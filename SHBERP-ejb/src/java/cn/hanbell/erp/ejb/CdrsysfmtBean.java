/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Cdrsysfmt;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class CdrsysfmtBean extends SuperEJBForERP<Cdrsysfmt> {

    public CdrsysfmtBean() {
        super(Cdrsysfmt.class);
    }

    public Cdrsysfmt getByFacno(String facno) {
        Query query = this.getEntityManager().createNamedQuery("Cdrsysfmt.findByFacno");
        query.setParameter("facno", facno);
        try {
            return (Cdrsysfmt) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}
