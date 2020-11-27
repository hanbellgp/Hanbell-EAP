/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.jrs;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.ejb.InvmasBean;
import cn.hanbell.erp.entity.Invmas;
import cn.hanbell.jrs.SuperRESTForERP;
import javax.ejb.EJB;
import javax.ws.rs.Path;

/**
 *
 * @author Administrator
 */
@Path("shberp/invmas")
public class InvmasFacadeREST extends SuperRESTForERP<Invmas> {

    @EJB
    private InvmasBean invmasBean;

    @Override
    protected SuperEJBForERP getSuperEJBForERP() {
        return invmasBean;
    }

    public InvmasFacadeREST() {
        super(Invmas.class);
    }

}
