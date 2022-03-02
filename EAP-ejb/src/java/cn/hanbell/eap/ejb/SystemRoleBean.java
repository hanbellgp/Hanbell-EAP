/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.SystemRole;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class SystemRoleBean extends SuperEJBForEAP<SystemRole> {

    public SystemRoleBean() {
        super(SystemRole.class);
    }

    public SystemRole findById(int id) {
        Query query = getEntityManager().createNamedQuery("SystemRole.findById");
        query.setParameter("id", id);
        return (SystemRole) query.getSingleResult();
    }

}
