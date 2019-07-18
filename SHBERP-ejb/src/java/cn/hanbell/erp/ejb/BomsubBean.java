/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Bomsub;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class BomsubBean extends SuperEJBForERP<Bomsub> {

    public BomsubBean() {
        super(Bomsub.class);
    }

    public Bomsub findByPKItnbrs(String itnbrf, String itnbr, String itnbrs) {
        Query query = this.getEntityManager().createNamedQuery("Bomsub.findByPKItnbrs");
        query.setParameter("itnbrf", itnbrf);
        query.setParameter("itnbr", itnbr);
        query.setParameter("itnbrs", itnbrs);
        try {
            return (Bomsub) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}
