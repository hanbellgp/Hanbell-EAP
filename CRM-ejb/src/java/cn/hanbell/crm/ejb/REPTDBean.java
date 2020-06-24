/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.REPTD;
import java.text.DecimalFormat;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class REPTDBean extends SuperEJBForCRM<REPTD> {

    public REPTDBean() {
        super(REPTD.class);
    }

    public REPTD findByPK(String td001, String td002, String td003) {
        Query query = getEntityManager().createNamedQuery("REPTD.findByPK");
        query.setParameter("td001", td001);
        query.setParameter("td002", td002);
        query.setParameter("td003", td003);
        try {
            Object o = query.getSingleResult();
            return (REPTD) o;
        } catch (Exception e) {
            return null;
        }
    }

    public String getTD003ByTD001AndTD002(String td001, String td022) {
        Query query = getEntityManager().createNativeQuery("Select TD003 from REPTD WHERE TD001=? and TD002=?");
        query.setParameter(1, td001);
        query.setParameter(2, td022);
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

