/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.CrmUserGroup;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class CrmUserGroupBean extends SuperEJBForEAP<CrmUserGroup> {

    public CrmUserGroupBean() {
        super(CrmUserGroup.class);
    }

    public CrmUserGroup findByUserid(String userid) {
        Query query = getEntityManager().createNamedQuery("CrmUserGroup.findByUserid");
        query.setParameter("userid", userid);
        try {
            return (CrmUserGroup) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

    public boolean checkStatus(String userid) {
        CrmUserGroup u = findByUserid(userid);
        if (u == null) {
            return false;
        }
        if (u.getStatus().equals("N")) {
            return false;
        }
        return true;
    }

}
