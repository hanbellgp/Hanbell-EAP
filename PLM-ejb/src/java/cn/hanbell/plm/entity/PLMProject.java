/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.plm.entity;

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
@Table(name = "plm_project")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PLMProject.findAll", query = "SELECT p FROM PLMProject p"),
    @NamedQuery(name = "PLMProject.findByProjno", query = "SELECT p FROM PLMProject p WHERE p.projectPK.projno = :projno"),
    @NamedQuery(name = "PLMProject.findByPK", query = "SELECT p FROM PLMProject p WHERE p.projectPK.projno = :projno AND p.projectPK.projname=:projname")})
public class PLMProject implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PLMProjectPK projectPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "projman")
    private String projman;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "series")
    private String series;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "prono")
    private String prono;
    @Size(max = 50)
    @Column(name = "projexample")
    private String projexample;
    @Size(max = 256)
    @Column(name = "projdsc")
    private String projdsc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "projfromdate")
    @Temporal(TemporalType.DATE)
    private Date projfromdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "projtype")
    private String projtype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "exestatus")
    private String exestatus;
    @Size(max = 256)
    @Column(name = "exedsc")
    private String exedsc;
    @Size(max = 50)
    @Column(name = "isclose")
    private String isclose;
    @Column(name = "indate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date indate;
    @Column(name = "cfmdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cfmdate;

    public PLMProject() {
    }

    public PLMProject(String projno, String projname) {
        this.projectPK = new PLMProjectPK(projno, projname);
    }

    public PLMProjectPK getProjectPK() {
        return projectPK;
    }

    public void setProjectPK(PLMProjectPK projectPK) {
        this.projectPK = projectPK;
    }

    public String getProjman() {
        return projman;
    }

    public void setProjman(String projman) {
        this.projman = projman;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getProno() {
        return prono;
    }

    public void setProno(String prono) {
        this.prono = prono;
    }

    public String getProjexample() {
        return projexample;
    }

    public void setProjexample(String projexample) {
        this.projexample = projexample;
    }

    public String getProjdsc() {
        return projdsc;
    }

    public void setProjdsc(String projdsc) {
        this.projdsc = projdsc;
    }

    public Date getProjfromdate() {
        return projfromdate;
    }

    public void setProjfromdate(Date projfromdate) {
        this.projfromdate = projfromdate;
    }

    public String getProjtype() {
        return projtype;
    }

    public void setProjtype(String projtype) {
        this.projtype = projtype;
    }

    public String getExestatus() {
        return exestatus;
    }

    public void setExestatus(String exestatus) {
        this.exestatus = exestatus;
    }

    public String getExedsc() {
        return exedsc;
    }

    public void setExedsc(String exedsc) {
        this.exedsc = exedsc;
    }

    public String getIsclose() {
        return isclose;
    }

    public void setIsclose(String isclose) {
        this.isclose = isclose;
    }

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    public Date getCfmdate() {
        return cfmdate;
    }

    public void setCfmdate(Date cfmdate) {
        this.cfmdate = cfmdate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectPK != null ? projectPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PLMProject)) {
            return false;
        }
        PLMProject other = (PLMProject) object;
        if ((this.projectPK != null && other.projectPK != null)) {
            return this.projectPK.equals(other.getProjectPK());
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.plm.entity.PLMProject[ pLMProjectPK=" + projectPK + " ]";
    }

}
