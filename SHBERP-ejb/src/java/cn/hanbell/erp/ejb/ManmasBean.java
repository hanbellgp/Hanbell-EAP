/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Manmas;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author kevindong
 */
@Stateless
@LocalBean
public class ManmasBean extends SuperEJBForERP<Manmas> {

    public ManmasBean() {
        super(Manmas.class);
    }

    public List<Manmas> findByLinecodeAndMandate(String facno, String linecode, Date mandateBegin, Date mandateEnd, int first, int pageSize) {
        String jpql = "SELECT m FROM Manmas m WHERE m.manmasPK.facno = :facno AND m.linecode = :linecode AND m.mandate >= :mandateBegin AND m.mandate <= :mandateEnd AND m.manstatus >='E' AND m.manstatus <'I' ORDER BY m.mandate,m.manmasPK.manno";
        Query query = getEntityManager().createQuery(jpql).setFirstResult(first).setMaxResults(pageSize);
        query.setParameter("facno", facno);
        query.setParameter("linecode", linecode);
        query.setParameter("mandateBegin", mandateBegin);
        query.setParameter("mandateEnd", mandateEnd);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public int getRowCountByLinecodeAndMandate(String facno, String linecode, Date mandateBegin, Date mandateEnd) {
        String jpql = "SELECT COUNT(m) FROM Manmas m WHERE m.manmasPK.facno = :facno AND m.linecode = :linecode AND m.mandate >= :mandateBegin AND m.mandate <= :mandateEnd AND m.manstatus >='E' AND m.manstatus <'I' ";
        Query query = getEntityManager().createQuery(jpql);
        query.setParameter("facno", facno);
        query.setParameter("linecode", linecode);
        query.setParameter("mandateBegin", mandateBegin);
        query.setParameter("mandateEnd", mandateEnd);
        try {
            return Integer.parseInt(query.getSingleResult().toString());
        } catch (Exception ex) {
            return 0;
        }
    }

}
