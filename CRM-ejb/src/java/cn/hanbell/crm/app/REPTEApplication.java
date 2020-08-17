/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.app;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author C2082
 */
public class REPTEApplication implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String maintainTypeId;
    private String maintainNumberId;
    private String mainSerial;
    private String maintainerId;
    private String maintainer;
    private String deptno;
    private String dept;
    private String problemId;
    private String problemName;
    private String handlingInfo;
    private String punchDate;
    private String addressNameView;
    private String addressView;
    private String sessionkey;
    private String openId;
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

    public String getMaintainNumberId() {
        return maintainNumberId;
    }

    public void setMaintainNumberId(String maintainNumberId) {
        this.maintainNumberId = maintainNumberId;
    }

    public String getMainSerial() {
        return mainSerial;
    }

    public void setMainSerial(String mainSerial) {
        this.mainSerial = mainSerial;
    }

    public String getMaintainerId() {
        return maintainerId;
    }

    public void setMaintainerId(String maintainerId) {
        this.maintainerId = maintainerId;
    }

    public String getMaintainer() {
        return maintainer;
    }

    public void setMaintainer(String maintainer) {
        this.maintainer = maintainer;
    }

    public String getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getProblemId() {
        return problemId;
    }

    public void setProblemId(String problemId) {
        this.problemId = problemId;
    }

    public String getProblemName() {
        return problemName;
    }

    public void setProblemName(String problemName) {
        this.problemName = problemName;
    }
    public String getHandlingInfo() {
        return handlingInfo;
    }

    public void setHandlingInfo(String handlingInfo) {
        this.handlingInfo = handlingInfo;
    }

    public String getPunchDate() {
        return punchDate;
    }

    public void setPunchDate(String punchDate) {
        this.punchDate = punchDate;
    }

    public String getAddressNameView() {
        return addressNameView;
    }

    public void setAddressNameView(String addressNameView) {
        this.addressNameView = addressNameView;
    }

    public String getAddressView() {
        return addressView;
    }

    public void setAddressView(String addressView) {
        this.addressView = addressView;
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

  
    
    @Override
    public String toString() {
        return "REPTEApplication{" + "id=" + id + ", maintainTypeId=" + maintainTypeId + ", maintainNumberId=" + maintainNumberId + ", mainSerial=" + mainSerial + ", maintainerId=" + maintainerId + ", maintainer=" + maintainer + ", deptno=" + deptno + ", dept=" + dept + ", problemId=" + problemId + ", problemName=" + problemName + ", handlingInfo=" + handlingInfo + '}';
    }


}
