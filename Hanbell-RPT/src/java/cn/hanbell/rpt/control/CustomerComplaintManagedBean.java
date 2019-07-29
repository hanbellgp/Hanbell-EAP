/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.control;

import cn.hanbell.eap.ejb.CustomerComplaintBean;
import cn.hanbell.eap.ejb.CustomerComplaintExpenseBean;
import cn.hanbell.eap.ejb.CustomerComplaintMaterialBean;
import cn.hanbell.eap.entity.CustomerComplaint;
import cn.hanbell.eap.entity.CustomerComplaintExpense;
import cn.hanbell.eap.entity.CustomerComplaintMaterial;
import cn.hanbell.rpt.lazy.CustomerComplaintModel;
import cn.hanbell.rpt.web.SuperQueryBean;
import com.lightshell.comm.BaseLib;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
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
@ManagedBean(name = "customerComplaintManagedBean")
@javax.faces.bean.ViewScoped
public class CustomerComplaintManagedBean extends SuperQueryBean<CustomerComplaint> {

    @EJB
    private CustomerComplaintBean customerComplaintBean;
    @EJB
    private CustomerComplaintExpenseBean customerComplaintExpenseBean;
    @EJB
    private CustomerComplaintMaterialBean customerComplaintMaterialBean;

    protected String queryKfno;
    protected String queryNcodeDC;
    //材料
    private List<CustomerComplaintMaterial> materialList;
    //差旅
    private List<CustomerComplaintExpense> travelList;
    //运费
    private List<CustomerComplaintExpense> tansportList;

    /**
     * Creates a new instance of HKFW005QueryBean
     */
    public CustomerComplaintManagedBean() {
        super(CustomerComplaint.class);
    }

    @Override
    public void init() {
        setSuperEJB(customerComplaintBean);
        this.model = new CustomerComplaintModel(customerComplaintBean);
        this.model.getSortFields().put("overdate", "DESC");
        super.init();
    }

