/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C2082
 */
@XmlRootElement
public class D50Z0009DOFWModel implements Serializable {

    private static final long serialVersionUID = 1L;
    private String applyfacno;
    private String applyUser;
    private String applyDept;
    private String supportfacno;
    private String supportUser;
    private String supportDept;

    public String getApplyfacno() {
        return applyfacno;
    }

    public void setApplyfacno(String applyfacno) {
        this.applyfacno = applyfacno;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getApplyDept() {
        return applyDept;
    }

    public void setApplyDept(String applyDept) {
        this.applyDept = applyDept;
    }

    public String getSupportfacno() {
        return supportfacno;
    }

    public void setSupportfacno(String supportfacno) {
        this.supportfacno = supportfacno;
    }

    public String getSupportUser() {
        return supportUser;
    }

    public void setSupportUser(String supportUser) {
        this.supportUser = supportUser;
    }

    public String getSupportDept() {
        return supportDept;
    }

    public void setSupportDept(String supportDept) {
        this.supportDept = supportDept;
    }
    
    
    
    
}

    

