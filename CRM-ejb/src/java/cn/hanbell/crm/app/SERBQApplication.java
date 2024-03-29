/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.app;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C2082
 */
@XmlRootElement
public class SERBQApplication implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String employeeId;
    private String deptId;
    private String complaintTypeId;
    private String customerCodeId;
    private String complaintTypeName;
    private String caller;
    private String callerUnit;
    private String callerPhone;
    private String reason;
    private String phoneCountry;
    private String phoneArea;
    private String phoneCountry1;
    private String phoneArea1;
    private String productId;
    private String areaId;
    private String dealer;
    private String incidentProvinceId;
    private String emergencyDrgreeId;
    private String problemTypeId;
    private String problemTypeName;
    private String incidentCityId;
    private String machineTypeId;
    private String currency;
    private String companyName;
    private String invoiceAdress1;
    private String invoiceAdress2;
    private String invoiceMail;
    private String unifyNum;
    private String sessionkey;
    private String openId;
    private String productTypeId;
    private String responsibilitiesId;
    private List<SERBQDETAILLApplication> sercadetails;
   

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SERBQApplication other = (SERBQApplication) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getComplaintTypeId() {
        return complaintTypeId;
    }

    public void setComplaintTypeId(String complaintTypeId) {
        this.complaintTypeId = complaintTypeId;
    }

    public String getCustomerCodeId() {
        return customerCodeId;
    }

    public void setCustomerCodeId(String customerCodeId) {
        this.customerCodeId = customerCodeId;
    }

    public String getComplaintTypeName() {
        return complaintTypeName;
    }

    public void setComplaintTypeName(String complaintTypeName) {
        this.complaintTypeName = complaintTypeName;
    }

    public String getCaller() {
        return caller;
    }

    public void setCaller(String caller) {
        this.caller = caller;
    }

    public String getCallerUnit() {
        return callerUnit;
    }

    public void setCallerUnit(String callerUnit) {
        this.callerUnit = callerUnit;
    }

    public String getCallerPhone() {
        return callerPhone;
    }

    public void setCallerPhone(String callerPhone) {
        this.callerPhone = callerPhone;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getPhoneCountry() {
        return phoneCountry;
    }

    public void setPhoneCountry(String phoneCountry) {
        this.phoneCountry = phoneCountry;
    }

    public String getPhoneArea() {
        return phoneArea;
    }

    public void setPhoneArea(String phoneArea) {
        this.phoneArea = phoneArea;
    }

    public String getPhoneCountry1() {
        return phoneCountry1;
    }

    public void setPhoneCountry1(String phoneCountry1) {
        this.phoneCountry1 = phoneCountry1;
    }

    public String getPhoneArea1() {
        return phoneArea1;
    }

    public void setPhoneArea1(String phoneArea1) {
        this.phoneArea1 = phoneArea1;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getDealer() {
        return dealer;
    }

    public void setDealer(String dealer) {
        this.dealer = dealer;
    }

    public String getIncidentProvinceId() {
        return incidentProvinceId;
    }

    public void setIncidentProvinceId(String incidentProvinceId) {
        this.incidentProvinceId = incidentProvinceId;
    }

    public String getEmergencyDrgreeId() {
        return emergencyDrgreeId;
    }

    public void setEmergencyDrgreeId(String emergencyDrgreeId) {
        this.emergencyDrgreeId = emergencyDrgreeId;
    }
    
        public String getResponsibilitiesId() {
        return responsibilitiesId;
    }
     
      public void setResponsibilitiesId(String responsibilitiesId) {
        this.responsibilitiesId = responsibilitiesId;
    }

    public String getProblemTypeId() {
        return problemTypeId;
    }

    public void setProblemTypeId(String problemTypeId) {
        this.problemTypeId = problemTypeId;
    }

    public String getIncidentCityId() {
        return incidentCityId;
    }

    public void setIncidentCityId(String incidentCityId) {
        this.incidentCityId = incidentCityId;
    }

    public String getMachineTypeId() {
        return machineTypeId;
    }

    public void setMachineTypeId(String machineTypeId) {
        this.machineTypeId = machineTypeId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getInvoiceAdress1() {
        return invoiceAdress1;
    }

    public void setInvoiceAdress1(String invoiceAdress1) {
        this.invoiceAdress1 = invoiceAdress1;
    }

    public String getInvoiceAdress2() {
        return invoiceAdress2;
    }

    public void setInvoiceAdress2(String invoiceAdress2) {
        this.invoiceAdress2 = invoiceAdress2;
    }

    public String getInvoiceMail() {
        return invoiceMail;
    }

    public void setInvoiceMail(String invoiceMail) {
        this.invoiceMail = invoiceMail;
    }

    public String getUnifyNum() {
        return unifyNum;
    }

    public void setUnifyNum(String unifyNum) {
        this.unifyNum = unifyNum;
    }

    public String getSessionkey() {
        return sessionkey;
    }

    public void setSessionkey(String sessionkey) {
        this.sessionkey = sessionkey;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(String productTypeId) {
        this.productTypeId = productTypeId;
    }

    public List<SERBQDETAILLApplication> getSercadetails() {
        return sercadetails;
    }

    public void setSercadetails(List<SERBQDETAILLApplication> sercadetails) {
        this.sercadetails = sercadetails;
    }

    public String getProblemTypeName() {
        return problemTypeName;
    }

    public void setProblemTypeName(String problemTypeName) {
        this.problemTypeName = problemTypeName;
    }
    
 

}
