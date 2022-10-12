/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HZPB131;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
/**
 *
 * @author C2082
 */

@Stateless
@LocalBean
public class HZPB131Bean extends SuperEJBForEFGP<HZPB131> {
    public HZPB131Bean() {
        super(HZPB131.class);
    }
}

