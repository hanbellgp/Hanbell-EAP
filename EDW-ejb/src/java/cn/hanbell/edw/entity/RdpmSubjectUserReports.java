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
    private int subjectWorkPercent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SubjectWorkDateTime")
    @Temporal(value = TemporalType.DATE)
    private Date subjectWorkDateTime;

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

    public int getSubjectWorkPercent() {
        return subjectWorkPercent;
    }

    public void setSubjectWorkPercent(int subjectWorkPercent) {
        this.subjectWorkPercent = subjectWorkPercent;
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
