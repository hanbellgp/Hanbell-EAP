/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HZCW028tDetail;
import cn.hanbell.oa.entity.HZCW033tDetail;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author C2082
 */
@Stateless
@LocalBean
public class HZCW033tDetailBean extends SuperEJBForEFGP<HZCW033tDetail> {
    
     public HZCW033tDetailBean() {
        super(HZCW033tDetail.class);
    }
}
