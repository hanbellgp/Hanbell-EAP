/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.jrs;

import cn.hanbell.crm.ejb.SERACBean;
import cn.hanbell.crm.entity.REPPW;
import cn.hanbell.crm.entity.SERAC;
import cn.hanbell.jrs.SuperRESTForCRM;
import cn.hanbell.util.SuperEJB;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author C2082
 */
@Path("crm/serac")
@javax.enterprise.context.RequestScoped
public class SERACFacadeREST extends SuperRESTForCRM<SERAC> {

    @EJB
    private SERACBean seracbean;

    public SERACFacadeREST() {
        super(SERAC.class);
    }

    @Override
    protected SuperEJB getSuperEJB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @GET
    @Path("wechat/problemtype")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Map<String,String>> findProblemType(String BQ003_value) {
        return seracbean.findProblemType(BQ003_value);
    }
}
