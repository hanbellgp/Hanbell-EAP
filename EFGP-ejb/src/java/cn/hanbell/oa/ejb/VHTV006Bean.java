/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.VHTV006;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class VHTV006Bean extends SuperEJBForEFGP<VHTV006> {

    public VHTV006Bean() {
        super(VHTV006.class);
    }

    //根据报价单号查询表单
    public VHTV006 findByQuono(String quono) {
        Query query = this.getEntityManager().createNamedQuery("VHTV006.findByQuono");
        query.setParameter("quono", quono);
        try {
            return (VHTV006) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }
}
