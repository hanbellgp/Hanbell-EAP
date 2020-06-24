/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.WARTB;
import java.text.DecimalFormat;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C1587
 */
@Stateless
@LocalBean
public class WARTBBean extends SuperEJBForCRM<WARTB> {

    public WARTBBean() {
        super(WARTB.class);
    }

    public WARTB findByPK(String tb001, String tb002, String tb003) {
        Query query = this.getEntityManager().createNamedQuery("WARTB.findByPK");
        query.setParameter("tb001", tb001);
        query.setParameter("tb002", tb002);
        query.setParameter("tb003", tb003);
        try {
            Object o = query.getSingleResult();
            return (WARTB) o;
        } catch (Exception ex) {
            return null;
        }
    }

    public String getDetailSerlByTA001AndTA002(String TA001, String TA002) {
        Query query = getEntityManager().createNativeQuery("Select TB003 from WARTB WHERE TB001=? and TB002=?");
        query.setParameter(1, TA001);
        query.setParameter(2, TA002);
        try {
            List<Object[]> o = query.getResultList();
            DecimalFormat decimalFormat = new DecimalFormat("0000");
            int i = 0;
            if (o != null) {
                i = o.size() + 1;
            }
            String k = decimalFormat.format(i);
            return k;
        } catch (Exception ex) {
            return null;
        }
    }
}
