/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.WARTA;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C1587
 */
@Stateless
@LocalBean
public class WARTABean extends SuperEJBForCRM<WARTA> {

    public WARTABean() {
        super(WARTA.class);
    }

    public WARTA findByPK(String ta001, String ta002) {
        Query query = this.getEntityManager().createNamedQuery("WARTA.findByPK");
        query.setParameter("ta001", ta001);
        query.setParameter("ta002", ta002);
        try {
            Object o = query.getSingleResult();
            return (WARTA) o;
        } catch (Exception ex) {
            return null;
        }
    }

}
