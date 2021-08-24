/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eam.jrs;

import cn.hanbell.eam.ejb.EquipmentRepairBean;
import cn.hanbell.eam.ejb.EquipmentSpareBean;
import cn.hanbell.eam.ejb.EquipmentSpareRecodeBean;
import cn.hanbell.eam.ejb.EquipmentSpareRecodeDtaBean;
import cn.hanbell.eam.ejb.EquipmentSpareStockBean;
import cn.hanbell.eam.ejb.SysCodeBean;
import cn.hanbell.eam.entity.EquipmentRepair;
import cn.hanbell.eam.entity.EquipmentSpare;
import cn.hanbell.eam.entity.EquipmentSpareRecode;
import cn.hanbell.eam.entity.EquipmentSpareRecodeDta;
import cn.hanbell.eam.entity.EquipmentSpareRecodeDtaResponse;
import cn.hanbell.eam.entity.EquipmentSpareStock;
import cn.hanbell.eam.entity.EquipmentSpareStockResponse;
import cn.hanbell.eam.entity.SysCode;
import cn.hanbell.eap.ejb.SystemGrantPrgBean;
import cn.hanbell.eap.ejb.SystemRoleDetailBean;
import cn.hanbell.eap.ejb.SystemUserBean;
import cn.hanbell.eap.entity.SystemGrantPrg;
import cn.hanbell.eap.entity.SystemRoleDetail;
import cn.hanbell.eap.entity.SystemUser;
import cn.hanbell.jrs.ResponseMessage;
import cn.hanbell.jrs.SuperRESTForEAM;
import com.lightshell.comm.SuperEJB;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javafx.scene.input.KeyCode;
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
@Path("shbeam/sparemanagement")
public class SpareManagementFacadeREST extends SuperRESTForEAM<EquipmentSpare> {
    @EJB
    private EquipmentRepairBean equipmentRepairBean;
    
    @EJB
    private EquipmentSpareBean equipmentSpareBean;
    
    @EJB
    private EquipmentSpareStockBean equipmentSpareStockBean;
    
    @EJB
    private EquipmentSpareRecodeBean equipmentSpareRecodeBean;
    
    @EJB
    private EquipmentSpareRecodeDtaBean equipmentSpareRecodeDtaBean;
    
    @EJB
    private SysCodeBean sysCodeBean;
    
    @EJB
    private SystemUserBean systemUserBean;
    
    @EJB
    private SystemRoleDetailBean systemRoleDetailBean;
    
    @EJB
    private SystemGrantPrgBean systemGrantPrgBean;
    
    protected SuperEJB superEJB;
    
    @Override
    protected SuperEJB getSuperEJB() {
        return equipmentSpareBean;
    }
    

    public SpareManagementFacadeREST() {
        super(EquipmentSpare.class);
    }
    
