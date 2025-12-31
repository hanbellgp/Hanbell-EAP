/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.FormInstance;
import cn.hanbell.oa.entity.OrganizationUnit;
import cn.hanbell.oa.entity.ParticipantActivityInstance;
import cn.hanbell.oa.entity.ProcessInstance;
import cn.hanbell.oa.entity.Users;
import cn.hanbell.oa.entity.WorkItem;
import cn.hanbell.util.BaseLib;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.DependsOn;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileOutputStream;
import org.apache.axis.client.Call;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONObject;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
@DependsOn({"UsersBean", "FunctionsBean", "TitleBean"})
public class WorkFlowBean extends SuperEJBForEFGP<FormInstance> implements Serializable {

    //public final String HOST_ADD = "http://oa.hanbell.com.cn";
    public final String HOST_ADD = "http://172.16.10.157";
    //正式环境
    //public final String FILE_URL = "smb://172.16.10.115/";
    //测试环境
    public final String FILE_URL = "smb://172.16.10.157/";
    public final String HOST_PORT = "8086";
    //文件存储的位置，允许读写的用户名密码，账号
    public final String OA_USERNO = "ECReader";
    public final String OA_PASSWORD = "HanbellP@ssw0rd";

    @EJB
    private ParticipantActivityInstanceBean participantActivityInstanceBean;
    @EJB
    private WorkAssignmentBean workAssignmentBean;
    @EJB
    private WorkItemBean workItemBean;

    public WorkFlowBean() {
        super(FormInstance.class);
    }

    public String buildXmlForEFGP(String formName, Object master, LinkedHashMap<String, List<?>> details, List<JSONObject> files, String userOid) {
        StringBuilder xmlBuilder = new StringBuilder();
        if (files == null || files.isEmpty()) {
            xmlBuilder.append("<").append(formName).append(">");
            buildXmlForEFGPMaster(xmlBuilder, formName, master);
            if (details != null && !details.isEmpty()) {
                for (Map.Entry<String, List<?>> e : details.entrySet()) {
                    xmlBuilder.append(buildXmlForEFGPDetails(e.getKey(), e.getValue()));
                }
            }
            xmlBuilder.append("</").append(formName).append(">");
            return xmlBuilder.toString();
        } else {
            xmlBuilder.append("<").append(formName).append(">");
            buildXmlForEFGPFile(xmlBuilder, files, userOid);
            buildXmlForEFGPMaster(xmlBuilder, formName, master);
            if (details != null && !details.isEmpty()) {
                for (Map.Entry<String, List<?>> e : details.entrySet()) {
                    xmlBuilder.append(buildXmlForEFGPDetails(e.getKey(), e.getValue()));
                }
            }
            xmlBuilder.append("</").append(formName).append(">");
            return xmlBuilder.toString();
            //  return null;
        }

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
        return xmlBuilder.toString().replace("&", "|");

    }

