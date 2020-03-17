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
@Table(name = "HK_PB054_WLDetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKPB054WLDetail.findAll", query = "SELECT h FROM HKPB054WLDetail h"),
    @NamedQuery(name = "HKPB054WLDetail.findByJEtotalB", query = "SELECT h FROM HKPB054WLDetail h WHERE h.jEtotalB = :jEtotalB"),
    @NamedQuery(name = "HKPB054WLDetail.findByNo", query = "SELECT h FROM HKPB054WLDetail h WHERE h.no = :no"),
    @NamedQuery(name = "HKPB054WLDetail.findByWareh", query = "SELECT h FROM HKPB054WLDetail h WHERE h.wareh = :wareh"),
    @NamedQuery(name = "HKPB054WLDetail.findByCost", query = "SELECT h FROM HKPB054WLDetail h WHERE h.cost = :cost"),
    @NamedQuery(name = "HKPB054WLDetail.findByQuantity", query = "SELECT h FROM HKPB054WLDetail h WHERE h.quantity = :quantity"),
    @NamedQuery(name = "HKPB054WLDetail.findByItdsc", query = "SELECT h FROM HKPB054WLDetail h WHERE h.itdsc = :itdsc"),
    @NamedQuery(name = "HKPB054WLDetail.findByUnmsr", query = "SELECT h FROM HKPB054WLDetail h WHERE h.unmsr = :unmsr"),
    @NamedQuery(name = "HKPB054WLDetail.findByFSN", query = "SELECT h FROM HKPB054WLDetail h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKPB054WLDetail.findByOid", query = "SELECT h FROM HKPB054WLDetail h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKPB054WLDetail.findByItnbr", query = "SELECT h FROM HKPB054WLDetail h WHERE h.itnbr = :itnbr"),
    @NamedQuery(name = "HKPB054WLDetail.findByWhdsc", query = "SELECT h FROM HKPB054WLDetail h WHERE h.whdsc = :whdsc")})
public class HKPB054WLDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "JEtotalB")
    private String jEtotalB;
    @Size(max = 255)
    @Column(name = "no")
    private String no;
    @Size(max = 255)
    @Column(name = "wareh")
    private String wareh;
    @Size(max = 255)
    @Column(name = "cost")
    private String cost;
    @Size(max = 255)
    @Column(name = "quantity")
    private String quantity;
    @Size(max = 255)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "unmsr")
    private String unmsr;
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
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "whdsc")
    private String whdsc;

    public HKPB054WLDetail() {
    }

    public HKPB054WLDetail(String oid) {
        this.oid = oid;
    }

    public String getJEtotalB() {
        return jEtotalB;
    }

    public void setJEtotalB(String jEtotalB) {
        this.jEtotalB = jEtotalB;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getWareh() {
        return wareh;
    }

    public void setWareh(String wareh) {
        this.wareh = wareh;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getUnmsr() {
        return unmsr;
    }

    public void setUnmsr(String unmsr) {
        this.unmsr = unmsr;
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

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getWhdsc() {
        return whdsc;
    }

    public void setWhdsc(String whdsc) {
        this.whdsc = whdsc;
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
        if (!(object instanceof HKPB054WLDetail)) {
            return false;
        }
        HKPB054WLDetail other = (HKPB054WLDetail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKPB054WLDetail[ oid=" + oid + " ]";
    }

}
