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
@Table(name = "cdrsys")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdrsys.findAll", query = "SELECT c FROM Cdrsys c"),
    @NamedQuery(name = "Cdrsys.findByFacno", query = "SELECT c FROM Cdrsys c WHERE c.facno = :facno"),
    @NamedQuery(name = "Cdrsys.findByLpyn", query = "SELECT c FROM Cdrsys c WHERE c.lpyn = :lpyn"),
    @NamedQuery(name = "Cdrsys.findByItnbry", query = "SELECT c FROM Cdrsys c WHERE c.itnbry = :itnbry"),
    @NamedQuery(name = "Cdrsys.findByIndate", query = "SELECT c FROM Cdrsys c WHERE c.indate = :indate"),
    @NamedQuery(name = "Cdrsys.findByUserno", query = "SELECT c FROM Cdrsys c WHERE c.userno = :userno"),
    @NamedQuery(name = "Cdrsys.findByPrepctl", query = "SELECT c FROM Cdrsys c WHERE c.prepctl = :prepctl"),
    @NamedQuery(name = "Cdrsys.findByCnmgn", query = "SELECT c FROM Cdrsys c WHERE c.cnmgn = :cnmgn"),
    @NamedQuery(name = "Cdrsys.findByResetpris", query = "SELECT c FROM Cdrsys c WHERE c.resetpris = :resetpris"),
    @NamedQuery(name = "Cdrsys.findByAloulate", query = "SELECT c FROM Cdrsys c WHERE c.aloulate = :aloulate"),
    @NamedQuery(name = "Cdrsys.findByPackckind", query = "SELECT c FROM Cdrsys c WHERE c.packckind = :packckind"),
    @NamedQuery(name = "Cdrsys.findByDirshp", query = "SELECT c FROM Cdrsys c WHERE c.dirshp = :dirshp"),
    @NamedQuery(name = "Cdrsys.findByPridcode", query = "SELECT c FROM Cdrsys c WHERE c.pridcode = :pridcode"),
    @NamedQuery(name = "Cdrsys.findByTryrunyn", query = "SELECT c FROM Cdrsys c WHERE c.tryrunyn = :tryrunyn"),
    @NamedQuery(name = "Cdrsys.findByVdrno", query = "SELECT c FROM Cdrsys c WHERE c.vdrno = :vdrno"),
    @NamedQuery(name = "Cdrsys.findByIsquouse", query = "SELECT c FROM Cdrsys c WHERE c.isquouse = :isquouse")})
