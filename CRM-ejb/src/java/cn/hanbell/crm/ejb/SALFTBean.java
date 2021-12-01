/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.SALFT;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class SALFTBean extends SuperEJBForCRM<SALFT> {

    public SALFTBean() {
        super(SALFT.class);
    }

    //事务回滚
    public void rollback() {
        this.getEntityManager().getTransaction().rollback();
    }
    
}
