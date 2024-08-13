/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.control;

//import cn.hanbell.crm.ejb.REPTCBean;
import cn.hanbell.erp.ejb.FreeServiceAmtBean;
import cn.hanbell.erp.entity.FreeServiceAmt;
import cn.hanbell.rpt.lazy.FreeServiceAmtModel;
import cn.hanbell.rpt.web.SuperQueryBean;
import com.lightshell.comm.BaseLib;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
 * @author C1749
 */
@ManagedBean(name = "freeServiceAmtManagedBean")
@javax.faces.bean.ViewScoped
public class FreeServiceAmtManagedBean extends SuperQueryBean<FreeServiceAmt> {

    @EJB
    FreeServiceAmtBean freeServiceAmtBean;
//    @EJB
//    REPTCBean reptcBean;
    protected String casenumber;
    protected String repairnumber;
    protected String userna;
    protected String deptna;
    protected String itntype;
    protected String judge;
    protected String charge;
    protected String iswarranty;
    private int y;
    private int m;
    protected Map<String, String> itntypes = new HashMap<>();//品号类别数组
    protected Map<String, String> judges = new HashMap<>();//责任判定数组
    public List<FreeServiceAmt> freeServiceAmtList;

    protected final Logger log4j = LogManager.getLogger();

    public FreeServiceAmtManagedBean() {
        super(FreeServiceAmt.class);
    }

