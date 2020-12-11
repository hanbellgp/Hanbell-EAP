/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.REPTA;
import cn.hanbell.util.BaseLib;
import java.util.Date;
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
public class REPTABean extends SuperEJBForCRM<REPTA> {

    public REPTABean() {
        super(REPTA.class);
    }

    public REPTA findByPK(String ta001, String ta002) {
        Query query = getEntityManager().createNamedQuery("REPTA.findByPK");
        query.setParameter("ta001", ta001);
        query.setParameter("ta002", ta002);
        try {
            return (REPTA) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }

    }

    public String getTA002ByTA001AndDate(String ta001, Date date) {
        String ls_no = "";
        String ls_ta002 = "";
        String serial = "000";
        ls_ta002 = BaseLib.formatDate("yyyyMMdd", date);
        String sql = "SELECT * FROM REPTA WHERE TA001 = '" + ta001 + "' and TA002 LIKE '" + ls_ta002 + "%' ORDER BY TA002 DESC ";
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

    public List<Object[]> getReptaByTA001AndTA031(String ta001, String ta002) {
        StringBuffer sql = new StringBuffer("SELECT TA002,TA003,TA004,TA009,TA005,TA006,TA007,TA013, TA500 ,TA197,TA198,TA071,TA010,TA017 FROM REPTA WHERE TA001=? and TA031='0'");
        if (ta002 != null && !"".equals(ta002)) {
            sql = sql.append(" and TA002 like '%").append(ta002).append("%'");
        }
        sql.append(" order by CREATE_DATE desc");
        try {
            Query query = getEntityManager().createNativeQuery(sql.toString());
            query.setParameter(1, ta001);
            List<Object[]> result = query.getResultList();
            return result;
        } catch (Exception ex) {
            return null;
        }
    }
}
