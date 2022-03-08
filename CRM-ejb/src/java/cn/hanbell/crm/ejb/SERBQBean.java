/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.SERBQ;
import cn.hanbell.util.BaseLib;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C1587
 */
@Stateless
@LocalBean
public class SERBQBean extends SuperEJBForCRM<SERBQ> {

    public SERBQBean() {
        super(SERBQ.class);
    }

    public SERBQ findByBq001(String bq001) {
        Query query = this.getEntityManager().createNamedQuery("SERBQ.findByBq001");
        query.setParameter("bq001", bq001);
        try {
            Object o = query.getSingleResult();
            return (SERBQ) o;
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Object[]> getD50Z0009D0FW(String bq001, String bq112, String createDateBegin, String createDateEnd) {
        StringBuffer sql = new StringBuffer();
        sql.append(" select BQ.BQ001 ,sum(TC091),sum(TC026),0.0,BQ.BQ510");
        sql.append(" from  REPTC TC");
        sql.append(" left join SERBQ BQ on BQ.BQ001=TC.TC054");
        sql.append(" where BQ.BQ001 is not null ");
        if (bq001 != null && !"".equals(bq001)) {
            sql.append(" and BQ.BQ001 like '%").append(bq001).append("%'");
        }
        if (bq112 != null && !"".equals(bq112)) {
            sql.append(" and BQ.BQ112 like '%").append(bq112).append("%'");
        }
        if (createDateBegin != null && !"".equals(createDateBegin)) {
            sql.append(" and BQ.CREATE_DATE >= '").append(createDateBegin).append("'");
        }
        if (createDateEnd != null && !"".equals(createDateEnd)) {
            sql.append(" and BQ.CREATE_DATE <= '").append(createDateEnd).append("'");
        }
        sql.append(" group by BQ.BQ001,BQ.BQ510");
        Query query = this.getEntityManager().createNativeQuery(sql.toString());
        try {
            List<Object[]> o = query.getResultList();
            return o;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getBQ001ByDeptAndDate(String deptno, Date date) {
        String ls_no = "";
        String serial = "0000";
        if ("".equals(deptno)) {
            return ls_no;
        }
        if (deptno.startsWith("5")) {
            ls_no += "KMKF";
        } else {
            switch (deptno.substring(0, 2)) {
                case "1C":
                    ls_no += "HBKF";
                    break;
                case "1D":
                    ls_no += "HNKF";
                    break;
                case "1V":
                    ls_no += "CQKF";
                    break;
                case "1E":
                    ls_no += "NJKF";
                    break;
                default:
                    ls_no += "HDKF";
                    break;
            }
        }
        ls_no += BaseLib.formatDate("yyyy", date);
        ls_no += BaseLib.formatDate("MM", date);
        String sql = "SELECT * FROM SERBQ WHERE BQ001 LIKE '" + ls_no + "%' ORDER BY BQ001 DESC ";
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
        ls_no += serial;
        return ls_no;
    }
}
