/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Apmtbil;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
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
