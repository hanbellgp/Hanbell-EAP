/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.BudgetAcc;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class BudgetAccBean extends SuperEJBForERP<BudgetAcc> {

    public BudgetAccBean() {
        super(BudgetAcc.class);
    }

    public BudgetAcc findByAccno(String accno) {
        Query query = getEntityManager().createNamedQuery("BudgetAcc.findByAccno");
        query.setParameter("accno", accno);
        try {
            return (BudgetAcc) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

}
