/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eam.jrs;

import cn.hanbell.eam.ejb.EquipmentAnalyResultBean;
import cn.hanbell.eam.ejb.EquipmentAnalyResultDtaBean;
import cn.hanbell.eam.entity.EquipmentAnalyResult;
import cn.hanbell.eam.entity.EquipmentAnalyResultDta;
import cn.hanbell.jrs.ResponseMessage;
import cn.hanbell.jrs.SuperRESTForEAM;
import com.lightshell.comm.SuperEJB;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author C2090
 */
@Stateless
@Path("shbeam/eqpmaintenance")
public class EquipmentMaintenanceFacadeREST extends SuperRESTForEAM<EquipmentAnalyResult> {
    @EJB
    private EquipmentAnalyResultBean equipmentAnalyResultBean;

    @EJB
    private EquipmentAnalyResultDtaBean equipmentAnalyResultDtaBean;

    protected SuperEJB superEJB;

    @Override
    protected SuperEJB getSuperEJB() {
        return equipmentAnalyResultBean;
    }


    public EquipmentMaintenanceFacadeREST() {
        super(EquipmentAnalyResult.class);
    }

    @GET
    @Path("autonomous-maintain-tasks/{filters}/{sorts}/{offset}/{pageSize}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<EquipmentAnalyResult> getAutonomousMaintainDocList(@PathParam("filters") PathSegment filters, @PathParam("sorts") PathSegment sorts, @PathParam("offset") Integer offset, @PathParam("pageSize") Integer pageSize, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            this.superEJB = equipmentAnalyResultBean;
            List<EquipmentAnalyResult> autoMaintainDocListRes = new ArrayList<>();
            try {
                Map<String, Object> filterFields = getFilterFieldsMap(filters);
                Map<String, String> sortFields = getSortFieldsMap(sorts);
                
                autoMaintainDocListRes = equipmentAnalyResultBean.getEquipmentAnalyResultListByNativeQuery(filterFields,sortFields);
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
            return autoMaintainDocListRes;
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("autonomous-maintain-detailinfo/{filters}/{sorts}/{offset}/{pageSize}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<Object> getAutonomousMaintainInitDta(@PathParam("filters") PathSegment filters, @PathParam("sorts") PathSegment sorts, @PathParam("offset") Integer offset, @PathParam("pageSize") Integer pageSize, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            List<Object> initDtaRes = new ArrayList<Object>();
            this.superEJB = equipmentAnalyResultBean;
            EquipmentAnalyResult autoMaintainInfo;
            List<EquipmentAnalyResultDta> autoMaintainDetailList = new ArrayList<>();
            try {
                Map<String, Object> filterFields = getFilterFieldsMap(filters);

                autoMaintainInfo = equipmentAnalyResultBean.findById(Integer.parseInt(filterFields.get("docId").toString()));
                if(autoMaintainInfo != null){
                    Map<String, Object> filterFields_detail = new HashMap<>();
                    Map<String, String> sortFields_detail = new LinkedHashMap<>();
                    filterFields_detail.put("pid", autoMaintainInfo.getFormid());
                    sortFields_detail.put("seq", "ASC");
                    autoMaintainDetailList = equipmentAnalyResultDtaBean.findByFilters(filterFields_detail, sortFields_detail);
                    initDtaRes.add(autoMaintainInfo);
                    initDtaRes.add(autoMaintainDetailList);
                }
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
            return initDtaRes;
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @POST
    @Path("autonomous-maintain-start")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage updateEqpMaintenance_autoMaintain(EquipmentAnalyResult entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            if (entity == null) {
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }

            try {
                Date minOptDate = new Date();
                EquipmentAnalyResult autoMaintainInfo = equipmentAnalyResultBean.findById(entity.getId());
                if (autoMaintainInfo == null) {
                    throw new WebApplicationException(Response.Status.BAD_REQUEST);
                }
                EquipmentAnalyResultDta autoMaintainDetail;
                JSONArray jsonArray = new JSONArray(entity.getStatus());
                JSONArray eqpMaintainDetailList_jsonArray = jsonArray.getJSONArray(0);
                String dateStrTemp = "";
                String resultStrTemp = "";
                String mainResultTemp = "正常";
                boolean completeFlag = true;
                boolean startFlag = false;
                for(Object obj : eqpMaintainDetailList_jsonArray){
                    JSONObject jsonObject = (JSONObject) obj;
                    autoMaintainDetail = equipmentAnalyResultDtaBean.findById(jsonObject.getInt("Id"));
                    resultStrTemp = jsonObject.getString("result");
                    if(resultStrTemp.equals("正常") || resultStrTemp.equals("异常")){
                        startFlag = true;
                        if(!resultStrTemp.equals("正常")){
                            mainResultTemp = "异常";
                        }
                        autoMaintainDetail.setAnalysisresult(resultStrTemp);
                    }
                    autoMaintainDetail.setException(jsonObject.getString("exception"));
                    autoMaintainDetail.setProblemsolve(jsonObject.getString("problemSolve"));

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd  HH:mm");
                    dateStrTemp = jsonObject.getString("sDate");
                    if(dateStrTemp != null && !dateStrTemp.isEmpty()){
                        Date startDateTemp = sdf.parse(dateStrTemp);
                        autoMaintainDetail.setSdate(startDateTemp);
                        if(startDateTemp.compareTo(minOptDate) < 0){
                            minOptDate = startDateTemp;
                        }
                    }
                    dateStrTemp = jsonObject.getString("eDate");
                    if(dateStrTemp != null && !dateStrTemp.isEmpty()){
                        autoMaintainDetail.setEdate(sdf.parse(dateStrTemp));
                    }
                }

                //先刷新容器更新数据库
                equipmentAnalyResultDtaBean.getEntityManager().flush();
                equipmentAnalyResultDtaBean.getEntityManager().clear ();

                //遍历表身判断单据是否已经完成
                List<EquipmentAnalyResultDta> analyResultDtaList =  equipmentAnalyResultDtaBean.findByPId(autoMaintainInfo.getFormid());
                for(EquipmentAnalyResultDta dtaObj : analyResultDtaList){
                     if(!("正常".equals(dtaObj.getAnalysisresult()) || "异常".equals(dtaObj.getAnalysisresult()))){
                        completeFlag = false;
                    }
                }

                if (completeFlag) {
                    autoMaintainInfo.setAnalysisresult(mainResultTemp);
                    autoMaintainInfo.setEnddate(new Date());
                    autoMaintainInfo.setStatus("V");
                } else if (startFlag && autoMaintainInfo.getStatus().equals("N")) {
                    autoMaintainInfo.setStatus("S");
                }
                if (autoMaintainInfo.getStartdate() == null) {//只有开始时间为空时更新开始时间
                    autoMaintainInfo.setStartdate(minOptDate);
                }
                autoMaintainInfo.setOptdate(new Date());
                autoMaintainInfo.setOptuser(entity.getOptuser());
                equipmentAnalyResultBean.update(autoMaintainInfo);

                return new ResponseMessage("200", "状态更新成功");
            } catch (Exception ex) {
                return new ResponseMessage("500", "系统错误Update失败");
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @POST
    @Path("autonomous-maintain-dispatch")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage updateEqpMaintenance_userDispatch(EquipmentAnalyResult entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            if (entity == null) {
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }

            try {
                EquipmentAnalyResult autoMaintainInfo = equipmentAnalyResultBean.findById(entity.getId());
                if (autoMaintainInfo == null) {
                    throw new WebApplicationException(Response.Status.BAD_REQUEST);
                }
                EquipmentAnalyResultDta autoMaintainDetail;
                JSONArray jsonArray = new JSONArray(entity.getStatus());
                JSONArray eqpMaintainDetailList_jsonArray = jsonArray.getJSONArray(0);
                String resultStrTemp = "";
                for (Object obj : eqpMaintainDetailList_jsonArray) {
                    JSONObject jsonObject = (JSONObject) obj;
                    autoMaintainDetail = equipmentAnalyResultDtaBean.findById(jsonObject.getInt("Id"));
                    resultStrTemp = jsonObject.getString("result");
                    //已经完成的不能派工
                    if (resultStrTemp.equals("正常") || resultStrTemp.equals("异常")) {
                        continue;
                    }
                    autoMaintainDetail.setAnalysisuser(jsonObject.getString("analysisUser"));
                    autoMaintainDetail.setLastanalysisuser(jsonObject.getString("analysisUserName"));
                }

                autoMaintainInfo.setOptdate(new Date());
                autoMaintainInfo.setOptuser(entity.getOptuser());

                return new ResponseMessage("200", "状态更新成功");
            } catch (Exception ex) {
                return new ResponseMessage("500", "系统错误Update失败");
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    private HashMap getFilterFieldsMap(PathSegment filters) {
        try {
            MultivaluedMap<String, String> filtersMM = filters.getMatrixParameters();
            HashMap<String, Object> filterFields = new HashMap<>();
            String key, value = "";
            if (filtersMM != null) {
                for (Map.Entry<String, List<String>> entrySet : filtersMM.entrySet()) {
                    key = entrySet.getKey();
                    value = entrySet.getValue().get(0);
                    if (key.contains("dateBegin") || key.contains("dateEnd")) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        Date dateFormatParse = sdf.parse(value);
                        filterFields.put(key, dateFormatParse);
                    } else {
                        filterFields.put(key, value);
                    }
                }
            }
            return filterFields;
        } catch (Exception ex) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }

    private LinkedHashMap getSortFieldsMap(PathSegment sorts) {
        try {
            MultivaluedMap<String, String> sortsMM = sorts.getMatrixParameters();
            LinkedHashMap<String, String> sortFields = new LinkedHashMap<>();
            String key, value = "";
            if (sortsMM != null) {
                for (Map.Entry<String, List<String>> entrySet : sortsMM.entrySet()) {
                    key = entrySet.getKey();
                    value = entrySet.getValue().get(0);
                    sortFields.put(key, value);
                }
            }
            sortFields.put("credate", "DESC");
            return sortFields;
        } catch (Exception ex) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }

}
