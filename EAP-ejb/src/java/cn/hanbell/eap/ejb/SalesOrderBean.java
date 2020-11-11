/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.SalesOrder;
import cn.hanbell.util.BaseLib;
import java.util.Date;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class SalesOrderBean extends SuperEJBForEAP<SalesOrder> {

    public SalesOrderBean() {
        super(SalesOrder.class);
    }

    public SalesOrder findByUID(String uid) {
        Query query = getEntityManager().createNamedQuery("SalesOrder.findByUID");
        query.setParameter("uid", uid);
        try {
            Object o = query.getSingleResult();
            return (SalesOrder) o;
        } catch (Exception ex) {
            return null;
        }
    }

    public String getFormId() {
        return getFormId(BaseLib.getDate());
    }

    public String getFormId(Date day) {
        return super.getFormId(day, "VO", "yyMM", 4);
    }

}
