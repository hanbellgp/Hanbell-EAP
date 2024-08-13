/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.edw.ejb;

import cn.hanbell.edw.comm.SuperEJBForEDW;
import cn.hanbell.edw.entity.EhsSafemanagerStandard;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C2079
 */
@Stateless
@LocalBean
public class EhsSafemanagerStandardBean extends SuperEJBForEDW<EhsSafemanagerStandard> {

    public EhsSafemanagerStandardBean() {
        super(EhsSafemanagerStandard.class);
    }

//    public List<EhsSafemanagerStandard> getTroubleNameList(String company, String syskind, String code) {
//        Query query = getEntityManager().createNamedQuery("EhsSafemanagerStandard.findBySyskindAndCodeAndCompany");
//        query.setParameter("syskind", syskind);
//        query.setParameter("parameterCode", code);
//        query.setParameter("company", company);
//        try {
//            List results = query.getResultList();
//            return results;
//        } catch (Exception ex) {
//            return null;
//        }
//    }

   

    
    

}
