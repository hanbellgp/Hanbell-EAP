/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.jrs;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.ejb.CdrcusBean;
import cn.hanbell.erp.entity.Cdrcus;
import cn.hanbell.jrs.SuperRESTForERP;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author C0160
 */
@Path("shberp/cdrcus")
@javax.enterprise.context.RequestScoped
public class CdrcusFacadeREST extends SuperRESTForERP<Cdrcus> {

    @EJB
    private CdrcusBean cdrcusBean;

    @Override
    protected SuperEJBForERP getSuperEJBForERP() {
        company = "C";
        return cdrcusBean;
    }

    public CdrcusFacadeREST() {
        super(Cdrcus.class);
    }

    @GET
    @Path("list/{man}")
    @Produces({"application/json"})
    public List<Cdrcus> findByMan(@PathParam("man") String man) {
        return cdrcusBean.findByMan(man);
    }

}
