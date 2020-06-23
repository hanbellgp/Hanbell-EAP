/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.REPMB;
import cn.hanbell.crm.entity.REPMQ;
import cn.hanbell.crm.entity.WARMB;
import cn.hanbell.crm.entity.WARMJ;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author C2082
 */
//
@Stateless
@LocalBean
public class WARMJBean  extends SuperEJBForCRM<WARMJ>{
      public WARMJBean() {
        super(WARMJ.class);
    }
      
      public List<Object[]> findLikeMJ002(String mj002) {
        StringBuffer sql=new StringBuffer("SELECT MJ001,MJ002 FROM WARMJ");
        if(mj002!=null&&!"".equals(mj002)){
            sql=sql.append(" where MJ002 like '%").append(mj002).append("%'");
        }
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
