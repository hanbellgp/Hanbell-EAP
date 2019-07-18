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
    @NamedQuery(name = "Invmas.findByEitdsc", query = "SELECT i FROM Invmas i WHERE i.eitdsc = :eitdsc"),
    @NamedQuery(name = "Invmas.findByEspdsc", query = "SELECT i FROM Invmas i WHERE i.espdsc = :espdsc"),
    @NamedQuery(name = "Invmas.findByUnmsr1", query = "SELECT i FROM Invmas i WHERE i.unmsr1 = :unmsr1"),
    @NamedQuery(name = "Invmas.findByUnmsr2", query = "SELECT i FROM Invmas i WHERE i.unmsr2 = :unmsr2"),
    @NamedQuery(name = "Invmas.findByUnmsr3", query = "SELECT i FROM Invmas i WHERE i.unmsr3 = :unmsr3"),
    @NamedQuery(name = "Invmas.findByUnmsr1e", query = "SELECT i FROM Invmas i WHERE i.unmsr1e = :unmsr1e"),
    @NamedQuery(name = "Invmas.findByUnmsr2e", query = "SELECT i FROM Invmas i WHERE i.unmsr2e = :unmsr2e"),
    @NamedQuery(name = "Invmas.findByUnmsr3e", query = "SELECT i FROM Invmas i WHERE i.unmsr3e = :unmsr3e"),
    @NamedQuery(name = "Invmas.findByRate2", query = "SELECT i FROM Invmas i WHERE i.rate2 = :rate2"),
    @NamedQuery(name = "Invmas.findByRate3", query = "SELECT i FROM Invmas i WHERE i.rate3 = :rate3"),
    @NamedQuery(name = "Invmas.findByFvco", query = "SELECT i FROM Invmas i WHERE i.fvco = :fvco"),
    @NamedQuery(name = "Invmas.findByJudco", query = "SELECT i FROM Invmas i WHERE i.judco = :judco"),
    @NamedQuery(name = "Invmas.findByMorpcode", query = "SELECT i FROM Invmas i WHERE i.morpcode = :morpcode"),
    @NamedQuery(name = "Invmas.findByGroup1", query = "SELECT i FROM Invmas i WHERE i.group1 = :group1"),
    @NamedQuery(name = "Invmas.findByGroup2", query = "SELECT i FROM Invmas i WHERE i.group2 = :group2"),
    @NamedQuery(name = "Invmas.findByGroup3", query = "SELECT i FROM Invmas i WHERE i.group3 = :group3"),
    @NamedQuery(name = "Invmas.findByGroup4", query = "SELECT i FROM Invmas i WHERE i.group4 = :group4"),
    @NamedQuery(name = "Invmas.findByGroup5", query = "SELECT i FROM Invmas i WHERE i.group5 = :group5"),
    @NamedQuery(name = "Invmas.findByGroup6", query = "SELECT i FROM Invmas i WHERE i.group6 = :group6"),
    @NamedQuery(name = "Invmas.findByGroup7", query = "SELECT i FROM Invmas i WHERE i.group7 = :group7"),
    @NamedQuery(name = "Invmas.findByGroup8", query = "SELECT i FROM Invmas i WHERE i.group8 = :group8"),
    @NamedQuery(name = "Invmas.findByGroup9", query = "SELECT i FROM Invmas i WHERE i.group9 = :group9"),
    @NamedQuery(name = "Invmas.findByGroup10", query = "SELECT i FROM Invmas i WHERE i.group10 = :group10"),
    @NamedQuery(name = "Invmas.findByGroup11", query = "SELECT i FROM Invmas i WHERE i.group11 = :group11"),
    @NamedQuery(name = "Invmas.findByGroup12", query = "SELECT i FROM Invmas i WHERE i.group12 = :group12"),
    @NamedQuery(name = "Invmas.findByPocode", query = "SELECT i FROM Invmas i WHERE i.pocode = :pocode"),
    @NamedQuery(name = "Invmas.findByDirrvyn", query = "SELECT i FROM Invmas i WHERE i.dirrvyn = :dirrvyn"),
    @NamedQuery(name = "Invmas.findByIoyn", query = "SELECT i FROM Invmas i WHERE i.ioyn = :ioyn"),
    @NamedQuery(name = "Invmas.findByPurtrtype", query = "SELECT i FROM Invmas i WHERE i.purtrtype = :purtrtype"),
    @NamedQuery(name = "Invmas.findByOrderqy", query = "SELECT i FROM Invmas i WHERE i.orderqy = :orderqy"),
    @NamedQuery(name = "Invmas.findByCadcamno", query = "SELECT i FROM Invmas i WHERE i.cadcamno = :cadcamno"),
    @NamedQuery(name = "Invmas.findByLowlevel", query = "SELECT i FROM Invmas i WHERE i.lowlevel = :lowlevel"),
    @NamedQuery(name = "Invmas.findByExclcode", query = "SELECT i FROM Invmas i WHERE i.exclcode = :exclcode"),
    @NamedQuery(name = "Invmas.findByCccode", query = "SELECT i FROM Invmas i WHERE i.cccode = :cccode"),
    @NamedQuery(name = "Invmas.findByUserno", query = "SELECT i FROM Invmas i WHERE i.userno = :userno"),
    @NamedQuery(name = "Invmas.findByIndate", query = "SELECT i FROM Invmas i WHERE i.indate = :indate"),
    @NamedQuery(name = "Invmas.findByAbcclass", query = "SELECT i FROM Invmas i WHERE i.abcclass = :abcclass"),
    @NamedQuery(name = "Invmas.findByUnprisyn", query = "SELECT i FROM Invmas i WHERE i.unprisyn = :unprisyn"),
    @NamedQuery(name = "Invmas.findByLowlevelcst", query = "SELECT i FROM Invmas i WHERE i.lowlevelcst = :lowlevelcst"),
    @NamedQuery(name = "Invmas.findByBarcode", query = "SELECT i FROM Invmas i WHERE i.barcode = :barcode"),
    @NamedQuery(name = "Invmas.findByStopyn", query = "SELECT i FROM Invmas i WHERE i.stopyn = :stopyn"),
    @NamedQuery(name = "Invmas.findByMark1", query = "SELECT i FROM Invmas i WHERE i.mark1 = :mark1"),
    @NamedQuery(name = "Invmas.findByMark2", query = "SELECT i FROM Invmas i WHERE i.mark2 = :mark2"),
    @NamedQuery(name = "Invmas.findByJityn", query = "SELECT i FROM Invmas i WHERE i.jityn = :jityn"),
    @NamedQuery(name = "Invmas.findByFyr", query = "SELECT i FROM Invmas i WHERE i.fyr = :fyr"),
    @NamedQuery(name = "Invmas.findByFyrname", query = "SELECT i FROM Invmas i WHERE i.fyrname = :fyrname"),
    @NamedQuery(name = "Invmas.findByMpackqy", query = "SELECT i FROM Invmas i WHERE i.mpackqy = :mpackqy"),
    @NamedQuery(name = "Invmas.findByItdsc2", query = "SELECT i FROM Invmas i WHERE i.itdsc2 = :itdsc2"),
    @NamedQuery(name = "Invmas.findBySpdsc2", query = "SELECT i FROM Invmas i WHERE i.spdsc2 = :spdsc2"),
    @NamedQuery(name = "Invmas.findByLbldefnum", query = "SELECT i FROM Invmas i WHERE i.lbldefnum = :lbldefnum"),
    @NamedQuery(name = "Invmas.findBySitdsc", query = "SELECT i FROM Invmas i WHERE i.sitdsc = :sitdsc"),
    @NamedQuery(name = "Invmas.findByItkind", query = "SELECT i FROM Invmas i WHERE i.itkind = :itkind"),
    @NamedQuery(name = "Invmas.findByLotqyyn", query = "SELECT i FROM Invmas i WHERE i.lotqyyn = :lotqyyn"),
    @NamedQuery(name = "Invmas.findByGenre1", query = "SELECT i FROM Invmas i WHERE i.genre1 = :genre1"),
    @NamedQuery(name = "Invmas.findByGenre2", query = "SELECT i FROM Invmas i WHERE i.genre2 = :genre2"),
    @NamedQuery(name = "Invmas.findByGenre3", query = "SELECT i FROM Invmas i WHERE i.genre3 = :genre3"),
    @NamedQuery(name = "Invmas.findByCost", query = "SELECT i FROM Invmas i WHERE i.cost = :cost"),
    @NamedQuery(name = "Invmas.findByAsscost", query = "SELECT i FROM Invmas i WHERE i.asscost = :asscost"),
    @NamedQuery(name = "Invmas.findByCpl", query = "SELECT i FROM Invmas i WHERE i.cpl = :cpl"),
    @NamedQuery(name = "Invmas.findByCpg", query = "SELECT i FROM Invmas i WHERE i.cpg = :cpg"),
    @NamedQuery(name = "Invmas.findByCpf", query = "SELECT i FROM Invmas i WHERE i.cpf = :cpf"),
    @NamedQuery(name = "Invmas.findByCpt", query = "SELECT i FROM Invmas i WHERE i.cpt = :cpt"),
    @NamedQuery(name = "Invmas.findByNStopyn", query = "SELECT i FROM Invmas i WHERE i.nStopyn = :nStopyn"),
    @NamedQuery(name = "Invmas.findByNEcnnewitnbr", query = "SELECT i FROM Invmas i WHERE i.nEcnnewitnbr = :nEcnnewitnbr"),
    @NamedQuery(name = "Invmas.findByNEcnno", query = "SELECT i FROM Invmas i WHERE i.nEcnno = :nEcnno"),
    @NamedQuery(name = "Invmas.findByNStopdate", query = "SELECT i FROM Invmas i WHERE i.nStopdate = :nStopdate"),
    @NamedQuery(name = "Invmas.findByNCount", query = "SELECT i FROM Invmas i WHERE i.nCount = :nCount"),
    @NamedQuery(name = "Invmas.findByDwl", query = "SELECT i FROM Invmas i WHERE i.dwl = :dwl"),
    @NamedQuery(name = "Invmas.findByDwg", query = "SELECT i FROM Invmas i WHERE i.dwg = :dwg"),
    @NamedQuery(name = "Invmas.findByDwf", query = "SELECT i FROM Invmas i WHERE i.dwf = :dwf"),
    @NamedQuery(name = "Invmas.findByDwt", query = "SELECT i FROM Invmas i WHERE i.dwt = :dwt"),
    @NamedQuery(name = "Invmas.findByCstmon", query = "SELECT i FROM Invmas i WHERE i.cstmon = :cstmon")})
