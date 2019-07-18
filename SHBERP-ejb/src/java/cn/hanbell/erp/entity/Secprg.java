/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
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
@Table(name = "secprg")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Secprg.findAll", query = "SELECT s FROM Secprg s"),
    @NamedQuery(name = "Secprg.findByPrgno", query = "SELECT s FROM Secprg s WHERE s.prgno = :prgno"),
    @NamedQuery(name = "Secprg.findByPrgname", query = "SELECT s FROM Secprg s WHERE s.prgname = :prgname"),
    @NamedQuery(name = "Secprg.findByProgram", query = "SELECT s FROM Secprg s WHERE s.program = :program"),
    @NamedQuery(name = "Secprg.findByPrgtype", query = "SELECT s FROM Secprg s WHERE s.prgtype = :prgtype")})
public class Secprg implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "prgno")
    private String prgno;
    @Size(max = 48)
    @Column(name = "prgname")
    private String prgname;
    @Size(max = 255)
    @Column(name = "program")
    private String program;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prgtype")
    private Character prgtype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enabled")
    private Character enabled;
    @Basic(optional = false)
    @NotNull
    @Column(name = "padd")
    private Character padd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pdelete")
    private Character pdelete;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pmodify")
    private Character pmodify;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pquery")
    private Character pquery;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pprint")
    private Character pprint;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pcommit")
    private Character pcommit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pcancel")
    private Character pcancel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unitask")
    private Character unitask;
    @Basic(optional = false)
    @NotNull
    @Column(name = "passyn")
    private Character passyn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mpos")
    private short mpos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pother1")
    private Character pother1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pother2")
    private Character pother2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pother3")
    private Character pother3;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pother4")
    private Character pother4;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pother5")
    private Character pother5;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pother6")
    private Character pother6;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pother7")
    private Character pother7;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pother8")
    private Character pother8;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pother9")
    private Character pother9;
    @Size(max = 16)
    @Column(name = "or1title")
    private String or1title;
    @Size(max = 16)
    @Column(name = "or2title")
    private String or2title;
    @Size(max = 16)
    @Column(name = "or3title")
    private String or3title;
    @Size(max = 16)
    @Column(name = "or4title")
    private String or4title;
    @Size(max = 16)
    @Column(name = "or5title")
    private String or5title;
    @Size(max = 16)
    @Column(name = "or6title")
    private String or6title;
    @Size(max = 16)
    @Column(name = "or7title")
    private String or7title;
    @Size(max = 16)
    @Column(name = "or8title")
    private String or8title;
    @Size(max = 16)
    @Column(name = "or9title")
    private String or9title;
    @Size(max = 30)
    @Column(name = "or1picture")
    private String or1picture;
    @Size(max = 30)
    @Column(name = "or2picture")
    private String or2picture;
    @Size(max = 30)
    @Column(name = "or3picture")
    private String or3picture;
    @Size(max = 30)
    @Column(name = "or4picture")
    private String or4picture;
    @Size(max = 30)
    @Column(name = "or5picture")
    private String or5picture;
    @Size(max = 30)
    @Column(name = "or6picture")
    private String or6picture;
    @Size(max = 30)
    @Column(name = "or7picture")
    private String or7picture;
    @Size(max = 30)
    @Column(name = "or8picture")
    private String or8picture;
    @Size(max = 30)
    @Column(name = "or9picture")
    private String or9picture;
    @Size(max = 30)
    @Column(name = "or1help")
    private String or1help;
    @Size(max = 30)
    @Column(name = "or2help")
    private String or2help;
    @Size(max = 30)
    @Column(name = "or3help")
    private String or3help;
    @Size(max = 30)
    @Column(name = "or4help")
    private String or4help;
    @Size(max = 30)
    @Column(name = "or5help")
    private String or5help;
    @Size(max = 30)
    @Column(name = "or6help")
    private String or6help;
    @Size(max = 30)
    @Column(name = "or7help")
    private String or7help;
    @Size(max = 30)
    @Column(name = "or8help")
    private String or8help;
    @Size(max = 30)
    @Column(name = "or9help")
    private String or9help;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prelation1")
    private Character prelation1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prelation2")
    private Character prelation2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prelation3")
    private Character prelation3;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prelation4")
    private Character prelation4;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stepbystep")
    private Character stepbystep;
    @Basic(optional = false)
    @NotNull
    @Column(name = "runsig")
    private Character runsig;
    @Size(max = 255)
    @Column(name = "prgparm")
    private String prgparm;

    public Secprg() {
    }

    public Secprg(String prgno) {
        this.prgno = prgno;
    }

    public Secprg(String prgno, Character prgtype, Character enabled, Character padd, Character pdelete, Character pmodify, Character pquery, Character pprint, Character pcommit, Character pcancel, Character unitask, Character passyn, short mpos, Character pother1, Character pother2, Character pother3, Character pother4, Character pother5, Character pother6, Character pother7, Character pother8, Character pother9, Character prelation1, Character prelation2, Character prelation3, Character prelation4, Character stepbystep, Character runsig) {
        this.prgno = prgno;
        this.prgtype = prgtype;
        this.enabled = enabled;
        this.padd = padd;
        this.pdelete = pdelete;
        this.pmodify = pmodify;
        this.pquery = pquery;
        this.pprint = pprint;
        this.pcommit = pcommit;
        this.pcancel = pcancel;
        this.unitask = unitask;
        this.passyn = passyn;
        this.mpos = mpos;
        this.pother1 = pother1;
        this.pother2 = pother2;
        this.pother3 = pother3;
        this.pother4 = pother4;
        this.pother5 = pother5;
        this.pother6 = pother6;
        this.pother7 = pother7;
        this.pother8 = pother8;
        this.pother9 = pother9;
        this.prelation1 = prelation1;
        this.prelation2 = prelation2;
        this.prelation3 = prelation3;
        this.prelation4 = prelation4;
        this.stepbystep = stepbystep;
        this.runsig = runsig;
    }

    public String getPrgno() {
        return prgno;
    }

    public void setPrgno(String prgno) {
        this.prgno = prgno;
    }

    public String getPrgname() {
        return prgname;
    }

    public void setPrgname(String prgname) {
        this.prgname = prgname;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public Character getPrgtype() {
        return prgtype;
    }

    public void setPrgtype(Character prgtype) {
        this.prgtype = prgtype;
    }

    public Character getEnabled() {
        return enabled;
    }

    public void setEnabled(Character enabled) {
        this.enabled = enabled;
    }

    public Character getPadd() {
        return padd;
    }

    public void setPadd(Character padd) {
        this.padd = padd;
    }

    public Character getPdelete() {
        return pdelete;
    }

    public void setPdelete(Character pdelete) {
        this.pdelete = pdelete;
    }

    public Character getPmodify() {
        return pmodify;
    }

    public void setPmodify(Character pmodify) {
        this.pmodify = pmodify;
    }

    public Character getPquery() {
        return pquery;
    }

    public void setPquery(Character pquery) {
        this.pquery = pquery;
    }

    public Character getPprint() {
        return pprint;
    }

    public void setPprint(Character pprint) {
        this.pprint = pprint;
    }

    public Character getPcommit() {
        return pcommit;
    }

    public void setPcommit(Character pcommit) {
        this.pcommit = pcommit;
    }

    public Character getPcancel() {
        return pcancel;
    }

    public void setPcancel(Character pcancel) {
        this.pcancel = pcancel;
    }

    public Character getUnitask() {
        return unitask;
    }

    public void setUnitask(Character unitask) {
        this.unitask = unitask;
    }

    public Character getPassyn() {
        return passyn;
    }

    public void setPassyn(Character passyn) {
        this.passyn = passyn;
    }

    public short getMpos() {
        return mpos;
    }

    public void setMpos(short mpos) {
        this.mpos = mpos;
    }

    public Character getPother1() {
        return pother1;
    }

    public void setPother1(Character pother1) {
        this.pother1 = pother1;
    }

    public Character getPother2() {
        return pother2;
    }

    public void setPother2(Character pother2) {
        this.pother2 = pother2;
    }

    public Character getPother3() {
        return pother3;
    }

    public void setPother3(Character pother3) {
        this.pother3 = pother3;
    }

    public Character getPother4() {
        return pother4;
    }

    public void setPother4(Character pother4) {
        this.pother4 = pother4;
    }

    public Character getPother5() {
        return pother5;
    }

    public void setPother5(Character pother5) {
        this.pother5 = pother5;
    }

    public Character getPother6() {
        return pother6;
    }

    public void setPother6(Character pother6) {
        this.pother6 = pother6;
    }

    public Character getPother7() {
        return pother7;
    }

    public void setPother7(Character pother7) {
        this.pother7 = pother7;
    }

    public Character getPother8() {
        return pother8;
    }

    public void setPother8(Character pother8) {
        this.pother8 = pother8;
    }

    public Character getPother9() {
        return pother9;
    }

    public void setPother9(Character pother9) {
        this.pother9 = pother9;
    }

    public String getOr1title() {
        return or1title;
    }

    public void setOr1title(String or1title) {
        this.or1title = or1title;
    }

    public String getOr2title() {
        return or2title;
    }

    public void setOr2title(String or2title) {
        this.or2title = or2title;
    }

    public String getOr3title() {
        return or3title;
    }

    public void setOr3title(String or3title) {
        this.or3title = or3title;
    }

    public String getOr4title() {
        return or4title;
    }

    public void setOr4title(String or4title) {
        this.or4title = or4title;
    }

    public String getOr5title() {
        return or5title;
    }

    public void setOr5title(String or5title) {
        this.or5title = or5title;
    }

    public String getOr6title() {
        return or6title;
    }

    public void setOr6title(String or6title) {
        this.or6title = or6title;
    }

    public String getOr7title() {
        return or7title;
    }

    public void setOr7title(String or7title) {
        this.or7title = or7title;
    }

    public String getOr8title() {
        return or8title;
    }

    public void setOr8title(String or8title) {
        this.or8title = or8title;
    }

    public String getOr9title() {
        return or9title;
    }

    public void setOr9title(String or9title) {
        this.or9title = or9title;
    }

    public String getOr1picture() {
        return or1picture;
    }

    public void setOr1picture(String or1picture) {
        this.or1picture = or1picture;
    }

    public String getOr2picture() {
        return or2picture;
    }

    public void setOr2picture(String or2picture) {
        this.or2picture = or2picture;
    }

    public String getOr3picture() {
        return or3picture;
    }

    public void setOr3picture(String or3picture) {
        this.or3picture = or3picture;
    }

    public String getOr4picture() {
        return or4picture;
    }

    public void setOr4picture(String or4picture) {
        this.or4picture = or4picture;
    }

    public String getOr5picture() {
        return or5picture;
    }

    public void setOr5picture(String or5picture) {
        this.or5picture = or5picture;
    }

    public String getOr6picture() {
        return or6picture;
    }

    public void setOr6picture(String or6picture) {
        this.or6picture = or6picture;
    }

    public String getOr7picture() {
        return or7picture;
    }

    public void setOr7picture(String or7picture) {
        this.or7picture = or7picture;
    }

    public String getOr8picture() {
        return or8picture;
    }

    public void setOr8picture(String or8picture) {
        this.or8picture = or8picture;
    }

    public String getOr9picture() {
        return or9picture;
    }

    public void setOr9picture(String or9picture) {
        this.or9picture = or9picture;
    }

    public String getOr1help() {
        return or1help;
    }

    public void setOr1help(String or1help) {
        this.or1help = or1help;
    }

    public String getOr2help() {
        return or2help;
    }

    public void setOr2help(String or2help) {
        this.or2help = or2help;
    }

    public String getOr3help() {
        return or3help;
    }

    public void setOr3help(String or3help) {
        this.or3help = or3help;
    }

    public String getOr4help() {
        return or4help;
    }

    public void setOr4help(String or4help) {
        this.or4help = or4help;
    }

    public String getOr5help() {
        return or5help;
    }

    public void setOr5help(String or5help) {
        this.or5help = or5help;
    }

    public String getOr6help() {
        return or6help;
    }

    public void setOr6help(String or6help) {
        this.or6help = or6help;
    }

    public String getOr7help() {
        return or7help;
    }

    public void setOr7help(String or7help) {
        this.or7help = or7help;
    }

    public String getOr8help() {
        return or8help;
    }

    public void setOr8help(String or8help) {
        this.or8help = or8help;
    }

    public String getOr9help() {
        return or9help;
    }

    public void setOr9help(String or9help) {
        this.or9help = or9help;
    }

    public Character getPrelation1() {
        return prelation1;
    }

    public void setPrelation1(Character prelation1) {
        this.prelation1 = prelation1;
    }

    public Character getPrelation2() {
        return prelation2;
    }

    public void setPrelation2(Character prelation2) {
        this.prelation2 = prelation2;
    }

    public Character getPrelation3() {
        return prelation3;
    }

    public void setPrelation3(Character prelation3) {
        this.prelation3 = prelation3;
    }

    public Character getPrelation4() {
        return prelation4;
    }

    public void setPrelation4(Character prelation4) {
        this.prelation4 = prelation4;
    }

    public Character getStepbystep() {
        return stepbystep;
    }

    public void setStepbystep(Character stepbystep) {
        this.stepbystep = stepbystep;
    }

    public Character getRunsig() {
        return runsig;
    }

    public void setRunsig(Character runsig) {
        this.runsig = runsig;
    }

    public String getPrgparm() {
        return prgparm;
    }

    public void setPrgparm(String prgparm) {
        this.prgparm = prgparm;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prgno != null ? prgno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Secprg)) {
            return false;
        }
        Secprg other = (Secprg) object;
        if ((this.prgno == null && other.prgno != null) || (this.prgno != null && !this.prgno.equals(other.prgno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Secprg[ prgno=" + prgno + " ]";
    }

}
