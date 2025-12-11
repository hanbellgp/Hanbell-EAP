/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.edw.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "RdpmSubjectUserReports")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RdpmSubjectUserReports.findAll", query = "SELECT e FROM RdpmSubjectUserReports e"),
    @NamedQuery(name = "RdpmSubjectUserReports.findBySubjectUserNoAndSubjectWorkDateTime", query = "SELECT e FROM RdpmSubjectUserReports e   WHERE e.subjectUserNo = :subjectUserNo  AND  e.subjectWorkDateTime LIKE :subjectWorkDateTime"),
    @NamedQuery(name = "RdpmSubjectUserReports.findById", query = "SELECT e FROM RdpmSubjectUserReports e WHERE e.id = :id")})
public class RdpmSubjectUserReports implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @Column(name = "Id")
    private String id;
    @Size(max = 50)
    @Column(name = "SubjectNo")
    private String subjectNo;
    @Size(max = 155)
    @Column(name = "SubjectName")
    private String subjectName;
    @Size(max = 50)
    @Column(name = "UType")
    private String uType;
    @Size(max = 50)
    @Column(name = "SubjectUserNo")
    private String subjectUserNo;
    @Size(max = 155)
    @Column(name = "SubjectUserName")
    private String subjectUserName;
    @Size(max = 155)
    @Column(name = "SubjectWorkPercent")
    private double subjectWorkPercent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SubjectWorkDateTime")
    @Temporal(value = TemporalType.DATE)
    private Date subjectWorkDateTime;
    @Column(name = "SubjectSeq")
    private int subjectSeq;
    @Size(max = 155)
    @Column(name = "SubjectSeqName")
    private String subjectSeqName;

    @Size(max = 5)
    @Column(name = "Facno")
    private String facno;
    @Size(max = 50)
    @Column(name = "SubjectDept")
    private String subjectDept;

    @Size(max = 155)
    @Column(name = "SubjectDeptName")
    private String subjectDeptName;
    @Size(max = 155)
    @Column(name = "RelationUserNo")
    private String relationUserNo;

    public RdpmSubjectUserReports() {
    }

    public RdpmSubjectUserReports(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubjectNo() {
        return subjectNo;
    }

    public void setSubjectNo(String subjectNo) {
        this.subjectNo = subjectNo;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getuType() {
        return uType;
    }

    public void setuType(String uType) {
        this.uType = uType;
    }

    public String getSubjectUserNo() {
        return subjectUserNo;
    }

    public void setSubjectUserNo(String subjectUserNo) {
        this.subjectUserNo = subjectUserNo;
    }

    public String getSubjectUserName() {
        return subjectUserName;
    }

    public void setSubjectUserName(String subjectUserName) {
        this.subjectUserName = subjectUserName;
    }

    public Date getSubjectWorkDateTime() {
        return subjectWorkDateTime;
    }

    public void setSubjectWorkDateTime(Date subjectWorkDateTime) {
        this.subjectWorkDateTime = subjectWorkDateTime;
    }

    public double getSubjectWorkPercent() {
        return subjectWorkPercent;
    }

    public void setSubjectWorkPercent(double subjectWorkPercent) {
        this.subjectWorkPercent = subjectWorkPercent;
    }

    public int getSubjectSeq() {
        return subjectSeq;
    }

    public void setSubjectSeq(int subjectSeq) {
        this.subjectSeq = subjectSeq;
    }

    public String getSubjectSeqName() {
        return subjectSeqName;
    }

    public void setSubjectSeqName(String subjectSeqName) {
        this.subjectSeqName = subjectSeqName;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getSubjectDept() {
        return subjectDept;
    }

    public void setSubjectDept(String subjectDept) {
        this.subjectDept = subjectDept;
    }

    public String getSubjectDeptName() {
        return subjectDeptName;
    }

    public void setSubjectDeptName(String subjectDeptName) {
        this.subjectDeptName = subjectDeptName;
    }

    public String getRelationUserNo() {
        return relationUserNo;
    }

    public void setRelationUserNo(String relationUserNo) {
        this.relationUserNo = relationUserNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RdpmSubjectUserReports)) {
            return false;
        }
        RdpmSubjectUserReports other = (RdpmSubjectUserReports) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.edw.entity.EhsSecure[ id=" + id + " ]";
    }

}
