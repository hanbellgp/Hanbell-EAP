/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.Demands;
import cn.hanbell.eap.entity.Department;
import cn.hanbell.eap.entity.SystemUser;
import cn.hanbell.util.BaseLib;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author C1749
 */
@Stateless
@LocalBean
public class DemandsBean extends SuperEJBForEAP<Demands> {

    public DemandsBean() {
        super(Demands.class);
    }

    //得到需有优化单号
    public String setFormIdNumber() {
        Date date;
        String formid;
        try {
            date = BaseLib.getDate("yyyy/MM/dd", BaseLib.formatDate("yyyy/MM/dd", BaseLib.getDate()));
            formid = this.getFormId(date, "PL", "yyMM", 3, "formid");
        } catch (ParseException ex) {
            return ex.toString();
        }
        return formid;
    }
}
