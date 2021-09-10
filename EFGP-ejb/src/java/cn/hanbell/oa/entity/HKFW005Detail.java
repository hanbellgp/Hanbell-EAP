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
 * @author Administrator
 */
@Entity
@Table(name = "HK_FW005_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKFW005Detail.findAll", query = "SELECT h FROM HKFW005Detail h"),
    @NamedQuery(name = "HKFW005Detail.findByOID", query = "SELECT h FROM HKFW005Detail h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKFW005Detail.findByModel", query = "SELECT h FROM HKFW005Detail h WHERE h.model = :model"),
    @NamedQuery(name = "HKFW005Detail.findByCreateno", query = "SELECT h FROM HKFW005Detail h WHERE h.createno = :createno"),
    @NamedQuery(name = "HKFW005Detail.findByNo", query = "SELECT h FROM HKFW005Detail h WHERE h.no = :no"),
    @NamedQuery(name = "HKFW005Detail.findByQty", query = "SELECT h FROM HKFW005Detail h WHERE h.qty = :qty"),
    @NamedQuery(name = "HKFW005Detail.findByItnbr", query = "SELECT h FROM HKFW005Detail h WHERE h.itnbr = :itnbr"),
    @NamedQuery(name = "HKFW005Detail.findByItdsc", query = "SELECT h FROM HKFW005Detail h WHERE h.itdsc = :itdsc"),
    @NamedQuery(name = "HKFW005Detail.findByFSN", query = "SELECT h FROM HKFW005Detail h WHERE h.formSerialNumber = :fsn ORDER BY CAST(h.no NUMERIC(10,2))"),
    @NamedQuery(name = "HKFW005Detail.findByCdrno", query = "SELECT h FROM HKFW005Detail h WHERE h.cdrno = :cdrno")})
public class HKFW005Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "model")
    private String model;
    @Size(max = 255)
    @Column(name = "createno")
    private String createno;
    @Size(max = 255)
    @Column(name = "no")
    private String no;
    @Size(max = 255)
    @Column(name = "qty")
    private String qty;
    @Size(max = 255)
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "cdrno")
    private String cdrno;
    @Size(max = 255)
    @Column(name = "trseq")
    private String trseq;

    @JoinColumn(name = "formSerialNumber", referencedColumnName = "formSerialNumber", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private HKFW005 hkfw005;
    
    public HKFW005Detail() {
    }

    public HKFW005Detail(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCreateno() {
        return createno;
    }

    public void setCreateno(String createno) {
        this.createno = createno;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
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

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getCdrno() {
        return cdrno;
    }

    public void setCdrno(String cdrno) {
        this.cdrno = cdrno;
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
        if (!(object instanceof HKFW005Detail)) {
            return false;
        }
        HKFW005Detail other = (HKFW005Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKFW005Detail[ oid=" + oid + " ]";
    }

    public String getTrseq() {
        return trseq;
    }

    public void setTrseq(String trseq) {
        this.trseq = trseq;
    }

    public HKFW005 getHkfw005() {
        return hkfw005;
    }

    public void setHkfw005(HKFW005 hkfw005) {
        this.hkfw005 = hkfw005;
    }

}
