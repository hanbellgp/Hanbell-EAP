/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKGL016;
import cn.hanbell.oa.entity.HKGL082;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 *
 * @author C2082
 */
@Stateless
@LocalBean
@Named
public class HKGL082Bean extends SuperEJBForEFGP<HKGL082> {

    public HKGL082Bean() {
        super(HKGL082.class);
    }

}
