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
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
@Table(name = "HZ_CW035")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HZCW035.findAll", query = "SELECT h FROM HZCW035 h"),
    @NamedQuery(name = "HZCW035.findBySubprojectno", query = "SELECT h FROM HZCW035 h WHERE h.subprojectno = :subprojectno"),
    @NamedQuery(name = "HZCW035.findByCenterid", query = "SELECT h FROM HZCW035 h WHERE h.centerid = :centerid"),
    @NamedQuery(name = "HZCW035.findByFacno", query = "SELECT h FROM HZCW035 h WHERE h.facno = :facno"),
    @NamedQuery(name = "HZCW035.findByEndDate", query = "SELECT h FROM HZCW035 h WHERE h.endDate = :endDate"),
    @NamedQuery(name = "HZCW035.findByPSN", query = "SELECT h FROM HZCW035 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HZCW035.findByRemark", query = "SELECT h FROM HZCW035 h WHERE h.remark = :remark"),
    @NamedQuery(name = "HZCW035.findByApplyUser", query = "SELECT h FROM HZCW035 h WHERE h.applyUser = :applyUser"),
    @NamedQuery(name = "HZCW035.findByApplyDept", query = "SELECT h FROM HZCW035 h WHERE h.applyDept = :applyDept"),
    @NamedQuery(name = "HZCW035.findByPrice", query = "SELECT h FROM HZCW035 h WHERE h.price = :price"),
    @NamedQuery(name = "HZCW035.findByFSN", query = "SELECT h FROM HZCW035 h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HZCW035.findByBossview", query = "SELECT h FROM HZCW035 h WHERE h.bossview = :bossview"),
    @NamedQuery(name = "HZCW035.findByAmount", query = "SELECT h FROM HZCW035 h WHERE h.amount = :amount"),
    @NamedQuery(name = "HZCW035.findByApplyreason", query = "SELECT h FROM HZCW035 h WHERE h.applyreason = :applyreason"),
    @NamedQuery(name = "HZCW035.findByProjectname", query = "SELECT h FROM HZCW035 h WHERE h.projectname = :projectname"),
    @NamedQuery(name = "HZCW035.findByFinanceview", query = "SELECT h FROM HZCW035 h WHERE h.financeview = :financeview"),
    @NamedQuery(name = "HZCW035.findByTotalqty", query = "SELECT h FROM HZCW035 h WHERE h.totalqty = :totalqty"),
    @NamedQuery(name = "HZCW035.findByOID", query = "SELECT h FROM HZCW035 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HZCW035.findByCentername", query = "SELECT h FROM HZCW035 h WHERE h.centername = :centername"),
    @NamedQuery(name = "HZCW035.findBySubprojectname", query = "SELECT h FROM HZCW035 h WHERE h.subprojectname = :subprojectname"),
    @NamedQuery(name = "HZCW035.findByEstimateamount", query = "SELECT h FROM HZCW035 h WHERE h.estimateamount = :estimateamount"),
    @NamedQuery(name = "HZCW035.findByProjectno", query = "SELECT h FROM HZCW035 h WHERE h.projectno = :projectno"),
    @NamedQuery(name = "HZCW035.findBySerialNumber", query = "SELECT h FROM HZCW035 h WHERE h.serialNumber = :serialNumber"),
    @NamedQuery(name = "HZCW035.findByManagerview", query = "SELECT h FROM HZCW035 h WHERE h.managerview = :managerview"),
    @NamedQuery(name = "HZCW035.findByQty", query = "SELECT h FROM HZCW035 h WHERE h.qty = :qty"),
    @NamedQuery(name = "HZCW035.findByApplyDate", query = "SELECT h FROM HZCW035 h WHERE h.applyDate = :applyDate"),
    @NamedQuery(name = "HZCW035.findByStartDate", query = "SELECT h FROM HZCW035 h WHERE h.startDate = :startDate"),
    @NamedQuery(name = "HZCW035.findByHdnmanager", query = "SELECT h FROM HZCW035 h WHERE h.hdnmanager = :hdnmanager"),
    @NamedQuery(name = "HZCW035.findByHdnsamedept", query = "SELECT h FROM HZCW035 h WHERE h.hdnsamedept = :hdnsamedept"),
    @NamedQuery(name = "HZCW035.findByBudgetDept", query = "SELECT h FROM HZCW035 h WHERE h.budgetDept = :budgetDept")})
