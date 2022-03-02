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
public class MCEmployee {

    private String company;
    private String userId;
    private String userName;
    private String deptId;
    private String deptName;
    private String levelId;
    private String email;
    private String phone;
    private String upperUserId;
    private String status;

    public MCEmployee() {

    }

    public MCEmployee(String userId, String userName, String deptId, String deptName, String email,String upperUserId, String status) {
        this.userId = userId;
        this.userName = userName;
        this.deptId = deptId;
        this.deptName = deptName;
        this.email = email;
        this.upperUserId = upperUserId;
        this.status = status;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUpperUserId() {
        return upperUserId;
    }

    public void setUpperUserId(String upperUserId) {
        this.upperUserId = upperUserId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
