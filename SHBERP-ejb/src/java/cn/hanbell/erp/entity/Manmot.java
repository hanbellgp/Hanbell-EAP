/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "manmot")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Manmot.findAll", query = "SELECT m FROM Manmot m"),
    @NamedQuery(name = "Manmot.findByFacno", query = "SELECT m FROM Manmot m WHERE m.manmotPK.facno = :facno"),
    @NamedQuery(name = "Manmot.findByProno", query = "SELECT m FROM Manmot m WHERE m.manmotPK.prono = :prono"),
    @NamedQuery(name = "Manmot.findByManno", query = "SELECT m FROM Manmot m WHERE m.manmotPK.manno = :manno"),
    @NamedQuery(name = "Manmot.findByLinecode", query = "SELECT m FROM Manmot m WHERE m.linecode = :linecode"),
    @NamedQuery(name = "Manmot.findByItnbrf", query = "SELECT m FROM Manmot m WHERE m.itnbrf = :itnbrf"),
    @NamedQuery(name = "Manmot.findByCusno", query = "SELECT m FROM Manmot m WHERE m.cusno = :cusno"),
    @NamedQuery(name = "Manmot.findByMankind", query = "SELECT m FROM Manmot m WHERE m.mankind = :mankind"),
    @NamedQuery(name = "Manmot.findByManstatus", query = "SELECT m FROM Manmot m WHERE m.manstatus = :manstatus"),
    @NamedQuery(name = "Manmot.findByManqty", query = "SELECT m FROM Manmot m WHERE m.manqty = :manqty"),
    @NamedQuery(name = "Manmot.findByMandate", query = "SELECT m FROM Manmot m WHERE m.mandate = :mandate"),
    @NamedQuery(name = "Manmot.findByTypecode", query = "SELECT m FROM Manmot m WHERE m.typecode = :typecode"),
    @NamedQuery(name = "Manmot.findByIssdate", query = "SELECT m FROM Manmot m WHERE m.issdate = :issdate"),
    @NamedQuery(name = "Manmot.findByMrpqty", query = "SELECT m FROM Manmot m WHERE m.mrpqty = :mrpqty"),
    @NamedQuery(name = "Manmot.findByMrpdate", query = "SELECT m FROM Manmot m WHERE m.mrpdate = :mrpdate"),
    @NamedQuery(name = "Manmot.findByMrpnr", query = "SELECT m FROM Manmot m WHERE m.mrpnr = :mrpnr"),
    @NamedQuery(name = "Manmot.findByBatnr", query = "SELECT m FROM Manmot m WHERE m.batnr = :batnr"),
    @NamedQuery(name = "Manmot.findByManlotno", query = "SELECT m FROM Manmot m WHERE m.manlotno = :manlotno"),
    @NamedQuery(name = "Manmot.findByItnbrh", query = "SELECT m FROM Manmot m WHERE m.itnbrh = :itnbrh"),
    @NamedQuery(name = "Manmot.findByRefno", query = "SELECT m FROM Manmot m WHERE m.refno = :refno"),
    @NamedQuery(name = "Manmot.findByRefseq", query = "SELECT m FROM Manmot m WHERE m.refseq = :refseq"),
    @NamedQuery(name = "Manmot.findByRemark1", query = "SELECT m FROM Manmot m WHERE m.remark1 = :remark1"),
    @NamedQuery(name = "Manmot.findByRemark2", query = "SELECT m FROM Manmot m WHERE m.remark2 = :remark2"),
    @NamedQuery(name = "Manmot.findByDecode", query = "SELECT m FROM Manmot m WHERE m.decode = :decode"),
    @NamedQuery(name = "Manmot.findByVdrno", query = "SELECT m FROM Manmot m WHERE m.vdrno = :vdrno"),
    @NamedQuery(name = "Manmot.findByUnpris", query = "SELECT m FROM Manmot m WHERE m.unpris = :unpris"),
    @NamedQuery(name = "Manmot.findByCoin", query = "SELECT m FROM Manmot m WHERE m.coin = :coin"),
    @NamedQuery(name = "Manmot.findByRatio", query = "SELECT m FROM Manmot m WHERE m.ratio = :ratio"),
    @NamedQuery(name = "Manmot.findByBuyer", query = "SELECT m FROM Manmot m WHERE m.buyer = :buyer"),
    @NamedQuery(name = "Manmot.findByKeyindate", query = "SELECT m FROM Manmot m WHERE m.keyindate = :keyindate"),
    @NamedQuery(name = "Manmot.findByUserno", query = "SELECT m FROM Manmot m WHERE m.userno = :userno"),
    @NamedQuery(name = "Manmot.findByCdrcode", query = "SELECT m FROM Manmot m WHERE m.cdrcode = :cdrcode"),
    @NamedQuery(name = "Manmot.findByLowlevel", query = "SELECT m FROM Manmot m WHERE m.lowlevel = :lowlevel"),
    @NamedQuery(name = "Manmot.findByAddcode", query = "SELECT m FROM Manmot m WHERE m.addcode = :addcode"),
    @NamedQuery(name = "Manmot.findByCfmdate", query = "SELECT m FROM Manmot m WHERE m.cfmdate = :cfmdate"),
    @NamedQuery(name = "Manmot.findByCfmuserno", query = "SELECT m FROM Manmot m WHERE m.cfmuserno = :cfmuserno"),
    @NamedQuery(name = "Manmot.findByMandateo", query = "SELECT m FROM Manmot m WHERE m.mandateo = :mandateo"),
    @NamedQuery(name = "Manmot.findByTax", query = "SELECT m FROM Manmot m WHERE m.tax = :tax"),
    @NamedQuery(name = "Manmot.findByTaxrate", query = "SELECT m FROM Manmot m WHERE m.taxrate = :taxrate"),
    @NamedQuery(name = "Manmot.findByItcls", query = "SELECT m FROM Manmot m WHERE m.itcls = :itcls"),
    @NamedQuery(name = "Manmot.findByMrptype", query = "SELECT m FROM Manmot m WHERE m.mrptype = :mrptype"),
    @NamedQuery(name = "Manmot.findByNormalaccdate", query = "SELECT m FROM Manmot m WHERE m.normalaccdate = :normalaccdate"),
    @NamedQuery(name = "Manmot.findByPosrccode", query = "SELECT m FROM Manmot m WHERE m.posrccode = :posrccode"),
    @NamedQuery(name = "Manmot.findByPredict", query = "SELECT m FROM Manmot m WHERE m.predict = :predict"),
    @NamedQuery(name = "Manmot.findByEccode", query = "SELECT m FROM Manmot m WHERE m.eccode = :eccode"),
    @NamedQuery(name = "Manmot.findByOastatus", query = "SELECT m FROM Manmot m WHERE m.oastatus = :oastatus"),
    @NamedQuery(name = "Manmot.findByOapsn", query = "SELECT m FROM Manmot m WHERE m.oapsn = :oapsn"),
    @NamedQuery(name = "Manmot.findByOauserno", query = "SELECT m FROM Manmot m WHERE m.oauserno = :oauserno"),
    @NamedQuery(name = "Manmot.findByOadate", query = "SELECT m FROM Manmot m WHERE m.oadate = :oadate")})
