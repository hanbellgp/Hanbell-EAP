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

    public List<REPMU> findByMu001(String Mu001) {
        Query query = getEntityManager().createNamedQuery("REPMU.findByMu003");
        query.setParameter("mu003", Mu001);
        try {
            List<REPMU> list=query.getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

