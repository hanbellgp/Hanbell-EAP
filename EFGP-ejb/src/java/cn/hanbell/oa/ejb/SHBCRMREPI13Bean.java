/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.SHBCRMREPI13;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class SHBCRMREPI13Bean extends SuperEJBForEFGP<SHBCRMREPI13> {

    public SHBCRMREPI13Bean() {
        super(SHBCRMREPI13.class);
    }

}
