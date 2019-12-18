/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKPB054WLDetail;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author C1749
 */
@Stateless
@LocalBean
public class HKPB054WLDetailBean extends SuperEJBForEFGP<HKPB054WLDetail> {

    public HKPB054WLDetailBean() {
        super(HKPB054WLDetail.class);
    }
}
