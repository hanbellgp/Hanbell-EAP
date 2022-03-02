/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.costctrl.app;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@XmlRootElement
public class MCDepartment {

    private String deptId;
    private String deptName;
    private String parentDeptId;
    private String deptManagerId;
    private String status;

    public MCDepartment() {
    }

    public MCDepartment(String deptId, String deptName, String deptManagerId, String parentDeptId, String status) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.deptManagerId = deptManagerId;
        this.parentDeptId = parentDeptId;
        this.status = status;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getParentDeptId() {
        return parentDeptId;
    }

    public void setParentDeptId(String parentDeptId) {
        this.parentDeptId = parentDeptId;
    }

    public String getDeptManagerId() {
        return deptManagerId;
    }

    public void setDeptManagerId(String deptManagerId) {
        this.deptManagerId = deptManagerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
