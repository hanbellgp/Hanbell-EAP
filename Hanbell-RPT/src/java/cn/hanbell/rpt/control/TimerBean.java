/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.control;

import cn.hanbell.eap.comm.MailNotify;
import cn.hanbell.eap.ejb.MailNotificationBean;
import cn.hanbell.oa.ejb.D50Z0009D0Bean;
import cn.hanbell.oa.entity.D50Z0009D0;
import cn.hanbell.rpt.lazy.D50Z0009D0Model;
import com.lightshell.comm.BaseLib;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TimerService;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author C2082
 */
@Singleton
@Startup
public class TimerBean {

    protected final Logger log4j = LogManager.getLogger("cn.hanbell.eap");
    @EJB
    private MailNotificationBean mailBean;
    @EJB
    private D50Z0009D0Bean d50Z0009D0Bean;

    /**
     * 集团工作支援单发送邮件到各个主管
     */
    @Schedule(minute = "00", hour = "08",dayOfMonth="1", persistent = false)
    public void sendMail() {
        String fileFullName = madeMail();
        if (fileFullName == null || "".equals(fileFullName)) {
            return;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MONTH, -1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        String dateString = sdf.format(cal.getTime());
        try {
            mailBean.getTo().clear();
            mailBean.getTo().add("kimsu@hanbell.com");
            mailBean.getCc().clear();
            mailBean.getCc().add("rainingsss@hanbell.cn");//庄玉梅
            mailBean.getCc().add("shenxian@hanbell.cn");//沈贤
            mailBean.getCc().add("zhujuhong@hanbell.cn");//朱菊红
            mailBean.getCc().add("vivianlee@hanbell.cn");//李娜
            mailBean.getCc().add("wangyunfei@hanbell.cn");//汪云绯
            mailBean.getCc().add("guliping@hanbell.cn");//顾经理
            mailBean.getCc().add("yuanfang@hanbell.cn");//袁课
            mailBean.getCc().add("menglun@hanbell.com");//温孟伦
            mailBean.getCc().add("jackruan@hanbell.cn");//阮仁杰
            mailBean.getCc().add("pingkuang.tsai@hanbell.com");//蔡秉光
            mailBean.getCc().add("zhoujianfang@hanbell.cn");//周建芳
            mailBean.getCc().add("zhangxiaohong@hanbell.cn");//张小红
            mailBean.getCc().add("liyongjuan@hanbell.cn");//李课
            mailBean.getCc().add("alex@zj-hanson.com");//胡轶峰
            mailBean.getCc().add("H0968@zj-hanson.com ");//吴美霞
            mailBean.getCc().add("gexia@zj-hanson.com");//戈课
            mailBean.setMailSubject(dateString + "集团工作支援单报表");
            mailBean.setMailContent("附件为" + dateString + "集团工作支援单报表，请查收！");
            File file = new File(fileFullName);
            mailBean.getAttachments().clear();
            mailBean.addAttachments(file);
            mailBean.notify(new MailNotify());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String madeMail() {
        D50Z0009D0Model model = new D50Z0009D0Model(d50Z0009D0Bean);
        model.getFilterFields().clear();
        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(Calendar.MONTH, -1);
        calendar1.set(Calendar.DAY_OF_MONTH, 1);
        calendar1.set(Calendar.HOUR_OF_DAY, 0);
        calendar1.set(Calendar.MINUTE, 0);
        calendar1.set(Calendar.SECOND, 0);
        calendar1.set(Calendar.MILLISECOND, 0);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(Calendar.MONTH, -1);
        calendar2.set(Calendar.DAY_OF_MONTH, calendar2.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar2.set(Calendar.HOUR_OF_DAY, 23);
        calendar2.set(Calendar.MINUTE, 59);
        calendar2.set(Calendar.SECOND, 59);
        calendar2.set(Calendar.MILLISECOND, 999);
        model.getFilterFields().put("processSerialNumber.createdTimeBegin", calendar1.getTime());
        model.getFilterFields().put("processSerialNumber.createdTimeEnd", calendar2.getTime());
        model.getFilterFields().put("processSerialNumber.currentState", 3);
        List<D50Z0009D0> entityList = d50Z0009D0Bean.findByFilters(model.getFilterFields(), model.getSortFields());
        if (entityList.size() == 0 || entityList.isEmpty()) {
            return "";
        }
        InputStream is = null;
        try {
            try {
               String finalFilePath = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
                int index = finalFilePath.indexOf("WEB-INF");
                String filePath = new String(finalFilePath.substring(1, index));
                String pathString = new String(filePath.concat("rpt/"));
                File file = new File(pathString, "集团支援单模板.xlsx");
                is = new FileInputStream(file);
                String fileName = "D50Z0009D0" + BaseLib.formatDate("yyyyMMddHHmmss", BaseLib.getDate()) + ".xlsx";
                String fileFullName =pathString+"output/" + fileName;
                Workbook wb = WorkbookFactory.create(is);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
                Sheet sheet = wb.getSheetAt(1);
                wb.setSheetName(1, sdf.format(new Date()) + "集团工作支援单");
                Row row = null;
                int i = 3;
                for (Iterator var12 = entityList.iterator(); var12.hasNext(); ++i) {
                    D50Z0009D0 e = (D50Z0009D0) var12.next();
                    row = sheet.createRow(i);
                    Cell cell = row.createCell(0);
                    cell.setCellValue((double) (i - 2));
                    row.createCell(1).setCellValue(e.getFormSerialNumber() != null ? e.getFormSerialNumber() : "");
                    row.createCell(2).setCellValue(e.getStartout() != null ? BaseLib.formatDate("MM", e.getEndout()) : "");
                    row.createCell(3).setCellValue(e.getApplyfacno() != null ? e.getComapntName(e.getApplyfacno()) : "");
                    row.createCell(4).setCellValue(e.getSupportfacno() != null ? e.getComapntName(e.getSupportfacno()) : "");
                    row.createCell(5).setCellValue(e.getSupportDept().getOrganizationUnitName() != null ? e.getSupportDept().getOrganizationUnitName() : "");
                    row.createCell(6).setCellValue(e.getSupportUser().getUserName() != null ? e.getSupportUser().getUserName() : "");
                    row.createCell(8).setCellValue(e.getApplyDept().getOrganizationUnitName() != null ? e.getApplyDept().getOrganizationUnitName() : "");
                    row.createCell(9).setCellValue(e.getApplyUser().getUserName() != null ? e.getApplyUser().getUserName() : "");
                    row.createCell(10).setCellValue(e.getProcessSerialNumber().getCreatedTime() != null ? BaseLib.formatDate("MM/dd", e.getProcessSerialNumber().getCreatedTime()) : "");
                    if (e.getStartout() != null && e.getEndout() != null) {
                        String startoutString = e.getStartout() != null ? BaseLib.formatDate("MM/dd", e.getStartout()) : "";
                        String endoutString = e.getEndout() != null ? BaseLib.formatDate("MM/dd", e.getEndout()) : "";
                        row.createCell(11).setCellValue(startoutString.concat("-").concat(endoutString));
                        startoutString = null;
                        endoutString = null;
                    }
                    row.createCell(12).setCellValue(e.getTotaldays() != null ? e.getTotaldays() : "");
                    row.createCell(13).setCellValue(e.getApplyreason() != null ? e.getApplyreason() : "");
                    row.createCell(14).setCellValue(e.getApplypay() != null && e.getApplypay().contains("1") ? "√" : "");
                    row.createCell(15).setCellValue(e.getApplypay() != null && e.getApplypay().contains("2") ? "√" : "");
                    row.createCell(16).setCellValue(e.getApplypay() != null && e.getApplypay().contains("3") ? "√" : "");
                    row.createCell(17).setCellValue(e.getApplypay() != null && e.getApplypay().contains("4") ? "√" : "");
                    row.createCell(18).setCellValue(e.getApplypay() != null && e.getApplypay().contains("6") ? "√" : "");
                    row.createCell(19).setCellValue(e.getApplypay() != null && e.getApplypay().contains("9") ? "√" : "");
                    row.createCell(20).setCellValue(e.getOtherpay1() != null ? e.getOtherpay1() : "");
                    if (e.getApplyfactory() != null && !"".equals(e.getApplyfactory())) {
                        row.createCell(21).setCellValue(e.getApplyfactory() != null ? e.getApplyfactory().concat("%") : "");
                    }
                }
                FileOutputStream os = null;
                try {
                    os = new FileOutputStream(fileFullName);
                    wb.write(os);
                    return fileFullName;
                } catch (Exception var38) {
                    this.log4j.error(var38);
                } finally {
                    try {
                        if (null != os) {
                            os.flush();
                            os.close();
                        }
                    } catch (IOException var37) {
                        this.log4j.error(var37.getMessage());
                    }
                }
            } catch (FileNotFoundException var40) {
                var40.printStackTrace();
                this.log4j.error(var40.getMessage());
            } catch (IOException var41) {
                var41.printStackTrace();
                this.log4j.error(var41.getMessage());
            } catch (Exception var42) {
                var42.printStackTrace();
                this.log4j.error(var42.getMessage());
            }
        } finally {

        }
        return "";
    }
}
