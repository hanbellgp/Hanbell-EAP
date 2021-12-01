/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.costctrl.jrs;

import cn.hanbell.costctrl.app.MessageEnum;
import cn.hanbell.costctrl.app.MCDepartment;
import cn.hanbell.costctrl.app.MCResponseData;
import cn.hanbell.costctrl.app.MCResponsePageData;
import cn.hanbell.costctrl.app.RequestBody;
import cn.hanbell.crm.jrs.model.JSONObject;
import cn.hanbell.jrs.SuperRESTForEFGP;
import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.ejb.OrganizationUnitBean;
import cn.hanbell.oa.entity.OrganizationUnit;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Administrator
 */
@Path("costctrl/dept")
public class MCDepartmentFacadeREST extends SuperRESTForEFGP<OrganizationUnit> {

    @EJB
    private OrganizationUnitBean organizationUnitBean;

    public MCDepartmentFacadeREST() {
        super(OrganizationUnit.class);
    }

    @Override
    protected SuperEJBForEFGP getSuperEJB() {
        return organizationUnitBean;
    }

    @POST
    @Path("get")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public MCResponseData findAll(RequestBody entity) {
        try {
            //判断token 是否有效
            if (entity == null) {
                return new MCResponseData(MessageEnum.Failue_107.getCode(), MessageEnum.Failue_107.getMsg());
            }
            if (!entity.checkSign()) {
                return new MCResponseData(MessageEnum.Failue_102.getCode(), MessageEnum.Failue_102.getMsg());
            }
            List<MCDepartment> deptList = new ArrayList<>();
            int page_index = entity.getPage_index();
            int page_size = entity.getPage_size();
            if (page_size < 1 || page_index < 1) {
                return new MCResponseData(MessageEnum.Failue_105.getCode(), MessageEnum.Failue_105.getMsg());
            }
            String flag = entity.getFlag();
            int hasMore = 0;
            Object arr[] = organizationUnitBean.getPageListAndAllCount(flag, page_index, page_size);
            if (null == arr || arr[1] == null) {
                return new MCResponseData(MessageEnum.Failue_109.getCode(), MessageEnum.Failue_109.getMsg());
            }
            int totalCount = (int) arr[0];
            List objList = (List) arr[1];
            for (int i = 0; i < objList.size(); i++) {
                Object[] row = (Object[]) objList.get(i);
                MCDepartment mc = new MCDepartment(row[0].toString(), row[1] == null ? "" : row[1].toString(), row[2] == null ? "" : row[2].toString(), row[3] == null ? "" : row[3].toString(), row[4] == null ? "" : row[4].toString());
                deptList.add(mc);
            }

//            objList.forEach((Object[] row) -> {
//                MCDepartment mc = new MCDepartment(row[0].toString(), row[1].toString(), row[2].toString(), row[3].toString(), row[4].toString());
//                deptList.add(mc);
//            });
            MCResponseData res = new MCResponseData(MessageEnum.SUCCESS.getCode(), MessageEnum.SUCCESS.getMsg());
            if (page_index * page_size < totalCount) {
                hasMore = 1;
            }
            if (page_index * page_size < totalCount) {
                hasMore = 1;
            }
            JSONObject js = new JSONObject();
            js.put("has_more", hasMore);
            js.put("total_count", totalCount);
            js.put("items", deptList);
            res.setData(js);
            return res;
        } catch (Exception ex) {
            ex.printStackTrace();
            log4j.error(ex.toString());
            return new MCResponseData(MessageEnum.Failue_109.getCode(), MessageEnum.Failue_109.getMsg());
        }

    }

}
