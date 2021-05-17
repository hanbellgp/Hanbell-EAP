/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.mes.ejb;

import cn.hanbell.mes.comm.SuperEJBForMES;
import cn.hanbell.mes.entity.MuserRole;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class MuserRoleBean extends SuperEJBForMES<MuserRole>{

    public MuserRoleBean() {
        super(MuserRole.class);
    }

}
