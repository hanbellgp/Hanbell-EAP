/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import com.lightshell.comm.SuperEntity;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "systemprogram")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SystemProgram.findAll", query = "SELECT s FROM SystemProgram s"),
    @NamedQuery(name = "SystemProgram.findById", query = "SELECT s FROM SystemProgram s WHERE s.id = :id"),
    @NamedQuery(name = "SystemProgram.findByName", query = "SELECT s FROM SystemProgram s WHERE s.name = :name"),
    @NamedQuery(name = "SystemProgram.findByAPI", query = "SELECT s FROM SystemProgram s WHERE s.api = :api"),
    @NamedQuery(name = "SystemProgram.findBySystemAndAPI", query = "SELECT s FROM SystemProgram s WHERE s.sysname = :sysname AND s.api = :api"),
    @NamedQuery(name = "SystemProgram.findByModuleId", query = "SELECT s FROM SystemProgram s WHERE s.systemModule.id = :moduleid"),
    @NamedQuery(name = "SystemProgram.findByStatus", query = "SELECT s FROM SystemProgram s WHERE s.status = :status")})
public class SystemProgram extends SuperEntity {

    @JoinColumn(name = "moduleid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SystemModule systemModule;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "api")
    private String api;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "sysname")
    private String sysname;

    @Column(name = "sortid")
    private Integer sortid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "noauto")
    private boolean noauto;
    @Column(name = "nochange")
    private Boolean nochange;
    @Size(max = 4)
    @Column(name = "nolead")
    private String nolead;
    @Size(max = 8)
    @Column(name = "noformat")
    private String noformat;
    @Column(name = "noseqlen")
    private Integer noseqlen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "doadd")
    private boolean doadd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "doedit")
    private boolean doedit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dodel")
    private boolean dodel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "doprt")
    private boolean doprt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dopriv")
    private boolean dopriv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "docfm")
    private boolean docfm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "douncfm")
    private boolean douncfm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "doaudit")
    private boolean doaudit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dounaudit")
    private boolean dounaudit;
    @Size(max = 100)
    @Column(name = "rptclazz")
    private String rptclazz;
    @Size(max = 100)
    @Column(name = "rptdesign")
    private String rptdesign;
    @Size(max = 100)
    @Column(name = "rptformat")
    private String rptformat;
    @Size(max = 200)
    @Column(name = "rptjndi")
    private String rptjndi;
    @Size(max = 50)
    @Column(name = "descript")
    private String descript;

    public SystemProgram() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getSysname() {
        return sysname;
    }

    public void setSysname(String sysname) {
        this.sysname = sysname;
    }

    public SystemModule getSystemModule() {
        return systemModule;
    }

    public void setSystemModule(SystemModule systemModule) {
        this.systemModule = systemModule;
    }

    public Integer getSortid() {
        return sortid;
    }

    public void setSortid(Integer sortid) {
        this.sortid = sortid;
    }

    public boolean getNoauto() {
        return noauto;
    }

    public void setNoauto(boolean noauto) {
        this.noauto = noauto;
    }

    public Boolean getNochange() {
        return nochange;
    }

    public void setNochange(Boolean nochange) {
        this.nochange = nochange;
    }

    public String getNolead() {
        return nolead;
    }

    public void setNolead(String nolead) {
        this.nolead = nolead;
    }

    public String getNoformat() {
        return noformat;
    }

    public void setNoformat(String noformat) {
        this.noformat = noformat;
    }

    public Integer getNoseqlen() {
        return noseqlen;
    }

    public void setNoseqlen(Integer noseqlen) {
        this.noseqlen = noseqlen;
    }

    public boolean getDoadd() {
        return doadd;
    }

    public void setDoadd(boolean doadd) {
        this.doadd = doadd;
    }

    public boolean getDoedit() {
        return doedit;
    }

    public void setDoedit(boolean doedit) {
        this.doedit = doedit;
    }

    public boolean getDodel() {
        return dodel;
    }

    public void setDodel(boolean dodel) {
        this.dodel = dodel;
    }

    public boolean getDoprt() {
        return doprt;
    }

    public void setDoprt(boolean doprt) {
        this.doprt = doprt;
    }

    public boolean getDopriv() {
        return dopriv;
    }

    public void setDopriv(boolean dopriv) {
        this.dopriv = dopriv;
    }

    public boolean getDocfm() {
        return docfm;
    }

    public void setDocfm(boolean docfm) {
        this.docfm = docfm;
    }

    public boolean getDouncfm() {
        return douncfm;
    }

    public void setDouncfm(boolean douncfm) {
        this.douncfm = douncfm;
    }

    public boolean getDoaudit() {
        return doaudit;
    }

    public void setDoaudit(boolean doaudit) {
        this.doaudit = doaudit;
    }

    public boolean getDounaudit() {
        return dounaudit;
    }

    public void setDounaudit(boolean dounaudit) {
        this.dounaudit = dounaudit;
    }

    public String getRptdesign() {
        return rptdesign;
    }

    public void setRptdesign(String rptdesign) {
        this.rptdesign = rptdesign;
    }

    public String getRptjndi() {
        return rptjndi;
    }

    public void setRptjndi(String rptjndi) {
        this.rptjndi = rptjndi;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SystemProgram)) {
            return false;
        }
        SystemProgram other = (SystemProgram) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.SystemProgram[ id=" + id + " ]";
    }

    /**
     * @return the rptclazz
     */
    public String getRptclazz() {
        return rptclazz;
    }

    /**
     * @param rptclazz the rptclazz to set
     */
    public void setRptclazz(String rptclazz) {
        this.rptclazz = rptclazz;
    }

    /**
     * @return the rptformat
     */
    public String getRptformat() {
        return rptformat;
    }

    /**
     * @param rptformat the rptformat to set
     */
    public void setRptformat(String rptformat) {
        this.rptformat = rptformat;
    }

}
