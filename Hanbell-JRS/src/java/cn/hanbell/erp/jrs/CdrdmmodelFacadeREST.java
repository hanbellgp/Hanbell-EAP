/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.jrs;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.ejb.CdrdmmodelBean;
import cn.hanbell.erp.entity.Cdrdmmodel;
import cn.hanbell.jrs.SuperRESTForERP;
import javax.ejb.EJB;
import javax.ws.rs.Path;

/**
 *
 * @author C0160
 */
@Path("shberp/cdrdmmodel")
@javax.enterprise.context.RequestScoped
public class CdrdmmodelFacadeREST extends SuperRESTForERP<Cdrdmmodel> {

    @EJB
    private CdrdmmodelBean cdrdmmodelBean;

    @Override
    protected SuperEJBForERP getSuperEJBForERP() {
        return cdrdmmodelBean;
    }

    public CdrdmmodelFacadeREST() {
        super(Cdrdmmodel.class);
    }

}
