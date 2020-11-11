/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.jrs;

import cn.hanbell.eap.ejb.SalesOrderBean;
import cn.hanbell.eap.entity.SalesOrder;
import cn.hanbell.jrs.ResponseMessage;
import cn.hanbell.jrs.ResponseObject;
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
@Path("eap/salesorder")
@javax.enterprise.context.RequestScoped
public class SalesOrderFacadeREST extends SuperRESTForEAP<SalesOrder> {

    @EJB
    private SalesOrderBean salesOrderBean;

    public SalesOrderFacadeREST() {
        super(SalesOrder.class);
    }

    @Override
    protected SuperEJB getSuperEJB() {
        return salesOrderBean;
    }

    @Override
    public ResponseMessage create(SalesOrder entity, String appid, String token) {
        if (entity.getFormid() == null || "".equals(entity.getFormid())) {
            if (entity.getFormdate() != null) {
                entity.setFormid(salesOrderBean.getFormId(entity.getFormdate()));
            } else {
                entity.setFormid(salesOrderBean.getFormId());
            }
        }
        entity.setUID(salesOrderBean.getUUID());
        return super.create(entity, appid, token);
    }

    @Override
    public ResponseObject findById(PathSegment id, String appid, String token) {
        if (isAuthorized(appid, token)) {
            try {
                SalesOrder t = salesOrderBean.findByUID(id.getPath());
                ResponseObject res = new ResponseObject<>("200", "success", t);
                return res;
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

}
