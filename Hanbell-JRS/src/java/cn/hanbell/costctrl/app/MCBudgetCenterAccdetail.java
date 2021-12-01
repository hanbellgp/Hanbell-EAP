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
public class MCBudgetCenterAccdetail {

    private String facno;
    private String centerId;
    private String budgetAcc;
    private String accName;

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getCenterId() {
        return centerId;
    }

    public void setCenterId(String centerId) {
        this.centerId = centerId;
    }

    public String getBudgetAcc() {
        return budgetAcc;
    }

    public void setBudgetAcc(String budgetAcc) {
        this.budgetAcc = budgetAcc;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }
}
