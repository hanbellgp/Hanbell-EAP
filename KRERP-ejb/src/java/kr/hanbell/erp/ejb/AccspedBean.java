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
import kr.hanbell.erp.entity.Accsped;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class AccspedBean extends SuperEJBForERP<Accsped> {

    public AccspedBean() {
        super(Accsped.class);
    }

    public List<Accsped> findByAccno(String accno) {
        Query query = getEntityManager().createNamedQuery("Accsped.findByAccno");
        query.setParameter("accno", accno);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

}
