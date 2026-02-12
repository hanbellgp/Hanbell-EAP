/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.app;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C2082
 */
@Entity
@XmlRootElement
public class IssueApplication implements Serializable {

    @Id
    private Long id;
    private String facno;
    private String facnoname;
    private String employeeNo;
    private String employeeName;
    private String depeNo;
    private String deptName;
    private String post;
    private String postDesc;
    private String grade;
    private Date workStartDate;
    private String workStartDateDesc;
    private String proofType;
    private String proofDesc;

    private String reasonCode;
    private String reasonCdesc;

    private String money;

    private String sumrry;

    private List<HKGL082FilesApplication> hkgl082Files;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getFacnoname() {
        return facnoname;
    }

    public void setFacnoname(String facnoname) {
        this.facnoname = facnoname;
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

    public Date getWorkStartDate() {
        return workStartDate;
    }

    public void setWorkStartDate(Date workStartDate) {
        this.workStartDate = workStartDate;
    }

    public String getWorkStartDateDesc() {
        return workStartDateDesc;
    }

    public void setWorkStartDateDesc(String workStartDateDesc) {
        this.workStartDateDesc = workStartDateDesc;
    }

    public String getProofType() {
        return proofType;
    }

    public void setProofType(String proofType) {
        this.proofType = proofType;
    }

    public String getProofDesc() {
        return proofDesc;
    }

    public void setProofDesc(String proofDesc) {
        this.proofDesc = proofDesc;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getReasonCdesc() {
        return reasonCdesc;
    }

    public void setReasonCdesc(String reasonCdesc) {
        this.reasonCdesc = reasonCdesc;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getSumrry() {
        return sumrry;
    }

    public void setSumrry(String sumrry) {
        this.sumrry = sumrry;
    }

    public List<HKGL082FilesApplication> getHkgl082Files() {
        return hkgl082Files;
    }

    public void setHkgl082Files(List<HKGL082FilesApplication> hkgl082Files) {
        this.hkgl082Files = hkgl082Files;
    }



    
}
