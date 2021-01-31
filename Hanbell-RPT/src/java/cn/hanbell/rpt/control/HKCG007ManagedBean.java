/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.control;

import cn.hanbell.oa.ejb.HKCG007Bean;
import cn.hanbell.oa.ejb.HKCG007purDetailBean;
import cn.hanbell.oa.entity.HKCG007;
import cn.hanbell.oa.entity.HKCG007purDetail;
import cn.hanbell.rpt.lazy.HKCG007Model;
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
import javax.faces.bean.ViewScoped;
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
        name = "hkcg007ManagedBean"
)
@ViewScoped
public class HKCG007ManagedBean extends SuperQueryBean<HKCG007> {

    private Date queryDateBegin;
    private Date queryDateEnd;
    private String queryApplyUser;
    private String queryApplydept;
    private String queryUsedept;
    private String queryBuyType;
    @EJB
    private HKCG007Bean hkcg007Bean;
    @EJB
    private HKCG007purDetailBean hkcg007DetailBean;
    List<HKCG007purDetail> hkcg007DetailList;

    public HKCG007ManagedBean() {
        super(HKCG007.class);
    }

    @Override
    public void init() {
        this.setSuperEJB(this.hkcg007Bean);
        queryDateEnd = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(queryDateEnd);
        cal.add(Calendar.MONTH, -1);
        queryDateBegin = cal.getTime();
        this.model = new HKCG007Model(this.hkcg007Bean);
        this.model.getFilterFields().clear();
        super.init();
    }

    @Override
    public void reset() {
        queryApplyUser = "";
        queryApplyUser = "";
        queryApplydept = "";
        queryUsedept = "";
        queryBuyType = "All";
        queryDateEnd = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(queryDateEnd);
        cal.add(Calendar.MONTH, -1);
        queryDateBegin = cal.getTime();
    }

    @Override
    public void query() {
        if (this.model != null && this.model.getFilterFields() != null) {
            this.model.getFilterFields().clear();
            if (queryBuyType != null && !"All".equals(queryBuyType)) {
                this.model.getFilterFields().put("prkind", queryBuyType);
            }
            if (queryApplyUser != null && !"".equals(queryApplyUser)) {
                this.model.getFilterFields().put("applyUser.userName", queryApplyUser);
            }
            if (queryApplydept != null && !"".equals(queryApplydept)) {
                this.model.getFilterFields().put("applyOrganizationUnit.organizationUnitName", queryApplydept);
            }
            if (queryUsedept != null && !"".equals(queryUsedept)) {
                this.model.getFilterFields().put("useDeptno.organizationUnitName", queryUsedept);
            }
            if (queryDateBegin != null && !"".equals(queryDateBegin)) {
                this.model.getFilterFields().put("appDateBegin", queryDateBegin);
            }
            if (queryDateEnd != null && !"".equals(queryDateEnd)) {
                this.model.getFilterFields().put("appDateEnd", queryDateEnd);
            }
        }
    }

