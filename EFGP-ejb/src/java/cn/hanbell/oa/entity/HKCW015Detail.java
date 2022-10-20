/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.entity;

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
 * @author Administrator
 */
@Entity
@Table(name = "HK_CW015_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKCW015Detail.findAll", query = "SELECT h FROM HKCW015Detail h"),
    @NamedQuery(name = "HKCW015Detail.findBySummary", query = "SELECT h FROM HKCW015Detail h WHERE h.summary = :summary"),
    @NamedQuery(name = "HKCW015Detail.findByOtheramts", query = "SELECT h FROM HKCW015Detail h WHERE h.otheramts = :otheramts"),
    @NamedQuery(name = "HKCW015Detail.findByDrafttamts", query = "SELECT h FROM HKCW015Detail h WHERE h.drafttamts = :drafttamts"),
    @NamedQuery(name = "HKCW015Detail.findByNtsamts", query = "SELECT h FROM HKCW015Detail h WHERE h.ntsamts = :ntsamts"),
    @NamedQuery(name = "HKCW015Detail.findByTtamts", query = "SELECT h FROM HKCW015Detail h WHERE h.ttamts = :ttamts"),
    @NamedQuery(name = "HKCW015Detail.findByFSN", query = "SELECT h FROM HKCW015Detail h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKCW015Detail.findByOid", query = "SELECT h FROM HKCW015Detail h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKCW015Detail.findBySrcno", query = "SELECT h FROM HKCW015Detail h WHERE h.srcno = :srcno"),
    @NamedQuery(name = "HKCW015Detail.findByDraftiamts", query = "SELECT h FROM HKCW015Detail h WHERE h.draftiamts = :draftiamts"),
    @NamedQuery(name = "HKCW015Detail.findBySeq", query = "SELECT h FROM HKCW015Detail h WHERE h.seq = :seq")})
public class HKCW015Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "summary")
    private String summary;
    @Size(max = 255)
    @Column(name = "otheramts")
    private String otheramts;
    @Size(max = 255)
    @Column(name = "drafttamts")
    private String drafttamts;
    @Size(max = 255)
    @Column(name = "ntsamts")
    private String ntsamts;
    @Size(max = 255)
    @Column(name = "ttamts")
    private String ttamts;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "srcno")
    private String srcno;
    @Size(max = 255)
    @Column(name = "draftiamts")
    private String draftiamts;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;

    public HKCW015Detail() {
    }

    public HKCW015Detail(String oid) {
        this.oid = oid;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getOtheramts() {
        return otheramts;
    }

    public void setOtheramts(String otheramts) {
        this.otheramts = otheramts;
    }

    public String getDrafttamts() {
        return drafttamts;
    }

    public void setDrafttamts(String drafttamts) {
        this.drafttamts = drafttamts;
    }

    public String getNtsamts() {
        return ntsamts;
    }

    public void setNtsamts(String ntsamts) {
        this.ntsamts = ntsamts;
    }

    public String getTtamts() {
        return ttamts;
    }

    public void setTtamts(String ttamts) {
        this.ttamts = ttamts;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getSrcno() {
        return srcno;
    }

    public void setSrcno(String srcno) {
        this.srcno = srcno;
    }

    public String getDraftiamts() {
        return draftiamts;
    }

    public void setDraftiamts(String draftiamts) {
        this.draftiamts = draftiamts;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oid != null ? oid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HKCW015Detail)) {
            return false;
        }
        HKCW015Detail other = (HKCW015Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKCW015Detail[ oid=" + oid + " ]";
    }
    
}
