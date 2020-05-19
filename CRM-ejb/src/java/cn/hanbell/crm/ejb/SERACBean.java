/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.CRMGG;
import cn.hanbell.crm.entity.SERAC;
import cn.hanbell.crm.entity.WARMA;
import java.util.List;
import java.util.Map;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author C2082
 */
@Stateless
@LocalBean
public class SERACBean extends SuperEJBForCRM<SERAC> {

    public SERACBean() {
        super(SERAC.class);
    }

    public List<Map<String, String>> findProblemType(String BQ003_value) {
//        Query query = getEntityManager().createNativeQuery("Select * FROM SERAC s, SERAK c WHERE AK013 <> 'Y'  AND AK001=:BQ003_value AND AK006 = AC001");
//        query.setParameter("BQ003_value", BQ003_value);
//        try {
//          List<Map<String,String>>  o = query.getResultList();
//            return  o;
//        } catch (Exception ex) {
//            return null;
//        }
        return null;
    }
}
