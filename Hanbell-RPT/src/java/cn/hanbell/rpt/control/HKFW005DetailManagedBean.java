/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.control;

import cn.hanbell.oa.ejb.HKFW005DetailBean;
import cn.hanbell.oa.ejb.WorkAssignmentBean;
import cn.hanbell.oa.entity.HKFW005Detail;
import cn.hanbell.rpt.lazy.HKFW005DetailModel;
import cn.hanbell.rpt.web.SuperQueryBean;
import com.lightshell.comm.BaseLib;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author C1491
 */
@ManagedBean(name = "hkfw005DetailManagedBean")
@javax.faces.bean.ViewScoped
public class HKFW005DetailManagedBean extends SuperQueryBean<HKFW005Detail> {

    @EJB
    private WorkAssignmentBean workAssignmentBean;
    @EJB
    private HKFW005DetailBean hkfw005DetailBean;

    private String queryType;

    private Date queryCreateDateBegin;

    private Date queryCreateDateEnd;

    private String queryAssignee;

    /**
     * Creates a new instance of HKFW005DetailManagedBean
     */
    public HKFW005DetailManagedBean() {
        super(HKFW005Detail.class);
    }

    @Override
    public void init() {
        setSuperEJB(hkfw005DetailBean);
        this.model = new HKFW005DetailModel(hkfw005DetailBean);
        this.queryAssignee = "C0479";//服务仓管

        super.init();
        //this.queryState = "1";
    }

    @Override
    public void print() {
        entityList = hkfw005DetailBean.findByFilters(model.getFilterFields(), model.getSortFields());
        if (entityList == null || entityList.isEmpty()) {
            return;
        }
        fileName = "HKFW005" + BaseLib.formatDate("yyyyMMddHHmmss", BaseLib.getDate()) + ".xls";
        fileFullName = reportOutputPath + fileName;
        HSSFWorkbook wb = new HSSFWorkbook();
        CreationHelper createHelper = wb.getCreationHelper();
        CellStyle cellStyle = wb.createCellStyle();
        //创建内容
        Sheet sheet = wb.createSheet("HKFW005");
        Cell cell;
        Row row;
        row = sheet.createRow(0);
        row.createCell(0).setCellValue("表单单号");
        row.createCell(1).setCellValue("单据类型");
        row.createCell(2).setCellValue("申请人");
        row.createCell(3).setCellValue("申请部门");
        row.createCell(4).setCellValue("配合人");
        row.createCell(5).setCellValue("配合部门");
        row.createCell(6).setCellValue("订单号");
        row.createCell(7).setCellValue("客服单号");
        row.createCell(8).setCellValue("服务单号");
        row.createCell(9).setCellValue("创建时间");
        row.createCell(10).setCellValue("需出货日期");
        row.createCell(11).setCellValue("客户名称");
        row.createCell(12).setCellValue("客户代号");
        row.createCell(13).setCellValue("件号");
        row.createCell(14).setCellValue("品名");
        row.createCell(15).setCellValue("数量");
        int i = 1;
        for (HKFW005Detail e : entityList) {
            row = sheet.createRow(i);
            row.createCell(0).setCellValue(e.getFormSerialNumber());
            row.createCell(1).setCellValue(e.getHkfw005().getType() != null ? e.getHkfw005().getCusno() : "");
            row.createCell(2).setCellValue(e.getHkfw005().getApplyUser() != null ? e.getHkfw005().getApplyUser().getUserName() : "");
            row.createCell(3).setCellValue(e.getHkfw005().getApplyDept() != null ? e.getHkfw005().getApplyDept().getOrganizationUnitName() : "");
            row.createCell(4).setCellValue(e.getHkfw005().getSupportUser() != null ? e.getHkfw005().getSupportUser().getUserName() : "");
            row.createCell(5).setCellValue(e.getHkfw005().getSupportDept() != null ? e.getHkfw005().getSupportDept().getOrganizationUnitName() : "");
            row.createCell(6).setCellValue(e.getHkfw005().getCdrno() != null ? e.getHkfw005().getCdrno() : "");
            row.createCell(7).setCellValue(e.getHkfw005().getKfno() != null ? e.getHkfw005().getKfno() : "");
            row.createCell(8).setCellValue(e.getHkfw005().getFwno() != null ? e.getHkfw005().getFwno() : "");
            if (null == e.getHkfw005().getCreatedate() || e.getHkfw005().getCreatedate().equals("")) {
                row.createCell(9).setCellValue("");
            } else {
                cell = row.createCell(9);
                cell.setCellValue(e.getHkfw005().getCreatedate());
                cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy/MM/dd"));
                cell.setCellStyle(cellStyle);
            }
            if (null == e.getHkfw005().getShpdate() || e.getHkfw005().getShpdate().equals("")) {
                row.createCell(10).setCellValue("");
            } else {
                cell = row.createCell(10);
                cell.setCellValue(e.getHkfw005().getShpdate());
                cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy/MM/dd"));
                cell.setCellStyle(cellStyle);
            }
            row.createCell(11).setCellValue(e.getHkfw005().getCusno() != null ? e.getHkfw005().getCusno() : "");
            row.createCell(12).setCellValue(e.getHkfw005().getCusna() != null ? e.getHkfw005().getCusna() : "");
            row.createCell(13).setCellValue(e.getItnbr() != null ? e.getItnbr() : "");
            row.createCell(14).setCellValue(e.getItdsc() != null ? e.getItdsc() : "");
            row.createCell(15).setCellValue(e.getQty() != null ? e.getQty() : "");
            i++;
        }
        for (int c = 0; c < 13; c++) {
            sheet.autoSizeColumn(c);
        }
        OutputStream os = null;
        try {
            os = new FileOutputStream(fileFullName);
            wb.write(os);
            this.reportViewPath = reportViewContext + fileName;
            this.preview();
        } catch (Exception ex) {
            log4j.error(ex);
        } finally {
            try {
                if (null != os) {
                    os.flush();
                    os.close();
                }
            } catch (IOException ex) {
                log4j.error(ex.getMessage());
            }
        }
    }

