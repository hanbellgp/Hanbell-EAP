/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Apmanp585h;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class Apmanp585hBean extends SuperEJBForERP<Apmanp585h> {

    public Apmanp585hBean() {
        super(Apmanp585h.class);
    }

    public Apmanp585h findByOAPSN(String psn) {
        Query query = getEntityManager().createNamedQuery("Apmanp585h.findByOaid");
        query.setParameter("oaid", psn);
        try {
            return (Apmanp585h) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

}
