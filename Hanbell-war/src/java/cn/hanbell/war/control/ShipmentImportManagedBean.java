/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.war.control;

import cn.hanbell.eap.ejb.DepartmentBean;
import cn.hanbell.eap.entity.Department;
import cn.hanbell.eap.entity.Shipment;
import cn.hanbell.eap.entity.ShipmentDetail;
import cn.hanbell.erp.ejb.CdrcitnbrBean;
import cn.hanbell.erp.ejb.CdrhadBean;
import cn.hanbell.erp.ejb.CdrscusBean;
import cn.hanbell.erp.entity.Cdrhad;
import cn.hanbell.erp.entity.Cdrcus;
import cn.hanbell.erp.entity.Cdrlot;
import com.lightshell.comm.BaseLib;
import com.lowagie.text.pdf.PdfCopyFields;
import com.lowagie.text.pdf.PdfReader;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author C0160
 */
@ManagedBean(name = "shipmentImportManagedBean")
@SessionScoped
public class ShipmentImportManagedBean extends ShipmentPrintManagedBean {

    @EJB
    private CdrcitnbrBean cdrcitnbrBean;
    @EJB
    private CdrhadBean cdrhadBean;
    @EJB
    private CdrscusBean cdrscusBean;
    @EJB
    private DepartmentBean departmentBean;

    private List<Cdrhad> cdrhadList;
    private List<Cdrhad> cdrhadSelected;
    private HashMap<String, Object> filters;

    private boolean queryNoParts;
    private String queryModel;

    public ShipmentImportManagedBean() {
    }

    @Override
    public void handleDialogReturnWhenNew(SelectEvent event) {
        if (event.getObject() != null) {
            Cdrcus c = (Cdrcus) event.getObject();
            this.queryFormId = c.getCusno();
            this.queryName = c.getCusds();
        }
    }

    @Override
    public void init() {
        cdrhadList = new ArrayList<>();
        cdrhadSelected = new ArrayList<>();
        filters = new HashMap<>();
        super.init();
    }

    @Override
    public void print() throws Exception {
        if (currentPrgGrant == null || cdrhadSelected == null || cdrhadSelected.isEmpty()) {
            return;
        }
        String reportName, outputName, reportFormat, f;
        // 设置报表名称
        reportName = reportPath + currentPrgGrant.getSysprg().getRptdesign();
        // 设置导出文件名称
        fileName = "CdrhadBarcode" + BaseLib.formatDate("yyyyMMddHHmmss", getDate()) + ".pdf";
        outputName = reportOutputPath + fileName;
        OutputStream os = new FileOutputStream(outputName);
        if (this.currentPrgGrant != null && this.currentPrgGrant.getSysprg().getRptclazz() != null) {
            reportClassLoader = Class.forName(this.currentPrgGrant.getSysprg().getRptclazz()).getClassLoader();
        }
        PdfCopyFields pdfCopy = new PdfCopyFields(os);
        HashMap<String, Object> reportParams = new HashMap<>();
        ByteArrayOutputStream baos;
        for (Cdrhad c : cdrhadSelected) {
            f = this.getAppResPath() + c.getCdrhadPK().getShpno() + ".png";
            this.generateCode128(c.getCdrhadPK().getShpno(), 1.5f, 8d, f);
            this.generateQRCode(c.getCdrhadPK().getShpno(), 300, 300, this.getAppResPath(),
                    "QR" + c.getCdrhadPK().getShpno() + ".png");
            // 设置报表参数
            baos = new ByteArrayOutputStream();
            reportParams.put("company", userManagedBean.getCurrentCompany().getCompany());
            reportParams.put("companyFullName", userManagedBean.getCurrentCompany().getFullname());
            reportParams.put("tel", userManagedBean.getCurrentCompany().getTel());
            reportParams.put("fax", userManagedBean.getCurrentCompany().getFax());
            reportParams.put("id", c.getCdrhadPK().getShpno());
            reportParams.put("formid", c.getCdrhadPK().getShpno());
            reportParams.put("JNDIName", currentPrgGrant.getSysprg().getRptjndi());
            try {
                // 初始配置
                this.reportInitAndConfig();
                // 生成报表
                this.reportRunAndOutput(reportName, reportParams, null, "pdf", baos);
            } catch (Exception ex) {
                throw ex;
            } finally {
                reportParams.clear();
            }
            pdfCopy.addDocument(new PdfReader(baos.toByteArray()));
        }
        pdfCopy.close();
        this.reportViewPath = reportViewContext + fileName;
        this.preview();
    }

