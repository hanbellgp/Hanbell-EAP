/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.jrs;

import cn.hanbell.eap.ejb.SalesOrderBean;
import cn.hanbell.eap.ejb.SalesOrderProduceBean;
import cn.hanbell.eap.entity.SalesOrder;
import cn.hanbell.eap.entity.SalesOrderProduce;
import cn.hanbell.jrs.ResponseMessage;
import cn.hanbell.jrs.SuperRESTForEAP;
import com.lightshell.comm.SuperEJB;
import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;

/**
 *
 * @author C0160
 */
@Path("eap/salesorderproduce")
@javax.enterprise.context.RequestScoped
public class SalesOrderProduceFacadeREST extends SuperRESTForEAP<SalesOrderProduce> {

    @EJB
    private SalesOrderBean salesOrderBean;
    @EJB
    private SalesOrderProduceBean salesOrderProduceBean;

    public SalesOrderProduceFacadeREST() {
        super(SalesOrderProduce.class);
    }

    @Override
    protected SuperEJB getSuperEJB() {
        return salesOrderProduceBean;
    }

    @Override
    public ResponseMessage create(SalesOrderProduce entity, String appid, String token) {
        if (isAuthorized(appid, token)) {
            try {
                if (entity.getManufactureId() == null || "".equals(entity.getManufactureId())) {
                    if (entity.getManufactureDate() != null) {
                        entity.setManufactureId(salesOrderProduceBean.getFormId(entity.getManufactureDate()));
                    } else {
                        entity.setManufactureId(salesOrderProduceBean.getFormId());
                    }
                }
                getSuperEJB().persist(entity);
                SalesOrder order = salesOrderBean.findById(entity.getPid());
                if (order.getAutoUpdate()) {
                    order.sumManufactureQuantity();
                    salesOrderBean.update(order);
                }
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
    public ResponseMessage edit(PathSegment id, SalesOrderProduce entity, String appid, String token) {
        if (isAuthorized(appid, token)) {
            try {
                SalesOrderProduce t = salesOrderProduceBean.findById(Integer.parseInt(id.getPath()));
                if (t == null) {
                    return new ResponseMessage("404", "找不到对象");
                }
                getSuperEJB().update(entity);
                SalesOrder order = salesOrderBean.findById(entity.getPid());
                if (order.getAutoUpdate()) {
                    order.sumManufactureQuantity();
                    salesOrderBean.update(order);
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
    public ResponseMessage remove(PathSegment id, String appid, String token) {
        if (isAuthorized(appid, token)) {
            int pid;
            try {
                SalesOrderProduce t = salesOrderProduceBean.findById(Integer.parseInt(id.getPath()));
                if (t == null) {
                    return new ResponseMessage("404", "找不到对象");
                }
                pid = t.getPid();
                getSuperEJB().delete(t);
                SalesOrder order = salesOrderBean.findById(pid);
                if (order.getAutoUpdate()) {
                    order.sumManufactureQuantity();
                    salesOrderBean.update(order);
                }
                return new ResponseMessage("200", "删除成功");
            } catch (Exception ex) {
                log4j.error(ex);
                return new ResponseMessage("500", "系统错误删除失败");
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

}
