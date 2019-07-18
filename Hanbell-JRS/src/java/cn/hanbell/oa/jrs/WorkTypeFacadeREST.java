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
@Path("efgp/worktype")
@javax.enterprise.context.RequestScoped
public class WorkTypeFacadeREST extends SuperRESTForEFGP<KV> {

    public WorkTypeFacadeREST() {
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
                dataList.add(new KV("1", "常日班：08：00-17：10"));
                dataList.add(new KV("2", "加工早班：08：00-20：20"));
                dataList.add(new KV("3", "加工晚班：20：00-8：20"));
                dataList.add(new KV("4", "三次元早班：08:00-20:20"));
                dataList.add(new KV("5", "三次元晚班：20：00-08：20"));
                dataList.add(new KV("6", "试车早班：08：00-16：10"));
                dataList.add(new KV("7", "试车中班：16：00-00：10"));
                dataList.add(new KV("8", "试车晚班：00：00-08：10"));
                dataList.add(new KV("9", "装配早班：08：00-16：30"));
                dataList.add(new KV("10", "装配中班：16：10-00：40"));
                dataList.add(new KV("11", "物流早班：07：00-16：10"));
                dataList.add(new KV("12", "物流中班：13：00-21：40"));
                dataList.add(new KV("13", "特殊班别：09：00-16：10"));
                return dataList;
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

}