    @Override
    public void query() {
        cdrhadList.clear();
        filters.clear();
        filters.put("cusno", queryFormId);
        filters.put("shpdateBegin", queryDateBegin);
        filters.put("shpdateEnd", queryDateEnd);
        cdrhadBean.setCompany(this.userManagedBean.getCompany());
        cdrhadList = cdrhadBean.findByFilters(filters);
    }

    @Override
    public void verify() {
        if (cdrhadSelected == null || cdrhadSelected.isEmpty()) {
            showWarnMsg("Warn", "没有选择任何单据");
            return;
        }
        String formid, shipAddress;
        List<String> shpnoList = new ArrayList<>();
        int seq = 0;
        ShipmentDetail sd;
        List<ShipmentDetail> shipmentDetails = new ArrayList<>();

        Cdrhad a = cdrhadSelected.get(0);
        Department dept = departmentBean.findByDeptno(a.getDepno());

        Shipment s = new Shipment();
        s.setCompany(a.getCdrhadPK().getFacno());
        s.setFormdate(getDate());
        s.setCustomerno(a.getCusno());
        s.setCustomer(a.getCdrcus().getCusna());
        s.setCustomerFullName(a.getCdrcus().getCusds());
        s.setDeptno(a.getDepno());
        if (dept != null) {
            s.setDeptname(dept.getDept());
        }
        s.setUserno(a.getSecuser().getUserno() + "_" + a.getSecuser().getUsername());
        s.setStatus("N");
        s.setCreator(this.userManagedBean.getCurrentUser().getUsername());
        s.setCredate(getDate());
        // 获取明细
        List<Cdrlot> cdrlotList;
        cdrhadBean.setCompany(this.userManagedBean.getCompany());
        for (Cdrhad h : cdrhadSelected) {
            // 获取送货地址
            cdrscusBean.setCompany(h.getCdrhadPK().getFacno());
            shipAddress = cdrscusBean.getAddress(h.getCusno(), h.getShptrseq());

            this.fileName = this.getAppResPath() + h.getCdrhadPK().getShpno() + ".png";
            this.generateCode128(h.getCdrhadPK().getShpno(), 1.5f, 8d, this.fileName);
            this.generateQRCode(h.getCdrhadPK().getShpno(), 300, 300, this.getAppResPath(), "QR" + h.getCdrhadPK().getShpno() + ".png");
            cdrlotList = cdrhadBean.findCdrlotList(h.getCdrhadPK().getFacno(), h.getCdrhadPK().getShpno());
            if (cdrlotList != null && !cdrlotList.isEmpty()) {
                shpnoList.add(h.getCdrhadPK().getShpno());
                for (Cdrlot l : cdrlotList) {
                    if (queryNoParts) {
                        if (l.getVarnr() == null || "".equals(l.getVarnr())) {
                            continue;
                        }
                    }
                    if (queryModel != null && !"".equals(queryModel)) {
                        if (!l.getCdrdta().getItnbrcus().contains(queryModel)) {
                            continue;
                        }
                    }
                    seq++;
                    sd = new ShipmentDetail();
                    sd.setSeq(seq);
                    sd.setShpno(h.getCdrhadPK().getShpno());
                    sd.setShpdate(h.getShpdate());
                    sd.setShpseq(l.getCdrlotPK().getTrseq());
                    sd.setItemno(l.getCdrdta().getItnbr());
                    if (sd.getItemno() != null) {
                        this.fileName = this.getAppResPath() + sd.getItemno() + ".png";
                        this.generateCode128(sd.getItemno(), 1.5f, 8d, fileName);
                        this.generateQRCode(sd.getItemno(), 300, 300, this.getAppResPath(), "QR" + sd.getItemno() + ".png");
                    }
                    sd.setItemDesc(l.getCdrdta().getItdsc());
                    sd.setItemModel(l.getCdrdta().getItnbrcus());
                    sd.setCustomerItem(l.getCdrdta().getMatecode());
                    sd.setCustomerItemDesc(l.getCdrdta().getCuslable());
                    sd.setLotseq(l.getCdrlotPK().getSeq());
                    sd.setVarnr(l.getVarnr());
                    if (sd.getCustomerItem() != null && !"".equals(sd.getCustomerItem())) {
                        // 客户物料条码
                        this.fileName = this.getAppResPath() + h.getCusno() + sd.getCustomerItem() + ".png";
                        this.generateCode128(sd.getCustomerItem(), 1.5f, 8d, fileName);
                        this.generateQRCode(sd.getCustomerItem(), 300, 300, this.getAppResPath(), "QR" + h.getCusno() + sd.getCustomerItem() + ".png");
                        // 客户MES条码
                        if (sd.getItemModel() != null && l.getVarnr() != null) {
                            StringBuilder content = new StringBuilder();
                            switch (h.getCusno()) {
                                case "SCQ00011":
                                    // 美的专属二维码
                                    content.append("A0007001").append("|").append(BaseLib.formatDate("yyyyMMdd", sd.getShpdate())).append("-").append(sd.getLotseq()).append("|")
                                            .append(sd.getVarnr()).append("|").append(sd.getCustomerItem()).append("|").append(sd.getItemModel());
                                    break;
                                case "SSD00103":
                                    // 海达瑞专属二维码
                                    content.append(sd.getCustomerItem()).append(".").append(sd.getVarnr()).append(".").append(sd.getItemModel()).append(".")
                                            .append(BaseLib.formatDate("yyyyMMdd", h.getShpdate())).append(".").append(sd.getCustomerItemDesc());
                                    break;
                                case "SSD00886":
                                    // 海达诚专属二维码
                                    content.append(sd.getCustomerItem()).append(".").append(sd.getVarnr()).append(".").append(sd.getItemModel()).append(".")
                                            .append(BaseLib.formatDate("yyyyMMdd", h.getShpdate())).append(".").append(sd.getCustomerItemDesc());
                                    break;
                                //冰山冷热专属二维码
                                case "SLN00028":
                                    content.append(sd.getCustomerItem()).append(" ").append(sd.getItemDesc()).append("|").append(sd.getItemModel());
                                    break;
                                //南京天加
                                case "SJS00309":
                                    content.append(sd.getCustomerItem()).append("| 1100000429| ").append(BaseLib.formatDate("yyyyMMdd", sd.getShpdate())).append(new DecimalFormat("00").format(sd.getLotseq()));
                                     content.append("|").append(sd.getVarnr()).append("|").append(sd.getItemModel());
                                    break;
                                case "SSD01036":
                                    // 海达源专属二维码
                                    content.append(sd.getCustomerItem()).append(".").append(sd.getVarnr()).append(".").append(sd.getItemModel()).append(".")
                                            .append(BaseLib.formatDate("yyyyMMdd", h.getShpdate())).append(".").append(sd.getCustomerItemDesc());
                                    break;
                                case "SSD00730":
                                    // 青岛海信日立
                                    content.append(sd.getCustomerItem().trim());
                                    if (content.length() != 8) {
                                        for (int i = 1; i <= 8 - sd.getCustomerItem().trim().length(); i++) {
                                            content.append("0");
                                        }
                                    }
                                    content.append(ShipmentPrintManagedBean.SSD00730Year.valueOf("YEAR" + BaseLib.formatDate("yyyy", sd.getShpdate())).getValue())
                                            .append(ShipmentPrintManagedBean.SSD00730Month.valueOf("MONTH" + Integer.valueOf(BaseLib.formatDate("MM", sd.getShpdate()))).getValue())
                                            .append(ShipmentPrintManagedBean.SSD00730Day.valueOf("DAY" + Integer.valueOf(BaseLib.formatDate("dd", sd.getShpdate()))).getValue()).append("200753").append(sd.getVarnr().substring(sd.getVarnr().length() - 4));
                                    break;
                                case "SHB00221":
                                    //三河同飞
                                    content.append(sd.getCustomerItem()).append("0200020").append(BaseLib.formatDate("yyMMdd", sd.getShpdate())).append("000").append(String.format("%04d", seq));
                                    break;
                                case "SGD00205":
                                    content.append(sd.getVarnr()).append(".").append(sd.getItemModel()).append(".")
                                            .append(BaseLib.formatDate("yyyyMMdd", sd.getShpdate()));
                                    break;
                            }
                            if (content.length() > 0) {
                                this.generateQRCode(content.toString(), 300, 300, this.getAppResPath(), "QR" + h.getCusno() + l.getVarnr() + ".png");
                            }
                        }
                    }
                    // 汉钟制造号码条码
                    if (l.getVarnr() != null && !"".equals(l.getVarnr())) {
                        this.fileName = this.getAppResPath() + l.getVarnr() + ".png";
                        this.generateCode128(l.getVarnr(), 1.5f, 8d, fileName);
                        this.generateQRCode(l.getVarnr(), 300, 300, this.getAppResPath(), "QR" + l.getVarnr() + ".png");
                    }
                    sd.setFixnr(l.getFixnr());
                    sd.setWareh(l.getWareh());
                    sd.setQty(l.getShpqy1());
                    sd.setRemark(shipAddress);
                    sd.setRelformid(l.getCdrdta().getCdrno());
                    sd.setRelseq(l.getCdrdta().getCtrseq().intValue());
                    // 加入明细新增列表
                    shipmentDetails.add(sd);
                }
            }
        }
        if (!shipmentDetails.isEmpty()) {
            try {
                s.setRemark(shpnoList.toString());
                formid = shipmentBean.initData(s, shipmentDetails);
                if (formid != null) {
                    this.cdrhadSelected.clear();
                    this.cdrhadList.clear();
                    showInfoMsg("Info", "成功生成出货明细" + formid);
                } else {
                    showErrorMsg("Error", "产生出货明细失败");
                }
            } catch (Exception ex) {
                showErrorMsg("Error", ex.getMessage());
            }
        } else {
            showErrorMsg("Error", "没有对应库存信息");
        }
    }

