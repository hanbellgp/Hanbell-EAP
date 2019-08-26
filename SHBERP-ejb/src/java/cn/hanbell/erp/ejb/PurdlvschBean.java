/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Purdlvsch;
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
public class PurdlvschBean extends SuperEJBForERP<Purdlvsch> {

    List<Purdlvsch> dataList;

    public PurdlvschBean() {
        super(Purdlvsch.class);
    }

    public List<Purdlvsch> findNeedCancelByStatus(Date indate) {
        Query query = getEntityManager().createNamedQuery("Purdlvsch.findNeedCancelByStatus");
        query.setParameter("indate", indate);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Purdlvsch> findNeedThrowByStatus(Date indate) {
        Query query = getEntityManager().createNamedQuery("Purdlvsch.findNeedThrowByStatus");
        query.setParameter("indate", indate);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public Purdlvsch findByPK(String facno, String prono, String pono, short trseq, short schseq) {
        Query query = getEntityManager().createNamedQuery("Purdlvsch.findByPK");
        query.setParameter("facno", facno);
        query.setParameter("prono", prono);
        query.setParameter("pono", pono);
        query.setParameter("trseq", trseq);
        query.setParameter("schseq", schseq);
        try {
            Object o = query.getSingleResult();
            return (Purdlvsch) o;
        } catch (Exception ex) {
            return null;
        }
    }

}
