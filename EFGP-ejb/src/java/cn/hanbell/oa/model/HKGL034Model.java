/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C0160
 */
@XmlRootElement
public class HKGL034Model implements Serializable {


    private String facno;
    private String hdn_facno;
    private Date applyDate;
    private String applyUser;
    private String hdn_applyUser;
    private String applyDept;
    private String hdn_applyDept;

    private String type;
    private String hdn_type;

    public HKGL034Model() {
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    /**
     * @return the hdn_facno
     */
    public String getHdn_facno() {
        return hdn_facno;
    }

    /**
     * @param hdn_facno the hdn_facno to set
     */
    public void setHdn_facno(String hdn_facno) {
        this.hdn_facno = hdn_facno;
    }

    public String getHdn_applyUser() {
        return hdn_applyUser;
    }

    public void setHdn_applyUser(String hdn_applyUser) {
        this.hdn_applyUser = hdn_applyUser;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getHdn_type() {
        return hdn_type;
    }

    public void setHdn_type(String hdn_type) {
        this.hdn_type = hdn_type;
    }

    public String getApplyDept() {
        return applyDept;
    }

    public void setApplyDept(String applyDept) {
        this.applyDept = applyDept;
    }

    public String getHdn_applyDept() {
        return hdn_applyDept;
    }

    public void setHdn_applyDept(String hdn_applyDept) {
        this.hdn_applyDept = hdn_applyDept;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HKGL034Model)) {
            return false;
        }
        HKGL034Model other = (HKGL034Model) object;
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKGL034";
    }

}
