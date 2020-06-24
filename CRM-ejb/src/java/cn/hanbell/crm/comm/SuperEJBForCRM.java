/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.comm;

import cn.hanbell.util.SuperEJB;
import java.io.IOException;
import java.nio.charset.UnsupportedCharsetException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;

/**
 *
 * @author C0160
 * @param <T>
 */
public abstract class SuperEJBForCRM<T> extends SuperEJB<T> {

//    private final String url = "http://localhost:8480/Hanbell-WCO/api/sendmsg/send/";//本地测试区
    private final String url = "https://i2.hanbell.com.cn/Hanbell-WCO/api/sendmsg/send/";

    @PersistenceContext(unitName = "CRM-ejbPU")
    private EntityManager em;

    public SuperEJBForCRM(Class<T> entityClass) {
        super(entityClass);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    //发送企业微信信息
    public String sendMsgString(String userId, String msg, String sessionkey, String openid) {
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url+"compltaint");
            StringBuilder jsonString = new StringBuilder("{"
                    + "'userId':'");
            jsonString.append(userId).append("','msg':'").append(msg).append("','sessionkey':'").append(sessionkey).append("','openid':'").append(openid).append("'}");
            JSONObject jo = new JSONObject(jsonString.toString());
            httpPost.setHeader("content-type", "application/json");
            httpPost.setEntity(new StringEntity(jo.toString(), "UTF-8"));
            HttpResponse response = httpclient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                return "200";
            } else {
                return "500";
            }
        } catch (IOException | UnsupportedCharsetException ex) {
            return "500";
        }
    }
}
