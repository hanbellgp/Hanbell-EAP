/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.app;

import java.io.Serializable;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C2082
 */
@XmlRootElement
public class REPTCApplication implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String deliverydeptId;

    private String incentoryform;

    private String tradingreason;

    private String deliveryremark;

    private String maintainTypeId;

    private String repairKindId;

    private String repairno;

    private String customer;

    private String employeeId;

    private String deptId;

    private String maintainer;

    private String sessionkey;
    private String openId;

    List<REPTDApplication> reptds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaintainTypeId() {
        return maintainTypeId;
    }

    public void setMaintainTypeId(String maintainTypeId) {
        this.maintainTypeId = maintainTypeId;
    }

    public String getRepairKindId() {
        return repairKindId;
    }

    public void setRepairKindId(String repairKindId) {
        this.repairKindId = repairKindId;
    }

    public String getRepairno() {
        return repairno;
    }

    public void setRepairno(String repairno) {
        this.repairno = repairno;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
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

    public List<REPTDApplication> getReptds() {
        return reptds;
    }

    public void setReptds(List<REPTDApplication> reptds) {
        this.reptds = reptds;
    }

    public String getMaintainer() {
        return maintainer;
    }

    public void setMaintainer(String maintainer) {
        this.maintainer = maintainer;
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

    public String getIncentoryform() {
        return incentoryform;
    }

    public void setIncentoryform(String incentoryform) {
        this.incentoryform = incentoryform;
    }

    public String getTradingreason() {
        return tradingreason;
    }

    public void setTradingreason(String tradingreason) {
        this.tradingreason = tradingreason;
    }

    public String getDeliveryremark() {
        return deliveryremark;
    }

    public void setDeliveryremark(String deliveryremark) {
        this.deliveryremark = deliveryremark;
    }

    public String getDeliverydeptId() {
        return deliverydeptId;
    }

    public void setDeliverydeptId(String deliverydeptId) {
        this.deliverydeptId = deliverydeptId;
    }

}
