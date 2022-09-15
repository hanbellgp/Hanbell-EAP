/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.control;

import cn.hanbell.oa.ejb.HKGL037DetailBean;
import cn.hanbell.oa.entity.HKGL037Detail;
import cn.hanbell.rpt.lazy.HKGL037DetailModel;
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
@ManagedBean(name = "hkgl037DetailManagedBean")
@javax.faces.bean.ViewScoped
public class HKGL037DetailManagedBean extends SuperQueryBean<HKGL037Detail> {

    @EJB
    private HKGL037DetailBean hkgl037DetailBean;

    private String queryType;
    private String queryApplyUser;
    private Date queryCreateDateBegin;
    private Date queryCreateDateEnd;

    /**
     * Creates a new instance of HKFW005DetailManagedBean
     */
    public HKGL037DetailManagedBean() {
        super(HKGL037Detail.class);
    }

    @Override
    public void init() {
        setSuperEJB(hkgl037DetailBean);
        this.model = new HKGL037DetailModel(hkgl037DetailBean);
        super.init();
    }

    @Override
    public void print() {
        entityList = hkgl037DetailBean.findByFilters(model.getFilterFields(), model.getSortFields());
        if (entityList == null || entityList.isEmpty()) {
            return;
        }
        fileName = "HKGL037" + BaseLib.formatDate("yyyyMMddHHmmss", BaseLib.getDate()) + ".xls";
        fileFullName = reportOutputPath + fileName;
        HSSFWorkbook wb = new HSSFWorkbook();
        CreationHelper createHelper = wb.getCreationHelper();
        CellStyle cellStyle = wb.createCellStyle();
        //创建内容
        Sheet sheet = wb.createSheet("HKGL037");
        Cell cell;
        Row row;
        row = sheet.createRow(0);

        if (this.getQueryType().equals('3')) {
            row.createCell(0).setCellValue("单据类型");
            row.createCell(1).setCellValue("申请日期");
            row.createCell(2).setCellValue("申请人");
            row.createCell(3).setCellValue("申请部门");
            row.createCell(4).setCellValue("出发地");
            row.createCell(5).setCellValue("目的地");
            row.createCell(6).setCellValue("事由");
            row.createCell(7).setCellValue("用车日期");
            row.createCell(8).setCellValue("表单单号");
            int i = 1;
            for (HKGL037Detail e : entityList) {
                row = sheet.createRow(i);
                row.createCell(0).setCellValue(getCdesc("type", e.getHkgl037().getClxz()));
                if (null == e.getHkgl037().getSqrq() || "".equals(e.getHkgl037().getSqrq())) {
                    row.createCell(1).setCellValue("");
                } else {
                    cell = row.createCell(1);
                    cell.setCellValue(e.getHkgl037().getSqrq());
                    cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy/MM/dd"));
                    cell.setCellStyle(cellStyle);
                }
                row.createCell(2).setCellValue(e.getHkgl037().getHdnDept() != null ? e.getHkgl037().getHdnDept() : "");
                row.createCell(3).setCellValue(e.getHkgl037().getHdnEmply());
                row.createCell(4).setCellValue(e.getAddress1());
                row.createCell(5).setCellValue(e.getAddress2());
                row.createCell(6).setCellValue(e.getSy());
                if (null == e.getYcrqTxt() || e.getYcrqTxt().equals("")) {
                    row.createCell(7).setCellValue("");
                } else {
                    cell = row.createCell(7);
                    cell.setCellValue(e.getYcrqTxt());
                    cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy/MM/dd"));
                    cell.setCellStyle(cellStyle);
                }
                row.createCell(8).setCellValue(e.getFormSerialNumber());
                i++;
            }
            for (int c = 0; c < 9; c++) {
                sheet.autoSizeColumn(c);
            }
        } else {
            row.createCell(0).setCellValue("单据类型");
            row.createCell(1).setCellValue("日期");
            row.createCell(2).setCellValue("申请部门");
            row.createCell(3).setCellValue("驾驶员");
            row.createCell(4).setCellValue("目的地");
            row.createCell(5).setCellValue("事由");
            row.createCell(6).setCellValue("始公里数");
            row.createCell(7).setCellValue("终公里数");
            row.createCell(8).setCellValue("里程合计");
            row.createCell(9).setCellValue("回厂时间");
            row.createCell(10).setCellValue("车牌号");
            row.createCell(11).setCellValue("车牌号");
            row.createCell(12).setCellValue("表单单号");
            int i = 1;
            for (HKGL037Detail e : entityList) {
                row = sheet.createRow(i);
                row.createCell(0).setCellValue(getCdesc("type", e.getHkgl037().getClxz()));
                if (null == e.getHkgl037().getCctime() || e.getHkgl037().getCctime().equals("")) {
                    row.createCell(1).setCellValue("");
                } else {
                    cell = row.createCell(1);
                    cell.setCellValue(e.getHkgl037().getCctime());
                    cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy/MM/dd"));
                    cell.setCellStyle(cellStyle);
                }
                row.createCell(2).setCellValue(e.getHkgl037().getHdnDept() != null ? e.getHkgl037().getHdnDept() : "");
                if ("1".equals(e.getHkgl037().getClxz())) {
                    row.createCell(3).setCellValue(e.getHkgl037().getHdnJsy());
                } else {
                    row.createCell(3).setCellValue(e.getHkgl037().getHdnEmply());
                }
                row.createCell(4).setCellValue(e.getAddress2());
                row.createCell(5).setCellValue(e.getSy());
                row.createCell(6).setCellValue(e.getHkgl037().getSgls() != null ? e.getHkgl037().getSgls() : 0.00);
                row.createCell(7).setCellValue(e.getHkgl037().getZgls() != null ? e.getHkgl037().getZgls() : 0.00);
                row.createCell(8).setCellValue(e.getHkgl037().getTotal() != null ? e.getHkgl037().getTotal() : 0.00);
                if (null == e.getHkgl037().getHctime() || e.getHkgl037().getHctime().equals("")) {
                    row.createCell(9).setCellValue("");
                } else {
                    cell = row.createCell(9);
                    cell.setCellValue(e.getHkgl037().getHctime());
                    cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy/MM/dd"));
                    cell.setCellStyle(cellStyle);
                }
                row.createCell(10).setCellValue(e.getHkgl037().getCph());
                row.createCell(11).setCellValue(e.getHkgl037().getCpno());
                row.createCell(12).setCellValue(e.getFormSerialNumber());
                i++;
            }
            for (int c = 0; c < 13; c++) {
                sheet.autoSizeColumn(c);
            }
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
        this.model.getFilterFields().clear();
        if (this.model != null && this.model.getFilterFields() != null) {
            if (this.queryCreateDateBegin != null && !"".equals(this.queryCreateDateBegin)) {
                this.model.getFilterFields().put("hkgl037.cctimeBegin", queryCreateDateBegin);
            }
            if (this.queryCreateDateEnd != null && !"".equals(this.queryCreateDateEnd)) {
                this.model.getFilterFields().put("hkgl037.cctimeEnd", queryCreateDateEnd);
            }
            if (!"ALL".equals(this.queryType)) {
                this.model.getFilterFields().put("hkgl037.clxz", queryType);
            }
            if (this.queryApplyUser != null && !"".equals(this.queryApplyUser)) {
                this.model.getFilterFields().put("hkgl037.emply", queryApplyUser);
            }
            //筛选已结案的单据
            this.model.getFilterFields().put("hkgl037.processInstance.currentState =", 3);
        }
    }

    @Override
    public void reset() {
        super.reset();
        //this.model.getFilterFields().put("type <>", "4");
    }

    //获取代号说明
    public String getCdesc(String ckind, String code) {
        String cdesc = "";
        if ("type".equals(ckind)) {
            switch (code) {
                case "1":
                    cdesc = "公务车";
                    break;
                case "2":
                    cdesc = "私车公用";
                    break;
                case "3":
                    cdesc = "外叫车";
                    break;
                default:
                    cdesc = "";
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

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public String getQueryApplyUser() {
        return queryApplyUser;
    }

    public void setQueryApplyUser(String queryApplyUser) {
        this.queryApplyUser = queryApplyUser;
    }

}
