/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
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
@Table(name = "apmpay")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Apmpay.findAll", query = "SELECT a FROM Apmpay a"),
    @NamedQuery(name = "Apmpay.findByFacno", query = "SELECT a FROM Apmpay a WHERE a.apmpayPK.facno = :facno"),
    @NamedQuery(name = "Apmpay.findByPaycode", query = "SELECT a FROM Apmpay a WHERE a.apmpayPK.paycode = :paycode"),
    @NamedQuery(name = "Apmpay.findByPayno", query = "SELECT a FROM Apmpay a WHERE a.apmpayPK.payno = :payno"),
    @NamedQuery(name = "Apmpay.findByRkd", query = "SELECT a FROM Apmpay a WHERE a.rkd = :rkd"),
    @NamedQuery(name = "Apmpay.findByPayda", query = "SELECT a FROM Apmpay a WHERE a.payda = :payda"),
    @NamedQuery(name = "Apmpay.findByPaystat", query = "SELECT a FROM Apmpay a WHERE a.paystat = :paystat"),
    @NamedQuery(name = "Apmpay.findByVouno", query = "SELECT a FROM Apmpay a WHERE a.vouno = :vouno"),
    @NamedQuery(name = "Apmpay.findBySumry", query = "SELECT a FROM Apmpay a WHERE a.sumry = :sumry"),
    @NamedQuery(name = "Apmpay.findByTaxym", query = "SELECT a FROM Apmpay a WHERE a.taxym = :taxym"),
    @NamedQuery(name = "Apmpay.findBySrckind", query = "SELECT a FROM Apmpay a WHERE a.srckind = :srckind"),
    @NamedQuery(name = "Apmpay.findByBilltype", query = "SELECT a FROM Apmpay a WHERE a.billtype = :billtype"),
    @NamedQuery(name = "Apmpay.findBySrcno", query = "SELECT a FROM Apmpay a WHERE a.srcno = :srcno")})
public class Apmpay implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ApmpayPK apmpayPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "rkd")
    private String rkd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "payda")
    @Temporal(TemporalType.TIMESTAMP)
    private Date payda;
    @Size(max = 16)
    @Column(name = "ritm1")
    private String ritm1;
    @Size(max = 16)
    @Column(name = "ritm2")
    private String ritm2;
    @Size(max = 16)
    @Column(name = "ritm3")
    private String ritm3;
    @Size(max = 16)
    @Column(name = "ritm4")
    private String ritm4;
    @Size(max = 16)
    @Column(name = "ritm5")
    private String ritm5;
    @Size(max = 16)
    @Column(name = "ritm6")
    private String ritm6;
    @Size(max = 16)
    @Column(name = "ritm7")
    private String ritm7;
    @Size(max = 16)
    @Column(name = "ritm8")
    private String ritm8;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "usrno")
    private String usrno;
    @Size(max = 8)
    @Column(name = "depno")
    private String depno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "paystat")
    private Character paystat;
    @Size(max = 12)
    @Column(name = "vouno")
    private String vouno;
    @Size(max = 50)
    @Column(name = "sumry")
    private String sumry;
    @Size(max = 6)
    @Column(name = "taxym")
    private String taxym;
    @Size(max = 1)
    @Column(name = "srckind")
    private String srckind;
    @Size(max = 18)
    @Column(name = "billtype")
    private String billtype;
    @Size(max = 18)
    @Column(name = "srcno")
    private String srcno;
    
    public Apmpay() {
    }

    public Apmpay(ApmpayPK apmpayPK) {
        this.apmpayPK = apmpayPK;
    }

    public Apmpay(ApmpayPK apmpayPK, String rkd, Date payda, String usrno, Character paystat) {
        this.apmpayPK = apmpayPK;
        this.rkd = rkd;
        this.payda = payda;
        this.usrno = usrno;
        this.paystat = paystat;
    }

    public ApmpayPK getApmpayPK() {
        return apmpayPK;
    }

    public void setApmpayPK(ApmpayPK apmpayPK) {
        this.apmpayPK = apmpayPK;
    }

    public String getRkd() {
        return rkd;
    }

    public void setRkd(String rkd) {
        this.rkd = rkd;
    }

    public Date getPayda() {
        return payda;
    }

    public void setPayda(Date payda) {
        this.payda = payda;
    }

    public String getRitm1() {
        return ritm1;
    }

    public void setRitm1(String ritm1) {
        this.ritm1 = ritm1;
    }

    public String getRitm2() {
        return ritm2;
    }

    public void setRitm2(String ritm2) {
        this.ritm2 = ritm2;
    }

    public String getRitm3() {
        return ritm3;
    }

    public void setRitm3(String ritm3) {
        this.ritm3 = ritm3;
    }

    public String getRitm4() {
        return ritm4;
    }

    public void setRitm4(String ritm4) {
        this.ritm4 = ritm4;
    }

    public String getRitm5() {
        return ritm5;
    }

    public void setRitm5(String ritm5) {
        this.ritm5 = ritm5;
    }

    public String getRitm6() {
        return ritm6;
    }

    public void setRitm6(String ritm6) {
        this.ritm6 = ritm6;
    }

    public String getRitm7() {
        return ritm7;
    }

    public void setRitm7(String ritm7) {
        this.ritm7 = ritm7;
    }

    public String getRitm8() {
        return ritm8;
    }

    public void setRitm8(String ritm8) {
        this.ritm8 = ritm8;
    }

    public String getUsrno() {
        return usrno;
    }

    public void setUsrno(String usrno) {
        this.usrno = usrno;
    }

    public String getDepno() {
        return depno;
    }

    public void setDepno(String depno) {
        this.depno = depno;
    }

    public Character getPaystat() {
        return paystat;
    }

    public void setPaystat(Character paystat) {
        this.paystat = paystat;
    }

    public String getVouno() {
        return vouno;
    }

    public void setVouno(String vouno) {
        this.vouno = vouno;
    }

    public String getSumry() {
        return sumry;
    }

    public void setSumry(String sumry) {
        this.sumry = sumry;
    }

    public String getTaxym() {
        return taxym;
    }

    public void setTaxym(String taxym) {
        this.taxym = taxym;
    }

    public String getSrckind() {
        return srckind;
    }

    public void setSrckind(String srckind) {
        this.srckind = srckind;
    }

    public String getBilltype() {
        return billtype;
    }

    public void setBilltype(String billtype) {
        this.billtype = billtype;
    }

    public String getSrcno() {
        return srcno;
    }

    public void setSrcno(String srcno) {
        this.srcno = srcno;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (apmpayPK != null ? apmpayPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Apmpay)) {
            return false;
        }
        Apmpay other = (Apmpay) object;
        if ((this.apmpayPK == null && other.apmpayPK != null) || (this.apmpayPK != null && !this.apmpayPK.equals(other.apmpayPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Apmpay[ apmpayPK=" + apmpayPK + " ]";
    }
    
}