public class Manmot implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ManmotPK manmotPK;
    @Size(max = 3)
    @Column(name = "linecode")
    private String linecode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "itnbrf")
    private String itnbrf;
    @Size(max = 8)
    @Column(name = "cusno")
    private String cusno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "mankind")
    private String mankind;
    @Basic(optional = false)
    @NotNull
    @Column(name = "manstatus")
    private Character manstatus;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "manqty")
    private BigDecimal manqty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mandate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mandate;
    @Size(max = 2)
    @Column(name = "typecode")
    private String typecode;
    @Column(name = "issdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date issdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mrpqty")
    private BigDecimal mrpqty;
    @Column(name = "mrpdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mrpdate;
    @Size(max = 10)
    @Column(name = "mrpnr")
    private String mrpnr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "batnr")
    private String batnr;
    @Size(max = 18)
    @Column(name = "manlotno")
    private String manlotno;
    @Size(max = 20)
    @Column(name = "itnbrh")
    private String itnbrh;
    @Size(max = 18)
    @Column(name = "refno")
    private String refno;
    @Column(name = "refseq")
    private Short refseq;
    @Size(max = 8)
    @Column(name = "remark1")
    private String remark1;
    @Size(max = 8)
    @Column(name = "remark2")
    private String remark2;
    @Column(name = "decode")
    private Character decode;
    @Size(max = 8)
    @Column(name = "vdrno")
    private String vdrno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unpris")
    private BigDecimal unpris;
    @Size(max = 4)
    @Column(name = "coin")
    private String coin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ratio")
    private BigDecimal ratio;
    @Size(max = 8)
    @Column(name = "buyer")
    private String buyer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "keyindate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date keyindate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "userno")
    private String userno;
    @Column(name = "cdrcode")
    private Character cdrcode;
    @Column(name = "lowlevel")
    private Integer lowlevel;
    @Size(max = 3)
    @Column(name = "addcode")
    private String addcode;
    @Column(name = "cfmdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cfmdate;
    @Size(max = 8)
    @Column(name = "cfmuserno")
    private String cfmuserno;
    @Column(name = "mandateo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mandateo;
    @Column(name = "tax")
    private Character tax;
    @Column(name = "taxrate")
    private BigDecimal taxrate;
    @Size(max = 4)
    @Column(name = "itcls")
    private String itcls;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mrptype")
    private Character mrptype;
    @Column(name = "normalaccdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date normalaccdate;
    @Column(name = "posrccode")
    private Character posrccode;
    @Size(max = 1)
    @Column(name = "predict")
    private String predict;
    @Size(max = 20)
    @Column(name = "eccode")
    private String eccode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "oastatus")
    private String oastatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "oapsn")
    private String oapsn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "oauserno")
    private String oauserno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "oadate")
    private String oadate;

    @Basic(optional = false)
    @NotNull
    @Column(name = "draftqty")
    private BigDecimal draftqty;
    
    @JoinColumn(name = "itnbrf", referencedColumnName = "itnbr", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Invmas invmas;

    public Manmot() {
    }

    public Manmot(ManmotPK manmotPK) {
        this.manmotPK = manmotPK;
    }

    public Manmot(ManmotPK manmotPK, String itnbrf, String mankind, Character manstatus, BigDecimal manqty, Date mandate, BigDecimal mrpqty, String batnr, BigDecimal unpris, BigDecimal ratio, Date keyindate, String userno, Character mrptype, String oastatus, String oapsn, String oauserno, String oadate) {
        this.manmotPK = manmotPK;
        this.itnbrf = itnbrf;
        this.mankind = mankind;
        this.manstatus = manstatus;
        this.manqty = manqty;
        this.mandate = mandate;
        this.mrpqty = mrpqty;
        this.batnr = batnr;
        this.unpris = unpris;
        this.ratio = ratio;
        this.keyindate = keyindate;
        this.userno = userno;
        this.mrptype = mrptype;
        this.oastatus = oastatus;
        this.oapsn = oapsn;
        this.oauserno = oauserno;
        this.oadate = oadate;
    }

    public Manmot(String facno, String prono, String manno) {
        this.manmotPK = new ManmotPK(facno, prono, manno);
    }

    public ManmotPK getManmotPK() {
        return manmotPK;
    }

    public void setManmotPK(ManmotPK manmotPK) {
        this.manmotPK = manmotPK;
    }

    public String getLinecode() {
        return linecode;
    }

    public void setLinecode(String linecode) {
        this.linecode = linecode;
    }

    public String getItnbrf() {
        return itnbrf;
    }

    public void setItnbrf(String itnbrf) {
        this.itnbrf = itnbrf;
    }

    public String getCusno() {
        return cusno;
    }

    public void setCusno(String cusno) {
        this.cusno = cusno;
    }

    public String getMankind() {
        return mankind;
    }

    public void setMankind(String mankind) {
        this.mankind = mankind;
    }

    public Character getManstatus() {
        return manstatus;
    }

    public void setManstatus(Character manstatus) {
        this.manstatus = manstatus;
    }

    public BigDecimal getManqty() {
        return manqty;
    }

    public void setManqty(BigDecimal manqty) {
        this.manqty = manqty;
    }

    public Date getMandate() {
        return mandate;
    }

    public void setMandate(Date mandate) {
        this.mandate = mandate;
    }

    public String getTypecode() {
        return typecode;
    }

    public void setTypecode(String typecode) {
        this.typecode = typecode;
    }

    public Date getIssdate() {
        return issdate;
    }

    public void setIssdate(Date issdate) {
        this.issdate = issdate;
    }

    public BigDecimal getMrpqty() {
        return mrpqty;
    }

    public void setMrpqty(BigDecimal mrpqty) {
        this.mrpqty = mrpqty;
    }

    public Date getMrpdate() {
        return mrpdate;
    }

    public void setMrpdate(Date mrpdate) {
        this.mrpdate = mrpdate;
    }

    public String getMrpnr() {
        return mrpnr;
    }

    public void setMrpnr(String mrpnr) {
        this.mrpnr = mrpnr;
    }

    public String getBatnr() {
        return batnr;
    }

    public void setBatnr(String batnr) {
        this.batnr = batnr;
    }

    public String getManlotno() {
        return manlotno;
    }

    public void setManlotno(String manlotno) {
        this.manlotno = manlotno;
    }

    public String getItnbrh() {
        return itnbrh;
    }

    public void setItnbrh(String itnbrh) {
        this.itnbrh = itnbrh;
    }

    public String getRefno() {
        return refno;
    }

    public void setRefno(String refno) {
        this.refno = refno;
    }

    public Short getRefseq() {
        return refseq;
    }

    public void setRefseq(Short refseq) {
        this.refseq = refseq;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public Character getDecode() {
        return decode;
    }

    public void setDecode(Character decode) {
        this.decode = decode;
    }

    public String getVdrno() {
        return vdrno;
    }

    public void setVdrno(String vdrno) {
        this.vdrno = vdrno;
    }

    public BigDecimal getUnpris() {
        return unpris;
    }

    public void setUnpris(BigDecimal unpris) {
        this.unpris = unpris;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public BigDecimal getRatio() {
        return ratio;
    }

    public void setRatio(BigDecimal ratio) {
        this.ratio = ratio;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public Date getKeyindate() {
        return keyindate;
    }

    public void setKeyindate(Date keyindate) {
        this.keyindate = keyindate;
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
    }

    public Character getCdrcode() {
        return cdrcode;
    }

    public void setCdrcode(Character cdrcode) {
        this.cdrcode = cdrcode;
    }

    public Integer getLowlevel() {
        return lowlevel;
    }

    public void setLowlevel(Integer lowlevel) {
        this.lowlevel = lowlevel;
    }

    public String getAddcode() {
        return addcode;
    }

    public void setAddcode(String addcode) {
        this.addcode = addcode;
    }

    public Date getCfmdate() {
        return cfmdate;
    }

    public void setCfmdate(Date cfmdate) {
        this.cfmdate = cfmdate;
    }

    public String getCfmuserno() {
        return cfmuserno;
    }

    public void setCfmuserno(String cfmuserno) {
        this.cfmuserno = cfmuserno;
    }

    public Date getMandateo() {
        return mandateo;
    }

    public void setMandateo(Date mandateo) {
        this.mandateo = mandateo;
    }

    public Character getTax() {
        return tax;
    }

    public void setTax(Character tax) {
        this.tax = tax;
    }

    public BigDecimal getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(BigDecimal taxrate) {
        this.taxrate = taxrate;
    }

    public String getItcls() {
        return itcls;
    }

    public void setItcls(String itcls) {
        this.itcls = itcls;
    }

    public Character getMrptype() {
        return mrptype;
    }

    public void setMrptype(Character mrptype) {
        this.mrptype = mrptype;
    }

    public Date getNormalaccdate() {
        return normalaccdate;
    }

    public void setNormalaccdate(Date normalaccdate) {
        this.normalaccdate = normalaccdate;
    }

    public Character getPosrccode() {
        return posrccode;
    }

    public void setPosrccode(Character posrccode) {
        this.posrccode = posrccode;
    }

    public String getPredict() {
        return predict;
    }

    public void setPredict(String predict) {
        this.predict = predict;
    }

    public String getEccode() {
        return eccode;
    }

    public void setEccode(String eccode) {
        this.eccode = eccode;
    }

    public String getOastatus() {
        return oastatus;
    }

    public void setOastatus(String oastatus) {
        this.oastatus = oastatus;
    }

    public String getOapsn() {
        return oapsn;
    }

    public void setOapsn(String oapsn) {
        this.oapsn = oapsn;
    }

    public String getOauserno() {
        return oauserno;
    }

    public void setOauserno(String oauserno) {
        this.oauserno = oauserno;
    }

    public String  getOadate() {
        return oadate;
    }

    public void setOadate(String oadate) {
        this.oadate = oadate;
    }

    public BigDecimal getDraftqty() {
        return draftqty;
    }

    public void setDraftqty(BigDecimal draftqty) {
        this.draftqty = draftqty;
    }
    
    public Invmas getInvmas() {
        return invmas;
    }

    public void setInvmas(Invmas invmas) {
        this.invmas = invmas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (manmotPK != null ? manmotPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Manmot)) {
            return false;
        }
        Manmot other = (Manmot) object;
        if ((this.manmotPK == null && other.manmotPK != null) || (this.manmotPK != null && !this.manmotPK.equals(other.manmotPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Manmot[ manmotPK=" + manmotPK + " ]";
    }
    
}
