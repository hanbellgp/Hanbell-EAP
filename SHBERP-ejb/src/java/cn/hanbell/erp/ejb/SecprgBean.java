/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Secprg;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class SecprgBean extends SuperEJBForERP<Secprg> {

    public SecprgBean() {
        super(Secprg.class);
    }

    public Secprg findByPrgno(String prgno) {
        Query query = getEntityManager().createNamedQuery("Secprg.findByPrgno");
        query.setParameter("prgno", prgno);
        try {
            Object o = query.getSingleResult();
            return (Secprg) o;
        } catch (Exception ex) {
            return null;
        }
    }

}
