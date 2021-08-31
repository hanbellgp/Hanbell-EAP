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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C2082
 */
@Entity
@Table(name = "purvdrit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Purvdrit.findAll", query = "SELECT p FROM Purvdrit p"),
    @NamedQuery(name = "Purvdrit.findByItnbr", query = "SELECT p FROM Purvdrit p WHERE p.purvdritPK.itnbr = :itnbr"),
    @NamedQuery(name = "Purvdrit.findByVdrno", query = "SELECT p FROM Purvdrit p WHERE p.purvdritPK.vdrno = :vdrno"),
    @NamedQuery(name = "Purvdrit.findByLeadtime", query = "SELECT p FROM Purvdrit p WHERE p.leadtime = :leadtime"),
    @NamedQuery(name = "Purvdrit.findByPominqy", query = "SELECT p FROM Purvdrit p WHERE p.pominqy = :pominqy"),
    @NamedQuery(name = "Purvdrit.findByPomaxqy", query = "SELECT p FROM Purvdrit p WHERE p.pomaxqy = :pomaxqy"),
    @NamedQuery(name = "Purvdrit.findByLotqy", query = "SELECT p FROM Purvdrit p WHERE p.lotqy = :lotqy"),
    @NamedQuery(name = "Purvdrit.findByMinpkqy", query = "SELECT p FROM Purvdrit p WHERE p.minpkqy = :minpkqy")})
public class Purvdrit implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PurvdritPK purvdritPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "leadtime")
    private short leadtime;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pominqy")
    private BigDecimal pominqy;
    @Column(name = "pomaxqy")
    private BigDecimal pomaxqy;
    @Column(name = "lotqy")
    private BigDecimal lotqy;
    @Column(name = "minpkqy")
    private BigDecimal minpkqy;

    public Purvdrit() {
    }

    public Purvdrit(PurvdritPK purvdritPK) {
        this.purvdritPK = purvdritPK;
    }

    public Purvdrit(PurvdritPK purvdritPK, short leadtime) {
        this.purvdritPK = purvdritPK;
        this.leadtime = leadtime;
    }

    public Purvdrit(String itnbr, String vdrno) {
        this.purvdritPK = new PurvdritPK(itnbr, vdrno);
    }

    public PurvdritPK getPurvdritPK() {
        return purvdritPK;
    }

    public void setPurvdritPK(PurvdritPK purvdritPK) {
        this.purvdritPK = purvdritPK;
    }

    public short getLeadtime() {
        return leadtime;
    }

    public void setLeadtime(short leadtime) {
        this.leadtime = leadtime;
    }

    public BigDecimal getPominqy() {
        return pominqy;
    }

    public void setPominqy(BigDecimal pominqy) {
        this.pominqy = pominqy;
    }

    public BigDecimal getPomaxqy() {
        return pomaxqy;
    }

    public void setPomaxqy(BigDecimal pomaxqy) {
        this.pomaxqy = pomaxqy;
    }

    public BigDecimal getLotqy() {
        return lotqy;
    }

    public void setLotqy(BigDecimal lotqy) {
        this.lotqy = lotqy;
    }

    public BigDecimal getMinpkqy() {
        return minpkqy;
    }

    public void setMinpkqy(BigDecimal minpkqy) {
        this.minpkqy = minpkqy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (purvdritPK != null ? purvdritPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Purvdrit)) {
            return false;
        }
        Purvdrit other = (Purvdrit) object;
        if ((this.purvdritPK == null && other.purvdritPK != null) || (this.purvdritPK != null && !this.purvdritPK.equals(other.purvdritPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.ejb.Purvdrit[ purvdritPK=" + purvdritPK + " ]";
    }
    
}
