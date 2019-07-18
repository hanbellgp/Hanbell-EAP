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
 * @author Administrator
 */
@XmlRootElement
public class HZJS034Model implements Serializable {

    @Size(max = 3)
    @Column(name = "facno")
    private String facno;
    @Size(max = 20)
    @Column(name = "empl")
    private String empl;
    @Size(max = 20)
    @Column(name = "dept")
    private String dept;
    @Column(name = "indate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date indate;
    @Size(max = 20)
    @Column(name = "PLMNO")
    private String PLMNO;

    public HZJS034Model() {
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getEmpl() {
        return empl;
    }

    public void setEmpl(String empl) {
        this.empl = empl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HZJS034Model)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HZJS034Model";
    }

    /**
     * @return the PLMNO
     */
    public String getPLMNO() {
        return PLMNO;
    }

    /**
     * @param PLMNO the PLMNO to set
     */
    public void setPLMNO(String PLMNO) {
        this.PLMNO = PLMNO;
    }

}
