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
@Table(name = "invmasimport")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvmasImport.findAll", query = "SELECT i FROM InvmasImport i"),
    @NamedQuery(name = "InvmasImport.findById", query = "SELECT i FROM InvmasImport i WHERE i.id = :id"),
    @NamedQuery(name = "InvmasImport.findByItcls", query = "SELECT i FROM InvmasImport i WHERE i.itcls = :itcls"),
    @NamedQuery(name = "InvmasImport.findByItnbr", query = "SELECT i FROM InvmasImport i WHERE i.itnbr = :itnbr")})
public class InvmasImport extends SuperEntity {

    @Size(max = 20)
    @Column(name = "itcls")
    private String itcls;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "itnbr")
    private String itnbr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 60)
    @Column(name = "spdsc")
    private String spdsc;
    @Size(max = 60)
    @Column(name = "eitdsc")
    private String eitdsc;
    @Size(max = 60)
    @Column(name = "espdsc")
    private String espdsc;
    @Size(max = 10)
    @Column(name = "unmsr1")
    private String unmsr1;
    @Size(max = 20)
    @Column(name = "kind")
    private String kind;
    @Size(max = 100)
    @Column(name = "used")
    private String used;
    @Size(max = 45)
    @Column(name = "remark")
    private String remark;

    public InvmasImport() {
    }

    public String getItcls() {
        return itcls;
    }

    public void setItcls(String itcls) {
        this.itcls = itcls;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getSpdsc() {
        return spdsc;
    }

    public void setSpdsc(String spdsc) {
        this.spdsc = spdsc;
    }

    public String getEitdsc() {
        return eitdsc;
    }

    public void setEitdsc(String eitdsc) {
        this.eitdsc = eitdsc;
    }

    public String getEspdsc() {
        return espdsc;
    }

    public void setEspdsc(String espdsc) {
        this.espdsc = espdsc;
    }

    public String getUnmsr1() {
        return unmsr1;
    }

    public void setUnmsr1(String unmsr1) {
        this.unmsr1 = unmsr1;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
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
        if (!(object instanceof InvmasImport)) {
            return false;
        }
        InvmasImport other = (InvmasImport) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.InvmasImport[ id=" + id + " ]";
    }

    /**
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

}
