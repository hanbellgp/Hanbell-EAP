/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.CRMGG;
import cn.hanbell.crm.entity.SERCA;
import cn.hanbell.crm.entity.SYSNN;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author C2082
 */
@Stateless
@LocalBean
public class SYSNNBean extends SuperEJBForCRM<SYSNN> {
    
    public SYSNNBean() {
        super(SYSNN.class);
    }
    
    
     public SYSNN findById(String id) {
        Query query = getEntityManager().createNamedQuery("SYSNN.findByNn001");
        query.setParameter("nn001", id);
        try {
            Object o = query.getSingleResult();
            return (SYSNN) o;
        } catch (Exception ex) {
            return null;
        }
    }
}
