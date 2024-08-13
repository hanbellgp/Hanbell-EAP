/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HZGL004carDetail;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author ZFF
 */
@Stateless
@LocalBean
public class HZGL004carDetailBean extends SuperEJBForEFGP<HZGL004carDetail> {

    public HZGL004carDetailBean() {
        super(HZGL004carDetail.class);
    }

}
