/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Apmrno;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class ApmrnoBean extends SuperEJBForERP<Apmrno> {

    public ApmrnoBean() {
        super(Apmrno.class);
    }

    public Apmrno findMaxByPK(String facno, String scode, String maxnumber) {
        Query query = getEntityManager().createNamedQuery("Apmrno.findByPK");
        query.setParameter("facno", facno);
        query.setParameter("scode", scode);
        query.setParameter("maxnumber", maxnumber);
        try {
            return (Apmrno) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

}
