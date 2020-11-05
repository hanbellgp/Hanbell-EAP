/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.control;

import cn.hanbell.eap.ejb.MailNotificationBean;
import cn.hanbell.oa.ejb.D50Z0009D0Bean;
import cn.hanbell.oa.entity.D50Z0009D0;
import cn.hanbell.rpt.lazy.D50Z0009D0Model;
;
import cn.hanbell.rpt.web.SuperQueryBean;
import com.lightshell.comm.BaseLib;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author C2082
 */


@ManagedBean(
        name = "d50Z0009D0ManagedBean"
)
@ViewScoped
public class D50Z0009D0ManagedBean extends SuperQueryBean<D50Z0009D0> {

    @EJB
    private D50Z0009D0Bean d50Z0009D0Bean;
    @EJB
    private MailNotificationBean mailBean;
    private String supportfacno;
    private String applyfacno;
    public D50Z0009D0ManagedBean() {
        super(D50Z0009D0.class);
    }

    @Override
    public void init() {
        this.setSuperEJB(this.d50Z0009D0Bean);
        this.model = new D50Z0009D0Model(this.d50Z0009D0Bean);
         this.model.getFilterFields().clear();
            model.getFilterFields().put("processSerialNumber.currentState", 3);
        super.init();
    }

    @Override
    public void query() {
        if (this.model != null && this.model.getFilterFields() != null) {
            this.model.getFilterFields().clear();
            model.getFilterFields().put("processSerialNumber.currentState", 3);
            if (this.queryDateBegin != null && this.queryDateEnd != null) {
                model.getFilterFields().put("processSerialNumber.createdTimeBegin", this.queryDateBegin);
                model.getFilterFields().put("processSerialNumber.createdTimeEnd", this.queryDateEnd);
            }
            if (supportfacno != null && !"ALL".equals(supportfacno)) {
                model.getFilterFields().put("supportfacno", this.supportfacno);
            }
            if (applyfacno != null && !"ALL".equals(applyfacno)) {
                model.getFilterFields().put("applyfacno", this.applyfacno);
            }
        }
    }

    @Override
    public void reset() {
        this.setSuperEJB(this.d50Z0009D0Bean);
        this.model = new D50Z0009D0Model(this.d50Z0009D0Bean);
        this.queryDateBegin = null;
        this.queryDateEnd = null;
        this.supportfacno = "ALL";
        this.applyfacno = "ALL";
        query();
    }

    @Override
    public void print() {
        entityList = d50Z0009D0Bean.findByFilters(model.getFilterFields(), model.getSortFields());
        InputStream is = null;
        try {
            try {
                String finalFilePath = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
                //测试路径
//                int index = finalFilePath.indexOf("dist/gfdeploy");
                //正式路径
//                D:\Java\glassfish5\glassfish\domains\domain1\applications\Hanbell-EAP\Hanbell-RPT_war\rpt
//                D:\Java\glassfish5\glassfish\domains\domain1\applications\Hanbell-EAP\Hanbell-RPT_war\WEB-INF\classes\cn\hanbell\rpt\control
                int index = finalFilePath.indexOf("WEB-INF");
                String filePath = new String(finalFilePath.substring(1, index));
                String pathString = new String(filePath.concat("rpt/"));
                File file = new File(pathString, "集团支援单模板.xlsx");
                is = new FileInputStream(file);
                this.fileName = "D50Z0009D0" + BaseLib.formatDate("yyyyMMddHHmmss", BaseLib.getDate()) + ".xlsx";
                this.fileFullName = this.reportOutputPath + this.fileName;
                Workbook wb = WorkbookFactory.create(is);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
                Sheet sheet = wb.getSheetAt(1);
                wb.setSheetName(1, sdf.format(new Date()) + "集团工作支援单");
                Row row = null;
                int i = 3;
                for (Iterator var12 = this.entityList.iterator(); var12.hasNext(); ++i) {
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
                    os = new FileOutputStream(this.fileFullName);
                    wb.write(os);
                    this.reportViewPath = this.reportViewContext + this.fileName;
                    this.preview();
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
                this.log4j.error(var40.getMessage());
            } catch (IOException var41) {
                this.log4j.error(var41.getMessage());
            } catch (Exception var42) {
                this.log4j.error(var42.getMessage());
            }
        } finally {

        }
    }
    public HSSFCellStyle getColumnTopStyle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setFontHeightInPoints((short) 11);
        font.setBoldweight((short) 700);
        font.setFontName("Courier New");
        HSSFCellStyle style = workbook.createCellStyle();
        style.setBorderBottom((short) 1);
        style.setBottomBorderColor((short) 8);
        style.setBorderLeft((short) 1);
        style.setLeftBorderColor((short) 8);
        style.setBorderRight((short) 1);
        style.setRightBorderColor((short) 8);
        style.setBorderTop((short) 1);
        style.setTopBorderColor((short) 8);
        style.setFont(font);
        style.setWrapText(false);
        style.setAlignment((short) 2);
        style.setVerticalAlignment((short) 1);
        return style;
    }

    public String getSupportTypeValue(String supporttype) {
         if(supporttype==null||"".equals(supporttype)){
            return "";
        }
        String[] type = supporttype.split(",");
        StringBuffer value = new StringBuffer();
        for (int i = 0; i < type.length; i++) {
            switch (type[i]) {
                case "1":
                    value.append("客诉服务").append(",");
                    break;
                case "2":
                    value.append("收费服务").append(",");
                    break;
                case "3":
                    value.append("营业").append(",");
                    break;
                case "4":
                    value.append("其他").append(",");
                    break;
            }
        }
        return value.substring(0, value.length() - 1);
    }

    public String getPayValue(String pay) {
        if(pay==null||"".equals(pay)){
            return "";
        }
        String[] payList = pay.split(",");
        StringBuffer value = new StringBuffer();
        for (int i = 0; i < payList.length; i++) {
            switch (payList[i]) {
                case "1":
                    value.append("交通费(含机票)").append(",");
                    break;
                case "2":
                    value.append("出差津贴").append(",");
                    break;
                case "3":
                    value.append("薪资成本").append(",");
                    break;
                case "4":
                    value.append("膳食费").append(",");
                    break;
                case "5":
                    value.append("材料费").append(",");
                    break;
                case "6":
                    value.append("住宿费").append(",");
                    break;
                case "7":
                    value.append("邮电费").append(",");
                    break;
                case "8":
                    value.append("交际费").append(",");
                    break;
                case "9":
                    value.append("其他").append(",");
                    break;
            }
        }
        return value.substring(0, value.length() - 1);
    }

    public String getSupportfacno() {
        return supportfacno;
    }

    public void setSupportfacno(String supportfacno) {
        this.supportfacno = supportfacno;
    }

    public String getApplyfacno() {
        return applyfacno;
    }

    public void setApplyfacno(String applyfacno) {
        this.applyfacno = applyfacno;
    }

}