    protected void buildXmlForEFGPMaster(StringBuilder builder, String formName, Object master) throws RuntimeException {

        Field[] fields = master.getClass().getDeclaredFields();//不含继承自超类的属性
        for (Field f : fields) {
            try {
                f.setAccessible(true);
                if ("auditor".equals(f.getName()) || "securityOfficer".equals(f.getName()) || "sectionSupervisor".equals(f.getName())
                        || "departmentHead".equals(f.getName()) || "safetySectionChief".equals(f.getName()) || "signatory".equals(f.getName()) || (f.getName().equals("creator") || f.getName().equals("empl") || f.getName().equals("emply") || f.getName().equals("employee") || f.getName().endsWith("user") || f.getName().endsWith("userno") || f.getName().endsWith("User") || f.getName().endsWith("Userno")) && (!f.getName().startsWith("hdn"))) {
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
//                    builder.append("<").append(f.getName()).append("  id=\"").append(f.getName()).append("\"  dataType=\"").append(f.getType().getName()).append("\" perDataProId=\"\">");
//                    builder.append(f.get(master)==null?"":f.get(master)).append("</").append(f.getName()).append(">");
                    builder.append("<").append(f.getName()).append(" id=\"").append(f.getName()).append("\"").append(" txt=\"").append(f.get(master)).append("\" hdn=\"\" ")
                            .append(" dataType=\"").append(f.getType().getName()).append("\" perDataProId=\"\">");
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

    protected void buildXmlForEFGPFile(StringBuilder builder, List<JSONObject> files, String userOID) throws RuntimeException {

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
    }

    public String completeWorkItem(String host, String port, String psn, String definitionId, String userId, String comment) throws Exception {

        ProcessInstance pi = processInstanceBean.findBySerialNumber(psn);
        if (pi == null) {
            return "404$ProcessInstance不存在";
        }
        ParticipantActivityInstance pai = participantActivityInstanceBean.findByContextOIDAndDefinitionId(pi.getContextOID(), definitionId);
        if (pai == null) {
            return "404$ParticipantActivityInstance不存在";
        }
        WorkItem workItem = workItemBean.findByContainerOIDAndContextOID(pai.getOID(), pi.getContextOID());
        if (workItem == null) {
            return "404$WorkItem不存在";
        }
        if (workItem.getCurrentState() != 1) {
            return "200$WorkItem已处理";
        }
        return this.completeWorkItem(host, port, workItem.getOID(), userId, comment);

    }

    public String completeWorkItem(String host, String port, String workItemOID, String userId, String comment) throws Exception {
        currentUser = usersBean.findById(userId);
        if (currentUser == null) {
            log4j.error("用户" + userId + "不存在");
            return "404$用户不存在";
        }
        WorkItem workItem = workItemBean.findByOID(workItemOID);
        if (workItem == null) {
            return "404$WorkItem不存在";
        }
        if (workItem.getCurrentState() > 1) {
            return "200$WorkItem已处理";
        }
        Object[] params = null;
        try {
            // 建立一个WebServices调用连接
            Call call = BaseLib.getAXISCall(host, port, "/NaNaWeb/services/WorkflowService?wsdl");
            // 接受一个工作项目
//            call.setOperationName(new QName("WorkflowService", "acceptWorkItem"));
//            params = new Object[]{workItemOID, userId};
//            call.invoke(params);
            // 审批一个工作项目
            call.setOperationName(new QName("WorkflowService", "completeWorkItem"));
            params = new Object[]{workItemOID, userId, comment};
            call.invoke(params);
            return "200$success";
        } catch (ServiceException | RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
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
        try {
            return invokeProcess(host, port, processId, getCurrentUser().getId(), getUserFunction().getOrganizationUnit().getId(), formFieldValue, subject);
        } catch (Exception e) {
            throw new RuntimeException(subject);
        }

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
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            currentUser = null;
            userFunction = null;
        }
    }

    public String reserveNoCmDocument(String host, String port, String fileName) {
        Object[] params = null;
        Object object = null;
        String xml = null;
        try {
            //建立一个WebServices调用连接
            Call call = BaseLib.getAXISCall(host, port, "/NaNaWeb/services/WorkflowService?wsdl");
            //获取一个空的文件模板
            call.setOperationName(new QName("WorkflowService", "reserveNoCmDocument"));
            params = new Object[]{fileName};
            object = call.invoke(params);
            xml = object.toString();
            return xml;
        } catch (ServiceException | RemoteException e) {
            throw new RuntimeException(e);
        } finally {
            currentUser = null;
            userFunction = null;
        }
    }

    /**
     * OA文件写入172.16.10.157中的OA服务器
     *
     * @param user 服务器用户
     * @param passowrd 服务器密码
     * @param fileUrl OA附件的文件地址
     * @param imgData 文件BASE54位编号
     */
    public void getShareFileContent(String user, String passowrd, String fileUrl, String imgData) {
        OutputStream outputStream = null;
        try {
            NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication("", user, passowrd);
            SmbFile smbFile = new SmbFile(fileUrl, auth);
            smbFile.connect();
            outputStream = new SmbFileOutputStream(smbFile);
            byte[] b = Base64.decodeBase64(imgData);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }
            outputStream.write(b);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public long getFileSize(String user, String passowrd, String url) {
        try {
            NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication("", user, passowrd);
            SmbFile smbFile = new SmbFile(url, auth);
            if (smbFile.isFile()) {
                return smbFile.length();
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(WorkFlowBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SmbException ex) {
            Logger.getLogger(WorkFlowBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
