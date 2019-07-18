/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKJS007;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author C1749
 */
@Stateless
@LocalBean
public class HKJS007Bean extends SuperEJBForEFGP<HKJS007> {

    public HKJS007Bean() {
        super(HKJS007.class);
    }
}
