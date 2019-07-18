/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Invclswah;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class InvclswahBean extends SuperEJBForERP<Invclswah> {

    public InvclswahBean() {
        super(Invclswah.class);
    }

    public Invclswah findByInvclswahPK(String facno, String prono, String itcls) {
        Query query = this.getEntityManager().createNamedQuery("Invclswah.findByPK");
        query.setParameter("facno", facno);
        query.setParameter("prono", prono);
        query.setParameter("itcls", itcls);
        try {
            Object o = query.getSingleResult();
            return (Invclswah) o;
        } catch (Exception ex) {
            return null;
        }

    }
}
