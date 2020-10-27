/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.jrs;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.ejb.CdrcusBean;
import cn.hanbell.erp.ejb.CdrdmmodelBean;
import cn.hanbell.erp.entity.Cdrcus;
import cn.hanbell.erp.entity.Cdrdmmodel;
import cn.hanbell.jrs.ResponseData;
import cn.hanbell.jrs.SuperRESTForERP;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;

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
