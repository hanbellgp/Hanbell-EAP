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
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "PLM_ITNBR_DETAIL_TEMP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PLMItnbrDetailTemp.findAll", query = "SELECT p FROM PLMItnbrDetailTemp p"),
    @NamedQuery(name = "PLMItnbrDetailTemp.findByItemNumber", query = "SELECT p FROM PLMItnbrDetailTemp p WHERE p.itemNumber = :itemnumber"),
    @NamedQuery(name = "PLMItnbrDetailTemp.findById", query = "SELECT p FROM PLMItnbrDetailTemp p WHERE p.id = :id"),
    @NamedQuery(name = "PLMItnbrDetailTemp.findByUnmsr", query = "SELECT p FROM PLMItnbrDetailTemp p WHERE p.unmsr = :unmsr"),
    @NamedQuery(name = "PLMItnbrDetailTemp.findByUnmsre", query = "SELECT p FROM PLMItnbrDetailTemp p WHERE p.unmsre = :unmsre")})
public class PLMItnbrDetailTemp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 128)
    @Column(name = "item_number")
    private String itemNumber;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "id")
    private String id;
    @Size(max = 20)
    @Column(name = "c_itnbr")
    private String cItnbr;
    @Size(max = 20)
    @Column(name = "a_itnbr")
    private String aItnbr;
    @Size(max = 25)
    @Column(name = "c_itdsc")
    private String cItdsc;
    @Size(max = 25)
    @Column(name = "c_spdsc")
    private String cSpdsc;
    @Size(max = 30)
    @Column(name = "c_eitdsc")
    private String cEitdsc;
    @Size(max = 30)
    @Column(name = "c_espdsc")
    private String cEspdsc;
    @Size(max = 25)
    @Column(name = "a_itdsc")
    private String aItdsc;
    @Size(max = 25)
    @Column(name = "a_spdsc")
    private String aSpdsc;
    @Size(max = 30)
    @Column(name = "a_eitdsc")
    private String aEitdsc;
    @Size(max = 30)
    @Column(name = "a_espdsc")
    private String aEspdsc;
    @Size(max = 3)
    @Column(name = "series")
    private String series;
    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Size(max = 8)
    @Column(name = "unmsr")
    private String unmsr;
    @Size(max = 8)
    @Column(name = "unmsre")
    private String unmsre;

    public PLMItnbrDetailTemp() {
    }

    public PLMItnbrDetailTemp(String id) {
        this.id = id;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCItnbr() {
        return cItnbr;
    }

    public void setCItnbr(String cItnbr) {
        this.cItnbr = cItnbr;
    }

    public String getAItnbr() {
        return aItnbr;
    }

    public void setAItnbr(String aItnbr) {
        this.aItnbr = aItnbr;
    }

    public String getCItdsc() {
        return cItdsc;
    }

    public void setCItdsc(String cItdsc) {
        this.cItdsc = cItdsc;
    }

    public String getCSpdsc() {
        return cSpdsc;
    }

    public void setCSpdsc(String cSpdsc) {
        this.cSpdsc = cSpdsc;
    }

    public String getCEitdsc() {
        return cEitdsc;
    }

    public void setCEitdsc(String cEitdsc) {
        this.cEitdsc = cEitdsc;
    }

    public String getCEspdsc() {
        return cEspdsc;
    }

    public void setCEspdsc(String cEspdsc) {
        this.cEspdsc = cEspdsc;
    }

    public String getAItdsc() {
        return aItdsc;
    }

    public void setAItdsc(String aItdsc) {
        this.aItdsc = aItdsc;
    }

    public String getASpdsc() {
        return aSpdsc;
    }

    public void setASpdsc(String aSpdsc) {
        this.aSpdsc = aSpdsc;
    }

    public String getAEitdsc() {
        return aEitdsc;
    }

    public void setAEitdsc(String aEitdsc) {
        this.aEitdsc = aEitdsc;
    }

    public String getAEspdsc() {
        return aEspdsc;
    }

    public void setAEspdsc(String aEspdsc) {
        this.aEspdsc = aEspdsc;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUnmsr() {
        return unmsr;
    }

    public void setUnmsr(String unmsr) {
        this.unmsr = unmsr;
    }

    public String getUnmsre() {
        return unmsre;
    }

    public void setUnmsre(String unmsre) {
        this.unmsre = unmsre;
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
        if (!(object instanceof PLMItnbrDetailTemp)) {
            return false;
        }
        PLMItnbrDetailTemp other = (PLMItnbrDetailTemp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.plm.entity.PLMItnbrDetailTemp[ id=" + id + " ]";
    }
    
}
