/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.REPMQ;
import cn.hanbell.crm.entity.WARTA;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class REPMQBean extends SuperEJBForCRM<REPMQ> {

    public REPMQBean() {
        super(REPMQ.class);
    }

    //客诉单别
    public List<Object[]> findForm(String MQ001) {
        StringBuffer sql=new StringBuffer("Select DISTINCT MQ001,MQ002 from REPMQ Left join  REPMU on MQ001=MU001 Where MQ003=N'a1'and (( MU003=N'CRMDS' and MQ010='Y' )  or MQ010='N' )");
        if(MQ001!=null&&!"".equals(MQ001)){
            sql.append(" AND  MQ001='").append(MQ001).append("'");
        }
         Query query = getEntityManager().createNativeQuery(sql.toString());
        try {
            List<Object[]> list = query.getResultList();
            return list;
        } catch (Exception ex) {
            return null;
        }
    }

    //维修单别
    public List<Object[]> findMaintainForm() {
        Query query = getEntityManager().createNativeQuery("SELECT  TOP 50 * FROM ( Select DISTINCT MQ001,MQ002,MQ008 from REPMQ REPMQ Left join REPMU  as REPMU on MQ001=MU001 Where MQ003=N'a2' and (( MU003=N'CRMDS' and MQ010='Y' )  or MQ010='N' ) ) AS tData  order by MQ001");
        try {
            List<Object[]> list = query.getResultList();
            return list;
        } catch (Exception ex) {
            return null;
        }
    }
}
