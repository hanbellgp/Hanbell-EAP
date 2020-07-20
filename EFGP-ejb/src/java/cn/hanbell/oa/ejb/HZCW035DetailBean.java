/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HZCW035;
import cn.hanbell.oa.entity.HZCW035Detail;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author C2082
 */
@Stateless
@LocalBean
public class HZCW035DetailBean extends SuperEJBForEFGP<HZCW035Detail>{
    
    public HZCW035DetailBean() {
        super(HZCW035Detail.class);
    }
    
}
