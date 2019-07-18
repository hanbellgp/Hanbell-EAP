/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Puracd;
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
public class PuracdBean extends SuperEJBForERP<Puracd> {

    public PuracdBean() {
        super(Puracd.class);
    }

    public List<Puracd> findByAcceptno(String value) {
        Query query = getEntityManager().createNamedQuery("Puracd.findByAcceptno");
        query.setParameter("acceptno", value);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Puracd> findByAcceptnoAndItnbr(String acceptno, String itnbr) {
        Query query = getEntityManager().createNamedQuery("Puracd.findByAcceptnoAndItnbr");
        query.setParameter("acceptno", acceptno);
        query.setParameter("itnbr", itnbr);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public Puracd findByPK(String facno, String prono, String acceptno, short trseq) {
        Query query = getEntityManager().createNamedQuery("Puracd.findByPK");
        query.setParameter("facno", facno);
        query.setParameter("prono", prono);
        query.setParameter("acceptno", acceptno);
        query.setParameter("trseq", trseq);
        try {
            Puracd puracd = (Puracd) query.getSingleResult();
            return puracd;
        } catch (Exception ex) {
            return null;
        }
    }

}
