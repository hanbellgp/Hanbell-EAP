/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hanbell.erp.ejb;


import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import vn.hanbell.erp.comm.SuperEJBForERP;
import vn.hanbell.erp.entity.Purdask;

/**
 *
 * @author C1491
 */
@Stateless
@LocalBean
public class PurdaskBean extends SuperEJBForERP<Purdask> {

    public PurdaskBean() {
        super(Purdask.class);
    }
}
