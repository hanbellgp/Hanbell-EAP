/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.VHFW002Grid1SERI12;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author C1587
 */
@Stateless
@LocalBean
public class VHFW002Grid1SERI12Bean extends SuperEJBForEFGP<VHFW002Grid1SERI12> {

    public VHFW002Grid1SERI12Bean() {
        super(VHFW002Grid1SERI12.class);
    }

}
