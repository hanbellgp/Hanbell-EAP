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
import vn.hanbell.erp.entity.Invdou;

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
