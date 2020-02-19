/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.WechatTag;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.persistence.Query;

/**
 *
 * @author C1879
 */
@Stateless
@LocalBean
public class WechatTagBean extends SuperEJBForEAP<WechatTag> {

    public WechatTagBean() {
        super(WechatTag.class);
    }

    @Override
    public JsonObjectBuilder createJsonObjectBuilder(WechatTag entity) {
        JsonObjectBuilder job = Json.createObjectBuilder();
        if (entity != null) {
            job.add("tagname", entity.getTagname())
                    .add("tagid", entity.getId());
        }
        return job;
    }

    public WechatTag findByTagcode(String value) {
        Query query = getEntityManager().createNamedQuery("WechatTag.findByTagcode");
        query.setParameter("tagcode", value);
        try {
            Object o = query.getSingleResult();
            return (WechatTag) o;
        } catch (Exception ex) {
            return null;
        }
    }

    public WechatTag findByTagname(String value) {
        Query query = getEntityManager().createNamedQuery("WechatTag.findByTagname");
        query.setParameter("tagname", value);
        try {
            Object o = query.getSingleResult();
            return (WechatTag) o;
        } catch (Exception ex) {
            return null;
        }
    }
    

}
