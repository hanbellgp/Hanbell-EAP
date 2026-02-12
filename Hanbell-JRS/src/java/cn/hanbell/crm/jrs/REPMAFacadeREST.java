/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.jrs;

import cn.hanbell.crm.ejb.REPMABean;
import cn.hanbell.crm.entity.REPMA;
import cn.hanbell.jrs.SuperRESTForCRM;
import cn.hanbell.util.SuperEJB;
import javax.ejb.EJB;
import javax.ws.rs.Path;

/**
 *
 * @author Administrator
 */
@Path("crm/repma")
@javax.enterprise.context.RequestScoped
public class REPMAFacadeREST extends SuperRESTForCRM<REPMA> {

    @EJB
    private REPMABean repmaBean;

    public REPMAFacadeREST() {
        super(REPMA.class);
    }

    @Override
    protected SuperEJB getSuperEJB() {
        return repmaBean;
    }

}
