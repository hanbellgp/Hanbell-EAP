/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.SystemProgram;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
public class SystemProgramBean extends SuperEJBForEAP<SystemProgram> {

    public SystemProgramBean() {
        super(SystemProgram.class);
    }

    public SystemProgram findByAPI(String api) {
        Query query = getEntityManager().createNamedQuery("SystemProgram.findByAPI");
        query.setParameter("api", api);
        try {
            return (SystemProgram) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public List<SystemProgram> findByModuleId(int id) {
        Query query = getEntityManager().createNamedQuery("SystemProgram.findByModuleId");
        query.setParameter("moduleid", id);
        return query.getResultList();
    }

    public SystemProgram findBySystemAndAPI(String sysname, String api) {
        Query query = getEntityManager().createNamedQuery("SystemProgram.findBySystemAndAPI");
        query.setParameter("sysname", sysname);
        query.setParameter("api", api);
        try {
            return (SystemProgram) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}
