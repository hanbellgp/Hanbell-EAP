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
@Path("efgp/leavekind")
@javax.enterprise.context.RequestScoped
public class LeaveKindFacadeREST extends SuperRESTForEFGP<KV> {

    public LeaveKindFacadeREST() {
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
                dataList.add(new KV("1", "年休假"));
                dataList.add(new KV("2", "事假"));
                dataList.add(new KV("3", "病假"));
                dataList.add(new KV("4", "婚假"));
                dataList.add(new KV("5", "产检假"));
                dataList.add(new KV("6", "产假"));
                dataList.add(new KV("7", "陪产假"));
                dataList.add(new KV("8", "哺乳假"));
                dataList.add(new KV("9", "无薪假"));
                dataList.add(new KV("10", "工伤假"));
                dataList.add(new KV("11", "公假"));
                dataList.add(new KV("12", "丧假"));
                dataList.add(new KV("13", "补休假"));
                return dataList;
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

}
