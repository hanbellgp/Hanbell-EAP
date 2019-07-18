/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hanbell.erp.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author Administrator
 */
@Entity
@Table(name = "invmas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invmas.findAll", query = "SELECT i FROM Invmas i"),
    @NamedQuery(name = "Invmas.findByItnbr", query = "SELECT i FROM Invmas i WHERE i.itnbr = :itnbr"),
    @NamedQuery(name = "Invmas.findByItclscode", query = "SELECT i FROM Invmas i WHERE i.itclscode = :itclscode"),
    @NamedQuery(name = "Invmas.findByItdsc", query = "SELECT i FROM Invmas i WHERE i.itdsc = :itdsc"),
    @NamedQuery(name = "Invmas.findBySpdsc", query = "SELECT i FROM Invmas i WHERE i.spdsc = :spdsc"),
    @NamedQuery(name = "Invmas.findByEitdsc", query = "SELECT i FROM Invmas i WHERE i.eitdsc = :eitdsc")})
public class Invmas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "itnbr")
    private String itnbr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "itclscode")
    private Character itclscode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 90)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 90)
    @Column(name = "spdsc")
    private String spdsc;
    @Size(max = 90)
    @Column(name = "eitdsc")
    private String eitdsc;
    @Size(max = 90)
    @Column(name = "espdsc")
    private String espdsc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "unmsr1")
    private String unmsr1;
    @Size(max = 8)
    @Column(name = "unmsr2")
    private String unmsr2;
    @Size(max = 4)
    @Column(name = "unmsr3")
    private String unmsr3;
    @Size(max = 12)
    @Column(name = "unmsr1e")
    private String unmsr1e;
    @Size(max = 12)
    @Column(name = "unmsr2e")
    private String unmsr2e;
    @Size(max = 12)
    @Column(name = "unmsr3e")
    private String unmsr3e;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rate2")
    private BigDecimal rate2;
    @Column(name = "rate3")
    private BigDecimal rate3;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fvco")
    private Character fvco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "judco")
    private String judco;
    @Column(name = "morpcode")
    private Character morpcode;
    @Size(max = 8)
    @Column(name = "group1")
    private String group1;
    @Size(max = 8)
    @Column(name = "group2")
    private String group2;
    @Size(max = 8)
    @Column(name = "group3")
    private String group3;
    @Size(max = 8)
    @Column(name = "group4")
    private String group4;
    @Size(max = 8)
    @Column(name = "group5")
    private String group5;
    @Size(max = 8)
    @Column(name = "group6")
    private String group6;
    @Size(max = 8)
    @Column(name = "group7")
    private String group7;
    @Size(max = 8)
    @Column(name = "group8")
    private String group8;
    @Size(max = 8)
    @Column(name = "group9")
    private String group9;
    @Size(max = 8)
    @Column(name = "group10")
    private String group10;
    @Size(max = 8)
    @Column(name = "group11")
    private String group11;
    @Size(max = 8)
    @Column(name = "group12")
    private String group12;
    @Column(name = "pocode")
    private Character pocode;
    @Column(name = "dirrvyn")
    private Character dirrvyn;
    @Column(name = "ioyn")
    private Character ioyn;
    @Size(max = 3)
    @Column(name = "purtrtype")
    private String purtrtype;
    @Column(name = "orderqy")
    private BigDecimal orderqy;
    @Size(max = 20)
    @Column(name = "cadcamno")
    private String cadcamno;
    @Column(name = "lowlevel")
    private Short lowlevel;
    @Column(name = "exclcode")
    private Character exclcode;
    @Size(max = 30)
    @Column(name = "cccode")
    private String cccode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "userno")
    private String userno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "indate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date indate;
    @Size(max = 1)
    @Column(name = "abcclass")
    private String abcclass;
    @Column(name = "unprisyn")
    private Character unprisyn;
    @Column(name = "lowlevelcst")
    private Short lowlevelcst;
    @Size(max = 20)
    @Column(name = "barcode")
    private String barcode;
    @Size(max = 20)
    @Column(name = "stopyn")
    private String stopyn;
    @Size(max = 120)
    @Column(name = "mark1")
    private String mark1;
    @Size(max = 120)
    @Column(name = "mark2")
    private String mark2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "jityn")
    private Character jityn;
    @Size(max = 8)
    @Column(name = "fyr")
    private String fyr;
    @Size(max = 20)
    @Column(name = "fyrname")
    private String fyrname;
    @Column(name = "mpackqy")
    private BigDecimal mpackqy;
    @Size(max = 120)
    @Column(name = "itdsc2")
    private String itdsc2;
    @Size(max = 120)
    @Column(name = "spdsc2")
    private String spdsc2;
    @Column(name = "lbldefnum")
    private Integer lbldefnum;
    @Size(max = 90)
    @Column(name = "sitdsc")
    private String sitdsc;
    @Size(max = 4)
    @Column(name = "itkind")
    private String itkind;
    @Column(name = "lotqyyn")
    private Character lotqyyn;
    @Size(max = 20)
    @Column(name = "genre1")
    private String genre1;
    @Size(max = 90)
    @Column(name = "genre2")
    private String genre2;
    @Size(max = 90)
    @Column(name = "genre3")
    private String genre3;
    //@JoinColumn(name = "itcls", referencedColumnName = "itcls")
    //@ManyToOne
    @Size(min = 1, max = 4)
    @Column(name = "itcls")
    private String itcls;

    public Invmas() {
    }

    public Invmas(String itnbr) {
        this.itnbr = itnbr;
    }

    public Invmas(String itnbr, Character itclscode, String itdsc, String unmsr1, Character fvco, String judco, String userno, Date indate, Character jityn) {
        this.itnbr = itnbr;
        this.itclscode = itclscode;
        this.itdsc = itdsc;
        this.unmsr1 = unmsr1;
        this.fvco = fvco;
        this.judco = judco;
        this.userno = userno;
        this.indate = indate;
        this.jityn = jityn;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public Character getItclscode() {
        return itclscode;
    }

    public void setItclscode(Character itclscode) {
        this.itclscode = itclscode;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getSpdsc() {
        return spdsc;
    }

    public void setSpdsc(String spdsc) {
        this.spdsc = spdsc;
    }

    public String getEitdsc() {
        return eitdsc;
    }

    public void setEitdsc(String eitdsc) {
        this.eitdsc = eitdsc;
    }

    public String getEspdsc() {
        return espdsc;
    }

    public void setEspdsc(String espdsc) {
        this.espdsc = espdsc;
    }

    public String getUnmsr1() {
        return unmsr1;
    }

    public void setUnmsr1(String unmsr1) {
        this.unmsr1 = unmsr1;
    }

    public String getUnmsr2() {
        return unmsr2;
    }

    public void setUnmsr2(String unmsr2) {
        this.unmsr2 = unmsr2;
    }

    public String getUnmsr3() {
        return unmsr3;
    }

    public void setUnmsr3(String unmsr3) {
        this.unmsr3 = unmsr3;
    }

    public String getUnmsr1e() {
        return unmsr1e;
    }

    public void setUnmsr1e(String unmsr1e) {
        this.unmsr1e = unmsr1e;
    }

    public String getUnmsr2e() {
        return unmsr2e;
    }

    public void setUnmsr2e(String unmsr2e) {
        this.unmsr2e = unmsr2e;
    }

    public String getUnmsr3e() {
        return unmsr3e;
    }

    public void setUnmsr3e(String unmsr3e) {
        this.unmsr3e = unmsr3e;
    }

    public BigDecimal getRate2() {
        return rate2;
    }

    public void setRate2(BigDecimal rate2) {
        this.rate2 = rate2;
    }

    public BigDecimal getRate3() {
        return rate3;
    }

    public void setRate3(BigDecimal rate3) {
        this.rate3 = rate3;
    }

    public Character getFvco() {
        return fvco;
    }

    public void setFvco(Character fvco) {
        this.fvco = fvco;
    }

    public String getJudco() {
        return judco;
    }

    public void setJudco(String judco) {
        this.judco = judco;
    }

    public Character getMorpcode() {
        return morpcode;
    }

    public void setMorpcode(Character morpcode) {
        this.morpcode = morpcode;
    }

    public String getGroup1() {
        return group1;
    }

    public void setGroup1(String group1) {
        this.group1 = group1;
    }

    public String getGroup2() {
        return group2;
    }

    public void setGroup2(String group2) {
        this.group2 = group2;
    }

    public String getGroup3() {
        return group3;
    }

    public void setGroup3(String group3) {
        this.group3 = group3;
    }

    public String getGroup4() {
        return group4;
    }

    public void setGroup4(String group4) {
        this.group4 = group4;
    }

    public String getGroup5() {
        return group5;
    }

    public void setGroup5(String group5) {
        this.group5 = group5;
    }

    public String getGroup6() {
        return group6;
    }

    public void setGroup6(String group6) {
        this.group6 = group6;
    }

    public String getGroup7() {
        return group7;
    }

    public void setGroup7(String group7) {
        this.group7 = group7;
    }

    public String getGroup8() {
        return group8;
    }

    public void setGroup8(String group8) {
        this.group8 = group8;
    }

    public String getGroup9() {
        return group9;
    }

    public void setGroup9(String group9) {
        this.group9 = group9;
    }

    public String getGroup10() {
        return group10;
    }

    public void setGroup10(String group10) {
        this.group10 = group10;
    }

    public String getGroup11() {
        return group11;
    }

    public void setGroup11(String group11) {
        this.group11 = group11;
    }

    public String getGroup12() {
        return group12;
    }

    public void setGroup12(String group12) {
        this.group12 = group12;
    }

    public Character getPocode() {
        return pocode;
    }

    public void setPocode(Character pocode) {
        this.pocode = pocode;
    }

    public Character getDirrvyn() {
        return dirrvyn;
    }

    public void setDirrvyn(Character dirrvyn) {
        this.dirrvyn = dirrvyn;
    }

    public Character getIoyn() {
        return ioyn;
    }

    public void setIoyn(Character ioyn) {
        this.ioyn = ioyn;
    }

    public String getPurtrtype() {
        return purtrtype;
    }

    public void setPurtrtype(String purtrtype) {
        this.purtrtype = purtrtype;
    }

    public BigDecimal getOrderqy() {
        return orderqy;
    }

    public void setOrderqy(BigDecimal orderqy) {
        this.orderqy = orderqy;
    }

    public String getCadcamno() {
        return cadcamno;
    }

    public void setCadcamno(String cadcamno) {
        this.cadcamno = cadcamno;
    }

    public Short getLowlevel() {
        return lowlevel;
    }

    public void setLowlevel(Short lowlevel) {
        this.lowlevel = lowlevel;
    }

    public Character getExclcode() {
        return exclcode;
    }

    public void setExclcode(Character exclcode) {
        this.exclcode = exclcode;
    }

    public String getCccode() {
        return cccode;
    }

    public void setCccode(String cccode) {
        this.cccode = cccode;
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

    public String getAbcclass() {
        return abcclass;
    }

    public void setAbcclass(String abcclass) {
        this.abcclass = abcclass;
    }

    public Character getUnprisyn() {
        return unprisyn;
    }

    public void setUnprisyn(Character unprisyn) {
        this.unprisyn = unprisyn;
    }

    public Short getLowlevelcst() {
        return lowlevelcst;
    }

    public void setLowlevelcst(Short lowlevelcst) {
        this.lowlevelcst = lowlevelcst;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getStopyn() {
        return stopyn;
    }

    public void setStopyn(String stopyn) {
        this.stopyn = stopyn;
    }

    public String getMark1() {
        return mark1;
    }

    public void setMark1(String mark1) {
        this.mark1 = mark1;
    }

    public String getMark2() {
        return mark2;
    }

    public void setMark2(String mark2) {
        this.mark2 = mark2;
    }

    public Character getJityn() {
        return jityn;
    }

    public void setJityn(Character jityn) {
        this.jityn = jityn;
    }

    public String getFyr() {
        return fyr;
    }

    public void setFyr(String fyr) {
        this.fyr = fyr;
    }

    public String getFyrname() {
        return fyrname;
    }

    public void setFyrname(String fyrname) {
        this.fyrname = fyrname;
    }

    public BigDecimal getMpackqy() {
        return mpackqy;
    }

    public void setMpackqy(BigDecimal mpackqy) {
        this.mpackqy = mpackqy;
    }

    public String getItdsc2() {
        return itdsc2;
    }

    public void setItdsc2(String itdsc2) {
        this.itdsc2 = itdsc2;
    }

    public String getSpdsc2() {
        return spdsc2;
    }

    public void setSpdsc2(String spdsc2) {
        this.spdsc2 = spdsc2;
    }

    public Integer getLbldefnum() {
        return lbldefnum;
    }

    public void setLbldefnum(Integer lbldefnum) {
        this.lbldefnum = lbldefnum;
    }

    public String getSitdsc() {
        return sitdsc;
    }

    public void setSitdsc(String sitdsc) {
        this.sitdsc = sitdsc;
    }

    public String getItkind() {
        return itkind;
    }

    public void setItkind(String itkind) {
        this.itkind = itkind;
    }

    public Character getLotqyyn() {
        return lotqyyn;
    }

    public void setLotqyyn(Character lotqyyn) {
        this.lotqyyn = lotqyyn;
    }

    public String getGenre1() {
        return genre1;
    }

    public void setGenre1(String genre1) {
        this.genre1 = genre1;
    }

    public String getGenre2() {
        return genre2;
    }

    public void setGenre2(String genre2) {
        this.genre2 = genre2;
    }

    public String getGenre3() {
        return genre3;
    }

    public void setGenre3(String genre3) {
        this.genre3 = genre3;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itnbr != null ? itnbr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invmas)) {
            return false;
        }
        Invmas other = (Invmas) object;
        if ((this.itnbr == null && other.itnbr != null) || (this.itnbr != null && !this.itnbr.equals(other.itnbr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vn.hanbell.erp.comm.Invmas[ itnbr=" + itnbr + " ]";
    }

    public String getItcls() {
        return itcls;
    }

    public void setItcls(String itcls) {
        this.itcls = itcls;
    }

}
