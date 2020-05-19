/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.ecpur.ejb;

import java.io.IOException;
import java.nio.charset.UnsupportedCharsetException;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

/**
 *
 * @author Administrator
 */
@Startup
@Singleton
public class ECPurvdrBean {

    protected final Logger log4j = LogManager.getLogger();

    public ECPurvdrBean() {

    }

    //回写电子采购平台
    public String ECPostBack(String url, JSONObject jsonObject) {
        try {
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("content-type", "application/json");
            httpPost.setEntity(new StringEntity(jsonObject.toString(), "UTF-8"));
            HttpClient httpCient = HttpClients.createDefault();
            HttpResponse response = httpCient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                //System.out.println("测试update-alarm成功");
                //log4j.info(String.format("执行RootCloudBean中的方法updateAlarm成功,参数1:%s,参数2:%s,参数3:%s,返回内容:%s", deviceId, alarmId, status, "200"));
                return "200";
            } else {
                log4j.info(String.format("执行ECPurvdrBean中的方法ECPostBack异常,参数1:%s,参数2:%s,返回内容:%s", url, jsonObject, String.valueOf(response.getStatusLine().getStatusCode())));
            }

        } catch (IOException | UnsupportedCharsetException ex) {
            log4j.error("执行ECPostBack中的方法ECPostback失败", ex);
        }
        return "";
    }
}
