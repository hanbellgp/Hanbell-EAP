/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.SHBERPMIS226;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author C1587
 */
@Stateless
@LocalBean
public class SHBERPMIS226Bean extends SuperEJBForEFGP<SHBERPMIS226>{
    
    public SHBERPMIS226Bean(){
        super(SHBERPMIS226.class);
    }

}