    @GET
    @Path("getSpareStockList/{filters}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public String getSpareStockList(@PathParam("filters") PathSegment filters, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            List<EquipmentSpareStockResponse> spareStockList = new ArrayList<EquipmentSpareStockResponse>();
            this.superEJB = equipmentSpareStockBean;
            try {
                MultivaluedMap<String, String> filtersMM = filters.getMatrixParameters();
                Map<String, Object> filterFields = new HashMap<>();
                String key, value="";
                if (filtersMM != null) {
                    for (Map.Entry<String, List<String>> entrySet : filtersMM.entrySet()) {
                        key = entrySet.getKey();
                        value = entrySet.getValue().get(0);
                        filterFields.put(key, value);
                    }
                }
                spareStockList = equipmentSpareStockBean.getEquipmentSpareStockListByNativeQuery(filterFields.get("basicInfo").toString());
                
                System.out.print(spareStockList);
                
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
            
           JSONArray jsonArray = new JSONArray(spareStockList);
           
           return jsonArray.toString();
           
        } else {
           throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }
    
    @GET
    @Path("getSpareRecodeDocList/{filters}/{sorts}/{offset}/{pageSize}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public List<EquipmentSpareRecode> getSpareRecodeDocList(@PathParam("filters") PathSegment filters, @PathParam("sorts") PathSegment sorts, @PathParam("offset") Integer offset, @PathParam("pageSize") Integer pageSize, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            this.superEJB = equipmentSpareRecodeBean;
            List<EquipmentSpareRecode> spareDocListRes = new ArrayList<>();
            try {
                MultivaluedMap<String, String> filtersMM = filters.getMatrixParameters();
                MultivaluedMap<String, String> sortsMM = sorts.getMatrixParameters();
                Map<String, Object> filterFields = new HashMap<>();
                Map<String, String> sortFields = new LinkedHashMap<>();
                String key, value="";
                if (filtersMM != null) {
                    for (Map.Entry<String, List<String>> entrySet : filtersMM.entrySet()) {
                        key = entrySet.getKey();
                        value = entrySet.getValue().get(0);
                        if(key.equals("formdateBegin") || key.equals("formdateEnd"))
                        {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            Date dateFormatParse = sdf.parse(value);
                            filterFields.put(key, dateFormatParse);
                        }
                        else
                        {
                            filterFields.put(key, value);
                        }
                    }
                }
                if (sortsMM != null) {
                    for (Map.Entry<String, List<String>> entrySet : sortsMM.entrySet()) {
                        key = entrySet.getKey();
                        value = entrySet.getValue().get(0);
                        sortFields.put(key, value);
                    }
                }
                sortFields.put("credate", "DESC");

                spareDocListRes = equipmentSpareRecodeBean.getEquipmentRepairListByNativeQuery(filterFields,sortFields);
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
                return spareDocListRes;
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }
    
    @GET
    @Path("getRetreatSpareList/{filters}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public String getRetreatSpareList(@PathParam("filters") PathSegment filters, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            List<EquipmentSpareRecodeDtaResponse> spareRecodeList = new ArrayList<EquipmentSpareRecodeDtaResponse>();
            this.superEJB = equipmentSpareRecodeDtaBean;
            try {
                MultivaluedMap<String, String> filtersMM = filters.getMatrixParameters();
                Map<String, Object> filterFields = new HashMap<>();
                String key, value="";
                if (filtersMM != null) {
                    for (Map.Entry<String, List<String>> entrySet : filtersMM.entrySet()) {
                        key = entrySet.getKey();
                        value = entrySet.getValue().get(0);
                        filterFields.put(key, value);
                    }
                }
                spareRecodeList = getEqpRepairRetreatSpareList(filterFields.get("docFormid").toString(), filterFields.get("basicInfo").toString());
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
            
           JSONArray jsonArray = new JSONArray(spareRecodeList);
           
           return jsonArray.toString();
           
        } else {
           throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }
    
    private List<EquipmentSpareRecodeDtaResponse> getEqpRepairRetreatSpareList(String formid, String spareInfo) {
        List<EquipmentSpareRecodeDta> eqpSpareRecodeDtas = equipmentSpareRecodeDtaBean.getRetreatSpareListByRepairFormId(formid,spareInfo);
        //List按照sparenum分组
        Map<EquipmentSpare, List<EquipmentSpareRecodeDta>> groupBySparenumMap = eqpSpareRecodeDtas.stream().collect(Collectors.groupingBy(EquipmentSpareRecodeDta::getSparenum));

        List<EquipmentSpareRecodeDtaResponse> resList = new ArrayList<>();
        groupBySparenumMap.forEach((key, value) -> {
            BigDecimal qtySum = BigDecimal.ZERO;
            BigDecimal priceSum = BigDecimal.ZERO;
            for (int i = 0; i < value.size(); i++) {
                EquipmentSpareRecodeDta dtaTemp = value.get(i);
                qtySum = qtySum.add(dtaTemp.getCqty());
                priceSum = priceSum.add(value.get(i).getCqty().multiply(value.get(i).getUprice()));
            }
            EquipmentSpareRecodeDtaResponse resTemp = new EquipmentSpareRecodeDtaResponse(key, value, qtySum, priceSum);
            resList.add(resTemp);
        });
        return resList;
    }
    
    @GET
    @Path("getSpareDeliveryInfo/{filters}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public String getSpareDeliveryInfo(@PathParam("filters") PathSegment filters, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            SystemUser currentUser = new SystemUser();
            String actionName = "";
            boolean verifyAuthFlag = false;
            List<Object> resObjects = new ArrayList<>();
            List<EquipmentSpareRecodeDtaResponse> spareRecodeDtaList = new ArrayList<>();
            List<EquipmentSpareRecode> eqpSpareRecodes = new ArrayList<>();
            EquipmentSpareRecode eqpSpareRecodeTemp = null;
            try {
                MultivaluedMap<String, String> filtersMM = filters.getMatrixParameters();
                Map<String, Object> filterFields = new HashMap<>();
                String key, value="";
                if (filtersMM != null) {
                    for (Map.Entry<String, List<String>> entrySet : filtersMM.entrySet()) {
                        key = entrySet.getKey();
                        value = entrySet.getValue().get(0);
                        filterFields.put(key, value);
                    }
                }
                eqpSpareRecodes = equipmentSpareRecodeBean.findByFormid(filterFields.get("docFormid").toString());
                currentUser = systemUserBean.findByUserId(filterFields.get("userId").toString());
                actionName = filterFields.get("actionName").toString();
                
                if(eqpSpareRecodes.size() > 0 && currentUser != null){
                    eqpSpareRecodeTemp = eqpSpareRecodes.get(0);
                }
                else{
                    throw new WebApplicationException(Response.Status.NOT_FOUND);
                }
                eqpSpareRecodeTemp = eqpSpareRecodes.get(0);
                spareRecodeDtaList = getEqpSpareRecodeDtaResponses(eqpSpareRecodeTemp.getFormid());
                verifyAuthFlag = eqpSpareRecodeTemp.getStatus().equals("V") ? false : checkUserAuthority(currentUser.getId(), actionName);
                
                System.out.print(spareRecodeDtaList);
                
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
            
            resObjects.add(eqpSpareRecodeTemp);
            resObjects.add(spareRecodeDtaList);
            resObjects.add(verifyAuthFlag);
            
           JSONArray jsonArray = new JSONArray(resObjects);
           
           return jsonArray.toString();
           
        } else {
           throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }
    
    @POST
    @Path("startSpareDelivery")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage startSpareDelivery(EquipmentSpareRecode entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            if (entity == null) {
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
            
            try {
                //插入EquipmentSpareRecode表头
                String formid = equipmentSpareRecodeBean.getFormId(new Date(), "CK", "YYMM", 4);
                Date currentDate = new Date();
                EquipmentSpareRecode equipmentSpareRecodeTemp = new EquipmentSpareRecode();
                equipmentSpareRecodeTemp.setFormid(formid);
                equipmentSpareRecodeTemp.setCompany(entity.getCompany());
                equipmentSpareRecodeTemp.setDeptno(entity.getDeptno());
                equipmentSpareRecodeTemp.setDeptname(entity.getDeptname());
                equipmentSpareRecodeTemp.setFormdate(currentDate);
                equipmentSpareRecodeTemp.setWarehouseno(entity.getWarehouseno());
                equipmentSpareRecodeTemp.setSarea(entity.getSarea());
                equipmentSpareRecodeTemp.setSlocation(entity.getSlocation());
                String acceptTypeTemp = "";
                //判断报修单是否已经存在出库单,每个报修单只能出库一次
                if(entity.getRelano() == null || entity.getRelano().trim().equals("")){
                    acceptTypeTemp = "20";
                }
                else{
                    acceptTypeTemp = "25";
                    List<EquipmentRepair> eqpRepairCheckList = new ArrayList<>();
                    String repairFormIdTemp = entity.getRelano();
                    //判断报修单是否存在
                    eqpRepairCheckList = equipmentRepairBean.findByFormid(repairFormIdTemp);
                    if (eqpRepairCheckList.size() > 0 && (!eqpRepairCheckList.get(0).getRstatus().equals("98"))) {
                        List<EquipmentSpareRecode> spareRecodeCheckList = new ArrayList<>();
                        Map<String, Object> filterFields = new HashMap<>();
                        Map<String, String> sortFields = new LinkedHashMap<>();
                        filterFields.put("relano", repairFormIdTemp);
                        filterFields.put("ExistForm", "ExistForm");
                        spareRecodeCheckList = equipmentSpareRecodeBean.getEquipmentRepairListByNativeQuery(filterFields, sortFields);
                        if (spareRecodeCheckList.size() > 0) {
                            String errorMsg = "已存在出库单:".concat(spareRecodeCheckList.get(0).getFormid()).concat(",请确认!");
                            return new ResponseMessage("301", errorMsg);
                        }
                    } else {
                        String errorMsg = "报修单:".concat(repairFormIdTemp).concat("不存在或已作废!");
                        return new ResponseMessage("302", errorMsg);
                    }
                }
                equipmentSpareRecodeTemp.setAccepttype(acceptTypeTemp);
                equipmentSpareRecodeTemp.setRelano(entity.getRelano());
                equipmentSpareRecodeTemp.setRemark(entity.getRemark());
                equipmentSpareRecodeTemp.setStatus("N");
                equipmentSpareRecodeTemp.setCreator(entity.getCreator());
                equipmentSpareRecodeTemp.setCredate(currentDate);
                equipmentSpareRecodeBean.persist(equipmentSpareRecodeTemp);
                
                //插入EquipmentSpareRecodeDta单身
                JSONArray jsonArray = new JSONArray(entity.getStatus());
                JSONArray spareUsedList_jsonArray = jsonArray.getJSONArray(0);
                
                JSONObject jsonObj = new JSONObject();
                for(int i = 0;i<spareUsedList_jsonArray.length();i++)
                {
                    jsonObj = (JSONObject)spareUsedList_jsonArray.get(i);
                    if(jsonObj == null)
                        continue;
                    int spareIdTemp = jsonObj.getJSONObject("sparenum").getInt("id");
                    EquipmentSpare spareObjTemp = equipmentSpareBean.findById(spareIdTemp);
                    if(spareObjTemp == null)
                        continue;
                    EquipmentSpareRecodeDta eqpSpareDtaTemp = new EquipmentSpareRecodeDta();
                    eqpSpareDtaTemp.setPid(formid);
                    eqpSpareDtaTemp.setSeq(i + 1);
                    eqpSpareDtaTemp.setSparenum(spareObjTemp);
                    eqpSpareDtaTemp.setCqty(jsonObj.getBigDecimal("qty"));
                    eqpSpareDtaTemp.setUprice(jsonObj.getBigDecimal("uprice"));
                    eqpSpareDtaTemp.setSlocation(jsonObj.getString("slocation"));
                    eqpSpareDtaTemp.setRemark(jsonObj.getString("remark"));
                    eqpSpareDtaTemp.setStatus("N");
                    eqpSpareDtaTemp.setCreator(entity.getCreator());
                    eqpSpareDtaTemp.setCredate(currentDate);
                    equipmentSpareRecodeDtaBean.persist(eqpSpareDtaTemp);
                }
                return new ResponseMessage("200", formid);
            } catch (Exception e) {
                return new ResponseMessage("300", "出库单建单失败,请重试!");
            }
        }
        else
        {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }
    
    @POST
    @Path("startSpareRetreat")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage startSpareRetreat(EquipmentSpareRecode entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            if (entity == null) {
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
            
            try {
                JSONArray jsonArray = new JSONArray(entity.getStatus());
                JSONArray spareUsedList_jsonArray = jsonArray.getJSONArray(0);
                
                //JSONArray按照出库单分组
                Map<String, List<JSONObject>> mapGroupByPid = new HashMap();
                String tempIdStr = "";
                List<JSONObject> list = null;
                for(Object obj : spareUsedList_jsonArray){
                    JSONObject jsonObject = (JSONObject) obj;
                    tempIdStr = jsonObject.getString("pid");
                    if(mapGroupByPid.containsKey(tempIdStr)){
                        list = mapGroupByPid.get(tempIdStr);
                        list.add(jsonObject);
                    }else{
                        list = new ArrayList();
                        list.add(jsonObject);
                        mapGroupByPid.put(tempIdStr, list);
                    }
                }
                
                StringBuilder allFormidSb = new StringBuilder();
                Date currentDate = new Date();
                mapGroupByPid.forEach((key, value) -> {
                    
                    //插入EquipmentSpareRecode表头
                    String formid = equipmentSpareRecodeBean.getFormId(new Date(), "TK", "YYMM", 4);
                    allFormidSb.append(formid).append(",");
                    EquipmentSpareRecode equipmentSpareRecodeTemp = new EquipmentSpareRecode();
                    List<EquipmentSpareRecode> relaSpareRecodeList = equipmentSpareRecodeBean.findByFormid(key);
                    if(relaSpareRecodeList.size() > 0){
                        equipmentSpareRecodeTemp.setSarea(relaSpareRecodeList.get(0).getSarea());
                        equipmentSpareRecodeTemp.setSlocation(relaSpareRecodeList.get(0).getSlocation());
                    }
                    else{
                        equipmentSpareRecodeTemp.setSarea(entity.getSarea());
                        equipmentSpareRecodeTemp.setSlocation(entity.getSlocation());
                    }
                    equipmentSpareRecodeTemp.setFormid(formid);
                    equipmentSpareRecodeTemp.setCompany(entity.getCompany());
                    equipmentSpareRecodeTemp.setFormdate(currentDate);
                    equipmentSpareRecodeTemp.setWarehouseno(entity.getWarehouseno());
                    String acceptTypeTemp = entity.getRelano() == null ? "30" : "35";
                    equipmentSpareRecodeTemp.setAccepttype(acceptTypeTemp);
                    //Mod By C2090:退库单关联单号改为出库单
                    equipmentSpareRecodeTemp.setRelano(key);
                    equipmentSpareRecodeTemp.setDeptno(entity.getDeptno());
                    equipmentSpareRecodeTemp.setDeptname(entity.getDeptname());
                    equipmentSpareRecodeTemp.setRemark(entity.getRemark());
                    equipmentSpareRecodeTemp.setStatus("N");
                    equipmentSpareRecodeTemp.setCreator(entity.getCreator());
                    equipmentSpareRecodeTemp.setCredate(currentDate);
                    equipmentSpareRecodeBean.persist(equipmentSpareRecodeTemp);

                    //插入EquipmentSpareRecodeDta单身
                    JSONObject jsonObj;
                    for(int i = 0;i< value.size();i++)
                    {
                        jsonObj = value.get(i);
                        if(jsonObj == null)
                            continue;
                        int spareIdTemp = jsonObj.getJSONObject("sparenum").getInt("id");
                        EquipmentSpare spareObjTemp = equipmentSpareBean.findById(spareIdTemp);
                        if(spareObjTemp == null)
                            continue;
                        EquipmentSpareRecodeDta eqpSpareDtaTemp = new EquipmentSpareRecodeDta();
                        eqpSpareDtaTemp.setPid(formid);
                        eqpSpareDtaTemp.setSeq(i + 1);
                        eqpSpareDtaTemp.setSparenum(spareObjTemp);
                        eqpSpareDtaTemp.setCqty(jsonObj.getBigDecimal("cqty"));
                        eqpSpareDtaTemp.setUprice(jsonObj.getBigDecimal("uprice"));
                        eqpSpareDtaTemp.setSlocation(jsonObj.getString("slocation"));
                        eqpSpareDtaTemp.setRemark(jsonObj.getString("remark"));
                        eqpSpareDtaTemp.setStatus("N");
                        eqpSpareDtaTemp.setCreator(entity.getCreator());
                        eqpSpareDtaTemp.setCredate(currentDate);
                        equipmentSpareRecodeDtaBean.persist(eqpSpareDtaTemp);
                    }
                    
                });
                
                return new ResponseMessage("200", allFormidSb.toString().substring(0, allFormidSb.length() - 1));
            } catch (Exception e) {
                return new ResponseMessage("300", "退库单建单失败,请重试!");
            }
        }
        else
        {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }
    
    @POST
    @Path("verifySpareDelivery")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage verifySpareDelivery(EquipmentSpareRecode entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            if (entity == null) {
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
            
            try {
                String acceptTypeTemp = entity.getAccepttype();
                if(acceptTypeTemp == null){
                    return new ResponseMessage("303", "单据类型异常!");
                }
                switch(acceptTypeTemp)
                {
                    case "10":
                        return startVerify_recode(entity);
                    case "20":
                    case "25":
                        return startVerify_delivery(entity);
                    case "30":
                    case "35":
                        return startVerify_retreat(entity);
                    default:
                        return new ResponseMessage("302", "不支持单据类型:" + acceptTypeTemp);
                }
            } catch (Exception e) {
                return new ResponseMessage("300", "出库单建单失败,请重试!");
            }
        }
        else
        {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }
    
    private ResponseMessage startVerify_delivery(EquipmentSpareRecode entity) {
        Date currentDate = new Date();
        List<EquipmentSpareRecodeDta> eqpSpareRecodeDtas = new ArrayList<>();
        List<EquipmentSpareStock> eqpSpareStocks = new ArrayList<>();
        List<EquipmentRepair> eqpRepairs = new ArrayList<>();
        BigDecimal priceSum = BigDecimal.ZERO; 
        EquipmentSpareRecode eqpEquipmentSpareRecode = equipmentSpareRecodeBean.findById(entity.getId());
        if(eqpEquipmentSpareRecode == null){
            return new ResponseMessage("303", "出库单资料异常,请联系管理员!");
        }
        String eqpRepairFormId = eqpEquipmentSpareRecode.getRelano();
        if(eqpRepairFormId != null && eqpRepairFormId != ""){
            eqpRepairs = equipmentRepairBean.findByFormid(eqpRepairFormId);
        }
        eqpSpareRecodeDtas = equipmentSpareRecodeDtaBean.findByPId(eqpEquipmentSpareRecode.getFormid());
        for (EquipmentSpareRecodeDta eSpareRecodeDta : eqpSpareRecodeDtas) {
            EquipmentSpareStock eSpareStock = equipmentSpareStockBean.findBySparenumAndRemark(eSpareRecodeDta.getSparenum().getSparenum(), eSpareRecodeDta.getRemark());
            if (eSpareRecodeDta.getCqty().compareTo(eSpareStock.getQty()) == 1) {
                return new ResponseMessage("301", "备件库存数量不足,请确认库存!");
            }
            eSpareStock.setQty(eSpareStock.getQty().subtract(eSpareRecodeDta.getCqty()));
            eSpareStock.setOptdate(currentDate);
            eSpareStock.setOptuser(entity.getCfmuser());
            equipmentSpareStockBean.getEntityManager().clear();
            eqpSpareStocks.add(eSpareStock);
            eSpareRecodeDta.setStatus("V");
            eSpareRecodeDta.setOptdate(currentDate);
            eSpareRecodeDta.setOptuser(entity.getCfmuser());
            equipmentSpareRecodeDtaBean.getEntityManager().clear();
            priceSum = priceSum.add(eSpareRecodeDta.getCqty().multiply(eSpareRecodeDta.getUprice()));
        }
        eqpEquipmentSpareRecode.setCfmuser(entity.getCfmuser());
        eqpEquipmentSpareRecode.setCfmdate(currentDate);
        eqpEquipmentSpareRecode.setStatus("V");
        equipmentSpareStockBean.update(eqpSpareStocks);
        equipmentSpareRecodeDtaBean.update(eqpSpareRecodeDtas);//更新对应字表状态
        equipmentSpareRecodeBean.update(eqpEquipmentSpareRecode);
        //若关联报修单,则更新报修单的备件费用
        if(eqpRepairs.size() > 0){
            eqpRepairs.get(0).setSparecost(priceSum);
            equipmentRepairBean.update(eqpRepairs.get(0));
        }
        return new ResponseMessage("200", "出库核准完成!");
    }
    
    private ResponseMessage startVerify_recode(EquipmentSpareRecode entity) {
        Date currentDate = new Date();
        List<EquipmentSpareRecodeDta> eqpSpareRecodeDtas = new ArrayList<>();
        List<EquipmentSpareStock> eqpSpareStocks = new ArrayList<>();
        EquipmentSpareRecode eqpEquipmentSpareRecode = equipmentSpareRecodeBean.findById(entity.getId());
        eqpSpareRecodeDtas = equipmentSpareRecodeDtaBean.findByPId(eqpEquipmentSpareRecode.getFormid());
        for (EquipmentSpareRecodeDta eSpareRecodeDta : eqpSpareRecodeDtas) {
            EquipmentSpareStock eSpareStock = new EquipmentSpareStock();
            eSpareStock.setIntime(currentDate);
            eSpareStock.setRemark(eqpEquipmentSpareRecode.getFormid());
            eSpareStock.setCreator(eqpEquipmentSpareRecode.getCreator());
            eSpareStock.setCredate(currentDate);
            eSpareStock.setQty(eSpareRecodeDta.getCqty());
            eSpareStock.setUprice(eSpareRecodeDta.getUprice());
            eSpareStock.setSparenum(eSpareRecodeDta.getSparenum());
            eSpareStock.setSarea(eqpEquipmentSpareRecode.getSarea());
            eSpareStock.setSlocation(eqpEquipmentSpareRecode.getSlocation());
            eSpareStock.setWarehouseno(eqpEquipmentSpareRecode.getWarehouseno());
            eSpareStock.setCompany(eqpEquipmentSpareRecode.getCompany());
            eSpareStock.setStatus("V");
            equipmentSpareStockBean.getEntityManager().clear();
            eqpSpareStocks.add(eSpareStock);
            eSpareRecodeDta.setStatus("V");
            equipmentSpareRecodeDtaBean.getEntityManager().clear();
        }
        
        eqpEquipmentSpareRecode.setCfmuser(entity.getCfmuser());
        eqpEquipmentSpareRecode.setCfmdate(currentDate);
        eqpEquipmentSpareRecode.setStatus("V");
        equipmentSpareStockBean.update(eqpSpareStocks);
        equipmentSpareRecodeDtaBean.update(eqpSpareRecodeDtas);//更新对应字表状态
        equipmentSpareRecodeBean.update(eqpEquipmentSpareRecode);
        return new ResponseMessage("200", "入库核准完成!");
    }
    
    private ResponseMessage startVerify_retreat(EquipmentSpareRecode entity) {
        Date currentDate = new Date();
        List<EquipmentSpareRecodeDta> eqpSpareRecodeDtas = new ArrayList<>();
        List<EquipmentSpareStock> eqpSpareStocks = new ArrayList<>();
        List<EquipmentSpareRecode> eqpSpareRelaList = new ArrayList<>();
        List<EquipmentRepair> eqpRepairs = new ArrayList<>();
        BigDecimal priceSum = BigDecimal.ZERO; 
        EquipmentSpareRecode eqpEquipmentSpareRecode = equipmentSpareRecodeBean.findById(entity.getId());
        if(eqpEquipmentSpareRecode == null){
            return new ResponseMessage("303", "退库单资料异常,请联系管理员!");
        }
        String spareRelaFormId = eqpEquipmentSpareRecode.getRelano();
        eqpSpareRelaList = equipmentSpareRecodeBean.findByFormid(spareRelaFormId);
        if (eqpSpareRelaList.size() > 0) {
            String eqpRepairFormId = eqpSpareRelaList.get(0).getRelano();
            if (eqpRepairFormId != null && eqpRepairFormId != "") {
                eqpRepairs = equipmentRepairBean.findByFormid(eqpRepairFormId);
            }
        }
        else{
            return new ResponseMessage("304", "关联出库单资料异常,请联系管理员!");
        }
        
        eqpSpareRecodeDtas = equipmentSpareRecodeDtaBean.findByPId(eqpEquipmentSpareRecode.getFormid());
        for (EquipmentSpareRecodeDta eSpareRecodeDta : eqpSpareRecodeDtas) {
            EquipmentSpareStock eSpareStock = equipmentSpareStockBean.findBySparenumAndRemark(eSpareRecodeDta.getSparenum().getSparenum(), eSpareRecodeDta.getRemark());
            if (eSpareStock == null) {
                return new ResponseMessage("301", "该备件已被删除!");
            }
            eSpareStock.setQty(eSpareStock.getQty().add(eSpareRecodeDta.getCqty()));
            eSpareStock.setOptdate(currentDate);
            eSpareStock.setOptuser(entity.getCfmuser());
            equipmentSpareStockBean.getEntityManager().clear();
            eqpSpareStocks.add(eSpareStock);
            eSpareRecodeDta.setStatus("V");
            eSpareRecodeDta.setOptdate(currentDate);
            eSpareRecodeDta.setOptuser(entity.getCfmuser());
            equipmentSpareRecodeDtaBean.getEntityManager().clear();
        }
        eqpEquipmentSpareRecode.setCfmuser(entity.getCfmuser());
        eqpEquipmentSpareRecode.setCfmdate(currentDate);
        eqpEquipmentSpareRecode.setStatus("V");
        equipmentSpareStockBean.update(eqpSpareStocks);
        equipmentSpareRecodeDtaBean.update(eqpSpareRecodeDtas);//更新对应字表状态
        equipmentSpareRecodeBean.update(eqpEquipmentSpareRecode);
        //若关联报修单,则更新报修单的备件费用
        if (eqpRepairs.size() > 0) {
            equipmentSpareRecodeDtaBean.getEntityManager().flush();
            equipmentSpareRecodeDtaBean.getEntityManager().clear ();
            List<EquipmentSpareRecodeDta> eqpRepairSpareRecodeDtas = new ArrayList<>();
            eqpRepairSpareRecodeDtas = equipmentSpareRecodeDtaBean.getEquipmentSpareRecodeDtaListByRepairFormId(eqpRepairs.get(0).getFormid());
            for (EquipmentSpareRecodeDta rSpareRecodeDta : eqpRepairSpareRecodeDtas) {
                priceSum = priceSum.add(rSpareRecodeDta.getCqty().multiply(rSpareRecodeDta.getUprice()));
            }
            eqpRepairs.get(0).setSparecost(priceSum);
            equipmentRepairBean.update(eqpRepairs.get(0));
        }
        return new ResponseMessage("200", "退库核准完成!");
    }
    
    private List<EquipmentSpareRecodeDtaResponse> getEqpSpareRecodeDtaResponses(String formid){
        List<EquipmentSpareRecodeDta> eqpSpareRecodeDtas = equipmentSpareRecodeDtaBean.findByPId(formid);
        //List按照sparenum分组
        Map<EquipmentSpare,List<EquipmentSpareRecodeDta>> groupBySparenumMap = eqpSpareRecodeDtas.stream().collect(Collectors.groupingBy(EquipmentSpareRecodeDta::getSparenum));
        
        List<EquipmentSpareRecodeDtaResponse> resList = new ArrayList<>();
        groupBySparenumMap.forEach((key,value) -> {
            BigDecimal qtySum = BigDecimal.ZERO;
            BigDecimal priceSum = BigDecimal.ZERO;
            for(int i = 0;i< value.size() ;i++){
                qtySum = qtySum.add(value.get(i).getCqty());
                priceSum = priceSum.add(value.get(i).getCqty().multiply(value.get(i).getUprice()));
            }
            EquipmentSpareRecodeDtaResponse resTemp = new EquipmentSpareRecodeDtaResponse(key,value,qtySum,priceSum);
            resList.add(resTemp);
        });
        
        return resList;
    }
    
    private boolean checkUserAuthority(int userid, String apiName){
        List<SystemRoleDetail> roleList;
        List<SystemGrantPrg> userPrgGrantList;
        List<SystemGrantPrg> rolePrgGrantList;
        roleList = systemRoleDetailBean.findByUserId(userid);
        userPrgGrantList = systemGrantPrgBean.findBySystemNameAndUserId("EAM", userid);
        for(SystemGrantPrg sysGrantPrg: userPrgGrantList){
            if(sysGrantPrg.getSysprg().getApi().equals(apiName) && sysGrantPrg.getDocfm()){
                return true;
            }
        }
        for (SystemRoleDetail r : roleList) {
            rolePrgGrantList = systemGrantPrgBean.findBySystemNameAndRoleId("EAM", r.getPid());
            for(SystemGrantPrg roleSysGrantPrg: rolePrgGrantList){
                if(roleSysGrantPrg.getSysprg().getApi().equals(apiName) && roleSysGrantPrg.getDocfm()){
                    return true;
                }
            }
        }
        return false;
    }
}
