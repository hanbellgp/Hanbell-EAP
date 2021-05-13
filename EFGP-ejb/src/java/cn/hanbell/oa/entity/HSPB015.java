/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.entity;

import java.io.Serializable;
import java.util.Date;
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
 * @author C0160
 */
@Entity
@Table(name = "HS_PB015")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HSPB015.findAll", query = "SELECT h FROM HSPB015 h"),
    @NamedQuery(name = "HSPB015.findByPSN", query = "SELECT h FROM HSPB015 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HSPB015.findByFSN", query = "SELECT h FROM HSPB015 h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HSPB015.findByOID", query = "SELECT h FROM HSPB015 h WHERE h.oid = :oid")})
public class HSPB015 implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "otherCost")
    private Double otherCost;
    @Size(max = 255)
    @Column(name = "reason")
    private String reason;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "operatingUser")
    private String operatingUser;
    @Column(name = "materialCost")
    private Double materialCost;
    @Size(max = 255)
    @Column(name = "explanation")
    private String explanation;
    @Size(max = 255)
    @Column(name = "machineName")
    private String machineName;
    @Size(max = 255)
    @Column(name = "maintenanceUser")
    private String maintenanceUser;
    @Size(max = 255)
    @Column(name = "applyUser")
    private String applyUser;
    @Size(max = 255)
    @Column(name = "maintenanceDept")
    private String maintenanceDept;
    @Size(max = 255)
    @Column(name = "applyDept")
    private String applyDept;
    @Size(max = 255)
    @Column(name = "arrivalTime")
    private String arrivalTime;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "happenTime")
    private String happenTime;
    @Size(max = 255)
    @Column(name = "faultContent")
    private String faultContent;
    @Size(max = 255)
    @Column(name = "finishTime")
    private String finishTime;
    @Size(max = 255)
    @Column(name = "machineCode")
    private String machineCode;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Column(name = "arrivalDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrivalDate;
    @Size(max = 255)
    @Column(name = "faultCode")
    private String faultCode;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "applyRemark")
    private String applyRemark;
    @Column(name = "repairTime")
    private Integer repairTime;
    @Size(max = 255)
    @Column(name = "happenAddress")
    private String happenAddress;
    @Column(name = "happenDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date happenDate;
    @Size(max = 255)
    @Column(name = "assigned")
    private String assigned;
    @Column(name = "finishDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finishDate;
    @Size(max = 255)
    @Column(name = "operatingDept")
    private String operatingDept;
    @Column(name = "applyDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date applyDate;
    @Column(name = "manCost")
    private Double manCost;
    @Size(max = 255)
    @Column(name = "maintenance")
    private String maintenance;
    @Column(name = "totalCost")
    private Double totalCost;
    @Size(max = 255)
    @Column(name = "measures")
    private String measures;
    @Size(max = 255)
    @Column(name = "satisfaction")
    private String satisfaction;

    public HSPB015() {
    }

    public HSPB015(String oid) {
        this.oid = oid;
    }

    public Double getOtherCost() {
        return otherCost;
    }

    public void setOtherCost(Double otherCost) {
        this.otherCost = otherCost;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getOperatingUser() {
        return operatingUser;
    }

    public void setOperatingUser(String operatingUser) {
        this.operatingUser = operatingUser;
    }

    public Double getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(Double materialCost) {
        this.materialCost = materialCost;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getMaintenanceUser() {
        return maintenanceUser;
    }

    public void setMaintenanceUser(String maintenanceUser) {
        this.maintenanceUser = maintenanceUser;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getMaintenanceDept() {
        return maintenanceDept;
    }

    public void setMaintenanceDept(String maintenanceDept) {
        this.maintenanceDept = maintenanceDept;
    }

    public String getApplyDept() {
        return applyDept;
    }

    public void setApplyDept(String applyDept) {
        this.applyDept = applyDept;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getHappenTime() {
        return happenTime;
    }

    public void setHappenTime(String happenTime) {
        this.happenTime = happenTime;
    }

    public String getFaultContent() {
        return faultContent;
    }

    public void setFaultContent(String faultContent) {
        this.faultContent = faultContent;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getMachineCode() {
        return machineCode;
    }

    public void setMachineCode(String machineCode) {
        this.machineCode = machineCode;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getFaultCode() {
        return faultCode;
    }

    public void setFaultCode(String faultCode) {
        this.faultCode = faultCode;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getApplyRemark() {
        return applyRemark;
    }

    public void setApplyRemark(String applyRemark) {
        this.applyRemark = applyRemark;
    }

    public Integer getRepairTime() {
        return repairTime;
    }

    public void setRepairTime(Integer repairTime) {
        this.repairTime = repairTime;
    }

    public String getHappenAddress() {
        return happenAddress;
    }

    public void setHappenAddress(String happenAddress) {
        this.happenAddress = happenAddress;
    }

    public Date getHappenDate() {
        return happenDate;
    }

    public void setHappenDate(Date happenDate) {
        this.happenDate = happenDate;
    }

    public String getAssigned() {
        return assigned;
    }

    public void setAssigned(String assigned) {
        this.assigned = assigned;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public String getOperatingDept() {
        return operatingDept;
    }

    public void setOperatingDept(String operatingDept) {
        this.operatingDept = operatingDept;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public Double getManCost() {
        return manCost;
    }

    public void setManCost(Double manCost) {
        this.manCost = manCost;
    }

    public String getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(String maintenance) {
        this.maintenance = maintenance;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public String getMeasures() {
        return measures;
    }

    public void setMeasures(String measures) {
        this.measures = measures;
    }

    public String getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(String satisfaction) {
        this.satisfaction = satisfaction;
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
        if (!(object instanceof HSPB015)) {
            return false;
        }
        HSPB015 other = (HSPB015) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HSPB015[ oid=" + oid + " ]";
    }

}