    @Override
    public void setCurrentEntity(CustomerComplaint currentEntity) {
        materialList = new ArrayList<>();
        travelList = new ArrayList<>();
        tansportList = new ArrayList<>();
        if (currentEntity != null) {
            materialList = customerComplaintMaterialBean.findKfno(currentEntity.getKfno());
            travelList = customerComplaintExpenseBean.findKfnoAndType(currentEntity.getKfno(), "travelexpense");
            tansportList = customerComplaintExpenseBean.findKfnoAndType(currentEntity.getKfno(), "tansportexpense");
        }
        super.setCurrentEntity(currentEntity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void print() {
        entityList = customerComplaintBean.findByFilters(model.getFilterFields(), model.getSortFields());
        if (entityList == null || entityList.isEmpty()) {
            return;
        }
        fileName = "客诉成本" + BaseLib.formatDate("yyyyMMddHHmmss", BaseLib.getDate()) + ".xls";
        fileFullName = reportOutputPath + fileName;
        HSSFWorkbook workbook = new HSSFWorkbook();
        //获得表格样式
        Map<String, CellStyle> style = createStyles(workbook);
        // 生成一个表格
        HSSFSheet sheet1 = workbook.createSheet("客诉明细");
        HSSFSheet sheet2 = workbook.createSheet("材料明细");
        // 设置表格宽度
        int[] wt1 = getCuscomPlaintWidth();
        for (int i = 0; i < wt1.length; i++) {
            sheet1.setColumnWidth(i, wt1[i] * 256);
        }
        int[] wt2 = getCuscomPlaintDetailWidth();
        for (int i = 0; i < wt2.length; i++) {
            sheet2.setColumnWidth(i, wt2[i] * 256);
        }
        //创建标题行
        Row row;
        //表格一
        String[] title1 = getCuscomPlaintTitle();
        row = sheet1.createRow(0);
        row.setHeight((short) 800);
        for (int i = 0; i < title1.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellStyle(style.get("head"));
            cell.setCellValue(title1[i]);
        }
        List<CustomerComplaintMaterial> plaintMaterialLis = new ArrayList<>();
        int j = 1;
        for (CustomerComplaint cp : entityList) {
            plaintMaterialLis.addAll(customerComplaintMaterialBean.findKfno(cp.getKfno()));
            row = sheet1.createRow(j);
            j++;
            row.setHeight((short) 400);
            Cell cell0 = row.createCell(0);
            cell0.setCellStyle(style.get("cell"));
            cell0.setCellValue(cp.getNcodeDC());
            Cell cell1 = row.createCell(1);
            cell1.setCellStyle(style.get("cell"));
            cell1.setCellValue(cp.getKfno());
            Cell cell2 = row.createCell(2);
            cell2.setCellStyle(style.get("cell"));
            cell2.setCellValue(cp.getCusna() != null ? cp.getCusna() : "");
            Cell cell3 = row.createCell(3);
            cell3.setCellStyle(style.get("cell"));
            cell3.setCellValue(cp.getBadwhy() != null ? cp.getBadwhy() : "");
            Cell cell4 = row.createCell(4);
            cell4.setCellStyle(style.get("cell"));
            cell4.setCellValue(cp.getDutydeptna() != null ? cp.getDutydeptna() : "");
            Cell cell5 = row.createCell(5);
            cell5.setCellStyle(style.get("cell"));
            cell5.setCellValue(cp.getDutyrate() != null ? cp.getDutyrate() : "");
            Cell cell6 = row.createCell(6);
            cell6.setCellStyle(style.get("cell"));
            cell6.setCellValue(cp.getMaterialcost().toString());
            Cell cell7 = row.createCell(7);
            cell7.setCellStyle(style.get("cell"));
            cell7.setCellValue(cp.getLabourcost().toString());
            Cell cell8 = row.createCell(8);
            cell8.setCellStyle(style.get("cell"));
            cell8.setCellValue(cp.getTansportexpense().toString());
            Cell cell9 = row.createCell(9);
            cell9.setCellStyle(style.get("cell"));
            cell9.setCellValue(cp.getTravelexpense().toString());
            Cell cell10 = row.createCell(10);
            cell10.setCellStyle(style.get("cell"));
            cell10.setCellValue(cp.getClaimamount().toString());
            Cell cell11 = row.createCell(11);
            cell11.setCellStyle(style.get("cell"));
            cell11.setCellValue(cp.getOthercost().toString());
            Cell cell12 = row.createCell(12);
            cell12.setCellStyle(style.get("cell"));
            cell12.setCellValue(cp.getOverdate() != null ? BaseLib.formatDate("yyyy-MM-dd HH:mm", cp.getOverdate()) : "");
        }
        //表格二
        String[] title2 = getCuscomPlaintDetailTitle();
        row = sheet2.createRow(0);
        row.setHeight((short) 550);
        for (int i = 0; i < title2.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellStyle(style.get("head"));
            cell.setCellValue(title2[i]);
        }
        for (int i = 0; i < plaintMaterialLis.size(); i++) {
            CustomerComplaintMaterial cpd = plaintMaterialLis.get(i);
            row = sheet2.createRow(i + 1);
            row.setHeight((short) 400);
            Cell cell0 = row.createCell(0);
            cell0.setCellStyle(style.get("cell"));
            cell0.setCellValue(cpd.getKfno());
            Cell cell1 = row.createCell(1);
            cell1.setCellStyle(style.get("cell"));
            cell1.setCellValue(cpd.getFwno() != null ? cpd.getFwno() : "");
            Cell cell2 = row.createCell(2);
            cell2.setCellStyle(style.get("cell"));
            cell2.setCellValue(cpd.getTypedsc() != null ? cpd.getTypedsc() : "");
            Cell cell3 = row.createCell(3);
            cell3.setCellStyle(style.get("cell"));
            cell3.setCellValue(cpd.getTrno() != null ? cpd.getTrno() : "");
            Cell cell4 = row.createCell(4);
            cell4.setCellStyle(style.get("cell"));
            cell4.setCellValue(cpd.getItnbr() != null ? cpd.getItnbr() : "");
            Cell cell5 = row.createCell(5);
            cell5.setCellStyle(style.get("cell"));
            cell5.setCellValue(cpd.getItdsc() != null ? cpd.getItdsc() : "");
            Cell cell6 = row.createCell(6);
            cell6.setCellStyle(style.get("cell"));
            cell6.setCellValue(cpd.getTrnqy1() != null ? cpd.getTrnqy1().toString() : "");
            Cell cell7 = row.createCell(7);
            cell7.setCellStyle(style.get("cell"));
            cell7.setCellValue(cpd.getUnmsr1() != null ? cpd.getUnmsr1() : "");
            Cell cell8 = row.createCell(8);
            cell8.setCellStyle(style.get("cell"));
            cell8.setCellValue(cpd.getTramt() != null ? cpd.getTramt().toString() : "");
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

    public String[] getCuscomPlaintTitle() {
        return new String[]{"产品别", "客诉单号", "客户名称", "不良原因", "责任单位", "责任判断比率", "材料费", "人工费", "运输费(含空运、吊装费)", "差旅费", "不良导致索赔款", "其他", "结案时间"};
    }

    public String[] getCuscomPlaintDetailTitle() {
        return new String[]{"客诉单号", "服务单号", "类型", "领退料单号", "品号", "品名", "数量", "单位", "总金额"};
    }

    private int[] getCuscomPlaintWidth() {
        return new int[]{10, 20, 15, 60, 15, 15, 15, 15, 15, 15, 15, 15, 20};
    }

    private int[] getCuscomPlaintDetailWidth() {
        return new int[]{20, 20, 15, 20, 35, 35, 15, 15, 15};
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

    @Override
    public void query() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        if (this.model != null && this.model.getFilterFields() != null) {
            this.model.getFilterFields().clear();
            if (queryKfno != null && !"".equals(queryKfno)) {
                model.getFilterFields().put("kfno", queryKfno);
            }
            if (queryNcodeDC != null && !"".equals(queryNcodeDC)) {
                model.getFilterFields().put("ncodeDC", queryNcodeDC);
            }
            if (queryDateBegin != null && queryDateEnd != null) {
                model.getFilterFields().put("overdateBegin", queryDateBegin);
                model.getFilterFields().put("overdateEnd", queryDateEnd);
            }
        }
    }

    /**
     * @return the queryKfno
     */
    public String getQueryKfno() {
        return queryKfno;
    }

    /**
     * @param queryKfno the queryKfno to set
     */
    public void setQueryKfno(String queryKfno) {
        this.queryKfno = queryKfno;
    }

    /**
     * @return the queryNcodeDC
     */
    public String getQueryNcodeDC() {
        return queryNcodeDC;
    }

    /**
     * @param queryNcodeDC the queryNcodeDC to set
     */
    public void setQueryNcodeDC(String queryNcodeDC) {
        this.queryNcodeDC = queryNcodeDC;
    }

    /**
     * @return the materialList
     */
    public List<CustomerComplaintMaterial> getMaterialList() {
        return materialList;
    }

    /**
     * @param materialList the materialList to set
     */
    public void setMaterialList(List<CustomerComplaintMaterial> materialList) {
        this.materialList = materialList;
    }

    /**
     * @return the travelList
     */
    public List<CustomerComplaintExpense> getTravelList() {
        return travelList;
    }

    /**
     * @param travelList the travelList to set
     */
    public void setTravelList(List<CustomerComplaintExpense> travelList) {
        this.travelList = travelList;
    }

    /**
     * @return the tansportList
     */
    public List<CustomerComplaintExpense> getTansportList() {
        return tansportList;
    }

    /**
     * @param tansportList the tansportList to set
     */
    public void setTansportList(List<CustomerComplaintExpense> tansportList) {
        this.tansportList = tansportList;
    }

}
