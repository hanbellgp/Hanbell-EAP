/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.jrs;

import cn.hanbell.crm.comm.JSONModel;
import cn.hanbell.crm.ejb.REPMIBean;
import cn.hanbell.crm.entity.REPMA;
import cn.hanbell.crm.entity.REPMI;
import cn.hanbell.jrs.SuperRESTForCRM;
import cn.hanbell.util.SuperEJB;
import com.sun.xml.xsom.impl.scd.Iterators;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.JSONObject;

/**
 *
 * @author C2082
 */
@Path("crm/repmi")
@javax.enterprise.context.RequestScoped
public class REPMIFacadeREST extends SuperRESTForCRM<REPMI> {

    @EJB
    private REPMIBean eromibean;
    public REPMIFacadeREST() {
        super(REPMI.class);
    }

    @Override
    protected SuperEJB getSuperEJB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @GET
    @Path("wechat/productNumber")
    @Produces({MediaType.APPLICATION_JSON})
    public List<JSONModel> findProductNumber() {
        return eromibean.findProductNumber();
    }
}
