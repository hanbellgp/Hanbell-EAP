/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKGL076DetailQ1;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author C2082
 */
@Stateless
@LocalBean
public class HKGL076DetailQ1Bean extends SuperEJBForEFGP<HKGL076DetailQ1> {

    public HKGL076DetailQ1Bean() {
        super(HKGL076DetailQ1.class);
    }

}
