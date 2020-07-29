/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import com.lightshell.comm.SuperEntity;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author C0160
 */
@Entity
@Table(name = "task")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Task.getRowCountByExecutorIdAndActualFinishDate", query = "SELECT COUNT(j) FROM Task j WHERE j.status = 'V' AND j.executorId = :executorId AND j.actualFinishDate >= :actualFinishDate"),
    @NamedQuery(name = "Task.getRowCountByExecutorIdAndPlannedStartDate", query = "SELECT COUNT(j) FROM Task j WHERE j.status = 'N' AND j.executorId = :executorId AND j.plannedStartDate <= :plannedStartDate"),
    @NamedQuery(name = "Task.getRowCountByExecutorIdAndStatus", query = "SELECT COUNT(j) FROM Task j WHERE j.executorId = :executorId AND j.status =:status"),
    @NamedQuery(name = "Task.getRowCountByExecutorIdAndYear", query = "SELECT COUNT(j) FROM Task j WHERE j.status = 'V' AND j.executorId = :executorId AND FUNC('YEAR',j.actualFinishDate) = :y"),
    @NamedQuery(name = "Task.getRowCountByExecutorIdYearAndMonth", query = "SELECT COUNT(j) FROM Task j WHERE j.status = 'V' AND j.executorId = :executorId AND FUNC('YEAR',j.actualFinishDate) = :y AND FUNC('MONTH',j.actualFinishDate) = :m"),
    @NamedQuery(name = "Task.getRowCountByExecutorsAndActualFinishDate", query = "SELECT COUNT(j) FROM Task j WHERE j.status = 'V' AND j.executorId IN :executors AND j.actualFinishDate >= :actualFinishDate"),
    @NamedQuery(name = "Task.getRowCountByExecutorsAndPlannedStartDate", query = "SELECT COUNT(j) FROM Task j WHERE j.status = 'N' AND j.executorId IN :executors AND j.plannedStartDate <= :plannedStartDate"),
    @NamedQuery(name = "Task.getRowCountByExecutorsAndStatus", query = "SELECT COUNT(j) FROM Task j WHERE j.executorId IN :executors AND j.status =:status"),
    @NamedQuery(name = "Task.getRowCountByExecutorsAndYear", query = "SELECT COUNT(j) FROM Task j WHERE j.status = 'V' AND j.executorId IN :executors AND FUNC('YEAR',j.actualFinishDate) = :y"),
    @NamedQuery(name = "Task.getRowCountByExecutorsYearAndMonth", query = "SELECT COUNT(j) FROM Task j WHERE j.status = 'V' AND j.executorId IN :executors AND FUNC('YEAR',j.actualFinishDate) = :y AND FUNC('MONTH',j.actualFinishDate) = :m"),
    @NamedQuery(name = "Task.findAll", query = "SELECT j FROM Task j"),
    @NamedQuery(name = "Task.findById", query = "SELECT j FROM Task j WHERE j.id = :id"),
    @NamedQuery(name = "Task.findByName", query = "SELECT j FROM Task j WHERE j.name = :name"),
    @NamedQuery(name = "Task.findByExecutorId", query = "SELECT j FROM Task j WHERE j.executorId = :executorId"),
    @NamedQuery(name = "Task.findByExecutorIdAndActualFinishDate", query = "SELECT j FROM Task j WHERE j.status = 'V' AND j.executorId = :executorId AND j.actualFinishDate >= :actualFinishDate ORDER BY j.actualFinishDate,j.priority"),
    @NamedQuery(name = "Task.findByExecutorIdAndPlannedStartDate", query = "SELECT j FROM Task j WHERE j.status = 'N' AND j.executorId = :executorId AND j.plannedStartDate <= :plannedStartDate ORDER BY j.plannedStartDate,j.priority"),
    @NamedQuery(name = "Task.findByExecutorIdAndStatus", query = "SELECT j FROM Task j WHERE j.status =:status AND j.executorId = :executorId ORDER BY j.plannedStartDate,j.priority"),
    @NamedQuery(name = "Task.findByExecutorsAndActualFinishDate", query = "SELECT j FROM Task j WHERE j.status = 'V' AND j.executorId IN :executors AND j.actualFinishDate >= :actualFinishDate ORDER BY j.actualFinishDate,j.priority"),
    @NamedQuery(name = "Task.findByExecutorsAndPlannedStartDate", query = "SELECT j FROM Task j WHERE j.status = 'N' AND j.executorId IN :executors AND j.plannedStartDate <= :plannedStartDate ORDER BY j.plannedStartDate,j.priority"),
    @NamedQuery(name = "Task.findByExecutorsAndStatus", query = "SELECT j FROM Task j WHERE j.status = :status AND j.executorId IN :executors ORDER BY j.plannedStartDate,j.priority"),
    @NamedQuery(name = "Task.findByPriority", query = "SELECT j FROM Task j WHERE j.priority = :priority"),
    @NamedQuery(name = "Task.findByContextId", query = "SELECT j FROM Task j WHERE j.contextId = :contextId"),
    @NamedQuery(name = "Task.findByStatus", query = "SELECT j FROM Task j WHERE j.status = :status")})
