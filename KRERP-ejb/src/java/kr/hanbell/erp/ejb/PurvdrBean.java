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
import kr.hanbell.erp.entity.Purvdr;

/**
 *
 * @author C1491
 */
@Stateless
@LocalBean
public class PurvdrBean extends SuperEJBForERP<Purvdr> {

    public PurvdrBean() {
        super(Purvdr.class);
    }

    public Purvdr findByVdrno(String vdrno) {
        Query query = getEntityManager().createNamedQuery("Purvdr.findByVdrno");
        query.setParameter("vdrno", vdrno);
        try {
            return (Purvdr) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

    public Purvdr findByVdrds(String vdrds) {
        Query query = getEntityManager().createNamedQuery("Purvdr.findByVdrds");
        query.setParameter("vdrds", vdrds);
        try {
            return (Purvdr) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

}
