/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.VHFW004Detail;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * 
 */
@Stateless
@LocalBean
public class VHFW004DetailBean extends SuperEJBForEFGP<VHFW004Detail> {

    public VHFW004DetailBean() {
        super(VHFW004Detail.class);
    }

}
