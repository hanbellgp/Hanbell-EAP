/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.CMSMV;
import cn.hanbell.crm.entity.CRMGA;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author C2082
 */
public class CRMGABean  extends SuperEJBForCRM<CRMGA> {
    
    public CRMGABean() {
        super(CRMGA.class);
    }
    
public List<Object[]> findByGA001() {
        StringBuffer sql=new StringBuffer("SELECT  TOP 50 * FROM ( Select GA002,GA003 from CRMGA CRMGA Where (GA001='2B') ) AS tData  order by GA002");
        Query query = getEntityManager().createNativeQuery(sql.toString());
        try {
            List<Object[]> objs=query.getResultList();
            return objs;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    
}
