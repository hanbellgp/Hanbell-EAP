/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.control;

import cn.hanbell.oa.ejb.FunctionsBean;
import cn.hanbell.oa.ejb.HKYX011Bean;
import cn.hanbell.oa.ejb.OrganizationUnitBean;
import cn.hanbell.oa.entity.Functions;
import cn.hanbell.oa.entity.HKYX011;
import cn.hanbell.oa.entity.OrganizationUnit;
import cn.hanbell.rpt.lazy.HKYX011Model;
import cn.hanbell.rpt.web.SuperQueryBean;
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
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author C2082
 */
@ManagedBean(name = "hkyx011ManagedBean")
@javax.faces.bean.ViewScoped
public class HKYX011ManagedBean extends SuperQueryBean<HKYX011> {

    @EJB
    private HKYX011Bean hkyx001Bean;
    @EJB
    private OrganizationUnitBean organizationunitBean;
    @EJB
    private FunctionsBean functionsBean;

    public HKYX011ManagedBean() {
        super(HKYX011.class);
    }

    private String queryCustomerNo;
    private String queryCustomerName;
    private String queryDeptno;
    private String queryDept;
    private List<Object[]> list;

    @Override
    public void reset() {
        queryCustomerNo = "";
        queryCustomerName = "";
        queryDeptno = "";
        queryDept = "";
        this.queryDateEnd = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.queryDateEnd);
        cal.add(Calendar.YEAR, -1);
        this.queryDateBegin = cal.getTime();
        query();
    }

    @Override
    public void query() {
        if (this.model != null && this.model.getFilterFields() != null) {
            this.model.getFilterFields().clear();
            if (queryCustomerNo != null && !"".equals(queryCustomerNo)) {
                this.model.getFilterFields().put("customerno", queryCustomerNo);
            }
            if (queryCustomerName != null && !"".equals(queryCustomerName)) {
                this.model.getFilterFields().put("customername", queryCustomerName);
            }
            if (queryDateBegin != null && !"".equals(queryDateBegin)) {
                this.model.getFilterFields().put("applyDateBegin", queryDateBegin);
            }
            if (queryDateEnd != null && !"".equals(queryDateEnd)) {
                this.model.getFilterFields().put("applyDateEnd", queryDateEnd);
            }
        }
        maginDeptName();

    }

    @Override
    public void print() {
        InputStream is = null;
        try {
            try {
                String finalFilePath = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
                int index = finalFilePath.indexOf("WEB-INF");
                String filePath = new String(finalFilePath.substring(1, index));
                String pathString = new String(filePath.concat("rpt/"));
                File file = new File(pathString, "实际销售折让统计表模板.xls");
                is = new FileInputStream(file);
                this.fileName = "HKYW011" + BaseLib.formatDate("yyyyMMddHHmmss", BaseLib.getDate()) + ".xls";
                this.fileFullName = this.reportOutputPath + this.fileName;
                Workbook wb = WorkbookFactory.create(is);
                CellStyle cellStyle = wb.createCellStyle();
                short border = 1;
                cellStyle.setBorderBottom(border);
                cellStyle.setBorderLeft(border);
                cellStyle.setBorderRight(border);
                cellStyle.setBorderTop(border);
                cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
                Sheet sheet = wb.getSheetAt(0);
                wb.setSheetName(0, BaseLib.formatDate("yyyy-MM-dd", queryDateBegin) + "~" + BaseLib.formatDate("yyyy-MM-dd", queryDateEnd) + "实际销售折让统计表");
                Row row = null;
                int i = 2;
                Double count1 = 0.0;
                Double count2 = 0.0;
                Double count3 = 0.0;
                for (Object[] o : list) {
                    row = sheet.createRow(i);
                    Cell cell = row.createCell(0);
                    cell.setCellValue("汉钟");
                    Cell cell1 = row.createCell(1);
                    Cell cell2 = row.createCell(2);
                    Cell cell3 = row.createCell(3);
                    Cell cell4 = row.createCell(4);
                    Cell cell5 = row.createCell(5);
                    Cell cell6 = row.createCell(6);
                    Cell cell7 = row.createCell(7);
                    Cell cell8 = row.createCell(8);
                    Cell cell9 = row.createCell(9);
                    Cell cell10 = row.createCell(10);
                    Cell cell11 = row.createCell(11);
                    cell.setCellStyle(cellStyle);
                    cell1.setCellStyle(cellStyle);
                    cell2.setCellStyle(cellStyle);
                    cell3.setCellStyle(cellStyle);
                    cell4.setCellStyle(cellStyle);
                    cell5.setCellStyle(cellStyle);
                    cell6.setCellStyle(cellStyle);
                    cell7.setCellStyle(cellStyle);
                    cell8.setCellStyle(cellStyle);
                    cell9.setCellStyle(cellStyle);
                    cell10.setCellStyle(cellStyle);
                    cell11.setCellStyle(cellStyle);
                    cell1.setCellValue(o[0] != null ? BaseLib.formatDate("yyyy/MM/dd", (Date) o[0]) : "");
                    cell2.setCellValue(o[1] != null ? (String) o[1] : "");
                    cell3.setCellValue(o[2] != null ? (String) o[2] : "");
                    cell4.setCellValue(o[3] != null ? (String) o[3] : "");
                    cell5.setCellValue(o[4] != null ? (String) o[4] : "");
                    cell6.setCellValue(o[5] != null ? (Double) o[5] : 0.0);
                    cell7.setCellValue(o[6] != null ? (Double) o[6] : 0.0);
                    cell8.setCellValue(o[7] != null ? (Double) o[7] : 0.0);
                    cell9.setCellValue(o[8] != null ? (Double) o[8] : 0.0);
                    cell10.setCellValue(o[9] != null ? (String) o[9] : "");
                    cell11.setCellValue(o[10] != null ? (String) o[10] : "");
                    count1 = count1 + (Double) o[5];
                    count2 = count2 + (Double) o[6];
                    count3 = count3 + (Double) o[7];
                    i++;
                }
                for (int m = i; m <= i + 1; m++) {
                    row = sheet.createRow(m);
                    Cell cell = row.createCell(0);
                    Cell cell1 = row.createCell(1);
                    Cell cell2 = row.createCell(2);
                    Cell cell3 = row.createCell(3);
                    Cell cell4 = row.createCell(4);
                    Cell cell5 = row.createCell(5);
                    Cell cell6 = row.createCell(6);
                    Cell cell7 = row.createCell(7);
                    Cell cell8 = row.createCell(8);
                    Cell cell9 = row.createCell(9);
                    Cell cell10 = row.createCell(10);
                    Cell cell11 = row.createCell(11);
                    cell.setCellStyle(cellStyle);
                    cell1.setCellStyle(cellStyle);
                    cell2.setCellStyle(cellStyle);
                    cell3.setCellStyle(cellStyle);
                    cell4.setCellStyle(cellStyle);
                    cell5.setCellStyle(cellStyle);
                    cell6.setCellStyle(cellStyle);
                    cell7.setCellStyle(cellStyle);
                    cell8.setCellStyle(cellStyle);
                    cell9.setCellStyle(cellStyle);
                    cell10.setCellStyle(cellStyle);
                    cell11.setCellStyle(cellStyle);
                    if (m == i + 1) {
                        cell.setCellValue("合计");
                        CellRangeAddress region = new CellRangeAddress(m, m, 0, 5);
                        sheet.addMergedRegion(region);
                        cellStyle.setFillForegroundColor(IndexedColors.AUTOMATIC.getIndex());
                        //设置合计行灰色背景
                        CellStyle style = wb.createCellStyle();
                        style.setBorderBottom(border);
                        style.setBorderLeft(border);
                        style.setBorderRight(border);
                        style.setBorderTop(border);
                        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                        style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
                        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
                        cell.setCellStyle(style);
                        cell.setCellStyle(style);
                        cell1.setCellStyle(style);
                        cell2.setCellStyle(style);
                        cell3.setCellStyle(style);
                        cell4.setCellStyle(style);
                        cell5.setCellStyle(style);
                        cell6.setCellStyle(style);
                        cell7.setCellStyle(style);
                        cell8.setCellStyle(style);
                        cell9.setCellStyle(style);
                        cell10.setCellStyle(style);
                        cell11.setCellStyle(style);
                        cell6.setCellValue(count1);
                        cell7.setCellValue(count2);
                        cell8.setCellValue(count3);
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
                var40.printStackTrace();
            } catch (IOException var41) {
                this.log4j.error(var41.getMessage());
                var41.printStackTrace();
            } catch (Exception var42) {
                var42.printStackTrace();
                this.log4j.error(var42.getMessage());
            }
        } finally {

        }
    }

    @Override
    public void init() {
        list = new ArrayList<>();
        setSuperEJB(hkyx001Bean);
        this.model = new HKYX011Model(this.hkyx001Bean);
        this.model.getFilterFields().clear();
        this.queryDateEnd = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.queryDateEnd);
        cal.add(Calendar.YEAR, -1);
        this.queryDateBegin = cal.getTime();
        query();
        super.init();
    }

    public String getQueryCustomerNo() {
        return queryCustomerNo;
    }

    public void setQueryCustomerNo(String queryCustomerNo) {
        this.queryCustomerNo = queryCustomerNo;
    }

    public String getQueryCustomerName() {
        return queryCustomerName;
    }

    public void setQueryCustomerName(String queryCustomerName) {
        this.queryCustomerName = queryCustomerName;
    }

    public String getQueryDeptno() {
        return queryDeptno;
    }

    public void setQueryDeptno(String queryDeptno) {
        this.queryDeptno = queryDeptno;
    }

    public String getQueryDept() {
        return queryDept;
    }

    public void setQueryDept(String queryDept) {
        this.queryDept = queryDept;
    }

    public List<Object[]> getList() {
        return list;
    }

    public void setList(List<Object[]> list) {
        this.list = list;
    }

    public void maginDeptName() {
        entityList = hkyx001Bean.findByFilters(model.getFilterFields(), model.getSortFields());
        list.clear();
        int i = 0;
        for (Iterator var12 = this.entityList.iterator(); var12.hasNext(); ++i) {
            HKYX011 entity = (HKYX011) var12.next();
            Functions f = functionsBean.findByOccupantOIDAndisMain(entity.getUser().getOid(), true);
            if (f != null && entity.getProcessInstance().getCurrentState() == 3) {
                OrganizationUnit org = f.getOrganizationUnit();
                entity.setDeptno(org.getId());
                entity.setDeptname(org.getOrganizationUnitName());
                Object[] o = {entity.getApplyDate(), entity.getCustomerno(),
                    entity.getCustomername(), org.getId(),
                    org.getOrganizationUnitName(), entity.getDiscountTotal(),
                    entity.getNumbertotal(), entity.getSaleamountTotal(), entity.getRatetotal(), entity.getRemark(), entity.getPeriod()};
                list.add(o);
            }

        }
    }
}
