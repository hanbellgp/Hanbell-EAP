/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.war.query;

import cn.hanbell.war.lazy.ArmbillDetailForQueryModel;
import cn.hanbell.war.web.SuperQueryBean;
import cn.hanbell.eap.ejb.ArmbillDetailForQueryBean;
import cn.hanbell.eap.entity.ArmbillDetailForQuery;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author C0160
 */
@ManagedBean(name = "billExportQueryBean")
@ViewScoped
public class BillExportQueryBean extends SuperQueryBean<ArmbillDetailForQuery> {

    @EJB
    private ArmbillDetailForQueryBean armbillDetailForQueryBean;

    private String queryCreator;
    private String queryDeptno;

    public BillExportQueryBean() {
        super(ArmbillDetailForQuery.class);
    }

    @Override
    public void init() {
        queryCreator = userManagedBean.getCurrentUser().getUsername();
        superEJB = armbillDetailForQueryBean;
        model = new ArmbillDetailForQueryModel(armbillDetailForQueryBean, userManagedBean.getCompany());
        model.getFilterFields().put("armbill.creator", queryCreator);
        super.init();
    }

    @Override
    public void query() {
        if (this.model != null && this.model.getFilterFields() != null) {
            this.model.getFilterFields().clear();
            if (queryFormId != null && !"".equals(queryFormId)) {
                this.model.getFilterFields().put("armbill.formid", queryFormId);
            }
            if (queryDateBegin != null) {
                this.model.getFilterFields().put("armbill.formdateBegin", queryDateBegin);
            }
            if (queryDateEnd != null) {
                this.model.getFilterFields().put("armbill.formdateEnd", queryDateEnd);
            }
            if (queryCreator != null && !"".equals(queryCreator)) {
                this.model.getFilterFields().put("armbill.creator", queryCreator);
            }
            if (queryDeptno != null && !"".equals(queryDeptno)) {
                this.model.getFilterFields().put("armbill.deptno", queryDeptno);
            }
            if (queryState != null && !"ALL".equals(queryState)) {
                this.model.getFilterFields().put("armbill.status", queryState);
            }
        }
    }

    @Override
    public void reset() {
        super.reset();
        queryCreator = userManagedBean.getCurrentUser().getUsername();
        model.getFilterFields().put("armbill.creator", queryCreator);
    }

    /**
     * @return the queryCreator
     */
    public String getQueryCreator() {
        return queryCreator;
    }

    /**
     * @param queryCreator the queryCreator to set
     */
    public void setQueryCreator(String queryCreator) {
        this.queryCreator = queryCreator;
    }

    /**
     * @return the queryDeptno
     */
    public String getQueryDeptno() {
        return queryDeptno;
    }

    /**
     * @param queryDeptno the queryDeptno to set
     */
    public void setQueryDeptno(String queryDeptno) {
        this.queryDeptno = queryDeptno;
    }

}
