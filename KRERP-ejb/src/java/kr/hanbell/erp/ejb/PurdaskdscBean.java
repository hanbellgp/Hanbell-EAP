/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kr.hanbell.erp.ejb;

import kr.hanbell.erp.comm.SuperEJBForERP;
import kr.hanbell.erp.entity.Purdaskdsc;
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
