/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;

import cn.hanbell.crm.entity.DDGD;
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
public class DDGDBean extends SuperEJBForCRM<DDGD> {

    public DDGDBean() {
        super(DDGD.class);
    }

    public List<DDGD> findByDDGC(String gd001) {
        Query query = getEntityManager().createNamedQuery("DDGD.findByGd001");
        query.setParameter("gd001", gd001);
        try {
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

}
