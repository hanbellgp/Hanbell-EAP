/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.FormInstance;
import cn.hanbell.oa.entity.OrganizationUnit;
import cn.hanbell.oa.entity.Users;
import cn.hanbell.util.BaseLib;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import javax.ejb.DependsOn;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import org.json.JSONObject;

/**
 *
 * @author C2082
 */
@Stateless
@LocalBean
@DependsOn({"UsersBean", "FunctionsBean", "TitleBean"})
public class HKPB033WorkFlowBean extends SuperEJBForEFGP<FormInstance> implements Serializable {


    public HKPB033WorkFlowBean() {
        super(FormInstance.class);
    }

    public String buildXmlForEFGP(String formName, Object master, List<JSONObject> files, String userOID) {
        StringBuilder xmlBuilder = new StringBuilder();
        return xmlBuilder.append("<").append(formName).append(">").
                append(buildXmlForEFGPFile(formName, master, files, userOID)).
                append(buildXmlForEFGPMaster(formName, master)).append("</").append(formName).append(">").toString();
    }

    protected StringBuffer buildXmlForEFGPFile(String formName, Object master, List<JSONObject> files, String userOID) throws RuntimeException {
        StringBuffer builder = new StringBuffer();
        if (files != null && !files.isEmpty()) {
            builder.append("<Attachment id=\"Attachment\">");
            builder.append("<attachments>");
            for (JSONObject j : files) {
                System.out.println(j.toString());
                builder.append("<attachment");
                builder.append(" OID=\"").append(j.getJSONArray("OID").getString(0)).append("\"");
               
                builder.append(" fileSize=\"").append(j.getJSONArray("fileSize").getLong(0)).append("\"");
                builder.append(" id=\"").append(j.getJSONArray("id").getString(0)).append("\"");
                builder.append(" fileType=\"").append(j.getJSONArray("fileType").getString(0)).append("\"");
                builder.append(" name=\"").append(j.getJSONArray("name").getString(0)).append("\"");
                builder.append(" originalFileName=\"").append(j.getJSONArray("originalFileName").getString(0)).append("\"");
                builder.append(" uploadTime=\"").append(j.getJSONArray("uploadTime").getLong(0)).append("\"");
                builder.append(">");
                builder.append("<description></description>");
                builder.append("<permission>");
                builder.append("<user OID=\"").append(userOID).append("\"");
                builder.append(" restriction=\"1\">").append("</user>");
                builder.append("</permission>");
                builder.append("</attachment>");
            }
            builder.append("</attachments>");
            builder.append("</Attachment>");
        }

        return builder;
    }

    protected StringBuffer buildXmlForEFGPMaster(String formName, Object master) throws RuntimeException {
        StringBuffer builder = new StringBuffer();
        Field[] fields = master.getClass().getDeclaredFields();//不含继承自超类的属性
        for (Field f : fields) {
            try {
                f.setAccessible(true);
                if ("auditor".equals(f.getName()) || "securityOfficer".equals(f.getName()) || "sectionSupervisor".equals(f.getName())
                        || "departmentHead".equals(f.getName()) || "safetySectionChief".equals(f.getName()) || "signatory".equals(f.getName())) {
                    if (f.get(master) != null && !"".equals(f.get(master))) {
                        Users user = this.findUserByUserno(f.get(master).toString());
                        if (user == null) {
                            log4j.error(f.get(master).toString() + "用户不存在");
                            throw new RuntimeException();
                        }
                        builder.append("<").append(f.getName()).append("  id=\"").append(f.getName()).append("\" label=\"").append(user.getUserName()).append("\"");
                        builder.append("  hidden=\"").append(user.getOid()).append("\" list_hidden=\"\"");
                        builder.append("  dataType=\"").append(f.getType().getName()).append("\">").append(f.get(master)).append("</").append(f.getName()).append(">");
                    } else {
                        builder.append("<").append(f.getName()).append("  id=\"").append(f.getName()).append("\" label=\"\" hidden=\"\" list_hidden=\"\" dataType=\"").append(f.getType().getName()).append("\" />");
                    }
                } else if ((f.getName().equals("dept") || f.getName().equals("department") || f.getName().endsWith("dept") || f.getName().endsWith("deptno") || f.getName().endsWith("Dept") || f.getName().endsWith("Deptno") || f.getName().endsWith("depno")) && (!f.getName().startsWith("hdn"))) {
                    if (f.get(master) != null && !"".equals(f.get(master))) {
                        OrganizationUnit dept = this.findOrgUnitByDeptno(f.get(master).toString());
                        if (dept == null) {
                            log4j.error(f.get(master).toString() + "部门不存在");
                            throw new RuntimeException();
                        }
                        builder.append("<").append(f.getName()).append("  id=\"").append(f.getName()).append("\" label=\"").append(dept.getOrganizationUnitName()).append("\"");
                        builder.append("  hidden=\"").append(dept.getOid()).append("\" list_hidden=\"\"");
                        builder.append("  dataType=\"").append(f.getType().getName()).append("\">").append(f.get(master)).append("</").append(f.getName()).append(">");
                    } else {
                        builder.append("<").append(f.getName()).append("  id=\"").append(f.getName()).append("\" label=\"\" hidden=\"\" list_hidden=\"\" dataType=\"").append(f.getType().getName()).append("\" />");
                    }
                } else if (f.getType().getName().equals("java.util.Date")) {
                    if (f.get(master) != null && !"".equals(f.get(master))) {
                        builder.append("<").append(f.getName()).append("  id=\"").append(f.getName()).append("\" list_hidden=\"\" dataType=\"").append(f.getType().getName()).append("\" >");
                        builder.append(BaseLib.formatDate("yyyy/MM/dd", (Date) f.get(master))).append("</").append(f.getName()).append(">");
                    } else {
                        builder.append("<").append(f.getName()).append("  id=\"").append(f.getName()).append("\" list_hidden=\"\" dataType=\"").append(f.getType().getName()).append("\" />");
                    }
                } else {
                    builder.append("<").append(f.getName()).append("  id=\"").append(f.getName()).append("\"  dataType=\"").append(f.getType().getName()).append("\" perDataProId=\"\">");
                    builder.append(f.get(master)).append("</").append(f.getName()).append(">");
                }
            } catch (IllegalArgumentException | IllegalAccessException ex) {
                log4j.error(ex);
                throw new RuntimeException(ex);
            }
        }
        return builder;
    }
}
