/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.SHBERPINV310Detail;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class SHBERPINV130DetailBean extends SuperEJBForEFGP<SHBERPINV310Detail> {

    public SHBERPINV130DetailBean() {
        super(SHBERPINV310Detail.class);
    }

}
