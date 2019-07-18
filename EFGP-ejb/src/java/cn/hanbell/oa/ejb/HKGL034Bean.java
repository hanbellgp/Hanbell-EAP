/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKGL034;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.inject.Named;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
@Named
public class HKGL034Bean extends SuperEJBForEFGP<HKGL034> {

    public HKGL034Bean() {
        super(HKGL034.class);
    }

}
