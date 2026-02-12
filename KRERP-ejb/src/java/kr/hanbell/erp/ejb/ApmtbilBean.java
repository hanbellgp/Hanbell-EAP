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
import kr.hanbell.erp.entity.Apmtbil;

/**
 *
 * @author C1491
 */
@Stateless
@LocalBean
public class ApmtbilBean extends SuperEJBForERP<Apmtbil> {

    public ApmtbilBean() {
        super(Apmtbil.class);
    }

    public Apmtbil findByPK(String facno, String bilno) {
        Query query = this.getEntityManager().createNamedQuery("Apmtbil.findByPK");
        query.setParameter("facno", facno);
        query.setParameter("bilno", bilno);
        return (Apmtbil) query.getSingleResult();
    }
}
