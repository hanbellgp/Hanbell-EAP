/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "demands")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Demands.findAll", query = "SELECT d FROM Demands d"),
    @NamedQuery(name = "Demands.findByAppendix", query = "SELECT d FROM Demands d WHERE d.appendix = :appendix"),
    @NamedQuery(name = "Demands.findByCfmdate", query = "SELECT d FROM Demands d WHERE d.cfmdate = :cfmdate"),
    @NamedQuery(name = "Demands.findByCfmuser", query = "SELECT d FROM Demands d WHERE d.cfmuser = :cfmuser"),
    @NamedQuery(name = "Demands.findByCreator", query = "SELECT d FROM Demands d WHERE d.creator = :creator"),
    @NamedQuery(name = "Demands.findByCredate", query = "SELECT d FROM Demands d WHERE d.credate = :credate"),
    @NamedQuery(name = "Demands.findByDemandContent", query = "SELECT d FROM Demands d WHERE d.demandContent = :demandContent"),
    @NamedQuery(name = "Demands.findByDemandDate", query = "SELECT d FROM Demands d WHERE d.demandDate = :demandDate"),
    @NamedQuery(name = "Demands.findByDemandDeptName", query = "SELECT d FROM Demands d WHERE d.demandDeptName = :demandDeptName"),
    @NamedQuery(name = "Demands.findByDemandDeptno", query = "SELECT d FROM Demands d WHERE d.demandDeptno = :demandDeptno"),
    @NamedQuery(name = "Demands.findByDemandName", query = "SELECT d FROM Demands d WHERE d.demandName = :demandName"),
    @NamedQuery(name = "Demands.findByDemandNameID", query = "SELECT d FROM Demands d WHERE d.demandNameID = :demandNameID"),
    @NamedQuery(name = "Demands.findByDemandsResume", query = "SELECT d FROM Demands d WHERE d.demandsResume = :demandsResume"),
    @NamedQuery(name = "Demands.findByDirectorID", query = "SELECT d FROM Demands d WHERE d.directorID = :directorID"),
    @NamedQuery(name = "Demands.findByDirectorName", query = "SELECT d FROM Demands d WHERE d.directorName = :directorName"),
    @NamedQuery(name = "Demands.findByDirectorDeptID", query = "SELECT d FROM Demands d WHERE d.directorDeptID = :directorDeptID"),
    @NamedQuery(name = "Demands.findByDirectorDeptName", query = "SELECT d FROM Demands d WHERE d.directorDeptName = :directorDeptName"),
    @NamedQuery(name = "Demands.findByFormdate", query = "SELECT d FROM Demands d WHERE d.formdate = :formdate"),
    @NamedQuery(name = "Demands.findByFormid", query = "SELECT d FROM Demands d WHERE d.formid = :formid"),
    @NamedQuery(name = "Demands.findByModulName", query = "SELECT d FROM Demands d WHERE d.modulName = :modulName"),
    @NamedQuery(name = "Demands.findByOid", query = "SELECT d FROM Demands d WHERE d.oid = :oid"),
    @NamedQuery(name = "Demands.findByOptdate", query = "SELECT d FROM Demands d WHERE d.optdate = :optdate"),
    @NamedQuery(name = "Demands.findByOptuser", query = "SELECT d FROM Demands d WHERE d.optuser = :optuser"),
    @NamedQuery(name = "Demands.findByPlanEndDate", query = "SELECT d FROM Demands d WHERE d.planEndDate = :planEndDate"),
    @NamedQuery(name = "Demands.findByPlanStartDate", query = "SELECT d FROM Demands d WHERE d.planStartDate = :planStartDate"),
    @NamedQuery(name = "Demands.findByProcedureName", query = "SELECT d FROM Demands d WHERE d.procedureName = :procedureName"),
    @NamedQuery(name = "Demands.findByRealOverDate", query = "SELECT d FROM Demands d WHERE d.realOverDate = :realOverDate"),
    @NamedQuery(name = "Demands.findByRealStartDate", query = "SELECT d FROM Demands d WHERE d.realStartDate = :realStartDate"),
    @NamedQuery(name = "Demands.findByStatus", query = "SELECT d FROM Demands d WHERE d.status = :status"),
    @NamedQuery(name = "Demands.findBySystemName", query = "SELECT d FROM Demands d WHERE d.systemName = :systemName"),
    @NamedQuery(name = "Demands.findByWriteDate", query = "SELECT d FROM Demands d WHERE d.writeDate = :writeDate"),
    @NamedQuery(name = "Demands.findByWriterID", query = "SELECT d FROM Demands d WHERE d.writerID = :writerID"),
    @NamedQuery(name = "Demands.findByWriterName", query = "SELECT d FROM Demands d WHERE d.writerName = :writerName"),
    @NamedQuery(name = "Demands.findById", query = "SELECT d FROM Demands d WHERE d.id = :id")})
