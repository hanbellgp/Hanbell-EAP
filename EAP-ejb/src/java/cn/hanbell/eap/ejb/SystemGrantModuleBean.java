/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.SystemGrantModule;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
public class SystemGrantModuleBean extends SuperEJBForEAP<SystemGrantModule> {

    public SystemGrantModuleBean() {
        super(SystemGrantModule.class);
    }

    public int getRowCountByUserId(int id) {
        Query query = getEntityManager().createNamedQuery("SystemGrantModule.getRowCountByUserId");
        query.setParameter("userid", id);
        try {
            return Integer.parseInt(query.getSingleResult().toString());
        } catch (Exception e) {
            return 0;
        }
    }

    public List<SystemGrantModule> findByUserId(int id) {
        Query query = this.getEntityManager().createNamedQuery("SystemGrantModule.findByUserId");
        query.setParameter("userid", id);
        return query.getResultList();
    }

    public List<SystemGrantModule> findByRoleId(int id) {
        Query query = this.getEntityManager().createNamedQuery("SystemGrantModule.findByRoleId");
        query.setParameter("roleid", id);
        return query.getResultList();
    }

    public List<SystemGrantModule> findBySystemNameAndUserId(String sysname, int id) {
        Query query = this.getEntityManager().createNamedQuery("SystemGrantModule.findBySystemNameAndUserId");
        query.setParameter("sysname", sysname);
        query.setParameter("userid", id);
        return query.getResultList();
    }

    public List<SystemGrantModule> findBySystemNameAndRoleId(String sysname, int id) {
        Query query = this.getEntityManager().createNamedQuery("SystemGrantModule.findBySystemNameAndRoleId");
        query.setParameter("sysname", sysname);
        query.setParameter("roleid", id);
        return query.getResultList();
    }

}
