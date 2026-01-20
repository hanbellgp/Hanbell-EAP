/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.app;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C2082
 */
@Entity
@XmlRootElement
public class ResignApplication implements Serializable {

    @Id
    private Long id;
    private String employeeNo;
    private String employeeName;
    private String depeNo;
    private String deptName;
    private String post;
    private String postDesc;
    private String grade;
    private String isAdmin;
    private Date workdate;
    private Date resigndate;
    private String reason;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDepeNo() {
        return depeNo;
    }

    public void setDepeNo(String depeNo) {
        this.depeNo = depeNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPostDesc() {
        return postDesc;
    }

    public void setPostDesc(String postDesc) {
        this.postDesc = postDesc;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Date getWorkdate() {
        return workdate;
    }

    public void setWorkdate(Date workdate) {
        this.workdate = workdate;
    }

    public Date getResigndate() {
        return resigndate;
    }

    public void setResigndate(Date resigndate) {
        this.resigndate = resigndate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    
    
    
}
