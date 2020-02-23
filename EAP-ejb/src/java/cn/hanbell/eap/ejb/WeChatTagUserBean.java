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

    public JsonObjectBuilder createJsonObjectBuilder(List<WeChatTagUser> list, int tagid) {
        JsonObjectBuilder job = Json.createObjectBuilder();
        if (list != null && !list.isEmpty()) {
            if (list.size() > 1) {
                job.add("tagid", tagid);
                StringBuilder listjs = new StringBuilder();
                for (WeChatTagUser tgr : list) {
                    if (list.indexOf(tgr) == 0) {
                        listjs.append("[\"").append(tgr.getUserid()).append("\"");
                        continue;
                    }
                    if (list.size() - 1 == list.indexOf(tgr)) {
                        listjs.append(",\"").append(tgr.getUserid()).append("\"]");
                        continue;
                    }
                    listjs.append(",\"").append(tgr.getUserid()).append("\"");
                }
                if (listjs.length() > 0 && !"".equals(listjs.toString())) {
                    job.add("userlist", listjs.toString());
                }
            } else {
                job = createJsonObjectBuilder(list.get(0));
            }
        }
        return job;
    }
    
    

    @Override
    public JsonObjectBuilder createJsonObjectBuilder(WeChatTagUser taguser) {
        JsonObjectBuilder job = Json.createObjectBuilder();
        job.add("tagid", taguser.getTagid());
        job.add("userlist", "[\"" + taguser.getUserid() + "\"]");
        return job;
    }

    public List<WeChatTagUser> findByTagid(int tagid) {
        Query query = this.getEntityManager().createNamedQuery("WechatTagUser.findByTagid");
        query.setParameter("tagid", tagid);
        return query.getResultList();
    }

    public List<WeChatTagUser> findByUserid(String userid) {
        Query query = this.getEntityManager().createNamedQuery("WechatTagUser.findByUserid");
        query.setParameter("userid", userid);
        return query.getResultList();
    }

    public WeChatTagUser findByTagidAndUserid(int tagid, String userid) {
        Query query = this.getEntityManager().createNamedQuery("WechatTagUser.findByTagidAndUserid");
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
