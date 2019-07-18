/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Apmapd;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
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

    public Apmapd findByPK(String facno, String apno, String aptyp, String trseq) {
        Query query = this.getEntityManager().createNamedQuery("Apmapd.findByPK");
        query.setParameter("facno", facno);
        query.setParameter("apno", apno);
        query.setParameter("aptyp", aptyp);
        query.setParameter("trseq", trseq);
        return (Apmapd) query.getSingleResult();
    }

}
