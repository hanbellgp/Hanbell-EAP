/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cn.hanbell.edw.jrs;

import cn.hanbell.crm.jrs.model.JSONObject;
import cn.hanbell.edw.ejb.RdpmSubjectUserReportsBean;
import cn.hanbell.edw.entity.RdpmSubjectUserReports;
import cn.hanbell.jrs.ResponseMessage;
import cn.hanbell.jrs.SuperRESTForEDW;
import com.lightshell.comm.SuperEJB;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;
import org.json.JSONArray;

/**
 *
 * @author 研发项目管理专案
 */
/**
 *
 * @author C2090
 */
@Stateless
@Path("shbedw/rdpm")
public class RdpmSubjectUserReportsREST extends SuperRESTForEDW<RdpmSubjectUserReports> {

    @EJB
    private RdpmSubjectUserReportsBean rdpmSubjectUserReportsBean;
    protected SuperEJB superEJB;

    @Override
    protected SuperEJB getSuperEJB() {
        return rdpmSubjectUserReportsBean;
    }

    public RdpmSubjectUserReportsREST() {
        super(RdpmSubjectUserReports.class);

    }

    @GET
    @Path("getRdpmSubjectUserReportsModel/{filters}/{sorts}/{offset}/{pageSize}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<RdpmSubjectUserReports> getRdpmSubjectUserReportsModel(@PathParam("filters") PathSegment filters, @PathParam("sorts") PathSegment sorts, @PathParam("offset") Integer offset, @PathParam("pageSize") Integer pageSize, @QueryParam("appid") String appid, @QueryParam("token") String token, @QueryParam("rDate") String rDate, @QueryParam("userId") String userId) {
        if (isAuthorized(appid, token)) {
            this.superEJB = rdpmSubjectUserReportsBean;
            List<RdpmSubjectUserReports> rdpmSubjectUserReportsListRes = new ArrayList<>();
            List<Object[]> list = new ArrayList<Object[]>();
            try {

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date = formatter.parse(rDate);
                rdpmSubjectUserReportsListRes = rdpmSubjectUserReportsBean.getRdpmSubjectUserReportsList(userId, rDate);
                if (rdpmSubjectUserReportsListRes.size() > 0) {
                    return rdpmSubjectUserReportsListRes;
                }
                list = rdpmSubjectUserReportsBean.getRdpmSubjectUserReportsList(userId);

                int item = 1;

                for (Object[] rE : list) {
                    RdpmSubjectUserReports uR = new RdpmSubjectUserReports();
                    UUID id = UUID.randomUUID();
                    uR.setSubjectNo(rE[0].toString());
                    uR.setSubjectName(rE[1].toString());
                    uR.setuType(rE[2].toString());
                    uR.setSubjectUserNo(rE[3].toString());
                    uR.setSubjectUserName(rE[4].toString());
                    uR.setSubjectWorkPercent(0);
                    uR.setSubjectWorkDateTime(date);
                    rdpmSubjectUserReportsListRes.add(uR);
                    uR.setId(id.toString());

                    if (item == list.size()) {//当最后一个专案时添加一个非研发工作专案
                        RdpmSubjectUserReports noUR = new RdpmSubjectUserReports();
                        UUID idNo = UUID.randomUUID();
                        noUR.setSubjectNo("01");
                        noUR.setSubjectName("非研发工作");
                        noUR.setuType(rE[2].toString());
                        noUR.setSubjectUserNo(rE[3].toString());
                        noUR.setSubjectUserName(rE[4].toString());
                        noUR.setSubjectWorkPercent(100);
                        noUR.setId(idNo.toString());
                        rdpmSubjectUserReportsListRes.add(noUR);
                    }
                    item++;
                }
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
            return rdpmSubjectUserReportsListRes;
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @POST
    @Path("saveReport")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage saveReport(JSONObject jsonObj1,@QueryParam("reportingDate")  String reportingDate, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            try {
                       SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date = formatter.parse(reportingDate);
                // 2. 提取 jsonObj1 的字符串值
                String jsonArrayStr = jsonObj1.getString("jsonObj1");
                // 3. 去除外层方括号（字符串实际是数组的字符串形式）
                jsonArrayStr = jsonArrayStr.substring(1, jsonArrayStr.length() - 1);
                // 4. 解析内层 JSON 数组
                JSONArray dataArray = new JSONArray(jsonArrayStr);
                List<RdpmSubjectUserReports> list = new ArrayList<>();
                String ITEM = "";
                for (int i = 0; i < dataArray.length(); i++) {
                    org.json.JSONObject jsonObj = (org.json.JSONObject) dataArray.get(i);
                    RdpmSubjectUserReports uR = new RdpmSubjectUserReports();
                    uR.setId(jsonObj.getString("id"));
                    uR.setSubjectWorkPercent(jsonObj.getInt("subjectWorkPercent"));
                    uR.setSubjectName(jsonObj.getString("subjectName"));
                    uR.setSubjectNo(jsonObj.getString("subjectNo"));
                    uR.setuType(jsonObj.getString("uType"));
                    uR.setSubjectUserNo(jsonObj.getString("subjectUserNo"));
                    uR.setSubjectWorkDateTime(date);
                    uR.setSubjectUserName(jsonObj.getString("subjectUserName"));
                    list.add(uR);
                }
                rdpmSubjectUserReportsBean.update(list);
                return new ResponseMessage("200", "保存成功");
            } catch (Exception e) {
                return new ResponseMessage("300", "保存失败,请重试!");
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

}
