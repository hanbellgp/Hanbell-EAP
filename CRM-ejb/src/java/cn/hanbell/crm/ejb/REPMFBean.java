/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.REPMF;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class REPMFBean extends  SuperEJBForCRM<REPMF>{

    public REPMFBean() {
        super(REPMF.class);
    }

   public REPMF findByItnbr(String itnbr) {
        Query query = getEntityManager().createNamedQuery("REPMF.findByMf001");
        query.setParameter("mf001", itnbr);
        try {
            return (REPMF) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }
    
}
