/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
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
@Table(name = "cdrqbomsub")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdrqbomsub.findAll", query = "SELECT c FROM Cdrqbomsub c"),
    @NamedQuery(name = "Cdrqbomsub.findByFacno", query = "SELECT c FROM Cdrqbomsub c WHERE c.cdrqbomsubPK.facno = :facno"),
    @NamedQuery(name = "Cdrqbomsub.findByCdrno", query = "SELECT c FROM Cdrqbomsub c WHERE c.cdrqbomsubPK.cdrno = :cdrno"),
    @NamedQuery(name = "Cdrqbomsub.findByTrseq", query = "SELECT c FROM Cdrqbomsub c WHERE c.cdrqbomsubPK.trseq = :trseq"),
    @NamedQuery(name = "Cdrqbomsub.findByItnbrf", query = "SELECT c FROM Cdrqbomsub c WHERE c.itnbrf = :itnbrf"),
    @NamedQuery(name = "Cdrqbomsub.findByItnbrfAndCdrno", query = "SELECT c FROM Cdrqbomsub c WHERE c.cdrqbomsubPK.facno = :facno AND c.cdrqbomsubPK.cdrno = :cdrno AND c.itnbrf = :itnbrf"),
    @NamedQuery(name = "Cdrqbomsub.findByPK", query = "SELECT c FROM Cdrqbomsub c WHERE c.cdrqbomsubPK.facno = :facno AND c.cdrqbomsubPK.cdrno = :cdrno AND c.cdrqbomsubPK.trseq = :trseq")})
