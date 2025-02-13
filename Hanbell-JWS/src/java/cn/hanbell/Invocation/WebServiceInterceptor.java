/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.Invocation;

import cn.hanbell.Annotation.WebServiceDescriptAnnotation;
import cn.hanbell.edw.ejb.EdwAMTBean;
import cn.hanbell.edw.entity.EdwAMT;
import com.sun.xml.ws.transport.Headers;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import javax.annotation.Priority;
import javax.ejb.EJB;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.namespace.QName;

/**
 *
 * @author C2082
 */
@Interceptor
@Priority(Interceptor.Priority.APPLICATION) // 设置优先级
public class WebServiceInterceptor {

    @EJB
    private EdwAMTBean edwatmBean;

    @AroundInvoke
    public Object logMethodInvocation(InvocationContext ctx) throws Exception {
        Headers o = (Headers) ctx.getContextData().get("com.sun.xml.ws.api.message.packet.inbound.transport.headers");
//        Map<String, Object> map = ctx.getContextData();
//        for (String a : map.keySet()) {
//            if (map.get(a) != null) {
//                System.out.print("key==" + a.toString());
//                System.out.print("value==" + map.get(a).toString());
//            }
//        }

        //完整网页路径
        String requestUrl = (String) ctx.getContextData().get("com.sun.xml.ws.transport.http.servlet.requestURL");
        requestUrl = requestUrl.substring(requestUrl.indexOf("://") + 3);
        String url = requestUrl.substring(requestUrl.indexOf("/"));
        List<String> oAWebServiceTokens = o.get("oawebservicetoken");
        Object[] params = ctx.getParameters();
        List<String> paramvalues=new ArrayList<String>();
        for(Object a : params){
            paramvalues.add(a.toString());
        }
        Method method = ctx.getMethod();
        if (oAWebServiceTokens == null || oAWebServiceTokens.size() == 0) { //OA调取 未找到cookie值
            EdwAMT amt = new EdwAMT();
            amt.setComType("WebService");
            String uuid = UUID.randomUUID().toString().replace("-", "");
            amt.setId(uuid);
            amt.setSysno("2");
            amt.setUrl(url + "?WSDL");
            amt.setFTime(new Date());
            amt.setReqId(uuid);
            amt.setStatus("0");
            amt.setReqType("POST");
            List<String> hosts = (List<String>) o.get("host");
            amt.setReqIP(String.join(";;", hosts));

            WebServiceDescriptAnnotation webServiceDescriptAnnotation = method.getAnnotation(WebServiceDescriptAnnotation.class);
            if (webServiceDescriptAnnotation == null || webServiceDescriptAnnotation.value() == "") {
                WebMethod webmethod = method.getAnnotation(WebMethod.class);
                amt.setDsc(webmethod.operationName().toString());
            } else {
                amt.setDsc(webServiceDescriptAnnotation.value());
            }
           
            List<String> paramnames = new ArrayList<String>();
            for (Parameter param : method.getParameters()) {
                WebParam WebParam = param.getAnnotation(WebParam.class);
                paramnames.add(WebParam.name());
            }

            amt.setReqContent(getWebServiceRequestContent(paramnames, paramvalues).toString().replaceAll("@webmethodname", method.getName()));
            amt.setIsAuth("0");
            amt.setRType("1");
            edwatmBean.persist(amt);
            try {
                Object result = ctx.proceed(); // 调用实际方法
                if ("200".equals(result.toString())) {
                    amt.setCTime(new Date());
                    amt.setRTime(new Date());
                    amt.setRNum(0);
                    amt.setStatus("1");
                    amt.setMsg("SUCCESS");
                    amt.setHttpCode(200);
                    amt.setHttpDesc("OK");
                     amt.setError("");
                    amt.setResContent(getWebServiceResopneContent(result.toString()).toString().replaceAll("@mothodname", method.getName()));
                } else {
                    amt.setCTime(new Date());
                    amt.setRTime(new Date());
                    amt.setRNum(0);
                    amt.setStatus("2");
                    amt.setMsg("Fail");
                    amt.setHttpCode(500);
                    amt.setHttpDesc("Fail");
                     amt.setError("");
                    amt.setResContent(getWebServiceResopneContent(result.toString()).toString().replaceAll("@mothodname", method.getName()));
                }
            } catch (Exception e) {
                amt.setCTime(new Date());
                amt.setRTime(new Date());
                amt.setRNum(0);
                amt.setStatus("2");
                amt.setMsg("Fail");
                amt.setHttpCode(500);
                amt.setHttpDesc("Fail");
                StringWriter sw = new StringWriter();
                e.printStackTrace(new PrintWriter(sw)); // 直接使用StringWriter包装PrintWriter
                String stackTrace = sw.toString(); // 获取堆栈跟踪的字符串表示
                amt.setError(stackTrace);
                amt.setResContent(getWebServiceResopneContent("500").toString().replaceAll("@mothodname", method.getName()));
            }
            edwatmBean.update(amt);
        } else {
            // 有cookie值
            String uuid = ((String) oAWebServiceTokens.get(0)).replaceAll("oAWebServiceToken=", "");
            EdwAMT amt = edwatmBean.getByUUUD(uuid);
            if (amt == null) {
                return "404";
            }
            try {
                Object result = ctx.proceed(); // 调用实际方法

                if ("200".equals(result.toString())) {
                    amt.setCTime(new Date());
                    amt.setStatus("1");
                    amt.setMsg("SUCCESS");
                    amt.setHttpCode(200);
                    amt.setHttpDesc("OK");
                    amt.setRNum(amt.getRNum() + 1);
                    amt.setRTime(new Date());
                    amt.setError("");
                    amt.setResContent(getWebServiceResopneContent(result.toString()).toString().replaceAll("@mothodname", method.getName()));
                } else {
                    amt.setCTime(new Date());
                    amt.setStatus("2");
                    amt.setMsg("Fail");
                    amt.setHttpCode(500);
                    amt.setRNum(amt.getRNum() + 1);
                    amt.setError("");
                    amt.setResContent(getWebServiceResopneContent(result.toString()).toString().replaceAll("@mothodname", method.getName()));
                    amt.setHttpDesc("Fail");
                }
                return result;
            } catch (Exception e) {
                amt.setCTime(new Date());
                amt.setStatus("2");
                amt.setMsg("Fail");
                amt.setHttpCode(500);
                amt.setRNum(amt.getRNum() + 1);
                amt.setResContent(getWebServiceResopneContent("500").toString().replaceAll("@mothodname", method.getName()));
                amt.setHttpDesc("Fail");
                StringWriter sw = new StringWriter();
                e.printStackTrace(new PrintWriter(sw)); // 直接使用StringWriter包装PrintWriter
                String stackTrace = sw.toString(); // 获取堆栈跟踪的字符串表示
                amt.setError(stackTrace);
            }
            edwatmBean.update(amt);
        }
        return "200";
    }

