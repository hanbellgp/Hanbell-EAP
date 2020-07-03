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
@Table(name = "HZ_CW030_detail4")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HZCW030Detail4.findAll", query = "SELECT h FROM HZCW030Detail4 h"),
    @NamedQuery(name = "HZCW030Detail4.findByTransfercenterName2", query = "SELECT h FROM HZCW030Detail4 h WHERE h.transfercenterName2 = :transfercenterName2"),
    @NamedQuery(name = "HZCW030Detail4.findByRecallbudgetAccname2", query = "SELECT h FROM HZCW030Detail4 h WHERE h.recallbudgetAccname2 = :recallbudgetAccname2"),
    @NamedQuery(name = "HZCW030Detail4.findByTransferbudgetAcc2", query = "SELECT h FROM HZCW030Detail4 h WHERE h.transferbudgetAcc2 = :transferbudgetAcc2"),
    @NamedQuery(name = "HZCW030Detail4.findByRecallamount2", query = "SELECT h FROM HZCW030Detail4 h WHERE h.recallamount2 = :recallamount2"),
    @NamedQuery(name = "HZCW030Detail4.findByRecallcenterid2", query = "SELECT h FROM HZCW030Detail4 h WHERE h.recallcenterid2 = :recallcenterid2"),
    @NamedQuery(name = "HZCW030Detail4.findByOid", query = "SELECT h FROM HZCW030Detail4 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HZCW030Detail4.findByTransferamount2", query = "SELECT h FROM HZCW030Detail4 h WHERE h.transferamount2 = :transferamount2"),
    @NamedQuery(name = "HZCW030Detail4.findByNeedUser2lbl", query = "SELECT h FROM HZCW030Detail4 h WHERE h.needUser2lbl = :needUser2lbl"),
    @NamedQuery(name = "HZCW030Detail4.findByRecallbudgetAcc2", query = "SELECT h FROM HZCW030Detail4 h WHERE h.recallbudgetAcc2 = :recallbudgetAcc2"),
    @NamedQuery(name = "HZCW030Detail4.findByTransfercenterid2", query = "SELECT h FROM HZCW030Detail4 h WHERE h.transfercenterid2 = :transfercenterid2"),
    @NamedQuery(name = "HZCW030Detail4.findByFSN", query = "SELECT h FROM HZCW030Detail4 h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HZCW030Detail4.findByNeedUser2txt", query = "SELECT h FROM HZCW030Detail4 h WHERE h.needUser2txt = :needUser2txt"),
    @NamedQuery(name = "HZCW030Detail4.findByTrfbudgetAccname2", query = "SELECT h FROM HZCW030Detail4 h WHERE h.trfbudgetAccname2 = :trfbudgetAccname2"),
    @NamedQuery(name = "HZCW030Detail4.findBySeq", query = "SELECT h FROM HZCW030Detail4 h WHERE h.seq = :seq"),
    @NamedQuery(name = "HZCW030Detail4.findByRecallcenterName2", query = "SELECT h FROM HZCW030Detail4 h WHERE h.recallcenterName2 = :recallcenterName2"),
    @NamedQuery(name = "HZCW030Detail4.findByNeedUser3txt", query = "SELECT h FROM HZCW030Detail4 h WHERE h.needUser3txt = :needUser3txt"),
    @NamedQuery(name = "HZCW030Detail4.findByNeedUser3lbl", query = "SELECT h FROM HZCW030Detail4 h WHERE h.needUser3lbl = :needUser3lbl")})
