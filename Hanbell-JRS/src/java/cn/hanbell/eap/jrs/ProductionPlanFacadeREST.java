/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.jrs;

import cn.hanbell.eap.ejb.ProductionPlanBean;
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
                getSuperEJB().persist(entity);
                return new ResponseMessage("200", "更新成功");
            } catch (Exception ex) {
                log4j.error(ex);
                return new ResponseMessage("500", "系统错误更新失败");
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("summary/{filters}/{sorts}")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseData findByMonAndFiltering(@PathParam("filters") PathSegment filters,
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
                List<Object[]> list = productionPlanBean.getSummary(filterFields, sortFields);
                String mon = "", type = "", itemno = "", itemModel = "";
                BigDecimal total = BigDecimal.ZERO;
                List<Map<String, Object>> data = new ArrayList<>();
                Map<String, Object> obj = null;
                for (int i = 0; i < list.size(); i++) {
                    if (mon.equals(list.get(i)[0].toString()) && type.equals(list.get(i)[1].toString())
                            && itemno.equals(list.get(i)[2].toString())
                            && itemModel.equals(list.get(i)[3].toString())) {
                        if (obj != null) {
                            obj.put(BaseLib.formatDate("yyyyMMdd", (Date) list.get(i)[4]), list.get(i)[5]);
                            total = total.add((BigDecimal) list.get(i)[5]);
                            obj.put("total", total);
                        }
                    } else {
                        obj = new HashMap<>();
                        obj.put("mon", list.get(i)[0]);
                        obj.put("formType", list.get(i)[1]);
                        obj.put("itemno", list.get(i)[2]);
                        obj.put("itemModel", list.get(i)[3]);
                        obj.put(BaseLib.formatDate("yyyyMMdd", (Date) list.get(i)[4]), list.get(i)[5]);
                        total = (BigDecimal) list.get(i)[5];
                        obj.put("total", total);
                        data.add(obj);
                    }
                    mon = list.get(i)[0].toString();
                    type = list.get(i)[1].toString();
                    itemno = list.get(i)[2].toString();
                    itemModel = list.get(i)[3].toString();
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

}
