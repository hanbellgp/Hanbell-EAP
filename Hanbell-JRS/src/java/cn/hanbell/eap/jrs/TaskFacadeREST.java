/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.jrs;

import cn.hanbell.eap.ejb.TaskBean;
import cn.hanbell.eap.entity.Task;
import cn.hanbell.jrs.ResponseData;
import cn.hanbell.jrs.SuperRESTForEAP;
import com.lightshell.comm.SuperEJB;
import java.util.List;
import javax.ejb.EJB;
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
@Path("eap/task")
public class TaskFacadeREST extends SuperRESTForEAP<Task> {

    @EJB
    private TaskBean taskBean;

    public TaskFacadeREST() {
        super(Task.class);
    }

    @Override
    protected SuperEJB getSuperEJB() {
        return taskBean;
    }

    @GET
    @Path("executor")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseData findByExecutor(@QueryParam("executorid") String executorid, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            try {
                List<Task> list = taskBean.findByExecutorIdAndStatus(executorid, "N");
                ResponseData res = new ResponseData<Task>("200", "获取成功");
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
