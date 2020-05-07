/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.SystemName;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Named
@Stateless
public class SystemNameBean extends SuperEJBForEAP<SystemName> {

    public SystemNameBean() {
        super(SystemName.class);
    }

    public SystemName authorize(String appid, String token) {
        if (appid == null || token == null) {
            return null;
        }
        Query query = getEntityManager().createNamedQuery("SystemName.findByAppidAndToken");
        query.setParameter("appid", appid);
        query.setParameter("token", token);
        try {
            Object o = query.getSingleResult();
            return (SystemName) o;
        } catch (Exception ex) {
            return null;
        }
    }

    public List<SystemName> findByNameOrDescript(String q) {
        Query query = getEntityManager().createNamedQuery("SystemName.findByNameOrDescript");
        query.setParameter("name", q);
        query.setParameter("descript", q);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public boolean isAuthorized(String appid, String token) {
        Object o = authorize(appid, token);
        return o != null;
    }

}