    public StringBuilder getWebServiceRequestContent(List<String> paramnames, List<String> paramsvalue) {

        StringBuilder content = new StringBuilder();
        content.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>").append("\n");
        content.append("<S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\"").append("\n");
        content.append("  ").append("xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\">").append("\n");
        content.append("  ").append("<SOAP-ENV:Header />").append("\n");
        content.append("  ").append("<S:Body xmlns:ns2=\"http://jws.hanbell.cn/\">").append("\n");
        content.append("    ").append("<ns2:@webmethodname xmlns:ns2=\"http://jws.hanbell.cn/\">").append("\n");
        for (int i = 0; i < paramnames.size(); i++) {
            content.append("      ").append("<").append(paramnames.get(i)).append(">").append(paramsvalue.get(i)).append("</").append(paramnames.get(i)).append(">").append("\n");
        }
        content.append("    ").append(" </ns2:@webmethodname>").append("\n");
        content.append("  ").append(" </S:Body>").append("\n");
        content.append("</S:Envelope>").append("\n");
        return content;
    }

    public StringBuilder getWebServiceResopneContent(String retrunvalue) {
        StringBuilder content = new StringBuilder();
        content.append("<?xml version='1.0' encoding='UTF-8'?>").append("\n");
        content.append("<S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\">").append("\n");
        content.append("  ").append("<S:Body>").append("\n");
        content.append("    ").append("<ns2:@mothodnameResponse xmlns:ns2=\"http://jws.hanbell.cn/\">").append("\n");
        content.append("      ").append("<return>").append(retrunvalue).append("</return>").append("\n");
        content.append("    ").append("</ns2:@mothodnameResponse>").append("\n");
        content.append("  ").append("</S:Body>").append("\n");
        content.append("</S:Envelope>").append("\n");
        return content;
    }
}
