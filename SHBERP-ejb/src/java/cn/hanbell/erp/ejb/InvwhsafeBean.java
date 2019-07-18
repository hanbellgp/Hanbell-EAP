/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Invbal;
import cn.hanbell.erp.entity.Invwhsafe;
import cn.hanbell.erp.entity.InvwhsafePK;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author C1587
 */
@Stateless
@LocalBean
public class InvwhsafeBean extends SuperEJBForERP<Invwhsafe> {

    @EJB
    private InvbalBean invbalBean;

    public InvwhsafeBean() {
        super(Invwhsafe.class);
    }

    public Boolean initINVWHSAFE(String a, String b) {

        return true;
    }

}
