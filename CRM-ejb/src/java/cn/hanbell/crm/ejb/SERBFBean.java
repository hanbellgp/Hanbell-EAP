/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.SERBF;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author C2082
 */
@Stateless
@LocalBean
public class SERBFBean extends SuperEJBForCRM<SERBF>{
    
    public SERBFBean() {
        super(SERBF.class);
    }
    
    public List<SERBF> findByBF002(String bf002){
        Query query = getEntityManager().createNamedQuery("SERBF.findByBf002");
        query.setParameter("bf002", bf002);
        try {
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
}
