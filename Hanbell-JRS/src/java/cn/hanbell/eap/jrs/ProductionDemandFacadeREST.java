/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.jrs;

import cn.hanbell.eap.ejb.ProductBean;
import cn.hanbell.eap.ejb.ProductionPlanBean;
import cn.hanbell.eap.ejb.SalesOrderBean;
import cn.hanbell.eap.entity.Product;
import cn.hanbell.eap.entity.ProductBom;
import cn.hanbell.eap.entity.ProductionPlan;
import cn.hanbell.erp.ejb.InvbalBean;
import cn.hanbell.erp.ejb.InvmasBean;
import cn.hanbell.erp.ejb.ManwipbalBean;
import cn.hanbell.erp.ejb.PurdtaBean;
import cn.hanbell.erp.entity.Invmas;
import cn.hanbell.jrs.ResponseData;
import cn.hanbell.jrs.ResponseMessage;
import cn.hanbell.jrs.SuperRESTForEAP;
import cn.hanbell.util.BaseLib;
import com.lightshell.comm.SuperEJB;
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
@Path("eap/productiondemand")
public class ProductionDemandFacadeREST extends SuperRESTForEAP<ProductionPlan> {

    @EJB
    private ProductBean productBean;
    @EJB
    private ProductionPlanBean productionPlanBean;
    @EJB
    private SalesOrderBean salesOrderBean;

    @EJB
    private InvbalBean invbalBean;
    @EJB
    private InvmasBean invmasBean;
    @EJB
    private ManwipbalBean manwipbalBean;
    @EJB
    private PurdtaBean purdtaBean;

    public ProductionDemandFacadeREST() {
        super(ProductionPlan.class);
    }

    @Override
    protected SuperEJB getSuperEJB() {
        return productionPlanBean;
    }

    @Override
    public ResponseMessage create(ProductionPlan entity, String appid, String token) {
        throw new WebApplicationException(Response.Status.NOT_ACCEPTABLE);
    }

    @Override
    public ResponseMessage edit(PathSegment id, ProductionPlan entity, String appid, String token) {
        throw new WebApplicationException(Response.Status.NOT_ACCEPTABLE);
    }

    @Override
    public ResponseMessage remove(PathSegment id, String appid, String token) {
        throw new WebApplicationException(Response.Status.NOT_ACCEPTABLE);
    }

