/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.REPPB;
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
public class REPPBBean extends SuperEJBForCRM<REPPB> {

    public REPPBBean() {
        super(REPPB.class);
    }

    public List<REPPB> findByREPPAPK(String pa001, String pa002) {
        Query query = getEntityManager().createNamedQuery("REPPB.findByREPPAPK");
        query.setParameter("pb001", pa001);
        query.setParameter("pb002", pa002);
        try {
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

}
