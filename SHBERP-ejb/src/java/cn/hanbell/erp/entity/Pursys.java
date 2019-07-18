/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "pursys")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pursys.findAll", query = "SELECT p FROM Pursys p"),
    @NamedQuery(name = "Pursys.findByFacno", query = "SELECT p FROM Pursys p WHERE p.pursysPK.facno = :facno"),
    @NamedQuery(name = "Pursys.findByProno", query = "SELECT p FROM Pursys p WHERE p.pursysPK.prono = :prono"),
    @NamedQuery(name = "Pursys.findByHunprinum", query = "SELECT p FROM Pursys p WHERE p.hunprinum = :hunprinum"),
    @NamedQuery(name = "Pursys.findByHagprinum", query = "SELECT p FROM Pursys p WHERE p.hagprinum = :hagprinum"),  
    @NamedQuery(name = "Pursys.findByPK", query = "SELECT p FROM Pursys p WHERE p.pursysPK.facno = :facno AND p.pursysPK.prono = :prono")
})
public class Pursys implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PursysPK pursysPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hunprinum")
    private short hunprinum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hagprinum")
    private short hagprinum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "yearmon")
    private String yearmon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unpricode")
    private short unpricode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ekpmonth")
    private short ekpmonth;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hkpmonth")
    private short hkpmonth;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "buyer")
    private String buyer;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "uplimit")
    private BigDecimal uplimit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dnlimit")
    private BigDecimal dnlimit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prdircfm")
    private Character prdircfm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "podircfm")
    private Character podircfm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rvdircfm")
    private Character rvdircfm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bkdircfm")
    private Character bkdircfm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "addcode")
    private String addcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "addtype")
    private String addtype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "outtype")
    private String outtype;
    @Column(name = "keyinyn")
    private Character keyinyn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "buyeryn")
    private Character buyeryn;
    @Column(name = "badityn")
    private Character badityn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "budgetyn")
    private Character budgetyn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prautoyn")
    private Character prautoyn;
    @Column(name = "prautochar")
    private Character prautochar;
    @Size(max = 6)
    @Column(name = "prnofmt")
    private String prnofmt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "poautoyn")
    private Character poautoyn;
    @Column(name = "poautochar")
    private Character poautochar;
    @Size(max = 6)
    @Column(name = "ponofmt")
    private String ponofmt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rvautoyn")
    private Character rvautoyn;
    @Column(name = "rvautochar")
    private Character rvautochar;
    @Size(max = 6)
    @Column(name = "rvnofmt")
    private String rvnofmt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bkautoyn")
    private Character bkautoyn;
    @Column(name = "bkautochar")
    private Character bkautochar;
    @Size(max = 6)
    @Column(name = "bknofmt")
    private String bknofmt;
    @Size(max = 3)
    @Column(name = "badtrtype")
    private String badtrtype;
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
    @Size(max = 8)
    @Column(name = "cntype")
    private String cntype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aoautoyn")
    private Character aoautoyn;
    @Column(name = "aoautochar")
    private Character aoautochar;
    @Size(max = 6)
    @Column(name = "aonofmt")
    private String aonofmt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aoyn")
    private Character aoyn;
    @Size(max = 3)
    @Column(name = "asstype")
    private String asstype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "coautoyn")
    private Character coautoyn;
    @Column(name = "coautochar")
    private Character coautochar;
    @Size(max = 6)
    @Column(name = "conofmt")
    private String conofmt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "asautoyn")
    private Character asautoyn;
    @Column(name = "asautochar")
    private Character asautochar;
    @Size(max = 6)
    @Column(name = "asnofmt")
    private String asnofmt;
    @Column(name = "nopoyn")
    private Character nopoyn;
    @Column(name = "adddisp")
    private Character adddisp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "resetpri")
    private Character resetpri;
    @Basic(optional = false)
    @NotNull
    @Column(name = "setzero")
    private Character setzero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "overpreyn")
    private Character overpreyn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "isprndate")
    private String isprndate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "btyn")
    private Character btyn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "btautoyn")
    private Character btautoyn;
    @Column(name = "btautochar")
    private Character btautochar;
    @Size(max = 6)
    @Column(name = "btnofmt")
    private String btnofmt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "btretainpol1")
    private Character btretainpol1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "btretainpol2")
    private Character btretainpol2;
    @Size(max = 3)
    @Column(name = "dfbtpurtrtype")
    private String dfbtpurtrtype;
    @Size(max = 8)
    @Column(name = "dfbtprofaccno")
    private String dfbtprofaccno;
    @Size(max = 8)
    @Column(name = "dfbtlossaccno")
    private String dfbtlossaccno;
    @Size(max = 8)
    @Column(name = "relpurkind")
    private String relpurkind;
    @Size(max = 3)
    @Column(name = "fixtype")
    private String fixtype;
    @Size(max = 3)
    @Column(name = "dgctype")
    private String dgctype;
    @Column(name = "showdcode")
    private Character showdcode;
    @Size(max = 16)
    @Column(name = "tel")
    private String tel;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="电话/传真格式无效, 应为 xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 16)
    @Column(name = "fax")
    private String fax;
    @Column(name = "comyn")
    private Character comyn;
    @Size(max = 3)
    @Column(name = "exptype")
    private String exptype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "jityn")
    private Character jityn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "autoship")
    private Character autoship;
    @Basic(optional = false)
    @NotNull
    @Column(name = "freeapun")
    private Character freeapun;
    @Size(max = 8)
    @Column(name = "dftrivdrno")
    private String dftrivdrno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "prisref")
    private String prisref;
    @Column(name = "prmarksrc")
    private Character prmarksrc;
    @Column(name = "buyerdfsq")
    private Character buyerdfsq;
    @Size(max = 8)
    @Column(name = "cnmgn")
    private String cnmgn;
    @Column(name = "allowchgpoda")
    private Character allowchgpoda;
    @Column(name = "maxpdays")
    private Short maxpdays;
    @Column(name = "maxsdays")
    private Short maxsdays;
    @Column(name = "trancdrdircfm")
    private Character trancdrdircfm;

    public Pursys() {
    }

    public Pursys(PursysPK pursysPK) {
        this.pursysPK = pursysPK;
    }

    public Pursys(PursysPK pursysPK, short hunprinum, short hagprinum, String yearmon, short unpricode, short ekpmonth, short hkpmonth, String buyer, BigDecimal uplimit, BigDecimal dnlimit, Character prdircfm, Character podircfm, Character rvdircfm, Character bkdircfm, String addcode, String addtype, String outtype, Character buyeryn, Character budgetyn, Character prautoyn, Character poautoyn, Character rvautoyn, Character bkautoyn, Character aoautoyn, Character aoyn, Character coautoyn, Character asautoyn, Character resetpri, Character setzero, Character overpreyn, String isprndate, Character btyn, Character btautoyn, Character btretainpol1, Character btretainpol2, Character jityn, Character autoship, Character freeapun, String prisref) {
        this.pursysPK = pursysPK;
        this.hunprinum = hunprinum;
        this.hagprinum = hagprinum;
        this.yearmon = yearmon;
        this.unpricode = unpricode;
        this.ekpmonth = ekpmonth;
        this.hkpmonth = hkpmonth;
        this.buyer = buyer;
        this.uplimit = uplimit;
        this.dnlimit = dnlimit;
        this.prdircfm = prdircfm;
        this.podircfm = podircfm;
        this.rvdircfm = rvdircfm;
        this.bkdircfm = bkdircfm;
        this.addcode = addcode;
        this.addtype = addtype;
        this.outtype = outtype;
        this.buyeryn = buyeryn;
        this.budgetyn = budgetyn;
        this.prautoyn = prautoyn;
        this.poautoyn = poautoyn;
        this.rvautoyn = rvautoyn;
        this.bkautoyn = bkautoyn;
        this.aoautoyn = aoautoyn;
        this.aoyn = aoyn;
        this.coautoyn = coautoyn;
        this.asautoyn = asautoyn;
        this.resetpri = resetpri;
        this.setzero = setzero;
        this.overpreyn = overpreyn;
        this.isprndate = isprndate;
        this.btyn = btyn;
        this.btautoyn = btautoyn;
        this.btretainpol1 = btretainpol1;
        this.btretainpol2 = btretainpol2;
        this.jityn = jityn;
        this.autoship = autoship;
        this.freeapun = freeapun;
        this.prisref = prisref;
    }

    public Pursys(String facno, String prono) {
        this.pursysPK = new PursysPK(facno, prono);
    }

    public PursysPK getPursysPK() {
        return pursysPK;
    }

    public void setPursysPK(PursysPK pursysPK) {
        this.pursysPK = pursysPK;
    }

    public short getHunprinum() {
        return hunprinum;
    }

    public void setHunprinum(short hunprinum) {
        this.hunprinum = hunprinum;
    }

    public short getHagprinum() {
        return hagprinum;
    }

    public void setHagprinum(short hagprinum) {
        this.hagprinum = hagprinum;
    }

    public String getYearmon() {
        return yearmon;
    }

    public void setYearmon(String yearmon) {
        this.yearmon = yearmon;
    }

    public short getUnpricode() {
        return unpricode;
    }

    public void setUnpricode(short unpricode) {
        this.unpricode = unpricode;
    }

    public short getEkpmonth() {
        return ekpmonth;
    }

    public void setEkpmonth(short ekpmonth) {
        this.ekpmonth = ekpmonth;
    }

    public short getHkpmonth() {
        return hkpmonth;
    }

    public void setHkpmonth(short hkpmonth) {
        this.hkpmonth = hkpmonth;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
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

    public Character getPrdircfm() {
        return prdircfm;
    }

    public void setPrdircfm(Character prdircfm) {
        this.prdircfm = prdircfm;
    }

    public Character getPodircfm() {
        return podircfm;
    }

    public void setPodircfm(Character podircfm) {
        this.podircfm = podircfm;
    }

    public Character getRvdircfm() {
        return rvdircfm;
    }

    public void setRvdircfm(Character rvdircfm) {
        this.rvdircfm = rvdircfm;
    }

    public Character getBkdircfm() {
        return bkdircfm;
    }

    public void setBkdircfm(Character bkdircfm) {
        this.bkdircfm = bkdircfm;
    }

    public String getAddcode() {
        return addcode;
    }

    public void setAddcode(String addcode) {
        this.addcode = addcode;
    }

    public String getAddtype() {
        return addtype;
    }

    public void setAddtype(String addtype) {
        this.addtype = addtype;
    }

    public String getOuttype() {
        return outtype;
    }

    public void setOuttype(String outtype) {
        this.outtype = outtype;
    }

    public Character getKeyinyn() {
        return keyinyn;
    }

    public void setKeyinyn(Character keyinyn) {
        this.keyinyn = keyinyn;
    }

    public Character getBuyeryn() {
        return buyeryn;
    }

    public void setBuyeryn(Character buyeryn) {
        this.buyeryn = buyeryn;
    }

    public Character getBadityn() {
        return badityn;
    }

    public void setBadityn(Character badityn) {
        this.badityn = badityn;
    }

    public Character getBudgetyn() {
        return budgetyn;
    }

    public void setBudgetyn(Character budgetyn) {
        this.budgetyn = budgetyn;
    }

    public Character getPrautoyn() {
        return prautoyn;
    }

    public void setPrautoyn(Character prautoyn) {
        this.prautoyn = prautoyn;
    }

    public Character getPrautochar() {
        return prautochar;
    }

    public void setPrautochar(Character prautochar) {
        this.prautochar = prautochar;
    }

    public String getPrnofmt() {
        return prnofmt;
    }

    public void setPrnofmt(String prnofmt) {
        this.prnofmt = prnofmt;
    }

    public Character getPoautoyn() {
        return poautoyn;
    }

    public void setPoautoyn(Character poautoyn) {
        this.poautoyn = poautoyn;
    }

    public Character getPoautochar() {
        return poautochar;
    }

    public void setPoautochar(Character poautochar) {
        this.poautochar = poautochar;
    }

    public String getPonofmt() {
        return ponofmt;
    }

    public void setPonofmt(String ponofmt) {
        this.ponofmt = ponofmt;
    }

    public Character getRvautoyn() {
        return rvautoyn;
    }

    public void setRvautoyn(Character rvautoyn) {
        this.rvautoyn = rvautoyn;
    }

    public Character getRvautochar() {
        return rvautochar;
    }

    public void setRvautochar(Character rvautochar) {
        this.rvautochar = rvautochar;
    }

    public String getRvnofmt() {
        return rvnofmt;
    }

    public void setRvnofmt(String rvnofmt) {
        this.rvnofmt = rvnofmt;
    }

    public Character getBkautoyn() {
        return bkautoyn;
    }

    public void setBkautoyn(Character bkautoyn) {
        this.bkautoyn = bkautoyn;
    }

    public Character getBkautochar() {
        return bkautochar;
    }

    public void setBkautochar(Character bkautochar) {
        this.bkautochar = bkautochar;
    }

    public String getBknofmt() {
        return bknofmt;
    }

    public void setBknofmt(String bknofmt) {
        this.bknofmt = bknofmt;
    }

    public String getBadtrtype() {
        return badtrtype;
    }

    public void setBadtrtype(String badtrtype) {
        this.badtrtype = badtrtype;
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

    public String getCntype() {
        return cntype;
    }

    public void setCntype(String cntype) {
        this.cntype = cntype;
    }

    public Character getAoautoyn() {
        return aoautoyn;
    }

    public void setAoautoyn(Character aoautoyn) {
        this.aoautoyn = aoautoyn;
    }

    public Character getAoautochar() {
        return aoautochar;
    }

    public void setAoautochar(Character aoautochar) {
        this.aoautochar = aoautochar;
    }

    public String getAonofmt() {
        return aonofmt;
    }

    public void setAonofmt(String aonofmt) {
        this.aonofmt = aonofmt;
    }

    public Character getAoyn() {
        return aoyn;
    }

    public void setAoyn(Character aoyn) {
        this.aoyn = aoyn;
    }

    public String getAsstype() {
        return asstype;
    }

    public void setAsstype(String asstype) {
        this.asstype = asstype;
    }

    public Character getCoautoyn() {
        return coautoyn;
    }

    public void setCoautoyn(Character coautoyn) {
        this.coautoyn = coautoyn;
    }

    public Character getCoautochar() {
        return coautochar;
    }

    public void setCoautochar(Character coautochar) {
        this.coautochar = coautochar;
    }

    public String getConofmt() {
        return conofmt;
    }

    public void setConofmt(String conofmt) {
        this.conofmt = conofmt;
    }

    public Character getAsautoyn() {
        return asautoyn;
    }

    public void setAsautoyn(Character asautoyn) {
        this.asautoyn = asautoyn;
    }

    public Character getAsautochar() {
        return asautochar;
    }

    public void setAsautochar(Character asautochar) {
        this.asautochar = asautochar;
    }

    public String getAsnofmt() {
        return asnofmt;
    }

    public void setAsnofmt(String asnofmt) {
        this.asnofmt = asnofmt;
    }

    public Character getNopoyn() {
        return nopoyn;
    }

    public void setNopoyn(Character nopoyn) {
        this.nopoyn = nopoyn;
    }

    public Character getAdddisp() {
        return adddisp;
    }

    public void setAdddisp(Character adddisp) {
        this.adddisp = adddisp;
    }

    public Character getResetpri() {
        return resetpri;
    }

    public void setResetpri(Character resetpri) {
        this.resetpri = resetpri;
    }

    public Character getSetzero() {
        return setzero;
    }

    public void setSetzero(Character setzero) {
        this.setzero = setzero;
    }

    public Character getOverpreyn() {
        return overpreyn;
    }

    public void setOverpreyn(Character overpreyn) {
        this.overpreyn = overpreyn;
    }

    public String getIsprndate() {
        return isprndate;
    }

    public void setIsprndate(String isprndate) {
        this.isprndate = isprndate;
    }

    public Character getBtyn() {
        return btyn;
    }

    public void setBtyn(Character btyn) {
        this.btyn = btyn;
    }

    public Character getBtautoyn() {
        return btautoyn;
    }

    public void setBtautoyn(Character btautoyn) {
        this.btautoyn = btautoyn;
    }

    public Character getBtautochar() {
        return btautochar;
    }

    public void setBtautochar(Character btautochar) {
        this.btautochar = btautochar;
    }

    public String getBtnofmt() {
        return btnofmt;
    }

    public void setBtnofmt(String btnofmt) {
        this.btnofmt = btnofmt;
    }

    public Character getBtretainpol1() {
        return btretainpol1;
    }

    public void setBtretainpol1(Character btretainpol1) {
        this.btretainpol1 = btretainpol1;
    }

    public Character getBtretainpol2() {
        return btretainpol2;
    }

    public void setBtretainpol2(Character btretainpol2) {
        this.btretainpol2 = btretainpol2;
    }

    public String getDfbtpurtrtype() {
        return dfbtpurtrtype;
    }

    public void setDfbtpurtrtype(String dfbtpurtrtype) {
        this.dfbtpurtrtype = dfbtpurtrtype;
    }

    public String getDfbtprofaccno() {
        return dfbtprofaccno;
    }

    public void setDfbtprofaccno(String dfbtprofaccno) {
        this.dfbtprofaccno = dfbtprofaccno;
    }

    public String getDfbtlossaccno() {
        return dfbtlossaccno;
    }

    public void setDfbtlossaccno(String dfbtlossaccno) {
        this.dfbtlossaccno = dfbtlossaccno;
    }

    public String getRelpurkind() {
        return relpurkind;
    }

    public void setRelpurkind(String relpurkind) {
        this.relpurkind = relpurkind;
    }

    public String getFixtype() {
        return fixtype;
    }

    public void setFixtype(String fixtype) {
        this.fixtype = fixtype;
    }

    public String getDgctype() {
        return dgctype;
    }

    public void setDgctype(String dgctype) {
        this.dgctype = dgctype;
    }

    public Character getShowdcode() {
        return showdcode;
    }

    public void setShowdcode(Character showdcode) {
        this.showdcode = showdcode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Character getComyn() {
        return comyn;
    }

    public void setComyn(Character comyn) {
        this.comyn = comyn;
    }

    public String getExptype() {
        return exptype;
    }

    public void setExptype(String exptype) {
        this.exptype = exptype;
    }

    public Character getJityn() {
        return jityn;
    }

    public void setJityn(Character jityn) {
        this.jityn = jityn;
    }

    public Character getAutoship() {
        return autoship;
    }

    public void setAutoship(Character autoship) {
        this.autoship = autoship;
    }

    public Character getFreeapun() {
        return freeapun;
    }

    public void setFreeapun(Character freeapun) {
        this.freeapun = freeapun;
    }

    public String getDftrivdrno() {
        return dftrivdrno;
    }

    public void setDftrivdrno(String dftrivdrno) {
        this.dftrivdrno = dftrivdrno;
    }

    public String getPrisref() {
        return prisref;
    }

    public void setPrisref(String prisref) {
        this.prisref = prisref;
    }

    public Character getPrmarksrc() {
        return prmarksrc;
    }

    public void setPrmarksrc(Character prmarksrc) {
        this.prmarksrc = prmarksrc;
    }

    public Character getBuyerdfsq() {
        return buyerdfsq;
    }

    public void setBuyerdfsq(Character buyerdfsq) {
        this.buyerdfsq = buyerdfsq;
    }

    public String getCnmgn() {
        return cnmgn;
    }

    public void setCnmgn(String cnmgn) {
        this.cnmgn = cnmgn;
    }

    public Character getAllowchgpoda() {
        return allowchgpoda;
    }

    public void setAllowchgpoda(Character allowchgpoda) {
        this.allowchgpoda = allowchgpoda;
    }

    public Short getMaxpdays() {
        return maxpdays;
    }

    public void setMaxpdays(Short maxpdays) {
        this.maxpdays = maxpdays;
    }

    public Short getMaxsdays() {
        return maxsdays;
    }

    public void setMaxsdays(Short maxsdays) {
        this.maxsdays = maxsdays;
    }

    public Character getTrancdrdircfm() {
        return trancdrdircfm;
    }

    public void setTrancdrdircfm(Character trancdrdircfm) {
        this.trancdrdircfm = trancdrdircfm;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pursysPK != null ? pursysPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pursys)) {
            return false;
        }
        Pursys other = (Pursys) object;
        if ((this.pursysPK == null && other.pursysPK != null) || (this.pursysPK != null && !this.pursysPK.equals(other.pursysPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Pursys[ pursysPK=" + pursysPK + " ]";
    }
    
}
