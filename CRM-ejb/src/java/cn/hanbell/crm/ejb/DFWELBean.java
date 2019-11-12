/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.DFWEL;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class DFWELBean extends SuperEJBForCRM<DFWEL> {

    public DFWELBean() {
        super(DFWEL.class);
    }

    public DFWEL findByEl001(String el001) {
        Query query = getEntityManager().createNamedQuery("DFWEL.findByEl001");
        query.setParameter("el001", el001);
        try {
            return (DFWEL) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }

    }

}
