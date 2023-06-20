/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.entity;

import cn.hanbell.oa.ejb.WorkFlowBean;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C2082
 */
@Entity
@Table(name = "HK_CW005")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKCW005.findAll", query = "SELECT h FROM HKCW005 h"),
    @NamedQuery(name = "HKCW005.findByFacno", query = "SELECT h FROM HKCW005 h WHERE h.facno = :facno"),
    @NamedQuery(name = "HKCW005.findByPSN", query = "SELECT h FROM HKCW005 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKCW005.findByJine", query = "SELECT h FROM HKCW005 h WHERE h.jine = :jine"),
    @NamedQuery(name = "HKCW005.findByCreatedate", query = "SELECT h FROM HKCW005 h WHERE h.createdate = :createdate"),
    @NamedQuery(name = "HKCW005.findByBttbankno", query = "SELECT h FROM HKCW005 h WHERE h.bttbankno = :bttbankno"),
    @NamedQuery(name = "HKCW005.findByPzzh", query = "SELECT h FROM HKCW005 h WHERE h.pzzh = :pzzh"),
    @NamedQuery(name = "HKCW005.findByLkr", query = "SELECT h FROM HKCW005 h WHERE h.lkr = :lkr"),
    @NamedQuery(name = "HKCW005.findByDx", query = "SELECT h FROM HKCW005 h WHERE h.dx = :dx"),
    @NamedQuery(name = "HKCW005.findByVdrd", query = "SELECT h FROM HKCW005 h WHERE h.vdrd = :vdrd"),
    @NamedQuery(name = "HKCW005.findByFSN", query = "SELECT h FROM HKCW005 h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKCW005.findByHdnmanager", query = "SELECT h FROM HKCW005 h WHERE h.hdnmanager = :hdnmanager"),
    @NamedQuery(name = "HKCW005.findByCreatetime", query = "SELECT h FROM HKCW005 h WHERE h.createtime = :createtime"),
    @NamedQuery(name = "HKCW005.findByFkxz", query = "SELECT h FROM HKCW005 h WHERE h.fkxz = :fkxz"),
    @NamedQuery(name = "HKCW005.findByDept", query = "SELECT h FROM HKCW005 h WHERE h.dept = :dept"),
    @NamedQuery(name = "HKCW005.findByVdrno", query = "SELECT h FROM HKCW005 h WHERE h.vdrno = :vdrno"),
    @NamedQuery(name = "HKCW005.findByOID", query = "SELECT h FROM HKCW005 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKCW005.findByEls", query = "SELECT h FROM HKCW005 h WHERE h.els = :els"),
    @NamedQuery(name = "HKCW005.findByApplyuser", query = "SELECT h FROM HKCW005 h WHERE h.applyuser = :applyuser"),
    @NamedQuery(name = "HKCW005.findByDeptno", query = "SELECT h FROM HKCW005 h WHERE h.deptno = :deptno"),
    @NamedQuery(name = "HKCW005.findByFkje", query = "SELECT h FROM HKCW005 h WHERE h.fkje = :fkje"),
    @NamedQuery(name = "HKCW005.findByKemu", query = "SELECT h FROM HKCW005 h WHERE h.kemu = :kemu"),
    @NamedQuery(name = "HKCW005.findBySerialNumber", query = "SELECT h FROM HKCW005 h WHERE h.serialNumber = :serialNumber"),
    @NamedQuery(name = "HKCW005.findByBeizhu", query = "SELECT h FROM HKCW005 h WHERE h.beizhu = :beizhu"),
    @NamedQuery(name = "HKCW005.findByBib", query = "SELECT h FROM HKCW005 h WHERE h.bib = :bib"),
    @NamedQuery(name = "HKCW005.findByFkfs", query = "SELECT h FROM HKCW005 h WHERE h.fkfs = :fkfs"),
    @NamedQuery(name = "HKCW005.findByZy", query = "SELECT h FROM HKCW005 h WHERE h.zy = :zy"),
    @NamedQuery(name = "HKCW005.findByEndDate", query = "SELECT h FROM HKCW005 h WHERE h.endDate = :endDate"),
    @NamedQuery(name = "HKCW005.findByCashBalance", query = "SELECT h FROM HKCW005 h WHERE h.cashBalance = :cashBalance"),
    @NamedQuery(name = "HKCW005.findByBankBalance", query = "SELECT h FROM HKCW005 h WHERE h.bankBalance = :bankBalance"),
    @NamedQuery(name = "HKCW005.findByContractno", query = "SELECT h FROM HKCW005 h WHERE h.contractno = :contractno"),
    @NamedQuery(name = "HKCW005.findByApplyType", query = "SELECT h FROM HKCW005 h WHERE h.applyType = :applyType"),
    @NamedQuery(name = "HKCW005.findByLongterm", query = "SELECT h FROM HKCW005 h WHERE h.longterm = :longterm"),
    @NamedQuery(name = "HKCW005.findByZjother", query = "SELECT h FROM HKCW005 h WHERE h.zjother = :zjother"),
    @NamedQuery(name = "HKCW005.findByBondtype", query = "SELECT h FROM HKCW005 h WHERE h.bondtype = :bondtype"),
    @NamedQuery(name = "HKCW005.findByFinancialProduct", query = "SELECT h FROM HKCW005 h WHERE h.financialProduct = :financialProduct"),
    @NamedQuery(name = "HKCW005.findByPaymentTerms4", query = "SELECT h FROM HKCW005 h WHERE h.paymentTerms4 = :paymentTerms4"),
    @NamedQuery(name = "HKCW005.findByPaymentTerms3", query = "SELECT h FROM HKCW005 h WHERE h.paymentTerms3 = :paymentTerms3"),
    @NamedQuery(name = "HKCW005.findByPaymentTerms2", query = "SELECT h FROM HKCW005 h WHERE h.paymentTerms2 = :paymentTerms2"),
    @NamedQuery(name = "HKCW005.findByPaymentTerms1", query = "SELECT h FROM HKCW005 h WHERE h.paymentTerms1 = :paymentTerms1"),
    @NamedQuery(name = "HKCW005.findByFundtype", query = "SELECT h FROM HKCW005 h WHERE h.fundtype = :fundtype"),
    @NamedQuery(name = "HKCW005.findByProjectname", query = "SELECT h FROM HKCW005 h WHERE h.projectname = :projectname"),
    @NamedQuery(name = "HKCW005.findBySubscribeAmount1", query = "SELECT h FROM HKCW005 h WHERE h.subscribeAmount1 = :subscribeAmount1"),
    @NamedQuery(name = "HKCW005.findByAnalysis", query = "SELECT h FROM HKCW005 h WHERE h.analysis = :analysis"),
    @NamedQuery(name = "HKCW005.findByTotalinvestment", query = "SELECT h FROM HKCW005 h WHERE h.totalinvestment = :totalinvestment"),
    @NamedQuery(name = "HKCW005.findByOtherstock", query = "SELECT h FROM HKCW005 h WHERE h.otherstock = :otherstock"),
    @NamedQuery(name = "HKCW005.findBySubscribeAmount2", query = "SELECT h FROM HKCW005 h WHERE h.subscribeAmount2 = :subscribeAmount2"),
    @NamedQuery(name = "HKCW005.findBySubscribeAmount3", query = "SELECT h FROM HKCW005 h WHERE h.subscribeAmount3 = :subscribeAmount3"),
    @NamedQuery(name = "HKCW005.findByOptiontype", query = "SELECT h FROM HKCW005 h WHERE h.optiontype = :optiontype"),
    @NamedQuery(name = "HKCW005.findByZjapplytype", query = "SELECT h FROM HKCW005 h WHERE h.zjapplytype = :zjapplytype"),
    @NamedQuery(name = "HKCW005.findByInvestmentObject", query = "SELECT h FROM HKCW005 h WHERE h.investmentObject = :investmentObject"),
    @NamedQuery(name = "HKCW005.findByBondrate", query = "SELECT h FROM HKCW005 h WHERE h.bondrate = :bondrate"),
    @NamedQuery(name = "HKCW005.findByRemainingAmount", query = "SELECT h FROM HKCW005 h WHERE h.remainingAmount = :remainingAmount"),
    @NamedQuery(name = "HKCW005.findByLegalRepresentative", query = "SELECT h FROM HKCW005 h WHERE h.legalRepresentative = :legalRepresentative"),
    @NamedQuery(name = "HKCW005.findByStockprice", query = "SELECT h FROM HKCW005 h WHERE h.stockprice = :stockprice"),
    @NamedQuery(name = "HKCW005.findByAmount4", query = "SELECT h FROM HKCW005 h WHERE h.amount4 = :amount4"),
    @NamedQuery(name = "HKCW005.findByInterestrate", query = "SELECT h FROM HKCW005 h WHERE h.interestrate = :interestrate"),
    @NamedQuery(name = "HKCW005.findByAmount3", query = "SELECT h FROM HKCW005 h WHERE h.amount3 = :amount3"),
    @NamedQuery(name = "HKCW005.findByTerm2", query = "SELECT h FROM HKCW005 h WHERE h.term2 = :term2"),
    @NamedQuery(name = "HKCW005.findByAmount2", query = "SELECT h FROM HKCW005 h WHERE h.amount2 = :amount2"),
    @NamedQuery(name = "HKCW005.findByRate", query = "SELECT h FROM HKCW005 h WHERE h.rate = :rate"),
    @NamedQuery(name = "HKCW005.findByRegisteredCapital", query = "SELECT h FROM HKCW005 h WHERE h.registeredCapital = :registeredCapital"),
    @NamedQuery(name = "HKCW005.findByAmount1", query = "SELECT h FROM HKCW005 h WHERE h.amount1 = :amount1"),
    @NamedQuery(name = "HKCW005.findByNetworth", query = "SELECT h FROM HKCW005 h WHERE h.networth = :networth"),
    @NamedQuery(name = "HKCW005.findByOtherbond", query = "SELECT h FROM HKCW005 h WHERE h.otherbond = :otherbond"),
    @NamedQuery(name = "HKCW005.findByOtherfund", query = "SELECT h FROM HKCW005 h WHERE h.otherfund = :otherfund"),
    @NamedQuery(name = "HKCW005.findByDeadline", query = "SELECT h FROM HKCW005 h WHERE h.deadline = :deadline"),
    @NamedQuery(name = "HKCW005.findByDeliveryDate", query = "SELECT h FROM HKCW005 h WHERE h.deliveryDate = :deliveryDate"),
    @NamedQuery(name = "HKCW005.findByOther1", query = "SELECT h FROM HKCW005 h WHERE h.other1 = :other1"),
    @NamedQuery(name = "HKCW005.findByOther3", query = "SELECT h FROM HKCW005 h WHERE h.other3 = :other3"),
    @NamedQuery(name = "HKCW005.findByOther2", query = "SELECT h FROM HKCW005 h WHERE h.other2 = :other2"),
    @NamedQuery(name = "HKCW005.findBySubscribeNumber3", query = "SELECT h FROM HKCW005 h WHERE h.subscribeNumber3 = :subscribeNumber3"),
    @NamedQuery(name = "HKCW005.findBySubscribeNumber1", query = "SELECT h FROM HKCW005 h WHERE h.subscribeNumber1 = :subscribeNumber1"),
    @NamedQuery(name = "HKCW005.findByShareholding", query = "SELECT h FROM HKCW005 h WHERE h.shareholding = :shareholding"),
    @NamedQuery(name = "HKCW005.findByRisklevel", query = "SELECT h FROM HKCW005 h WHERE h.risklevel = :risklevel"),
    @NamedQuery(name = "HKCW005.findByAllamount", query = "SELECT h FROM HKCW005 h WHERE h.allamount = :allamount"),
    @NamedQuery(name = "HKCW005.findByPaydate1", query = "SELECT h FROM HKCW005 h WHERE h.paydate1 = :paydate1"),
    @NamedQuery(name = "HKCW005.findByPaydate3", query = "SELECT h FROM HKCW005 h WHERE h.paydate3 = :paydate3"),
    @NamedQuery(name = "HKCW005.findByStocktype", query = "SELECT h FROM HKCW005 h WHERE h.stocktype = :stocktype"),
    @NamedQuery(name = "HKCW005.findByPaydate2", query = "SELECT h FROM HKCW005 h WHERE h.paydate2 = :paydate2"),
    @NamedQuery(name = "HKCW005.findByPaydate4", query = "SELECT h FROM HKCW005 h WHERE h.paydate4 = :paydate4"),
    @NamedQuery(name = "HKCW005.findByCategory", query = "SELECT h FROM HKCW005 h WHERE h.category = :category"),
    @NamedQuery(name = "HKCW005.findByStockInvestment", query = "SELECT h FROM HKCW005 h WHERE h.stockInvestment = :stockInvestment"),
    @NamedQuery(name = "HKCW005.findByOtherDescription", query = "SELECT h FROM HKCW005 h WHERE h.otherDescription = :otherDescription")})
