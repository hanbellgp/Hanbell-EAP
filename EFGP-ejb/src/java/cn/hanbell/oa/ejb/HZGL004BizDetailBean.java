/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HZGL004BizDetail;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author C2082
 */
@Stateless
@LocalBean
public class HZGL004BizDetailBean extends SuperEJBForEFGP<HZGL004BizDetail> {

    public HZGL004BizDetailBean() {
        super(HZGL004BizDetail.class);
    }

}