public class Task extends SuperEntity {

    @Size(max = 45)
    @Column(name = "contextObject")
    private String contextObject;
    @Column(name = "contextId")
    private Integer contextId;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 400)
    @Column(name = "description")
    private String description;
    @Size(max = 20)
    @Column(name = "executorId")
    private String executorId;
    @Size(max = 45)
    @Column(name = "executor")
    private String executor;
    @Size(max = 20)
    @Column(name = "deptId")
    private String deptId;
    @Size(max = 45)
    @Column(name = "dept")
    private String dept;
    @Basic(optional = false)
    @NotNull
    @Column(name = "plannedStartDate")
    @Temporal(TemporalType.DATE)
    private Date plannedStartDate;
    @Column(name = "plannedStartTime")
    @Temporal(TemporalType.TIME)
    private Date plannedStartTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "plannedFinishDate")
    @Temporal(TemporalType.DATE)
    private Date plannedFinishDate;
    @Column(name = "plannedFinishTime")
    @Temporal(TemporalType.TIME)
    private Date plannedFinishTime;
    @Column(name = "actualStartDate")
    @Temporal(TemporalType.DATE)
    private Date actualStartDate;
    @Column(name = "actualStartTime")
    @Temporal(TemporalType.TIME)
    private Date actualStartTime;
    @Column(name = "actualFinishDate")
    @Temporal(TemporalType.DATE)
    private Date actualFinishDate;
    @Column(name = "actualFinishTime")
    @Temporal(TemporalType.TIME)
    private Date actualFinishTime;
    @Size(max = 2)
    @Column(name = "priority")
    private String priority;
    @Size(max = 2)
    @Column(name = "lvl")
    private String lvl;
    @Column(name = "sortid")
    private Integer sortid;
    @Column(name = "progress")
    private Integer progress;
    @Size(max = 300)
    @Column(name = "location")
    private String location;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
    @Column(name = "accuracy")
    private Integer accuracy;

    public Task() {
        this.sortid = 0;
        this.progress = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExecutorId() {
        return executorId;
    }

    public void setExecutorId(String executorId) {
        this.executorId = executorId;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    /**
     * @return the deptId
     */
    public String getDeptId() {
        return deptId;
    }

    /**
     * @param deptId the deptId to set
     */
    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    /**
     * @return the dept
     */
    public String getDept() {
        return dept;
    }

    /**
     * @param dept the dept to set
     */
    public void setDept(String dept) {
        this.dept = dept;
    }

    public Date getPlannedStartDate() {
        return plannedStartDate;
    }

    public void setPlannedStartDate(Date plannedStartDate) {
        this.plannedStartDate = plannedStartDate;
    }

    public Date getPlannedStartTime() {
        return plannedStartTime;
    }

    public void setPlannedStartTime(Date plannedStartTime) {
        this.plannedStartTime = plannedStartTime;
    }

    public Date getPlannedFinishDate() {
        return plannedFinishDate;
    }

    public void setPlannedFinishDate(Date plannedFinishDate) {
        this.plannedFinishDate = plannedFinishDate;
    }

    public Date getPlannedFinishTime() {
        return plannedFinishTime;
    }

    public void setPlannedFinishTime(Date plannedFinishTime) {
        this.plannedFinishTime = plannedFinishTime;
    }

    public Date getActualStartDate() {
        return actualStartDate;
    }

    public void setActualStartDate(Date actualStartDate) {
        this.actualStartDate = actualStartDate;
    }

    public Date getActualStartTime() {
        return actualStartTime;
    }

    public void setActualStartTime(Date actualStartTime) {
        this.actualStartTime = actualStartTime;
    }

    public Date getActualFinishDate() {
        return actualFinishDate;
    }

    public void setActualFinishDate(Date actualFinishDate) {
        this.actualFinishDate = actualFinishDate;
    }

    public Date getActualFinishTime() {
        return actualFinishTime;
    }

    public void setActualFinishTime(Date actualFinishTime) {
        this.actualFinishTime = actualFinishTime;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getLvl() {
        return lvl;
    }

    public void setLvl(String lvl) {
        this.lvl = lvl;
    }

    public Integer getSortid() {
        return sortid;
    }

    public void setSortid(Integer sortid) {
        this.sortid = sortid;
    }

    /**
     * @return the progress
     */
    public Integer getProgress() {
        return progress;
    }

    /**
     * @param progress the progress to set
     */
    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Integer accuracy) {
        this.accuracy = accuracy;
    }

    /**
     * @return the contextObject
     */
    public String getContextObject() {
        return contextObject;
    }

    /**
     * @param contextObject the contextObject to set
     */
    public void setContextObject(String contextObject) {
        this.contextObject = contextObject;
    }

    /**
     * @return the contextId
     */
    public Integer getContextId() {
        return contextId;
    }

    /**
     * @param contextId the contextId to set
     */
    public void setContextId(Integer contextId) {
        this.contextId = contextId;
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
        if (!(object instanceof Task)) {
            return false;
        }
        Task other = (Task) object;
        if (this.id != null && other.id != null) {
            return this.id.equals(other.id);
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.Task[ id=" + id + " ]";
    }

}
