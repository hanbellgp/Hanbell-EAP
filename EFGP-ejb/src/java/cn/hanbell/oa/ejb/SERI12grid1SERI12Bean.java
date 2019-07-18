/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.SERI12grid1SERI12;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author C1587
 */
@Stateless
@LocalBean
public class SERI12grid1SERI12Bean extends SuperEJBForEFGP<SERI12grid1SERI12> {

    public SERI12grid1SERI12Bean() {
        super(SERI12grid1SERI12.class);
    }

}
