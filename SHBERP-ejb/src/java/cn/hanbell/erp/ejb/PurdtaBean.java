/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Purdta;
import java.math.BigDecimal;
import java.util.Date;
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
public class PurdtaBean extends SuperEJBForERP<Purdta> {

    public PurdtaBean() {
        super(Purdta.class);
    }

    public List<Purdta> findByItnbrAndBeforeAskdate(String facno, String itnbr, Date askdate) {
        String jpql = "SELECT p FROM Purdta p WHERE p.purdtaPK.facno = :facno AND p.itnbr = :itnbr AND p.askdate <= :askdate ORDER BY p.purdtaPK.facno,p.purdtaPK.prono,p.purdtaPK.pono ";
        Query query = getEntityManager().createQuery(jpql);
        query.setParameter("facno", facno);
        query.setParameter("itnbr", itnbr);
        query.setParameter("askdate", askdate);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Purdta> findByItnbrAndBeforeAskdate(String facno, List<String> itnbr, Date askdate) {
        String jpql = "SELECT p FROM Purdta p WHERE p.purdtaPK.facno = :facno AND p.itnbr IN :itnbr AND p.askdate <= :askdate ORDER BY p.purdtaPK.facno,p.purdtaPK.prono,p.purdtaPK.pono ";
        Query query = getEntityManager().createQuery(jpql);
        query.setParameter("facno", facno);
        query.setParameter("itnbr", itnbr);
        query.setParameter("askdate", askdate);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
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

    public BigDecimal getAvailableQuantity(String facno, String itnbr, Date askdate) {
        BigDecimal qty = BigDecimal.ZERO;
        List<Purdta> purdtaList = findByItnbrAndBeforeAskdate(facno, itnbr, askdate);
        if (purdtaList != null && !purdtaList.isEmpty()) {
            for (Purdta e : purdtaList) {
                qty = qty.add(e.getPoqy1().subtract(e.getOkqy1()).subtract(e.getCallqy1()));
            }
        }
        return qty;
    }

    public BigDecimal getAvailableQuantity(String facno, List<String> itnbr, Date askdate) {
        BigDecimal qty = BigDecimal.ZERO;
        List<Purdta> purdtaList = findByItnbrAndBeforeAskdate(facno, itnbr, askdate);
        if (purdtaList != null && !purdtaList.isEmpty()) {
            for (Purdta e : purdtaList) {
                qty = qty.add(e.getPoqy1().subtract(e.getOkqy1()).subtract(e.getCallqy1()));
            }
        }
        return qty;
    }

}
