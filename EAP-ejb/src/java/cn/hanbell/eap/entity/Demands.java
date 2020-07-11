/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import com.lightshell.comm.FormEntity;
import java.util.Date;
import javax.persistence.Column;
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
 * @author C1749
 */
@Entity
@Table(name = "demands")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Demands.findAll", query = "SELECT d FROM Demands d"),
    @NamedQuery(name = "Demands.findById", query = "SELECT d FROM Demands d WHERE d.id = :id"),
    @NamedQuery(name = "Demands.findByFormid", query = "SELECT d FROM Demands d WHERE d.formid = :formid"),
    @NamedQuery(name = "Demands.findByFormdate", query = "SELECT d FROM Demands d WHERE d.formdate = :formdate"),
    @NamedQuery(name = "Demands.findBySystemName", query = "SELECT d FROM Demands d WHERE d.systemName = :systemName"),
    @NamedQuery(name = "Demands.findByModuleName", query = "SELECT d FROM Demands d WHERE d.moduleName = :moduleName"),
    @NamedQuery(name = "Demands.findByProcedureName", query = "SELECT d FROM Demands d WHERE d.procedureName = :procedureName"),
    @NamedQuery(name = "Demands.findByDemandResume", query = "SELECT d FROM Demands d WHERE d.demandResume = :demandResume"),
    @NamedQuery(name = "Demands.findByDemandDate", query = "SELECT d FROM Demands d WHERE d.demandDate = :demandDate"),
    @NamedQuery(name = "Demands.findByDemanderID", query = "SELECT d FROM Demands d WHERE d.demanderID = :demanderID"),
    @NamedQuery(name = "Demands.findByDemanderName", query = "SELECT d FROM Demands d WHERE d.demanderName = :demanderName"),
    @NamedQuery(name = "Demands.findByDemanderDeptID", query = "SELECT d FROM Demands d WHERE d.demanderDeptID = :demanderDeptID"),
    @NamedQuery(name = "Demands.findByDemanderDeptName", query = "SELECT d FROM Demands d WHERE d.demanderDeptName = :demanderDeptName"),
    @NamedQuery(name = "Demands.findByDemandContent", query = "SELECT d FROM Demands d WHERE d.demandContent = :demandContent"),
    @NamedQuery(name = "Demands.findByDirectorID", query = "SELECT d FROM Demands d WHERE d.directorID = :directorID"),
    @NamedQuery(name = "Demands.findByDirectorName", query = "SELECT d FROM Demands d WHERE d.directorName = :directorName"),
    @NamedQuery(name = "Demands.findByDirectorDeptID", query = "SELECT d FROM Demands d WHERE d.directorDeptID = :directorDeptID"),
    @NamedQuery(name = "Demands.findByDirectorDeptName", query = "SELECT d FROM Demands d WHERE d.directorDeptName = :directorDeptName"),
    @NamedQuery(name = "Demands.findByPlanStartDate", query = "SELECT d FROM Demands d WHERE d.planStartDate = :planStartDate"),
    @NamedQuery(name = "Demands.findByPlanOverDate", query = "SELECT d FROM Demands d WHERE d.planOverDate = :planOverDate"),
    @NamedQuery(name = "Demands.findByRealStartDate", query = "SELECT d FROM Demands d WHERE d.realStartDate = :realStartDate"),
    @NamedQuery(name = "Demands.findByRealOverDate", query = "SELECT d FROM Demands d WHERE d.realOverDate = :realOverDate"),
    @NamedQuery(name = "Demands.findByWriterID", query = "SELECT d FROM Demands d WHERE d.writerID = :writerID"),
    @NamedQuery(name = "Demands.findByWriterName", query = "SELECT d FROM Demands d WHERE d.writerName = :writerName"),
    @NamedQuery(name = "Demands.findByWriteDate", query = "SELECT d FROM Demands d WHERE d.writeDate = :writeDate"),
    @NamedQuery(name = "Demands.findByAppendix", query = "SELECT d FROM Demands d WHERE d.appendix = :appendix"),
    @NamedQuery(name = "Demands.findByOID", query = "SELECT d FROM Demands d WHERE d.oid = :oid"),
    @NamedQuery(name = "Demands.findByStatus", query = "SELECT d FROM Demands d WHERE d.status = :status"),
    @NamedQuery(name = "Demands.findByCreator", query = "SELECT d FROM Demands d WHERE d.creator = :creator"),
    @NamedQuery(name = "Demands.findByCredate", query = "SELECT d FROM Demands d WHERE d.credate = :credate"),
    @NamedQuery(name = "Demands.findByOptuser", query = "SELECT d FROM Demands d WHERE d.optuser = :optuser"),
    @NamedQuery(name = "Demands.findByOptdate", query = "SELECT d FROM Demands d WHERE d.optdate = :optdate"),
    @NamedQuery(name = "Demands.findByCfmuser", query = "SELECT d FROM Demands d WHERE d.cfmuser = :cfmuser"),
    @NamedQuery(name = "Demands.findByCfmdate", query = "SELECT d FROM Demands d WHERE d.cfmdate = :cfmdate"),
    @NamedQuery(name = "Demands.findByEmergencyDegree", query = "SELECT d FROM Demands d WHERE d.emergencyDegree = :emergencyDegree")})
