/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.CRMGD;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class CRMGDBean extends SuperEJBForCRM<CRMGD> {

    public CRMGDBean() {
        super(CRMGD.class);
    }

    public List<CRMGD> findByCRMGG(String gd002) {
        Query query = getEntityManager().createNamedQuery("CRMGD.findByGd002");
        query.setParameter("gd002", gd002);
        try {
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
}
