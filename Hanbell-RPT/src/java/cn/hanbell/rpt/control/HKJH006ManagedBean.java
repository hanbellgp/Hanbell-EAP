/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.control;

import cn.hanbell.oa.ejb.HKJH006Bean;
import cn.hanbell.oa.entity.HKJH006;
import cn.hanbell.rpt.web.SuperQueryBean;
import com.lightshell.comm.BaseLib;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author C2082
 */
@ManagedBean(name = "hkjh006ManagedBean")
@javax.faces.bean.ViewScoped
public class HKJH006ManagedBean extends SuperQueryBean<HKJH006> {

    @EJB
    private HKJH006Bean hkjh006Bean;

    public HKJH006ManagedBean() {
        super(HKJH006.class);
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
        list = hkjh006Bean.findByCustomerAndApplyDate(BaseLib.formatDate("yyyy-MM-dd HH:mm:ss.000", queryDateBegin),
                BaseLib.formatDate("yyyy-MM-dd HH:mm:ss.000", queryDateEnd),
                this.queryCustomerNo, this.queryCustomerName);
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
                File file = new File(pathString, "折让合同统计表及预估模板.xls");
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
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
                Sheet sheet = wb.getSheetAt(0);
                wb.setSheetName(0, BaseLib.formatDate("yyyy-MM-dd", queryDateBegin) + "~" + BaseLib.formatDate("yyyy-MM-dd", queryDateEnd) + "折让合同统计表及预估");
                Row row = null;
                int i = 2;
                for (Object[] o : list) {
                    row = sheet.createRow(i);
                    Cell cell0 = row.createCell(0);
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
                    cell0.setCellStyle(cellStyle);
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
                    cell0.setCellValue(o[0] != null ? BaseLib.formatDate("yyyy/MM/dd", (Date) o[0]) : "");
                    cell1.setCellValue(o[1] != null ? (String) o[1] : "");
                    cell2.setCellValue(o[2] != null ? (String) o[2] : "");
                    cell3.setCellValue(o[3] != null ? (String) o[3] : "");
                    cell4.setCellValue(o[4] != null ? (String) o[4] : "");
                    cell5.setCellValue(o[5] != null ? (String) o[5] : "");
                    cell6.setCellValue("开具红字发票，冲销货款");
                    cell7.setCellValue(o[6] != null ? (String) o[6] : "");
                    cell8.setCellValue(o[7] != null ? (String) o[7] : "");
                    cell9.setCellValue(o[8] != null ? (String) o[8] : "");
                    cell11.setCellValue(o[9] != null ? (String) o[9] : "");
                    i++;
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
        setSuperEJB(hkjh006Bean);
        this.queryDateEnd = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.queryDateEnd);
        cal.add(Calendar.YEAR, -1);
        this.queryDateBegin = cal.getTime();
        list = hkjh006Bean.findByCustomerAndApplyDate(BaseLib.formatDate("yyyy-MM-dd HH:mm:ss.000", queryDateBegin),
                BaseLib.formatDate("yyyy-MM-dd HH:mm:ss.000", queryDateEnd),
                this.queryCustomerNo, this.queryCustomerName);
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
}
