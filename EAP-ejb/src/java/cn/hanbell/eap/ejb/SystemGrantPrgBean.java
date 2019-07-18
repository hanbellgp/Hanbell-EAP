/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.SystemGrantPrg;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class SystemGrantPrgBean extends SuperEJBForEAP<SystemGrantPrg> {

    public SystemGrantPrgBean() {
        super(SystemGrantPrg.class);
    }

    public List<SystemGrantPrg> findByUserId(int id) {
        Query query = this.getEntityManager().createNamedQuery("SystemGrantPrg.findByUserId");
        query.setParameter("userid", id);
        return query.getResultList();
    }

    public List<SystemGrantPrg> findByRoleId(int id) {
        Query query = this.getEntityManager().createNamedQuery("SystemGrantPrg.findByRoleId");
        query.setParameter("roleid", id);
        return query.getResultList();
    }

    public List<SystemGrantPrg> findBySystemNameAndUserId(String sysname, int id) {
        Query query = this.getEntityManager().createNamedQuery("SystemGrantPrg.findBySystemNameAndUserId");
        query.setParameter("sysname", sysname);
        query.setParameter("userid", id);
        return query.getResultList();
    }

    public List<SystemGrantPrg> findBySystemNameAndRoleId(String sysname, int id) {
        Query query = this.getEntityManager().createNamedQuery("SystemGrantPrg.findBySystemNameAndRoleId");
        query.setParameter("sysname", sysname);
        query.setParameter("roleid", id);
        return query.getResultList();
    }

}
