/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.jrs;

import cn.hanbell.jrs.SuperRESTForEFGP;
import cn.hanbell.oa.app.KV;
import cn.hanbell.oa.comm.SuperEJBForEFGP;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 *
 * @author C0160
 */
@Path("efgp/bizvehicle")
@javax.enterprise.context.RequestScoped
public class BizVehicleFacadeREST extends SuperRESTForEFGP<KV> {

    public BizVehicleFacadeREST() {
        super(KV.class);
    }

    @Override
    protected SuperEJBForEFGP getSuperEJB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<KV> findAll(String appid, String token) {
        if (isAuthorized(appid, token)) {
            try {
                List<KV> dataList = new ArrayList<>();
                dataList.add(new KV("1", "公务车"));
                dataList.add(new KV("2", "长途巴士"));
                dataList.add(new KV("3", "高铁"));
                dataList.add(new KV("4", "火车"));
                dataList.add(new KV("5", "飞机"));
                dataList.add(new KV("6", "其他"));
                return dataList;
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

}
