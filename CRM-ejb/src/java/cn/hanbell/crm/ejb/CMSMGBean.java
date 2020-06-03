/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.CMSMG;
import cn.hanbell.crm.entity.CMSMV;
import cn.hanbell.crm.entity.DDGB;
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
public class CMSMGBean extends SuperEJBForCRM<CMSMG>{
    
    public CMSMGBean() {
        super(CMSMG.class);
    }
      public List<CMSMG> findByMG001(String mg001) {
        Query query = getEntityManager().createNamedQuery("CMSMG.findByMg001");
        query.setParameter("mg001", mg001);
        try {
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
    
}