    @Override
    public void init() {
        setSuperEJB(freeServiceAmtBean);
        model = new FreeServiceAmtModel(freeServiceAmtBean);
        freeServiceAmtList = new ArrayList<>();
        Date date = new Date();
        //默认单据日期开始
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, -1);
        c.set(Calendar.DAY_OF_MONTH, 1);
        queryDateBegin = c.getTime();
        //默认单据日期结束
        c.setTime(date);
        c.add(Calendar.MONTH, -1);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        queryDateEnd = c.getTime();
        y = c.get(Calendar.YEAR);
        m = c.get(Calendar.MONTH) + 1;
//        List<Object> data = reptcBean.getItntypeList();
        //设置品号类别初始值
//        for (Object item : data) {
//            itntypes.put(item.toString(), item.toString());
//        }
        judges.put("汉钟责任", "HZZR");
        judges.put("汉钟客户责任", "HZKFZR");
        judges.put("柯茂客户责任", "KMKFZR");
        judges.put("柯茂责任", "KMZR");
        freeServiceAmtList = freeServiceAmtBean.findQueryList(casenumber, repairnumber, userna, deptna, itntype, judge, charge, iswarranty, BaseLib.formatDate("yyyy-MM-dd", queryDateBegin), BaseLib.formatDate("yyyy-MM-dd", queryDateEnd));
        super.init();
    }

    @Override
    public void query() {
        freeServiceAmtList = freeServiceAmtBean.findQueryList(casenumber, repairnumber, userna, deptna, itntype, judge, charge, iswarranty, BaseLib.formatDate("yyyy-MM-dd", queryDateBegin), BaseLib.formatDate("yyyy-MM-dd", queryDateEnd));
        super.query();
    }

    @Override
    public void reset() {
        casenumber = "";
        repairnumber = "";
        userna = "";
        deptna = "";
        itntype = "";
        judge = "";
        charge = "";
        iswarranty = "";
        super.reset();
    }

    public void update() {
        Calendar c = Calendar.getInstance();
        c.setTime(queryDateBegin);
        y = c.get(Calendar.YEAR);
        m = c.get(Calendar.MONTH) + 1;
       // freeServiceAmtBean.updateFreeServiceAmt(y, m);
    }

    @Override
    public void print() {
        freeServiceAmtList = freeServiceAmtBean.findQueryList(casenumber, repairnumber, userna, deptna, itntype, judge, charge, iswarranty, BaseLib.formatDate("yyyy-MM-dd", queryDateBegin), BaseLib.formatDate("yyyy-MM-dd", queryDateEnd));
        if (freeServiceAmtList == null || freeServiceAmtList.isEmpty()) {
            return;
        }
        fileName = "免费服务金额明细表" + BaseLib.formatDate("yyyyMMdd", BaseLib.getDate()) + ".xls";
        fileFullName = reportOutputPath + fileName;
        HSSFWorkbook workbook = new HSSFWorkbook();
        //获得表格样式
        Map<String, CellStyle> style = createStyles(workbook);
        // 生成一个表格
        HSSFSheet sheet1 = workbook.createSheet("免费服务金额明细表");
        // 设置表格宽度
        int[] wt = {15, 18, 18, 10, 15, 15, 15, 20, 20, 20, 20, 15, 15, 15, 15, 15, 15, 15, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 15};
        for (int i = 0; i < wt.length; i++) {
            sheet1.setColumnWidth(i, wt[i] * 256);
        }
        //创建标题行
        Row row;
        //表格一
        String[] title = {"案件日期", "客诉单号", "责任人员", "姓名", "责任单位", "单位名称", "号类别编号", "品号类别编号", "产品序号", "产品机型编号", "客户编号", "客户名称", "责任判定", "是否收费",
            "是否在原厂保固期", "责任归属部门", "问题分类", "维修单号", "维修人员", "姓名", "维修部门", "部门代号", "客诉领料金额", "客诉退料金额", "拆修领料金额", "拆修退料金额", "差旅费", "运费", "合计金额"};
        row = sheet1.createRow(0);
        row.setHeight((short) 800);
        for (int i = 0; i < title.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellStyle(style.get("head"));
            cell.setCellValue(title[i]);
        }
        int j = 1;
        for (int i = 0; i < freeServiceAmtList.size(); i++) {
            FreeServiceAmt f = freeServiceAmtList.get(i);
            row = sheet1.createRow(j);
            j++;
            row.setHeight((short) 400);
            Cell cell;
            cell = row.createCell(0);
            cell.setCellStyle(style.get("cell"));
            cell.setCellValue(f.getCrdate() != null ? BaseLib.formatDate("yyyy-MM-dd", f.getCrdate()) : "");
            cell = row.createCell(1);
            cell.setCellStyle(style.get("cell"));
            cell.setCellValue(f.getCasenumber() != null ? f.getCasenumber() : "");
            cell = row.createCell(2);
            cell.setCellStyle(style.get("cell"));
            cell.setCellValue(f.getUserno() != null ? f.getUserno() : "");
            cell = row.createCell(3);
            cell.setCellStyle(style.get("cell"));
            cell.setCellValue(f.getUserna() != null ? f.getUserna() : "");
            cell = row.createCell(4);
            cell.setCellStyle(style.get("cell"));
            cell.setCellValue(f.getDeptno() != null ? f.getDeptno() : "");
            cell = row.createCell(5);
            cell.setCellStyle(style.get("cell"));
            cell.setCellValue(f.getDeptna() != null ? f.getDeptna() : "");
            cell = row.createCell(6);
            cell.setCellStyle(style.get("cell"));
            cell.setCellValue(f.getItntypeno() != null ? f.getItntypeno() : "");
            cell = row.createCell(7);
            cell.setCellStyle(style.get("cell"));
            cell.setCellValue(f.getItntypena() != null ? f.getItntypena() : "");
            cell = row.createCell(8);
            cell.setCellStyle(style.get("cell"));
            cell.setCellValue(f.getVarnr() != null ? f.getVarnr() : "");
            cell = row.createCell(9);
            cell.setCellStyle(style.get("cell"));
            cell.setCellValue(f.getItnbrcus() != null ? f.getItnbrcus() : "");
            cell = row.createCell(10);
            cell.setCellStyle(style.get("cell"));
            cell.setCellValue(f.getCusno() != null ? f.getCusno() : "");
            cell = row.createCell(11);
            cell.setCellStyle(style.get("cell"));
            cell.setCellValue(f.getCusna() != null ? f.getCusna() : "");
            cell = row.createCell(12);
            cell.setCellStyle(style.get("cell"));
            cell.setCellValue(f.getJudge() != null ? f.getJudge() : "");
            cell = row.createCell(13);
            cell.setCellStyle(style.get("cell"));
            cell.setCellValue(f.getCharge() != null ? f.getCharge() : "");
            cell = row.createCell(14);
            cell.setCellStyle(style.get("cell"));
            cell.setCellValue(f.getIswarranty() != null ? f.getIswarranty() : "");
            cell = row.createCell(15);
            cell.setCellStyle(style.get("cell"));
            cell.setCellValue(f.getAscriptiondept() != null ? f.getAscriptiondept() : "");
            cell = row.createCell(16);
            cell.setCellStyle(style.get("cell"));
            cell.setCellValue(f.getReason() != null ? f.getReason() : "");
            cell = row.createCell(17);
            cell.setCellStyle(style.get("cell"));
            cell.setCellValue(f.getRepairnumber() != null ? f.getRepairnumber() : "");
            cell = row.createCell(18);
            cell.setCellStyle(style.get("cell"));
            cell.setCellValue(f.getRepairuserno() != null ? f.getRepairuserno() : "");
            cell = row.createCell(19);
            cell.setCellStyle(style.get("cell"));
            cell.setCellValue(f.getRepairuserna() != null ? f.getRepairuserna() : "");
            cell = row.createCell(20);
            cell.setCellStyle(style.get("cell"));
            cell.setCellValue(f.getRepairdeptno() != null ? f.getRepairdeptno() : "");
            cell = row.createCell(21);
            cell.setCellStyle(style.get("cell"));
            cell.setCellValue(f.getRepairdeptna() != null ? f.getRepairdeptna() : "");
            cell = row.createCell(22);
            cell.setCellStyle(style.get("cell"));
            cell.setCellValue(f.getGcpamt().toString());
            cell = row.createCell(23);
            cell.setCellStyle(style.get("cell"));
            cell.setCellValue(f.getGcramt().toString());
            cell = row.createCell(24);
            cell.setCellStyle(style.get("cell"));
            cell.setCellValue(f.getDrpamt().toString());
            cell = row.createCell(25);
            cell.setCellStyle(style.get("cell"));
            cell.setCellValue(f.getDrramt().toString());
            cell = row.createCell(26);
            cell.setCellStyle(style.get("cell"));
            cell.setCellValue(f.getTravelamt().toString());
            cell = row.createCell(27);
            cell.setCellStyle(style.get("cell"));
            cell.setCellValue(f.getTrafficamt().toString());
            cell = row.createCell(28);
            cell.setCellStyle(style.get("cell"));
            cell.setCellValue(f.getTotalamt().toString());

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

    public Calendar getCalendar(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c;
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

    public List<FreeServiceAmt> getFreeServiceAmtList() {
        return freeServiceAmtList;
    }

    public void setFreeServiceAmtList(List<FreeServiceAmt> freeServiceAmtList) {
        this.freeServiceAmtList = freeServiceAmtList;
    }

    public String getCasenumber() {
        return casenumber;
    }

    public void setCasenumber(String casenumber) {
        this.casenumber = casenumber;
    }

    public String getRepairnumber() {
        return repairnumber;
    }

    public void setRepairnumber(String repairnumber) {
        this.repairnumber = repairnumber;
    }

    public String getJudge() {
        return judge;
    }

    public void setJudge(String judge) {
        this.judge = judge;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public String getIswarranty() {
        return iswarranty;
    }

    public void setIswarranty(String iswarranty) {
        this.iswarranty = iswarranty;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public Map<String, String> getJudges() {
        return judges;
    }

    public void setJudges(Map<String, String> judges) {
        this.judges = judges;
    }

    public String getItntype() {
        return itntype;
    }

    public void setItntype(String itntype) {
        this.itntype = itntype;
    }

    public Map<String, String> getItntypes() {
        return itntypes;
    }

    public void setItntypes(Map<String, String> itntypes) {
        this.itntypes = itntypes;
    }

    public String getUserna() {
        return userna;
    }

    public void setUserna(String userna) {
        this.userna = userna;
    }

    public String getDeptna() {
        return deptna;
    }

    public void setDeptna(String deptna) {
        this.deptna = deptna;
    }

}
