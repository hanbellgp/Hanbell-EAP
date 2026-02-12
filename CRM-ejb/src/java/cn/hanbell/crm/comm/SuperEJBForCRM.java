/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.comm;

import cn.hanbell.util.SuperEJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import org.apache.http.client.methods.CloseableHttpResponse;
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

    // 生产环境
    private final String URL = "http://jrs.hanbell.com.cn/Hanbell-WCO/api/sendmsg/send";
    // 测试环境
    //private final String URL = "http://i2.hanbell.com.cn:8480/Hanbell-WCO/api/sendmsg/send";

    protected String company = "C";

    @PersistenceContext(unitName = "CRM-PUSHB")
    private EntityManager em_shbcrm;

    @PersistenceContext(unitName = "CRM-PUCX")
    private EntityManager em_cxcrm;

    @PersistenceContext(unitName = "CRM-PUHS")
    private EntityManager em_hscrm;

    @PersistenceContext(unitName = "CRM-PUTHB")
    private EntityManager em_thbcrm;

    public SuperEJBForCRM(Class<T> entityClass) {
        super(entityClass);
    }

    @Override
    public EntityManager getEntityManager() {
        return getEntityManager(getCompany());
    }

    // 发送企业微信信息
    public String sendMsgString(String userId, String msg, String sessionkey, String openid)
            throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException {
        StringBuilder jsonString = new StringBuilder("{'userId':'");
        jsonString.append(userId).append("','msg':'").append(msg).append("','sessionkey':'").append(sessionkey)
                .append("','openid':'").append(openid).append("'}");
        JSONObject jo = new JSONObject(jsonString.toString());
        HttpPost httpPost = new HttpPost(URL);
        httpPost.setHeader("content-type", "application/json");
        httpPost.setEntity(new StringEntity(jo.toString(), "UTF-8"));
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == 200) {
                return "200";
            } else {
                return "500";
            }
        } catch (Exception var5) {

            return null;
        }
    }

    protected EntityManager getEntityManager(String facno) {
        switch (facno) {
            case "A":
                return em_thbcrm;
            case "C":
                return em_shbcrm;
            case "F":
                return em_cxcrm;
            case "H":
                return em_hscrm;
            default:
                return em_shbcrm;
        }
    }

    /**
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(String company) {
        this.company = company;
    }
}
