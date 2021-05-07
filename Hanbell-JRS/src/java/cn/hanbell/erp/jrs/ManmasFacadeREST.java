/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.jrs;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.ejb.ManmasBean;
import cn.hanbell.erp.ejb.ManwipbalBean;
import cn.hanbell.erp.entity.Manmas;
import cn.hanbell.erp.entity.Manwipbal;
import cn.hanbell.jrs.ResponseData;
import cn.hanbell.jrs.SuperRESTForERP;
import cn.hanbell.util.BaseLib;
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
@Path("shberp/manmas")
public class ManmasFacadeREST extends SuperRESTForERP<Manmas> {

    @EJB
    private ManmasBean manmasBean;

    @EJB
    private ManwipbalBean manwipbalBean;

    @Override
    protected SuperEJBForERP getSuperEJBForERP() {
        return manmasBean;
    }

    public ManmasFacadeREST() {
        super(Manmas.class);
    }

    @GET
    @Path("wipbal/{company}/{linecode}/{mandateBegin}/{mandateEnd}")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseData findWIPByLinecodeAndMandate(@PathParam("company") PathSegment company,
            @PathParam("linecode") PathSegment linecode, @PathParam("mandateBegin") PathSegment mandateBegin,
            @PathParam("mandateEnd") PathSegment mandateEnd, @QueryParam("offset") Integer offset,
            @QueryParam("pageSize") Integer pageSize, @QueryParam("appid") String appid,
            @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            try {
                List<Map<String, Object>> data = new ArrayList<>();
                Map<String, Object> obj = null;
                this.company = company.getPath();
                String queryLine = linecode.getPath();
                Date queryDateBegin = BaseLib.getDate("yyyy-MM-dd", mandateBegin.getPath());
                Date queryDateEnd = BaseLib.getDate("yyyy-MM-dd", mandateEnd.getPath());
                manmasBean.setCompany(this.company);
                manwipbalBean.setCompany(this.company);
                List<Manmas> list = manmasBean.findByLinecodeAndMandate(this.company, queryLine, queryDateBegin,
                        queryDateEnd, offset, pageSize);
                int count = manmasBean.getRowCountByLinecodeAndMandate(this.company, queryLine, queryDateBegin,
                        queryDateEnd);
                if (list != null) {
                    for (Manmas m : list) {
                        List<Manwipbal> wipbalList = manwipbalBean.findByManno(this.company,
                                m.getManmasPK().getManno());
                        obj = new HashMap<>();
                        obj.put("manmas", m);
                        for (Manwipbal wipbal : wipbalList) {
                            obj.put("wip" + String.valueOf(wipbal.getSeqnr()), wipbal.getOnhand1());
                            obj.put("wipfin", wipbal.getFinqy1());
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

    @GET
    @Path("wipbal/{company}/{itemno}/{mandate}")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseData findWIPByItemnoAndMandate(@PathParam("company") PathSegment company,
            @PathParam("itemno") PathSegment itemno,
            @PathParam("mandate") PathSegment mandate, @QueryParam("offset") Integer offset,
            @QueryParam("pageSize") Integer pageSize, @QueryParam("appid") String appid,
            @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            try {
                List<Map<String, Object>> data = new ArrayList<>();
                Map<String, Object> obj = null;
                this.company = company.getPath();
                String queryItemno = itemno.getPath();
                Date queryDateBegin = BaseLib.getDate("yyyy-MM-dd", "2021-01-01");
                Date queryDateEnd = BaseLib.getDate("yyyy-MM-dd", mandate.getPath());
                manmasBean.setCompany(this.company);
                manwipbalBean.setCompany(this.company);
                List<Manmas> list = manmasBean.findByItnbrfAndMandate(this.company, queryItemno, queryDateBegin,
                        queryDateEnd, offset, pageSize);
                int count = manmasBean.getRowCountByItnbrfAndMandate(this.company, queryItemno, queryDateBegin,
                        queryDateEnd);
                if (list != null) {
                    for (Manmas m : list) {
                        List<Manwipbal> wipbalList = manwipbalBean.findByManno(this.company,
                                m.getManmasPK().getManno());
                        obj = new HashMap<>();
                        obj.put("manmas", m);
                        for (Manwipbal wipbal : wipbalList) {
                            obj.put("wip" + String.valueOf(wipbal.getSeqnr()), wipbal.getOnhand1());
                            obj.put("wipfin", wipbal.getFinqy1());
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
