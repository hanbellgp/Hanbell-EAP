/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Manwipbal;
import java.math.BigDecimal;
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
public class ManwipbalBean extends SuperEJBForERP<Manwipbal> {

    public ManwipbalBean() {
        super(Manwipbal.class);
    }

    public List<Manwipbal> findByItnbr(String facno, String itnbr) {
        String jpql = "SELECT m FROM Manwipbal m WHERE m.manwipbalPK.facno = :facno AND m.itnbr = :itnbr AND (m.onhand1 > 0) ORDER BY m.manwipbalPK.facno,m.manwipbalPK.prono,m.manwipbalPK.manno ";
        Query query = getEntityManager().createQuery(jpql);
        query.setParameter("facno", facno);
        query.setParameter("itnbr", itnbr);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Manwipbal> findByItnbr(String facno, List<String> itnbr) {
        String jpql = "SELECT m FROM Manwipbal m WHERE m.manwipbalPK.facno = :facno AND m.itnbr IN :itnbr AND (m.onhand1 > 0) ORDER BY m.manwipbalPK.facno,m.manwipbalPK.prono,m.manwipbalPK.manno ";
        Query query = getEntityManager().createQuery(jpql);
        query.setParameter("facno", facno);
        query.setParameter("itnbr", itnbr);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Manwipbal> findByManno(String facno, String manno) {
        String jpql = "SELECT m FROM Manwipbal m WHERE m.manwipbalPK.facno = :facno AND m.manwipbalPK.manno = :manno ORDER BY m.manwipbalPK.facno,m.manwipbalPK.prono,m.manwipbalPK.manno,m.seqnr ";
        Query query = getEntityManager().createQuery(jpql);
        query.setParameter("facno", facno);
        query.setParameter("manno", manno);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public BigDecimal getTotalWIPQuantity(String facno, String itnbr) {
        BigDecimal qty = BigDecimal.ZERO;
        List<Manwipbal> manwipbalList = findByItnbr(facno, itnbr);
        if (manwipbalList != null && !manwipbalList.isEmpty()) {
            for (Manwipbal e : manwipbalList) {
                qty = qty.add(e.getOnhand1());
            }
        }
        return qty;
    }

    public BigDecimal getTotalWIPQuantity(String facno, List<String> itnbr) {
        BigDecimal qty = BigDecimal.ZERO;
        List<Manwipbal> manwipbalList = findByItnbr(facno, itnbr);
        if (manwipbalList != null && !manwipbalList.isEmpty()) {
            for (Manwipbal e : manwipbalList) {
                qty = qty.add(e.getOnhand1());
            }
        }
        return qty;
    }

    public List getWIPQuantity(String facno, String itnbr) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT facno,itnbr,seqnr,sum(onhand1) as wipqty,sum(finqy1) as finqty from manwipbal WHERE onhand1 > 0 ");
        sb.append(" and facno = ?1 AND itnbr = ?2 group by facno,itnbr,seqnr ORDER BY facno,itnbr,seqnr ");

        Query query = getEntityManager().createNativeQuery(sb.toString());
        query.setParameter(1, facno);
        query.setParameter(2, itnbr);

        try {
            return query.getResultList();
        } catch (Exception ex) {
            log4j.error(ex);
        }
        return null;
    }

}