public class HZCW030Detail4 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "transfercenterName2")
    private String transfercenterName2;
    @Size(max = 255)
    @Column(name = "recallbudgetAccname2")
    private String recallbudgetAccname2;
    @Size(max = 255)
    @Column(name = "transferbudgetAcc2")
    private String transferbudgetAcc2;
    @Size(max = 255)
    @Column(name = "recallamount2")
    private String recallamount2;
    @Size(max = 255)
    @Column(name = "recallcenterid2")
    private String recallcenterid2;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "transferamount2")
    private String transferamount2;
    @Size(max = 255)
    @Column(name = "needUser2_lbl")
    private String needUser2lbl;
    @Size(max = 255)
    @Column(name = "recallbudgetAcc2")
    private String recallbudgetAcc2;
    @Size(max = 255)
    @Column(name = "transfercenterid2")
    private String transfercenterid2;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "needUser2_txt")
    private String needUser2txt;
    @Size(max = 255)
    @Column(name = "trfbudgetAccname2")
    private String trfbudgetAccname2;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;
    @Size(max = 255)
    @Column(name = "recallcenterName2")
    private String recallcenterName2;
    @Size(max = 255)
    @Column(name = "needUser3_txt")
    private String needUser3txt;
    @Size(max = 255)
    @Column(name = "needUser3_lbl")
    private String needUser3lbl;

    public HZCW030Detail4() {
    }

    public HZCW030Detail4(String oid) {
        this.oid = oid;
    }

    public String getTransfercenterName2() {
        return transfercenterName2;
    }

    public void setTransfercenterName2(String transfercenterName2) {
        this.transfercenterName2 = transfercenterName2;
    }

    public String getRecallbudgetAccname2() {
        return recallbudgetAccname2;
    }

    public void setRecallbudgetAccname2(String recallbudgetAccname2) {
        this.recallbudgetAccname2 = recallbudgetAccname2;
    }

    public String getTransferbudgetAcc2() {
        return transferbudgetAcc2;
    }

    public void setTransferbudgetAcc2(String transferbudgetAcc2) {
        this.transferbudgetAcc2 = transferbudgetAcc2;
    }

    public String getRecallamount2() {
        return recallamount2;
    }

    public void setRecallamount2(String recallamount2) {
        this.recallamount2 = recallamount2;
    }

    public String getRecallcenterid2() {
        return recallcenterid2;
    }

    public void setRecallcenterid2(String recallcenterid2) {
        this.recallcenterid2 = recallcenterid2;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getTransferamount2() {
        return transferamount2;
    }

    public void setTransferamount2(String transferamount2) {
        this.transferamount2 = transferamount2;
    }

    public String getNeedUser2lbl() {
        return needUser2lbl;
    }

    public void setNeedUser2lbl(String needUser2lbl) {
        this.needUser2lbl = needUser2lbl;
    }

    public String getRecallbudgetAcc2() {
        return recallbudgetAcc2;
    }

    public void setRecallbudgetAcc2(String recallbudgetAcc2) {
        this.recallbudgetAcc2 = recallbudgetAcc2;
    }

    public String getTransfercenterid2() {
        return transfercenterid2;
    }

    public void setTransfercenterid2(String transfercenterid2) {
        this.transfercenterid2 = transfercenterid2;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getNeedUser2txt() {
        return needUser2txt;
    }

    public void setNeedUser2txt(String needUser2txt) {
        this.needUser2txt = needUser2txt;
    }

    public String getTrfbudgetAccname2() {
        return trfbudgetAccname2;
    }

    public void setTrfbudgetAccname2(String trfbudgetAccname2) {
        this.trfbudgetAccname2 = trfbudgetAccname2;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getRecallcenterName2() {
        return recallcenterName2;
    }

    public void setRecallcenterName2(String recallcenterName2) {
        this.recallcenterName2 = recallcenterName2;
    }

    public String getNeedUser3txt() {
        return needUser3txt;
    }

    public void setNeedUser3txt(String needUser3txt) {
        this.needUser3txt = needUser3txt;
    }

    public String getNeedUser3lbl() {
        return needUser3lbl;
    }

    public void setNeedUser3lbl(String needUser3lbl) {
        this.needUser3lbl = needUser3lbl;
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
        if (!(object instanceof HZCW030Detail4)) {
            return false;
        }
        HZCW030Detail4 other = (HZCW030Detail4) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HZCW030Detail4[ oid=" + oid + " ]";
    }
    
}
