/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.REPMQ;
import cn.hanbell.crm.entity.REPMU;

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
public class REPMUBean extends SuperEJBForCRM<REPMU> {

    public REPMUBean() {
        super(REPMU.class);
    }

    public List<Object[]> findByMu001(String Mu001) {
         StringBuffer sql=new StringBuffer("Select DISTINCT MQ001,MQ002,MQ008 from REPMQ REPMQ Left join REPMU  as REPMU on MQ001=MU001 Where MQ003=N'a2'  AND (( MU003=N'CRMDS' and MQ010='Y' )  or MQ010='N' ) ");
        if(Mu001!=null&&!"".equals(Mu001)){
            sql.append(" AND  MU003='").append(Mu001).append("'");
        }
         Query query = getEntityManager().createNativeQuery(sql.toString());
        try {
            List<Object[]> list = query.getResultList();
            return list;
        } catch (Exception ex) {
            return null;
        }
    }
}

