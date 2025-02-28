/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kr.hanbell.erp.ejb;


import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;
import kr.hanbell.erp.comm.SuperEJBForERP;
import kr.hanbell.erp.entity.Purserno;

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
