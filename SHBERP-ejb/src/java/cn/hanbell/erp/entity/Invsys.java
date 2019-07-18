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
 * @author Administrator
 */
@Entity
@Table(name = "invsys")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invsys.findAll", query = "SELECT i FROM Invsys i"),
    @NamedQuery(name = "Invsys.findByFacno", query = "SELECT i FROM Invsys i WHERE i.facno = :facno"),
    @NamedQuery(name = "Invsys.findByLmonth", query = "SELECT i FROM Invsys i WHERE i.lmonth = :lmonth"),
    @NamedQuery(name = "Invsys.findByHkpmonth", query = "SELECT i FROM Invsys i WHERE i.hkpmonth = :hkpmonth"),
    @NamedQuery(name = "Invsys.findByCstno", query = "SELECT i FROM Invsys i WHERE i.cstno = :cstno"),
    @NamedQuery(name = "Invsys.findByMctype", query = "SELECT i FROM Invsys i WHERE i.mctype = :mctype"),
    @NamedQuery(name = "Invsys.findByInvosmcorcls", query = "SELECT i FROM Invsys i WHERE i.invosmcorcls = :invosmcorcls"),
    @NamedQuery(name = "Invsys.findByInvosmrange", query = "SELECT i FROM Invsys i WHERE i.invosmrange = :invosmrange"),
    @NamedQuery(name = "Invsys.findByVacdrmon", query = "SELECT i FROM Invsys i WHERE i.vacdrmon = :vacdrmon"),
    @NamedQuery(name = "Invsys.findByVapurmon", query = "SELECT i FROM Invsys i WHERE i.vapurmon = :vapurmon"),
    @NamedQuery(name = "Invsys.findByVanocorp", query = "SELECT i FROM Invsys i WHERE i.vanocorp = :vanocorp"),
    @NamedQuery(name = "Invsys.findByInvlr", query = "SELECT i FROM Invsys i WHERE i.invlr = :invlr"),
    @NamedQuery(name = "Invsys.findByMpdosmit", query = "SELECT i FROM Invsys i WHERE i.mpdosmit = :mpdosmit"),
    @NamedQuery(name = "Invsys.findByLcmtrtype", query = "SELECT i FROM Invsys i WHERE i.lcmtrtype = :lcmtrtype"),
    @NamedQuery(name = "Invsys.findByOsmtrtype", query = "SELECT i FROM Invsys i WHERE i.osmtrtype = :osmtrtype"),
    @NamedQuery(name = "Invsys.findByPurthresh", query = "SELECT i FROM Invsys i WHERE i.purthresh = :purthresh"),
    @NamedQuery(name = "Invsys.findByPrirule", query = "SELECT i FROM Invsys i WHERE i.prirule = :prirule"),
    @NamedQuery(name = "Invsys.findBySequen", query = "SELECT i FROM Invsys i WHERE i.sequen = :sequen")})
public class Invsys implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "facno")
    private String facno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "lmonth")
    private String lmonth;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hkpmonth")
    private int hkpmonth;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cstno")
    private Character cstno;
    @Size(max = 3)
    @Column(name = "mctype")
    private String mctype;
    @Column(name = "invosmcorcls")
    private Character invosmcorcls;
    @Size(max = 10)
    @Column(name = "invosmrange")
    private String invosmrange;
    @Column(name = "vacdrmon")
    private Short vacdrmon;
    @Column(name = "vapurmon")
    private Short vapurmon;
    @Column(name = "vanocorp")
    private Character vanocorp;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "invlr")
    private BigDecimal invlr;
    @Column(name = "mpdosmit")
    private Character mpdosmit;
    @Size(max = 3)
    @Column(name = "lcmtrtype")
    private String lcmtrtype;
    @Size(max = 3)
    @Column(name = "osmtrtype")
    private String osmtrtype;
    @Column(name = "purthresh")
    private BigDecimal purthresh;
    @Column(name = "prirule")
    private Character prirule;
    @Column(name = "sequen")
    private Character sequen;

    public Invsys() {
    }

    public Invsys(String facno) {
        this.facno = facno;
    }

    public Invsys(String facno, String lmonth, int hkpmonth, Character cstno) {
        this.facno = facno;
        this.lmonth = lmonth;
        this.hkpmonth = hkpmonth;
        this.cstno = cstno;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getLmonth() {
        return lmonth;
    }

    public void setLmonth(String lmonth) {
        this.lmonth = lmonth;
    }

    public int getHkpmonth() {
        return hkpmonth;
    }

    public void setHkpmonth(int hkpmonth) {
        this.hkpmonth = hkpmonth;
    }

    public Character getCstno() {
        return cstno;
    }

    public void setCstno(Character cstno) {
        this.cstno = cstno;
    }

    public String getMctype() {
        return mctype;
    }

    public void setMctype(String mctype) {
        this.mctype = mctype;
    }

    public Character getInvosmcorcls() {
        return invosmcorcls;
    }

    public void setInvosmcorcls(Character invosmcorcls) {
        this.invosmcorcls = invosmcorcls;
    }

    public String getInvosmrange() {
        return invosmrange;
    }

    public void setInvosmrange(String invosmrange) {
        this.invosmrange = invosmrange;
    }

    public Short getVacdrmon() {
        return vacdrmon;
    }

    public void setVacdrmon(Short vacdrmon) {
        this.vacdrmon = vacdrmon;
    }

    public Short getVapurmon() {
        return vapurmon;
    }

    public void setVapurmon(Short vapurmon) {
        this.vapurmon = vapurmon;
    }

    public Character getVanocorp() {
        return vanocorp;
    }

    public void setVanocorp(Character vanocorp) {
        this.vanocorp = vanocorp;
    }

    public BigDecimal getInvlr() {
        return invlr;
    }

    public void setInvlr(BigDecimal invlr) {
        this.invlr = invlr;
    }

    public Character getMpdosmit() {
        return mpdosmit;
    }

    public void setMpdosmit(Character mpdosmit) {
        this.mpdosmit = mpdosmit;
    }

    public String getLcmtrtype() {
        return lcmtrtype;
    }

    public void setLcmtrtype(String lcmtrtype) {
        this.lcmtrtype = lcmtrtype;
    }

    public String getOsmtrtype() {
        return osmtrtype;
    }

    public void setOsmtrtype(String osmtrtype) {
        this.osmtrtype = osmtrtype;
    }

    public BigDecimal getPurthresh() {
        return purthresh;
    }

    public void setPurthresh(BigDecimal purthresh) {
        this.purthresh = purthresh;
    }

    public Character getPrirule() {
        return prirule;
    }

    public void setPrirule(Character prirule) {
        this.prirule = prirule;
    }

    public Character getSequen() {
        return sequen;
    }

    public void setSequen(Character sequen) {
        this.sequen = sequen;
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
        if (!(object instanceof Invsys)) {
            return false;
        }
        Invsys other = (Invsys) object;
        if ((this.facno == null && other.facno != null) || (this.facno != null && !this.facno.equals(other.facno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Invsys[ facno=" + facno + " ]";
    }
    
}
