/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.costctrl.jrs;

import cn.hanbell.costctrl.app.MessageEnum;
import cn.hanbell.costctrl.app.MCResponseData;
import cn.hanbell.costctrl.app.RequestBody;
import cn.hanbell.costctrl.app.Research;
import cn.hanbell.crm.jrs.model.JSONObject;
import cn.hanbell.eap.ejb.CompanyBean;
import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.ejb.MiscodeBean;
import cn.hanbell.erp.entity.Miscode;
import cn.hanbell.jrs.SuperRESTForERP;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Administrator
 */
@Path("costctrl/research")
public class ResearchFacadeREST extends SuperRESTForERP<Miscode> {

    @EJB
    private MiscodeBean miscodeBean;
    @EJB
    private CompanyBean companyBean;

    public ResearchFacadeREST() {
        super(Miscode.class);
    }

    protected SuperEJBForERP getSuperEJBForERP() {
        return miscodeBean;
    }

    @POST
    @Path("get")
    @Consumes({"application/json"})
    @Produces({MediaType.APPLICATION_JSON})
    public MCResponseData findAll(RequestBody entity) {
        try {
            //判断token 是否有效
            if (entity == null) {
                return new MCResponseData(MessageEnum.Failue_107.getCode(), MessageEnum.Failue_107.getMsg());
            }
            if (!entity.checkSign()) {
                return new MCResponseData(MessageEnum.Failue_102.getCode(), MessageEnum.Failue_102.getMsg());
            }
            if (!entity.checkRequestParams()) {
                return new MCResponseData(MessageEnum.Failue_111.getCode(), MessageEnum.Failue_111.getMsg());
            }
            List<Miscode> miscodeList;
            String facno = entity.getFacno();
//            if (null == companyBean.findByCompany(facno)) {
//                return new MCResponseData(MessageEnum.Failue_111.getCode(), MessageEnum.Failue_111.getMsg());
//            }
            miscodeBean.setCompany(facno);

            int page_index = entity.getPage_index();
            int page_size = entity.getPage_size();
//            if (page_size < 1 || page_index < 1) {
//                return new MCResponseData(MessageEnum.Failue_111.getCode(), MessageEnum.Failue_111.getMsg());
//            }
            int first = (page_index - 1) * page_size;
            HashMap<String, Object> filters = new HashMap<>();
            String flag = entity.getFlag();
            if (flag != null) {
                if (flag.equals("1")) {
                    filters.put("status", 'Y');
                } else if (flag.equals("0")) {
                    filters.put("status", 'N');
                }
            }
            filters.put("miscodePK.ckind", "9J");
            int hasMore = 0;
            int totalCount = miscodeBean.getRowCount(filters);
            miscodeList = miscodeBean.findByFilters(filters, first, page_size);
            List<Research> researchs = new ArrayList<Research>();
            if (!miscodeList.isEmpty()) {
                miscodeList.forEach((Miscode m) -> {
                    Research r = new Research();
                    r.setFacno(facno);
                    r.setCode(m.getMiscodePK().getCode());
                    r.setCdesc(m.getCdesc());
                    r.setStatus(m.getStatus().toString());
                    researchs.add(r);
                }
                );
            }
            MCResponseData res = new MCResponseData(MessageEnum.SUCCESS.getCode(), MessageEnum.SUCCESS.getMsg());
            if (page_index * page_size < totalCount) {
                hasMore = 1;
            }
            JSONObject js = new JSONObject();
            js.put("has_more", hasMore);
            js.put("total_count", totalCount);
            js.put("items", researchs);
            res.setData(js);
            return res;
        } catch (Exception ex) {
            log4j.error(ex.toString());
            return new MCResponseData(MessageEnum.Failue_109.getCode(), MessageEnum.Failue_109.getMsg());
        }

    }

}
