/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKCW025Detail;
import cn.hanbell.oa.entity.HKCW026Detail;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author C2082
 */
@Stateless
@LocalBean
public class HKCW026DetailBean extends SuperEJBForEFGP<HKCW026Detail> {

    public HKCW026DetailBean() {
        super(HKCW026Detail.class);
    }

}
