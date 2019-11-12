/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.PORBG;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class PORBGBean extends SuperEJBForCRM<PORBG> {

    public PORBGBean() {
        super(PORBG.class);
    }

    public PORBG findByBG001(String bg001) {
        Query query = getEntityManager().createNamedQuery("PORBG.findByBg001");
        query.setParameter("bg001", bg001);
        try {
            return (PORBG) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }

    }

}
