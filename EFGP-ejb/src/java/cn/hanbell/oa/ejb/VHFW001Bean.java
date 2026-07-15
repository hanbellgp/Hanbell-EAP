/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.VHFW001;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author ZFF
 */
@Stateless
@LocalBean
public class VHFW001Bean extends SuperEJBForEFGP<VHFW001> {

    public VHFW001Bean() {
        super(VHFW001.class);
    }

}
