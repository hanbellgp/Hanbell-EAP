/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.jrs;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.ejb.ItemCategoryBean;
import cn.hanbell.erp.entity.ItemCategory;
import cn.hanbell.jrs.SuperRESTForERP;
import javax.ejb.EJB;
import javax.ws.rs.Path;

/**
 *
 * @author C0160
 */
@Path("shberp/itemcategory")
public class ItemCategoryFacadeREST extends SuperRESTForERP<ItemCategory> {

    @EJB
    private ItemCategoryBean itemCategoryBean;

    @Override
    protected SuperEJBForERP getSuperEJBForERP() {
        company = "C";
        return itemCategoryBean;
    }

    public ItemCategoryFacadeREST() {
        super(ItemCategory.class);
    }

}
