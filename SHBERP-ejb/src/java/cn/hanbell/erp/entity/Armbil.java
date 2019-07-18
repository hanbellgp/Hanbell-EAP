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
 * @author C0160
 */
@Entity
@Table(name = "armbil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Armbil.findAll", query = "SELECT a FROM Armbil a"),
    @NamedQuery(name = "Armbil.findByFacno", query = "SELECT a FROM Armbil a WHERE a.armbilPK.facno = :facno"),
    @NamedQuery(name = "Armbil.findByBilno", query = "SELECT a FROM Armbil a WHERE a.armbilPK.bilno = :bilno")})
public class Armbil implements Serializable {

    @JoinColumn(name = "cusno", referencedColumnName = "cusno", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private Cdrcus cdrcus;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ArmbilPK armbilPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "bilnum")
    private String bilnum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "frmcode")
    private Character frmcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "depno")
    private String depno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "taxkd")
    private String taxkd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bildat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bildat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "biltyp")
    private Character biltyp;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "shpamts")
    private BigDecimal shpamts;
    @Basic(optional = false)
    @NotNull
    @Column(name = "shpamt")
    private BigDecimal shpamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "preamts")
    private BigDecimal preamts;
    @Basic(optional = false)
    @NotNull
    @Column(name = "preamt")
    private BigDecimal preamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "curamts")
    private BigDecimal curamts;
    @Basic(optional = false)
    @NotNull
    @Column(name = "curamt")
    private BigDecimal curamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bilamts")
    private BigDecimal bilamts;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bilamt")
    private BigDecimal bilamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "biltaxs")
    private BigDecimal biltaxs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "biltax")
    private BigDecimal biltax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "accamts")
    private BigDecimal accamts;
    @Basic(optional = false)
    @NotNull
    @Column(name = "accamt")
    private BigDecimal accamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bilstat")
    private Character bilstat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "ivocuskind")
    private String ivocuskind;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "ivocus")
    private String ivocus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "cuskind")
    private String cuskind;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "cusno")
    private String cusno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "taxcus")
    private String taxcus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "coin")
    private String coin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ratin")
    private BigDecimal ratin;
    @Size(max = 40)
    @Column(name = "address1")
    private String address1;
    @Size(max = 40)
    @Column(name = "address2")
    private String address2;
    @Size(max = 40)
    @Column(name = "address3")
    private String address3;
    @Size(max = 40)
    @Column(name = "address4")
    private String address4;
    @Size(max = 40)
    @Column(name = "address5")
    private String address5;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prtcnt")
    private short prtcnt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "vouno")
    private String vouno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "usrno")
    private String usrno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usrdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usrdate;
    @Size(max = 8)
    @Column(name = "ausrno")
    private String ausrno;
    @Column(name = "ausrdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ausrdate;
    @Size(max = 8)
    @Column(name = "mancode")
    private String mancode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "taxfacno")
    private String taxfacno;
    @Column(name = "warngdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date warngdate;
    @Column(name = "shlddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date shlddate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "taxym")
    private String taxym;
    @Size(max = 8)
    @Column(name = "rkd")
    private String rkd;
    @Size(max = 20)
    @Column(name = "tbilno")
    private String tbilno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "losamts")
    private BigDecimal losamts;
    @Basic(optional = false)
    @NotNull
    @Column(name = "losamt")
    private BigDecimal losamt;
    @Size(max = 18)
    @Column(name = "bilcategory")
    private String bilcategory;
    @Column(name = "taxrate")
    private BigDecimal taxrate;
    @Size(max = 8)
    @Column(name = "opbankno")
    private String opbankno;
    @Size(max = 40)
    @Column(name = "opbankna")
    private String opbankna;
    @Size(max = 25)
    @Column(name = "opbanknum")
    private String opbanknum;

    public Armbil() {
    }

    public Armbil(ArmbilPK armbilPK) {
        this.armbilPK = armbilPK;
    }

    public Armbil(ArmbilPK armbilPK, String bilnum, Character frmcode, String depno, String taxkd, Date bildat, Character biltyp, BigDecimal shpamts, BigDecimal shpamt, BigDecimal preamts, BigDecimal preamt, BigDecimal curamts, BigDecimal curamt, BigDecimal bilamts, BigDecimal bilamt, BigDecimal biltaxs, BigDecimal biltax, BigDecimal accamts, BigDecimal accamt, Character bilstat, String ivocuskind, String ivocus, String cuskind, String cusno, String taxcus, String coin, BigDecimal ratin, short prtcnt, String vouno, String usrno, Date usrdate, String taxfacno, String taxym, BigDecimal losamts, BigDecimal losamt) {
        this.armbilPK = armbilPK;
        this.bilnum = bilnum;
        this.frmcode = frmcode;
        this.depno = depno;
        this.taxkd = taxkd;
        this.bildat = bildat;
        this.biltyp = biltyp;
        this.shpamts = shpamts;
        this.shpamt = shpamt;
        this.preamts = preamts;
        this.preamt = preamt;
        this.curamts = curamts;
        this.curamt = curamt;
        this.bilamts = bilamts;
        this.bilamt = bilamt;
        this.biltaxs = biltaxs;
        this.biltax = biltax;
        this.accamts = accamts;
        this.accamt = accamt;
        this.bilstat = bilstat;
        this.ivocuskind = ivocuskind;
        this.ivocus = ivocus;
        this.cuskind = cuskind;
        this.cusno = cusno;
        this.taxcus = taxcus;
        this.coin = coin;
        this.ratin = ratin;
        this.prtcnt = prtcnt;
        this.vouno = vouno;
        this.usrno = usrno;
        this.usrdate = usrdate;
        this.taxfacno = taxfacno;
        this.taxym = taxym;
        this.losamts = losamts;
        this.losamt = losamt;
    }

    public Armbil(String facno, String bilym, String bilno) {
        this.armbilPK = new ArmbilPK(facno, bilym, bilno);
    }

    public ArmbilPK getArmbilPK() {
        return armbilPK;
    }

    public void setArmbilPK(ArmbilPK armbilPK) {
        this.armbilPK = armbilPK;
    }

    public String getBilnum() {
        return bilnum;
    }

    public void setBilnum(String bilnum) {
        this.bilnum = bilnum;
    }

    public Character getFrmcode() {
        return frmcode;
    }

    public void setFrmcode(Character frmcode) {
        this.frmcode = frmcode;
    }

    public String getDepno() {
        return depno;
    }

    public void setDepno(String depno) {
        this.depno = depno;
    }

    public String getTaxkd() {
        return taxkd;
    }

    public void setTaxkd(String taxkd) {
        this.taxkd = taxkd;
    }

    public Date getBildat() {
        return bildat;
    }

    public void setBildat(Date bildat) {
        this.bildat = bildat;
    }

    public Character getBiltyp() {
        return biltyp;
    }

    public void setBiltyp(Character biltyp) {
        this.biltyp = biltyp;
    }

    public BigDecimal getShpamts() {
        return shpamts;
    }

    public void setShpamts(BigDecimal shpamts) {
        this.shpamts = shpamts;
    }

    public BigDecimal getShpamt() {
        return shpamt;
    }

    public void setShpamt(BigDecimal shpamt) {
        this.shpamt = shpamt;
    }

    public BigDecimal getPreamts() {
        return preamts;
    }

    public void setPreamts(BigDecimal preamts) {
        this.preamts = preamts;
    }

    public BigDecimal getPreamt() {
        return preamt;
    }

    public void setPreamt(BigDecimal preamt) {
        this.preamt = preamt;
    }

    public BigDecimal getCuramts() {
        return curamts;
    }

    public void setCuramts(BigDecimal curamts) {
        this.curamts = curamts;
    }

    public BigDecimal getCuramt() {
        return curamt;
    }

    public void setCuramt(BigDecimal curamt) {
        this.curamt = curamt;
    }

    public BigDecimal getBilamts() {
        return bilamts;
    }

    public void setBilamts(BigDecimal bilamts) {
        this.bilamts = bilamts;
    }

    public BigDecimal getBilamt() {
        return bilamt;
    }

    public void setBilamt(BigDecimal bilamt) {
        this.bilamt = bilamt;
    }

    public BigDecimal getBiltaxs() {
        return biltaxs;
    }

    public void setBiltaxs(BigDecimal biltaxs) {
        this.biltaxs = biltaxs;
    }

    public BigDecimal getBiltax() {
        return biltax;
    }

    public void setBiltax(BigDecimal biltax) {
        this.biltax = biltax;
    }

    public BigDecimal getAccamts() {
        return accamts;
    }

    public void setAccamts(BigDecimal accamts) {
        this.accamts = accamts;
    }

    public BigDecimal getAccamt() {
        return accamt;
    }

    public void setAccamt(BigDecimal accamt) {
        this.accamt = accamt;
    }

    public Character getBilstat() {
        return bilstat;
    }

    public void setBilstat(Character bilstat) {
        this.bilstat = bilstat;
    }

    public String getIvocuskind() {
        return ivocuskind;
    }

    public void setIvocuskind(String ivocuskind) {
        this.ivocuskind = ivocuskind;
    }

    public String getIvocus() {
        return ivocus;
    }

    public void setIvocus(String ivocus) {
        this.ivocus = ivocus;
    }

    public String getCuskind() {
        return cuskind;
    }

    public void setCuskind(String cuskind) {
        this.cuskind = cuskind;
    }

    public String getCusno() {
        return cusno;
    }

    public void setCusno(String cusno) {
        this.cusno = cusno;
    }

    public String getTaxcus() {
        return taxcus;
    }

    public void setTaxcus(String taxcus) {
        this.taxcus = taxcus;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public BigDecimal getRatin() {
        return ratin;
    }

    public void setRatin(BigDecimal ratin) {
        this.ratin = ratin;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getAddress4() {
        return address4;
    }

    public void setAddress4(String address4) {
        this.address4 = address4;
    }

    public String getAddress5() {
        return address5;
    }

    public void setAddress5(String address5) {
        this.address5 = address5;
    }

    public short getPrtcnt() {
        return prtcnt;
    }

    public void setPrtcnt(short prtcnt) {
        this.prtcnt = prtcnt;
    }

    public String getVouno() {
        return vouno;
    }

    public void setVouno(String vouno) {
        this.vouno = vouno;
    }

    public String getUsrno() {
        return usrno;
    }

    public void setUsrno(String usrno) {
        this.usrno = usrno;
    }

    public Date getUsrdate() {
        return usrdate;
    }

    public void setUsrdate(Date usrdate) {
        this.usrdate = usrdate;
    }

    public String getAusrno() {
        return ausrno;
    }

    public void setAusrno(String ausrno) {
        this.ausrno = ausrno;
    }

    public Date getAusrdate() {
        return ausrdate;
    }

    public void setAusrdate(Date ausrdate) {
        this.ausrdate = ausrdate;
    }

    public String getMancode() {
        return mancode;
    }

    public void setMancode(String mancode) {
        this.mancode = mancode;
    }

    public String getTaxfacno() {
        return taxfacno;
    }

    public void setTaxfacno(String taxfacno) {
        this.taxfacno = taxfacno;
    }

    public Date getWarngdate() {
        return warngdate;
    }

    public void setWarngdate(Date warngdate) {
        this.warngdate = warngdate;
    }

    public Date getShlddate() {
        return shlddate;
    }

    public void setShlddate(Date shlddate) {
        this.shlddate = shlddate;
    }

    public String getTaxym() {
        return taxym;
    }

    public void setTaxym(String taxym) {
        this.taxym = taxym;
    }

    public String getRkd() {
        return rkd;
    }

    public void setRkd(String rkd) {
        this.rkd = rkd;
    }

    public String getTbilno() {
        return tbilno;
    }

    public void setTbilno(String tbilno) {
        this.tbilno = tbilno;
    }

    public BigDecimal getLosamts() {
        return losamts;
    }

    public void setLosamts(BigDecimal losamts) {
        this.losamts = losamts;
    }

    public BigDecimal getLosamt() {
        return losamt;
    }

    public void setLosamt(BigDecimal losamt) {
        this.losamt = losamt;
    }

    public String getBilcategory() {
        return bilcategory;
    }

    public void setBilcategory(String bilcategory) {
        this.bilcategory = bilcategory;
    }

    public BigDecimal getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(BigDecimal taxrate) {
        this.taxrate = taxrate;
    }

    public String getOpbankno() {
        return opbankno;
    }

    public void setOpbankno(String opbankno) {
        this.opbankno = opbankno;
    }

    public String getOpbankna() {
        return opbankna;
    }

    public void setOpbankna(String opbankna) {
        this.opbankna = opbankna;
    }

    public String getOpbanknum() {
        return opbanknum;
    }

    public void setOpbanknum(String opbanknum) {
        this.opbanknum = opbanknum;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (armbilPK != null ? armbilPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Armbil)) {
            return false;
        }
        Armbil other = (Armbil) object;
        if ((this.armbilPK == null && other.armbilPK != null) || (this.armbilPK != null && !this.armbilPK.equals(other.armbilPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Armbil[ armbilPK=" + armbilPK + " ]";
    }

    /**
     * @return the cdrcus
     */
    public Cdrcus getCdrcus() {
        return cdrcus;
    }

}
