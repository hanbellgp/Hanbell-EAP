/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.edw.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "RdpmOrderOA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RdpmOrderOA.findAll", query = "SELECT r FROM RdpmOrderOA r"),
    @NamedQuery(name = "RdpmOrderOA.findByFacno", query = "SELECT r FROM RdpmOrderOA r WHERE r.facno = :facno"),
    @NamedQuery(name = "RdpmOrderOA.findByDepno", query = "SELECT r FROM RdpmOrderOA r WHERE r.depno = :depno"),
    @NamedQuery(name = "RdpmOrderOA.findByRequestUserno", query = "SELECT r FROM RdpmOrderOA r WHERE r.requestUserno = :requestUserno"),
    @NamedQuery(name = "RdpmOrderOA.findByFormId", query = "SELECT r FROM RdpmOrderOA r WHERE r.rdpmOrderOAPK.formId = :formId"),
    @NamedQuery(name = "RdpmOrderOA.findByFormTrseq", query = "SELECT r FROM RdpmOrderOA r WHERE r.rdpmOrderOAPK.formTrseq = :formTrseq"),
    @NamedQuery(name = "RdpmOrderOA.findByRequestItnbr", query = "SELECT r FROM RdpmOrderOA r WHERE r.rdpmOrderOAPK.requestItnbr = :requestItnbr"),
    @NamedQuery(name = "RdpmOrderOA.findByRequestItdsc", query = "SELECT r FROM RdpmOrderOA r WHERE r.requestItdsc = :requestItdsc"),
    @NamedQuery(name = "RdpmOrderOA.findByRequestSpec", query = "SELECT r FROM RdpmOrderOA r WHERE r.requestSpec = :requestSpec"),
    @NamedQuery(name = "RdpmOrderOA.findByRequstQty", query = "SELECT r FROM RdpmOrderOA r WHERE r.requstQty = :requstQty"),
    @NamedQuery(name = "RdpmOrderOA.findByCreateDate", query = "SELECT r FROM RdpmOrderOA r WHERE r.createDate = :createDate"),
    @NamedQuery(name = "RdpmOrderOA.findByRequestDate", query = "SELECT r FROM RdpmOrderOA r WHERE r.requestDate = :requestDate"),
    @NamedQuery(name = "RdpmOrderOA.findByAskDate", query = "SELECT r FROM RdpmOrderOA r WHERE r.askDate = :askDate"),
    @NamedQuery(name = "RdpmOrderOA.findByBuyerno", query = "SELECT r FROM RdpmOrderOA r WHERE r.buyerno = :buyerno"),
    @NamedQuery(name = "RdpmOrderOA.findBySourcePrNo", query = "SELECT r FROM RdpmOrderOA r WHERE r.sourcePrNo = :sourcePrNo"),
    @NamedQuery(name = "RdpmOrderOA.findBySourcePrName", query = "SELECT r FROM RdpmOrderOA r WHERE r.sourcePrName = :sourcePrName"),
    @NamedQuery(name = "RdpmOrderOA.findByHmark", query = "SELECT r FROM RdpmOrderOA r WHERE r.hmark = :hmark"),
    @NamedQuery(name = "RdpmOrderOA.findByFlag", query = "SELECT r FROM RdpmOrderOA r WHERE r.flag = :flag"),
    @NamedQuery(name = "RdpmOrderOA.findByUpdateTime", query = "SELECT r FROM RdpmOrderOA r WHERE r.updateTime = :updateTime")})
