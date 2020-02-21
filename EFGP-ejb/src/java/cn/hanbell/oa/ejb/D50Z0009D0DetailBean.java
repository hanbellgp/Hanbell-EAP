/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.D50Z0009D0;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author C2082
 */
@Stateless
@LocalBean
public class D50Z0009D0DetailBean extends SuperEJBForEFGP<D50Z0009D0> {
    public D50Z0009D0DetailBean() {
        super(D50Z0009D0.class);
    }
}

