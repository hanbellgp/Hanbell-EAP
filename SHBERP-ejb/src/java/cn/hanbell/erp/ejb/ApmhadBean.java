/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Apmhad;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class ApmhadBean extends SuperEJBForERP<Apmhad> {

    public ApmhadBean() {
        super(Apmhad.class);
    }

    public Apmhad findByTrno(String facno, String vdrno, String trno) {
        Query query = this.getEntityManager().createNamedQuery("Apmhad.findByVdrnoAndTrno");
        query.setParameter("facno", facno);
        query.setParameter("vdrno", vdrno);
        query.setParameter("trno", trno);
        try {
            return (Apmhad) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}
