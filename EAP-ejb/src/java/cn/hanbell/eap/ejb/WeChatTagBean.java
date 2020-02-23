/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.WeChatTag;
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
public class WeChatTagBean extends SuperEJBForEAP<WeChatTag> {

    public WeChatTagBean() {
        super(WeChatTag.class);
    }

    @Override
    public JsonObjectBuilder createJsonObjectBuilder(WeChatTag entity) {
        JsonObjectBuilder job = Json.createObjectBuilder();
        if (entity != null) {
            job.add("tagname", entity.getTagname())
                    .add("tagid", entity.getId());
        }
        return job;
    }

    public WeChatTag findByTagcode(String value) {
        Query query = getEntityManager().createNamedQuery("WechatTag.findByTagcode");
        query.setParameter("tagcode", value);
        try {
            Object o = query.getSingleResult();
            return (WeChatTag) o;
        } catch (Exception ex) {
            return null;
        }
    }

    public WeChatTag findByTagname(String value) {
        Query query = getEntityManager().createNamedQuery("WechatTag.findByTagname");
        query.setParameter("tagname", value);
        try {
            Object o = query.getSingleResult();
            return (WeChatTag) o;
        } catch (Exception ex) {
            return null;
        }
    }

}
