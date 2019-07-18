/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.jrs;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Invwh;
import cn.hanbell.jrs.SuperRESTForERP;
import javax.ejb.Stateless;
import javax.ws.rs.Path;

/**
 *
 * @author C0160
 */
@Stateless
@Path("shberp/invwh")
public class InvwhFacadeREST extends SuperRESTForERP<Invwh> {

    public InvwhFacadeREST() {
        super(Invwh.class);
    }

    @Override
    protected SuperEJBForERP getERPEJB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
