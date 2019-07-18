/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.jrs;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.ejb.ItemKindBean;
import cn.hanbell.erp.entity.ItemKind;
import cn.hanbell.jrs.SuperRESTForERP;
import cn.hanbell.util.SuperEJB;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.Path;

/**
 *
 * @author C0160
 */
@Path("shberp/itemkind")
@javax.enterprise.context.RequestScoped
public class ItemKindFacadeREST extends SuperRESTForERP<ItemKind> {

    @EJB
    private ItemKindBean itemKindBean;

    @Override
    protected SuperEJBForERP getERPEJB() {
        company = "C";
        return itemKindBean;
    }

    public ItemKindFacadeREST() {
        super(ItemKind.class);
    }

}
