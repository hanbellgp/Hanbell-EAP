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
 * @author C0160
 */
@Entity
@Table(name = "HZ_CW027_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HZCW027Detail.findAll", query = "SELECT h FROM HZCW027Detail h"),
    @NamedQuery(name = "HZCW027Detail.findByOid", query = "SELECT h FROM HZCW027Detail h WHERE h.oid = :oid"),
    @NamedQuery(name = "HZCW027Detail.findByFSN", query = "SELECT h FROM HZCW027Detail h WHERE h.formSerialNumber = :fsn")})
public class HZCW027Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "fphm")
    private String fphm;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "zy")
    private String zy;
    @Size(max = 255)
    @Column(name = "ysje")
    private String ysje;
    @Size(max = 255)
    @Column(name = "ssje")
    private String ssje;
    @Size(max = 255)
    @Column(name = "no")
    private String no;
    @Size(max = 255)
    @Column(name = "bibi")
    private String bibi;
    @Size(max = 255)
    @Column(name = "acctno")
    private String acctno;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;

    public HZCW027Detail() {
    }

    public HZCW027Detail(String oid) {
        this.oid = oid;
    }

    public String getFphm() {
        return fphm;
    }

    public void setFphm(String fphm) {
        this.fphm = fphm;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getZy() {
        return zy;
    }

    public void setZy(String zy) {
        this.zy = zy;
    }

    public String getYsje() {
        return ysje;
    }

    public void setYsje(String ysje) {
        this.ysje = ysje;
    }

    public String getSsje() {
        return ssje;
    }

    public void setSsje(String ssje) {
        this.ssje = ssje;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getBibi() {
        return bibi;
    }

    public void setBibi(String bibi) {
        this.bibi = bibi;
    }

    public String getAcctno() {
        return acctno;
    }

    public void setAcctno(String acctno) {
        this.acctno = acctno;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
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
        if (!(object instanceof HZCW027Detail)) {
            return false;
        }
        HZCW027Detail other = (HZCW027Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HZCW027Detail[ oid=" + oid + " ]";
    }

}
