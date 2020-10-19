/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.jrs;

import cn.hanbell.eap.ejb.ConferenceDataBean;
import cn.hanbell.eap.entity.ConferenceData;

import cn.hanbell.jrs.ResponseData;
import cn.hanbell.jrs.SuperRESTForEAP;
import com.lightshell.comm.SuperEJB;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 *
 * @author C1491
 */
@Path("eap/conferencedata")
public class ConferenceDataFacadeREST extends SuperRESTForEAP<ConferenceData> {
    
    @EJB
    private ConferenceDataBean confDataBean;
    
    public ConferenceDataFacadeREST() {
        super(ConferenceData.class);
    }

    @Override
    protected SuperEJB getSuperEJB() {
        return confDataBean;
    }

    @Override
    public ResponseData findByQuery(String q, String appid, String token) {
        if (isAuthorized(appid, token)) {
            try {
                List<ConferenceData> list = confDataBean.findByConferenceCodeOrName(q);
                int count = getSuperEJB().getRowCount();
                ResponseData res = new ResponseData<ConferenceData>("200", "success");
                res.setData(list);
                res.setCount(list.size());
                return res;
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

}
