/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.DSH;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class DSHBean extends SuperEJBForCRM<DSH>{

    public DSHBean() {
        super(DSH.class);
    }

}