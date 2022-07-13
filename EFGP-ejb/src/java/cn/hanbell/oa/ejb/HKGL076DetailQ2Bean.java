/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKGL076DetailQ1;
import cn.hanbell.oa.entity.HKGL076DetailQ2;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author C2082
 */
@Stateless
@LocalBean
public class HKGL076DetailQ2Bean extends SuperEJBForEFGP<HKGL076DetailQ2> {

    public HKGL076DetailQ2Bean() {
        super(HKGL076DetailQ2.class);
    }

}
