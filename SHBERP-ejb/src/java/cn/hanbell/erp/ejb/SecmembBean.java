/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Secmemb;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class SecmembBean extends SuperEJBForERP<Secmemb> {

    public SecmembBean() {
        super(Secmemb.class);
    }

    public Secmemb findByPK(String facno, String depno, String userno) {
        Query query = getEntityManager().createNamedQuery("Secmemb.findByPK");
        query.setParameter("facno", facno);
        query.setParameter("depno", depno);
        query.setParameter("userno", userno);
        try {
            Object o = query.getSingleResult();
            return (Secmemb) o;
        } catch (Exception ex) {
            return null;
        }
    }

}
