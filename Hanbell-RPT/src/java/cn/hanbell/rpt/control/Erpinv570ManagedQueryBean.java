/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.control;

import cn.hanbell.erp.ejb.InvtrnhBean;
import cn.hanbell.rpt.web.PagerBean;
import com.lightshell.comm.BaseLib;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author C1879
 */
@ManagedBean(name = "erpinv570ManagedQueryBean")
@javax.faces.bean.ViewScoped
public class Erpinv570ManagedQueryBean extends PagerBean<String[]> {

    @EJB
    protected InvtrnhBean invtrnhBean;

    //查询参数
    protected String queryFacno;
    protected String queryTrtype;
    protected String queryDepno;
    protected String queryUserno;
    protected String queryWareh;

    public Erpinv570ManagedQueryBean() {
    }

    @Override
    public void reset() {
        pageSize = 15;
        queryFacno = "C";
        queryTrtype = "";
        queryDepno = "";
        queryUserno = "";
        queryWareh = "";
        super.reset();
    }

    @Override
    public void init() {
        pageSize = 15;
        queryFacno = "C";
        queryTrtype = "";
        queryDepno = "";
        queryUserno = "";
        queryWareh = "";
        super.init();
    }

    @Override
    public void query() {
        super.query();
        map.clear();
        map.put("facno", queryFacno);
        map.put("trtype", queryTrtype);
        map.put("depno", queryDepno);
        map.put("userno", queryUserno);
        map.put("wareh", queryWareh);
        try {
            totallist = invtrnhBean.getINV570(queryDateBegin, queryDateEnd, map);
            if (totallist != null && !totallist.isEmpty()) {
                total = totallist.size();
                super.pageClick();
            }
            if (total == 0) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "info", "无法查询数据"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "数据异常" + e.toString()));
        }

    }
    
    @Override
    public void print() {
        if (totallist == null || totallist.isEmpty()) {
            return;
        }
        fileName = "INV555" + BaseLib.formatDate("yyyyMMddHHmmss", BaseLib.getDate()) + ".xls";
        fileFullName = reportOutputPath + fileName;
        HSSFWorkbook workbook = new HSSFWorkbook();
        //获得表格样式
        Map<String, CellStyle> style = createStyles(workbook);
        // 生成一个表格
        HSSFSheet sheet1 = workbook.createSheet("库存交易明细");
        // 设置表格宽度
        int[] wt1 = getWidth();
        for (int i = 0; i < wt1.length; i++) {
            sheet1.setColumnWidth(i, wt1[i] * 256);
        }
        //创建标题行
        Row row;
        //表格一
        String[] title1 = getTitle();
        row = sheet1.createRow(0);
        row.setHeight((short) 800);
        for (int i = 0; i < title1.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellStyle(style.get("head"));
            cell.setCellValue(title1[i]);
        }
        int j = 1;
        for (int i = 0; i < totallist.size(); i++) {
            String[] arr = totallist.get(i);
            row = sheet1.createRow(j);
            j++;
            row.setHeight((short) 400);
            Cell cell;
            for (int k = 0; k < arr.length; k++) {
                cell = row.createCell(k);
                cell.setCellStyle(style.get("cell"));
                cell.setCellValue(arr[k]);
            }
        }
        OutputStream os = null;
        try {
            os = new FileOutputStream(fileFullName);
            workbook.write(os);
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

    public String[] getTitle() {
        return new String[]{"单据别", "单据名称", "公司别", "生产地", "对像名称", "交易单号", "交易日期", "序号",
            "件号", "名称", "差旅费", "物料归类", "大类", "大类名称", "库号", "仓库名称", "数量", "单位", "金额", "录入人员", "出入库", "备注", "原因别", "原因内容"};
    }

    private int[] getWidth() {
        return new int[]{10, 15, 10, 10, 10, 15, 15, 15, 10, 20, 25, 10, 10, 20, 10, 10, 10, 10, 10, 10, 10, 35, 10, 15};
    }

    private Map<String, CellStyle> createStyles(Workbook wb) {
        Map<String, CellStyle> styles = new LinkedHashMap<>();
        // 文件头样式
        CellStyle headStyle = wb.createCellStyle();
        headStyle.setWrapText(true);//设置自动换行
        headStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        headStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        headStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());//单元格背景颜色
        headStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        headStyle.setBorderRight(CellStyle.BORDER_THIN);
        headStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
        headStyle.setBorderLeft(CellStyle.BORDER_THIN);
        headStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        headStyle.setBorderTop(CellStyle.BORDER_THIN);
        headStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
        headStyle.setBorderBottom(CellStyle.BORDER_THIN);
        headStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        Font headFont = wb.createFont();
        headFont.setFontHeightInPoints((short) 12);
        headFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headStyle.setFont(headFont);
        styles.put("head", headStyle);

        // 正文样式
        CellStyle cellStyle = wb.createCellStyle();
        Font cellFont = wb.createFont();
        cellFont.setFontHeightInPoints((short) 10);
        cellStyle.setFont(cellFont);
        cellStyle.setWrapText(true);//设置自动换行
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        cellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());//单元格背景颜色
        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cellStyle.setBorderRight(CellStyle.BORDER_THIN);
        cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
        cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle.setBorderTop(CellStyle.BORDER_THIN);
        cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
        cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        styles.put("cell", cellStyle);

        return styles;
    }

    /**
     * @return the queryFacno
     */
    public String getQueryFacno() {
        return queryFacno;
    }

    /**
     * @param queryFacno the queryFacno to set
     */
    public void setQueryFacno(String queryFacno) {
        this.queryFacno = queryFacno;
    }

    /**
     * @return the queryTrtype
     */
    public String getQueryTrtype() {
        return queryTrtype;
    }

    /**
     * @param queryTrtype the queryTrtype to set
     */
    public void setQueryTrtype(String queryTrtype) {
        this.queryTrtype = queryTrtype;
    }

    /**
     * @return the queryDepno
     */
    public String getQueryDepno() {
        return queryDepno;
    }

    /**
     * @param queryDepno the queryDepno to set
     */
    public void setQueryDepno(String queryDepno) {
        this.queryDepno = queryDepno;
    }

    /**
     * @return the queryUserno
     */
    public String getQueryUserno() {
        return queryUserno;
    }

    /**
     * @param queryUserno the queryUserno to set
     */
    public void setQueryUserno(String queryUserno) {
        this.queryUserno = queryUserno;
    }

    /**
     * @return the queryWareh
     */
    public String getQueryWareh() {
        return queryWareh;
    }

    /**
     * @param queryWareh the queryWareh to set
     */
    public void setQueryWareh(String queryWareh) {
        this.queryWareh = queryWareh;
    }


}
