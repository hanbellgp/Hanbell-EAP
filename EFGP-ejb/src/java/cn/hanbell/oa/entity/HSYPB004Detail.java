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
@Table(name = "HSY_PB004_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HSYPB004Detail.findAll", query = "SELECT h FROM HSYPB004Detail h"),
    @NamedQuery(name = "HSYPB004Detail.findByFSN", query = "SELECT h FROM HSYPB004Detail h WHERE h.formSerialNumber = :fsn ORDER BY h.seq")})
public class HSYPB004Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "old_drawing")
    private String oldDrawing;
    @Size(max = 255)
    @Column(name = "ECN")
    private String ecn;
    @Size(max = 255)
    @Column(name = "address")
    private String address;
    @Size(max = 255)
    @Column(name = "new_itdsc")
    private String newItdsc;
    @Size(max = 255)
    @Column(name = "old_itdsc")
    private String oldItdsc;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "new_itnbr")
    private String newItnbr;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "new_drawing")
    private String newDrawing;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;
    @Size(max = 255)
    @Column(name = "old_itnbr")
    private String oldItnbr;

    public HSYPB004Detail() {
    }

    public HSYPB004Detail(String oid) {
        this.oid = oid;
    }

    public String getOldDrawing() {
        return oldDrawing;
    }

    public void setOldDrawing(String oldDrawing) {
        this.oldDrawing = oldDrawing;
    }

    public String getEcn() {
        return ecn;
    }

    public void setEcn(String ecn) {
        this.ecn = ecn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNewItdsc() {
        return newItdsc;
    }

    public void setNewItdsc(String newItdsc) {
        this.newItdsc = newItdsc;
    }

    public String getOldItdsc() {
        return oldItdsc;
    }

    public void setOldItdsc(String oldItdsc) {
        this.oldItdsc = oldItdsc;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getNewItnbr() {
        return newItnbr;
    }

    public void setNewItnbr(String newItnbr) {
        this.newItnbr = newItnbr;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getNewDrawing() {
        return newDrawing;
    }

    public void setNewDrawing(String newDrawing) {
        this.newDrawing = newDrawing;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getOldItnbr() {
        return oldItnbr;
    }

    public void setOldItnbr(String oldItnbr) {
        this.oldItnbr = oldItnbr;
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
        if (!(object instanceof HSYPB004Detail)) {
            return false;
        }
        HSYPB004Detail other = (HSYPB004Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HSYPB004Detail[ oid=" + oid + " ]";
    }

}