    @GET
    @Path("{company}/{itemmodel}/{baseday}")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseData findByDemand(@PathParam("company") PathSegment company, @PathParam("itemmodel") PathSegment itemmodel, @PathParam("baseday") PathSegment baseday, @QueryParam("appid") String appid,
            @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            try {
                // baseday传入格式yyyyMMdd
                String facno = company.getPath();
                String model = itemmodel.getPath();
                String month = baseday.getPath().substring(0, 6);
                Date date = BaseLib.getDate("yyyyMMdd", baseday.getPath());

                List<Object[]> planSummary = productionPlanBean.getSummary(model, month);
                List<Object[]> demandSummary = salesOrderBean.getSummary(model, month);

                // 产品型号对应的品号
                List<String> itemList = new ArrayList<>();
                List<Product> productList = productBean.findByItemModel(model);
                productList.forEach((p) -> {
                    itemList.add(p.getItemno());
                });
                // 查询ERP库存
                invbalBean.setCompany(facno);
                BigDecimal inv = invbalBean.getInvbalQuantity(facno, itemList);
                // 查询ERP在制
                manwipbalBean.setCompany(facno);
                BigDecimal wip = manwipbalBean.getTotalWIPQuantity(facno, itemList);
                // 查询ERP未进
                purdtaBean.setCompany(facno);
                BigDecimal po = purdtaBean.getAvailableQuantity(facno, itemList, date);

                String mon = "", series = "", itemno = "", itemModel = "";
                BigDecimal total = BigDecimal.ZERO;
                List<Map<String, Object>> data = new ArrayList<>();
                Map<String, Object> obj = null;
                for (int i = 0; i < planSummary.size(); i++) {
                    if (mon.equals(planSummary.get(i)[0].toString()) && series.equals(planSummary.get(i)[1].toString())
                            && itemno.equals(planSummary.get(i)[2].toString())
                            && itemModel.equals(planSummary.get(i)[3].toString())) {
                        if (obj != null) {
                            obj.put("d" + BaseLib.formatDate("yyyyMMdd", (Date) planSummary.get(i)[4]), planSummary.get(i)[5]);
                            total = total.add((BigDecimal) planSummary.get(i)[5]);
                            obj.put("total", total);
                        }
                    } else {
                        obj = new HashMap<>();
                        obj.put("kind", "50");
                        obj.put("mon", planSummary.get(i)[0]);
                        obj.put("productSeries", planSummary.get(i)[1]);
                        obj.put("itemno", planSummary.get(i)[2]);
                        obj.put("itemModel", planSummary.get(i)[3]);
                        obj.put("d" + BaseLib.formatDate("yyyyMMdd", (Date) planSummary.get(i)[4]), planSummary.get(i)[5]);
                        total = (BigDecimal) planSummary.get(i)[5];
                        obj.put("total", total);
                        data.add(obj);
                    }
                    mon = planSummary.get(i)[0].toString();
                    series = planSummary.get(i)[1].toString();
                    itemno = planSummary.get(i)[2].toString();
                    itemModel = planSummary.get(i)[3].toString();
                }
                mon = "";
                series = "";
                itemno = "";
                itemModel = "";
                total = BigDecimal.ZERO;
                for (int i = 0; i < demandSummary.size(); i++) {
                    if (mon.equals(demandSummary.get(i)[0].toString()) && series.equals(demandSummary.get(i)[1].toString())
                            && itemno.equals(demandSummary.get(i)[2].toString())
                            && itemModel.equals(demandSummary.get(i)[3].toString())) {
                        if (obj != null) {
                            obj.put("d" + BaseLib.formatDate("yyyyMMdd", (Date) demandSummary.get(i)[4]), demandSummary.get(i)[5]);
                            total = total.add((BigDecimal) demandSummary.get(i)[5]);
                            obj.put("total", total);
                        }
                    } else {
                        obj = new HashMap<>();
                        obj.put("kind", "10");
                        obj.put("mon", demandSummary.get(i)[0]);
                        obj.put("productSeries", demandSummary.get(i)[1]);
                        obj.put("itemno", demandSummary.get(i)[2]);
                        obj.put("itemModel", demandSummary.get(i)[3]);
                        obj.put("d" + BaseLib.formatDate("yyyyMMdd", (Date) demandSummary.get(i)[4]), demandSummary.get(i)[5]);
                        total = (BigDecimal) demandSummary.get(i)[5];
                        obj.put("total", total);
                        data.add(obj);
                    }
                    mon = demandSummary.get(i)[0].toString();
                    series = demandSummary.get(i)[1].toString();
                    itemno = demandSummary.get(i)[2].toString();
                    itemModel = demandSummary.get(i)[3].toString();
                }
                // 库存
                obj = new HashMap<>();
                obj.put("kind", "20");
                obj.put("mon", month);
                obj.put("productSeries", series);
                obj.put("itemno", itemno);
                obj.put("itemModel", model);
                obj.put("d" + baseday.getPath(), inv);
                obj.put("total", inv);
                data.add(obj);
                // 在制
                obj = new HashMap<>();
                obj.put("kind", "30");
                obj.put("mon", month);
                obj.put("productSeries", series);
                obj.put("itemno", itemno);
                obj.put("itemModel", model);
                obj.put("d" + baseday.getPath(), wip);
                obj.put("total", wip);
                data.add(obj);
                // 未进
                obj = new HashMap<>();
                obj.put("kind", "40");
                obj.put("mon", month);
                obj.put("productSeries", series);
                obj.put("itemno", itemno);
                obj.put("itemModel", model);
                obj.put("d" + baseday.getPath(), po);
                obj.put("total", po);
                data.add(obj);
                // 排序
                data.sort((Map<String, Object> o1, Map<String, Object> o2) -> {
                    if (o1.get("itemModel").toString().compareTo(o2.get("itemModel").toString()) < 1 && o1.get("kind").toString().compareTo(o2.get("kind").toString()) < 1) {
                        return -1;
                    } else {
                        return 1;
                    }
                });
                String itnbr;
                Invmas invmas;
                List<Map<String, Object>> extData = new ArrayList<>();
                itemList.clear();
                for (Product p : productList) {
                    // 获取子阶可用数量
                    if (p.getBOM() != null) {
                        for (ProductBom pb : p.getBOM()) {
                            itnbr = pb.getItemno();
                            if (itemList.contains(itnbr)) {
                                continue;
                            }
                            invmasBean.setCompany(facno);
                            invmas = invmasBean.findByItnbr(itnbr);
                            if (invmas == null) {
                                continue;
                            }
                            inv = BigDecimal.ZERO;
                            wip = BigDecimal.ZERO;
                            po = BigDecimal.ZERO;
                            // 查询ERP库存
                            invbalBean.setCompany(facno);
                            inv = invbalBean.getInvbalQuantity(facno, itnbr);
                            if ("P".equals(invmas.getMorpcode())) {
                                // 查询ERP未进
                                purdtaBean.setCompany(facno);
                                po = purdtaBean.getAvailableQuantity(facno, itnbr, date);
                            } else {
                                // 查询ERP在制
                                manwipbalBean.setCompany(facno);
                                wip = manwipbalBean.getTotalWIPQuantity(facno, itnbr);
                                // 查询ERP未进
                                purdtaBean.setCompany(facno);
                                po = purdtaBean.getAvailableQuantity(facno, itnbr, date);
                            }

                            obj = new HashMap<>();
                            obj.put("kind", "20");
                            obj.put("mon", month);
                            obj.put("productSeries", series);
                            obj.put("itemno", itnbr);
                            obj.put("itemModel", String.valueOf(pb.getSeq()) + "-" + pb.getItemModel());
                            obj.put("d" + baseday.getPath(), inv);
                            obj.put("total", inv);
                            extData.add(obj);

                            obj = new HashMap<>();
                            obj.put("kind", "30");
                            obj.put("mon", month);
                            obj.put("productSeries", series);
                            obj.put("itemno", itnbr);
                            obj.put("itemModel", String.valueOf(pb.getSeq()) + "-" + pb.getItemModel());
                            obj.put("d" + baseday.getPath(), wip);
                            obj.put("total", wip);
                            extData.add(obj);

                            obj = new HashMap<>();
                            obj.put("kind", "40");
                            obj.put("mon", month);
                            obj.put("productSeries", series);
                            obj.put("itemno", itnbr);
                            obj.put("itemModel", String.valueOf(pb.getSeq()) + "-" + pb.getItemModel());
                            obj.put("d" + baseday.getPath(), po);
                            obj.put("total", po);
                            extData.add(obj);
                        }
                        // 排序
                        extData.sort((Map<String, Object> o1, Map<String, Object> o2) -> {
                            if (o1.get("itemModel").toString().compareTo(o2.get("itemModel").toString()) < 1 && o1.get("kind").toString().compareTo(o2.get("kind").toString()) < 1) {
                                return -1;
                            } else {
                                return 1;
                            }
                        });
                    }
                }
                // 响应消息
                ResponseData res = new ResponseData<ProductionPlan>("200", "success");
                res.setData(data);
                res.setCount(data.size());
                res.getExtData().put("children", extData);
                return res;
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

}
