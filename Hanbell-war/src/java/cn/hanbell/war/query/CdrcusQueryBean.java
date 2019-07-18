/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.war.query;

import cn.hanbell.erp.ejb.CdrcusBean;
import cn.hanbell.erp.entity.Cdrcus;
import cn.hanbell.war.lazy.CdrcusModel;
import cn.hanbell.war.web.SuperQueryBeanForERP;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author C0160
 */
@ManagedBean(name = "cdrcusQueryBean")
@ViewScoped
public class CdrcusQueryBean extends SuperQueryBeanForERP<Cdrcus> {

    @EJB
    private CdrcusBean cdrcusBean;

    public CdrcusQueryBean() {
        super(Cdrcus.class);
    }

    @Override
    public void init() {
        superEJB = cdrcusBean;
        model = new CdrcusModel(cdrcusBean, this.getUserManagedBean().getCompany());
        super.init();
    }

    public void query() {
        if (this.getModel() != null) {
            this.getModel().getFilterFields().clear();
            if (this.getQueryFormId() != null && !"".equals(this.queryFormId)) {
                this.getModel().getFilterFields().put("cusno", this.getQueryFormId());
            }
            if (this.getQueryName() != null && !"".equals(this.queryName)) {
                this.getModel().getFilterFields().put("cusna", this.getQueryName());
            }
        }
    }

}
