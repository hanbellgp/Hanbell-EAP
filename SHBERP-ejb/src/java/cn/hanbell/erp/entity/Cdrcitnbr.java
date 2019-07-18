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
@Table(name = "cdrcitnbr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdrcitnbr.getRowCount", query = "SELECT COUNT(c) FROM Cdrcitnbr c"),
    @NamedQuery(name = "Cdrcitnbr.findAll", query = "SELECT c FROM Cdrcitnbr c"),
    @NamedQuery(name = "Cdrcitnbr.findByCusno", query = "SELECT c FROM Cdrcitnbr c WHERE c.cdrcitnbrPK.cusno = :cusno"),
    @NamedQuery(name = "Cdrcitnbr.findByItnbr", query = "SELECT c FROM Cdrcitnbr c WHERE c.cdrcitnbrPK.itnbr = :itnbr"),
    @NamedQuery(name = "Cdrcitnbr.findByPK", query = "SELECT c FROM Cdrcitnbr c WHERE  c.cdrcitnbrPK.cusno = :cusno AND c.cdrcitnbrPK.itnbr = :itnbr AND c.cdrcitnbrPK.itnbrcus = :itnbrcus")})
public class Cdrcitnbr implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CdrcitnbrPK cdrcitnbrPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "itdsccus")
    private String itdsccus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "spdsccus")
    private String spdsccus;
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
    @Size(max = 8)
    @Column(name = "packcode")
    private String packcode;
    @Size(max = 3)
    @Column(name = "facno")
    private String facno;
    @Size(max = 8)
    @Column(name = "dmark1")
    private String dmark1;
    @Size(max = 8)
    @Column(name = "dmark2")
    private String dmark2;
    @Size(max = 8)
    @Column(name = "dmark3")
    private String dmark3;
    @Size(max = 8)
    @Column(name = "dmark4")
    private String dmark4;
    @Size(max = 4)
    @Column(name = "unmsrcus")
    private String unmsrcus;
    @Size(max = 60)
    @Column(name = "spdsccus2")
    private String spdsccus2;

    public Cdrcitnbr() {
    }

    public Cdrcitnbr(CdrcitnbrPK cdrcitnbrPK) {
        this.cdrcitnbrPK = cdrcitnbrPK;
    }

    public Cdrcitnbr(CdrcitnbrPK cdrcitnbrPK, String itdsccus, String spdsccus, Date indate, String userno) {
        this.cdrcitnbrPK = cdrcitnbrPK;
        this.itdsccus = itdsccus;
        this.spdsccus = spdsccus;
        this.indate = indate;
        this.userno = userno;
    }

    public Cdrcitnbr(String cusno, String itnbr, String itnbrcus) {
        this.cdrcitnbrPK = new CdrcitnbrPK(cusno, itnbr, itnbrcus);
    }

    public CdrcitnbrPK getCdrcitnbrPK() {
        return cdrcitnbrPK;
    }

    public void setCdrcitnbrPK(CdrcitnbrPK cdrcitnbrPK) {
        this.cdrcitnbrPK = cdrcitnbrPK;
    }

    public String getItdsccus() {
        return itdsccus;
    }

    public void setItdsccus(String itdsccus) {
        this.itdsccus = itdsccus;
    }

    public String getSpdsccus() {
        return spdsccus;
    }

    public void setSpdsccus(String spdsccus) {
        this.spdsccus = spdsccus;
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

    public String getPackcode() {
        return packcode;
    }

    public void setPackcode(String packcode) {
        this.packcode = packcode;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getDmark1() {
        return dmark1;
    }

    public void setDmark1(String dmark1) {
        this.dmark1 = dmark1;
    }

    public String getDmark2() {
        return dmark2;
    }

    public void setDmark2(String dmark2) {
        this.dmark2 = dmark2;
    }

    public String getDmark3() {
        return dmark3;
    }

    public void setDmark3(String dmark3) {
        this.dmark3 = dmark3;
    }

    public String getDmark4() {
        return dmark4;
    }

    public void setDmark4(String dmark4) {
        this.dmark4 = dmark4;
    }

    public String getUnmsrcus() {
        return unmsrcus;
    }

    public void setUnmsrcus(String unmsrcus) {
        this.unmsrcus = unmsrcus;
    }

    public String getSpdsccus2() {
        return spdsccus2;
    }

    public void setSpdsccus2(String spdsccus2) {
        this.spdsccus2 = spdsccus2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdrcitnbrPK != null ? cdrcitnbrPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cdrcitnbr)) {
            return false;
        }
        Cdrcitnbr other = (Cdrcitnbr) object;
        if ((this.cdrcitnbrPK == null && other.cdrcitnbrPK != null) || (this.cdrcitnbrPK != null && !this.cdrcitnbrPK.equals(other.cdrcitnbrPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Cdrcitnbr[ cdrcitnbrPK=" + cdrcitnbrPK + " ]";
    }

}
