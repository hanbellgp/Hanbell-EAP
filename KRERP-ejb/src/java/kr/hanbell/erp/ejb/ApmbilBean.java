/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kr.hanbell.erp.ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;
import kr.hanbell.erp.comm.SuperEJBForERP;
import kr.hanbell.erp.entity.Apmbil;

/**
 *
 * @author C1491
 */
@Stateless
@LocalBean
public class ApmbilBean extends SuperEJBForERP<Apmbil> {
    
    @EJB
    private ApmaphBean vhbapmaphBean;
    @EJB
    private ApmapdBean vhbapmapdBean;
    @EJB
    private ApmtbilBean vhbapmtbilBean;

    public ApmbilBean() {
        super(Apmbil.class);
    }

    public Apmbil findByPK(String facno, String bilno) {
        Query query = this.getEntityManager().createNamedQuery("Apmbil.findByPK");
        query.setParameter("facno", facno);
        query.setParameter("bilno", bilno);
        try {
            return (Apmbil) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}
