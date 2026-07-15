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
import vn.hanbell.erp.entity.Cdrlndta;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class CdrlndtaBean extends SuperEJBForERP<Cdrlndta> {

    public CdrlndtaBean() {
        super(Cdrlndta.class);
    }

    public Cdrlndta findByPK(String facno, String trno, short trseq) {
        Query query = getEntityManager().createNamedQuery("Cdrlndta.findByPK");
        query.setParameter("facno", facno);
        query.setParameter("trno", trno);
        query.setParameter("trseq", trseq);
        try {
            return (Cdrlndta) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

}
