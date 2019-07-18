/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.jrs;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.ejb.ItemFaultBean;
import cn.hanbell.erp.entity.ItemFault;
import cn.hanbell.jrs.SuperRESTForERP;
import javax.ejb.EJB;
import javax.ws.rs.Path;

/**
 *
 * @author C0160
 */
@Path("shberp/itemfault")
@javax.enterprise.context.RequestScoped
public class ItemFaultFacadeREST extends SuperRESTForERP<ItemFault> {

    @EJB
    private ItemFaultBean itemFaultBean;

    @Override
    protected SuperEJBForERP getERPEJB() {
        company = "C";
        return itemFaultBean;
    }

    public ItemFaultFacadeREST() {
        super(ItemFault.class);
    }

}