public class Cdrqbomsub implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CdrqbomsubPK cdrqbomsubPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "itnbrf")
    private String itnbrf;
    @Basic(optional = false)
    @NotNull
    @Column(name = "spcode")
    private Character spcode;
    @Size(max = 60)
    @Column(name = "spdesc")
    private String spdesc;
    @Size(max = 60)
    @Column(name = "spdesc2")
    private String spdesc2;
    @Size(max = 20)
    @Column(name = "itdesc1")
    private String itdesc1;
    @Size(max = 20)
    @Column(name = "itnbr1")
    private String itnbr1;
    @Size(max = 2)
    @Column(name = "itscode1")
    private String itscode1;
    @Size(max = 20)
    @Column(name = "itsdesc1")
    private String itsdesc1;
    @Size(max = 20)
    @Column(name = "itnbrs1")
    private String itnbrs1;
    @Size(max = 20)
    @Column(name = "itdesc2")
    private String itdesc2;
    @Size(max = 20)
    @Column(name = "itnbr2")
    private String itnbr2;
    @Size(max = 2)
    @Column(name = "itscode2")
    private String itscode2;
    @Size(max = 20)
    @Column(name = "itsdesc2")
    private String itsdesc2;
    @Size(max = 20)
    @Column(name = "itnbrs2")
    private String itnbrs2;
    @Size(max = 20)
    @Column(name = "itdesc3")
    private String itdesc3;
    @Size(max = 20)
    @Column(name = "itnbr3")
    private String itnbr3;
    @Size(max = 2)
    @Column(name = "itscode3")
    private String itscode3;
    @Size(max = 20)
    @Column(name = "itsdesc3")
    private String itsdesc3;
    @Size(max = 20)
    @Column(name = "itnbrs3")
    private String itnbrs3;
    @Size(max = 20)
    @Column(name = "itdesc4")
    private String itdesc4;
    @Size(max = 20)
    @Column(name = "itnbr4")
    private String itnbr4;
    @Size(max = 2)
    @Column(name = "itscode4")
    private String itscode4;
    @Size(max = 20)
    @Column(name = "itsdesc4")
    private String itsdesc4;
    @Size(max = 20)
    @Column(name = "itnbrs4")
    private String itnbrs4;
    @Size(max = 20)
    @Column(name = "itdesc5")
    private String itdesc5;
    @Size(max = 20)
    @Column(name = "itnbr5")
    private String itnbr5;
    @Size(max = 2)
    @Column(name = "itscode5")
    private String itscode5;
    @Size(max = 20)
    @Column(name = "itsdesc5")
    private String itsdesc5;
    @Size(max = 20)
    @Column(name = "itnbrs5")
    private String itnbrs5;
    @Size(max = 20)
    @Column(name = "itdesc6")
    private String itdesc6;
    @Size(max = 20)
    @Column(name = "itnbr6")
    private String itnbr6;
    @Size(max = 2)
    @Column(name = "itscode6")
    private String itscode6;
    @Size(max = 20)
    @Column(name = "itsdesc6")
    private String itsdesc6;
    @Size(max = 20)
    @Column(name = "itnbrs6")
    private String itnbrs6;
    @Size(max = 20)
    @Column(name = "itdesc7")
    private String itdesc7;
    @Size(max = 20)
    @Column(name = "itnbr7")
    private String itnbr7;
    @Size(max = 2)
    @Column(name = "itscode7")
    private String itscode7;
    @Size(max = 20)
    @Column(name = "itsdesc7")
    private String itsdesc7;
    @Size(max = 20)
    @Column(name = "itnbrs7")
    private String itnbrs7;
    @Size(max = 20)
    @Column(name = "itdesc8")
    private String itdesc8;
    @Size(max = 20)
    @Column(name = "itnbr8")
    private String itnbr8;
    @Size(max = 2)
    @Column(name = "itscode8")
    private String itscode8;
    @Size(max = 20)
    @Column(name = "itsdesc8")
    private String itsdesc8;
    @Size(max = 20)
    @Column(name = "itnbrs8")
    private String itnbrs8;
    @Size(max = 20)
    @Column(name = "itdesc9")
    private String itdesc9;
    @Size(max = 20)
    @Column(name = "itnbr9")
    private String itnbr9;
    @Size(max = 2)
    @Column(name = "itscode9")
    private String itscode9;
    @Size(max = 20)
    @Column(name = "itsdesc9")
    private String itsdesc9;
    @Size(max = 20)
    @Column(name = "itnbrs9")
    private String itnbrs9;
    @Size(max = 20)
    @Column(name = "itdesc10")
    private String itdesc10;
    @Size(max = 20)
    @Column(name = "itnbr10")
    private String itnbr10;
    @Size(max = 2)
    @Column(name = "itscode10")
    private String itscode10;
    @Size(max = 20)
    @Column(name = "itsdesc10")
    private String itsdesc10;
    @Size(max = 20)
    @Column(name = "itnbrs10")
    private String itnbrs10;
    @Size(max = 20)
    @Column(name = "itdesc11")
    private String itdesc11;
    @Size(max = 20)
    @Column(name = "itnbr11")
    private String itnbr11;
    @Size(max = 2)
    @Column(name = "itscode11")
    private String itscode11;
    @Size(max = 20)
    @Column(name = "itsdesc11")
    private String itsdesc11;
    @Size(max = 20)
    @Column(name = "itnbrs11")
    private String itnbrs11;
    @Size(max = 20)
    @Column(name = "itdesc12")
    private String itdesc12;
    @Size(max = 20)
    @Column(name = "itnbr12")
    private String itnbr12;
    @Size(max = 2)
    @Column(name = "itscode12")
    private String itscode12;
    @Size(max = 20)
    @Column(name = "itsdesc12")
    private String itsdesc12;
    @Size(max = 20)
    @Column(name = "itnbrs12")
    private String itnbrs12;
    @Size(max = 20)
    @Column(name = "itdesc13")
    private String itdesc13;
    @Size(max = 20)
    @Column(name = "itnbr13")
    private String itnbr13;
    @Size(max = 2)
    @Column(name = "itscode13")
    private String itscode13;
    @Size(max = 20)
    @Column(name = "itsdesc13")
    private String itsdesc13;
    @Size(max = 20)
    @Column(name = "itnbrs13")
    private String itnbrs13;
    @Size(max = 20)
    @Column(name = "itdesc14")
    private String itdesc14;
    @Size(max = 20)
    @Column(name = "itnbr14")
    private String itnbr14;
    @Size(max = 2)
    @Column(name = "itscode14")
    private String itscode14;
    @Size(max = 20)
    @Column(name = "itsdesc14")
    private String itsdesc14;
    @Size(max = 20)
    @Column(name = "itnbrs14")
    private String itnbrs14;
    @Size(max = 20)
    @Column(name = "itdesc15")
    private String itdesc15;
    @Size(max = 20)
    @Column(name = "itnbr15")
    private String itnbr15;
    @Size(max = 2)
    @Column(name = "itscode15")
    private String itscode15;
    @Size(max = 20)
    @Column(name = "itsdesc15")
    private String itsdesc15;
    @Size(max = 20)
    @Column(name = "itnbrs15")
    private String itnbrs15;
    @Size(max = 20)
    @Column(name = "itdesc16")
    private String itdesc16;
    @Size(max = 20)
    @Column(name = "itnbr16")
    private String itnbr16;
    @Size(max = 2)
    @Column(name = "itscode16")
    private String itscode16;
    @Size(max = 20)
    @Column(name = "itsdesc16")
    private String itsdesc16;
    @Size(max = 20)
    @Column(name = "itnbrs16")
    private String itnbrs16;
    @Size(max = 20)
    @Column(name = "itdesc17")
    private String itdesc17;
    @Size(max = 20)
    @Column(name = "itnbr17")
    private String itnbr17;
    @Size(max = 2)
    @Column(name = "itscode17")
    private String itscode17;
    @Size(max = 20)
    @Column(name = "itsdesc17")
    private String itsdesc17;
    @Size(max = 20)
    @Column(name = "itnbrs17")
    private String itnbrs17;
    @Size(max = 20)
    @Column(name = "itdesc18")
    private String itdesc18;
    @Size(max = 20)
    @Column(name = "itnbr18")
    private String itnbr18;
    @Size(max = 2)
    @Column(name = "itscode18")
    private String itscode18;
    @Size(max = 20)
    @Column(name = "itsdesc18")
    private String itsdesc18;
    @Size(max = 20)
    @Column(name = "itnbrs18")
    private String itnbrs18;
    @Size(max = 20)
    @Column(name = "itdesc19")
    private String itdesc19;
    @Size(max = 20)
    @Column(name = "itnbr19")
    private String itnbr19;
    @Size(max = 2)
    @Column(name = "itscode19")
    private String itscode19;
    @Size(max = 20)
    @Column(name = "itsdesc19")
    private String itsdesc19;
    @Size(max = 20)
    @Column(name = "itnbrs19")
    private String itnbrs19;
    @Size(max = 20)
    @Column(name = "itdesc20")
    private String itdesc20;
    @Size(max = 20)
    @Column(name = "itnbr20")
    private String itnbr20;
    @Size(max = 2)
    @Column(name = "itscode20")
    private String itscode20;
    @Size(max = 20)
    @Column(name = "itsdesc20")
    private String itsdesc20;
    @Size(max = 20)
    @Column(name = "itnbrs20")
    private String itnbrs20;
    @Size(max = 20)
    @Column(name = "itdesc21")
    private String itdesc21;
    @Size(max = 20)
    @Column(name = "itnbr21")
    private String itnbr21;
    @Size(max = 2)
    @Column(name = "itscode21")
    private String itscode21;
    @Size(max = 20)
    @Column(name = "itsdesc21")
    private String itsdesc21;
    @Size(max = 20)
    @Column(name = "itnbrs21")
    private String itnbrs21;
    @Size(max = 20)
    @Column(name = "itdesc22")
    private String itdesc22;
    @Size(max = 20)
    @Column(name = "itnbr22")
    private String itnbr22;
    @Size(max = 2)
    @Column(name = "itscode22")
    private String itscode22;
    @Size(max = 20)
    @Column(name = "itsdesc22")
    private String itsdesc22;
    @Size(max = 20)
    @Column(name = "itnbrs22")
    private String itnbrs22;
    @Size(max = 20)
    @Column(name = "itdesc23")
    private String itdesc23;
    @Size(max = 20)
    @Column(name = "itnbr23")
    private String itnbr23;
    @Size(max = 2)
    @Column(name = "itscode23")
    private String itscode23;
    @Size(max = 20)
    @Column(name = "itsdesc23")
    private String itsdesc23;
    @Size(max = 20)
    @Column(name = "itnbrs23")
    private String itnbrs23;
    @Size(max = 20)
    @Column(name = "itdesc24")
    private String itdesc24;
    @Size(max = 20)
    @Column(name = "itnbr24")
    private String itnbr24;
    @Size(max = 2)
    @Column(name = "itscode24")
    private String itscode24;
    @Size(max = 20)
    @Column(name = "itsdesc24")
    private String itsdesc24;
    @Size(max = 20)
    @Column(name = "itnbrs24")
    private String itnbrs24;
    @Size(max = 20)
    @Column(name = "itdesc25")
    private String itdesc25;
    @Size(max = 20)
    @Column(name = "itnbr25")
    private String itnbr25;
    @Size(max = 2)
    @Column(name = "itscode25")
    private String itscode25;
    @Size(max = 20)
    @Column(name = "itsdesc25")
    private String itsdesc25;
    @Size(max = 20)
    @Column(name = "itnbrs25")
    private String itnbrs25;

    public Cdrqbomsub() {
    }

    public Cdrqbomsub(CdrqbomsubPK cdrqbomsubPK) {
        this.cdrqbomsubPK = cdrqbomsubPK;
    }

    public Cdrqbomsub(CdrqbomsubPK cdrqbomsubPK, String itnbrf, Character spcode) {
        this.cdrqbomsubPK = cdrqbomsubPK;
        this.itnbrf = itnbrf;
        this.spcode = spcode;
    }

    public Cdrqbomsub(String facno, String cdrno, short trseq) {
        this.cdrqbomsubPK = new CdrqbomsubPK(facno, cdrno, trseq);
    }

    public CdrqbomsubPK getCdrqbomsubPK() {
        return cdrqbomsubPK;
    }

    public void setCdrqbomsubPK(CdrqbomsubPK cdrqbomsubPK) {
        this.cdrqbomsubPK = cdrqbomsubPK;
    }

    public String getItnbrf() {
        return itnbrf;
    }

    public void setItnbrf(String itnbrf) {
        this.itnbrf = itnbrf;
    }

    public Character getSpcode() {
        return spcode;
    }

    public void setSpcode(Character spcode) {
        this.spcode = spcode;
    }

    public String getSpdesc() {
        return spdesc;
    }

    public void setSpdesc(String spdesc) {
        this.spdesc = spdesc;
    }

    public String getSpdesc2() {
        return spdesc2;
    }

    public void setSpdesc2(String spdesc2) {
        this.spdesc2 = spdesc2;
    }

    public String getItdesc1() {
        return itdesc1;
    }

    public void setItdesc1(String itdesc1) {
        this.itdesc1 = itdesc1;
    }

    public String getItnbr1() {
        return itnbr1;
    }

    public void setItnbr1(String itnbr1) {
        this.itnbr1 = itnbr1;
    }

    public String getItscode1() {
        return itscode1;
    }

    public void setItscode1(String itscode1) {
        this.itscode1 = itscode1;
    }

    public String getItsdesc1() {
        return itsdesc1;
    }

    public void setItsdesc1(String itsdesc1) {
        this.itsdesc1 = itsdesc1;
    }

    public String getItnbrs1() {
        return itnbrs1;
    }

    public void setItnbrs1(String itnbrs1) {
        this.itnbrs1 = itnbrs1;
    }

    public String getItdesc2() {
        return itdesc2;
    }

    public void setItdesc2(String itdesc2) {
        this.itdesc2 = itdesc2;
    }

    public String getItnbr2() {
        return itnbr2;
    }

    public void setItnbr2(String itnbr2) {
        this.itnbr2 = itnbr2;
    }

    public String getItscode2() {
        return itscode2;
    }

    public void setItscode2(String itscode2) {
        this.itscode2 = itscode2;
    }

    public String getItsdesc2() {
        return itsdesc2;
    }

    public void setItsdesc2(String itsdesc2) {
        this.itsdesc2 = itsdesc2;
    }

    public String getItnbrs2() {
        return itnbrs2;
    }

    public void setItnbrs2(String itnbrs2) {
        this.itnbrs2 = itnbrs2;
    }

    public String getItdesc3() {
        return itdesc3;
    }

    public void setItdesc3(String itdesc3) {
        this.itdesc3 = itdesc3;
    }

    public String getItnbr3() {
        return itnbr3;
    }

    public void setItnbr3(String itnbr3) {
        this.itnbr3 = itnbr3;
    }

    public String getItscode3() {
        return itscode3;
    }

    public void setItscode3(String itscode3) {
        this.itscode3 = itscode3;
    }

    public String getItsdesc3() {
        return itsdesc3;
    }

    public void setItsdesc3(String itsdesc3) {
        this.itsdesc3 = itsdesc3;
    }

    public String getItnbrs3() {
        return itnbrs3;
    }

    public void setItnbrs3(String itnbrs3) {
        this.itnbrs3 = itnbrs3;
    }

    public String getItdesc4() {
        return itdesc4;
    }

    public void setItdesc4(String itdesc4) {
        this.itdesc4 = itdesc4;
    }

    public String getItnbr4() {
        return itnbr4;
    }

    public void setItnbr4(String itnbr4) {
        this.itnbr4 = itnbr4;
    }

    public String getItscode4() {
        return itscode4;
    }

    public void setItscode4(String itscode4) {
        this.itscode4 = itscode4;
    }

    public String getItsdesc4() {
        return itsdesc4;
    }

    public void setItsdesc4(String itsdesc4) {
        this.itsdesc4 = itsdesc4;
    }

    public String getItnbrs4() {
        return itnbrs4;
    }

    public void setItnbrs4(String itnbrs4) {
        this.itnbrs4 = itnbrs4;
    }

    public String getItdesc5() {
        return itdesc5;
    }

    public void setItdesc5(String itdesc5) {
        this.itdesc5 = itdesc5;
    }

    public String getItnbr5() {
        return itnbr5;
    }

    public void setItnbr5(String itnbr5) {
        this.itnbr5 = itnbr5;
    }

    public String getItscode5() {
        return itscode5;
    }

    public void setItscode5(String itscode5) {
        this.itscode5 = itscode5;
    }

    public String getItsdesc5() {
        return itsdesc5;
    }

    public void setItsdesc5(String itsdesc5) {
        this.itsdesc5 = itsdesc5;
    }

    public String getItnbrs5() {
        return itnbrs5;
    }

    public void setItnbrs5(String itnbrs5) {
        this.itnbrs5 = itnbrs5;
    }

    public String getItdesc6() {
        return itdesc6;
    }

    public void setItdesc6(String itdesc6) {
        this.itdesc6 = itdesc6;
    }

    public String getItnbr6() {
        return itnbr6;
    }

    public void setItnbr6(String itnbr6) {
        this.itnbr6 = itnbr6;
    }

    public String getItscode6() {
        return itscode6;
    }

    public void setItscode6(String itscode6) {
        this.itscode6 = itscode6;
    }

    public String getItsdesc6() {
        return itsdesc6;
    }

    public void setItsdesc6(String itsdesc6) {
        this.itsdesc6 = itsdesc6;
    }

    public String getItnbrs6() {
        return itnbrs6;
    }

    public void setItnbrs6(String itnbrs6) {
        this.itnbrs6 = itnbrs6;
    }

    public String getItdesc7() {
        return itdesc7;
    }

    public void setItdesc7(String itdesc7) {
        this.itdesc7 = itdesc7;
    }

    public String getItnbr7() {
        return itnbr7;
    }

    public void setItnbr7(String itnbr7) {
        this.itnbr7 = itnbr7;
    }

    public String getItscode7() {
        return itscode7;
    }

    public void setItscode7(String itscode7) {
        this.itscode7 = itscode7;
    }

    public String getItsdesc7() {
        return itsdesc7;
    }

    public void setItsdesc7(String itsdesc7) {
        this.itsdesc7 = itsdesc7;
    }

    public String getItnbrs7() {
        return itnbrs7;
    }

    public void setItnbrs7(String itnbrs7) {
        this.itnbrs7 = itnbrs7;
    }

    public String getItdesc8() {
        return itdesc8;
    }

    public void setItdesc8(String itdesc8) {
        this.itdesc8 = itdesc8;
    }

    public String getItnbr8() {
        return itnbr8;
    }

    public void setItnbr8(String itnbr8) {
        this.itnbr8 = itnbr8;
    }

    public String getItscode8() {
        return itscode8;
    }

    public void setItscode8(String itscode8) {
        this.itscode8 = itscode8;
    }

    public String getItsdesc8() {
        return itsdesc8;
    }

    public void setItsdesc8(String itsdesc8) {
        this.itsdesc8 = itsdesc8;
    }

    public String getItnbrs8() {
        return itnbrs8;
    }

    public void setItnbrs8(String itnbrs8) {
        this.itnbrs8 = itnbrs8;
    }

    public String getItdesc9() {
        return itdesc9;
    }

    public void setItdesc9(String itdesc9) {
        this.itdesc9 = itdesc9;
    }

    public String getItnbr9() {
        return itnbr9;
    }

    public void setItnbr9(String itnbr9) {
        this.itnbr9 = itnbr9;
    }

    public String getItscode9() {
        return itscode9;
    }

    public void setItscode9(String itscode9) {
        this.itscode9 = itscode9;
    }

    public String getItsdesc9() {
        return itsdesc9;
    }

    public void setItsdesc9(String itsdesc9) {
        this.itsdesc9 = itsdesc9;
    }

    public String getItnbrs9() {
        return itnbrs9;
    }

    public void setItnbrs9(String itnbrs9) {
        this.itnbrs9 = itnbrs9;
    }

    public String getItdesc10() {
        return itdesc10;
    }

    public void setItdesc10(String itdesc10) {
        this.itdesc10 = itdesc10;
    }

    public String getItnbr10() {
        return itnbr10;
    }

    public void setItnbr10(String itnbr10) {
        this.itnbr10 = itnbr10;
    }

    public String getItscode10() {
        return itscode10;
    }

    public void setItscode10(String itscode10) {
        this.itscode10 = itscode10;
    }

    public String getItsdesc10() {
        return itsdesc10;
    }

    public void setItsdesc10(String itsdesc10) {
        this.itsdesc10 = itsdesc10;
    }

    public String getItnbrs10() {
        return itnbrs10;
    }

    public void setItnbrs10(String itnbrs10) {
        this.itnbrs10 = itnbrs10;
    }

    public String getItdesc11() {
        return itdesc11;
    }

    public void setItdesc11(String itdesc11) {
        this.itdesc11 = itdesc11;
    }

    public String getItnbr11() {
        return itnbr11;
    }

    public void setItnbr11(String itnbr11) {
        this.itnbr11 = itnbr11;
    }

    public String getItscode11() {
        return itscode11;
    }

    public void setItscode11(String itscode11) {
        this.itscode11 = itscode11;
    }

    public String getItsdesc11() {
        return itsdesc11;
    }

    public void setItsdesc11(String itsdesc11) {
        this.itsdesc11 = itsdesc11;
    }

    public String getItnbrs11() {
        return itnbrs11;
    }

    public void setItnbrs11(String itnbrs11) {
        this.itnbrs11 = itnbrs11;
    }

    public String getItdesc12() {
        return itdesc12;
    }

    public void setItdesc12(String itdesc12) {
        this.itdesc12 = itdesc12;
    }

    public String getItnbr12() {
        return itnbr12;
    }

    public void setItnbr12(String itnbr12) {
        this.itnbr12 = itnbr12;
    }

    public String getItscode12() {
        return itscode12;
    }

    public void setItscode12(String itscode12) {
        this.itscode12 = itscode12;
    }

    public String getItsdesc12() {
        return itsdesc12;
    }

    public void setItsdesc12(String itsdesc12) {
        this.itsdesc12 = itsdesc12;
    }

    public String getItnbrs12() {
        return itnbrs12;
    }

    public void setItnbrs12(String itnbrs12) {
        this.itnbrs12 = itnbrs12;
    }

    public String getItdesc13() {
        return itdesc13;
    }

    public void setItdesc13(String itdesc13) {
        this.itdesc13 = itdesc13;
    }

    public String getItnbr13() {
        return itnbr13;
    }

    public void setItnbr13(String itnbr13) {
        this.itnbr13 = itnbr13;
    }

    public String getItscode13() {
        return itscode13;
    }

    public void setItscode13(String itscode13) {
        this.itscode13 = itscode13;
    }

    public String getItsdesc13() {
        return itsdesc13;
    }

    public void setItsdesc13(String itsdesc13) {
        this.itsdesc13 = itsdesc13;
    }

    public String getItnbrs13() {
        return itnbrs13;
    }

    public void setItnbrs13(String itnbrs13) {
        this.itnbrs13 = itnbrs13;
    }

    public String getItdesc14() {
        return itdesc14;
    }

    public void setItdesc14(String itdesc14) {
        this.itdesc14 = itdesc14;
    }

    public String getItnbr14() {
        return itnbr14;
    }

    public void setItnbr14(String itnbr14) {
        this.itnbr14 = itnbr14;
    }

    public String getItscode14() {
        return itscode14;
    }

    public void setItscode14(String itscode14) {
        this.itscode14 = itscode14;
    }

    public String getItsdesc14() {
        return itsdesc14;
    }

    public void setItsdesc14(String itsdesc14) {
        this.itsdesc14 = itsdesc14;
    }

    public String getItnbrs14() {
        return itnbrs14;
    }

    public void setItnbrs14(String itnbrs14) {
        this.itnbrs14 = itnbrs14;
    }

    public String getItdesc15() {
        return itdesc15;
    }

    public void setItdesc15(String itdesc15) {
        this.itdesc15 = itdesc15;
    }

    public String getItnbr15() {
        return itnbr15;
    }

    public void setItnbr15(String itnbr15) {
        this.itnbr15 = itnbr15;
    }

    public String getItscode15() {
        return itscode15;
    }

    public void setItscode15(String itscode15) {
        this.itscode15 = itscode15;
    }

    public String getItsdesc15() {
        return itsdesc15;
    }

    public void setItsdesc15(String itsdesc15) {
        this.itsdesc15 = itsdesc15;
    }

    public String getItnbrs15() {
        return itnbrs15;
    }

    public void setItnbrs15(String itnbrs15) {
        this.itnbrs15 = itnbrs15;
    }

    public String getItdesc16() {
        return itdesc16;
    }

    public void setItdesc16(String itdesc16) {
        this.itdesc16 = itdesc16;
    }

    public String getItnbr16() {
        return itnbr16;
    }

    public void setItnbr16(String itnbr16) {
        this.itnbr16 = itnbr16;
    }

    public String getItscode16() {
        return itscode16;
    }

    public void setItscode16(String itscode16) {
        this.itscode16 = itscode16;
    }

    public String getItsdesc16() {
        return itsdesc16;
    }

    public void setItsdesc16(String itsdesc16) {
        this.itsdesc16 = itsdesc16;
    }

    public String getItnbrs16() {
        return itnbrs16;
    }

    public void setItnbrs16(String itnbrs16) {
        this.itnbrs16 = itnbrs16;
    }

    public String getItdesc17() {
        return itdesc17;
    }

    public void setItdesc17(String itdesc17) {
        this.itdesc17 = itdesc17;
    }

    public String getItnbr17() {
        return itnbr17;
    }

    public void setItnbr17(String itnbr17) {
        this.itnbr17 = itnbr17;
    }

    public String getItscode17() {
        return itscode17;
    }

    public void setItscode17(String itscode17) {
        this.itscode17 = itscode17;
    }

    public String getItsdesc17() {
        return itsdesc17;
    }

    public void setItsdesc17(String itsdesc17) {
        this.itsdesc17 = itsdesc17;
    }

    public String getItnbrs17() {
        return itnbrs17;
    }

    public void setItnbrs17(String itnbrs17) {
        this.itnbrs17 = itnbrs17;
    }

    public String getItdesc18() {
        return itdesc18;
    }

    public void setItdesc18(String itdesc18) {
        this.itdesc18 = itdesc18;
    }

    public String getItnbr18() {
        return itnbr18;
    }

    public void setItnbr18(String itnbr18) {
        this.itnbr18 = itnbr18;
    }

    public String getItscode18() {
        return itscode18;
    }

    public void setItscode18(String itscode18) {
        this.itscode18 = itscode18;
    }

    public String getItsdesc18() {
        return itsdesc18;
    }

    public void setItsdesc18(String itsdesc18) {
        this.itsdesc18 = itsdesc18;
    }

    public String getItnbrs18() {
        return itnbrs18;
    }

    public void setItnbrs18(String itnbrs18) {
        this.itnbrs18 = itnbrs18;
    }

    public String getItdesc19() {
        return itdesc19;
    }

    public void setItdesc19(String itdesc19) {
        this.itdesc19 = itdesc19;
    }

    public String getItnbr19() {
        return itnbr19;
    }

    public void setItnbr19(String itnbr19) {
        this.itnbr19 = itnbr19;
    }

    public String getItscode19() {
        return itscode19;
    }

    public void setItscode19(String itscode19) {
        this.itscode19 = itscode19;
    }

    public String getItsdesc19() {
        return itsdesc19;
    }

    public void setItsdesc19(String itsdesc19) {
        this.itsdesc19 = itsdesc19;
    }

    public String getItnbrs19() {
        return itnbrs19;
    }

    public void setItnbrs19(String itnbrs19) {
        this.itnbrs19 = itnbrs19;
    }

    public String getItdesc20() {
        return itdesc20;
    }

    public void setItdesc20(String itdesc20) {
        this.itdesc20 = itdesc20;
    }

    public String getItnbr20() {
        return itnbr20;
    }

    public void setItnbr20(String itnbr20) {
        this.itnbr20 = itnbr20;
    }

    public String getItscode20() {
        return itscode20;
    }

    public void setItscode20(String itscode20) {
        this.itscode20 = itscode20;
    }

    public String getItsdesc20() {
        return itsdesc20;
    }

    public void setItsdesc20(String itsdesc20) {
        this.itsdesc20 = itsdesc20;
    }

    public String getItnbrs20() {
        return itnbrs20;
    }

    public void setItnbrs20(String itnbrs20) {
        this.itnbrs20 = itnbrs20;
    }

    public String getItdesc21() {
        return itdesc21;
    }

    public void setItdesc21(String itdesc21) {
        this.itdesc21 = itdesc21;
    }

    public String getItnbr21() {
        return itnbr21;
    }

    public void setItnbr21(String itnbr21) {
        this.itnbr21 = itnbr21;
    }

    public String getItscode21() {
        return itscode21;
    }

    public void setItscode21(String itscode21) {
        this.itscode21 = itscode21;
    }

    public String getItsdesc21() {
        return itsdesc21;
    }

    public void setItsdesc21(String itsdesc21) {
        this.itsdesc21 = itsdesc21;
    }

    public String getItnbrs21() {
        return itnbrs21;
    }

    public void setItnbrs21(String itnbrs21) {
        this.itnbrs21 = itnbrs21;
    }

    public String getItdesc22() {
        return itdesc22;
    }

    public void setItdesc22(String itdesc22) {
        this.itdesc22 = itdesc22;
    }

    public String getItnbr22() {
        return itnbr22;
    }

    public void setItnbr22(String itnbr22) {
        this.itnbr22 = itnbr22;
    }

    public String getItscode22() {
        return itscode22;
    }

    public void setItscode22(String itscode22) {
        this.itscode22 = itscode22;
    }

    public String getItsdesc22() {
        return itsdesc22;
    }

    public void setItsdesc22(String itsdesc22) {
        this.itsdesc22 = itsdesc22;
    }

    public String getItnbrs22() {
        return itnbrs22;
    }

    public void setItnbrs22(String itnbrs22) {
        this.itnbrs22 = itnbrs22;
    }

    public String getItdesc23() {
        return itdesc23;
    }

    public void setItdesc23(String itdesc23) {
        this.itdesc23 = itdesc23;
    }

    public String getItnbr23() {
        return itnbr23;
    }

    public void setItnbr23(String itnbr23) {
        this.itnbr23 = itnbr23;
    }

    public String getItscode23() {
        return itscode23;
    }

    public void setItscode23(String itscode23) {
        this.itscode23 = itscode23;
    }

    public String getItsdesc23() {
        return itsdesc23;
    }

    public void setItsdesc23(String itsdesc23) {
        this.itsdesc23 = itsdesc23;
    }

    public String getItnbrs23() {
        return itnbrs23;
    }

    public void setItnbrs23(String itnbrs23) {
        this.itnbrs23 = itnbrs23;
    }

    public String getItdesc24() {
        return itdesc24;
    }

    public void setItdesc24(String itdesc24) {
        this.itdesc24 = itdesc24;
    }

    public String getItnbr24() {
        return itnbr24;
    }

    public void setItnbr24(String itnbr24) {
        this.itnbr24 = itnbr24;
    }

    public String getItscode24() {
        return itscode24;
    }

    public void setItscode24(String itscode24) {
        this.itscode24 = itscode24;
    }

    public String getItsdesc24() {
        return itsdesc24;
    }

    public void setItsdesc24(String itsdesc24) {
        this.itsdesc24 = itsdesc24;
    }

    public String getItnbrs24() {
        return itnbrs24;
    }

    public void setItnbrs24(String itnbrs24) {
        this.itnbrs24 = itnbrs24;
    }

    public String getItdesc25() {
        return itdesc25;
    }

    public void setItdesc25(String itdesc25) {
        this.itdesc25 = itdesc25;
    }

    public String getItnbr25() {
        return itnbr25;
    }

    public void setItnbr25(String itnbr25) {
        this.itnbr25 = itnbr25;
    }

    public String getItscode25() {
        return itscode25;
    }

    public void setItscode25(String itscode25) {
        this.itscode25 = itscode25;
    }

    public String getItsdesc25() {
        return itsdesc25;
    }

    public void setItsdesc25(String itsdesc25) {
        this.itsdesc25 = itsdesc25;
    }

    public String getItnbrs25() {
        return itnbrs25;
    }

    public void setItnbrs25(String itnbrs25) {
        this.itnbrs25 = itnbrs25;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdrqbomsubPK != null ? cdrqbomsubPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cdrqbomsub)) {
            return false;
        }
        Cdrqbomsub other = (Cdrqbomsub) object;
        if ((this.cdrqbomsubPK == null && other.cdrqbomsubPK != null) || (this.cdrqbomsubPK != null && !this.cdrqbomsubPK.equals(other.cdrqbomsubPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Cdrqbomsub[ cdrqbomsubPK=" + cdrqbomsubPK + " ]";
    }

}
