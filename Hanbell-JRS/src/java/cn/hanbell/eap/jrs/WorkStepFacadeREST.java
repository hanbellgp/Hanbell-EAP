/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.jrs;

import cn.hanbell.eap.ejb.WorkStepBean;
import cn.hanbell.eap.entity.WorkStep;
import cn.hanbell.jrs.ResponseData;
import cn.hanbell.jrs.SuperRESTForEAP;
import com.lightshell.comm.SuperEJB;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;

/**
 *
 * @author C0160
 */
@Path("eap/workstep")
public class WorkStepFacadeREST extends SuperRESTForEAP<WorkStep> {

    @EJB
    private WorkStepBean workStepBean;

    public WorkStepFacadeREST() {
        super(WorkStep.class);
    }

    @Override
    protected SuperEJB getSuperEJB() {
        return workStepBean;
    }

    @GET
    @Path("steps/{uid}")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseData findByContextUID(@PathParam("uid") PathSegment uid, @QueryParam("appid") String appid,
            @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            try {
                List<WorkStep> data = workStepBean.findByContextUID(uid.getPath());
                ResponseData res = new ResponseData<WorkStep>("200", "success");
                if (data != null) {
                    res.setData(data);
                    res.setCount(data.size());
                }
                return res;
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

}
