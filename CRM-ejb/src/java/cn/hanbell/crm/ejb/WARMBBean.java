/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.WARMB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C1491
 */
@Stateless
@LocalBean
public class WARMBBean extends SuperEJBForCRM<WARMB> {

    public WARMBBean() {
        super(WARMB.class);
    }

    public WARMB findByMB001(String mb001) {
        Query query = this.getEntityManager().createNamedQuery("WARMB.findByMb001");
        query.setParameter("mb001", mb001);
        try {
            Object o = query.getSingleResult();
            return (WARMB) o;
        } catch (Exception e) {
            return null;
        }

    }

}
