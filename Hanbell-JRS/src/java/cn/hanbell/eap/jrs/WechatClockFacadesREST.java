/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.jrs;

import cn.hanbell.eap.app.CardRecordListApplication;
import cn.hanbell.eap.ejb.WechatClockBean;
import cn.hanbell.eap.entity.WechatClock;
import cn.hanbell.jrs.ResponseMessage;
import cn.hanbell.jrs.SuperRESTForEAP;
import cn.hanbell.util.BaseLib;
import com.lightshell.comm.SuperEJB;
import java.util.Date;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author C2082
 */
@Path("eap/wechatclock")
public class WechatClockFacadesREST extends SuperRESTForEAP<WechatClock> {

    @EJB
    private WechatClockBean qyWechatCardRecordBean;

    protected final Logger log4j = LogManager.getLogger("cn.hanbell.wco");
    
    public WechatClockFacadesREST() {
        super(WechatClock.class);
    }

    @Override
    protected SuperEJB getSuperEJB() {
        return qyWechatCardRecordBean;
    }

    @POST
    @Path("create")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public ResponseMessage create(CardRecordListApplication records) {
        for (WechatClock r : records.getRecords()) {
            long date = Long.valueOf(r.getCheckintime()) * 1000;
            r.setCheckintime(BaseLib.formatDate("yyyy/MM/dd HH:mm", new Date(date)));
            if (qyWechatCardRecordBean.hasExistPersist(r) == false) {
                try {
                    qyWechatCardRecordBean.persist(r);
                } catch (Exception e) {
                    log4j.warn(("抛转OA数据失败："+r.toString()));
                }

            }
        }
        ResponseMessage message = new ResponseMessage("200", "抛转成功");
        return message;
    }
}
