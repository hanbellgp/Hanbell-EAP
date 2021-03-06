/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.WARMJ;
import cn.hanbell.crm.entity.WARMQ;
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
public class WARMQBean extends SuperEJBForCRM<WARMQ>{
    
    public WARMQBean() {
        super(WARMQ.class);
    }
      public List<Object[]> findByMQ003(String MQ001) {
        StringBuffer sql=new StringBuffer("SELECT  TOP 50 * FROM ( Select DISTINCT MQ001,MQ002 from WARMQ WARMQ Left join WARMU  as WARMU on MQ001=MU001 ");
        sql.append("Where MQ003 = N'b1'   and (( MU003 = N'CRMDS' and MQ010='Y' )  or MQ010='N' ) ");
        if(MQ001!=null&&!"".equals(MQ001)){
        sql.append(" AND MQ001='").append(MQ001).append("'");
        }
        sql.append(") AS tData  order by MQ001");
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
