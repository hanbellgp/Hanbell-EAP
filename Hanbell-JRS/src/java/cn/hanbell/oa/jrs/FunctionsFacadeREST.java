/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.jrs;

import cn.hanbell.jrs.ResponseObject;
import cn.hanbell.jrs.SuperRESTForEFGP;
import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.ejb.FunctionLevelBean;
import cn.hanbell.oa.ejb.FunctionsBean;
import cn.hanbell.oa.ejb.UsersBean;
import cn.hanbell.oa.entity.FunctionLevel;
import cn.hanbell.oa.entity.Functions;
import cn.hanbell.oa.entity.Users;
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
@Path("efgp/functions")
@javax.enterprise.context.RequestScoped
public class FunctionsFacadeREST extends SuperRESTForEFGP<Functions> {

    @EJB
    private FunctionsBean funtionsBean;

    @EJB
    private UsersBean usersBean;

    @EJB
    private FunctionLevelBean functionLevelBean;

    @Override
    protected SuperEJBForEFGP getSuperEJB() {
        return funtionsBean;
    }

    public FunctionsFacadeREST() {
        super(Functions.class);
    }

    @GET
    @Path("{filters}/{sorts}/{offset}/{pageSize}/size")
    @Produces({MediaType.APPLICATION_JSON})
    public FunctionsResponseResult findByFiltersWithSize(@PathParam("filters") PathSegment filters,
            @PathParam("sorts") PathSegment sorts, @PathParam("offset") Integer offset,
            @PathParam("pageSize") Integer pageSize, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            data = super.find(filters, sorts, offset, pageSize);
            FunctionsResponseResult r = new FunctionsResponseResult();
            for (Map.Entry<Integer, List<Functions>> entrySet : data.entrySet()) {
                r.setSize(entrySet.getKey());
                r.setResult(entrySet.getValue());
            }
            return r;
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("functionlevel/manager/{id}/{level}")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseObject<Users> findManagerByIdAndLevel(@PathParam("id") String userid, @PathParam("level") String level, @QueryParam("appid") String appid, @QueryParam("token") String token) {
        //获取当前员工的部门职等。
        if (isAuthorized(appid, token)) {
            ResponseObject resp = new ResponseObject("200", "success");
            Users entity = usersBean.findUserByUserno(userid);
            Functions function = funtionsBean.findByUserOIDAndIsMain(entity.getOid());
            //搜查的职等
            List<FunctionLevel> fuctionLevels = functionLevelBean.findByFunctionLevelName(level);
            if (function != null && fuctionLevels != null && !fuctionLevels.isEmpty()) {
                //当前员工的职等相同或者小于搜查的职等（OA中的职等越小代表职位越高）
                if (function.getFunctionLevel().getLevelValue() <= fuctionLevels.get(0).getLevelValue()) {
                    resp.setObject(entity);
                    return resp;
                } else {
                    //根据部门往上找经理级
                    try {
                        Users user = getManager(fuctionLevels.get(0).getLevelValue(), function.getOrganizationUnit().getOid(), null);
                        if (user == null) {
                            user = getManager(fuctionLevels.get(0).getLevelValue() - 1000, function.getOrganizationUnit().getOid(), null);
                        }
                        System.out.print("user=" + user);
                        resp.setObject(user);
                        return resp;
                    } catch (Exception ex) {
                        //找不到，防止递归出现空指针的情况
                        ex.printStackTrace();
                    }
                }
            }
            resp = new ResponseObject("500", "faild");
            return resp;
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    public Users getManager(int functionlevel, String organizationOid, Users user) throws Exception {
        while (true) {
            List<Functions> functions = funtionsBean.findByOrgUnitOID(organizationOid);
            if (functions == null || functions.isEmpty()) {
                return null;
            } else {
                for (Functions entity : functions) {
                    if (entity.getFunctionLevel().getLevelValue() == functionlevel) {
                        user = entity.getUsers();
                        return user;
                    }
                }
                organizationOid = functions.get(0).getOrganizationUnit().getSuperUnitOID();
            }
        }
    }
}

class FunctionsResponseResult {

    private Integer size;
    private List<Functions> result;

    public FunctionsResponseResult() {

    }

    /**
     * @return the size
     */
    public Integer getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * @return the result
     */
    public List<Functions> getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(List<Functions> result) {
        this.result = result;
    }

}
