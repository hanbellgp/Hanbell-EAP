/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.edw.ejb;

import cn.hanbell.edw.comm.SuperEJBForEDW;
import cn.hanbell.edw.entity.RdpmOrderOA;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author C1491
 */
@Stateless
@LocalBean
public class RdpmOrderOABean extends SuperEJBForEDW<RdpmOrderOA> {

    public RdpmOrderOABean() {
        super(RdpmOrderOA.class);
    }

}
