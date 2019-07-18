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
@Path("efgp/bizkind")
@javax.enterprise.context.RequestScoped
public class BizKindFacadeREST extends SuperRESTForEFGP<KV> {

    public BizKindFacadeREST() {
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
                dataList.add(new KV("1", "业务推展"));
                dataList.add(new KV("2", "售后服务"));
                dataList.add(new KV("3", "厂商洽谈"));
                dataList.add(new KV("4", "培训"));
                dataList.add(new KV("7", "其他"));
                return dataList;
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

}
