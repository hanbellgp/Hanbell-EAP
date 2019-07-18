/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.REPTD;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class REPTDBean extends SuperEJBForCRM<REPTD> { 

    public REPTDBean() {
        super(REPTD.class);
    }

    public REPTD findByPK(String td001, String td002, String td003) {
        Query query = getEntityManager().createNamedQuery("REPTD.findByPK");
        query.setParameter("td001", td001);
        query.setParameter("td002", td002);
        query.setParameter("td003", td003);
        try {
            Object o = query.getSingleResult();
            return (REPTD) o;
        } catch (Exception e) {
            return null;
        }

    }
    
   

}
