/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import com.lightshell.wx.WeChatUtil;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.JsonObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author C2082
 */
@Stateless
@LocalBean
public class SENDMSGBean extends WeChatUtil {

    @Override
    protected String getAppID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String getAppSecret() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String getAppToken() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void initConfiguration() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String sendMsgString(String userId, String msg, String sessionkey, String openid) {
        String urlString = "http://localhost:8480/Hanbell-WCO/api/sendmsg/crm/compltaint"; //测试地址
       
        StringBuilder jsonString = new StringBuilder("{"
                + "'userId':'");
        jsonString.append(userId).append("','msg':'").append(msg).append("','sessionkey':'").append(sessionkey).append("','openid':'").append(openid).append("'}");
        JSONObject jo = new JSONObject(jsonString.toString());
        CloseableHttpResponse response = post(urlString, initStringEntity(jo.toString()));
        if (response != null) {
            HttpEntity httpEntity = response.getEntity();
            try {
                JSONObject jor = new JSONObject(EntityUtils.toString(httpEntity, "UTF-8"));
                int errcode = jor.getInt("code");
                if (errcode == 200) {
                    return "success";
                } else {
                    return jor.getString("errmsg");
                }
            } catch (IOException | ParseException | JSONException ex) {
                log4j.error(ex);
            } finally {
                try {
                    response.close();
                } catch (IOException ex) {
                    log4j.error(ex);
                }
            }
        }
        return "系统异常操作失败";
    }

    @Override
    public CloseableHttpResponse post(String url, HttpEntity entity) {
        HttpClient c = CertificateValidationIgnored.getNoCertificateHttpClient(url);
        this.initHttpClient();
        HttpPost httpPost = new HttpPost(url);
        if (entity != null) {
            httpPost.setEntity(entity);
        }
        try {
            HttpResponse response = c.execute(httpPost);
            System.out.println("状态码是=="+response.getStatusLine().getStatusCode());
            if (response.getStatusLine().getStatusCode() == 200) {
                return (CloseableHttpResponse) response;
            } else {
                return null;
            }
        } catch (UnsupportedEncodingException var5) {
            this.log4j.error(var5);
            return null;
        } catch (IOException var6) {
            this.log4j.error(var6);
            return null;
        }
    }

}
