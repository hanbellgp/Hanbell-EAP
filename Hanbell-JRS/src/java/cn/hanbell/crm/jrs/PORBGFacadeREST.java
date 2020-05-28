/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.jrs;

import cn.hanbell.crm.ejb.PORBGBean;
import cn.hanbell.crm.entity.DFWEL;
import cn.hanbell.crm.entity.PORBG;
import cn.hanbell.crm.entity.WARMA;
import cn.hanbell.crm.jrs.model.JSONObject;
import cn.hanbell.jrs.ResponseData;
import cn.hanbell.jrs.SuperRESTForCRM;
import cn.hanbell.util.SuperEJB;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author C2082
 */
@Path("crm/porbg")
@javax.enterprise.context.RequestScoped
public class PORBGFacadeREST extends SuperRESTForCRM<PORBG> {

    @EJB
    private PORBGBean porbgbean;

    public PORBGFacadeREST() {
        super(PORBG.class);
    }

    @Override
    protected SuperEJB getSuperEJB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return
     */
    @GET
    @Path("wechat/area")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseData<PORBG> findProduct() {
        ResponseData response = new ResponseData("200", "success");
        List<PORBG> list = porbgbean.findAll();
          List<JSONObject> objs=new ArrayList<>();
        JSONObject js=null;
        for(PORBG p:list){
        js=new JSONObject();
        js.put("key", p.getBg001());
        js.put("value", p.getBg002());
        objs.add(js);
        }
        response.setCount(objs.size());
        response.setData(objs);
        return response;
    }
}
