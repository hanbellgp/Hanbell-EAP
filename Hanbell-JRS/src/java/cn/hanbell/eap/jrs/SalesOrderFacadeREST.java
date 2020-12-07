/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.jrs;

import cn.hanbell.eap.ejb.SalesOrderBean;
import cn.hanbell.eap.ejb.WorkStepBean;
import cn.hanbell.eap.entity.SalesOrder;
import cn.hanbell.eap.entity.WorkStep;
import cn.hanbell.jrs.ResponseMessage;
import cn.hanbell.jrs.ResponseObject;
import cn.hanbell.jrs.SuperRESTForEAP;
import com.lightshell.comm.SuperEJB;
import java.util.List;
import java.util.Objects;
import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;

/**
 *
 * @author C0160
 */
@Path("eap/salesorder")
public class SalesOrderFacadeREST extends SuperRESTForEAP<SalesOrder> {

    @EJB
    private SalesOrderBean salesOrderBean;
    @EJB
    private WorkStepBean workStepBean;

    public SalesOrderFacadeREST() {
        super(SalesOrder.class);
    }

    @Override
    protected SuperEJB getSuperEJB() {
        return salesOrderBean;
    }

    @Override
    public ResponseMessage create(SalesOrder entity, String appid, String token) {
        if (isAuthorized(appid, token)) {
            try {
                if (entity.getFormid() == null || "".equals(entity.getFormid())) {
                    if (entity.getFormdate() != null) {
                        entity.setFormid(salesOrderBean.getFormId(entity.getFormdate()));
                    } else {
                        entity.setFormid(salesOrderBean.getFormId());
                    }
                }
                entity.setCredateToNow();
                entity.setUID(salesOrderBean.getUUID());
                salesOrderBean.persist(entity);
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
    public ResponseMessage edit(PathSegment id, SalesOrder entity, String appid, String token) {
        if (isAuthorized(appid, token)) {
            try {
                SalesOrder t = salesOrderBean.findById(Integer.parseInt(id.getPath()));
                if (t == null) {
                    return new ResponseMessage("404", "找不到对象");
                }
                if (!Objects.equals(t.getOptdate(), entity.getOptdate())) {
                    return new ResponseMessage("409", "修改冲突");
                }
                entity.setOptdateToNow();
                salesOrderBean.update(entity);
                // 更新WorkStep
                if (!Objects.equals(t.getCurrentStep(), entity.getCurrentStep())) {
                    WorkStep step = workStepBean.findByContextUIDAndSeq(entity.getUID(), entity.getCurrentStep());
                    if (step != null) {
                        step.setCfmuser(entity.getOptuser());
                        step.setCfmdate(entity.getOptdate());
                        workStepBean.update(step);
                    }
                }
                return new ResponseMessage("200", "更新成功");
            } catch (Exception ex) {
                return new ResponseMessage("500", "系统错误更新失败");
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @Override
    public ResponseObject findById(PathSegment id, String appid, String token) {
        if (isAuthorized(appid, token)) {
            try {
                SalesOrder t = salesOrderBean.findByUID(id.getPath());
                List<WorkStep> steps = workStepBean.findByContextUID(t.getUID());
                ResponseObject res = new ResponseObject<>("200", "success", t);
                if (steps != null) {
                    res.getExtData().put("steps", steps);
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
