/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hanbell.erp.ejb;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;
import vn.hanbell.erp.comm.SuperEJBForERP;
import vn.hanbell.erp.entity.Cdrcus;

/**
 *
 * @author ZFF
 */
@Stateless
@LocalBean
public class CdrcusBean extends SuperEJBForERP<Cdrcus> {
    
    public CdrcusBean() {
        super(Cdrcus.class);
    }

    public Cdrcus findByCusno(String cusno) {
        Query query = getEntityManager().createNamedQuery("Cdrcus.findByCusno");
        query.setParameter("cusno", cusno);
        try {
            Object o = query.getSingleResult();
            return (Cdrcus) o;
        } catch (Exception ex) {
            return null;
        }
    }
    
    public Cdrcus findByCusds(String cusds) {
        Query query = getEntityManager().createNamedQuery("Cdrcus.findByCusds");
        query.setParameter("cusds", cusds);
        try {
            Object o = query.getSingleResult();
            return (Cdrcus) o;
        } catch (Exception ex) {
            return null;
        }
    }
}
