/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKPB054DetailB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author C1749
 */
@Stateless
@LocalBean
public class HKPB054DetailBBean extends SuperEJBForEFGP<HKPB054DetailB> {

    public HKPB054DetailBBean() {
        super(HKPB054DetailB.class);
    }

}