public class Cdrsys implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "facno")
    private String facno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lpyn")
    private Character lpyn;
    @Column(name = "itnbry")
    private Character itnbry;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sayn")
    private Character sayn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "areayn")
    private Character areayn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuyyn")
    private Character cuyyn;
    @Column(name = "termyn")
    private Character termyn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sndyn")
    private Character sndyn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "payyn")
    private Character payyn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "itnbryn")
    private Character itnbryn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unpricode")
    private Character unpricode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "credityn")
    private Character credityn;
    @Column(name = "orderyn")
    private Character orderyn;
    @Column(name = "shpyn")
    private Character shpyn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "yearmon")
    private String yearmon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hkpmonth")
    private short hkpmonth;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ekpmonth")
    private short ekpmonth;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hunprinum")
    private short hunprinum;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "uplimit")
    private BigDecimal uplimit;
    @Column(name = "dnlimit")
    private BigDecimal dnlimit;
    @Column(name = "keyinyn")
    private Character keyinyn;
    @Column(name = "manyn")
    private Character manyn;
    @Size(max = 8)
    @Column(name = "hmark1")
    private String hmark1;
    @Size(max = 2)
    @Column(name = "hmark1kind")
    private String hmark1kind;
    @Size(max = 8)
    @Column(name = "hmark2")
    private String hmark2;
    @Size(max = 2)
    @Column(name = "hmark2kind")
    private String hmark2kind;
    @Size(max = 8)
    @Column(name = "hmark3")
    private String hmark3;
    @Size(max = 2)
    @Column(name = "hmark3kind")
    private String hmark3kind;
    @Size(max = 8)
    @Column(name = "hmark4")
    private String hmark4;
    @Size(max = 2)
    @Column(name = "hmark4kind")
    private String hmark4kind;
    @Size(max = 8)
    @Column(name = "dmark1")
    private String dmark1;
    @Size(max = 2)
    @Column(name = "dmark1kind")
    private String dmark1kind;
    @Size(max = 8)
    @Column(name = "dmark2")
    private String dmark2;
    @Size(max = 2)
    @Column(name = "dmark2kind")
    private String dmark2kind;
    @Size(max = 8)
    @Column(name = "dmark3")
    private String dmark3;
    @Size(max = 2)
    @Column(name = "dmark3kind")
    private String dmark3kind;
    @Size(max = 8)
    @Column(name = "dmark4")
    private String dmark4;
    @Size(max = 2)
    @Column(name = "dmark4kind")
    private String dmark4kind;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuspocode")
    private Character cuspocode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "packcode")
    private Character packcode;
    @Size(max = 8)
    @Column(name = "cntype")
    private String cntype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "indate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date indate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "userno")
    private String userno;
    @Column(name = "shpdircfm")
    private Character shpdircfm;
    @Column(name = "newcredityn")
    private Character newcredityn;
    @Size(max = 1)
    @Column(name = "credityn2")
    private String credityn2;
    @Size(max = 1)
    @Column(name = "creditshpcdr")
    private String creditshpcdr;
    @Size(max = 1)
    @Column(name = "shpsaveyn")
    private String shpsaveyn;
    @Size(max = 1)
    @Column(name = "showpriceyn")
    private String showpriceyn;
    @Column(name = "dpyn")
    private Character dpyn;
    @Size(max = 6)
    @Column(name = "cdrlnwh")
    private String cdrlnwh;
    @Size(max = 1)
    @Column(name = "lnpyn")
    private String lnpyn;
    @Column(name = "earlyshp")
    private Integer earlyshp;
    @Column(name = "ischgda")
    private Character ischgda;
    @Column(name = "prepctl")
    private Character prepctl;
    @Size(max = 8)
    @Column(name = "cnmgn")
    private String cnmgn;
    @Column(name = "resetpris")
    private Character resetpris;
    @Column(name = "aloulate")
    private Character aloulate;
    @Size(max = 20)
    @Column(name = "customtypena")
    private String customtypena;
    @Column(name = "modtrktm")
    private Character modtrktm;
    @Size(max = 8)
    @Column(name = "relcusgp")
    private String relcusgp;
    @Size(max = 3)
    @Column(name = "relcdrtr1")
    private String relcdrtr1;
    @Size(max = 3)
    @Column(name = "relcdrtr2")
    private String relcdrtr2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "packfrcusit")
    private Character packfrcusit;
    @Size(max = 8)
    @Column(name = "packckind")
    private String packckind;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dirshp")
    private Character dirshp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pridcode")
    private Character pridcode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tryrunyn")
    private Character tryrunyn;
    @Size(max = 12)
    @Column(name = "vdrno")
    private String vdrno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "acesoryyn")
    private Character acesoryyn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "itquo")
    private Character itquo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "itshp")
    private Character itshp;
    @Size(max = 3)
    @Column(name = "autotrtype")
    private String autotrtype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prepdnlimit")
    private BigDecimal prepdnlimit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "showshplot")
    private Character showshplot;
    @Basic(optional = false)
    @NotNull
    @Column(name = "showoldpri")
    private Character showoldpri;
    @Size(max = 3)
    @Column(name = "relbcdrtr1")
    private String relbcdrtr1;
    @Size(max = 3)
    @Column(name = "relbcdrtr2")
    private String relbcdrtr2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rptmode2")
    private Character rptmode2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "showshpaddress")
    private Character showshpaddress;
    @Basic(optional = false)
    @NotNull
    @Column(name = "showshpcont")
    private Character showshpcont;
    @Column(name = "mpackyn")
    private Character mpackyn;
    @Column(name = "morderyn")
    private Character morderyn;
    @Column(name = "difprionitnbrcus")
    private Character difprionitnbrcus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "asryissmode")
    private Character asryissmode;
    @Size(max = 3)
    @Column(name = "asrytrtype")
    private String asrytrtype;
    @Size(max = 8)
    @Column(name = "asrydfdepno")
    private String asrydfdepno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cdrbomsubyn")
    private Character cdrbomsubyn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "subfrzstatus")
    private Character subfrzstatus;
    @Size(max = 3)
    @Column(name = "asrybtrtype")
    private String asrybtrtype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "cmcyn")
    private String cmcyn;
    @Column(name = "conprionly")
    private Character conprionly;
    @Column(name = "cfmoutda")
    private Character cfmoutda;
    @Column(name = "allowchgrecda")
    private Character allowchgrecda;
    @Column(name = "shppremgn")
    private Character shppremgn;
    @Size(max = 6)
    @Column(name = "lndfwh")
    private String lndfwh;
    @Size(max = 1)
    @Column(name = "isquouse")
    private String isquouse;

    public Cdrsys() {
    }

    public Cdrsys(String facno) {
        this.facno = facno;
    }

    public Cdrsys(String facno, Character lpyn, Character sayn, Character areayn, Character cuyyn, Character sndyn, Character payyn, Character itnbryn, Character unpricode, Character credityn, String yearmon, short hkpmonth, short ekpmonth, short hunprinum, Character cuspocode, Character packcode, Date indate, String userno, Character packfrcusit, Character dirshp, Character pridcode, Character tryrunyn, Character acesoryyn, Character itquo, Character itshp, BigDecimal prepdnlimit, Character showshplot, Character showoldpri, Character rptmode2, Character showshpaddress, Character showshpcont, Character asryissmode, Character cdrbomsubyn, Character subfrzstatus, String cmcyn) {
        this.facno = facno;
        this.lpyn = lpyn;
        this.sayn = sayn;
        this.areayn = areayn;
        this.cuyyn = cuyyn;
        this.sndyn = sndyn;
        this.payyn = payyn;
        this.itnbryn = itnbryn;
        this.unpricode = unpricode;
        this.credityn = credityn;
        this.yearmon = yearmon;
        this.hkpmonth = hkpmonth;
        this.ekpmonth = ekpmonth;
        this.hunprinum = hunprinum;
        this.cuspocode = cuspocode;
        this.packcode = packcode;
        this.indate = indate;
        this.userno = userno;
        this.packfrcusit = packfrcusit;
        this.dirshp = dirshp;
        this.pridcode = pridcode;
        this.tryrunyn = tryrunyn;
        this.acesoryyn = acesoryyn;
        this.itquo = itquo;
        this.itshp = itshp;
        this.prepdnlimit = prepdnlimit;
        this.showshplot = showshplot;
        this.showoldpri = showoldpri;
        this.rptmode2 = rptmode2;
        this.showshpaddress = showshpaddress;
        this.showshpcont = showshpcont;
        this.asryissmode = asryissmode;
        this.cdrbomsubyn = cdrbomsubyn;
        this.subfrzstatus = subfrzstatus;
        this.cmcyn = cmcyn;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public Character getLpyn() {
        return lpyn;
    }

    public void setLpyn(Character lpyn) {
        this.lpyn = lpyn;
    }

    public Character getItnbry() {
        return itnbry;
    }

    public void setItnbry(Character itnbry) {
        this.itnbry = itnbry;
    }

    public Character getSayn() {
        return sayn;
    }

    public void setSayn(Character sayn) {
        this.sayn = sayn;
    }

    public Character getAreayn() {
        return areayn;
    }

    public void setAreayn(Character areayn) {
        this.areayn = areayn;
    }

    public Character getCuyyn() {
        return cuyyn;
    }

    public void setCuyyn(Character cuyyn) {
        this.cuyyn = cuyyn;
    }

    public Character getTermyn() {
        return termyn;
    }

    public void setTermyn(Character termyn) {
        this.termyn = termyn;
    }

    public Character getSndyn() {
        return sndyn;
    }

    public void setSndyn(Character sndyn) {
        this.sndyn = sndyn;
    }

    public Character getPayyn() {
        return payyn;
    }

    public void setPayyn(Character payyn) {
        this.payyn = payyn;
    }

    public Character getItnbryn() {
        return itnbryn;
    }

    public void setItnbryn(Character itnbryn) {
        this.itnbryn = itnbryn;
    }

    public Character getUnpricode() {
        return unpricode;
    }

    public void setUnpricode(Character unpricode) {
        this.unpricode = unpricode;
    }

    public Character getCredityn() {
        return credityn;
    }

    public void setCredityn(Character credityn) {
        this.credityn = credityn;
    }

    public Character getOrderyn() {
        return orderyn;
    }

    public void setOrderyn(Character orderyn) {
        this.orderyn = orderyn;
    }

    public Character getShpyn() {
        return shpyn;
    }

    public void setShpyn(Character shpyn) {
        this.shpyn = shpyn;
    }

    public String getYearmon() {
        return yearmon;
    }

    public void setYearmon(String yearmon) {
        this.yearmon = yearmon;
    }

    public short getHkpmonth() {
        return hkpmonth;
    }

    public void setHkpmonth(short hkpmonth) {
        this.hkpmonth = hkpmonth;
    }

    public short getEkpmonth() {
        return ekpmonth;
    }

    public void setEkpmonth(short ekpmonth) {
        this.ekpmonth = ekpmonth;
    }

    public short getHunprinum() {
        return hunprinum;
    }

    public void setHunprinum(short hunprinum) {
        this.hunprinum = hunprinum;
    }

    public BigDecimal getUplimit() {
        return uplimit;
    }

    public void setUplimit(BigDecimal uplimit) {
        this.uplimit = uplimit;
    }

    public BigDecimal getDnlimit() {
        return dnlimit;
    }

    public void setDnlimit(BigDecimal dnlimit) {
        this.dnlimit = dnlimit;
    }

    public Character getKeyinyn() {
        return keyinyn;
    }

    public void setKeyinyn(Character keyinyn) {
        this.keyinyn = keyinyn;
    }

    public Character getManyn() {
        return manyn;
    }

    public void setManyn(Character manyn) {
        this.manyn = manyn;
    }

    public String getHmark1() {
        return hmark1;
    }

    public void setHmark1(String hmark1) {
        this.hmark1 = hmark1;
    }

    public String getHmark1kind() {
        return hmark1kind;
    }

    public void setHmark1kind(String hmark1kind) {
        this.hmark1kind = hmark1kind;
    }

    public String getHmark2() {
        return hmark2;
    }

    public void setHmark2(String hmark2) {
        this.hmark2 = hmark2;
    }

    public String getHmark2kind() {
        return hmark2kind;
    }

    public void setHmark2kind(String hmark2kind) {
        this.hmark2kind = hmark2kind;
    }

    public String getHmark3() {
        return hmark3;
    }

    public void setHmark3(String hmark3) {
        this.hmark3 = hmark3;
    }

    public String getHmark3kind() {
        return hmark3kind;
    }

    public void setHmark3kind(String hmark3kind) {
        this.hmark3kind = hmark3kind;
    }

    public String getHmark4() {
        return hmark4;
    }

    public void setHmark4(String hmark4) {
        this.hmark4 = hmark4;
    }

    public String getHmark4kind() {
        return hmark4kind;
    }

    public void setHmark4kind(String hmark4kind) {
        this.hmark4kind = hmark4kind;
    }

    public String getDmark1() {
        return dmark1;
    }

    public void setDmark1(String dmark1) {
        this.dmark1 = dmark1;
    }

    public String getDmark1kind() {
        return dmark1kind;
    }

    public void setDmark1kind(String dmark1kind) {
        this.dmark1kind = dmark1kind;
    }

    public String getDmark2() {
        return dmark2;
    }

    public void setDmark2(String dmark2) {
        this.dmark2 = dmark2;
    }

    public String getDmark2kind() {
        return dmark2kind;
    }

    public void setDmark2kind(String dmark2kind) {
        this.dmark2kind = dmark2kind;
    }

    public String getDmark3() {
        return dmark3;
    }

    public void setDmark3(String dmark3) {
        this.dmark3 = dmark3;
    }

    public String getDmark3kind() {
        return dmark3kind;
    }

    public void setDmark3kind(String dmark3kind) {
        this.dmark3kind = dmark3kind;
    }

    public String getDmark4() {
        return dmark4;
    }

    public void setDmark4(String dmark4) {
        this.dmark4 = dmark4;
    }

    public String getDmark4kind() {
        return dmark4kind;
    }

    public void setDmark4kind(String dmark4kind) {
        this.dmark4kind = dmark4kind;
    }

    public Character getCuspocode() {
        return cuspocode;
    }

    public void setCuspocode(Character cuspocode) {
        this.cuspocode = cuspocode;
    }

    public Character getPackcode() {
        return packcode;
    }

    public void setPackcode(Character packcode) {
        this.packcode = packcode;
    }

    public String getCntype() {
        return cntype;
    }

    public void setCntype(String cntype) {
        this.cntype = cntype;
    }

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
    }

    public Character getShpdircfm() {
        return shpdircfm;
    }

    public void setShpdircfm(Character shpdircfm) {
        this.shpdircfm = shpdircfm;
    }

    public Character getNewcredityn() {
        return newcredityn;
    }

    public void setNewcredityn(Character newcredityn) {
        this.newcredityn = newcredityn;
    }

    public String getCredityn2() {
        return credityn2;
    }

    public void setCredityn2(String credityn2) {
        this.credityn2 = credityn2;
    }

    public String getCreditshpcdr() {
        return creditshpcdr;
    }

    public void setCreditshpcdr(String creditshpcdr) {
        this.creditshpcdr = creditshpcdr;
    }

    public String getShpsaveyn() {
        return shpsaveyn;
    }

    public void setShpsaveyn(String shpsaveyn) {
        this.shpsaveyn = shpsaveyn;
    }

    public String getShowpriceyn() {
        return showpriceyn;
    }

    public void setShowpriceyn(String showpriceyn) {
        this.showpriceyn = showpriceyn;
    }

    public Character getDpyn() {
        return dpyn;
    }

    public void setDpyn(Character dpyn) {
        this.dpyn = dpyn;
    }

    public String getCdrlnwh() {
        return cdrlnwh;
    }

    public void setCdrlnwh(String cdrlnwh) {
        this.cdrlnwh = cdrlnwh;
    }

    public String getLnpyn() {
        return lnpyn;
    }

    public void setLnpyn(String lnpyn) {
        this.lnpyn = lnpyn;
    }

    public Integer getEarlyshp() {
        return earlyshp;
    }

    public void setEarlyshp(Integer earlyshp) {
        this.earlyshp = earlyshp;
    }

    public Character getIschgda() {
        return ischgda;
    }

    public void setIschgda(Character ischgda) {
        this.ischgda = ischgda;
    }

    public Character getPrepctl() {
        return prepctl;
    }

    public void setPrepctl(Character prepctl) {
        this.prepctl = prepctl;
    }

    public String getCnmgn() {
        return cnmgn;
    }

    public void setCnmgn(String cnmgn) {
        this.cnmgn = cnmgn;
    }

    public Character getResetpris() {
        return resetpris;
    }

    public void setResetpris(Character resetpris) {
        this.resetpris = resetpris;
    }

    public Character getAloulate() {
        return aloulate;
    }

    public void setAloulate(Character aloulate) {
        this.aloulate = aloulate;
    }

    public String getCustomtypena() {
        return customtypena;
    }

    public void setCustomtypena(String customtypena) {
        this.customtypena = customtypena;
    }

    public Character getModtrktm() {
        return modtrktm;
    }

    public void setModtrktm(Character modtrktm) {
        this.modtrktm = modtrktm;
    }

    public String getRelcusgp() {
        return relcusgp;
    }

    public void setRelcusgp(String relcusgp) {
        this.relcusgp = relcusgp;
    }

    public String getRelcdrtr1() {
        return relcdrtr1;
    }

    public void setRelcdrtr1(String relcdrtr1) {
        this.relcdrtr1 = relcdrtr1;
    }

    public String getRelcdrtr2() {
        return relcdrtr2;
    }

    public void setRelcdrtr2(String relcdrtr2) {
        this.relcdrtr2 = relcdrtr2;
    }

    public Character getPackfrcusit() {
        return packfrcusit;
    }

    public void setPackfrcusit(Character packfrcusit) {
        this.packfrcusit = packfrcusit;
    }

    public String getPackckind() {
        return packckind;
    }

    public void setPackckind(String packckind) {
        this.packckind = packckind;
    }

    public Character getDirshp() {
        return dirshp;
    }

    public void setDirshp(Character dirshp) {
        this.dirshp = dirshp;
    }

    public Character getPridcode() {
        return pridcode;
    }

    public void setPridcode(Character pridcode) {
        this.pridcode = pridcode;
    }

    public Character getTryrunyn() {
        return tryrunyn;
    }

    public void setTryrunyn(Character tryrunyn) {
        this.tryrunyn = tryrunyn;
    }

    public String getVdrno() {
        return vdrno;
    }

    public void setVdrno(String vdrno) {
        this.vdrno = vdrno;
    }

    public Character getAcesoryyn() {
        return acesoryyn;
    }

    public void setAcesoryyn(Character acesoryyn) {
        this.acesoryyn = acesoryyn;
    }

    public Character getItquo() {
        return itquo;
    }

    public void setItquo(Character itquo) {
        this.itquo = itquo;
    }

    public Character getItshp() {
        return itshp;
    }

    public void setItshp(Character itshp) {
        this.itshp = itshp;
    }

    public String getAutotrtype() {
        return autotrtype;
    }

    public void setAutotrtype(String autotrtype) {
        this.autotrtype = autotrtype;
    }

    public BigDecimal getPrepdnlimit() {
        return prepdnlimit;
    }

    public void setPrepdnlimit(BigDecimal prepdnlimit) {
        this.prepdnlimit = prepdnlimit;
    }

    public Character getShowshplot() {
        return showshplot;
    }

    public void setShowshplot(Character showshplot) {
        this.showshplot = showshplot;
    }

    public Character getShowoldpri() {
        return showoldpri;
    }

    public void setShowoldpri(Character showoldpri) {
        this.showoldpri = showoldpri;
    }

    public String getRelbcdrtr1() {
        return relbcdrtr1;
    }

    public void setRelbcdrtr1(String relbcdrtr1) {
        this.relbcdrtr1 = relbcdrtr1;
    }

    public String getRelbcdrtr2() {
        return relbcdrtr2;
    }

    public void setRelbcdrtr2(String relbcdrtr2) {
        this.relbcdrtr2 = relbcdrtr2;
    }

    public Character getRptmode2() {
        return rptmode2;
    }

    public void setRptmode2(Character rptmode2) {
        this.rptmode2 = rptmode2;
    }

    public Character getShowshpaddress() {
        return showshpaddress;
    }

    public void setShowshpaddress(Character showshpaddress) {
        this.showshpaddress = showshpaddress;
    }

    public Character getShowshpcont() {
        return showshpcont;
    }

    public void setShowshpcont(Character showshpcont) {
        this.showshpcont = showshpcont;
    }

    public Character getMpackyn() {
        return mpackyn;
    }

    public void setMpackyn(Character mpackyn) {
        this.mpackyn = mpackyn;
    }

    public Character getMorderyn() {
        return morderyn;
    }

    public void setMorderyn(Character morderyn) {
        this.morderyn = morderyn;
    }

    public Character getDifprionitnbrcus() {
        return difprionitnbrcus;
    }

    public void setDifprionitnbrcus(Character difprionitnbrcus) {
        this.difprionitnbrcus = difprionitnbrcus;
    }

    public Character getAsryissmode() {
        return asryissmode;
    }

    public void setAsryissmode(Character asryissmode) {
        this.asryissmode = asryissmode;
    }

    public String getAsrytrtype() {
        return asrytrtype;
    }

    public void setAsrytrtype(String asrytrtype) {
        this.asrytrtype = asrytrtype;
    }

    public String getAsrydfdepno() {
        return asrydfdepno;
    }

    public void setAsrydfdepno(String asrydfdepno) {
        this.asrydfdepno = asrydfdepno;
    }

    public Character getCdrbomsubyn() {
        return cdrbomsubyn;
    }

    public void setCdrbomsubyn(Character cdrbomsubyn) {
        this.cdrbomsubyn = cdrbomsubyn;
    }

    public Character getSubfrzstatus() {
        return subfrzstatus;
    }

    public void setSubfrzstatus(Character subfrzstatus) {
        this.subfrzstatus = subfrzstatus;
    }

    public String getAsrybtrtype() {
        return asrybtrtype;
    }

    public void setAsrybtrtype(String asrybtrtype) {
        this.asrybtrtype = asrybtrtype;
    }

    public String getCmcyn() {
        return cmcyn;
    }

    public void setCmcyn(String cmcyn) {
        this.cmcyn = cmcyn;
    }

    public Character getConprionly() {
        return conprionly;
    }

    public void setConprionly(Character conprionly) {
        this.conprionly = conprionly;
    }

    public Character getCfmoutda() {
        return cfmoutda;
    }

    public void setCfmoutda(Character cfmoutda) {
        this.cfmoutda = cfmoutda;
    }

    public Character getAllowchgrecda() {
        return allowchgrecda;
    }

    public void setAllowchgrecda(Character allowchgrecda) {
        this.allowchgrecda = allowchgrecda;
    }

    public Character getShppremgn() {
        return shppremgn;
    }

    public void setShppremgn(Character shppremgn) {
        this.shppremgn = shppremgn;
    }

    public String getLndfwh() {
        return lndfwh;
    }

    public void setLndfwh(String lndfwh) {
        this.lndfwh = lndfwh;
    }

    public String getIsquouse() {
        return isquouse;
    }

    public void setIsquouse(String isquouse) {
        this.isquouse = isquouse;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facno != null ? facno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cdrsys)) {
            return false;
        }
        Cdrsys other = (Cdrsys) object;
        if ((this.facno == null && other.facno != null) || (this.facno != null && !this.facno.equals(other.facno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Cdrsys[ facno=" + facno + " ]";
    }

}
