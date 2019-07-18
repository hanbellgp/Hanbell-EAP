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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C0160
 */
@Entity
@Table(name = "apmsys")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Apmsys.findAll", query = "SELECT a FROM Apmsys a"),
    @NamedQuery(name = "Apmsys.findById", query = "SELECT a FROM Apmsys a WHERE a.facno = :id"),
    @NamedQuery(name = "Apmsys.findByFacno", query = "SELECT a FROM Apmsys a WHERE a.facno = :facno")})
public class Apmsys implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "facno")
    private String facno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "kpcur")
    private short kpcur;
    @Basic(optional = false)
    @NotNull
    @Column(name = "kphis")
    private short kphis;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "coinctr")
    private String coinctr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "cstkd")
    private String cstkd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "chgcode")
    private String chgcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "autnrcode1")
    private String autnrcode1;
    @Size(max = 1)
    @Column(name = "autnrfnt1")
    private String autnrfnt1;
    @Size(max = 6)
    @Column(name = "autnrformat1")
    private String autnrformat1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "autnrcode2")
    private String autnrcode2;
    @Size(max = 1)
    @Column(name = "autnrfnt2")
    private String autnrfnt2;
    @Size(max = 6)
    @Column(name = "autnrformat2")
    private String autnrformat2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "autnrcode3")
    private String autnrcode3;
    @Size(max = 1)
    @Column(name = "autnrfnt3")
    private String autnrfnt3;
    @Size(max = 6)
    @Column(name = "autnrformat3")
    private String autnrformat3;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "autnrcode4")
    private String autnrcode4;
    @Size(max = 1)
    @Column(name = "autnrfnt4")
    private String autnrfnt4;
    @Size(max = 6)
    @Column(name = "autnrformat4")
    private String autnrformat4;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "autnrcode5")
    private String autnrcode5;
    @Size(max = 1)
    @Column(name = "autnrfnt5")
    private String autnrfnt5;
    @Size(max = 6)
    @Column(name = "autnrformat5")
    private String autnrformat5;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "autnrcode6")
    private String autnrcode6;
    @Size(max = 1)
    @Column(name = "autnrfnt6")
    private String autnrfnt6;
    @Size(max = 6)
    @Column(name = "autnrformat6")
    private String autnrformat6;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "autnrcode7")
    private String autnrcode7;
    @Size(max = 1)
    @Column(name = "autnrfnt7")
    private String autnrfnt7;
    @Size(max = 6)
    @Column(name = "autnrformat7")
    private String autnrformat7;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "autnrcode8")
    private String autnrcode8;
    @Size(max = 1)
    @Column(name = "autnrfnt8")
    private String autnrfnt8;
    @Size(max = 6)
    @Column(name = "autnrformat8")
    private String autnrformat8;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "autnrcode9")
    private String autnrcode9;
    @Size(max = 1)
    @Column(name = "autnrfnt9")
    private String autnrfnt9;
    @Size(max = 6)
    @Column(name = "autnrformat9")
    private String autnrformat9;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "autnrcode10")
    private String autnrcode10;
    @Size(max = 1)
    @Column(name = "autnrfnt10")
    private String autnrfnt10;
    @Size(max = 6)
    @Column(name = "autnrformat10")
    private String autnrformat10;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "autnrcode11")
    private String autnrcode11;
    @Size(max = 1)
    @Column(name = "autnrfnt11")
    private String autnrfnt11;
    @Size(max = 6)
    @Column(name = "autnrformat11")
    private String autnrformat11;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "autnrcode12")
    private String autnrcode12;
    @Size(max = 1)
    @Column(name = "autnrfnt12")
    private String autnrfnt12;
    @Size(max = 6)
    @Column(name = "autnrformat12")
    private String autnrformat12;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "autnrcode13")
    private String autnrcode13;
    @Size(max = 1)
    @Column(name = "autnrfnt13")
    private String autnrfnt13;
    @Size(max = 6)
    @Column(name = "autnrformat13")
    private String autnrformat13;
    @Size(max = 8)
    @Column(name = "acctno")
    private String acctno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ntskd")
    private String ntskd;
    @Column(name = "payda1")
    private Short payda1;
    @Column(name = "fdat1")
    private Short fdat1;
    @Column(name = "tdat1")
    private Short tdat1;
    @Column(name = "recda1")
    private Short recda1;
    @Column(name = "payda2")
    private Short payda2;
    @Column(name = "fdat2")
    private Short fdat2;
    @Column(name = "tdat2")
    private Short tdat2;
    @Column(name = "recda2")
    private Short recda2;
    @Column(name = "payda3")
    private Short payda3;
    @Column(name = "fdat3")
    private Short fdat3;
    @Column(name = "tdat3")
    private Short tdat3;
    @Column(name = "recda3")
    private Short recda3;
    @Column(name = "payda4")
    private Short payda4;
    @Column(name = "fdat4")
    private Short fdat4;
    @Column(name = "tdat4")
    private Short tdat4;
    @Column(name = "recda4")
    private Short recda4;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "postage")
    private BigDecimal postage;
    @Size(max = 8)
    @Column(name = "postno")
    private String postno;
    @Column(name = "ttamt")
    private BigDecimal ttamt;
    @Size(max = 8)
    @Column(name = "ttaccno")
    private String ttaccno;
    @Size(max = 8)
    @Column(name = "ttacctno")
    private String ttacctno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "yeamon")
    private String yeamon;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "aplym")
    private String aplym;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bilym")
    private short bilym;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "bilyn")
    private String bilyn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "aplyn")
    private String aplyn;
    @Size(max = 1)
    @Column(name = "cntcode")
    private String cntcode;
    @Column(name = "delyday")
    private Short delyday;
    @Size(max = 1)
    @Column(name = "autnrcode15")
    private String autnrcode15;
    @Size(max = 1)
    @Column(name = "autnrfnt15")
    private String autnrfnt15;
    @Size(max = 6)
    @Column(name = "autnrformat15")
    private String autnrformat15;
    @Size(max = 1)
    @Column(name = "autnrcode16")
    private String autnrcode16;
    @Size(max = 1)
    @Column(name = "autnrfnt16")
    private String autnrfnt16;
    @Size(max = 6)
    @Column(name = "autnrformat16")
    private String autnrformat16;
    @Size(max = 1)
    @Column(name = "autnrcode17")
    private String autnrcode17;
    @Size(max = 1)
    @Column(name = "autnrfnt17")
    private String autnrfnt17;
    @Size(max = 6)
    @Column(name = "autnrformat17")
    private String autnrformat17;
    @Column(name = "payterm")
    private Character payterm;
    @Size(max = 8)
    @Column(name = "psautoadjcode")
    private String psautoadjcode;
    @Size(max = 8)
    @Column(name = "msautoadjcode")
    private String msautoadjcode;
    @Size(max = 1)
    @Column(name = "autnrcode18")
    private String autnrcode18;
    @Size(max = 1)
    @Column(name = "autnrfnt18")
    private String autnrfnt18;
    @Size(max = 6)
    @Column(name = "autnrformat18")
    private String autnrformat18;
    @Size(max = 3)
    @Column(name = "subtrtype")
    private String subtrtype;
    @Column(name = "allowdiftax")
    private Character allowdiftax;
    @Column(name = "tttfmng")
    private Character tttfmng;
    @Column(name = "dtrapyh")
    private Character dtrapyh;

    public Apmsys() {
    }

    public Apmsys(String facno) {
        this.facno = facno;
    }

    public Apmsys(String facno, short kpcur, short kphis, String coinctr, String cstkd, String chgcode, String autnrcode1, String autnrcode2, String autnrcode3, String autnrcode4, String autnrcode5, String autnrcode6, String autnrcode7, String autnrcode8, String autnrcode9, String autnrcode10, String autnrcode11, String autnrcode12, String autnrcode13, String ntskd, String yeamon, String aplym, short bilym, String bilyn, String aplyn) {
        this.facno = facno;
        this.kpcur = kpcur;
        this.kphis = kphis;
        this.coinctr = coinctr;
        this.cstkd = cstkd;
        this.chgcode = chgcode;
        this.autnrcode1 = autnrcode1;
        this.autnrcode2 = autnrcode2;
        this.autnrcode3 = autnrcode3;
        this.autnrcode4 = autnrcode4;
        this.autnrcode5 = autnrcode5;
        this.autnrcode6 = autnrcode6;
        this.autnrcode7 = autnrcode7;
        this.autnrcode8 = autnrcode8;
        this.autnrcode9 = autnrcode9;
        this.autnrcode10 = autnrcode10;
        this.autnrcode11 = autnrcode11;
        this.autnrcode12 = autnrcode12;
        this.autnrcode13 = autnrcode13;
        this.ntskd = ntskd;
        this.yeamon = yeamon;
        this.aplym = aplym;
        this.bilym = bilym;
        this.bilyn = bilyn;
        this.aplyn = aplyn;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public short getKpcur() {
        return kpcur;
    }

    public void setKpcur(short kpcur) {
        this.kpcur = kpcur;
    }

    public short getKphis() {
        return kphis;
    }

    public void setKphis(short kphis) {
        this.kphis = kphis;
    }

    public String getCoinctr() {
        return coinctr;
    }

    public void setCoinctr(String coinctr) {
        this.coinctr = coinctr;
    }

    public String getCstkd() {
        return cstkd;
    }

    public void setCstkd(String cstkd) {
        this.cstkd = cstkd;
    }

    public String getChgcode() {
        return chgcode;
    }

    public void setChgcode(String chgcode) {
        this.chgcode = chgcode;
    }

    public String getAutnrcode1() {
        return autnrcode1;
    }

    public void setAutnrcode1(String autnrcode1) {
        this.autnrcode1 = autnrcode1;
    }

    public String getAutnrfnt1() {
        return autnrfnt1;
    }

    public void setAutnrfnt1(String autnrfnt1) {
        this.autnrfnt1 = autnrfnt1;
    }

    public String getAutnrformat1() {
        return autnrformat1;
    }

    public void setAutnrformat1(String autnrformat1) {
        this.autnrformat1 = autnrformat1;
    }

    public String getAutnrcode2() {
        return autnrcode2;
    }

    public void setAutnrcode2(String autnrcode2) {
        this.autnrcode2 = autnrcode2;
    }

    public String getAutnrfnt2() {
        return autnrfnt2;
    }

    public void setAutnrfnt2(String autnrfnt2) {
        this.autnrfnt2 = autnrfnt2;
    }

    public String getAutnrformat2() {
        return autnrformat2;
    }

    public void setAutnrformat2(String autnrformat2) {
        this.autnrformat2 = autnrformat2;
    }

    public String getAutnrcode3() {
        return autnrcode3;
    }

    public void setAutnrcode3(String autnrcode3) {
        this.autnrcode3 = autnrcode3;
    }

    public String getAutnrfnt3() {
        return autnrfnt3;
    }

    public void setAutnrfnt3(String autnrfnt3) {
        this.autnrfnt3 = autnrfnt3;
    }

    public String getAutnrformat3() {
        return autnrformat3;
    }

    public void setAutnrformat3(String autnrformat3) {
        this.autnrformat3 = autnrformat3;
    }

    public String getAutnrcode4() {
        return autnrcode4;
    }

    public void setAutnrcode4(String autnrcode4) {
        this.autnrcode4 = autnrcode4;
    }

    public String getAutnrfnt4() {
        return autnrfnt4;
    }

    public void setAutnrfnt4(String autnrfnt4) {
        this.autnrfnt4 = autnrfnt4;
    }

    public String getAutnrformat4() {
        return autnrformat4;
    }

    public void setAutnrformat4(String autnrformat4) {
        this.autnrformat4 = autnrformat4;
    }

    public String getAutnrcode5() {
        return autnrcode5;
    }

    public void setAutnrcode5(String autnrcode5) {
        this.autnrcode5 = autnrcode5;
    }

    public String getAutnrfnt5() {
        return autnrfnt5;
    }

    public void setAutnrfnt5(String autnrfnt5) {
        this.autnrfnt5 = autnrfnt5;
    }

    public String getAutnrformat5() {
        return autnrformat5;
    }

    public void setAutnrformat5(String autnrformat5) {
        this.autnrformat5 = autnrformat5;
    }

    public String getAutnrcode6() {
        return autnrcode6;
    }

    public void setAutnrcode6(String autnrcode6) {
        this.autnrcode6 = autnrcode6;
    }

    public String getAutnrfnt6() {
        return autnrfnt6;
    }

    public void setAutnrfnt6(String autnrfnt6) {
        this.autnrfnt6 = autnrfnt6;
    }

    public String getAutnrformat6() {
        return autnrformat6;
    }

    public void setAutnrformat6(String autnrformat6) {
        this.autnrformat6 = autnrformat6;
    }

    public String getAutnrcode7() {
        return autnrcode7;
    }

    public void setAutnrcode7(String autnrcode7) {
        this.autnrcode7 = autnrcode7;
    }

    public String getAutnrfnt7() {
        return autnrfnt7;
    }

    public void setAutnrfnt7(String autnrfnt7) {
        this.autnrfnt7 = autnrfnt7;
    }

    public String getAutnrformat7() {
        return autnrformat7;
    }

    public void setAutnrformat7(String autnrformat7) {
        this.autnrformat7 = autnrformat7;
    }

    public String getAutnrcode8() {
        return autnrcode8;
    }

    public void setAutnrcode8(String autnrcode8) {
        this.autnrcode8 = autnrcode8;
    }

    public String getAutnrfnt8() {
        return autnrfnt8;
    }

    public void setAutnrfnt8(String autnrfnt8) {
        this.autnrfnt8 = autnrfnt8;
    }

    public String getAutnrformat8() {
        return autnrformat8;
    }

    public void setAutnrformat8(String autnrformat8) {
        this.autnrformat8 = autnrformat8;
    }

    public String getAutnrcode9() {
        return autnrcode9;
    }

    public void setAutnrcode9(String autnrcode9) {
        this.autnrcode9 = autnrcode9;
    }

    public String getAutnrfnt9() {
        return autnrfnt9;
    }

    public void setAutnrfnt9(String autnrfnt9) {
        this.autnrfnt9 = autnrfnt9;
    }

    public String getAutnrformat9() {
        return autnrformat9;
    }

    public void setAutnrformat9(String autnrformat9) {
        this.autnrformat9 = autnrformat9;
    }

    public String getAutnrcode10() {
        return autnrcode10;
    }

    public void setAutnrcode10(String autnrcode10) {
        this.autnrcode10 = autnrcode10;
    }

    public String getAutnrfnt10() {
        return autnrfnt10;
    }

    public void setAutnrfnt10(String autnrfnt10) {
        this.autnrfnt10 = autnrfnt10;
    }

    public String getAutnrformat10() {
        return autnrformat10;
    }

    public void setAutnrformat10(String autnrformat10) {
        this.autnrformat10 = autnrformat10;
    }

    public String getAutnrcode11() {
        return autnrcode11;
    }

    public void setAutnrcode11(String autnrcode11) {
        this.autnrcode11 = autnrcode11;
    }

    public String getAutnrfnt11() {
        return autnrfnt11;
    }

    public void setAutnrfnt11(String autnrfnt11) {
        this.autnrfnt11 = autnrfnt11;
    }

    public String getAutnrformat11() {
        return autnrformat11;
    }

    public void setAutnrformat11(String autnrformat11) {
        this.autnrformat11 = autnrformat11;
    }

    public String getAutnrcode12() {
        return autnrcode12;
    }

    public void setAutnrcode12(String autnrcode12) {
        this.autnrcode12 = autnrcode12;
    }

    public String getAutnrfnt12() {
        return autnrfnt12;
    }

    public void setAutnrfnt12(String autnrfnt12) {
        this.autnrfnt12 = autnrfnt12;
    }

    public String getAutnrformat12() {
        return autnrformat12;
    }

    public void setAutnrformat12(String autnrformat12) {
        this.autnrformat12 = autnrformat12;
    }

    public String getAutnrcode13() {
        return autnrcode13;
    }

    public void setAutnrcode13(String autnrcode13) {
        this.autnrcode13 = autnrcode13;
    }

    public String getAutnrfnt13() {
        return autnrfnt13;
    }

    public void setAutnrfnt13(String autnrfnt13) {
        this.autnrfnt13 = autnrfnt13;
    }

    public String getAutnrformat13() {
        return autnrformat13;
    }

    public void setAutnrformat13(String autnrformat13) {
        this.autnrformat13 = autnrformat13;
    }

    public String getAcctno() {
        return acctno;
    }

    public void setAcctno(String acctno) {
        this.acctno = acctno;
    }

    public String getNtskd() {
        return ntskd;
    }

    public void setNtskd(String ntskd) {
        this.ntskd = ntskd;
    }

    public Short getPayda1() {
        return payda1;
    }

    public void setPayda1(Short payda1) {
        this.payda1 = payda1;
    }

    public Short getFdat1() {
        return fdat1;
    }

    public void setFdat1(Short fdat1) {
        this.fdat1 = fdat1;
    }

    public Short getTdat1() {
        return tdat1;
    }

    public void setTdat1(Short tdat1) {
        this.tdat1 = tdat1;
    }

    public Short getRecda1() {
        return recda1;
    }

    public void setRecda1(Short recda1) {
        this.recda1 = recda1;
    }

    public Short getPayda2() {
        return payda2;
    }

    public void setPayda2(Short payda2) {
        this.payda2 = payda2;
    }

    public Short getFdat2() {
        return fdat2;
    }

    public void setFdat2(Short fdat2) {
        this.fdat2 = fdat2;
    }

    public Short getTdat2() {
        return tdat2;
    }

    public void setTdat2(Short tdat2) {
        this.tdat2 = tdat2;
    }

    public Short getRecda2() {
        return recda2;
    }

    public void setRecda2(Short recda2) {
        this.recda2 = recda2;
    }

    public Short getPayda3() {
        return payda3;
    }

    public void setPayda3(Short payda3) {
        this.payda3 = payda3;
    }

    public Short getFdat3() {
        return fdat3;
    }

    public void setFdat3(Short fdat3) {
        this.fdat3 = fdat3;
    }

    public Short getTdat3() {
        return tdat3;
    }

    public void setTdat3(Short tdat3) {
        this.tdat3 = tdat3;
    }

    public Short getRecda3() {
        return recda3;
    }

    public void setRecda3(Short recda3) {
        this.recda3 = recda3;
    }

    public Short getPayda4() {
        return payda4;
    }

    public void setPayda4(Short payda4) {
        this.payda4 = payda4;
    }

    public Short getFdat4() {
        return fdat4;
    }

    public void setFdat4(Short fdat4) {
        this.fdat4 = fdat4;
    }

    public Short getTdat4() {
        return tdat4;
    }

    public void setTdat4(Short tdat4) {
        this.tdat4 = tdat4;
    }

    public Short getRecda4() {
        return recda4;
    }

    public void setRecda4(Short recda4) {
        this.recda4 = recda4;
    }

    public BigDecimal getPostage() {
        return postage;
    }

    public void setPostage(BigDecimal postage) {
        this.postage = postage;
    }

    public String getPostno() {
        return postno;
    }

    public void setPostno(String postno) {
        this.postno = postno;
    }

    public BigDecimal getTtamt() {
        return ttamt;
    }

    public void setTtamt(BigDecimal ttamt) {
        this.ttamt = ttamt;
    }

    public String getTtaccno() {
        return ttaccno;
    }

    public void setTtaccno(String ttaccno) {
        this.ttaccno = ttaccno;
    }

    public String getTtacctno() {
        return ttacctno;
    }

    public void setTtacctno(String ttacctno) {
        this.ttacctno = ttacctno;
    }

    public String getYeamon() {
        return yeamon;
    }

    public void setYeamon(String yeamon) {
        this.yeamon = yeamon;
    }

    public String getAplym() {
        return aplym;
    }

    public void setAplym(String aplym) {
        this.aplym = aplym;
    }

    public short getBilym() {
        return bilym;
    }

    public void setBilym(short bilym) {
        this.bilym = bilym;
    }

    public String getBilyn() {
        return bilyn;
    }

    public void setBilyn(String bilyn) {
        this.bilyn = bilyn;
    }

    public String getAplyn() {
        return aplyn;
    }

    public void setAplyn(String aplyn) {
        this.aplyn = aplyn;
    }

    public String getCntcode() {
        return cntcode;
    }

    public void setCntcode(String cntcode) {
        this.cntcode = cntcode;
    }

    public Short getDelyday() {
        return delyday;
    }

    public void setDelyday(Short delyday) {
        this.delyday = delyday;
    }

    public String getAutnrcode15() {
        return autnrcode15;
    }

    public void setAutnrcode15(String autnrcode15) {
        this.autnrcode15 = autnrcode15;
    }

    public String getAutnrfnt15() {
        return autnrfnt15;
    }

    public void setAutnrfnt15(String autnrfnt15) {
        this.autnrfnt15 = autnrfnt15;
    }

    public String getAutnrformat15() {
        return autnrformat15;
    }

    public void setAutnrformat15(String autnrformat15) {
        this.autnrformat15 = autnrformat15;
    }

    public String getAutnrcode16() {
        return autnrcode16;
    }

    public void setAutnrcode16(String autnrcode16) {
        this.autnrcode16 = autnrcode16;
    }

    public String getAutnrfnt16() {
        return autnrfnt16;
    }

    public void setAutnrfnt16(String autnrfnt16) {
        this.autnrfnt16 = autnrfnt16;
    }

    public String getAutnrformat16() {
        return autnrformat16;
    }

    public void setAutnrformat16(String autnrformat16) {
        this.autnrformat16 = autnrformat16;
    }

    public String getAutnrcode17() {
        return autnrcode17;
    }

    public void setAutnrcode17(String autnrcode17) {
        this.autnrcode17 = autnrcode17;
    }

    public String getAutnrfnt17() {
        return autnrfnt17;
    }

    public void setAutnrfnt17(String autnrfnt17) {
        this.autnrfnt17 = autnrfnt17;
    }

    public String getAutnrformat17() {
        return autnrformat17;
    }

    public void setAutnrformat17(String autnrformat17) {
        this.autnrformat17 = autnrformat17;
    }

    public Character getPayterm() {
        return payterm;
    }

    public void setPayterm(Character payterm) {
        this.payterm = payterm;
    }

    public String getPsautoadjcode() {
        return psautoadjcode;
    }

    public void setPsautoadjcode(String psautoadjcode) {
        this.psautoadjcode = psautoadjcode;
    }

    public String getMsautoadjcode() {
        return msautoadjcode;
    }

    public void setMsautoadjcode(String msautoadjcode) {
        this.msautoadjcode = msautoadjcode;
    }

    public String getAutnrcode18() {
        return autnrcode18;
    }

    public void setAutnrcode18(String autnrcode18) {
        this.autnrcode18 = autnrcode18;
    }

    public String getAutnrfnt18() {
        return autnrfnt18;
    }

    public void setAutnrfnt18(String autnrfnt18) {
        this.autnrfnt18 = autnrfnt18;
    }

    public String getAutnrformat18() {
        return autnrformat18;
    }

    public void setAutnrformat18(String autnrformat18) {
        this.autnrformat18 = autnrformat18;
    }

    public String getSubtrtype() {
        return subtrtype;
    }

    public void setSubtrtype(String subtrtype) {
        this.subtrtype = subtrtype;
    }

    public Character getAllowdiftax() {
        return allowdiftax;
    }

    public void setAllowdiftax(Character allowdiftax) {
        this.allowdiftax = allowdiftax;
    }

    public Character getTttfmng() {
        return tttfmng;
    }

    public void setTttfmng(Character tttfmng) {
        this.tttfmng = tttfmng;
    }

    public Character getDtrapyh() {
        return dtrapyh;
    }

    public void setDtrapyh(Character dtrapyh) {
        this.dtrapyh = dtrapyh;
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
        if (!(object instanceof Apmsys)) {
            return false;
        }
        Apmsys other = (Apmsys) object;
        if ((this.facno == null && other.facno != null) || (this.facno != null && !this.facno.equals(other.facno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Apmsys[ facno=" + facno + " ]";
    }

}
