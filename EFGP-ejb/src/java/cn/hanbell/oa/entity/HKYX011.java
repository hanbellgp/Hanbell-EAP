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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C2082
 */
@Entity
@Table(name = "HK_YX011")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKYX011.findAll", query = "SELECT h FROM HKYX011 h"),
    @NamedQuery(name = "HKYX011.findByHdncustomertype", query = "SELECT h FROM HKYX011 h WHERE h.hdncustomertype = :hdncustomertype"),
    @NamedQuery(name = "HKYX011.findByCapital", query = "SELECT h FROM HKYX011 h WHERE h.capital = :capital"),
    @NamedQuery(name = "HKYX011.findByPSN", query = "SELECT h FROM HKYX011 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKYX011.findBySaleamountTotal", query = "SELECT h FROM HKYX011 h WHERE h.saleamountTotal = :saleamountTotal"),
    @NamedQuery(name = "HKYX011.findByDiscountamount5", query = "SELECT h FROM HKYX011 h WHERE h.discountamount5 = :discountamount5"),
    @NamedQuery(name = "HKYX011.findByDiscountamount3", query = "SELECT h FROM HKYX011 h WHERE h.discountamount3 = :discountamount3"),
    @NamedQuery(name = "HKYX011.findByDiscountamount4", query = "SELECT h FROM HKYX011 h WHERE h.discountamount4 = :discountamount4"),
    @NamedQuery(name = "HKYX011.findByDiscountamount1", query = "SELECT h FROM HKYX011 h WHERE h.discountamount1 = :discountamount1"),
    @NamedQuery(name = "HKYX011.findByDiscountamount2", query = "SELECT h FROM HKYX011 h WHERE h.discountamount2 = :discountamount2"),
    @NamedQuery(name = "HKYX011.findByPrincipal", query = "SELECT h FROM HKYX011 h WHERE h.principal = :principal"),
    @NamedQuery(name = "HKYX011.findByApplyUser", query = "SELECT h FROM HKYX011 h WHERE h.applyUser = :applyUser"),
    @NamedQuery(name = "HKYX011.findByApplyDept", query = "SELECT h FROM HKYX011 h WHERE h.applyDept = :applyDept"),
    @NamedQuery(name = "HKYX011.findByFSN", query = "SELECT h FROM HKYX011 h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKYX011.findBySalesnumber5", query = "SELECT h FROM HKYX011 h WHERE h.salesnumber5 = :salesnumber5"),
    @NamedQuery(name = "HKYX011.findByCustomername", query = "SELECT h FROM HKYX011 h WHERE h.customername = :customername"),
    @NamedQuery(name = "HKYX011.findByCustomerno", query = "SELECT h FROM HKYX011 h WHERE h.customerno = :customerno"),
    @NamedQuery(name = "HKYX011.findByCustomertype", query = "SELECT h FROM HKYX011 h WHERE h.customertype = :customertype"),
    @NamedQuery(name = "HKYX011.findByModel4", query = "SELECT h FROM HKYX011 h WHERE h.model4 = :model4"),
    @NamedQuery(name = "HKYX011.findByModel3", query = "SELECT h FROM HKYX011 h WHERE h.model3 = :model3"),
    @NamedQuery(name = "HKYX011.findByModel2", query = "SELECT h FROM HKYX011 h WHERE h.model2 = :model2"),
    @NamedQuery(name = "HKYX011.findByPeriod", query = "SELECT h FROM HKYX011 h WHERE h.period = :period"),
    @NamedQuery(name = "HKYX011.findByDiscountrate5", query = "SELECT h FROM HKYX011 h WHERE h.discountrate5 = :discountrate5"),
    @NamedQuery(name = "HKYX011.findByModel1", query = "SELECT h FROM HKYX011 h WHERE h.model1 = :model1"),
    @NamedQuery(name = "HKYX011.findByDiscountrate4", query = "SELECT h FROM HKYX011 h WHERE h.discountrate4 = :discountrate4"),
    @NamedQuery(name = "HKYX011.findBySalesnumber3", query = "SELECT h FROM HKYX011 h WHERE h.salesnumber3 = :salesnumber3"),
    @NamedQuery(name = "HKYX011.findByDiscountrate3", query = "SELECT h FROM HKYX011 h WHERE h.discountrate3 = :discountrate3"),
    @NamedQuery(name = "HKYX011.findBySalesnumber4", query = "SELECT h FROM HKYX011 h WHERE h.salesnumber4 = :salesnumber4"),
    @NamedQuery(name = "HKYX011.findByDiscountrate2", query = "SELECT h FROM HKYX011 h WHERE h.discountrate2 = :discountrate2"),
    @NamedQuery(name = "HKYX011.findByHdnapmanager", query = "SELECT h FROM HKYX011 h WHERE h.hdnapmanager = :hdnapmanager"),
    @NamedQuery(name = "HKYX011.findBySalesnumber1", query = "SELECT h FROM HKYX011 h WHERE h.salesnumber1 = :salesnumber1"),
    @NamedQuery(name = "HKYX011.findByDiscountrate1", query = "SELECT h FROM HKYX011 h WHERE h.discountrate1 = :discountrate1"),
    @NamedQuery(name = "HKYX011.findByModel5", query = "SELECT h FROM HKYX011 h WHERE h.model5 = :model5"),
    @NamedQuery(name = "HKYX011.findBySalesnumber2", query = "SELECT h FROM HKYX011 h WHERE h.salesnumber2 = :salesnumber2"),
    @NamedQuery(name = "HKYX011.findBySalesamount3", query = "SELECT h FROM HKYX011 h WHERE h.salesamount3 = :salesamount3"),
    @NamedQuery(name = "HKYX011.findBySalesamount2", query = "SELECT h FROM HKYX011 h WHERE h.salesamount2 = :salesamount2"),
    @NamedQuery(name = "HKYX011.findByRatetotal", query = "SELECT h FROM HKYX011 h WHERE h.ratetotal = :ratetotal"),
    @NamedQuery(name = "HKYX011.findBySalesamount1", query = "SELECT h FROM HKYX011 h WHERE h.salesamount1 = :salesamount1"),
    @NamedQuery(name = "HKYX011.findByOID", query = "SELECT h FROM HKYX011 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKYX011.findByDiscountTotal", query = "SELECT h FROM HKYX011 h WHERE h.discountTotal = :discountTotal"),
    @NamedQuery(name = "HKYX011.findBySalesamount5", query = "SELECT h FROM HKYX011 h WHERE h.salesamount5 = :salesamount5"),
    @NamedQuery(name = "HKYX011.findBySalesamount4", query = "SELECT h FROM HKYX011 h WHERE h.salesamount4 = :salesamount4"),
    @NamedQuery(name = "HKYX011.findByNumbertotal", query = "SELECT h FROM HKYX011 h WHERE h.numbertotal = :numbertotal"),
    @NamedQuery(name = "HKYX011.findByApplyDate", query = "SELECT h FROM HKYX011 h WHERE h.applyDate = :applyDate"),
    @NamedQuery(name = "HKYX011.findByRemark", query = "SELECT h FROM HKYX011 h WHERE h.remark = :remark")})
