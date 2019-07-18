/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Invpri;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class InvpriBean extends SuperEJBForERP<Invpri> {

    public InvpriBean() {
        super(Invpri.class);
    }

    public Invpri findByPK(String facno, String yearmon, String itnbr) {
        Query query = getEntityManager().createNamedQuery("Invpri.findByPK");
        query.setParameter("facno", facno);
        query.setParameter("yearmon", yearmon);
        query.setParameter("itnbr", itnbr);
        try {
            Invpri i = (Invpri) query.getSingleResult();
            return i;
        } catch (Exception ex) {
            return null;
        }
    }
}