public class HZCW035 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "subprojectno")
    private String subprojectno;
    @Size(max = 255)
    @Column(name = "centerid")
    private String centerid;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Column(name = "endDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "remark")
    private String remark;
    @Size(max = 255)
    @Column(name = "applyUser")
    private String applyUser;
    @Size(max = 255)
    @Column(name = "applyDept")
    private String applyDept;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Double price;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "bossview")
    private String bossview;
    @Column(name = "amount")
    private Double amount;
    @Size(max = 255)
    @Column(name = "applyreason")
    private String applyreason;
    @Size(max = 255)
    @Column(name = "projectname")
    private String projectname;
    @Size(max = 255)
    @Column(name = "financeview")
    private String financeview;
    @Column(name = "totalqty")
    private Double totalqty;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "centername")
    private String centername;
    @Size(max = 255)
    @Column(name = "subprojectname")
    private String subprojectname;
    @Column(name = "estimateamount")
    private Double estimateamount;
    @Size(max = 255)
    @Column(name = "projectno")
    private String projectno;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "managerview")
    private String managerview;
    @Column(name = "qty")
    private Double qty;
    @Column(name = "applyDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date applyDate;
    @Column(name = "startDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Size(max = 255)
    @Column(name = "hdnmanager")
    private String hdnmanager;
    @Size(max = 255)
    @Column(name = "hdnsamedept")
    private String hdnsamedept;
    @Size(max = 255)
    @Column(name = "budgetDept")
    private String budgetDept;
     //申请人员
    @JoinColumn(name = "applyUser", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = true)
    private Users user;
    //申请部门
    @JoinColumn(name = "applyDept", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = true)
    private OrganizationUnit organizationUnit;
     //流程号
    @JoinColumn(name = "processSerialNumber", referencedColumnName = "serialNumber", insertable = false, updatable = false)
    @OneToOne(optional = true)
    private ProcessInstance processInstance;
    
    public HZCW035() {
    }

    public HZCW035(String oid) {
        this.oid = oid;
    }

    public String getSubprojectno() {
        return subprojectno;
    }

    public void setSubprojectno(String subprojectno) {
        this.subprojectno = subprojectno;
    }

    public String getCenterid() {
        return centerid;
    }

    public void setCenterid(String centerid) {
        this.centerid = centerid;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getApplyDept() {
        return applyDept;
    }

    public void setApplyDept(String applyDept) {
        this.applyDept = applyDept;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getBossview() {
        return bossview;
    }

    public void setBossview(String bossview) {
        this.bossview = bossview;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getApplyreason() {
        return applyreason;
    }

    public void setApplyreason(String applyreason) {
        this.applyreason = applyreason;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getFinanceview() {
        return financeview;
    }

    public void setFinanceview(String financeview) {
        this.financeview = financeview;
    }

    public Double getTotalqty() {
        return totalqty;
    }

    public void setTotalqty(Double totalqty) {
        this.totalqty = totalqty;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getCentername() {
        return centername;
    }

    public void setCentername(String centername) {
        this.centername = centername;
    }

    public String getSubprojectname() {
        return subprojectname;
    }

    public void setSubprojectname(String subprojectname) {
        this.subprojectname = subprojectname;
    }

    public Double getEstimateamount() {
        return estimateamount;
    }

    public void setEstimateamount(Double estimateamount) {
        this.estimateamount = estimateamount;
    }

    public String getProjectno() {
        return projectno;
    }

    public void setProjectno(String projectno) {
        this.projectno = projectno;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getManagerview() {
        return managerview;
    }

    public void setManagerview(String managerview) {
        this.managerview = managerview;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getHdnmanager() {
        return hdnmanager;
    }

    public void setHdnmanager(String hdnmanager) {
        this.hdnmanager = hdnmanager;
    }

    public String getHdnsamedept() {
        return hdnsamedept;
    }

    public void setHdnsamedept(String hdnsamedept) {
        this.hdnsamedept = hdnsamedept;
    }

    public String getBudgetDept() {
        return budgetDept;
    }

    public void setBudgetDept(String budgetDept) {
        this.budgetDept = budgetDept;
    }


    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public OrganizationUnit getOrganizationUnit() {
        return organizationUnit;
    }

    public void setOrganizationUnit(OrganizationUnit organizationUnit) {
        this.organizationUnit = organizationUnit;
    }

    public ProcessInstance getProcessInstance() {
        return processInstance;
    }

    public void setProcessInstance(ProcessInstance processInstance) {
        this.processInstance = processInstance;
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
        if (!(object instanceof HZCW035)) {
            return false;
        }
        HZCW035 other = (HZCW035) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HZCW035[ oid=" + oid + " ]";
    }
    
}
