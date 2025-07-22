/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.entity;

import cn.hanbell.oa.ejb.WorkFlowBean;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ZQ001")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ZQ001.findAll", query = "SELECT z FROM ZQ001 z"),
    @NamedQuery(name = "ZQ001.findByFacno", query = "SELECT z FROM ZQ001 z WHERE z.facno = :facno"),
    @NamedQuery(name = "ZQ001.findByReceptionStaff", query = "SELECT z FROM ZQ001 z WHERE z.receptionStaff = :receptionStaff"),
    @NamedQuery(name = "ZQ001.findByPSN", query = "SELECT z FROM ZQ001 z WHERE z.processSerialNumber = :psn"),
    @NamedQuery(name = "ZQ001.findByAddress1", query = "SELECT z FROM ZQ001 z WHERE z.address1 = :address1"),
    @NamedQuery(name = "ZQ001.findByEstablishmentUser", query = "SELECT z FROM ZQ001 z WHERE z.establishmentUser = :establishmentUser"),
    @NamedQuery(name = "ZQ001.findByOid", query = "SELECT z FROM ZQ001 z WHERE z.oid = :oid"),
    @NamedQuery(name = "ZQ001.findByResearchMethod", query = "SELECT z FROM ZQ001 z WHERE z.researchMethod = :researchMethod"),
    @NamedQuery(name = "ZQ001.findByApplyUser", query = "SELECT z FROM ZQ001 z WHERE z.applyUser = :applyUser"),
    @NamedQuery(name = "ZQ001.findByInstitution", query = "SELECT z FROM ZQ001 z WHERE z.institution = :institution"),
    @NamedQuery(name = "ZQ001.findByApplyDept", query = "SELECT z FROM ZQ001 z WHERE z.applyDept = :applyDept"),
    @NamedQuery(name = "ZQ001.findBySerialNumber", query = "SELECT z FROM ZQ001 z WHERE z.serialNumber = :serialNumber"),
    @NamedQuery(name = "ZQ001.findByOtherMethod", query = "SELECT z FROM ZQ001 z WHERE z.otherMethod = :otherMethod"),
    @NamedQuery(name = "ZQ001.findByFileno", query = "SELECT z FROM ZQ001 z WHERE z.fileno = :fileno"),
    @NamedQuery(name = "ZQ001.findByResearchTime", query = "SELECT z FROM ZQ001 z WHERE z.researchTime = :researchTime"),
    @NamedQuery(name = "ZQ001.findByFSN", query = "SELECT z FROM ZQ001 z WHERE z.formSerialNumber = :fsn"),
    @NamedQuery(name = "ZQ001.findByApplyDate", query = "SELECT z FROM ZQ001 z WHERE z.applyDate = :applyDate"),
    @NamedQuery(name = "ZQ001.findByRemark", query = "SELECT z FROM ZQ001 z WHERE z.remark = :remark")})
public class ZQ001 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 4000)
    @Column(name = "receptionStaff")
    private String receptionStaff;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "address1")
    private String address1;
    @Size(max = 255)
    @Column(name = "establishmentUser")
    private String establishmentUser;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "researchMethod")
    private String researchMethod;
    @Size(max = 255)
    @Column(name = "applyUser")
    private String applyUser;
    @Size(max = 4000)
    @Column(name = "institution")
    private String institution;
    @Size(max = 255)
    @Column(name = "applyDept")
    private String applyDept;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "otherMethod")
    private String otherMethod;
    @Size(max = 255)
    @Column(name = "fileno")
    private String fileno;
    @Size(max = 255)
    @Column(name = "researchTime")
    private String researchTime;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Column(name = "applyDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date applyDate;
    @Size(max = 4000)
    @Column(name = "remark")
    private String remark;
    
       //申请人
    @JoinColumn(name = "applyUser", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private Users user;

           //申请人
    @JoinColumn(name = "establishmentUser", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private Users user2;
    //申请部门
    @JoinColumn(name = "applyDept", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private OrganizationUnit dept;

    public ZQ001() {
    }

    public ZQ001(String oid) {
        this.oid = oid;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getReceptionStaff() {
        return receptionStaff;
    }

    public void setReceptionStaff(String receptionStaff) {
        this.receptionStaff = receptionStaff;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getEstablishmentUser() {
        return establishmentUser;
    }

    public void setEstablishmentUser(String establishmentUser) {
        this.establishmentUser = establishmentUser;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getResearchMethod() {
        return researchMethod;
    }

    public void setResearchMethod(String researchMethod) {
        this.researchMethod = researchMethod;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getApplyDept() {
        return applyDept;
    }

    public void setApplyDept(String applyDept) {
        this.applyDept = applyDept;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getOtherMethod() {
        return otherMethod;
    }

    public void setOtherMethod(String otherMethod) {
        this.otherMethod = otherMethod;
    }

    public String getFileno() {
        return fileno;
    }

    public void setFileno(String fileno) {
        this.fileno = fileno;
    }

    public String getResearchTime() {
        return researchTime;
    }

    public void setResearchTime(String researchTime) {
        this.researchTime = researchTime;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    public String getCompanyName() {
        WorkFlowBean WorkFlowBean = new WorkFlowBean();
        return WorkFlowBean.getCompanyName(this.facno);
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public OrganizationUnit getDept() {
        return dept;
    }

    public void setDept(OrganizationUnit dept) {
        this.dept = dept;
    }

    public Users getUser2() {
        return user2;
    }

    public void setUser2(Users user2) {
        this.user2 = user2;
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
        if (!(object instanceof ZQ001)) {
            return false;
        }
        ZQ001 other = (ZQ001) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.ZQ001[ oid=" + oid + " ]";
    }
    
}
