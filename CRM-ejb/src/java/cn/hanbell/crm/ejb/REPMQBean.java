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
public class REPMQBean extends SuperEJBForCRM<REPMQ>{

    public REPMQBean() {
        super(REPMQ.class);
    }
    
    public List<Map<String,Object>> findForm() {
       Query query=getEntityManager().createNativeQuery( "Select DISTINCT r from REPMQ r Left join  REPMU on MQ001=MU001 Where MQ003=N'a1'and (( MU003=N'CRMDS' and MQ010='Y' )  or MQ010='N' ) ");
        try {
           List<Map<String,Object>> list = query.getResultList();
            return  list;
        } catch (Exception ex) {
            return null;
        }
    }
}
