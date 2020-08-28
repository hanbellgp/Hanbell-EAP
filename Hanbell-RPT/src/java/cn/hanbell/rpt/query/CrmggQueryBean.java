/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.query;

import cn.hanbell.crm.ejb.CRMGGBean;
import cn.hanbell.crm.entity.CRMGG;
import cn.hanbell.rpt.lazy.CRMGGModel;
import cn.hanbell.rpt.web.SuperQueryBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author C2082
 */
@ManagedBean(name = "crmggQueryBean")
@ViewScoped
public class CrmggQueryBean extends SuperQueryBean<CRMGG> {

    @EJB
    private CRMGGBean crmggBean;

    private String customerID;
    private String customerName;

    public CrmggQueryBean() {
        super(CRMGG.class);
    }

    @Override
    public void init() {
        this.superEJB = crmggBean;
        setModel(new CRMGGModel(crmggBean));
        super.init();
    }

    @Override
    public void query() {
        if (this.model != null) {
            this.model.getFilterFields().clear();
            if (this.customerID != null && !"".equals(this.customerID)) {
                this.model.getFilterFields().put("gg001", this.customerID);
            }
            if (this.customerName != null && !"".equals(this.customerName)) {
                this.model.getFilterFields().put("gg003", this.customerName);
            }
        }
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

}
