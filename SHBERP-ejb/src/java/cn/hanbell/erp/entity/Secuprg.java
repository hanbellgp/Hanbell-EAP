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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C1587
 */
@Entity
@Table(name = "secuprg")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Secuprg.findAll", query = "SELECT s FROM Secuprg s"),
    @NamedQuery(name = "Secuprg.findByPrgno", query = "SELECT s FROM Secuprg s WHERE s.secuprgPK.prgno = :prgno"),
    @NamedQuery(name = "Secuprg.findByUserno", query = "SELECT s FROM Secuprg s WHERE s.secuprgPK.userno = :userno ORDER BY s.secuprgPK.prgno"),
    @NamedQuery(name = "Secuprg.findByPK", query = "SELECT s FROM Secuprg s WHERE s.secuprgPK.userno = :userno and s.secuprgPK.prgno = :prgno"),
    @NamedQuery(name = "Secuprg.findByPadd", query = "SELECT s FROM Secuprg s WHERE s.padd = :padd"),
    @NamedQuery(name = "Secuprg.findByPdelete", query = "SELECT s FROM Secuprg s WHERE s.pdelete = :pdelete"),
    @NamedQuery(name = "Secuprg.findByPmodify", query = "SELECT s FROM Secuprg s WHERE s.pmodify = :pmodify"),
    @NamedQuery(name = "Secuprg.findByPquery", query = "SELECT s FROM Secuprg s WHERE s.pquery = :pquery"),
    @NamedQuery(name = "Secuprg.findByPprint", query = "SELECT s FROM Secuprg s WHERE s.pprint = :pprint"),
    @NamedQuery(name = "Secuprg.findByPcommit", query = "SELECT s FROM Secuprg s WHERE s.pcommit = :pcommit"),
    @NamedQuery(name = "Secuprg.findByPcancel", query = "SELECT s FROM Secuprg s WHERE s.pcancel = :pcancel"),
    @NamedQuery(name = "Secuprg.findByPother1", query = "SELECT s FROM Secuprg s WHERE s.pother1 = :pother1"),
    @NamedQuery(name = "Secuprg.findByPother2", query = "SELECT s FROM Secuprg s WHERE s.pother2 = :pother2"),
    @NamedQuery(name = "Secuprg.findByPother3", query = "SELECT s FROM Secuprg s WHERE s.pother3 = :pother3"),
    @NamedQuery(name = "Secuprg.findByPother4", query = "SELECT s FROM Secuprg s WHERE s.pother4 = :pother4"),
    @NamedQuery(name = "Secuprg.findByPother5", query = "SELECT s FROM Secuprg s WHERE s.pother5 = :pother5"),
    @NamedQuery(name = "Secuprg.findByPother6", query = "SELECT s FROM Secuprg s WHERE s.pother6 = :pother6"),
    @NamedQuery(name = "Secuprg.findByPother7", query = "SELECT s FROM Secuprg s WHERE s.pother7 = :pother7"),
    @NamedQuery(name = "Secuprg.findByPother8", query = "SELECT s FROM Secuprg s WHERE s.pother8 = :pother8"),
    @NamedQuery(name = "Secuprg.findByPother9", query = "SELECT s FROM Secuprg s WHERE s.pother9 = :pother9"),
    @NamedQuery(name = "Secuprg.findByPrelation1", query = "SELECT s FROM Secuprg s WHERE s.prelation1 = :prelation1"),
    @NamedQuery(name = "Secuprg.findByPrelation2", query = "SELECT s FROM Secuprg s WHERE s.prelation2 = :prelation2"),
    @NamedQuery(name = "Secuprg.findByPrelation3", query = "SELECT s FROM Secuprg s WHERE s.prelation3 = :prelation3"),
    @NamedQuery(name = "Secuprg.findByPrelation4", query = "SELECT s FROM Secuprg s WHERE s.prelation4 = :prelation4"),
    @NamedQuery(name = "Secuprg.findByStepbystep", query = "SELECT s FROM Secuprg s WHERE s.stepbystep = :stepbystep"),
    @NamedQuery(name = "Secuprg.findByRunsig", query = "SELECT s FROM Secuprg s WHERE s.runsig = :runsig"),
    @NamedQuery(name = "Secuprg.findByPuserno", query = "SELECT s FROM Secuprg s WHERE s.puserno = :puserno"),
    @NamedQuery(name = "Secuprg.findByGtype", query = "SELECT s FROM Secuprg s WHERE s.gtype = :gtype")})
public class Secuprg implements Serializable {

    @JoinColumns({
        @JoinColumn(name = "prgno", referencedColumnName = "prgno", insertable = false, updatable = false)
    })
    @ManyToOne()
    private Secprg secprg;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SecuprgPK secuprgPK;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "puserno")
    private String puserno;
    @Size(max = 2)
    @Column(name = "gtype")
    private String gtype;

    public Secuprg() {
    }

    public Secuprg(SecuprgPK secuprgPK) {
        this.secuprgPK = secuprgPK;
    }

    public Secuprg(SecuprgPK secuprgPK, Character padd, Character pdelete, Character pmodify, Character pquery, Character pprint, Character pcommit, Character pcancel, Character pother1, Character pother2, Character pother3, Character pother4, Character pother5, Character pother6, Character pother7, Character pother8, Character pother9, Character prelation1, Character prelation2, Character prelation3, Character prelation4, Character stepbystep, Character runsig, String puserno) {
        this.secuprgPK = secuprgPK;
        this.padd = padd;
        this.pdelete = pdelete;
        this.pmodify = pmodify;
        this.pquery = pquery;
        this.pprint = pprint;
        this.pcommit = pcommit;
        this.pcancel = pcancel;
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
        this.puserno = puserno;
    }

    public Secuprg(String prgno, String userno) {
        this.secuprgPK = new SecuprgPK(prgno, userno);
    }

    public SecuprgPK getSecuprgPK() {
        return secuprgPK;
    }

    public void setSecuprgPK(SecuprgPK secuprgPK) {
        this.secuprgPK = secuprgPK;
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

    public String getPuserno() {
        return puserno;
    }

    public void setPuserno(String puserno) {
        this.puserno = puserno;
    }

    public String getGtype() {
        return gtype;
    }

    public void setGtype(String gtype) {
        this.gtype = gtype;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (secuprgPK != null ? secuprgPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Secuprg)) {
            return false;
        }
        Secuprg other = (Secuprg) object;
        if ((this.secuprgPK == null && other.secuprgPK != null) || (this.secuprgPK != null && !this.secuprgPK.equals(other.secuprgPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Secuprg[ secuprgPK=" + secuprgPK + " ]";
    }

    /**
     * @return the secprg
     */
    public Secprg getSecprg() {
        return secprg;
    }

    /**
     * @param secprg the secprg to set
     */
    public void setSecprg(Secprg secprg) {
        this.secprg = secprg;
    }

}
