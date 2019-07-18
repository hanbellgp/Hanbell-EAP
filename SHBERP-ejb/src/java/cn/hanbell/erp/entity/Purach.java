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
@Table(name = "purach")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Purach.findAll", query = "SELECT p FROM Purach p"),
    @NamedQuery(name = "Purach.findByFacno", query = "SELECT p FROM Purach p WHERE p.purachPK.facno = :facno"),
    @NamedQuery(name = "Purach.findByProno", query = "SELECT p FROM Purach p WHERE p.purachPK.prono = :prono"),
    @NamedQuery(name = "Purach.findByAcceptno", query = "SELECT p FROM Purach p WHERE p.purachPK.acceptno = :acceptno"),
    @NamedQuery(name = "Purach.findByAcceptdate", query = "SELECT p FROM Purach p WHERE p.acceptdate = :acceptdate"),
    @NamedQuery(name = "Purach.findByVdrno", query = "SELECT p FROM Purach p WHERE p.vdrno = :vdrno")})
public class Purach implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PurachPK purachPK;
    @Column(name = "acceptdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date acceptdate;
    @Size(max = 8)
    @Column(name = "vdrno")
    private String vdrno;
    @Size(max = 20)
    @Column(name = "ivono")
    private String ivono;
    @Size(max = 8)
    @Column(name = "depno")
    private String depno;
    @Column(name = "achsta")
    private Character achsta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "autoship")
    private Character autoship;
    @Column(name = "decode")
    private Character decode;
    @Size(max = 3)
    @Column(name = "cdrtrtype")
    private String cdrtrtype;
    @Size(max = 8)
    @Column(name = "cdrdepno")
    private String cdrdepno;
    @Size(max = 8)
    @Column(name = "cusno")
    private String cusno;
    @Column(name = "shptrseq")
    private Short shptrseq;
    @Size(max = 12)
    @Column(name = "wareh")
    private String wareh;
    @Column(name = "tax")
    private Character tax;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "taxrate")
    private BigDecimal taxrate;
    @Size(max = 4)
    @Column(name = "coin")
    private String coin;
    @Column(name = "ratio")
    private BigDecimal ratio;
    @Size(max = 8)
    @Column(name = "mancode")
    private String mancode;
    @Size(max = 18)
    @Column(name = "shpno")
    private String shpno;
    @Column(name = "recivedate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date recivedate;
    @Column(name = "ivotrseq")
    private Short ivotrseq;
    @Column(name = "triyn")
    private Character triyn;
    @Size(max = 8)
    @Column(name = "trivdrno")
    private String trivdrno;
    @Size(max = 8)
    @Column(name = "userno")
    private String userno;
    @Column(name = "indate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date indate;
    @Size(max = 8)
    @Column(name = "cfmuserno")
    private String cfmuserno;
    @Column(name = "cfmdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cfmdate;
    @Size(max = 10)
    @Column(name = "dmark")
    private String dmark;
    @Size(max = 20)
    @Column(name = "invoiceno")
    private String invoiceno;
    @Size(max = 18)
    @Column(name = "shcdrno")
    private String shcdrno;

    public Purach() {
    }

    public Purach(PurachPK purachPK) {
        this.purachPK = purachPK;
    }

    public Purach(PurachPK purachPK, Character autoship) {
        this.purachPK = purachPK;
        this.autoship = autoship;
    }

    public Purach(String facno, String prono, String acceptno) {
        this.purachPK = new PurachPK(facno, prono, acceptno);
    }

    public PurachPK getPurachPK() {
        return purachPK;
    }

    public void setPurachPK(PurachPK purachPK) {
        this.purachPK = purachPK;
    }

    public Date getAcceptdate() {
        return acceptdate;
    }

    public void setAcceptdate(Date acceptdate) {
        this.acceptdate = acceptdate;
    }

    public String getVdrno() {
        return vdrno;
    }

    public void setVdrno(String vdrno) {
        this.vdrno = vdrno;
    }

    public String getIvono() {
        return ivono;
    }

    public void setIvono(String ivono) {
        this.ivono = ivono;
    }

    public String getDepno() {
        return depno;
    }

    public void setDepno(String depno) {
        this.depno = depno;
    }

    public Character getAchsta() {
        return achsta;
    }

    public void setAchsta(Character achsta) {
        this.achsta = achsta;
    }

    public Character getAutoship() {
        return autoship;
    }

    public void setAutoship(Character autoship) {
        this.autoship = autoship;
    }

    public Character getDecode() {
        return decode;
    }

    public void setDecode(Character decode) {
        this.decode = decode;
    }

    public String getCdrtrtype() {
        return cdrtrtype;
    }

    public void setCdrtrtype(String cdrtrtype) {
        this.cdrtrtype = cdrtrtype;
    }

    public String getCdrdepno() {
        return cdrdepno;
    }

    public void setCdrdepno(String cdrdepno) {
        this.cdrdepno = cdrdepno;
    }

    public String getCusno() {
        return cusno;
    }

    public void setCusno(String cusno) {
        this.cusno = cusno;
    }

    public Short getShptrseq() {
        return shptrseq;
    }

    public void setShptrseq(Short shptrseq) {
        this.shptrseq = shptrseq;
    }

    public String getWareh() {
        return wareh;
    }

    public void setWareh(String wareh) {
        this.wareh = wareh;
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

    public String getMancode() {
        return mancode;
    }

    public void setMancode(String mancode) {
        this.mancode = mancode;
    }

    public String getShpno() {
        return shpno;
    }

    public void setShpno(String shpno) {
        this.shpno = shpno;
    }

    public Date getRecivedate() {
        return recivedate;
    }

    public void setRecivedate(Date recivedate) {
        this.recivedate = recivedate;
    }

    public Short getIvotrseq() {
        return ivotrseq;
    }

    public void setIvotrseq(Short ivotrseq) {
        this.ivotrseq = ivotrseq;
    }

    public Character getTriyn() {
        return triyn;
    }

    public void setTriyn(Character triyn) {
        this.triyn = triyn;
    }

    public String getTrivdrno() {
        return trivdrno;
    }

    public void setTrivdrno(String trivdrno) {
        this.trivdrno = trivdrno;
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
    }

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    public String getCfmuserno() {
        return cfmuserno;
    }

    public void setCfmuserno(String cfmuserno) {
        this.cfmuserno = cfmuserno;
    }

    public Date getCfmdate() {
        return cfmdate;
    }

    public void setCfmdate(Date cfmdate) {
        this.cfmdate = cfmdate;
    }

    public String getDmark() {
        return dmark;
    }

    public void setDmark(String dmark) {
        this.dmark = dmark;
    }

    public String getInvoiceno() {
        return invoiceno;
    }

    public void setInvoiceno(String invoiceno) {
        this.invoiceno = invoiceno;
    }

    public String getShcdrno() {
        return shcdrno;
    }

    public void setShcdrno(String shcdrno) {
        this.shcdrno = shcdrno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (purachPK != null ? purachPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Purach)) {
            return false;
        }
        Purach other = (Purach) object;
        if ((this.purachPK == null && other.purachPK != null) || (this.purachPK != null && !this.purachPK.equals(other.purachPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Purach[ purachPK=" + purachPK + " ]";
    }

}
