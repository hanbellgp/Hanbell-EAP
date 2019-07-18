/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.BudgetAcc;
import cn.hanbell.erp.entity.BudgetCenterAccDetail;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class BudgetCenterAccDetailBean extends SuperEJBForERP<BudgetCenterAccDetail>{
        
    public BudgetCenterAccDetailBean() {
        super(BudgetCenterAccDetail.class);
    }

}
