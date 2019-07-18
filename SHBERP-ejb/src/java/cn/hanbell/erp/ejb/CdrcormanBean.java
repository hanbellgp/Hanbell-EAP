/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Cdrcorman;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class CdrcormanBean extends SuperEJBForERP<Cdrcorman> {

    public CdrcormanBean() {
        super(Cdrcorman.class);
    }

    public Cdrcorman findByItcls(String itcls) {
        Query query = this.getEntityManager().createNamedQuery("Cdrcorman.findByItcls");
        query.setParameter("itcls", itcls);
        try {
            return (Cdrcorman) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}