public class HKCW005 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "jine")
    private Double jine;
    @Column(name = "createdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;
    @Size(max = 255)
    @Column(name = "bttbankno")
    private String bttbankno;
    @Size(max = 255)
    @Column(name = "pzzh")
    private String pzzh;
    @Size(max = 255)
    @Column(name = "lkr")
    private String lkr;
    @Size(max = 255)
    @Column(name = "dx")
    private String dx;
    @Size(max = 255)
    @Column(name = "vdrd")
    private String vdrd;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "hdnmanager")
    private String hdnmanager;
    @Column(name = "createtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createtime;
    @Size(max = 255)
    @Column(name = "fkxz")
    private String fkxz;
    @Size(max = 255)
    @Column(name = "fkxz2")
    private String fkxz2;
    @Size(max = 255)
    @Column(name = "dept")
    private String dept;
    @Size(max = 255)
    @Column(name = "vdrno")
    private String vdrno;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "els")
    private String els;
    @Size(max = 255)
    @Column(name = "applyuser")
    private String applyuser;
    @Size(max = 255)
    @Column(name = "deptno")
    private String deptno;
    @Column(name = "fkje")
    private Double fkje;
    @Size(max = 255)
    @Column(name = "kemu")
    private String kemu;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "beizhu")
    private String beizhu;
    @Size(max = 255)
    @Column(name = "bib")
    private String bib;
    @Size(max = 255)
    @Column(name = "fkfs")
    private String fkfs;
    @Size(max = 255)
    @Column(name = "zy")
    private String zy;
    @Column(name = "endDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Size(max = 255)
    @Column(name = "cashBalance")
    private String cashBalance;
    @Size(max = 255)
    @Column(name = "bankBalance")
    private String bankBalance;
    @Size(max = 255)
    @Column(name = "contractno")
    private String contractno;
    @Size(max = 255)
    @Column(name = "applyType")
    private String applyType;
    @Size(max = 255)
    @Column(name = "longterm")
    private String longterm;
    @Size(max = 255)
    @Column(name = "zjother")
    private String zjother;
    @Size(max = 255)
    @Column(name = "bondtype")
    private String bondtype;
    @Size(max = 255)
    @Column(name = "financialProduct")
    private String financialProduct;
    @Size(max = 255)
    @Column(name = "paymentTerms4")
    private String paymentTerms4;
    @Size(max = 255)
    @Column(name = "paymentTerms3")
    private String paymentTerms3;
    @Size(max = 255)
    @Column(name = "paymentTerms2")
    private String paymentTerms2;
    @Size(max = 255)
    @Column(name = "paymentTerms1")
    private String paymentTerms1;
    @Size(max = 255)
    @Column(name = "fundtype")
    private String fundtype;
    @Size(max = 255)
    @Column(name = "projectname")
    private String projectname;
    @Size(max = 255)
    @Column(name = "subscribeAmount1")
    private String subscribeAmount1;
    @Size(max = 255)
    @Column(name = "analysis")
    private String analysis;
    @Column(name = "totalinvestment")
    private Double totalinvestment;
    @Size(max = 255)
    @Column(name = "otherstock")
    private String otherstock;
    @Size(max = 255)
    @Column(name = "subscribeAmount2")
    private String subscribeAmount2;
    @Size(max = 255)
    @Column(name = "subscribeAmount3")
    private String subscribeAmount3;
    @Size(max = 255)
    @Column(name = "optiontype")
    private String optiontype;
    @Size(max = 255)
    @Column(name = "zjapplytype")
    private String zjapplytype;
    @Size(max = 255)
    @Column(name = "investmentObject")
    private String investmentObject;
    @Size(max = 255)
    @Column(name = "bondrate")
    private String bondrate;
    @Column(name = "remainingAmount")
    private Double remainingAmount;
    @Size(max = 255)
    @Column(name = "legalRepresentative")
    private String legalRepresentative;
    @Size(max = 255)
    @Column(name = "stockprice")
    private String stockprice;
    @Column(name = "amount4")
    private Double amount4;
    @Size(max = 255)
    @Column(name = "interestrate")
    private String interestrate;
    @Column(name = "amount3")
    private Double amount3;
    @Size(max = 255)
    @Column(name = "term2")
    private String term2;
    @Column(name = "amount2")
    private Double amount2;
    @Size(max = 255)
    @Column(name = "rate")
    private String rate;
    @Column(name = "registeredCapital")
    private Double registeredCapital;
    @Column(name = "amount1")
    private Double amount1;
    @Size(max = 255)
    @Column(name = "networth")
    private String networth;
    @Size(max = 255)
    @Column(name = "otherbond")
    private String otherbond;
    @Size(max = 255)
    @Column(name = "otherfund")
    private String otherfund;
    @Size(max = 255)
    @Column(name = "deadline")
    private String deadline;
    @Size(max = 255)
    @Column(name = "deliveryDate")
    private String deliveryDate;
    @Size(max = 255)
    @Column(name = "other1")
    private String other1;
    @Size(max = 255)
    @Column(name = "other3")
    private String other3;
    @Size(max = 255)
    @Column(name = "other2")
    private String other2;
    @Size(max = 255)
    @Column(name = "subscribeNumber3")
    private String subscribeNumber3;
    @Size(max = 255)
    @Column(name = "subscribeNumber1")
    private String subscribeNumber1;
    @Size(max = 255)
    @Column(name = "shareholding")
    private String shareholding;
    @Size(max = 255)
    @Column(name = "risklevel")
    private String risklevel;
    @Column(name = "allamount")
    private Double allamount;
    @Column(name = "paydate1")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paydate1;
    @Column(name = "paydate3")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paydate3;
    @Size(max = 255)
    @Column(name = "stocktype")
    private String stocktype;
    @Column(name = "paydate2")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paydate2;
    @Column(name = "paydate4")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paydate4;
    @Size(max = 255)
    @Column(name = "category")
    private String category;
    @Size(max = 255)
    @Column(name = "stockInvestment")
    private String stockInvestment;
    @Size(max = 255)
    @Column(name = "otherDescription")
    private String otherDescription;
    @Column(name = "amount5")
    private Double amount5;
    @Column(name = "paydate5")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paydate5;
    @Size(max = 255)
    @Column(name = "paymentTerms5")
    private String paymentTerms5;
    @Column(name = "amount6")
    private Double amount6;
    @Column(name = "paydate6")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paydate6;
    @Size(max = 255)
    @Column(name = "paymentTerms6")
    private String paymentTerms6;

    @JoinColumn(name = "lkr", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private Users user;
    
    @Size(max = 255)
    @Column(name = "storageType")
    private String storageType;
    @Size(max = 255)
    @Column(name = "storageType1")
    private String storageType1;
    @Size(max = 255)
    @Column(name = "storageType2")
    private String storageType2;
    @Size(max = 255)
    @Column(name = "storageType3")
    private String storageType3;
    @Size(max = 255)
    @Column(name = "storageType4")
    private String storageType4;
    @Size(max = 255)
    @Column(name = "dcOther")
    private String dcOther;
    @Size(max = 255)
    @Column(name = "deadline2")
    private String deadline2;
    @Size(max = 255)
    @Column(name = "bondrate2")
  private String bondrate2;
    public HKCW005() {
    }

    public HKCW005(String oid) {
        this.oid = oid;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public Double getJine() {
        return jine;
    }

    public void setJine(Double jine) {
        this.jine = jine;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getBttbankno() {
        return bttbankno;
    }

    public void setBttbankno(String bttbankno) {
        this.bttbankno = bttbankno;
    }

    public String getPzzh() {
        return pzzh;
    }

    public void setPzzh(String pzzh) {
        this.pzzh = pzzh;
    }

    public String getLkr() {
        return lkr;
    }

    public void setLkr(String lkr) {
        this.lkr = lkr;
    }

    public String getDx() {
        return dx;
    }

    public void setDx(String dx) {
        this.dx = dx;
    }

    public String getVdrd() {
        return vdrd;
    }

    public void setVdrd(String vdrd) {
        this.vdrd = vdrd;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getHdnmanager() {
        return hdnmanager;
    }

    public void setHdnmanager(String hdnmanager) {
        this.hdnmanager = hdnmanager;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getFkxz() {
        return fkxz;
    }

    public void setFkxz(String fkxz) {
        this.fkxz = fkxz;
    }

    public String getFkxz2() {
        return fkxz2;
    }

    public void setFkxz2(String fkxz2) {
        this.fkxz2 = fkxz2;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getVdrno() {
        return vdrno;
    }

    public void setVdrno(String vdrno) {
        this.vdrno = vdrno;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getEls() {
        return els;
    }

    public void setEls(String els) {
        this.els = els;
    }

    public String getApplyuser() {
        return applyuser;
    }

    public void setApplyuser(String applyuser) {
        this.applyuser = applyuser;
    }

    public String getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    public Double getFkje() {
        return fkje;
    }

    public void setFkje(Double fkje) {
        this.fkje = fkje;
    }

    public String getKemu() {
        return kemu;
    }

    public void setKemu(String kemu) {
        this.kemu = kemu;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public String getBib() {
        return bib;
    }

    public void setBib(String bib) {
        this.bib = bib;
    }

    public String getFkfs() {
        return fkfs;
    }

    public void setFkfs(String fkfs) {
        this.fkfs = fkfs;
    }

    public String getZy() {
        return zy;
    }

    public void setZy(String zy) {
        this.zy = zy;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCashBalance() {
        return cashBalance;
    }

    public void setCashBalance(String cashBalance) {
        this.cashBalance = cashBalance;
    }

    public String getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(String bankBalance) {
        this.bankBalance = bankBalance;
    }

    public String getContractno() {
        return contractno;
    }

    public void setContractno(String contractno) {
        this.contractno = contractno;
    }

    public String getApplyType() {
        return applyType;
    }

    public void setApplyType(String applyType) {
        this.applyType = applyType;
    }

    public String getLongterm() {
        return longterm;
    }

    public void setLongterm(String longterm) {
        this.longterm = longterm;
    }

    public String getZjother() {
        return zjother;
    }

    public void setZjother(String zjother) {
        this.zjother = zjother;
    }

    public String getBondtype() {
        return bondtype;
    }

    public void setBondtype(String bondtype) {
        this.bondtype = bondtype;
    }

    public String getFinancialProduct() {
        return financialProduct;
    }

    public void setFinancialProduct(String financialProduct) {
        this.financialProduct = financialProduct;
    }

    public String getPaymentTerms4() {
        return paymentTerms4;
    }

    public void setPaymentTerms4(String paymentTerms4) {
        this.paymentTerms4 = paymentTerms4;
    }

    public String getPaymentTerms3() {
        return paymentTerms3;
    }

    public void setPaymentTerms3(String paymentTerms3) {
        this.paymentTerms3 = paymentTerms3;
    }

    public String getPaymentTerms2() {
        return paymentTerms2;
    }

    public void setPaymentTerms2(String paymentTerms2) {
        this.paymentTerms2 = paymentTerms2;
    }

    public String getPaymentTerms1() {
        return paymentTerms1;
    }

    public void setPaymentTerms1(String paymentTerms1) {
        this.paymentTerms1 = paymentTerms1;
    }

    public String getFundtype() {
        return fundtype;
    }

    public void setFundtype(String fundtype) {
        this.fundtype = fundtype;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getSubscribeAmount1() {
        return subscribeAmount1;
    }

    public void setSubscribeAmount1(String subscribeAmount1) {
        this.subscribeAmount1 = subscribeAmount1;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public Double getTotalinvestment() {
        return totalinvestment;
    }

    public void setTotalinvestment(Double totalinvestment) {
        this.totalinvestment = totalinvestment;
    }

    public String getOtherstock() {
        return otherstock;
    }

    public void setOtherstock(String otherstock) {
        this.otherstock = otherstock;
    }

    public String getSubscribeAmount2() {
        return subscribeAmount2;
    }

    public void setSubscribeAmount2(String subscribeAmount2) {
        this.subscribeAmount2 = subscribeAmount2;
    }

    public String getSubscribeAmount3() {
        return subscribeAmount3;
    }

    public void setSubscribeAmount3(String subscribeAmount3) {
        this.subscribeAmount3 = subscribeAmount3;
    }

    public String getOptiontype() {
        return optiontype;
    }

    public void setOptiontype(String optiontype) {
        this.optiontype = optiontype;
    }

    public String getZjapplytype() {
        return zjapplytype;
    }

    public void setZjapplytype(String zjapplytype) {
        this.zjapplytype = zjapplytype;
    }

    public String getInvestmentObject() {
        return investmentObject;
    }

    public void setInvestmentObject(String investmentObject) {
        this.investmentObject = investmentObject;
    }

    public String getBondrate() {
        return bondrate;
    }

    public void setBondrate(String bondrate) {
        this.bondrate = bondrate;
    }

    public Double getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(Double remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public String getStockprice() {
        return stockprice;
    }

    public void setStockprice(String stockprice) {
        this.stockprice = stockprice;
    }

    public Double getAmount4() {
        return amount4;
    }

    public void setAmount4(Double amount4) {
        this.amount4 = amount4;
    }

    public String getInterestrate() {
        return interestrate;
    }

    public void setInterestrate(String interestrate) {
        this.interestrate = interestrate;
    }

    public Double getAmount3() {
        return amount3;
    }

    public void setAmount3(Double amount3) {
        this.amount3 = amount3;
    }

    public String getTerm2() {
        return term2;
    }

    public void setTerm2(String term2) {
        this.term2 = term2;
    }

    public Double getAmount2() {
        return amount2;
    }

    public void setAmount2(Double amount2) {
        this.amount2 = amount2;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public Double getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(Double registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public Double getAmount1() {
        return amount1;
    }

    public void setAmount1(Double amount1) {
        this.amount1 = amount1;
    }

    public String getNetworth() {
        return networth;
    }

    public void setNetworth(String networth) {
        this.networth = networth;
    }

    public String getOtherbond() {
        return otherbond;
    }

    public void setOtherbond(String otherbond) {
        this.otherbond = otherbond;
    }

    public String getOtherfund() {
        return otherfund;
    }

    public void setOtherfund(String otherfund) {
        this.otherfund = otherfund;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getOther1() {
        return other1;
    }

    public void setOther1(String other1) {
        this.other1 = other1;
    }

    public String getOther3() {
        return other3;
    }

    public void setOther3(String other3) {
        this.other3 = other3;
    }

    public String getOther2() {
        return other2;
    }

    public void setOther2(String other2) {
        this.other2 = other2;
    }

    public String getSubscribeNumber3() {
        return subscribeNumber3;
    }

    public void setSubscribeNumber3(String subscribeNumber3) {
        this.subscribeNumber3 = subscribeNumber3;
    }

    public String getSubscribeNumber1() {
        return subscribeNumber1;
    }

    public void setSubscribeNumber1(String subscribeNumber1) {
        this.subscribeNumber1 = subscribeNumber1;
    }

    public String getShareholding() {
        return shareholding;
    }

    public void setShareholding(String shareholding) {
        this.shareholding = shareholding;
    }

    public String getRisklevel() {
        return risklevel;
    }

    public void setRisklevel(String risklevel) {
        this.risklevel = risklevel;
    }

    public Double getAllamount() {
        return allamount;
    }

    public void setAllamount(Double allamount) {
        this.allamount = allamount;
    }

    public Date getPaydate1() {
        return paydate1;
    }

    public void setPaydate1(Date paydate1) {
        this.paydate1 = paydate1;
    }

    public Date getPaydate3() {
        return paydate3;
    }

    public void setPaydate3(Date paydate3) {
        this.paydate3 = paydate3;
    }

    public String getStocktype() {
        return stocktype;
    }

    public void setStocktype(String stocktype) {
        this.stocktype = stocktype;
    }

    public Date getPaydate2() {
        return paydate2;
    }

    public void setPaydate2(Date paydate2) {
        this.paydate2 = paydate2;
    }

    public Date getPaydate4() {
        return paydate4;
    }

    public void setPaydate4(Date paydate4) {
        this.paydate4 = paydate4;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStockInvestment() {
        return stockInvestment;
    }

    public void setStockInvestment(String stockInvestment) {
        this.stockInvestment = stockInvestment;
    }

    public String getOtherDescription() {
        return otherDescription;
    }

    public void setOtherDescription(String otherDescription) {
        this.otherDescription = otherDescription;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Double getAmount5() {
        return amount5;
    }

    public void setAmount5(Double amount5) {
        this.amount5 = amount5;
    }

    public Date getPaydate5() {
        return paydate5;
    }

    public void setPaydate5(Date paydate5) {
        this.paydate5 = paydate5;
    }

    public String getPaymentTerms5() {
        return paymentTerms5;
    }

    public void setPaymentTerms5(String paymentTerms5) {
        this.paymentTerms5 = paymentTerms5;
    }

    public Double getAmount6() {
        return amount6;
    }

    public void setAmount6(Double amount6) {
        this.amount6 = amount6;
    }

    public Date getPaydate6() {
        return paydate6;
    }

    public void setPaydate6(Date paydate6) {
        this.paydate6 = paydate6;
    }

    public String getPaymentTerms6() {
        return paymentTerms6;
    }

    public void setPaymentTerms6(String paymentTerms6) {
        this.paymentTerms6 = paymentTerms6;
    }

    public String getStorageType() {
        return storageType;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    public String getStorageType1() {
        return storageType1;
    }

    public void setStorageType1(String storageType1) {
        this.storageType1 = storageType1;
    }

    public String getStorageType2() {
        return storageType2;
    }

    public void setStorageType2(String storageType2) {
        this.storageType2 = storageType2;
    }

    public String getStorageType3() {
        return storageType3;
    }

    public void setStorageType3(String storageType3) {
        this.storageType3 = storageType3;
    }

    public String getStorageType4() {
        return storageType4;
    }

    public void setStorageType4(String storageType4) {
        this.storageType4 = storageType4;
    }

    public String getDcOther() {
        return dcOther;
    }

    public void setDcOther(String dcOther) {
        this.dcOther = dcOther;
    }

    public String getDeadline2() {
        return deadline2;
    }

    public void setDeadline2(String deadline2) {
        this.deadline2 = deadline2;
    }

    public String getBondrate2() {
        return bondrate2;
    }

    public void setBondrate2(String bondrate2) {
        this.bondrate2 = bondrate2;
    }

    public String getCompanyName() {
        WorkFlowBean WorkFlowBean = new WorkFlowBean();
        return WorkFlowBean.getCompanyName(this.facno);
    }

    public String getBibName() {
        switch (this.bib) {
            case "1":
                return "人民币";
            case "2":
                return "美元";
            case "3":
                return "日元";
            case "4":
                return "欧元";
            case "5":
                return "英镑";
            case "6":
                return "卢币";
            case "7":
                return "越南盾";
            case "8":
                return "台币";
            case "9":
                return "港币";
            case "10":
                return this.els;
        }
        return "";
    }

    public String getCategoryValue() {
        switch (this.category) {
            case "1":
                return "全资";
            case "2":
                return "控股";
            case "3":
                return "参股";
            case "4":
                return "其他";
        }
        return "";
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oid != null ? oid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HKCW005)) {
            return false;
        }
        HKCW005 other = (HKCW005) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKCW005[ oid=" + oid + " ]";
    }

}
