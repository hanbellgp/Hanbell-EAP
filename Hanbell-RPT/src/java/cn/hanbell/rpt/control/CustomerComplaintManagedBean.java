/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.control;

import cn.hanbell.crm.ejb.REPTCBean;
import cn.hanbell.crm.ejb.SERCABean;
import cn.hanbell.eap.comm.MailNotify;
import cn.hanbell.eap.ejb.CustomerComplaintBean;
import cn.hanbell.eap.ejb.CustomerComplaintExpenseBean;
import cn.hanbell.eap.ejb.CustomerComplaintMaterialBean;
import cn.hanbell.eap.ejb.MailNotificationBean;
import cn.hanbell.eap.entity.CustomerComplaint;
import cn.hanbell.eap.entity.CustomerComplaintExpense;
import cn.hanbell.eap.entity.CustomerComplaintMaterial;
import cn.hanbell.erp.ejb.CdrlnhadBean;
import cn.hanbell.erp.ejb.InvhadBean;
import cn.hanbell.oa.ejb.HKFW005Bean;
import cn.hanbell.oa.ejb.HKFW006Bean;
import cn.hanbell.oa.ejb.SERI12Bean;
import cn.hanbell.oa.entity.SERI12;
import cn.hanbell.rpt.lazy.CustomerComplaintModel;
import cn.hanbell.rpt.web.SuperQueryBean;
import com.lightshell.comm.BaseLib;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
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
@ManagedBean(name = "customerComplaintManagedBean")
@javax.faces.bean.ViewScoped
public class CustomerComplaintManagedBean extends SuperQueryBean<CustomerComplaint> {

    @EJB
    private CustomerComplaintBean customerComplaintBean;
    @EJB
    private CustomerComplaintExpenseBean customerComplaintExpenseBean;
    @EJB
    private CustomerComplaintMaterialBean customerComplaintMaterialBean;
    @EJB
    private SERI12Bean seri12Bean;
    @EJB
    private SERCABean sercaBean;
    @EJB
    private HKFW005Bean hkfw005Bean;
    @EJB
    private HKFW006Bean hkfw006Bean;
    @EJB
    private CdrlnhadBean cdrlnhadBean;
    @EJB
    private REPTCBean reptcBean;
    @EJB
    private InvhadBean invhadBean;
    @EJB
    private MailNotificationBean mailBean;

    protected String queryKfno;
    protected String queryNcodeDC;

    private Date begin;
    private Date end;
    private String selectKfno;
    private Boolean checked;
    private String number;

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
    public void reset() {
        number = "";
        checked = false;
        selectKfno = "";
        begin = null;
        end = null;
        queryKfno = "";
        queryNcodeDC = "";
        queryDateBegin = null;
        queryDateEnd = null;
        super.reset();
    }

    @Override
    public void init() {
        selectKfno = "";
        checked = false;
        number = "";
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
        int[] wt1 = getCustomerComplaintWidth();
        for (int i = 0; i < wt1.length; i++) {
            sheet1.setColumnWidth(i, wt1[i] * 256);
        }
        int[] wt2 = getCustomerComplaintMaterialWidth();
        for (int i = 0; i < wt2.length; i++) {
            sheet2.setColumnWidth(i, wt2[i] * 256);
        }
        //创建标题行
        Row row;
        //表格一
        String[] title1 = getCustomerComplaintTitle();
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
            cell12.setCellValue(cp.getTotalamount().toString());
            Cell cell13 = row.createCell(13);
            cell13.setCellStyle(style.get("cell"));
            cell13.setCellValue(cp.getOverdate() != null ? BaseLib.formatDate("yyyy-MM-dd HH:mm", cp.getOverdate()) : "");
        }
        //表格二
        String[] title2 = getCustomerComplaintMaterialTitle();
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