    @Override
    public void query() {
        List<String> psnList = null;
        this.model.getFilterFields().clear();
        if (this.model != null && this.model.getFilterFields() != null) {
            psnList = workAssignmentBean.findByProcessDefIDAndUserid(this.queryAssignee, "PKG_HK_FW005");
            if (psnList != null && !psnList.isEmpty()) {
                this.model.getFilterFields().put("hkfw005.processInstance.serialNumber IN ", psnList);
            } else {
                this.model.getFilterFields().put("hkfw005.processInstance.serialNumber = ", "");
            }
            if (this.queryCreateDateBegin != null && !"".equals(this.queryCreateDateBegin)) {
                this.model.getFilterFields().put("hkfw005.createdateBegin", queryCreateDateBegin);
            }
            if (this.queryCreateDateEnd != null && !"".equals(this.queryCreateDateEnd)) {
                this.model.getFilterFields().put("hkfw005.createdateEnd", queryCreateDateEnd);
            }
            if (!"ALL".equals(this.queryType)) {
                this.model.getFilterFields().put("hkfw005.type", queryType);
            }
//            if (!"ALL".equals(this.queryState)) {
//                this.model.getFilterFields().put("hkfw005.processInstance.currentState = ", Integer.valueOf(this.queryState));
//            }
//            if (!"ALL".equals(this.queryState)) {
//                this.model.getFilterFields().put("hkfw005.processInstance.currentState = ", Integer.valueOf(this.queryState));
//            }

        }
    }

    @Override
    public void reset() {
        super.reset();
        this.model.getFilterFields().put("type <>", "4");
    }

    //获取代号说明
    public String getCdesc(String ckind, String code) {
        String cdesc = "";
        if ("type".equals(ckind)) {
            switch (code) {
                case "1":
                    cdesc = "零件支援";
                    break;
                case "2":
                    cdesc = "整机支援";
                    break;
                default:
                    cdesc = "维修支援";
                    break;
            }
        }
        return cdesc;
    }

    public Date getQueryCreateDateBegin() {
        return queryCreateDateBegin;
    }

    public void setQueryCreateDateBegin(Date queryCreateDateBegin) {
        this.queryCreateDateBegin = queryCreateDateBegin;
    }

    public Date getQueryCreateDateEnd() {
        return queryCreateDateEnd;
    }

    public void setQueryCreateDateEnd(Date queryCreateDateEnd) {
        this.queryCreateDateEnd = queryCreateDateEnd;
    }

    public String getQueryAssignee() {
        return queryAssignee;
    }

    public void setQueryAssignee(String queryAssignee) {
        this.queryAssignee = queryAssignee;
    }

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

}
