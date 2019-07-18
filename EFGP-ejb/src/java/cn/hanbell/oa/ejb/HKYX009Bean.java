/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKYX009;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class HKYX009Bean extends SuperEJBForEFGP<HKYX009> {

    public HKYX009Bean() {
        super(HKYX009.class);
    }

    //根据报价单号查询表单
    public HKYX009 findByQuono(String quono) {
        Query query = this.getEntityManager().createNamedQuery("HKYX009.findByQuono");
        query.setParameter("quono", quono);
        try {
            return (HKYX009) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }
}
