/*
 * To change this license header, choose License Headers in Project Properties. To change this template file, choose
 * Tools | Templates and open the template in the editor.
 */
package cn.hanbell.erp.jrs;

import cn.hanbell.eap.ejb.ShipmentScheduleBean;
import cn.hanbell.eap.entity.ShipmentSchedule;
import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.ejb.InvbalBean;
import cn.hanbell.erp.entity.Invbal;
import cn.hanbell.erp.entity.InvbalPK;
import cn.hanbell.jrs.ResponseMessage;
import cn.hanbell.jrs.SuperRESTForERP;
import cn.hanbell.util.BaseLib;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;

/**
 *
 * @author C0160
 */
@Path("shberp/invbal")
public class InvbalFacadeREST extends SuperRESTForERP<Invbal> {

    @EJB
    private InvbalBean invbalBean;

    @EJB
    private ShipmentScheduleBean shipmentScheduleBean;

    @Override
    protected SuperEJBForERP getSuperEJBForERP() {
        return invbalBean;
    }

    public InvbalFacadeREST() {
        super(Invbal.class);
    }

    private InvbalPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;itnbr=itnbrValue;facno=facnoValue;prono=pronoValue;wareh=warehValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        cn.hanbell.erp.entity.InvbalPK key = new cn.hanbell.erp.entity.InvbalPK();
        MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> itnbr = map.get("itnbr");
        if (itnbr != null && !itnbr.isEmpty()) {
            key.setItnbr(itnbr.get(0));
        }
        java.util.List<String> facno = map.get("facno");
        if (facno != null && !facno.isEmpty()) {
            key.setFacno(facno.get(0));
        }
        java.util.List<String> prono = map.get("prono");
        if (prono != null && !prono.isEmpty()) {
            key.setProno(prono.get(0));
        }
        java.util.List<String> wareh = map.get("wareh");
        if (wareh != null && !wareh.isEmpty()) {
            key.setWareh(wareh.get(0));
        }
        return key;
    }

    @POST
    @Path("shipmentschedule/{company}/{shipdate}")
    @Produces({"application/json"})
    public ResponseMessage updateShipmentScheduleStock(@PathParam("company") PathSegment company,
        @PathParam("shipdate") PathSegment shipdate, @QueryParam("appid") String appid,
        @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            try {
                this.company = company.getPath();
                Date formdateBegin = BaseLib.getDate("yyyy-MM-dd", shipdate.getPath());
                Date formdateEnd = BaseLib.getDate("yyyy-MM-dd", shipdate.getPath());
                String wareh = company.getMatrixParameters().getFirst("wareh");
                List<String> warehList = null;
                if (wareh != null && !"".equals(wareh)) {
                    warehList = Arrays.asList(wareh.split(","));
                }
                List<ShipmentSchedule> ssList =
                    shipmentScheduleBean.findByCompanyFormdateAndStatus(this.company, formdateBegin, formdateEnd, "N");
                if (ssList != null && !ssList.isEmpty()) {
                    invbalBean.setCompany(this.company);
                    for (ShipmentSchedule ss : ssList) {
                        BigDecimal qty = invbalBean.getInvbalQuantity(ss.getCompany(), ss.getItemno(), warehList);
                        ss.setInvqty(qty);
                        ss.setDiffqty(ss.getInvqty().subtract(ss.getAppqty()));
                    }
                    shipmentScheduleBean.update(ssList);
                }
                return new ResponseMessage("200", "更新库存成功");
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

}