public class Demands extends FormEntity {

    @Size(max = 255)
    @Column(name = "systemName")
    private String systemName;
    @Size(max = 255)
    @Column(name = "moduleName")
    private String moduleName;
    @Size(max = 255)
    @Column(name = "procedureName")
    private String procedureName;
    @Size(max = 45)
    @Column(name = "demandResume")
    private String demandResume;
    @Column(name = "demandDate")
    @Temporal(TemporalType.DATE)
    private Date demandDate;
    @Size(max = 255)
    @Column(name = "demanderID")
    private String demanderID;
    @Size(max = 255)
    @Column(name = "demanderName")
    private String demanderName;
    @Size(max = 255)
    @Column(name = "demanderDeptID")
    private String demanderDeptID;
    @Size(max = 255)
    @Column(name = "demanderDeptName")
    private String demanderDeptName;
    @Size(max = 400)
    @Column(name = "demandContent")
    private String demandContent;
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
    @Column(name = "planStartDate")
    @Temporal(TemporalType.DATE)
    private Date planStartDate;
    @Column(name = "planOverDate")
    @Temporal(TemporalType.DATE)
    private Date planOverDate;
    @Column(name = "realStartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date realStartDate;
    @Column(name = "realOverDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date realOverDate;
    @Size(max = 255)
    @Column(name = "writerID")
    private String writerID;
    @Size(max = 255)
    @Column(name = "writerName")
    private String writerName;
    @Column(name = "writeDate")
    @Temporal(TemporalType.DATE)
    private Date writeDate;
    @Size(max = 255)
    @Column(name = "appendix")
    private String appendix;
    @Size(max = 255)
    @Column(name = "oid")
    private String oid;
    @Size(max = 5)
    @Column(name = "emergencyDegree")
    private String emergencyDegree;

    public Demands() {
    }

    public Demands(Integer id) {
        this.id = id;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public String getDemandResume() {
        return demandResume;
    }

    public void setDemandResume(String demandResume) {
        this.demandResume = demandResume;
    }

    public Date getDemandDate() {
        return demandDate;
    }

    public void setDemandDate(Date demandDate) {
        this.demandDate = demandDate;
    }

    public String getDemanderID() {
        return demanderID;
    }

    public void setDemanderID(String demanderID) {
        this.demanderID = demanderID;
    }

    public String getDemanderName() {
        return demanderName;
    }

    public void setDemanderName(String demanderName) {
        this.demanderName = demanderName;
    }

    public String getDemanderDeptID() {
        return demanderDeptID;
    }

    public void setDemanderDeptID(String demanderDeptID) {
        this.demanderDeptID = demanderDeptID;
    }

    public String getDemanderDeptName() {
        return demanderDeptName;
    }

    public void setDemanderDeptName(String demanderDeptName) {
        this.demanderDeptName = demanderDeptName;
    }

    public String getDemandContent() {
        return demandContent;
    }

    public void setDemandContent(String demandContent) {
        this.demandContent = demandContent;
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

    public Date getPlanStartDate() {
        return planStartDate;
    }

    public void setPlanStartDate(Date planStartDate) {
        this.planStartDate = planStartDate;
    }

    public Date getPlanOverDate() {
        return planOverDate;
    }

    public void setPlanOverDate(Date planOverDate) {
        this.planOverDate = planOverDate;
    }

    public Date getRealStartDate() {
        return realStartDate;
    }

    public void setRealStartDate(Date realStartDate) {
        this.realStartDate = realStartDate;
    }

    public Date getRealOverDate() {
        return realOverDate;
    }

    public void setRealOverDate(Date realOverDate) {
        this.realOverDate = realOverDate;
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

    public Date getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
    }

    public String getAppendix() {
        return appendix;
    }

    public void setAppendix(String appendix) {
        this.appendix = appendix;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getEmergencyDegree() {
        return emergencyDegree;
    }

    public void setEmergencyDegree(String emergencyDegree) {
        this.emergencyDegree = emergencyDegree;
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
