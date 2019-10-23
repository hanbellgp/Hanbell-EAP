/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hanbell.erp.ejb;

import vn.hanbell.erp.comm.SuperEJBForERP;
import vn.hanbell.erp.entity.Purdaskdsc;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class PurdaskdscBean extends SuperEJBForERP<Purdaskdsc> {

    public PurdaskdscBean() {
        super(Purdaskdsc.class);
    }

}
