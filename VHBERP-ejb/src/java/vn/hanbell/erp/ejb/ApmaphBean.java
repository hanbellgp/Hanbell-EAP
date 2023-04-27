/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hanbell.erp.ejb;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;
import vn.hanbell.erp.comm.SuperEJBForERP;
import vn.hanbell.erp.entity.Apmapd;
import vn.hanbell.erp.entity.Apmaph;

/**
 *
 * @author C1491
 */
@Stateless
@LocalBean
public class ApmaphBean extends SuperEJBForERP<Apmaph> {

    @EJB
    private ApmapdBean apmapdBean;

    public ApmaphBean() {
        super(Apmaph.class);
    }

    public List<Apmaph> findNeedThrow(String aptyp) {
        Query query
                = this.getEntityManager().createNamedQuery("Apmaph.findNeedThrow").setFirstResult(0).setMaxResults(1);
        query.setParameter("aptyp", aptyp);
        return query.getResultList();
    }

    public List<Apmapd> findNeedThrowDetail(String facno, String apno, String aptyp) {
        apmapdBean.setCompany(facno);
        return apmapdBean.findNeedThrowDetail(facno, apno, aptyp);
    }
}
