/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.jrs;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.ejb.InvwhBean;
import cn.hanbell.erp.entity.Invwh;
import cn.hanbell.jrs.SuperRESTForERP;
import javax.ejb.EJB;
import javax.ws.rs.Path;

/**
 *
 * @author C0160
 */
@Path("shberp/invwh")
public class InvwhFacadeREST extends SuperRESTForERP<Invwh> {

    @EJB
    private InvwhBean invwhBean;

    @Override
    protected SuperEJBForERP getSuperEJBForERP() {
        return invwhBean;
    }

    public InvwhFacadeREST() {
        super(Invwh.class);
    }

}
