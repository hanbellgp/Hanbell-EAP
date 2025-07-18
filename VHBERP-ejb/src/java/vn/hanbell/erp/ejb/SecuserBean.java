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
import vn.hanbell.erp.entity.Secuser;

/**
 *
 * @author ZFF
 */
@Stateless
@LocalBean
public class SecuserBean extends SuperEJBForERP<Secuser> {
    
    public SecuserBean() {
        super(Secuser.class);
    }
    
    public Secuser findByUserno(String userno) {
        Query query = getEntityManager().createNamedQuery("Secuser.findByUserno");
        query.setParameter("userno", userno);
        try {
            Object o = query.getSingleResult();
            return (Secuser) o;
        } catch (Exception ex) {
            return null;
        }
    }
}
