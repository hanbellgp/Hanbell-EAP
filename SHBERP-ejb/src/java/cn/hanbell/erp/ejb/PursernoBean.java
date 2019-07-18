/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Purserno;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C1491
 */
@Stateless
@LocalBean
public class PursernoBean extends SuperEJBForERP<Purserno> {

    public PursernoBean() {
        super(Purserno.class);
    }

    public Purserno findByPK(String facno, String prono, Character difcode, String keyformat) {
        Query query = getEntityManager().createNamedQuery("Purserno.findByPK");
        query.setParameter("facno", facno);
        query.setParameter("prono", prono);
        query.setParameter("difcode", difcode);
        query.setParameter("keyformat", keyformat);
        try {
            return (Purserno) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }
}
