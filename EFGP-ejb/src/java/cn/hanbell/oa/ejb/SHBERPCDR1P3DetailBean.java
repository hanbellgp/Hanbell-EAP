/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.SHBERPCDR1P3Detail;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class SHBERPCDR1P3DetailBean extends SuperEJBForEFGP<SHBERPCDR1P3Detail>{

    public SHBERPCDR1P3DetailBean() {
        super(SHBERPCDR1P3Detail.class);
    }

}
