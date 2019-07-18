/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Cdrcitnbr;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class CdrcitnbrBean extends SuperEJBForERP<Cdrcitnbr> {

    public CdrcitnbrBean() {
        super(Cdrcitnbr.class);
    }

    public Cdrcitnbr findByPK(String cusno, String itnbr, String itnbrcus) {
        Query query = getEntityManager().createNamedQuery("Cdrcitnbr.findByPK");
        query.setParameter("cusno", cusno);
        query.setParameter("itnbr", itnbr);
        query.setParameter("itnbrcus", itnbrcus);
        try {
            Object o = query.getSingleResult();
            return (Cdrcitnbr) o;
        } catch (Exception ex) {
            return null;
        }
    }

}