    /**
     * @return the cdrhadList
     */
    public List<Cdrhad> getCdrhadList() {
        return cdrhadList;
    }

    /**
     * @return the cdrhadSelected
     */
    public List<Cdrhad> getCdrhadSelected() {
        return cdrhadSelected;
    }

    /**
     * @param armbilSelected the cdrhadSelected to set
     */
    public void setCdrhadSelected(List<Cdrhad> armbilSelected) {
        this.cdrhadSelected = armbilSelected;
    }

    /**
     * @return the queryNoParts
     */
    public boolean isQueryNoParts() {
        return queryNoParts;
    }

    /**
     * @param queryNoParts the queryNoParts to set
     */
    public void setQueryNoParts(boolean queryNoParts) {
        this.queryNoParts = queryNoParts;
    }

    /**
     * @return the sortBy
     */
    public String getQueryModel() {
        return queryModel;
    }

    /**
     * @param queryModel the sortBy to set
     */
    public void setQueryModel(String queryModel) {
        this.queryModel = queryModel;
    }

    enum SSD00730Year {
        YEAR2022("B"), YEAR2023("A"), YEAR2024("9"), YEAR2025("8"), YEAR2026("7"), YEAR2027("6"),
        YEAR2028("5"), YEAR2029("4"), YEAR2030("3"), YEAR2031("2"), YEAR2032("1");
        String value;

        SSD00730Year(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    enum SSD00730Month {
        MONTH1("1"), MONTH2("A"), MONTH3("2"), MONTH4("B"), MONTH5("3"), MONTH6("C"),
        MONTH7("4"), MONTH8("D"), MONTH9("5"), MONTH10("E"), MONTH11("6"), MONTH12("F");
        String value;

        SSD00730Month(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    enum SSD00730Day {
        DAY1("1"), DAY2("2"), DAY3("3"), DAY4("4"), DAY5("5"), DAY6("6"),
        DAY7("7"), DAY8("8"), DAY9("9"), DAY10("A"), DAY11("B"), DAY12("C"),
        DAY13("D"), DAY14("E"), DAY15("F"), DAY16("G"), DAY17("H"), DAY18("J"),
        DAY19("K"), DAY20("L"), DAY21("M"), DAY22("N"), DAY23("P"), DAY24("Q"),
        DAY25("R"), DAY26("S"), DAY27("T"), DAY28("U"), DAY29("V"), DAY30("W"), DAY31("Y");
        String value;

        SSD00730Day(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
