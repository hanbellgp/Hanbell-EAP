/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.jrs;

import cn.hanbell.jrs.ResponseMessage;
import cn.hanbell.jrs.SuperRESTForEFGP;
import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.ejb.HSPB015Bean;
import cn.hanbell.oa.ejb.WorkFlowBean;
import cn.hanbell.oa.entity.HSPB015;
import cn.hanbell.wco.ejb.Agent1000002Bean;
import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;

/**
 *
 * @author C0160
 */
@Path("efgp/hspb015")
public class HSPB015FacadeREST extends SuperRESTForEFGP<HSPB015> {

    @EJB
    private Agent1000002Bean agent1000002Bean;

    @EJB
    private HSPB015Bean hspb015Bean;
    @EJB
    private WorkFlowBean workFlowBean;

    @Override
    protected SuperEJBForEFGP getSuperEJB() {
        return hspb015Bean;
    }

    public HSPB015FacadeREST() {
        super(HSPB015.class);
    }

    @Override
    public ResponseMessage completeWorkItem(HSPB015 entity, PathSegment oid, PathSegment userid, String appid, String token) {
        if (isAuthorized(appid, token)) {
            try {
                workFlowBean.completeWorkItem(workFlowBean.HOST_ADD, workFlowBean.HOST_PORT, oid.getPath(), userid.getPath(), "Approve On Mobile Dev");
                return new ResponseMessage("200", "OK");
            } catch (Exception ex) {
                return new ResponseMessage("500", ex.getMessage());
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @Override
    public ResponseMessage sendWeComMessage(String psn, String step, String appid, String token) {
        if (isAuthorized(appid, token)) {
            agent1000002Bean.initConfiguration();
            agent1000002Bean.sendMsgToUser("C0160", "text", "Hello Kevin");
            return new ResponseMessage("200", "OK");
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

}
