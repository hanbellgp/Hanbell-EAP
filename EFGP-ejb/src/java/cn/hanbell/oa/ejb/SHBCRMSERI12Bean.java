/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.SHBCRMSERI12;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class SHBCRMSERI12Bean extends SuperEJBForEFGP<SHBCRMSERI12> {

    public SHBCRMSERI12Bean() {
        super(SHBCRMSERI12.class);
    }

}
