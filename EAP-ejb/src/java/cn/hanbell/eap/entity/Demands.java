/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import com.lightshell.comm.FormEntity;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C2082
 */
@Entity
@Table(name = "demands")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Demands.findAll", query = "SELECT d FROM Demands d"),
    @NamedQuery(name = "Demands.findByWriteDate", query = "SELECT d FROM Demands d WHERE d.writeDate = :writeDate"),
    @NamedQuery(name = "Demands.findByOid", query = "SELECT d FROM Demands d WHERE d.oid = :oid"),
    @NamedQuery(name = "Demands.findByDemandsResume", query = "SELECT d FROM Demands d WHERE d.demandsResume = :demandsResume"),
    @NamedQuery(name = "Demands.findByWriterID", query = "SELECT d FROM Demands d WHERE d.writerID = :writerID"),
    @NamedQuery(name = "Demands.findByWriterName", query = "SELECT d FROM Demands d WHERE d.writerName = :writerName"),
    @NamedQuery(name = "Demands.findBySystemName", query = "SELECT d FROM Demands d WHERE d.systemName = :systemName"),
    @NamedQuery(name = "Demands.findByModulName", query = "SELECT d FROM Demands d WHERE d.modulName = :modulName"),
    @NamedQuery(name = "Demands.findByProcedureName", query = "SELECT d FROM Demands d WHERE d.procedureName = :procedureName"),
    @NamedQuery(name = "Demands.findByDemandDeptno", query = "SELECT d FROM Demands d WHERE d.demandDeptno = :demandDeptno"),
    @NamedQuery(name = "Demands.findByDemandNameID", query = "SELECT d FROM Demands d WHERE d.demandNameID = :demandNameID"),
    @NamedQuery(name = "Demands.findByDemandName", query = "SELECT d FROM Demands d WHERE d.demandName = :demandName"),
    @NamedQuery(name = "Demands.findByDemandDate", query = "SELECT d FROM Demands d WHERE d.demandDate = :demandDate"),
    @NamedQuery(name = "Demands.findByAppendix", query = "SELECT d FROM Demands d WHERE d.appendix = :appendix"),
    @NamedQuery(name = "Demands.findByDemandContent", query = "SELECT d FROM Demands d WHERE d.demandContent = :demandContent"),
    @NamedQuery(name = "Demands.findByDirectorName", query = "SELECT d FROM Demands d WHERE d.directorName = :directorName"),
    @NamedQuery(name = "Demands.findByDirectorID", query = "SELECT d FROM Demands d WHERE d.directorID = :directorID"),
    @NamedQuery(name = "Demands.findByPlanStartDate", query = "SELECT d FROM Demands d WHERE d.planStartDate = :planStartDate"),
    @NamedQuery(name = "Demands.findByRealStartDate", query = "SELECT d FROM Demands d WHERE d.realStartDate = :realStartDate"),
    @NamedQuery(name = "Demands.findByPlanEndDate", query = "SELECT d FROM Demands d WHERE d.planEndDate = :planEndDate"),
    @NamedQuery(name = "Demands.findByRealOverDate", query = "SELECT d FROM Demands d WHERE d.realOverDate = :realOverDate"),
    @NamedQuery(name = "Demands.findByDemandDeptName", query = "SELECT d FROM Demands d WHERE d.demandDeptName = :demandDeptName")})
public class Demands extends FormEntity implements Serializable {

    private static final long serialVersionUID = 1L;
   
    @Basic(optional = false)
    @NotNull
    @Column(name = "writeDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date writeDate;
    @Size(max = 255)
    @Column(name = "oid")
    private String oid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "demandsResume")
    private String demandsResume;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "writerID")
    private String writerID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "writerName")
    private String writerName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "systemName")
    private String systemName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "modulName")
    private String modulName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "procedureName")
    private String procedureName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "demandDeptno")
    private String demandDeptno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "demandNameID")
    private String demandNameID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "demandName")
    private String demandName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "demandDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date demandDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "appendix")
    private String appendix;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "demandContent")
    private String demandContent;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "directorName")
    private String directorName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "directorID")
    private String directorID;
    @Column(name = "planStartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date planStartDate;
    @Column(name = "realStartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date realStartDate;
    @Column(name = "planEndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date planEndDate;
    @Column(name = "realOverDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date realOverDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "demandDeptName")
    private String demandDeptName;

    public Date getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getDemandsResume() {
        return demandsResume;
    }

    public void setDemandsResume(String demandsResume) {
        this.demandsResume = demandsResume;
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

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getModulName() {
        return modulName;
    }

    public void setModulName(String modulName) {
        this.modulName = modulName;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public String getDemandDeptno() {
        return demandDeptno;
    }

    public void setDemandDeptno(String demandDeptno) {
        this.demandDeptno = demandDeptno;
    }

    public String getDemandNameID() {
        return demandNameID;
    }

    public void setDemandNameID(String demandNameID) {
        this.demandNameID = demandNameID;
    }

    public String getDemandName() {
        return demandName;
    }

    public void setDemandName(String demandName) {
        this.demandName = demandName;
    }

    public Date getDemandDate() {
        return demandDate;
    }

    public void setDemandDate(Date demandDate) {
        this.demandDate = demandDate;
    }

    public String getAppendix() {
        return appendix;
    }

    public void setAppendix(String appendix) {
        this.appendix = appendix;
    }

    public String getDemandContent() {
        return demandContent;
    }

    public void setDemandContent(String demandContent) {
        this.demandContent = demandContent;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getDirectorID() {
        return directorID;
    }

    public void setDirectorID(String directorID) {
        this.directorID = directorID;
    }

    public Date getPlanStartDate() {
        return planStartDate;
    }

    public void setPlanStartDate(Date planStartDate) {
        this.planStartDate = planStartDate;
    }

    public Date getRealStartDate() {
        return realStartDate;
    }

    public void setRealStartDate(Date realStartDate) {
        this.realStartDate = realStartDate;
    }

    public Date getPlanEndDate() {
        return planEndDate;
    }

    public void setPlanEndDate(Date planEndDate) {
        this.planEndDate = planEndDate;
    }

    public Date getRealOverDate() {
        return realOverDate;
    }

    public void setRealOverDate(Date realOverDate) {
        this.realOverDate = realOverDate;
    }

    public String getDemandDeptName() {
        return demandDeptName;
    }

    public void setDemandDeptName(String demandDeptName) {
        this.demandDeptName = demandDeptName;
    }

    @Override
    public String toString() {
        return "Demands{" + "writeDate=" + writeDate + ", oid=" + oid + ", demandsResume=" + demandsResume + ", writerID=" + writerID + ", writerName=" + writerName + ", systemName=" + systemName + ", modulName=" + modulName + ", procedureName=" + procedureName + ", demandDeptno=" + demandDeptno + ", demandNameID=" + demandNameID + ", demandName=" + demandName + ", demandDate=" + demandDate + ", appendix=" + appendix + ", demandContent=" + demandContent + ", directorName=" + directorName + ", directorID=" + directorID + ", planStartDate=" + planStartDate + ", realStartDate=" + realStartDate + ", planEndDate=" + planEndDate + ", realOverDate=" + realOverDate + ", demandDeptName=" + demandDeptName + '}';
    }    
}
