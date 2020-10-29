/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.jrs;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.ejb.PurvdrBean;
import cn.hanbell.erp.entity.Purvdr;
import cn.hanbell.jrs.SuperRESTForERP;
import javax.ejb.EJB;
import javax.ws.rs.Path;

/**
 *
 * @author C0160
 */
@Path("shberp/purvdr")
@javax.enterprise.context.RequestScoped
public class PurvdrFacadeREST extends SuperRESTForERP<Purvdr> {

    @EJB
    private PurvdrBean purvdrBean;

    @Override
    protected SuperEJBForERP getSuperEJBForERP() {
        company = "C";
        return purvdrBean;
    }

    public PurvdrFacadeREST() {
        super(Purvdr.class);
    }

}
