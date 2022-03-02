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
@Table(name = "HSY_JG002_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HSYJG002Detail.findAll", query = "SELECT h FROM HSYJG002Detail h"),
    @NamedQuery(name = "HSYJG002Detail.findByFormid", query = "SELECT h FROM HSYJG002Detail h WHERE h.formid = :formid"),
    @NamedQuery(name = "HSYJG002Detail.findByModingFactory", query = "SELECT h FROM HSYJG002Detail h WHERE h.modingFactory = :modingFactory"),
    @NamedQuery(name = "HSYJG002Detail.findByItdsc", query = "SELECT h FROM HSYJG002Detail h WHERE h.itdsc = :itdsc"),
    @NamedQuery(name = "HSYJG002Detail.findByChangeContent", query = "SELECT h FROM HSYJG002Detail h WHERE h.changeContent = :changeContent"),
    @NamedQuery(name = "HSYJG002Detail.findByChangeType", query = "SELECT h FROM HSYJG002Detail h WHERE h.changeType = :changeType"),
    @NamedQuery(name = "HSYJG002Detail.findByCastingPlant", query = "SELECT h FROM HSYJG002Detail h WHERE h.castingPlant = :castingPlant"),
    @NamedQuery(name = "HSYJG002Detail.findByProcessingPlant", query = "SELECT h FROM HSYJG002Detail h WHERE h.processingPlant = :processingPlant"),
    @NamedQuery(name = "HSYJG002Detail.findByFSN", query = "SELECT h FROM HSYJG002Detail h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HSYJG002Detail.findByRemark", query = "SELECT h FROM HSYJG002Detail h WHERE h.remark = :remark"),
    @NamedQuery(name = "HSYJG002Detail.findByOID", query = "SELECT h FROM HSYJG002Detail h WHERE h.oid = :oid"),
    @NamedQuery(name = "HSYJG002Detail.findByItnbr", query = "SELECT h FROM HSYJG002Detail h WHERE h.itnbr = :itnbr"),
    @NamedQuery(name = "HSYJG002Detail.findBySeq", query = "SELECT h FROM HSYJG002Detail h WHERE h.seq = :seq")})
public class HSYJG002Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "formid")
    private String formid;
    @Size(max = 255)
    @Column(name = "modingFactory")
    private String modingFactory;
    @Size(max = 255)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "changeContent")
    private String changeContent;
    @Size(max = 255)
    @Column(name = "changeType")
    private String changeType;
    @Size(max = 255)
    @Column(name = "castingPlant")
    private String castingPlant;
    @Size(max = 255)
    @Column(name = "processingPlant")
    private String processingPlant;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 4000)
    @Column(name = "remark")
    private String remark;
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
    @Column(name = "seq")
    private String seq;
    @Size(max = 255)
    @Column(name = "positionOld")
    private String positionOld;
    @Size(max = 255)
    @Column(name = "positionNew")
    private String positionNew;
    
    public HSYJG002Detail() {
    }

    public HSYJG002Detail(String oid) {
        this.oid = oid;
    }

    public String getFormid() {
        return formid;
    }

    public void setFormid(String formid) {
        this.formid = formid;
    }

    public String getModingFactory() {
        return modingFactory;
    }

    public void setModingFactory(String modingFactory) {
        this.modingFactory = modingFactory;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getChangeContent() {
        return changeContent;
    }

    public void setChangeContent(String changeContent) {
        this.changeContent = changeContent;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    public String getCastingPlant() {
        return castingPlant;
    }

    public void setCastingPlant(String castingPlant) {
        this.castingPlant = castingPlant;
    }

    public String getProcessingPlant() {
        return processingPlant;
    }

    public void setProcessingPlant(String processingPlant) {
        this.processingPlant = processingPlant;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getPositionOld() {
        return positionOld;
    }

    public void setPositionOld(String positionOld) {
        this.positionOld = positionOld;
    }

    public String getPositionNew() {
        return positionNew;
    }

    public void setPositionNew(String positionNew) {
        this.positionNew = positionNew;
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
        if (!(object instanceof HSYJG002Detail)) {
            return false;
        }
        HSYJG002Detail other = (HSYJG002Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HSYJG002Detail[ oid=" + oid + " ]";
    }
    
}
