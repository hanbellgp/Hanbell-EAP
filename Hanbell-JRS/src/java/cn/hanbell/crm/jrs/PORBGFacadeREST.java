/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.jrs;

import cn.hanbell.crm.ejb.PORBGBean;
import cn.hanbell.crm.entity.PORBG;
import cn.hanbell.crm.entity.WARMA;
import cn.hanbell.jrs.SuperRESTForCRM;
import cn.hanbell.util.SuperEJB;
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
public class PORBGFacadeREST extends SuperRESTForCRM<PORBG>{

    @EJB
    private PORBGBean porbgbean;
    
    public PORBGFacadeREST(Class<PORBG> entityClass) {
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
    @Path("wechat/product")
    @Produces({MediaType.APPLICATION_JSON})
    public List<PORBG> findProduct(){
      return porbgbean.findAll();
    }
}
