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
import kr.hanbell.erp.entity.Apmrno;

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
