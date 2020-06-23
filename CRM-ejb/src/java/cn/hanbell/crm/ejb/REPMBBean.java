/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.REPMA;
import cn.hanbell.crm.entity.REPMB;
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
public class REPMBBean extends SuperEJBForCRM<REPMB> {

    public REPMBBean() {
        super(REPMB.class);
    }

    public List<REPMB> findByMB003(String mb003) {
        Query query = getEntityManager().createNamedQuery("REPMB.findByMb003");
        query.setParameter("mb003", mb003);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public List<REPMB> findAll(String mb001) {
        Query query = getEntityManager().createNamedQuery("REPMB.findAll");
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public REPMB findByMB001(String mb001) {
        Query query = getEntityManager().createNamedQuery("REPMB.findByMb001");
        query.setParameter("mb001", mb001);
        try {
            return (REPMB) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }
}
