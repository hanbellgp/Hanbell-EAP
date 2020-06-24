/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.WARTA;
import cn.hanbell.util.BaseLib;
import java.util.Date;
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
public class WARTABean extends SuperEJBForCRM<WARTA> {

    public WARTABean() {
        super(WARTA.class);
    }

    public WARTA findByPK(String ta001, String ta002) {
        Query query = this.getEntityManager().createNamedQuery("WARTA.findByPK");
        query.setParameter("ta001", ta001);
        query.setParameter("ta002", ta002);
        try {
            Object o = query.getSingleResult();
            return (WARTA) o;
        } catch (Exception ex) {
            return null;
        }
    }
    
    public String getTA002ByTA001AndDate(String ta001, Date date) {
        String ls_no = "";
        String ls_ta002 = "";
        String serial = "000";
        ls_ta002 = BaseLib.formatDate("yyyyMMdd", date);
        String sql = "SELECT * FROM WARTA WHERE TA001 = '" + ta001 + "' and TA002 LIKE '" + ls_ta002 + "%' ORDER BY TA002 DESC ";
        Query query = getEntityManager().createNativeQuery(sql);
        List result = query.getResultList();
        int m = 0;
        if (null != result && !result.isEmpty()) {
            m = result.size();
            m = m + 1;
        } else {
            m = 1;
        }
        serial = serial + m;
        serial = serial.substring(String.valueOf(m).length());
        ls_no += ls_ta002;
        ls_no += serial;
        return ls_no;
    }
    

}
