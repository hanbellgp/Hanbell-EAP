/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.BudgetCenter;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class BudgetCenterBean extends SuperEJBForERP<BudgetCenter> {

    public BudgetCenterBean() {
        super(BudgetCenter.class);
    }

    public BudgetCenter findByDeptid(String deptid) {
        Query query = getEntityManager().createNamedQuery("BudgetCenter.findByDeptid");
        query.setParameter("deptid", deptid);
        try {
            return (BudgetCenter) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

}
