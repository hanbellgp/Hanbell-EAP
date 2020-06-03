/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.jrs;

import cn.hanbell.crm.ejb.SERACBean;
import cn.hanbell.crm.entity.REPPW;
import cn.hanbell.crm.entity.SERAC;
import cn.hanbell.crm.jrs.model.JSONObject;
import cn.hanbell.jrs.ResponseData;
import cn.hanbell.jrs.SuperRESTForCRM;
import cn.hanbell.util.SuperEJB;
import java.util.ArrayList;
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
import javax.ws.rs.core.Response;

/**
 *
 * @author C2082
 */
@Path("crm/serac")
@javax.enterprise.context.RequestScoped
public class SERACFacadeREST extends SuperRESTForCRM<SERAC> {
    
    @EJB
    private SERACBean seracbean;
    
    public SERACFacadeREST() {
        super(SERAC.class);
    }
    
    @Override
    protected SuperEJB getSuperEJB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @GET
    @Path("wechat/problemtype/{BQ003_value}")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseData<JSONObject> findProblemType(@PathParam("BQ003_value") String BQ003_value,@QueryParam("searchWord")String AK003) {
        List<Object[]> list = seracbean.findProblemType(BQ003_value,AK003);
        if (list == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        List<JSONObject> objs = new ArrayList<>();
        JSONObject js = null;
        for (int i = 0; i < list.size(); i++) {
            js = new JSONObject();
            js.put("key", list.get(i)[0]);
            js.put("value", list.get(i)[1]);
            js.put("value1", list.get(i)[2]);//紧急度
            js.put("value2", list.get(i)[3]);//紧急度名称
            objs.add(js);
        }
        ResponseData responseData = new ResponseData("200", "seccess");
        responseData.setData(objs);
        responseData.setCount(objs.size());
        return responseData;
    }
}