public class RdpmOrderOA implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RdpmOrderOAPK rdpmOrderOAPK;
    @Size(max = 3)
    @Column(name = "Facno")
    private String facno;
    @Size(max = 8)
    @Column(name = "Depno")
    private String depno;
    @Size(max = 20)
    @Column(name = "RequestUserno")
    private String requestUserno;
    @Size(max = 50)
    @Column(name = "RequestItdsc")
    private String requestItdsc;
    @Size(max = 50)
    @Column(name = "RequestSpec")
    private String requestSpec;
    @Column(name = "RequstQty")
    private Integer requstQty;
    @Column(name = "CreateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "RequestDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date requestDate;
    @Column(name = "AskDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date askDate;
    @Size(max = 20)
    @Column(name = "Buyerno")
    private String buyerno;
    @Size(max = 50)
    @Column(name = "SourcePrNo")
    private String sourcePrNo;
    @Size(max = 100)
    @Column(name = "SourcePrName")
    private String sourcePrName;
    @Size(max = 20)
    @Column(name = "Prno")
    private String Prno;
    @Column(name = "Trseq")
    private int Trseq;
    @Size(max = 100)
    @Column(name = "hmark")
    private String hmark;
    @Size(max = 1)
    @Column(name = "flag")
    private String flag;
    @Column(name = "UpdateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    public RdpmOrderOA() {
    }

    public RdpmOrderOA(RdpmOrderOAPK rdpmOrderOAPK) {
        this.rdpmOrderOAPK = rdpmOrderOAPK;
    }

    public RdpmOrderOA(String formId, int formTrseq, String requestItnbr) {
        this.rdpmOrderOAPK = new RdpmOrderOAPK(formId, formTrseq, requestItnbr);
    }

    public RdpmOrderOAPK getRdpmOrderOAPK() {
        return rdpmOrderOAPK;
    }

    public void setRdpmOrderOAPK(RdpmOrderOAPK rdpmOrderOAPK) {
        this.rdpmOrderOAPK = rdpmOrderOAPK;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getDepno() {
        return depno;
    }

    public void setDepno(String depno) {
        this.depno = depno;
    }

    public String getRequestUserno() {
        return requestUserno;
    }

    public void setRequestUserno(String requestUserno) {
        this.requestUserno = requestUserno;
    }

    public String getRequestItdsc() {
        return requestItdsc;
    }

    public void setRequestItdsc(String requestItdsc) {
        this.requestItdsc = requestItdsc;
    }

    public String getRequestSpec() {
        return requestSpec;
    }

    public void setRequestSpec(String requestSpec) {
        this.requestSpec = requestSpec;
    }

    public Integer getRequstQty() {
        return requstQty;
    }

    public void setRequstQty(Integer requstQty) {
        this.requstQty = requstQty;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getAskDate() {
        return askDate;
    }

    public void setAskDate(Date askDate) {
        this.askDate = askDate;
    }

    public String getBuyerno() {
        return buyerno;
    }

    public void setBuyerno(String buyerno) {
        this.buyerno = buyerno;
    }

    public String getSourcePrNo() {
        return sourcePrNo;
    }

    public void setSourcePrNo(String sourcePrNo) {
        this.sourcePrNo = sourcePrNo;
    }

    public String getSourcePrName() {
        return sourcePrName;
    }

    public void setSourcePrName(String sourcePrName) {
        this.sourcePrName = sourcePrName;
    }

    public String getHmark() {
        return hmark;
    }

    public void setHmark(String hmark) {
        this.hmark = hmark;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rdpmOrderOAPK != null ? rdpmOrderOAPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RdpmOrderOA)) {
            return false;
        }
        RdpmOrderOA other = (RdpmOrderOA) object;
        if ((this.rdpmOrderOAPK == null && other.rdpmOrderOAPK != null) || (this.rdpmOrderOAPK != null && !this.rdpmOrderOAPK.equals(other.rdpmOrderOAPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.edw.entity.RdpmOrderOA[ rdpmOrderOAPK=" + rdpmOrderOAPK + " ]";
    }

    public String getPrno() {
        return Prno;
    }

    public void setPrno(String Prno) {
        this.Prno = Prno;
    }

    public int getTrseq() {
        return Trseq;
    }

    public void setTrseq(int Trseq) {
        this.Trseq = Trseq;
    }

}
