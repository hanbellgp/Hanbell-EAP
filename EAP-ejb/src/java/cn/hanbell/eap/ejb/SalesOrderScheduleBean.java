/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.SalesOrderSchedule;
import cn.hanbell.util.BaseLib;
import java.util.Date;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class SalesOrderScheduleBean extends SuperEJBForEAP<SalesOrderSchedule> {

    public SalesOrderScheduleBean() {
        super(SalesOrderSchedule.class);
    }

    public String getFormId() {
        return getFormId(BaseLib.getDate());
    }

    public String getFormId(Date day) {
        return super.getFormId(day, "VM", "yyMM", 4, "manufactureId");
    }

}
