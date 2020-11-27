/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.jrs;

import cn.hanbell.eap.ejb.ProductionPlanBean;
import cn.hanbell.eap.ejb.SalesOrderBean;
import cn.hanbell.eap.entity.ProductionPlan;
import cn.hanbell.jrs.ResponseData;
import cn.hanbell.jrs.ResponseMessage;
import cn.hanbell.jrs.SuperRESTForEAP;
import cn.hanbell.util.BaseLib;
import com.lightshell.comm.SuperEJB;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;

/**
 *
 * @author C0160
 */
@Path("eap/productionplan")
@javax.enterprise.context.RequestScoped
public class ProductionPlanFacadeREST extends SuperRESTForEAP<ProductionPlan> {

    @EJB
    private ProductionPlanBean productionPlanBean;
    @EJB
    private SalesOrderBean salesOrderBean;

    public ProductionPlanFacadeREST() {
        super(ProductionPlan.class);
    }

    @Override
    protected SuperEJB getSuperEJB() {
        return productionPlanBean;
    }

    @Override
    public ResponseMessage create(ProductionPlan entity, String appid, String token) {
        if (isAuthorized(appid, token)) {
            try {
                if (entity.getFormid() == null || "".equals(entity.getFormid())) {
                    if (entity.getFormdate() != null) {
                        entity.setFormid(productionPlanBean.getFormId(entity.getFormdate()));
                    } else {
                        entity.setFormid(productionPlanBean.getFormId());
                    }
                }
                entity.setCredateToNow();
                productionPlanBean.persist(entity);
                return new ResponseMessage("200", "更新成功");
            } catch (Exception ex) {
                log4j.error(ex);
                return new ResponseMessage("500", "系统错误更新失败");
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @Override
    public ResponseMessage edit(PathSegment id, ProductionPlan entity, String appid, String token) {
        if (isAuthorized(appid, token)) {
            try {
                ProductionPlan t = productionPlanBean.findById(Integer.parseInt(id.getPath()));
                if (t == null) {
                    return new ResponseMessage("404", "找不到对象");
                }
                if (!Objects.equals(t.getOptdate(), entity.getOptdate())) {
                    return new ResponseMessage("409", "修改冲突");
                }
                entity.setOptdateToNow();
                productionPlanBean.update(entity);
                return new ResponseMessage("200", "更新成功");
            } catch (Exception ex) {
                return new ResponseMessage("500", "系统错误更新失败");
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("summary/{filters}/{sorts}")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseData findBySummary(@PathParam("filters") PathSegment filters,
            @PathParam("sorts") PathSegment sorts, @QueryParam("offset") Integer offset,
            @QueryParam("pageSize") Integer pageSize, @QueryParam("appid") String appid,
            @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            try {
                MultivaluedMap<String, String> filtersMM = filters.getMatrixParameters();
                MultivaluedMap<String, String> sortsMM = sorts.getMatrixParameters();
                Map<String, Object> filterFields = new HashMap<>();
                Map<String, String> sortFields = new HashMap<>();
                String key, value;
                Object day;
                if (filtersMM != null) {
                    for (Map.Entry<String, List<String>> entrySet : filtersMM.entrySet()) {
                        key = entrySet.getKey();
                        value = entrySet.getValue().get(0);
                        if (key.endsWith("dateBegin") || key.endsWith("DateBegin") || key.endsWith("dateEnd")
                                || key.endsWith("DateEnd")) {
                            day = BaseLib.getDate("yyyy-MM-dd", value);
                            filterFields.put(key, day);
                        } else {
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
                List<Object[]> planSummary = productionPlanBean.getSummary(filterFields, sortFields);
                String mon = "", series = "", itemno = "", itemModel = "";
                BigDecimal total = BigDecimal.ZERO;
                List<Map<String, Object>> data = new ArrayList<>();
                Map<String, Object> obj = null;
                for (int i = 0; i < planSummary.size(); i++) {
                    if (mon.equals(planSummary.get(i)[0].toString()) && series.equals(planSummary.get(i)[1].toString())
                            && itemno.equals(planSummary.get(i)[2].toString())
                            && itemModel.equals(planSummary.get(i)[3].toString())) {
                        if (obj != null) {
                            obj.put("d" + BaseLib.formatDate("yyyyMMdd", (Date) planSummary.get(i)[4]), planSummary.get(i)[5]);
                            total = total.add((BigDecimal) planSummary.get(i)[5]);
                            obj.put("total", total);
                        }
                    } else {
                        obj = new HashMap<>();
                        obj.put("mon", planSummary.get(i)[0]);
                        obj.put("productSeries", planSummary.get(i)[1]);
                        obj.put("itemno", planSummary.get(i)[2]);
                        obj.put("itemModel", planSummary.get(i)[3]);
                        obj.put("d" + BaseLib.formatDate("yyyyMMdd", (Date) planSummary.get(i)[4]), planSummary.get(i)[5]);
                        total = (BigDecimal) planSummary.get(i)[5];
                        obj.put("total", total);
                        data.add(obj);
                    }
                    mon = planSummary.get(i)[0].toString();
                    series = planSummary.get(i)[1].toString();
                    itemno = planSummary.get(i)[2].toString();
                    itemModel = planSummary.get(i)[3].toString();
                }
                ResponseData res = new ResponseData<ProductionPlan>("200", "success");
                if (data.size() > (offset + pageSize)) {
                    res.setData(data.subList(offset, offset + pageSize - 1));
                } else {
                    res.setData(data);
                }
                res.setCount(data.size());
                return res;
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("demand/{filters}/{sorts}")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseData findByDemand(@PathParam("filters") PathSegment filters,
            @PathParam("sorts") PathSegment sorts, @QueryParam("offset") Integer offset,
            @QueryParam("pageSize") Integer pageSize, @QueryParam("appid") String appid,
            @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            try {
                MultivaluedMap<String, String> filtersMM = filters.getMatrixParameters();
                MultivaluedMap<String, String> sortsMM = sorts.getMatrixParameters();
                Map<String, Object> filterFields = new HashMap<>();
                Map<String, String> sortFields = new HashMap<>();
                String key, value;
                Object day;
                if (filtersMM != null) {
                    for (Map.Entry<String, List<String>> entrySet : filtersMM.entrySet()) {
                        key = entrySet.getKey();
                        value = entrySet.getValue().get(0);
                        if (key.endsWith("dateBegin") || key.endsWith("DateBegin") || key.endsWith("dateEnd")
                                || key.endsWith("DateEnd")) {
                            day = BaseLib.getDate("yyyy-MM-dd", value);
                            filterFields.put(key, day);
                        } else {
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
                List<Object[]> planSummary = productionPlanBean.getSummary(filterFields, sortFields);
                List<Object[]> demandSummary = salesOrderBean.getSummary(filterFields, sortFields);
                String mon = "", series = "", itemno = "", itemModel = "";
                BigDecimal total = BigDecimal.ZERO;
                List<Map<String, Object>> data = new ArrayList<>();
                Map<String, Object> obj = null;
                for (int i = 0; i < planSummary.size(); i++) {
                    if (mon.equals(planSummary.get(i)[0].toString()) && series.equals(planSummary.get(i)[1].toString())
                            && itemno.equals(planSummary.get(i)[2].toString())
                            && itemModel.equals(planSummary.get(i)[3].toString())) {
                        if (obj != null) {
                            obj.put("d" + BaseLib.formatDate("yyyyMMdd", (Date) planSummary.get(i)[4]), planSummary.get(i)[5]);
                            total = total.add((BigDecimal) planSummary.get(i)[5]);
                            obj.put("total", total);
                        }
                    } else {
                        obj = new HashMap<>();
                        obj.put("kind", "50");
                        obj.put("mon", planSummary.get(i)[0]);
                        obj.put("productSeries", planSummary.get(i)[1]);
                        obj.put("itemno", planSummary.get(i)[2]);
                        obj.put("itemModel", planSummary.get(i)[3]);
                        obj.put("d" + BaseLib.formatDate("yyyyMMdd", (Date) planSummary.get(i)[4]), planSummary.get(i)[5]);
                        total = (BigDecimal) planSummary.get(i)[5];
                        obj.put("total", total);
                        data.add(obj);
                    }
                    mon = planSummary.get(i)[0].toString();
                    series = planSummary.get(i)[1].toString();
                    itemno = planSummary.get(i)[2].toString();
                    itemModel = planSummary.get(i)[3].toString();
                }
                mon = "";
                series = "";
                itemno = "";
                itemModel = "";
                total = BigDecimal.ZERO;
                for (int i = 0; i < demandSummary.size(); i++) {
                    if (mon.equals(demandSummary.get(i)[0].toString()) && series.equals(demandSummary.get(i)[1].toString())
                            && itemno.equals(demandSummary.get(i)[2].toString())
                            && itemModel.equals(demandSummary.get(i)[3].toString())) {
                        if (obj != null) {
                            obj.put("d" + BaseLib.formatDate("yyyyMMdd", (Date) demandSummary.get(i)[4]), demandSummary.get(i)[5]);
                            total = total.add((BigDecimal) demandSummary.get(i)[5]);
                            obj.put("total", total);
                        }
                    } else {
                        obj = new HashMap<>();
                        obj.put("kind", "10");
                        obj.put("mon", demandSummary.get(i)[0]);
                        obj.put("productSeries", demandSummary.get(i)[1]);
                        obj.put("itemno", demandSummary.get(i)[2]);
                        obj.put("itemModel", demandSummary.get(i)[3]);
                        obj.put("d" + BaseLib.formatDate("yyyyMMdd", (Date) demandSummary.get(i)[4]), demandSummary.get(i)[5]);
                        total = (BigDecimal) demandSummary.get(i)[5];
                        obj.put("total", total);
                        data.add(obj);
                    }
                    mon = demandSummary.get(i)[0].toString();
                    series = demandSummary.get(i)[1].toString();
                    itemno = demandSummary.get(i)[2].toString();
                    itemModel = demandSummary.get(i)[3].toString();
                }
                // 先按机型再按类别
                data.sort((Map<String, Object> o1, Map<String, Object> o2) -> {
                    if (o1.get("itemModel").toString().compareTo(o2.get("itemModel").toString()) < 1) {
                        return -1;
                    } else {
                        return 1;
                    }
                });
                data.sort((Map<String, Object> o1, Map<String, Object> o2) -> {
                    if (o1.get("itemModel").toString().compareTo(o2.get("itemModel").toString()) < 1 && o1.get("kind").toString().compareTo(o2.get("kind").toString()) < 1) {
                        return -1;
                    } else {
                        return 1;
                    }
                });
                ResponseData res = new ResponseData<ProductionPlan>("200", "success");
                if (data.size() > (offset + pageSize)) {
                    res.setData(data.subList(offset, offset + pageSize - 1));
                } else {
                    res.setData(data);
                }
                res.setCount(data.size());
                return res;
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

}
