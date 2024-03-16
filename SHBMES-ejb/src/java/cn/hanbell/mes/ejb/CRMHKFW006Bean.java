/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.mes.ejb;

import cn.hanbell.mes.comm.SuperEJBForMES;
import cn.hanbell.mes.entity.CRMHKFW006;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C1491
 */
@Stateless
@LocalBean
public class CRMHKFW006Bean extends SuperEJBForMES<CRMHKFW006> {

    public CRMHKFW006Bean() {
        super(CRMHKFW006.class);
    }

    public CRMHKFW006 findByPSN(String psn) {
        Query query = getEntityManager().createNamedQuery("CRMHKFW006.findByPSN");
        query.setParameter("psn", psn);
        try {
            return (CRMHKFW006) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }
}
