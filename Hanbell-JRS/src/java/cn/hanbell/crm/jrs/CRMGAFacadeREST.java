/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.jrs;

import cn.hanbell.crm.entity.CRMGA;
import cn.hanbell.erp.ejb.MiscodeBean;
import cn.hanbell.jrs.SuperRESTForCRM;
import cn.hanbell.util.SuperEJB;
import javax.ejb.EJB;
import javax.ws.rs.Path;

/**
 *
 * @author C2082
 */
@Path("crm/crmga")
@javax.enterprise.context.RequestScoped
public class CRMGAFacadeREST extends SuperRESTForCRM<CRMGA> {

    @EJB
    private MiscodeBean misodebean;

    public CRMGAFacadeREST() {
        super(CRMGA.class);
    }

    @Override
    protected SuperEJB getSuperEJB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}
