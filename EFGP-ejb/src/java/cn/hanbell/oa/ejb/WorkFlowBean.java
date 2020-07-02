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
import java.rmi.RemoteException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.DependsOn;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.inject.Named;
import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import org.apache.axis.client.Call;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
@Named
@DependsOn({"UsersBean", "FunctionsBean", "TitleBean"})
public class WorkFlowBean extends SuperEJBForEFGP<FormInstance> implements Serializable {

    //public final String HOST_ADD = "http://oa.hanbell.com.cn";
    public final String HOST_ADD = "http://172.16.10.157";
    public final String HOST_PORT = "8086";

    public WorkFlowBean() {
        super(FormInstance.class);
    }

    public String buildXmlForEFGP(String formName, Object master, LinkedHashMap<String, List<?>> details) {

        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<").append(formName).append(">");
        buildXmlForEFGPMaster(xmlBuilder, formName, master);
        if (details != null && !details.isEmpty()) {
            for (Map.Entry<String, List<?>> e : details.entrySet()) {
                xmlBuilder.append(buildXmlForEFGPDetails(e.getKey(), e.getValue()));
            }
        }
        xmlBuilder.append("</").append(formName).append(">");
        return xmlBuilder.toString();

    }

    protected void buildXmlForEFGPMaster(StringBuilder builder, String formName, Object master) throws RuntimeException {

        Field[] fields = master.getClass().getDeclaredFields();//不含继承自超类的属性
        for (Field f : fields) {
            try {
                f.setAccessible(true);
                if ((f.getName().equals("creator") || f.getName().equals("empl") || f.getName().equals("emply") || f.getName().equals("employee") || f.getName().endsWith("user") || f.getName().endsWith("userno") || f.getName().endsWith("User") || f.getName().endsWith("Userno")) && (!f.getName().startsWith("hdn"))) {
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

    }

    protected String buildXmlForEFGPDetails(String detailName, List<?> detailList) {

        StringBuilder detailBuilder = new StringBuilder();
        detailBuilder.append("<").append(detailName).append(" id=\"").append(detailName).append("\"><records>");
        if (detailList != null && !detailList.isEmpty()) {
            int i = 0;
            for (Object detail : detailList) {
                buildEFGPDetail(detailBuilder, detailName, detail, i);
                i++;
            }
        }
        detailBuilder.append("</records></").append(detailName).append(">");
        return detailBuilder.toString();

    }

    protected void buildEFGPDetail(StringBuilder builder, String detailName, Object detail, int index) {

        Field[] fields = detail.getClass().getDeclaredFields();
        builder.append("<record  id = \"");
        builder.append(detailName).append("_");
        builder.append(index).append("\">");
        for (Field f : fields) {
            f.setAccessible(true);
            try {
                builder.append("<item id=\"").append(f.getName()).append("\"");
                builder.append(" dataType=\"").append(f.getType().getName()).append("\" perDataProId=\"\">").append(f.get(detail)).append("</item>");
            } catch (IllegalArgumentException | IllegalAccessException ex) {
                log4j.error(ex);
            }
        }
        builder.append("</record>");

    }

    public String findFormOIDsOfProcess(String processId) throws Exception {
        Object[] params = null;
        Object object = null;
        String formOID = null;
        try {
            //建立一个WebServices调用连接
            Call call = BaseLib.getAXISCall(this.HOST_ADD, this.HOST_PORT, "/NaNaWeb/services/WorkflowService?wsdl");
            call.setOperationName(new QName("WorkflowService", "findFormOIDsOfProcess"));
            //转入流程代号
            params = new Object[]{processId};
            //获取表单唯一代号
            object = call.invoke(params);
            formOID = object.toString();
            return formOID;
        } catch (ServiceException | RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public String getCompanyByDeptId(String deptId) {
        switch (deptId.substring(0, 2)) {
            case "1C":
                return "J";
            case "1D":
                return "G";
            case "1E":
                return "N";
            case "1V":
                return "C4";
            case "1R":
                return "W";
        }
        switch (deptId.substring(0, 1)) {
            case "1":
                return "C";
            case "2":
                return "H";
            case "3":
                return "V";
            case "4":
                return "Q";
            case "5":
                return "K";
            case "6":
                return "R";
            case "7":
                return "Y";
            case "8":
                return "E";
            case "9":
                return "L";
        }
        return "";
    }

    public String getCompanyName(String facno) {
        switch (facno) {
            case "C":
                return "上海汉钟";
            case "G":
                return "广州分公司";
            case "J":
                return "济南分公司";
            case "N":
                return "南京分公司";
            case "C4":
                return "重庆分公司";
            case "H":
                return "浙江汉声";
            case "Y":
                return "安徽汉扬";
            case "K":
                return "上海柯茂";
            case "E":
                return "浙江柯茂";
            case "Q":
                return "世纪东元";
            case "L":
                return "真空技术";
            case "X":
                return "香港汉钟";
            case "V":
                return "越南汉钟";
            case "R":
                return "韩国汉钟";
            case "W":
                return "顺德涡旋";
        }
        return "上海汉钟";
    }

    public String getFormFieldTemplate(String formOID) throws Exception {
        Object[] params = null;
        Object object = null;
        String formXml = null;
        try {
            //建立一个WebServices调用连接
            Call call = BaseLib.getAXISCall(this.HOST_ADD, this.HOST_PORT, "/NaNaWeb/services/WorkflowService?wsdl");
            call.setOperationName(new QName("WorkflowService", "getFormFieldTemplate"));
            //转入FormOID
            params = new Object[]{formOID};
            //获取表单XML格式
            object = call.invoke(params);
            formXml = object.toString();
            return formXml;
        } catch (ServiceException | RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public String invokeProcess(String host, String port, String processId, String formFieldValue, String subject) throws Exception {
        if ((getCurrentUser() == null) || (getUserFunction() == null)) {
            log4j.error("用户或部门不存在");
            return "401$用户或部门不存在";
        }
        return invokeProcess(host, port, processId, getCurrentUser().getId(), getUserFunction().getOrganizationUnit().getId(), formFieldValue, subject);
    }

    public String invokeProcess(String host, String port, String processId, String userId, String orgUnitId, String formFieldValue, String subject) throws Exception {

        currentUser = usersBean.findById(userId);
        if (getCurrentUser() == null) {
            log4j.error("用户" + userId + "不存在");
            return "401$用户不存在";
        }
        organizationUnit = organizationUnitBean.findById(orgUnitId);
        if (getOrganizationUnit() == null) {
            log4j.error("部门" + orgUnitId + "不存在");
            return "401$部门不存在";
        }

        Object[] params = null;
        Object object = null;

        String formOID = null;
        String serialNo = null;
        try {
            //建立一个WebServices调用连接
            Call call = BaseLib.getAXISCall(host, port, "/NaNaWeb/services/WorkflowService?wsdl");
            //查找表单FormOID，一个流程关联多个表单时，返回值用","分开
            call.setOperationName(new QName("WorkflowService", "findFormOIDsOfProcess"));
            //转入流程代号
            params = new Object[]{processId};
            //获取表单唯一代号
            object = call.invoke(params);
            formOID = object.toString();
            //发起一个流程
            call.setOperationName(new QName("WorkflowService", "invokeProcess"));
            params = new Object[]{processId, userId, orgUnitId, formOID, formFieldValue, subject};
            object = call.invoke(params);
            serialNo = object.toString();
            return "200$" + serialNo;
        } catch (ServiceException | RemoteException e) {
            throw new RuntimeException(e);
        } finally {
            currentUser = null;
            userFunction = null;
        }

    }

}
