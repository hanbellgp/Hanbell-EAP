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
@Table(name = "HK_JH007")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKJH007.findAll", query = "SELECT h FROM HKJH007 h"),
    @NamedQuery(name = "HKJH007.findByFacno", query = "SELECT h FROM HKJH007 h WHERE h.facno = :facno"),
    @NamedQuery(name = "HKJH007.findByPSN", query = "SELECT h FROM HKJH007 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKJH007.findByFSN", query = "SELECT h FROM HKJH007 h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKJH007.findByOID", query = "SELECT h FROM HKJH007 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKJH007.findBySerialNumber", query = "SELECT h FROM HKJH007 h WHERE h.serialNumber = :serialNumber")})
public class HKJH007 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "remark")
    private String remark;
    @Size(max = 255)
    @Column(name = "returnNumber")
    private String returnNumber;
    @Size(max = 255)
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "custserviceno")
    private String custserviceno;
    @Size(max = 255)
    @Column(name = "applyUser")
    private String applyUser;
    @Size(max = 255)
    @Column(name = "hdnapmanage")
    private String hdnapmanage;
    @Size(max = 255)
    @Column(name = "reasonname")
    private String reasonname;
    @Size(max = 255)
    @Column(name = "supplydept")
    private String supplydept;
    @Column(name = "returnDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date returnDate;
    @Size(max = 255)
    @Column(name = "applyDept")
    private String applyDept;
    @Size(max = 255)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "hdnsupplymanage")
    private String hdnsupplymanage;
    @Size(max = 255)
    @Column(name = "outfixnr")
    private String outfixnr;
    @Size(max = 255)
    @Column(name = "supplier")
    private String supplier;
    @Size(max = 255)
    @Column(name = "supplyuser")
    private String supplyuser;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "hdnproduct")
    private String hdnproduct;
    @Size(max = 255)
    @Column(name = "addcode")
    private String addcode;
    @Size(max = 255)
    @Column(name = "borrowNumber")
    private String borrowNumber;
    @Size(max = 255)
    @Column(name = "demanddept")
    private String demanddept;
    @Size(max = 255)
    @Column(name = "hdnsupplier")
    private String hdnsupplier;
    @Column(name = "needdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date needdate;
    @Size(max = 255)
    @Column(name = "infixnr")
    private String infixnr;
    @Size(max = 255)
    @Column(name = "demandproduct")
    private String demandproduct;
    @Size(max = 255)
    @Column(name = "outvarnr")
    private String outvarnr;
    @Size(max = 255)
    @Column(name = "contractNumber")
    private String contractNumber;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "demander")
    private String demander;
    @Size(max = 255)
    @Column(name = "hdnsupplyassistant")
    private String hdnsupplyassistant;
    @Column(name = "borrowDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date borrowDate;
    @Size(max = 255)
    @Column(name = "customerName")
    private String customerName;
    @Size(max = 255)
    @Column(name = "wareh")
    private String wareh;
    @Size(max = 255)
    @Column(name = "unit")
    private String unit;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "customerphone")
    private String customerphone;
    @Size(max = 255)
    @Column(name = "invarnr")
    private String invarnr;
    @Size(max = 255)
    @Column(name = "qty")
    private String qty;
    @Column(name = "applyDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date applyDate;
    @Size(max = 255)
    @Column(name = "hdndemander")
    private String hdndemander;
    @Size(max = 255)
    @Column(name = "hdnapassistant")
    private String hdnapassistant;
    @Size(max = 255)
    @Column(name = "whdsc")
    private String whdsc;
    @Size(max = 255)
    @Column(name = "borrowreason")
    private String borrowreason;
    @Size(max = 255)
    @Column(name = "customer")
    private String customer;
    @Size(max = 255)
    @Column(name = "customercontact")
    private String customercontact;

    public HKJH007() {
    }

    public HKJH007(String oid) {
        this.oid = oid;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getReturnNumber() {
        return returnNumber;
    }

    public void setReturnNumber(String returnNumber) {
        this.returnNumber = returnNumber;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getCustserviceno() {
        return custserviceno;
    }

    public void setCustserviceno(String custserviceno) {
        this.custserviceno = custserviceno;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getHdnapmanage() {
        return hdnapmanage;
    }

    public void setHdnapmanage(String hdnapmanage) {
        this.hdnapmanage = hdnapmanage;
    }

    public String getReasonname() {
        return reasonname;
    }

    public void setReasonname(String reasonname) {
        this.reasonname = reasonname;
    }

    public String getSupplydept() {
        return supplydept;
    }

    public void setSupplydept(String supplydept) {
        this.supplydept = supplydept;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getApplyDept() {
        return applyDept;
    }

    public void setApplyDept(String applyDept) {
        this.applyDept = applyDept;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getHdnsupplymanage() {
        return hdnsupplymanage;
    }

    public void setHdnsupplymanage(String hdnsupplymanage) {
        this.hdnsupplymanage = hdnsupplymanage;
    }

    public String getOutfixnr() {
        return outfixnr;
    }

    public void setOutfixnr(String outfixnr) {
        this.outfixnr = outfixnr;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getSupplyuser() {
        return supplyuser;
    }

    public void setSupplyuser(String supplyuser) {
        this.supplyuser = supplyuser;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getHdnproduct() {
        return hdnproduct;
    }

    public void setHdnproduct(String hdnproduct) {
        this.hdnproduct = hdnproduct;
    }

    public String getAddcode() {
        return addcode;
    }

    public void setAddcode(String addcode) {
        this.addcode = addcode;
    }

    public String getBorrowNumber() {
        return borrowNumber;
    }

    public void setBorrowNumber(String borrowNumber) {
        this.borrowNumber = borrowNumber;
    }

    public String getDemanddept() {
        return demanddept;
    }

    public void setDemanddept(String demanddept) {
        this.demanddept = demanddept;
    }

    public String getHdnsupplier() {
        return hdnsupplier;
    }

    public void setHdnsupplier(String hdnsupplier) {
        this.hdnsupplier = hdnsupplier;
    }

    public Date getNeeddate() {
        return needdate;
    }

    public void setNeeddate(Date needdate) {
        this.needdate = needdate;
    }

    public String getInfixnr() {
        return infixnr;
    }

    public void setInfixnr(String infixnr) {
        this.infixnr = infixnr;
    }

    public String getDemandproduct() {
        return demandproduct;
    }

    public void setDemandproduct(String demandproduct) {
        this.demandproduct = demandproduct;
    }

    public String getOutvarnr() {
        return outvarnr;
    }

    public void setOutvarnr(String outvarnr) {
        this.outvarnr = outvarnr;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getDemander() {
        return demander;
    }

    public void setDemander(String demander) {
        this.demander = demander;
    }

    public String getHdnsupplyassistant() {
        return hdnsupplyassistant;
    }

    public void setHdnsupplyassistant(String hdnsupplyassistant) {
        this.hdnsupplyassistant = hdnsupplyassistant;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getWareh() {
        return wareh;
    }

    public void setWareh(String wareh) {
        this.wareh = wareh;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getCustomerphone() {
        return customerphone;
    }

    public void setCustomerphone(String customerphone) {
        this.customerphone = customerphone;
    }

    public String getInvarnr() {
        return invarnr;
    }

    public void setInvarnr(String invarnr) {
        this.invarnr = invarnr;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getHdndemander() {
        return hdndemander;
    }

    public void setHdndemander(String hdndemander) {
        this.hdndemander = hdndemander;
    }

    public String getHdnapassistant() {
        return hdnapassistant;
    }

    public void setHdnapassistant(String hdnapassistant) {
        this.hdnapassistant = hdnapassistant;
    }

    public String getWhdsc() {
        return whdsc;
    }

    public void setWhdsc(String whdsc) {
        this.whdsc = whdsc;
    }

    public String getBorrowreason() {
        return borrowreason;
    }

    public void setBorrowreason(String borrowreason) {
        this.borrowreason = borrowreason;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCustomercontact() {
        return customercontact;
    }

    public void setCustomercontact(String customercontact) {
        this.customercontact = customercontact;
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
        if (!(object instanceof HKJH007)) {
            return false;
        }
        HKJH007 other = (HKJH007) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKJH007[ oid=" + oid + " ]";
    }

}