public class Demands implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "appendix")
    private String appendix;
    @Column(name = "cfmdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cfmdate;
    @Size(max = 255)
    @Column(name = "cfmuser")
    private String cfmuser;
    @Size(max = 255)
    @Column(name = "creator")
    private String creator;
    @Column(name = "credate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date credate;
    @Size(max = 255)
    @Column(name = "demandContent")
    private String demandContent;
    @Column(name = "demandDate")
    @Temporal(TemporalType.DATE)
    private Date demandDate;
    @Size(max = 255)
    @Column(name = "demandDeptName")
    private String demandDeptName;
    @Size(max = 255)
    @Column(name = "demandDeptno")
    private String demandDeptno;
    @Size(max = 255)
    @Column(name = "demandName")
    private String demandName;
    @Size(max = 255)
    @Column(name = "demandNameID")
    private String demandNameID;
    @Size(max = 255)
    @Column(name = "demandsResume")
    private String demandsResume;
    @Size(max = 255)
    @Column(name = "directorID")
    private String directorID;
    @Size(max = 255)
    @Column(name = "directorName")
    private String directorName;
    @Size(max = 10)
    @Column(name = "directorDeptID")
    private String directorDeptID;
    @Size(max = 10)
    @Column(name = "directorDeptName")
    private String directorDeptName;
    @Column(name = "formdate")
    @Temporal(TemporalType.DATE)
    private Date formdate;
    @Size(max = 255)
    @Column(name = "formid")
    private String formid;
    @Size(max = 255)
    @Column(name = "modulName")
    private String modulName;
    @Size(max = 255)
    @Column(name = "oid")
    private String oid;
    @Column(name = "optdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date optdate;
    @Size(max = 255)
    @Column(name = "optuser")
    private String optuser;
    @Column(name = "planEndDate")
    @Temporal(TemporalType.DATE)
    private Date planEndDate;
    @Column(name = "planStartDate")
    @Temporal(TemporalType.DATE)
    private Date planStartDate;
    @Size(max = 255)
    @Column(name = "procedureName")
    private String procedureName;
    @Column(name = "realOverDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date realOverDate;
    @Column(name = "realStartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date realStartDate;
    @Size(max = 255)
    @Column(name = "status")
    private String status;
    @Size(max = 255)
    @Column(name = "systemName")
    private String systemName;
    @Column(name = "writeDate")
    @Temporal(TemporalType.DATE)
    private Date writeDate;
    @Size(max = 255)
    @Column(name = "writerID")
    private String writerID;
    @Size(max = 255)
    @Column(name = "writerName")
    private String writerName;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public Demands() {
    }

    public Demands(Integer id) {
        this.id = id;
    }

    public String getAppendix() {
        return appendix;
    }

    public void setAppendix(String appendix) {
        this.appendix = appendix;
    }

    public Date getCfmdate() {
        return cfmdate;
    }

    public void setCfmdate(Date cfmdate) {
        this.cfmdate = cfmdate;
    }

    public String getCfmuser() {
        return cfmuser;
    }

    public void setCfmuser(String cfmuser) {
        this.cfmuser = cfmuser;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCredate() {
        return credate;
    }

    public void setCredate(Date credate) {
        this.credate = credate;
    }

    public String getDemandContent() {
        return demandContent;
    }

    public void setDemandContent(String demandContent) {
        this.demandContent = demandContent;
    }

    public Date getDemandDate() {
        return demandDate;
    }

    public void setDemandDate(Date demandDate) {
        this.demandDate = demandDate;
    }

    public String getDemandDeptName() {
        return demandDeptName;
    }

    public void setDemandDeptName(String demandDeptName) {
        this.demandDeptName = demandDeptName;
    }

    public String getDemandDeptno() {
        return demandDeptno;
    }

    public void setDemandDeptno(String demandDeptno) {
        this.demandDeptno = demandDeptno;
    }

    public String getDemandName() {
        return demandName;
    }

    public void setDemandName(String demandName) {
        this.demandName = demandName;
    }

    public String getDemandNameID() {
        return demandNameID;
    }

    public void setDemandNameID(String demandNameID) {
        this.demandNameID = demandNameID;
    }

    public String getDemandsResume() {
        return demandsResume;
    }

    public void setDemandsResume(String demandsResume) {
        this.demandsResume = demandsResume;
    }

    public String getDirectorID() {
        return directorID;
    }

    public void setDirectorID(String directorID) {
        this.directorID = directorID;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getDirectorDeptID() {
        return directorDeptID;
    }

    public void setDirectorDeptID(String directorDeptID) {
        this.directorDeptID = directorDeptID;
    }

    public String getDirectorDeptName() {
        return directorDeptName;
    }

    public void setDirectorDeptName(String directorDeptName) {
        this.directorDeptName = directorDeptName;
    }

    public Date getFormdate() {
        return formdate;
    }

    public void setFormdate(Date formdate) {
        this.formdate = formdate;
    }

    public String getFormid() {
        return formid;
    }

    public void setFormid(String formid) {
        this.formid = formid;
    }

    public String getModulName() {
        return modulName;
    }

    public void setModulName(String modulName) {
        this.modulName = modulName;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Date getOptdate() {
        return optdate;
    }

    public void setOptdate(Date optdate) {
        this.optdate = optdate;
    }

    public String getOptuser() {
        return optuser;
    }

    public void setOptuser(String optuser) {
        this.optuser = optuser;
    }

    public Date getPlanEndDate() {
        return planEndDate;
    }

    public void setPlanEndDate(Date planEndDate) {
        this.planEndDate = planEndDate;
    }

    public Date getPlanStartDate() {
        return planStartDate;
    }

    public void setPlanStartDate(Date planStartDate) {
        this.planStartDate = planStartDate;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public Date getRealOverDate() {
        return realOverDate;
    }

    public void setRealOverDate(Date realOverDate) {
        this.realOverDate = realOverDate;
    }

    public Date getRealStartDate() {
        return realStartDate;
    }

    public void setRealStartDate(Date realStartDate) {
        this.realStartDate = realStartDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public Date getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
    }

    public String getWriterID() {
        return writerID;
    }

    public void setWriterID(String writerID) {
        this.writerID = writerID;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof Demands)) {
            return false;
        }
        Demands other = (Demands) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.Demands[ id=" + id + " ]";
    }
    
}