    public String[] getCustomerComplaintTitle() {
        return new String[]{"产品别", "客诉单号", "客户名称", "不良原因", "责任单位", "责任判断比率", "材料费", "人工费", "运输费(含空运、吊装费)", "差旅费", "不良导致索赔款", "其他", "费用合计", "结案时间"};
    }

    public String[] getCustomerComplaintMaterialTitle() {
        return new String[]{"客诉单号", "服务单号", "类型", "领退料单号", "品号", "品名", "数量", "单位", "金额"};
    }

    private int[] getCustomerComplaintWidth() {
        return new int[]{10, 20, 15, 60, 15, 15, 15, 15, 15, 15, 15, 15, 15, 20};
    }

    private int[] getCustomerComplaintMaterialWidth() {
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

    public void sendMail() {
        if (!"".equals(number) && !"".equals(selectKfno)) {
            try {
                mailBean.getTo().clear();
                mailBean.getTo().add(getNumber().trim() + "@hanbell.com.cn");
                mailBean.setMailSubject("客诉结案抛转详细");
                mailBean.setMailContent(customerComplaintBean.getMail("客诉结案抛转详细", selectKfno));
                mailBean.notify(new MailNotify());
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "info", "邮件派送成功"));
            } catch (Exception e) {
            }
        }
    }

    public void selectCreateCustomerComplaint() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        List<SERI12> list = new ArrayList<>();
        if (!checked) {
            if (begin != null && end != null) {
                list = seri12Bean.findByBq037(df.format(begin), df.format(end));
            }
        } else {
            SERI12 seri12 = seri12Bean.findByBq001(selectKfno);
            if (seri12 != null) {
                list.add(seri12);
            }
        }
        int count = 0;
        BigDecimal travel, tansport, material;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            for (SERI12 seri12 : list) {
                travel = BigDecimal.ZERO;
                tansport = BigDecimal.ZERO;
                material = BigDecimal.ZERO;
                String kfno = seri12.getBq001();
                CustomerComplaint cp = new CustomerComplaint();
                String varnr = sercaBean.findCa009ByCa001(kfno);
                cp.setKfno(seri12.getBq001());
                cp.setCusno(seri12.getBq002() == null ? "null" : seri12.getBq002());
                cp.setCusna(seri12.getBq002c() == null ? "null" : seri12.getBq002c());
                cp.setVarnr(varnr == null ? "null" : varnr);
                cp.setNcodeDC(seri12.getBq197() == null ? "null" : seri12.getBq197());
                cp.setNcodeCD(seri12.getBq198() == null ? "null" : seri12.getBq198());
                cp.setNcodeDD(seri12.getBq003() == null ? "null" : seri12.getBq003());
                cp.setDutydeptno(seri12.getBq504() == null ? "null" : seri12.getBq504());
                cp.setDutydeptna(seri12.getBq504c() == null ? "null" : seri12.getBq504c());
                cp.setDutyrate(seri12.getPropotion() == null ? "null" : seri12.getPropotion());
                cp.setCredate(BaseLib.getDate("yyyy/MM/dd", seri12.getBq021()));
                cp.setOverdate(BaseLib.getDate("yyyy/MM/dd", seri12.getBq037()));
                cp.setBadwhy(seri12.getBq503() == null ? "null" : seri12.getBq503());
                //一、运输费
                tansportList = new ArrayList<>();
                CustomerComplaintExpense cce;
                List hkfw005s = hkfw005Bean.getTansportExpense(kfno);
                if (hkfw005s != null && !hkfw005s.isEmpty()) {
                    for (int i = 0; i < hkfw005s.size(); i++) {
                        Object[] row = (Object[]) hkfw005s.get(i);
                        cce = new CustomerComplaintExpense();
                        cce.setType(row[0].toString());
                        cce.setSources(row[1].toString());
                        cce.setKfno(row[2].toString());
                        cce.setFwno(row[3] == null ? "null" : row[3].toString());
                        cce.setUserno(row[4] == null ? "null" : row[4].toString());
                        cce.setUserna(row[5] == null ? "null" : row[5].toString());
                        cce.setDeptno(row[6] == null ? "null" : row[6].toString());
                        cce.setDeptna(row[7] == null ? "null" : row[7].toString());
                        cce.setOccurdate(row[8] == null ? "null" : row[8].toString());
                        cce.setExpensetype(row[9] == null ? "null" : row[9].toString());
                        cce.setCustom1(hkfw005Bean.getYsStyleName(row[10].toString()));
                        cce.setCustom2(row[11] == null ? "null" : row[11].toString());
                        cce.setCustom3(row[12] == null ? "null" : row[12].toString());
                        cce.setCustom4(row[13] == null ? "null" : row[13].toString());
                        cce.setExpense(BigDecimal.valueOf(Double.parseDouble(row[14].toString())));
                        cce.setRemark1(row[15] == null ? "null" : row[15].toString());
                        cce.setSourcesno(row[16] == null ? "null" : row[16].toString());
                        tansportList.add(cce);
                    }
                }
                List hkfw006s = hkfw006Bean.getTansportExpense(kfno);
                if (hkfw006s != null && !hkfw006s.isEmpty()) {
                    for (int i = 0; i < hkfw006s.size(); i++) {
                        Object[] row = (Object[]) hkfw006s.get(i);
                        cce = new CustomerComplaintExpense();
                        cce.setType(row[0].toString());
                        cce.setSources(row[1].toString());
                        cce.setKfno(row[2].toString());
                        cce.setFwno(row[3] == null ? "null" : row[3].toString());
                        cce.setUserno(row[4] == null ? "null" : row[4].toString());
                        cce.setUserna(row[5] == null ? "null" : row[5].toString());
                        cce.setDeptno(row[6] == null ? "null" : row[6].toString());
                        cce.setDeptna(row[7] == null ? "null" : row[7].toString());
                        cce.setOccurdate(row[8] == null ? "null" : row[8].toString());
                        cce.setExpensetype(row[9] == null ? "null" : row[9].toString());
                        cce.setCustom1(row[10] == null ? "null" : row[10].toString());
                        cce.setCustom2(row[11] == null ? "null" : row[11].toString());
                        cce.setCustom3(row[12] == null ? "null" : row[12].toString());
                        cce.setCustom4(row[13] == null ? "null" : row[13].toString());
                        cce.setExpense(BigDecimal.valueOf(Double.parseDouble(row[14].toString())));
                        cce.setRemark1(row[15] == null ? "null" : row[15].toString());
                        cce.setSourcesno(row[16] == null ? "null" : row[16].toString());
                        tansportList.add(cce);
                    }
                }
                List cdrlnhads = cdrlnhadBean.getCustomerComplaintExpense(kfno);
                if (cdrlnhads != null && !cdrlnhads.isEmpty()) {
                    for (int i = 0; i < cdrlnhads.size(); i++) {
                        Object[] row = (Object[]) cdrlnhads.get(i);
                        cce = new CustomerComplaintExpense();
                        cce.setType(row[0].toString());
                        cce.setSources(row[1].toString());
                        cce.setKfno(row[2].toString());
                        cce.setFwno(row[3] == null ? "null" : row[3].toString());
                        cce.setUserno(row[4] == null ? "null" : row[4].toString());
                        cce.setUserna(row[5] == null ? "null" : row[5].toString());
                        cce.setDeptno(row[6] == null ? "null" : row[6].toString());
                        cce.setDeptna(row[7] == null ? "null" : row[7].toString());
                        cce.setOccurdate(row[8] == null ? "null" : row[8].toString());
                        cce.setExpensetype(row[9] == null ? "null" : row[9].toString());
                        cce.setCustom1(row[10] == null ? "null" : row[10].toString());
                        cce.setCustom2(row[11] == null ? "null" : row[11].toString());
                        cce.setCustom3(row[12] == null ? "null" : row[12].toString());
                        cce.setCustom4("null");
                        cce.setSourcesno(row[13] == null ? "null" : row[13].toString());
                        cce.setExpense(BigDecimal.valueOf(Double.parseDouble(row[14].toString())));
                        cce.setRemark1(row[15] == null ? "null" : row[15].toString());
                        tansportList.add(cce);
                    }
                }
                //二、差旅费
                travelList = new ArrayList<>();
                List repts = reptcBean.getCustomerComplaintExpense(kfno);
                if (repts != null && !repts.isEmpty()) {
                    for (int i = 0; i < repts.size(); i++) {
                        Object[] row = (Object[]) repts.get(i);
                        cce = new CustomerComplaintExpense();
                        cce.setType(row[0].toString());
                        cce.setSources(row[1].toString());
                        cce.setKfno(row[2].toString());
                        cce.setFwno(row[3] == null ? "null" : row[3].toString());
                        cce.setUserno(row[4] == null ? "null" : row[4].toString());
                        cce.setUserna(row[5] == null ? "null" : row[5].toString());
                        cce.setDeptno(row[6] == null ? "null" : row[6].toString());
                        cce.setDeptna(row[7] == null ? "null" : row[7].toString());
                        cce.setSerialno(row[8] == null ? "null" : row[8].toString());
                        cce.setOccurdate(row[9] == null ? "null" : row[9].toString());
                        cce.setExpensetype(row[10] == null ? "null" : row[10].toString());
                        cce.setCustom1(row[11] == null ? "null" : row[11].toString());
                        cce.setCustom2(row[12] == null ? "null" : row[12].toString());
                        cce.setExpense(BigDecimal.valueOf(Double.parseDouble(row[13].toString())));
                        cce.setRemark1(row[14] == null ? "null" : row[14].toString());
                        cce.setSourcesno(row[15] == null ? "null" : row[15].toString());
                        cce.setSourcesdate(row[16] == null ? "null" : row[16].toString());
                        travelList.add(cce);
                    }
                }
                //三、材料费
                materialList = new ArrayList<>();
                CustomerComplaintMaterial cpd;
                List invhadhs = invhadBean.getCustomerComplaintMaterial(kfno);
                if (invhadhs != null && !invhadhs.isEmpty()) {
                    for (int i = 0; i < invhadhs.size(); i++) {
                        Object[] row = (Object[]) invhadhs.get(i);
                        cpd = new CustomerComplaintMaterial();
                        cpd.setKfno(row[0].toString());
                        cpd.setFwno(row[1] == null ? "null" : row[1].toString());
                        cpd.setTrtype(row[2] == null ? "null" : row[2].toString());
                        cpd.setTypedsc(row[3] == null ? "null" : row[3].toString());
                        cpd.setTrno(row[4] == null ? "null" : row[4].toString());
                        cpd.setTrdate(sdf.parse(row[5].toString()));
                        cpd.setTrseq(row[6] == null ? 0 : Integer.parseInt(row[6].toString()));
                        cpd.setItnbr(row[7] == null ? "null" : row[7].toString());
                        cpd.setItdsc(row[8] == null ? "null" : row[8].toString());
                        cpd.setTrnqy1(row[9] == null ? BigDecimal.ZERO : BigDecimal.valueOf(Double.parseDouble(row[9].toString())));
                        cpd.setUnmsr1(row[10] == null ? "null" : row[10].toString());
                        cpd.setTramt(row[11] == null ? BigDecimal.ZERO : BigDecimal.valueOf(Double.parseDouble(row[11].toString())));
                        materialList.add(cpd);
                    }
                }
                List invhads = invhadBean.getCustomerComplaintMaterial(kfno);
                if (invhads != null && !invhads.isEmpty()) {
                    for (int i = 0; i < invhads.size(); i++) {
                        Object[] row = (Object[]) invhads.get(i);
                        cpd = new CustomerComplaintMaterial();
                        cpd.setKfno(row[0].toString());
                        cpd.setFwno(row[1] == null ? "null" : row[1].toString());
                        cpd.setTrtype(row[2] == null ? "null" : row[2].toString());
                        cpd.setTypedsc(row[3] == null ? "null" : row[3].toString());
                        cpd.setTrno(row[4] == null ? "null" : row[4].toString());
                        cpd.setTrdate(sdf.parse(row[5].toString()));
                        cpd.setTrseq(row[6] == null ? 0 : Integer.parseInt(row[6].toString()));
                        cpd.setItnbr(row[7] == null ? "null" : row[7].toString());
                        cpd.setItdsc(row[8] == null ? "null" : row[8].toString());
                        cpd.setTrnqy1(row[9] == null ? BigDecimal.ZERO : BigDecimal.valueOf(Double.parseDouble(row[9].toString())));
                        cpd.setUnmsr1(row[10] == null ? "null" : row[10].toString());
                        cpd.setTramt(row[11] == null ? BigDecimal.ZERO : BigDecimal.valueOf(Double.parseDouble(row[11].toString())));
                        materialList.add(cpd);
                    }
                }
                //资料更新
                List<CustomerComplaintExpense> expenses = customerComplaintExpenseBean.findKfno(kfno);
                if (expenses != null && !expenses.isEmpty()) {
                    customerComplaintExpenseBean.delete(expenses);
                }
                List<CustomerComplaintMaterial> materials = customerComplaintMaterialBean.findKfno(kfno);
                if (materials != null && !materials.isEmpty()) {
                    customerComplaintMaterialBean.delete(materials);
                }
                if (!travelList.isEmpty()) {
                    for (CustomerComplaintExpense complaintExpense : travelList) {
                        travel = travel.add(complaintExpense.getExpense());
                        customerComplaintExpenseBean.persist(complaintExpense);
                    }
                }
                if (!tansportList.isEmpty()) {
                    for (CustomerComplaintExpense complaintExpense : tansportList) {
                        tansport = tansport.add(complaintExpense.getExpense());
                        customerComplaintExpenseBean.persist(complaintExpense);
                    }
                }
                if (!materialList.isEmpty()) {
                    for (CustomerComplaintMaterial complaintMaterial : materialList) {
                        //IAF为服务领料 领料加项 IAG为服务退料 退料减项
                        if (complaintMaterial.getTrtype().equals("IAF")) {
                            material = material.add(complaintMaterial.getTramt());
                        } else {
                            material = material.subtract(complaintMaterial.getTramt());
                        }
                        customerComplaintMaterialBean.persist(complaintMaterial);
                    }
                }
                CustomerComplaint plaint = customerComplaintBean.findKfno(kfno);
                if (plaint != null) {
                    customerComplaintBean.delete(plaint);
                }
                cp.setMaterialcost(material);
                cp.setTravelexpense(travel);
                cp.setTansportexpense(tansport);
                customerComplaintBean.persist(cp);
                count++;
            }
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", ex.toString()));
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "info", "查询出数据共" + list.size() + "条，成功导入EAP数据库共计" + count + "条"));
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

    /**
     * @return the begin
     */
    public Date getBegin() {
        return begin;
    }

    /**
     * @param begin the begin to set
     */
    public void setBegin(Date begin) {
        this.begin = begin;
    }

    /**
     * @return the end
     */
    public Date getEnd() {
        return end;
    }

    /**
     * @param end the end to set
     */
    public void setEnd(Date end) {
        this.end = end;
    }

    /**
     * @return the selectKfno
     */
    public String getSelectKfno() {
        return selectKfno;
    }

    /**
     * @param selectKfno the selectKfno to set
     */
    public void setSelectKfno(String selectKfno) {
        this.selectKfno = selectKfno;
    }

    /**
     * @return the checked
     */
    public Boolean getChecked() {
        return checked;
    }

    /**
     * @param checked the checked to set
     */
    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    /**
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(String number) {
        this.number = number;
    }
}
