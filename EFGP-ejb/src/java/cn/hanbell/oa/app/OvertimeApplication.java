/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.app;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C0160
 */
@Entity
@XmlRootElement
public class OvertimeApplication implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String employee;
    private String formType;
    private String formTypeDesc;
    private String dept;
    private String hdnDept;

    private List<OvertimeApplicationDetail> detailList;

    public OvertimeApplication() {

    }

    /**
     * @return the employee
     */
    public String getEmployee() {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setEmployee(String employee) {
        this.employee = employee;
    }

    /**
     * @return the formType
     */
    public String getFormType() {
        return formType;
    }

    /**
     * @param formType the formType to set
     */
    public void setFormType(String formType) {
        this.formType = formType;
    }

    /**
     * @return the formTypeDesc
     */
    public String getFormTypeDesc() {
        return formTypeDesc;
    }

    /**
     * @param formTypeDesc the formTypeDesc to set
     */
    public void setFormTypeDesc(String formTypeDesc) {
        this.formTypeDesc = formTypeDesc;
    }

    /**
     * @return the dept
     */
    public String getDept() {
        return dept;
    }

    /**
     * @param dept the dept to set
     */
    public void setDept(String dept) {
        this.dept = dept;
    }

    /**
     * @return the hdnDept
     */
    public String getHdnDept() {
        return hdnDept;
    }

    /**
     * @param hdnDept the hdnDept to set
     */
    public void setHdnDept(String hdnDept) {
        this.hdnDept = hdnDept;
    }

    /**
     * @return the detailList
     */
    public List<OvertimeApplicationDetail> getDetailList() {
        return detailList;
    }

    /**
     * @param detailList the detailList to set
     */
    public void setDetailList(List<OvertimeApplicationDetail> detailList) {
        this.detailList = detailList;
    }

}