public class HKYX011 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "hdncustomertype")
    private String hdncustomertype;
    @Size(max = 255)
    @Column(name = "capital")
    private String capital;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "saleamountTotal")
    private Double saleamountTotal;
    @Column(name = "discountamount5")
    private Double discountamount5;
    @Column(name = "discountamount3")
    private Double discountamount3;
    @Column(name = "discountamount4")
    private Double discountamount4;
    @Column(name = "discountamount1")
    private Double discountamount1;
    @Column(name = "discountamount2")
    private Double discountamount2;
    @Size(max = 255)
    @Column(name = "principal")
    private String principal;
    @Size(max = 255)
    @Column(name = "applyUser")
    private String applyUser;
    @Size(max = 255)
    @Column(name = "applyDept")
    private String applyDept;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Column(name = "salesnumber5")
    private Double salesnumber5;
    @Size(max = 255)
    @Column(name = "customername")
    private String customername;
    @Size(max = 255)
    @Column(name = "customerno")
    private String customerno;
    @Size(max = 255)
    @Column(name = "customertype")
    private String customertype;
    @Size(max = 255)
    @Column(name = "model4")
    private String model4;
    @Size(max = 255)
    @Column(name = "model3")
    private String model3;
    @Size(max = 255)
    @Column(name = "model2")
    private String model2;
    @Size(max = 255)
    @Column(name = "period")
    private String period;
    @Column(name = "discountrate5")
    private Double discountrate5;
    @Size(max = 255)
    @Column(name = "model1")
    private String model1;
    @Column(name = "discountrate4")
    private Double discountrate4;
    @Column(name = "salesnumber3")
    private Double salesnumber3;
    @Column(name = "discountrate3")
    private Double discountrate3;
    @Column(name = "salesnumber4")
    private Double salesnumber4;
    @Column(name = "discountrate2")
    private Double discountrate2;
    @Size(max = 255)
    @Column(name = "hdnapmanager")
    private String hdnapmanager;
    @Column(name = "salesnumber1")
    private Double salesnumber1;
    @Column(name = "discountrate1")
    private Double discountrate1;
    @Size(max = 255)
    @Column(name = "model5")
    private String model5;
    @Column(name = "salesnumber2")
    private Double salesnumber2;
    @Column(name = "salesamount3")
    private Double salesamount3;
    @Column(name = "salesamount2")
    private Double salesamount2;
    @Column(name = "ratetotal")
    private Double ratetotal;
    @Column(name = "salesamount1")
    private Double salesamount1;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Column(name = "discountTotal")
    private Double discountTotal;
    @Column(name = "salesamount5")
    private Double salesamount5;
    @Column(name = "salesamount4")
    private Double salesamount4;
    @Column(name = "numbertotal")
    private Double numbertotal;
    @Column(name = "applyDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date applyDate;
    @Size(max = 255)
    @Column(name = "remark")
    private String remark;
    @Size(max = 255)
    @Column(name = "sealfacno")
    private String sealfacno;
    @Size(max = 255)
    @Column(name = "stampCategory")
    private String stampCategory;
    @Size(max = 255)
    @Column(name = "actualDiscountNo")
    private String actualDiscountNo;
    
    @JoinColumn(name = "principal", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private Users user;
    
    //流程号
    @JoinColumn(name = "processSerialNumber", referencedColumnName = "serialNumber", insertable = false, updatable = false)
    @OneToOne(optional = true)
    private ProcessInstance processInstance;
    
     @Transient
     private String deptno;
    
     @Transient
     private String deptname;
     
    public HKYX011() {
    }

    public HKYX011(String oid) {
        this.oid = oid;
    }

    public String getHdncustomertype() {
        return hdncustomertype;
    }

    public void setHdncustomertype(String hdncustomertype) {
        this.hdncustomertype = hdncustomertype;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public Double getSaleamountTotal() {
        return saleamountTotal;
    }

    public void setSaleamountTotal(Double saleamountTotal) {
        this.saleamountTotal = saleamountTotal;
    }

    public Double getDiscountamount5() {
        return discountamount5;
    }

    public void setDiscountamount5(Double discountamount5) {
        this.discountamount5 = discountamount5;
    }

    public Double getDiscountamount3() {
        return discountamount3;
    }

    public void setDiscountamount3(Double discountamount3) {
        this.discountamount3 = discountamount3;
    }

    public Double getDiscountamount4() {
        return discountamount4;
    }

    public void setDiscountamount4(Double discountamount4) {
        this.discountamount4 = discountamount4;
    }

    public Double getDiscountamount1() {
        return discountamount1;
    }

    public void setDiscountamount1(Double discountamount1) {
        this.discountamount1 = discountamount1;
    }

    public Double getDiscountamount2() {
        return discountamount2;
    }

    public void setDiscountamount2(Double discountamount2) {
        this.discountamount2 = discountamount2;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
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

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public Double getSalesnumber5() {
        return salesnumber5;
    }

    public void setSalesnumber5(Double salesnumber5) {
        this.salesnumber5 = salesnumber5;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getCustomerno() {
        return customerno;
    }

    public void setCustomerno(String customerno) {
        this.customerno = customerno;
    }

    public String getCustomertype() {
        return customertype;
    }

    public void setCustomertype(String customertype) {
        this.customertype = customertype;
    }

    public String getModel4() {
        return model4;
    }

    public void setModel4(String model4) {
        this.model4 = model4;
    }

    public String getModel3() {
        return model3;
    }

    public void setModel3(String model3) {
        this.model3 = model3;
    }

    public String getModel2() {
        return model2;
    }

    public void setModel2(String model2) {
        this.model2 = model2;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Double getDiscountrate5() {
        return discountrate5;
    }

    public void setDiscountrate5(Double discountrate5) {
        this.discountrate5 = discountrate5;
    }

    public String getModel1() {
        return model1;
    }

    public void setModel1(String model1) {
        this.model1 = model1;
    }

    public Double getDiscountrate4() {
        return discountrate4;
    }

    public void setDiscountrate4(Double discountrate4) {
        this.discountrate4 = discountrate4;
    }

    public Double getSalesnumber3() {
        return salesnumber3;
    }

    public void setSalesnumber3(Double salesnumber3) {
        this.salesnumber3 = salesnumber3;
    }

    public Double getDiscountrate3() {
        return discountrate3;
    }

    public void setDiscountrate3(Double discountrate3) {
        this.discountrate3 = discountrate3;
    }

    public Double getSalesnumber4() {
        return salesnumber4;
    }

    public void setSalesnumber4(Double salesnumber4) {
        this.salesnumber4 = salesnumber4;
    }

    public Double getDiscountrate2() {
        return discountrate2;
    }

    public void setDiscountrate2(Double discountrate2) {
        this.discountrate2 = discountrate2;
    }

    public String getHdnapmanager() {
        return hdnapmanager;
    }

    public void setHdnapmanager(String hdnapmanager) {
        this.hdnapmanager = hdnapmanager;
    }

    public Double getSalesnumber1() {
        return salesnumber1;
    }

    public void setSalesnumber1(Double salesnumber1) {
        this.salesnumber1 = salesnumber1;
    }

    public Double getDiscountrate1() {
        return discountrate1;
    }

    public void setDiscountrate1(Double discountrate1) {
        this.discountrate1 = discountrate1;
    }

    public String getModel5() {
        return model5;
    }

    public void setModel5(String model5) {
        this.model5 = model5;
    }

    public Double getSalesnumber2() {
        return salesnumber2;
    }

    public void setSalesnumber2(Double salesnumber2) {
        this.salesnumber2 = salesnumber2;
    }

    public Double getSalesamount3() {
        return salesamount3;
    }

    public void setSalesamount3(Double salesamount3) {
        this.salesamount3 = salesamount3;
    }

    public Double getSalesamount2() {
        return salesamount2;
    }

    public void setSalesamount2(Double salesamount2) {
        this.salesamount2 = salesamount2;
    }

    public Double getRatetotal() {
        return ratetotal;
    }

    public void setRatetotal(Double ratetotal) {
        this.ratetotal = ratetotal;
    }

    public Double getSalesamount1() {
        return salesamount1;
    }

    public void setSalesamount1(Double salesamount1) {
        this.salesamount1 = salesamount1;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Double getDiscountTotal() {
        return discountTotal;
    }

    public void setDiscountTotal(Double discountTotal) {
        this.discountTotal = discountTotal;
    }

    public Double getSalesamount5() {
        return salesamount5;
    }

    public void setSalesamount5(Double salesamount5) {
        this.salesamount5 = salesamount5;
    }

    public Double getSalesamount4() {
        return salesamount4;
    }

    public void setSalesamount4(Double salesamount4) {
        this.salesamount4 = salesamount4;
    }

    public Double getNumbertotal() {
        return numbertotal;
    }

    public void setNumbertotal(Double numbertotal) {
        this.numbertotal = numbertotal;
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

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public ProcessInstance getProcessInstance() {
        return processInstance;
    }

    public void setProcessInstance(ProcessInstance processInstance) {
        this.processInstance = processInstance;
    }

    public String getSealfacno() {
        return sealfacno;
    }

    public void setSealfacno(String sealfacno) {
        this.sealfacno = sealfacno;
    }

    public String getStampCategory() {
        return stampCategory;
    }

    public void setStampCategory(String stampCategory) {
        this.stampCategory = stampCategory;
    }

    public String getActualDiscountNo() {
        return actualDiscountNo;
    }

    public void setActualDiscountNo(String actualDiscountNo) {
        this.actualDiscountNo = actualDiscountNo;
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
        if (!(object instanceof HKYX011)) {
            return false;
        }
        HKYX011 other = (HKYX011) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKYX011[ oid=" + oid + " ]";
    }
    
}
