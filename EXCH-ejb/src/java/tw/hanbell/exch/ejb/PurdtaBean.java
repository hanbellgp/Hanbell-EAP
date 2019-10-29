/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.hanbell.exch.ejb;

import tw.hanbell.exch.comm.SuperEJBForEXCH;
import tw.hanbell.exch.entity.Purdta;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class PurdtaBean extends SuperEJBForEXCH<Purdta> {

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
