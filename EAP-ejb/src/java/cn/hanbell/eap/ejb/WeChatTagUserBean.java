/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.WeChatTagUser;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.persistence.Query;

/**
 *
 * @author C1879
 */
@Stateless
@LocalBean
public class WeChatTagUserBean extends SuperEJBForEAP<WeChatTagUser> {

    public WeChatTagUserBean() {
        super(WeChatTagUser.class);
    }

    @Override
    public JsonArrayBuilder createJsonArrayBuilder(List<WeChatTagUser> entityList) {
        if (entityList == null || entityList.isEmpty()) {
            return null;
        }
        JsonArrayBuilder jab = Json.createArrayBuilder();
        for (WeChatTagUser tu : entityList) {
            jab.add(tu.getUserid());
        }
        return jab;
    }

    public JsonObjectBuilder createJsonObjectBuilder(List<WeChatTagUser> list, int tagid) {
        JsonObjectBuilder job = Json.createObjectBuilder();
        if (list != null && !list.isEmpty()) {
            job.add("tagid", tagid);
            job.add("userlist", createJsonArrayBuilder(list));
        }
        return job;
    }

    public List<WeChatTagUser> findByTagid(int tagid) {
        Query query = this.getEntityManager().createNamedQuery("WeChatTagUser.findByTagid");
        query.setParameter("tagid", tagid);
        return query.getResultList();
    }

    public List<WeChatTagUser> findByUserid(String userid) {
        Query query = this.getEntityManager().createNamedQuery("WeChatTagUser.findByUserid");
        query.setParameter("userid", userid);
        return query.getResultList();
    }

    public WeChatTagUser findByTagidAndUserid(int tagid, String userid) {
        Query query = this.getEntityManager().createNamedQuery("WeChatTagUser.findByTagidAndUserid");
        query.setParameter("tagid", tagid);
        query.setParameter("userid", userid);
        try {
            Object o = query.getSingleResult();
            return (WeChatTagUser) o;
        } catch (Exception ex) {
            return null;
        }
    }

}
