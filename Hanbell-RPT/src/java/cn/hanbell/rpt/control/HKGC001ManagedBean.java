/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.control;

import cn.hanbell.eap.ejb.SystemProgramBean;
import cn.hanbell.eap.entity.SystemProgram;
import cn.hanbell.oa.ejb.HKGC001Bean;
import cn.hanbell.oa.model.HKGC001DetailModel;
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
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
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
@ManagedBean(name = "hkgc001ManagedQueryBean")
@javax.faces.bean.ViewScoped
public class HKGC001ManagedBean extends SuperQueryBean<HKGC001DetailModel> {

    @EJB
    private HKGC001Bean hkgc001Bean;

    @EJB
    private SystemProgramBean systemProgramBean;
    private Date startDate;
    private Date endDate;
    //自定义实体类，与HKGC001Detail相比较，多一个applydate，申请日期
    private List<HKGC001DetailModel> list;
    protected Date queryDateBegin;
    protected Date queryDateEnd;
    protected SystemProgram systemProgram;

    public HKGC001ManagedBean() {
        super(HKGC001DetailModel.class);
    }

    @Override
    public void init() {
        list = hkgc001Bean.getDetailByAppleDate(queryDateBegin, queryDateEnd);
        System.out.println("");
    }

    @Override
    public void print() {
        list = hkgc001Bean.getDetailByAppleDate(queryDateBegin, queryDateEnd);
        Logger log4j = LogManager.getLogger("cn.hanbell.eap");
        InputStream is = null;
        try {
            try {
                String finalFilePath = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
                int index = finalFilePath.indexOf("WEB-INF");
                String filePath = new String(finalFilePath.substring(1, index));
                String pathString = new String(filePath.concat("rpt/"));
                File file = new File(pathString, "研发制令申请及工作支援单.xls");
                is = new FileInputStream(file);
                this.fileName = "hkgc001" + BaseLib.formatDate("yyyyMMddHHmmss", BaseLib.getDate()) + ".xls";
                this.fileFullName = this.reportOutputPath + this.fileName;
                Workbook wb = WorkbookFactory.create(is);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
                Sheet sheet = wb.getSheetAt(0);
                wb.setSheetName(0, sdf.format(new Date()) + "研发制令申请及工作支援单");
                Row row = null;
                int i = 3;
                for (Iterator var12 = list.iterator(); var12.hasNext(); ++i) {
                    HKGC001DetailModel e = (HKGC001DetailModel) var12.next();
                    row = sheet.createRow(i-1);
                    Cell cell = row.createCell(0);
                    cell.setCellValue((double) (i - 2));
                    row.createCell(1).setCellValue(e.getItnbrf() != null ? e.getItnbrf() : "");
                    row.createCell(2).setCellValue(e.getItnbrfname() != null ? e.getItnbrfname() : "");
                    row.createCell(3).setCellValue(e.getItnbr() != null ? e.getItnbr() : "");
                    row.createCell(4).setCellValue(e.getItnbrname() != null ? e.getItnbrname() : "");
                    row.createCell(5).setCellValue(e.getWareh() != null ? e.getWareh() : "");
                    row.createCell(6).setCellValue(e.getWhdsc() != null ? e.getWhdsc() : "");
                    row.createCell(7).setCellValue(e.getQty() != null ? e.getQty() : "");
                    row.createCell(8).setCellValue(e.getWareh2() != null ? e.getWareh2() : "");
                    row.createCell(9).setCellValue(e.getWhdsc2() != null ? e.getWhdsc2() : "");
                    row.createCell(10).setCellValue(e.getNeeddate() != null ? e.getNeeddate() : "");
                    row.createCell(11).setCellValue(!"0".equals(e.getPurchasehelp())  ? e.getPurchasehelp() : "");
                    row.createCell(12).setCellValue(e.getMancode() != null ? e.getMancode() : "");
                    row.createCell(13).setCellValue(e.getManname() != null ? e.getManname() : "");
                    row.createCell(14).setCellValue(e.getFinishdate() != null ? e.getFinishdate() : "");
                    row.createCell(15).setCellValue(e.getTransno() != null ? e.getTransno() : "");
                    row.createCell(16).setCellValue(e.getFinqty() != null ? e.getFinqty() : "");
                    row.createCell(17).setCellValue(e.getEndDatetxt() != null ? e.getEndDatetxt() : "");
                    row.createCell(18).setCellValue(e.getStockDatetxt() != null ? e.getStockDatetxt() : "");
                }

                FileOutputStream os = null;

                try {
                    os = new FileOutputStream(this.fileFullName);
                    wb.write(os);
                    this.reportViewPath = this.reportViewContext + this.fileName;
                    this.preview();
                } catch (Exception var38) {
                    log4j.error(var38);
                } finally {
                    try {
                        if (null != os) {
                            os.flush();
                            os.close();
                        }
                    } catch (IOException var37) {
                        log4j.error(var37.getMessage());
                    }

                }
            } catch (FileNotFoundException var40) {
                log4j.error(var40.getMessage());
            } catch (IOException var41) {
                log4j.error(var41.getMessage());
            } catch (Exception var42) {
                log4j.error(var42.getMessage());
            }

        } finally {

        }
    }

    @Override
    public void query() {
        try {
            list = hkgc001Bean.getDetailByAppleDate(queryDateBegin, queryDateEnd);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "error", e.toString()));
        }

    }

    public void reset() {
        list = new ArrayList<>();
    }

    public HKGC001Bean getHkgc001Bean() {
        return hkgc001Bean;
    }

    public void setHkgc001Bean(HKGC001Bean hkgc001Bean) {
        this.hkgc001Bean = hkgc001Bean;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<HKGC001DetailModel> getList() {
        return list;
    }

    public void setList(List<HKGC001DetailModel> list) {
        this.list = list;
    }

    public Date getQueryDateBegin() {
        return queryDateBegin;
    }

    public void setQueryDateBegin(Date queryDateBegin) {
        this.queryDateBegin = queryDateBegin;
    }

    public Date getQueryDateEnd() {
        return queryDateEnd;
    }

    public void setQueryDateEnd(Date queryDateEnd) {
        this.queryDateEnd = queryDateEnd;
    }

}
