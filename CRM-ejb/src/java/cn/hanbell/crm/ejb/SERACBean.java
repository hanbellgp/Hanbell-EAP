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

    public List<Object[]> findProblemType(String BQ003_value,String AK003) {
        Query query = getEntityManager().createNativeQuery("Select AK002,AK003,AK006,AC002,AK008 FROM SERAC, SERAK WHERE AK013 <> 'Y'  AND AK001=? AND AK006 = AC001 And AK003 like ?");
        query.setParameter(1, BQ003_value);
        query.setParameter(2, new StringBuffer("%").append(AK003).append("%").toString());
        try {
            List<Object[]> o = query.getResultList();
            return o;
        } catch (Exception ex) {
            return null;
        }
    }
}
