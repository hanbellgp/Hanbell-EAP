/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.jrs;

import cn.hanbell.crm.jrs.model.JSONObject;
import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.ejb.MiscodeBean;
import cn.hanbell.erp.entity.ArmhadSum;
import cn.hanbell.erp.entity.Miscode;
import cn.hanbell.jrs.ResponseData;
import cn.hanbell.jrs.SuperRESTForERP;
import java.util.ArrayList;
import java.util.List;
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
@Path("shberp/miscode")
@javax.enterprise.context.RequestScoped
public class MiscodeFacadeREST  extends SuperRESTForERP<Miscode> {
    
    @EJB
    private MiscodeBean misodebean;

    public MiscodeFacadeREST() {
        super(Miscode.class);
    }

    @Override
    protected SuperEJBForERP getERPEJB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @GET
    @Path("tradingreason/{incentoryform}")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseData<JSONObject> findProductType(@PathParam("incentoryform") String incentoryform, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            String ckind = "";
            if ("FWLL".equals(incentoryform)) {
                ckind = "1A";
            } else if ("JCDF".equals(incentoryform) || "JCDX".equals(incentoryform)) {
                ckind = "1I";
            }
            List<Miscode> list = misodebean.findByCkind(ckind, 'Y');
            if (list == null) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
            List<JSONObject> objs = new ArrayList<>();
            JSONObject js = null;
            for (int i = 0; i < list.size(); i++) {
                js = new JSONObject();
                js.put("key", list.get(i).getMiscodePK().getCode());
                js.put("value", list.get(i).getCdesc());
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
