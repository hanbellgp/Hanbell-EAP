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
 * @author C2082
 */
@Entity
@Table(name = "HZ_CW030_detail3")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HZCW030Detail3.findAll", query = "SELECT h FROM HZCW030Detail3 h"),
    @NamedQuery(name = "HZCW030Detail3.findByRecallbudgetAccname", query = "SELECT h FROM HZCW030Detail3 h WHERE h.recallbudgetAccname = :recallbudgetAccname"),
    @NamedQuery(name = "HZCW030Detail3.findByRecallresearchno", query = "SELECT h FROM HZCW030Detail3 h WHERE h.recallresearchno = :recallresearchno"),
    @NamedQuery(name = "HZCW030Detail3.findByTransfercenterName", query = "SELECT h FROM HZCW030Detail3 h WHERE h.transfercenterName = :transfercenterName"),
    @NamedQuery(name = "HZCW030Detail3.findByTransferamount", query = "SELECT h FROM HZCW030Detail3 h WHERE h.transferamount = :transferamount"),
    @NamedQuery(name = "HZCW030Detail3.findByTransferResearchno", query = "SELECT h FROM HZCW030Detail3 h WHERE h.transferResearchno = :transferResearchno"),
    @NamedQuery(name = "HZCW030Detail3.findByOID", query = "SELECT h FROM HZCW030Detail3 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HZCW030Detail3.findByRecallamount", query = "SELECT h FROM HZCW030Detail3 h WHERE h.recallamount = :recallamount"),
    @NamedQuery(name = "HZCW030Detail3.findByRecallcenterName", query = "SELECT h FROM HZCW030Detail3 h WHERE h.recallcenterName = :recallcenterName"),
    @NamedQuery(name = "HZCW030Detail3.findByTransfercenterid", query = "SELECT h FROM HZCW030Detail3 h WHERE h.transfercenterid = :transfercenterid"),
    @NamedQuery(name = "HZCW030Detail3.findByRecallbudgetAcc", query = "SELECT h FROM HZCW030Detail3 h WHERE h.recallbudgetAcc = :recallbudgetAcc"),
    @NamedQuery(name = "HZCW030Detail3.findByTransferbudgetAcc", query = "SELECT h FROM HZCW030Detail3 h WHERE h.transferbudgetAcc = :transferbudgetAcc"),
    @NamedQuery(name = "HZCW030Detail3.findByTransferbudgetAccname", query = "SELECT h FROM HZCW030Detail3 h WHERE h.transferbudgetAccname = :transferbudgetAccname"),
    @NamedQuery(name = "HZCW030Detail3.findByTransferDatetxt", query = "SELECT h FROM HZCW030Detail3 h WHERE h.transferDatetxt = :transferDatetxt"),
    @NamedQuery(name = "HZCW030Detail3.findByRecallDatetxt", query = "SELECT h FROM HZCW030Detail3 h WHERE h.recallDatetxt = :recallDatetxt"),
    @NamedQuery(name = "HZCW030Detail3.findByFSN", query = "SELECT h FROM HZCW030Detail3 h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HZCW030Detail3.findByRecallcenterid", query = "SELECT h FROM HZCW030Detail3 h WHERE h.recallcenterid = :recallcenterid"),
    @NamedQuery(name = "HZCW030Detail3.findBySeq", query = "SELECT h FROM HZCW030Detail3 h WHERE h.seq = :seq")})
public class HZCW030Detail3 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "recallbudgetAccname")
    private String recallbudgetAccname;
    @Size(max = 255)
    @Column(name = "recallresearchno")
    private String recallresearchno;
    @Size(max = 255)
    @Column(name = "transfercenterName")
    private String transfercenterName;
    @Size(max = 255)
    @Column(name = "transferamount")
    private String transferamount;
    @Size(max = 255)
    @Column(name = "transferResearchno")
    private String transferResearchno;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "recallamount")
    private String recallamount;
    @Size(max = 255)
    @Column(name = "recallcenterName")
    private String recallcenterName;
    @Size(max = 255)
    @Column(name = "transfercenterid")
    private String transfercenterid;
    @Size(max = 255)
    @Column(name = "recallbudgetAcc")
    private String recallbudgetAcc;
    @Size(max = 255)
    @Column(name = "transferbudgetAcc")
    private String transferbudgetAcc;
    @Size(max = 255)
    @Column(name = "transferbudgetAccname")
    private String transferbudgetAccname;
    @Size(max = 255)
    @Column(name = "transferDate_txt")
    private String transferDatetxt;
    @Size(max = 255)
    @Column(name = "recallDate_txt")
    private String recallDatetxt;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "recallcenterid")
    private String recallcenterid;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;

    public HZCW030Detail3() {
    }

    public HZCW030Detail3(String oid) {
        this.oid = oid;
    }

    public String getRecallbudgetAccname() {
        return recallbudgetAccname;
    }

    public void setRecallbudgetAccname(String recallbudgetAccname) {
        this.recallbudgetAccname = recallbudgetAccname;
    }

    public String getRecallresearchno() {
        return recallresearchno;
    }

    public void setRecallresearchno(String recallresearchno) {
        this.recallresearchno = recallresearchno;
    }

    public String getTransfercenterName() {
        return transfercenterName;
    }

    public void setTransfercenterName(String transfercenterName) {
        this.transfercenterName = transfercenterName;
    }

    public String getTransferamount() {
        return transferamount;
    }

    public void setTransferamount(String transferamount) {
        this.transferamount = transferamount;
    }

    public String getTransferResearchno() {
        return transferResearchno;
    }

    public void setTransferResearchno(String transferResearchno) {
        this.transferResearchno = transferResearchno;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getRecallamount() {
        return recallamount;
    }

    public void setRecallamount(String recallamount) {
        this.recallamount = recallamount;
    }

    public String getRecallcenterName() {
        return recallcenterName;
    }

    public void setRecallcenterName(String recallcenterName) {
        this.recallcenterName = recallcenterName;
    }

    public String getTransfercenterid() {
        return transfercenterid;
    }

    public void setTransfercenterid(String transfercenterid) {
        this.transfercenterid = transfercenterid;
    }

    public String getRecallbudgetAcc() {
        return recallbudgetAcc;
    }

    public void setRecallbudgetAcc(String recallbudgetAcc) {
        this.recallbudgetAcc = recallbudgetAcc;
    }

    public String getTransferbudgetAcc() {
        return transferbudgetAcc;
    }

    public void setTransferbudgetAcc(String transferbudgetAcc) {
        this.transferbudgetAcc = transferbudgetAcc;
    }

    public String getTransferbudgetAccname() {
        return transferbudgetAccname;
    }

    public void setTransferbudgetAccname(String transferbudgetAccname) {
        this.transferbudgetAccname = transferbudgetAccname;
    }

    public String getTransferDatetxt() {
        return transferDatetxt;
    }

    public void setTransferDatetxt(String transferDatetxt) {
        this.transferDatetxt = transferDatetxt;
    }

    public String getRecallDatetxt() {
        return recallDatetxt;
    }

    public void setRecallDatetxt(String recallDatetxt) {
        this.recallDatetxt = recallDatetxt;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getRecallcenterid() {
        return recallcenterid;
    }

    public void setRecallcenterid(String recallcenterid) {
        this.recallcenterid = recallcenterid;
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
        if (!(object instanceof HZCW030Detail3)) {
            return false;
        }
        HZCW030Detail3 other = (HZCW030Detail3) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HZCW030Detail3[ oid=" + oid + " ]";
    }
    
}
