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
@Table(name = "SHB_ERP_MIS226_invwhclkDetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SHBERPMIS226InvwhclkDetail.findAll", query = "SELECT s FROM SHBERPMIS226InvwhclkDetail s"),
    @NamedQuery(name = "SHBERPMIS226InvwhclkDetail.findByOID", query = "SELECT s FROM SHBERPMIS226InvwhclkDetail s WHERE s.oid = :oid"),
    @NamedQuery(name = "SHBERPMIS226InvwhclkDetail.findByFSN", query = "SELECT s FROM SHBERPMIS226InvwhclkDetail s WHERE s.formSerialNumber = :fsn")})
public class SHBERPMIS226InvwhclkDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "wclerk_lbl")
    private String wclerkLbl;
    @Size(max = 255)
    @Column(name = "wclerk_txt")
    private String wclerkTxt;
    @Size(max = 255)
    @Column(name = "warehouse1")
    private String warehouse1;
    @Size(max = 255)
    @Column(name = "warehouse2")
    private String warehouse2;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;

    public SHBERPMIS226InvwhclkDetail() {
    }

    public SHBERPMIS226InvwhclkDetail(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getWclerkLbl() {
        return wclerkLbl;
    }

    public void setWclerkLbl(String wclerkLbl) {
        this.wclerkLbl = wclerkLbl;
    }

    public String getWclerkTxt() {
        return wclerkTxt;
    }

    public void setWclerkTxt(String wclerkTxt) {
        this.wclerkTxt = wclerkTxt;
    }

    public String getWarehouse1() {
        return warehouse1;
    }

    public void setWarehouse1(String warehouse1) {
        this.warehouse1 = warehouse1;
    }

    public String getWarehouse2() {
        return warehouse2;
    }

    public void setWarehouse2(String warehouse2) {
        this.warehouse2 = warehouse2;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
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
        if (!(object instanceof SHBERPMIS226InvwhclkDetail)) {
            return false;
        }
        SHBERPMIS226InvwhclkDetail other = (SHBERPMIS226InvwhclkDetail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.SHBERPMIS226InvwhclkDetail[ oid=" + oid + " ]";
    }

}
