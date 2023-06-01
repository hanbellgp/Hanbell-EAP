/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hanbell.erp.ejb;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;
import vn.hanbell.erp.comm.SuperEJBForERP;
import vn.hanbell.erp.entity.Apmapd;

/**
 *
 * @author C1491
 */
@Stateless
@LocalBean
public class ApmapdBean extends SuperEJBForERP<Apmapd> {

    public ApmapdBean() {
        super(Apmapd.class);
    }

    public List<Apmapd> findNeedThrowDetail(String facno, String apno, String aptyp) {
        Query query = this.getEntityManager().createNamedQuery("Apmapd.findByNeedThrowDetail");
        query.setParameter("facno", facno);
        query.setParameter("apno", apno);
        query.setParameter("aptyp", aptyp);
        return query.getResultList();
    }

}
