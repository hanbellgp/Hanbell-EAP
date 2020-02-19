/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.control;

import cn.hanbell.oa.ejb.D50Z0009D0Bean;
import cn.hanbell.oa.ejb.WorkFlowBean;
import cn.hanbell.oa.ejb.WorkItemBean;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
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
import org.jboss.logging.Logger;

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

    public D50Z0009D0ManagedBean() {
        super(D50Z0009D0.class);
    }

    @Override
    public void init() {
        this.setSuperEJB(this.d50Z0009D0Bean);
        this.model = new D50Z0009D0Model(this.d50Z0009D0Bean);
        super.init();
    }

    @Override
    public void query() {
        if (this.model != null && this.model.getFilterFields() != null) {
            this.model.getFilterFields().clear();
            System.err.println("");
            if (this.queryDateBegin != null && this.queryDateEnd != null) {
                model.getFilterFields().put("processSerialNumber.createdTimeBegin", this.queryDateBegin);
                model.getFilterFields().put("processSerialNumber.createdTimeEnd", this.queryDateEnd);
            }
        }
    }

    @Override
    public void reset() {
        this.setSuperEJB(this.d50Z0009D0Bean);
        this.model = new D50Z0009D0Model(this.d50Z0009D0Bean);
        this.queryDateBegin = null;
        this.queryDateEnd = null;
        super.reset();
    }

    @Override
    public void print() {
        this.entityList = d50Z0009D0Bean.findByFilters(model.getFilterFields(), model.getSortFields());
        InputStream is = null;
        try {
            try {
                String finalFilePath = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
                System.out.print("finallypath" + finalFilePath);
                int index = finalFilePath.indexOf("dist/gfdeploy");
                System.out.println("index" + index);
                String filePath = new String(finalFilePath.substring(1, index));
//                String pathString = filePath+"Hanbell-RPI/web/rpt/集团支援单.xlsx";
                String pathString = new String(filePath.concat("Hanbell-RPT/web/rpt/"));
                System.out.println("path" + pathString);
                String path = pathString.replaceAll("/", "\\\\\\\\");
                System.out.println("path=" + path);
                File file = new File(pathString, "集团支援单.xlsx");
                System.out.println("file=" + file);
                is = new FileInputStream(file);
                this.fileName = "D50Z0009D0" + BaseLib.formatDate("yyyyMMddHHmmss", BaseLib.getDate()) + ".xlsx";
                this.fileFullName = this.reportOutputPath + this.fileName;
                Workbook wb = WorkbookFactory.create(is);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
                Sheet sheet = wb.getSheetAt(1);
                wb.setSheetName(1, sdf.format(new Date()) + "集团工作支援单");
                Row row = null;
                int i = 3;
                System.out.print("this.entityList" + this.entityList);
                for (Iterator var12 = this.entityList.iterator(); var12.hasNext(); ++i) {
                    D50Z0009D0 e = (D50Z0009D0) var12.next();
                    row = sheet.createRow(i);
                    Cell cell = row.createCell(0);
                    cell.setCellValue((double) (i - 2));
                    row.createCell(1).setCellValue(e.getFormSerialNumber() != null ? e.getFormSerialNumber() : "");
                    row.createCell(2).setCellValue(e.getStartout() != null ? BaseLib.formatDate("MM", e.getEndout()) : "");
                    row.createCell(3).setCellValue(e.getApplyfacno() != null ? e.getApplyfacno() : "");
                    row.createCell(4).setCellValue(e.getSupportfacno() != null ? e.getSupportfacno() : "");
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
                    if (e.getApplyfactory() != null && !"".equals(e.getApplyfactory())) {
                        row.createCell(20).setCellValue(e.getApplyfactory() != null ? e.getApplyfactory().concat("%") : "");
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
                System.out.println("is=" + is);
                System.err.println("异常是" + var40);
            } catch (IOException var41) {
                System.out.println("2");
            } catch (Exception var42) {
//                Logger.getLogger(D50Z0009D0ManagedBean.class.getName()).log(Level.SEVERE, (String)null, var42);
                System.out.println("cn.hanbell.rpt.control.D50Z0009D0ManagedBean.print()" + var42);
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
}
