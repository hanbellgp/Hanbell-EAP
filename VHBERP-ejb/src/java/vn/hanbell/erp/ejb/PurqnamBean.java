/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hanbell.erp.ejb;

import vn.hanbell.erp.comm.SuperEJBForERP;
import vn.hanbell.erp.entity.Purqnam;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author C1491
 */
@Stateless
@LocalBean
public class PurqnamBean extends SuperEJBForERP<Purqnam> {

    public PurqnamBean() {
        super(Purqnam.class);
    }

}
