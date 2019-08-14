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
@Table(name = "HK_CW003_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKCW003Detail.findAll", query = "SELECT s FROM HKCW003Detail s"),
    @NamedQuery(name = "HKCW003Detail.findBySpdsc", query = "SELECT s FROM HKCW003Detail s WHERE s.spdsc = :spdsc"),
    @NamedQuery(name = "HKCW003Detail.findByOid", query = "SELECT s FROM HKCW003Detail s WHERE s.oid = :oid"),
    @NamedQuery(name = "HKCW003Detail.findByAsscost", query = "SELECT s FROM HKCW003Detail s WHERE s.asscost = :asscost"),
    @NamedQuery(name = "HKCW003Detail.findByEspdsc", query = "SELECT s FROM HKCW003Detail s WHERE s.espdsc = :espdsc"),
    @NamedQuery(name = "HKCW003Detail.findBySeq", query = "SELECT s FROM HKCW003Detail s WHERE s.seq = :seq"),
    @NamedQuery(name = "HKCW003Detail.findByItnbr", query = "SELECT s FROM HKCW003Detail s WHERE s.itnbr = :itnbr"),
    @NamedQuery(name = "HKCW003Detail.findByUnmsr1", query = "SELECT s FROM HKCW003Detail s WHERE s.unmsr1 = :unmsr1"),
    @NamedQuery(name = "HKCW003Detail.findByItdsc", query = "SELECT s FROM HKCW003Detail s WHERE s.itdsc = :itdsc"),
    @NamedQuery(name = "HKCW003Detail.findByCost", query = "SELECT s FROM HKCW003Detail s WHERE s.cost = :cost"),
    @NamedQuery(name = "HKCW003Detail.findByFSN", query = "SELECT s FROM HKCW003Detail s WHERE s.formSerialNumber = :fsn")})
public class HKCW003Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "spdsc")
    private String spdsc;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "asscost")
    private String asscost;
    @Size(max = 255)
    @Column(name = "espdsc")
    private String espdsc;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;
    @Size(max = 255)
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "unmsr1")
    private String unmsr1;
    @Size(max = 255)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "cost")
    private String cost;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;

    public HKCW003Detail() {
    }

    public HKCW003Detail(String oid) {
        this.oid = oid;
    }

    public String getSpdsc() {
        return spdsc;
    }

    public void setSpdsc(String spdsc) {
        this.spdsc = spdsc;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getAsscost() {
        return asscost;
    }

    public void setAsscost(String asscost) {
        this.asscost = asscost;
    }

    public String getEspdsc() {
        return espdsc;
    }

    public void setEspdsc(String espdsc) {
        this.espdsc = espdsc;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getUnmsr1() {
        return unmsr1;
    }

    public void setUnmsr1(String unmsr1) {
        this.unmsr1 = unmsr1;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
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
        if (!(object instanceof HKCW003Detail)) {
            return false;
        }
        HKCW003Detail other = (HKCW003Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKCW003Detail[ oid=" + oid + " ]";
    }

}
