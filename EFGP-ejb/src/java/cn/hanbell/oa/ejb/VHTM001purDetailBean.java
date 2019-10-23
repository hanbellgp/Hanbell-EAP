/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.VHTM001purDetail;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class VHTM001purDetailBean extends SuperEJBForEFGP<VHTM001purDetail>{

    public VHTM001purDetailBean() {
        super(VHTM001purDetail.class);
    }

}
