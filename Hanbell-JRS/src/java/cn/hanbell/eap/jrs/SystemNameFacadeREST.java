/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.jrs;

import cn.hanbell.eap.entity.SystemName;
import cn.hanbell.jrs.ResponseData;
import cn.hanbell.jrs.SuperRESTForEAP;
import com.lightshell.comm.SuperEJB;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author C0160
 */
@Path("eap/systemname")
public class SystemNameFacadeREST extends SuperRESTForEAP<SystemName> {

    public SystemNameFacadeREST() {
        super(SystemName.class);
    }

    @Override
    protected SuperEJB getSuperEJB() {
        return systemNameBean;
    }

    @GET
    @Path("query")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseData query(@QueryParam("q") String q, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            try {
                List<SystemName> list = systemNameBean.findByNameOrDescript(q);
                int count = getSuperEJB().getRowCount();
                ResponseData res = new ResponseData<SystemName>("200", "success");
                res.setData(list);
                res.setCount(list.size());
                return res;
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

}
