/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.SHBERPMIS226InvwhclkDetail;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class SHBERPMIS226InvwhclkDetailBean extends SuperEJBForEFGP<SHBERPMIS226InvwhclkDetail> {

    public SHBERPMIS226InvwhclkDetailBean() {
        super(SHBERPMIS226InvwhclkDetail.class);
    }

}