    @Override
    public void print() {
        entityList = hkcg007Bean.findByFilters(model.getFilterFields(), model.getSortFields());
        List<String> list = new ArrayList();
        InputStream is = null;
        try {
            try {
                String finalFilePath = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
                int index = finalFilePath.indexOf("WEB-INF");
                String filePath = new String(finalFilePath.substring(1, index));
                String pathString = new String(filePath.concat("rpt/"));
                File file = new File(pathString, "请购单模板.xlsx");
                is = new FileInputStream(file);
                this.fileName = "HKCG007" + BaseLib.formatDate("yyyyMMddHHmmss", BaseLib.getDate()) + ".xlsx";
                this.fileFullName = this.reportOutputPath + this.fileName;
                Workbook wb = WorkbookFactory.create(is);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
                Sheet sheet = wb.getSheetAt(0);
                wb.setSheetName(0, sdf.format(new Date()) + "请购单单头表");
                Row row = null;
                int i = 1;
                //打印单头档
                for (Iterator var12 = this.entityList.iterator(); var12.hasNext(); ++i) {
                    HKCG007 e = (HKCG007) var12.next();
                    list.add(e.getFormSerialNumber());
                    row = sheet.createRow(i);
                    Cell cell = row.createCell(0);
                    cell.setCellValue(i);
                    row.createCell(1).setCellValue(e.getFormSerialNumber() != null ? e.getFormSerialNumber() : "");
                    row.createCell(2).setCellValue(e.getFacno() != null ? e.getFacno() : "");
                    row.createCell(3).setCellValue(e.getApplyUser().getUserName() != null ? e.getApplyUser().getUserName() : "");
                    row.createCell(4).setCellValue(e.getApplyOrganizationUnit().getOrganizationUnitName() != null ? e.getApplyOrganizationUnit().getOrganizationUnitName() : "");
                    row.createCell(5).setCellValue(e.getAppDate() != null ? BaseLib.formatDate("yyyy/MM/dd", e.getAppDate()) : "");
                    row.createCell(6).setCellValue(e.getUser().getUserName() != null ? e.getUser().getUserName() : "");
                    row.createCell(7).setCellValue(e.getUseDeptno().getOrganizationUnitName() != null ? e.getUseDeptno().getOrganizationUnitName() : "");
                    row.createCell(8).setCellValue(e.getPRKindValue() != null ? e.getPRKindValue() : "");
                    row.createCell(9).setCellValue(e.getHmark1Value() != null ? e.getHmark1Value() : "");
                }

                Sheet sheet1 = wb.getSheetAt(1);
                wb.setSheetName(1, sdf.format(new Date()) + "请购单单身表");
                List<HKCG007purDetail> details = hkcg007DetailBean.findByFSN(list);
                //打印单身档
                i = 1;
                for (HKCG007purDetail detail : details) {
                    row = sheet1.createRow(i);
                    Cell cell = row.createCell(0);
                    cell.setCellValue(i);
                    row.createCell(1).setCellValue(detail.getItnbr() != null ? detail.getItnbr() : "");
                    row.createCell(2).setCellValue(detail.getItdsc() != null ? detail.getItdsc() : "");
                    row.createCell(3).setCellValue(detail.getSpdsc() != null ? detail.getSpdsc() : "");
                    row.createCell(4).setCellValue(detail.getHkcg007().getApplyUser()!=null ? detail.getHkcg007().getApplyUser().getUserName() : "");
                    row.createCell(5).setCellValue(detail.getHkcg007().getApplyOrganizationUnit() != null ?detail.getHkcg007().getApplyOrganizationUnit().getOrganizationUnitName() : "");
                    row.createCell(6).setCellValue(detail.getHkcg007().getAppDate() != null ? BaseLib.formatDate("yyyy/MM/dd", detail.getHkcg007().getAppDate()) : "");
                    row.createCell(7).setCellValue(detail.getRqtdateTxt() != null ? detail.getRqtdateTxt() : "");
                    row.createCell(8).setCellValue(detail.getEmgyn() != null ? detail.getEmgyn() : "");
                    row.createCell(9).setCellValue(detail.getPrqy1() != null ? detail.getPrqy1() : "");
                    row.createCell(10).setCellValue(detail.getAppunit() != null ? detail.getAppunit() : "");
                    row.createCell(11).setCellValue(detail.getApamts() != null ? detail.getApamts() : "");
                    row.createCell(12).setCellValue(detail.getDmark1() != null ? detail.getDmark1() : "");
                    row.createCell(13).setCellValue(detail.getDmark1name() != null ? detail.getDmark1name() : "");
                    row.createCell(14).setCellValue(detail.getDmark2() != null ? detail.getDmark2() : "");
                    row.createCell(15).setCellValue(detail.getDmark2name() != null ? detail.getDmark2name() : "");
                    row.createCell(16).setCellValue(detail.getVdrno() != null ? detail.getVdrno() : "");
                    row.createCell(17).setCellValue(detail.getVdrna() != null ? detail.getVdrna() : "");
                    row.createCell(18).setCellValue(detail.getBuyer() != null ? detail.getBuyer() : "");
                    row.createCell(19).setCellValue(detail.getBuyername() != null ? detail.getBuyername() : "");
                    row.createCell(20).setCellValue(detail.getUnpris() != null ? detail.getUnpris() : "");
                    row.createCell(12).setCellValue(detail.getAskdateTxt() != null ? detail.getAskdateTxt() : "");
                    row.createCell(22).setCellValue(detail.getCtramts() != null ? detail.getCtotamts() : "");
                    row.createCell(23).setCellValue(detail.getCtaxamts() != null ? detail.getCtaxamts() : "");
                    row.createCell(245).setCellValue(detail.getCtotamts() != null ? detail.getCtotamts() : "");
                    row.createCell(25).setCellValue(detail.getPurdaskdescs() != null ? detail.getPurdaskdescs() : "");
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
            } catch (IOException var41) {
                this.log4j.error(var41.getMessage());
            } catch (Exception var42) {
                var42.printStackTrace();
                this.log4j.error(var42.getMessage());
            }
        } finally {

        }
    }

    @Override
    public void setCurrentEntity(HKCG007 currentEntity) {
        if (currentEntity != null) {
            hkcg007DetailList = hkcg007DetailBean.findByFSN(currentEntity.getFormSerialNumber());
            super.setCurrentEntity(currentEntity);
        } else {
            currentEntity = new HKCG007();
        }

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

    public List<HKCG007purDetail> getHkcg007DetailList() {
        return hkcg007DetailList;
    }

    public void setHkcg007DetailList(List<HKCG007purDetail> hkcg007DetailList) {
        this.hkcg007DetailList = hkcg007DetailList;
    }

    public String getQueryApplyUser() {
        return queryApplyUser;
    }

    public void setQueryApplyUser(String queryApplyUser) {
        this.queryApplyUser = queryApplyUser;
    }

    public String getQueryApplydept() {
        return queryApplydept;
    }

    public void setQueryApplydept(String queryApplydept) {
        this.queryApplydept = queryApplydept;
    }

    public String getQueryUsedept() {
        return queryUsedept;
    }

    public void setQueryUsedept(String queryUsedept) {
        this.queryUsedept = queryUsedept;
    }

    public String getQueryBuyType() {
        return queryBuyType;
    }

    public void setQueryBuyType(String queryBuyType) {
        this.queryBuyType = queryBuyType;
    }
}