public class Invmas implements Serializable {

    @JoinColumn(name = "itcls", referencedColumnName = "itcls", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Invcls invcls;

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
    @Size(min = 1, max = 30)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 30)
    @Column(name = "spdsc")
    private String spdsc;
    @Size(max = 30)
    @Column(name = "eitdsc")
    private String eitdsc;
    @Size(max = 30)
    @Column(name = "espdsc")
    private String espdsc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "unmsr1")
    private String unmsr1;
    @Size(max = 4)
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
    private String morpcode;
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
    @Size(max = 60)
    @Column(name = "mark1")
    private String mark1;
    @Size(max = 60)
    @Column(name = "mark2")
    private String mark2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "jityn")
    private Character jityn;
    @Size(max = 8)
    @Column(name = "fyr")
    private String fyr;
    @Size(max = 10)
    @Column(name = "fyrname")
    private String fyrname;
    @Column(name = "mpackqy")
    private BigDecimal mpackqy;
    @Size(max = 60)
    @Column(name = "itdsc2")
    private String itdsc2;
    @Size(max = 60)
    @Column(name = "spdsc2")
    private String spdsc2;
    @Column(name = "lbldefnum")
    private Integer lbldefnum;
    @Size(max = 20)
    @Column(name = "sitdsc")
    private String sitdsc;
    @Size(max = 4)
    @Column(name = "itkind")
    private String itkind;
    @Column(name = "lotqyyn")
    private Character lotqyyn;
    @Size(max = 40)
    @Column(name = "genre1")
    private String genre1;
    @Size(max = 40)
    @Column(name = "genre2")
    private String genre2;
    @Size(max = 40)
    @Column(name = "genre3")
    private String genre3;
    @Column(name = "cost")
    private BigDecimal cost;
    @Column(name = "asscost")
    private BigDecimal asscost;
    @Column(name = "cpl")
    private BigDecimal cpl;
    @Column(name = "cpg")
    private BigDecimal cpg;
    @Column(name = "cpf")
    private BigDecimal cpf;
    @Column(name = "cpt")
    private BigDecimal cpt;
    @Size(max = 20)
    @Column(name = "n_stopyn")
    private String nStopyn;
    @Size(max = 20)
    @Column(name = "n_ecnnewitnbr")
    private String nEcnnewitnbr;
    @Size(max = 20)
    @Column(name = "n_ecnno")
    private String nEcnno;
    @Column(name = "n_stopdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date nStopdate;
    @Column(name = "n_count")
    private Long nCount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dwl")
    private BigDecimal dwl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dwg")
    private BigDecimal dwg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dwf")
    private BigDecimal dwf;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dwt")
    private BigDecimal dwt;
    @Size(max = 6)
    @Column(name = "cstmon")
    private String cstmon;
//    @JoinColumn(name = "itcls", referencedColumnName = "itcls")
//    @ManyToOne
    @Size(min = 1, max = 4)
    @Column(name = "itcls")
    private String itcls;

    public Invmas() {
    }

    public Invmas(String itnbr) {
        this.itnbr = itnbr;
    }

    public Invmas(String itnbr, Character itclscode, String itdsc, String unmsr1, Character fvco, String judco, String userno, Date indate, Character jityn, BigDecimal dwl, BigDecimal dwg, BigDecimal dwf, BigDecimal dwt) {
        this.itnbr = itnbr;
        this.itclscode = itclscode;
        this.itdsc = itdsc;
        this.unmsr1 = unmsr1;
        this.fvco = fvco;
        this.judco = judco;
        this.userno = userno;
        this.indate = indate;
        this.jityn = jityn;
        this.dwl = dwl;
        this.dwg = dwg;
        this.dwf = dwf;
        this.dwt = dwt;
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

    public String getMorpcode() {
        return morpcode;
    }

    public void setMorpcode(String morpcode) {
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

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getAsscost() {
        return asscost;
    }

    public void setAsscost(BigDecimal asscost) {
        this.asscost = asscost;
    }

    public BigDecimal getCpl() {
        return cpl;
    }

    public void setCpl(BigDecimal cpl) {
        this.cpl = cpl;
    }

    public BigDecimal getCpg() {
        return cpg;
    }

    public void setCpg(BigDecimal cpg) {
        this.cpg = cpg;
    }

    public BigDecimal getCpf() {
        return cpf;
    }

    public void setCpf(BigDecimal cpf) {
        this.cpf = cpf;
    }

    public BigDecimal getCpt() {
        return cpt;
    }

    public void setCpt(BigDecimal cpt) {
        this.cpt = cpt;
    }

    public String getNStopyn() {
        return nStopyn;
    }

    public void setNStopyn(String nStopyn) {
        this.nStopyn = nStopyn;
    }

    public String getNEcnnewitnbr() {
        return nEcnnewitnbr;
    }

    public void setNEcnnewitnbr(String nEcnnewitnbr) {
        this.nEcnnewitnbr = nEcnnewitnbr;
    }

    public String getNEcnno() {
        return nEcnno;
    }

    public void setNEcnno(String nEcnno) {
        this.nEcnno = nEcnno;
    }

    public Date getNStopdate() {
        return nStopdate;
    }

    public void setNStopdate(Date nStopdate) {
        this.nStopdate = nStopdate;
    }

    public Long getNCount() {
        return nCount;
    }

    public void setNCount(Long nCount) {
        this.nCount = nCount;
    }

    public BigDecimal getDwl() {
        return dwl;
    }

    public void setDwl(BigDecimal dwl) {
        this.dwl = dwl;
    }

    public BigDecimal getDwg() {
        return dwg;
    }

    public void setDwg(BigDecimal dwg) {
        this.dwg = dwg;
    }

    public BigDecimal getDwf() {
        return dwf;
    }

    public void setDwf(BigDecimal dwf) {
        this.dwf = dwf;
    }

    public BigDecimal getDwt() {
        return dwt;
    }

    public void setDwt(BigDecimal dwt) {
        this.dwt = dwt;
    }

    public String getCstmon() {
        return cstmon;
    }

    public void setCstmon(String cstmon) {
        this.cstmon = cstmon;
    }

    public String getItcls() {
        return itcls;
    }

    public void setItcls(String itcls) {
        this.itcls = itcls;
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
        return "cn.hanbell.erp.comm.Invmas[ itnbr=" + itnbr + " ]";
    }

    /**
     * @return the invcls
     */
    public Invcls getInvcls() {
        return invcls;
    }

    /**
     * @param invcls the invcls to set
     */
    public void setInvcls(Invcls invcls) {
        this.invcls = invcls;
    }

}
