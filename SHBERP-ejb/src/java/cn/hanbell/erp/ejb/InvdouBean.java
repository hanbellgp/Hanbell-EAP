/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Invdou;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class InvdouBean extends SuperEJBForERP<Invdou> {

    public InvdouBean() {
        super(Invdou.class);
    }

    public Invdou findByTrtype(String trtype) {
        Query query = getEntityManager().createNamedQuery("Invdou.findByTrtype");
        query.setParameter("trtype", trtype);
        try {
            Object o = query.getSingleResult();
            return (Invdou) o;
        } catch (Exception ex) {
            return null;
        }
    }

}
