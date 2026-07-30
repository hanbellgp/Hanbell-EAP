/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.jrs;

//import cn.hanbell.crm.ejb.CMSMEBean;
import cn.hanbell.oa.app.OvertimeApplication;
import cn.hanbell.jrs.ResponseMessage;
import cn.hanbell.jrs.SuperRESTForEFGP;
import cn.hanbell.oa.app.MCHKGL034;
import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.ejb.HKGL034Bean;
import cn.hanbell.oa.entity.HKGL034;
import cn.hanbell.oa.model.HKGL034DetailModel;
import cn.hanbell.oa.model.HKGL034Model;
import cn.hanbell.oa.app.OvertimeApplicationDetail;
import cn.hanbell.oa.entity.OrganizationUnit;
import cn.hanbell.util.BaseLib;
import cn.hanbell.wco.ejb.Agent1000002Bean;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.EJB;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author C0160
 */
@Path("efgp/hkgl034")
@javax.enterprise.context.RequestScoped
public class HKGL034FacadeREST extends SuperRESTForEFGP<HKGL034> {

    @EJB
    private HKGL034Bean hkgl034Bean;

    @EJB
    private Agent1000002Bean agent1000002Bean;

    @Override
    protected SuperEJBForEFGP getSuperEJB() {
        return hkgl034Bean;
    }

    public HKGL034FacadeREST() {
        super(HKGL034.class);
    }

