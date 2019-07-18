/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Cdrserno;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class CdrsernoBean extends SuperEJBForERP<Cdrserno> {

    public CdrsernoBean() {
        super(Cdrserno.class);
    }

    public Cdrserno findByPK(String facno, Character difcode, String keyformat) {
        Query query = this.getEntityManager().createNamedQuery("Cdrserno.findByPK");
        query.setParameter("facno", facno);
        query.setParameter("difcode", difcode);
        query.setParameter("keyformat", keyformat);
        try {
            return (Cdrserno) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}
