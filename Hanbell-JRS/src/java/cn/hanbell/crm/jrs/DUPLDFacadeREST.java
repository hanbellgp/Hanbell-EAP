/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.jrs;

import cn.hanbell.crm.ejb.DUPLDBean;
import cn.hanbell.crm.entity.DUPLD;
import cn.hanbell.jrs.ResponseMessage;
import cn.hanbell.jrs.SuperRESTForCRM;
import cn.hanbell.util.BaseLib;
import cn.hanbell.util.SuperEJB;
import java.math.BigDecimal;
import java.util.Date;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author C2082
 */
@Path("crm/dupld")
@javax.enterprise.context.RequestScoped
public class DUPLDFacadeREST extends SuperRESTForCRM<DUPLD> {

    @EJB
    private DUPLDBean dupldBean;

    public DUPLDFacadeREST() {
        super(DUPLD.class);
    }

    @Override
    protected SuperEJB getSuperEJB() {
        return dupldBean;
    }

    /**
     * 照片上传
     *
     * @param jsonRequest
     * @return
     */
    @POST
    @Path("upload")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage uploadEqpRepairPic(String jsonRequest) {
        try {
            JSONObject requestedJSON = new JSONObject(jsonRequest);
            JSONArray jsa = requestedJSON.getJSONArray("entityList");
            StringBuffer msg=new StringBuffer("【上海汉钟】 维修单：");
            msg.append(jsa.getJSONObject(0).getString("maintainType")).append("-").append(jsa.getJSONObject(0).getString("maintainNumber"));
            msg.append(" 附件已上传成功。详情请点击以下链接查看。\\\\n");
            for (int i = 0; i < jsa.length(); i++) {
                JSONObject o = jsa.getJSONObject(i);
                DUPLD dupld = new DUPLD();
                dupld.setCompany(o.getString("company"));
                dupld.setCreator(o.getString("employeeId"));
                dupld.setCreateDate(BaseLib.formatDate("yyyyMMdd", new Date()));
                dupld.setFlag(Short.valueOf("1"));
                dupld.setLd001(BigDecimal.valueOf(i + 1));
                dupld.setLd002(o.getString("maintainType"));
                dupld.setLd003(o.getString("maintainNumber"));
                dupld.setLd004(o.getString("employeeId"));
                dupld.setLd005(BaseLib.formatDate("yyyyMMdd", new Date()));
                dupld.setLd006(o.getString("uuid"));
                dupld.setDs007(o.getString("url"));
                dupld.setDs008(o.getString("filename"));
                msg.append("<a href=\"");
                msg.append(dupld.getDs007()).append("\">图片").append(i+1).append("</a>   ");
                dupldBean.persist(dupld);
            }
             dupldBean.sendMsgString(jsa.getJSONObject(0).getString("employeeId"), msg.toString(),requestedJSON.getString("sessionkey") , requestedJSON.getString("openid"));
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseMessage("500", "上传失败");
        }
        return new ResponseMessage("200", "文件已经上传成功");
    }
    
}
