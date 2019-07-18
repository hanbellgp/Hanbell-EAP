/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.SystemModule;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class SystemModuleBean extends SuperEJBForEAP<SystemModule> {

    public SystemModuleBean() {
        super(SystemModule.class);
    }

    public List<SystemModule> findBySystemName(String value) {
        Query query = getEntityManager().createNamedQuery("SystemModule.findBySysname");
        query.setParameter("sysname", value);
        return query.getResultList();
    }

}
