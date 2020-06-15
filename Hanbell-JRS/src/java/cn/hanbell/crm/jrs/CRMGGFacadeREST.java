/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.jrs;

import cn.hanbell.crm.ejb.CRMGGBean;
import cn.hanbell.crm.entity.CRMGG;
import cn.hanbell.crm.jrs.model.JSONObject;
import cn.hanbell.jrs.ResponseData;
import cn.hanbell.jrs.SuperRESTForCRM;
import cn.hanbell.oa.app.KV;
import cn.hanbell.util.SuperEJB;
import java.util.ArrayList;
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
 * @author Administrator
 */
@Path("crm/crmgg")
@javax.enterprise.context.RequestScoped
public class CRMGGFacadeREST extends SuperRESTForCRM<KV> {

    @EJB
    private CRMGGBean crmggBean;

    public CRMGGFacadeREST() {
        super(KV.class);
    }

    @Override
    protected SuperEJB getSuperEJB() {
        return crmggBean;
    }

    @GET
    @Path("{filters}/{sorts}/{offset}/{pageSize}")
    @Produces({MediaType.APPLICATION_JSON})
    @Override
    public ResponseData findByFilters(@PathParam("filters") PathSegment filters, @PathParam("sorts") PathSegment sorts,
            @PathParam("offset") Integer offset, @PathParam("pageSize") Integer pageSize,
            @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            List<CRMGG> crmggList;
            try {
                MultivaluedMap<String, String> filtersMM = filters.getMatrixParameters();
                MultivaluedMap<String, String> sortsMM = sorts.getMatrixParameters();
                Map<String, Object> filterFields = new HashMap<>();
                Map<String, String> sortFields = new HashMap<>();
                String key, value;
                if (filtersMM != null) {
                    for (Map.Entry<String, List<String>> entrySet : filtersMM.entrySet()) {
                        key = entrySet.getKey();
                        value = entrySet.getValue().get(0);
                        filterFields.put(key, value);
                    }
                }
                if (sortsMM != null) {
                    for (Map.Entry<String, List<String>> entrySet : sortsMM.entrySet()) {
                        key = entrySet.getKey();
                        value = entrySet.getValue().get(0);
                        sortFields.put(key, value);
                    }
                }
                List<KV> data = new ArrayList<>();
                crmggList = crmggBean.findByFilters(filterFields, offset, pageSize, sortFields);
                if (!crmggList.isEmpty()) {
                    crmggList.forEach((gg) -> {
                        data.add(new KV(gg.getGg001(), gg.getGg003()));
                    });
                }
                int count = crmggBean.getRowCount(filterFields);
                ResponseData res = new ResponseData<KV>("200", "success");
                res.setData(data);
                res.setCount(count);
                return res;
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("wechat/caller/{BQ002_value}")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseData<JSONObject> findCaller(@PathParam("BQ002_value") String BQ002_value,
            @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            List<Object[]> list = crmggBean.findCaller(BQ002_value);
            if (list == null) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
            JSONObject js = null;
            js = new JSONObject();
            List<JSONObject> objs = new ArrayList<>();
            // 公司简称，来电者,公司电话国码，公司电话区码，行动电话国码，行动电话区码，经销商
            // GG003,GD005,GD025,GD026,GD027,GD012，GD199
            for (int i = 0; i < list.size(); i++) {
                js = new JSONObject();
                js.put("GG003", list.get(i)[0]);
                js.put("GD005", list.get(i)[1]);
                js.put("GD025", list.get(i)[2]);
                js.put("GD026", list.get(i)[3]);
                js.put("GD027", list.get(i)[4]);
                js.put("GD012", list.get(i)[5]);
                js.put("GD199", list.get(i)[6]);
                js.put("GG001", list.get(i)[7]);
                objs.add(js);
            }
            ResponseData responseData = new ResponseData("200", "seccess");
            responseData.setData(objs);
            responseData.setCount(objs.size());
            return responseData;
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("wechat/customercode/")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseData<JSONObject> findCustomerCode(@QueryParam("searchWord") String GG003,
            @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            List<Object[]> list = crmggBean.findCustomerCode(GG003);
            if (list == null) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
            List<JSONObject> objs = new ArrayList<>();
            JSONObject js = null;
            // 公司简称，来电者,公司电话国码，公司电话区码，行动电话国码，行动电话区码,交易币别，公司全名,发票地址一，发票地址二，发票邮政区号，统一编号。经销商
            for (int i = 0; i < list.size(); i++) {
                js = new JSONObject();
                // GG001,GG003,GG043,GG003, GD005,GD025,GD026,GD027,GD012,GD199,
                // GG084,GG004,GG096,GG097,GG101,GG030,GG132
                js.put("value", list.get(i)[1]);// 公司简称
                js.put("key", list.get(i)[2]);// 公司编号
                js.put("value1", list.get(i)[3]);// 公司简称
                js.put("value2", list.get(i)[4]);// 来电者
                js.put("value3", list.get(i)[5]);// 公司电话国码
                js.put("value4", list.get(i)[6]);// 公司电话区码
                js.put("value5", list.get(i)[7]);// 行动电话国码
                js.put("value6", list.get(i)[8]);// 行动电话区码
                js.put("value7", list.get(i)[9]);//
                js.put("value8", list.get(i)[10]);// 交易币别
                js.put("value9", list.get(i)[11]);// 公司全名
                js.put("value10", list.get(i)[12]);// 发票地址一
                js.put("value11", list.get(i)[13]);// 发票地址二
                js.put("value12", list.get(i)[14]);// 发票邮政区号
                js.put("value13", list.get(i)[15]);// 统一编号
                js.put("value14", list.get(i)[16]);// 经销商
                objs.add(js);
            }
            ResponseData responseData = new ResponseData("200", "seccess");
            responseData.setData(objs);
            responseData.setCount(objs.size());
            return responseData;
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

}
