/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Scminvmas;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class ScminvmasBean extends SuperEJBForERP<Scminvmas> {

    public ScminvmasBean() {
        super(Scminvmas.class);
    }

    public Scminvmas findByItnbr(String itnbr) {
        Query query = getEntityManager().createNamedQuery("Scminvmas.findByItnbr");
        query.setParameter("itnbr", itnbr);
        try {
            Object o = query.getSingleResult();
            return (Scminvmas) o;
        } catch (Exception ex) {
            return null;
        }
    }

}