    @POST
    @Path("wechat")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage create(OvertimeApplication entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            if (entity == null || entity.getDetailList() == null || entity.getDetailList().isEmpty()) {
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
            HKGL034Model m;
            HKGL034DetailModel d;
            List<HKGL034DetailModel> detailList = new ArrayList<>();
            LinkedHashMap<String, List<?>> details = new LinkedHashMap<>();
            details.put("Detail", detailList);
            try {
                workFlowBean.initUserInfo(entity.getEmployee());
                m = new HKGL034Model();
                m.setApplyDate(BaseLib.getDate());
                m.setApplyUser(workFlowBean.getCurrentUser().getId());
                m.setHdn_applyUser(workFlowBean.getCurrentUser().getUserName());
                m.setApplyDept(workFlowBean.getUserFunction().getOrganizationUnit().getId());
                m.setHdn_applyDept(workFlowBean.getUserFunction().getOrganizationUnit().getOrganizationUnitName());
                m.setType(entity.getFormType());
                m.setHdn_type(entity.getFormTypeDesc());
                m.setIsWechat("Y");
                //根据部门设置公司
                m.setFacno(workFlowBean.getCompanyByDeptId(m.getApplyDept()));
                m.setHdn_facno(m.getFacno());
                m.setOverdue(entity.getOverdue());
                for (OvertimeApplicationDetail oad : entity.getDetailList()) {
                    
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Calendar.HOUR_OF_DAY, 0); // 设置小时为0，即午夜12点
                    calendar.set(Calendar.MINUTE, 0); // 设置分钟为0
                    calendar.set(Calendar.SECOND, 0); // 设置秒为0
                    calendar.set(Calendar.MILLISECOND, 0); // 设置毫秒为0
                    calendar.add(Calendar.DATE, -7);
                    Date oneWeekDate = calendar.getTime();
                    calendar.add(Calendar.DATE, 5);
                    Date oneDayDate = calendar.getTime();
                    Date startDate = BaseLib.getDate("yyyy-MM-dd", oad.getDate1());

                    if (startDate.getTime() < oneWeekDate.getTime()) {
                        return new ResponseMessage("500", "加班起始日已经超过7天，无法申请。");
                    }
                    if (startDate.getTime() <= oneDayDate.getTime() && !"Y".equals(entity.getOverdue())) {
                        return new ResponseMessage("500", "加班日起始日已超过2天,[是否逾期]选是");
                    }

                    d = new HKGL034DetailModel();
                    d.setSeq(oad.getSeq());
                    d.setDept_txt(oad.getDeptName().split("-")[1]);
                    d.setDept_lbl(oad.getDeptId());
                    d.setEmployee(oad.getEmployeeId());
                    d.setEmployeeName(oad.getEmployeeName().split("-")[1]);
                    Pattern p = Pattern.compile("\\s*|\t|\r|\n");
                    Matcher matcher = p.matcher(oad.getContent());
                    String finishedReplaceStr = matcher.replaceAll("");
                    d.setContent(finishedReplaceStr);
                    d.setDate1_txt(oad.getDate1());
                    d.setTime1_txt(oad.getTime1());
                    d.setTime2_txt(oad.getTime2());
                    d.setHour(oad.getHour());
                    if (oad.getLunch()) {
                        d.setHdn_lunch("用餐");
                    } else {
                        d.setHdn_lunch("不用餐");
                    }
                    if (oad.getDinner()) {
                        d.setHdn_dinner("用餐");
                    } else {
                        d.setHdn_dinner("不用餐");
                    }
                    detailList.add(d);
                }
                String formInstance = workFlowBean.buildXmlForEFGP("HK_GL034", m, details);
                String subject = entity.getEmployee() + "加班申请";
                String msg = workFlowBean.invokeProcess(workFlowBean.HOST_ADD, workFlowBean.HOST_PORT, "PKG_HK_GL034", formInstance, subject);
                String[] rm = msg.split("\\$");
                if (rm.length == 2) {
                    boolean isSuccess = true;
                    StringBuffer users = new StringBuffer();
                    for (OvertimeApplicationDetail oad : entity.getDetailList()) {
                        agent1000002Bean.initConfiguration();
                        String errmsg = agent1000002Bean.sendMsgToUser(oad.getEmployeeId(), "text", "[汉钟精机] 您申请的" + oad.getDate1() + "加班单已完成填单");
                        if ("ok".equals(errmsg)) {
                            isSuccess = false;
                            users.append(oad.getEmployeeName()).append(",");
                        }
                    }
                    return new ResponseMessage(rm[0], rm[1]);

                } else {
                    return new ResponseMessage("500", "提交失败");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                return new ResponseMessage("500", "资料填写有误，核对后请联系管理员");
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    
//    @POST
//    @Path("uploadFile")
//    @Consumes(MediaType.MULTIPART_FORM_DATA)
//    public String UploadFile( InputStream fileInputStream) {
//        String fileName = "xxx.jpg";
//        String filePath = "D:\\" + System.currentTimeMillis() + "_" + fileName;
//        saveFile(fileInputStream, filePath);
//        return "";
//    }
//
//    
//    @POST
//    @Path("uploadFile2")
//    @Consumes(MediaType.MULTIPART_FORM_DATA)
//    public String UploadFile2(@Context HttpServletRequest request) {
//        if (!ServletFileUpload.isMultipartContent(request)) {
//            return "";
//        }
//        DiskFileItemFactory factory = new DiskFileItemFactory();
//        ServletFileUpload upload = new ServletFileUpload(factory);
//
//        try {
//            // 解析请求的内容提取文件数据
//            List<FileItem> formItems = upload.parseRequest(request);
//
//            if (formItems != null && formItems.size() > 0) {
//                // 迭代表单数据
//                for (FileItem item : formItems) {
//                    // 处理不在表单中的字段
//                    if (!item.isFormField()) {
//                        String fileName = new File(item.getName()).getName();
//                        String filePath = "D:/" + fileName; // 指定文件保存路径
//                        File storeFile = new File(filePath);
//                        // 在控制台输出文件的上传路径
//                        item.write(storeFile); // 保存文件到硬盘
//                    }
//                }
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return "";
//    }
//    
//    
//    private void saveFile(InputStream inputStream, String filePath) {
//        File targetFile = new File(filePath);
//        targetFile.getParentFile().mkdirs();
//
//        try (FileOutputStream outputStream = new FileOutputStream(targetFile)) {
//            byte[] buffer = new byte[8192];
//            int bytesRead;
//            while ((bytesRead = inputStream.read(buffer)) != -1) {
//                outputStream.write(buffer, 0, bytesRead);
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }
}
