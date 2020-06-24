/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.jrs;

import cn.hanbell.eap.comm.TaskContextFactory;
import cn.hanbell.eap.context.TaskContext;
import cn.hanbell.eap.ejb.DemandsBean;
import cn.hanbell.eap.entity.Demands;
import cn.hanbell.eap.entity.Task;
import cn.hanbell.jrs.ResponseMessage;
import cn.hanbell.jrs.SuperRESTForEAP;
import com.lightshell.comm.SuperEJB;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
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
@Path("eap/demands")
@javax.enterprise.context.RequestScoped
public class DemandsFacadeREST extends SuperRESTForEAP<Demands> {

    @EJB
    private DemandsBean demandsBean;

    public DemandsFacadeREST() {
        super(Demands.class);
    }

    @Override
    protected SuperEJB getSuperEJB() {
        return demandsBean;
    }

    @Override
    public ResponseMessage create(Demands entity, String appid, String token) {
        entity.setFormid(demandsBean.getFormId(entity.getFormdate()));
        return super.create(entity, appid, token);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("task")
    public ResponseMessage createTask(Demands entity, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            try {
                TaskContext context = TaskContextFactory.createTaskContext("D");
                Task task = context.updateTask(entity);
                if (task != null && "V".equals(task.getStatus())) {
                    return new ResponseMessage("202", "任务已经结案");
                } else {
                    return new ResponseMessage("200", "创建或更新任务成功");
                }
            } catch (Exception ex) {
                return new ResponseMessage("500", "系统错误更新失败");
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

}
