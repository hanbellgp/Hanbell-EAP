/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.jrs;

import cn.hanbell.eap.ejb.ShipmentScheduleBean;
import cn.hanbell.eap.entity.ShipmentSchedule;
import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.ejb.ManmasBean;
import cn.hanbell.erp.ejb.ManwipbalBean;
import cn.hanbell.erp.entity.Manmas;
import cn.hanbell.jrs.ResponseData;
import cn.hanbell.jrs.SuperRESTForERP;
import cn.hanbell.util.BaseLib;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;

/**
 *
 * @author C0160
 */
@Path("shberp/shipmentshortage")
public class ShipmentShortageFacadeREST extends SuperRESTForERP<Manmas> {

    @EJB
    private ShipmentScheduleBean shipmentScheduleBean;

    @EJB
    private ManmasBean manmasBean;

    @EJB
    private ManwipbalBean manwipbalBean;

    @Override
    protected SuperEJBForERP getSuperEJBForERP() {
        return manmasBean;
    }

    public ShipmentShortageFacadeREST() {
        super(Manmas.class);
    }

    @GET
    @Path("{company}/{shipdate}")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseData findByCompanyAndShipdate(@PathParam("company") PathSegment company,
            @PathParam("shipdate") PathSegment shipdate, @QueryParam("offset") Integer offset,
            @QueryParam("pageSize") Integer pageSize, @QueryParam("appid") String appid,
            @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            try {
                List<Map<String, Object>> data = new ArrayList<>();
                Map<String, Object> obj;
                this.company = company.getPath();
                Date queryDate = BaseLib.getDate("yyyy-MM-dd", shipdate.getPath());
                manmasBean.setCompany(this.company);
                manwipbalBean.setCompany(this.company);

                List<ShipmentSchedule> scheduleList = shipmentScheduleBean.findByCompanyAndFormdate(this.company, queryDate, true, offset, pageSize);
                int count = shipmentScheduleBean.getRowCountByCompanyAndFormdate(this.company, queryDate, true);

                if (scheduleList != null && !scheduleList.isEmpty()) {
                    for (ShipmentSchedule ss : scheduleList) {
                        // 获取在制数量
                        List result = manwipbalBean.getWIPQuantity(this.company, ss.getItemno());
                        // 创建返回对象
                        obj = new HashMap<>();
                        obj.put("formdate", ss.getFormdate());
                        obj.put("customer", ss.getCustomer());
                        obj.put("itemno", ss.getItemno());
                        obj.put("itemDesc", ss.getItemDesc());
                        obj.put("itemSpec", ss.getItemSpec());
                        obj.put("appqty", ss.getAppqty());
                        obj.put("invqty", ss.getInvqty());
                        obj.put("diffqty", ss.getInvqty().subtract(ss.getAppqty()));
                        obj.put("description", ss.getDescription());
                        obj.put("tag", ss.getTag());
                        if (result != null && !result.isEmpty()) {
                            int seqnr;
                            BigDecimal wip;
                            BigDecimal wipFront = BigDecimal.ZERO;
                            BigDecimal wipEnd = BigDecimal.ZERO;

                            for (int i = 0; i < result.size(); i++) {
                                Object[] row = (Object[]) result.get(i);
                                seqnr = Integer.valueOf(row[2].toString());
                                wip = BigDecimal.valueOf(Double.valueOf(row[3].toString()));
                                obj.put("wip" + String.valueOf(seqnr), wip);
                                obj.put("wipfin", BigDecimal.valueOf(Double.valueOf(row[4].toString())));
                                if (seqnr < 40) {
                                    wipFront = wipFront.add(wip);
                                } else {
                                    wipEnd = wipEnd.add(wip);
                                }
                            }
                            obj.put("wipfront", wipFront);
                            obj.put("wipend", wipEnd);
                        }
                        data.add(obj);
                    }
                }
                ResponseData res = new ResponseData<Manmas>("200", "success");
                res.setData(data);
                res.setCount(count);
                return res;
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

}
