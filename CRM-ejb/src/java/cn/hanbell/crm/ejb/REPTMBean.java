/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.REPTM;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class REPTMBean extends SuperEJBForCRM<REPTM> {

    public REPTMBean() {
        super(REPTM.class);
    }

    public REPTM findByTM002(String tm002) {
        Query query = getEntityManager().createNamedQuery("REPTM.findByTm002");
        query.setParameter("tm002", tm002);
        try {
            return (REPTM) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

}
