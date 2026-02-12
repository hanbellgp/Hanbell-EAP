/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kr.hanbell.erp.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;
import kr.hanbell.erp.comm.SuperEJBForERP;
import kr.hanbell.erp.entity.Purdta;

/**
 *
 * @author ZFF
 */
@Stateless
@LocalBean
public class PurdtaBean extends SuperEJBForERP<Purdta>{

       public PurdtaBean() {
        super(Purdta.class);
    }

    public List<Purdta> findByPono(String pono) {
        Query query = getEntityManager().createNamedQuery("Purdta.findByPono");
        query.setParameter("pono", pono);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public Purdta findByPK(String facno, String prono, String pono, short trseq) {
        Query query = getEntityManager().createNamedQuery("Purdta.findByPK");
        query.setParameter("facno", facno);
        query.setParameter("prono", prono);
        query.setParameter("pono", pono);
        query.setParameter("trseq", trseq);
        try {
            Object o = query.getSingleResult();
            return (Purdta) o;
        } catch (Exception ex) {
            return null;
        }
    }
}
