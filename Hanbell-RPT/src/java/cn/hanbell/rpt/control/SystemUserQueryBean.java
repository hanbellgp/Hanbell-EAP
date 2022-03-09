/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.control;

import cn.hanbell.eap.ejb.SystemUserBean;
import cn.hanbell.eap.entity.SystemUser;
import cn.hanbell.rpt.lazy.SystemUserModel;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import cn.hanbell.rpt.web.SuperQueryBean;

/**
 *
 * @author C0160
 */
@ManagedBean(name = "systemUserQueryBean")
@ViewScoped
public class SystemUserQueryBean extends SuperQueryBean<SystemUser> {

    private String queryFormId;
    private String queryName;
    @EJB
    private SystemUserBean systemUserBean;

    public SystemUserQueryBean() {
        super(SystemUser.class);
    }

    @Override
    public void init() {
        this.superEJB = systemUserBean;
        setModel(new SystemUserModel(systemUserBean));
        model.getSortFields().put("userid", "ASC");
        super.init();
    }

    @Override
    public void query() {
        if (this.model != null) {
            this.model.getFilterFields().clear();
            if (this.queryFormId != null && !"".equals(this.queryFormId)) {
                this.model.getFilterFields().put("userid", this.queryFormId);
            }
            if (this.queryName != null && !"".equals(this.queryName)) {
                this.model.getFilterFields().put("username", this.queryName);
            }
        }
    }

    public String getQueryFormId() {
        return queryFormId;
    }

    public void setQueryFormId(String queryFormId) {
        this.queryFormId = queryFormId;
    }

    public String getQueryName() {
        return queryName;
    }

    public void setQueryName(String queryName) {
        this.queryName = queryName;
    }

}