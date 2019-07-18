/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.war.lazy;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Cdrcus;
import cn.hanbell.war.web.BaseLazyModelForERP;

/**
 *
 * @author C0160
 */
public class CdrcusModel extends BaseLazyModelForERP<Cdrcus> {

    public CdrcusModel(SuperEJBForERP superEJB, String company) {
        this.superEJB = superEJB;
        this.company = company;
    }

}
