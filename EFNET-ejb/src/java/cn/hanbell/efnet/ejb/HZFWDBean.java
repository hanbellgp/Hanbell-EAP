/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.efnet.ejb;

import cn.hanbell.efnet.comm.SuperEJBForEFNET;
import cn.hanbell.efnet.entity.HZFWD;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class HZFWDBean extends SuperEJBForEFNET<HZFWD> {

    public HZFWDBean() {
        super(HZFWD.class);
    }

}
