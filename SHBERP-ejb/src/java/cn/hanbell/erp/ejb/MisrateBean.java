/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Misrate;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class MisrateBean extends SuperEJBForERP<Misrate> {

    public MisrateBean() {
        super(Misrate.class);
    }

    public Misrate findByCoin(String coin) {
        Query q = this.getEntityManager().createQuery("SELECT m FROM Misrate m WHERE m.misratePK.coin = :coin ORDER BY m.misratePK.rateday desc");
        q.setParameter("coin", coin);
        try {
            Misrate m = (Misrate) q.getResultList().get(0);
            return m;
        } catch (Exception ex) {
            return null;
        }
    }

}
