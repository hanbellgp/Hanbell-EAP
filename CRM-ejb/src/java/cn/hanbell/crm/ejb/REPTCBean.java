/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.CMSMV;
import cn.hanbell.crm.entity.REPTC;
import cn.hanbell.util.BaseLib;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C1491
 */
@Stateless
@LocalBean
public class REPTCBean extends SuperEJBForCRM<REPTC> {

    public REPTCBean() {
        super(REPTC.class);
    }

    public REPTC findByPK(String tc001, String tc002) {
        Query query = getEntityManager().createNamedQuery("REPTC.findByPK");
        query.setParameter("tc001", tc001);
        query.setParameter("tc002", tc002);
        try {
            Object o = query.getSingleResult();
            return (REPTC) o;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     *
     * @param kfno
     * @return CRM 差旅费
     */
    public List getCustomerComplaintExpense(String kfno) {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT 'travelexpense' as type ,'CRM' as sources,TC054 as kfno,(MZ005+MZ006) as fwno,rtrim(MY005) as userno,(MV002) as userna,  ");
        sb.append(" MY004 as deptno,ME002 as deptna,MZ007 as serialno,MZ008 as occurdate,GA003 as expensetype,MZ031 as custom1 ,MZ032 as custom2, ");
        sb.append(" MZ017 as 'expense',MZ020 as remark1,MY025 as oano,MY024 as oadate FROM PORMZ z LEFT OUTER JOIN PORMY y ON z.MZ001=y.MY001  ");
        sb.append(" AND  z.MZ002=y.MY002 LEFT OUTER JOIN CMSME e on e.ME001=y.MY004 LEFT OUTER JOIN CMSMV v on v.MV001=y.MY005 ");
        sb.append(" LEFT OUTER JOIN  CRMGA a ON a.GA002=z.MZ009 LEFT OUTER JOIN  REPTC t ON t.TC001= z.MZ005 AND t.TC002=z.MZ006 ");
        sb.append("  WHERE (GA001='3C') AND TC054='${kfno}' ");
        try {
            String sql = sb.toString().replace("${kfno}", kfno);
            Query query = getEntityManager().createNativeQuery(sql);
            List list = query.getResultList();
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @param y
     * @param m
     * @return
     * @description 获取CRM的数据
     */
    public List getCRMList(int y, int m) {
        StringBuilder sb = new StringBuilder();
        sb.append(" select a.CREATE_DATE,a.BQ001,BQ016,b.MV002,a.BQ017,c.ME002,BQ003, d.MA003,e.CA009,e.CA500, ");
        sb.append(" a.BQ002 as '客户代号',f.GG003,a.BQ502,(case a.BQ501 when 'N' then '免费' else '收费' end) as BQ501, ");
        sb.append(" CASE WHEN datediff(DAY,g.MI009,CONVERT(VARCHAR(8),GETDATE(),112))>0 THEN '否' ELSE '是' END AS MI017, ");
        sb.append(" (select ME002 from CMSME where ME001 = a.BQ504) as '责任归属部门',h.AK003,(j.TC001+j.TC002) as '维修单号', ");
        sb.append(" TC016,(select MV002 from CMSMV where CMSMV.MV001 = j.TC016) as '维修人员名称', ");
        sb.append(" TC017,(select ME002 from CMSME where CMSME.ME001 = j.TC017) as '维修部门' ");
        sb.append(" from SERBQ a ,CMSMV b,CMSME c,SERCA e,CRMGG f,REPMI g,REPTC j, ");
        sb.append(" (SELECT AA002 AS MA002,AA003 AS MA003 ");
        sb.append(" FROM SERAA ");
        sb.append(" UNION ");
        sb.append(" Select MA002,MA003 ");
        sb.append(" from WARMA ");
        sb.append(" Where ((MA001 in (SELECT AA001 FROM SERAA)) ");
        sb.append(" or ((SELECT AA001 FROM SERAA) ='')) and MA002 <> '') as d, ");
        sb.append(" ( Select AK002,AK003,AK006,AK012,AK014 ");
        sb.append(" FROM  SERAK AS SERAK ");
        sb.append(" WHERE AK013 <> 'Y'  AND AK001=N'RLM' ");
        sb.append(" UNION ");
        sb.append(" SELECT AK002,AK003,AK006,AK012,AK014 ");
        sb.append(" FROM SERAB ");
        sb.append(" LEFT JOIN SERAK ON AK002 = AB002 AND AK001 = AB001  WHERE AK013 = 'Y' AND AK001=N'RLM' ) h ");
        sb.append(" where a.BQ016 = b.MV001 and a.BQ017 = c.ME001 and a.BQ003 = d.MA002 and a.BQ001= e.CA001 ");
        sb.append(" and a.BQ002 = f.GG001 and g.MI002=e.CA009 and a.BQ023 = h.AK002 and e.CA010= j.TC005 and e.CA011 = j.TC006 ");
        sb.append(" and year(a.CREATE_DATE) = ").append(y).append(" and month(a.CREATE_DATE)= ").append(m);
        Query query = getEntityManager().createNativeQuery(sb.toString());
        try {
            List CRMList = query.getResultList();
            return CRMList;
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     *
     * @param fwno
     * @return CRM 差旅费
     */
    public BigDecimal getCRMTravelamt(String fwno) {
        StringBuilder sb = new StringBuilder();
        BigDecimal amt = BigDecimal.ZERO;
        sb.append(" SELECT isnull(sum(MZ017),0) as MZ017 FROM PORMZ z LEFT OUTER JOIN PORMY y ON z.MZ001=y.MY001 ");
        sb.append(" AND  z.MZ002=y.MY002 LEFT OUTER JOIN CMSME e on e.ME001=y.MY004 LEFT OUTER JOIN CMSMV v on v.MV001=y.MY005 ");
        sb.append(" LEFT OUTER JOIN  CRMGA a ON a.GA002=z.MZ009 LEFT OUTER JOIN  REPTC t ON t.TC001= z.MZ005 AND t.TC002=z.MZ006 ");
        sb.append(" WHERE (GA001='3C')  and (MZ005+MZ006) = '${fwno}' ");
        try {
            String sql = sb.toString().replace("${fwno}", fwno);
            Query query = getEntityManager().createNativeQuery(sql);
            Object o = query.getSingleResult();
            amt = BigDecimal.valueOf(Double.valueOf(o.toString()));
            return amt;
        } catch (NumberFormatException ex) {
            return amt;
        }
    }

    public String getTC002ByTC001AndDate(String tc001, Date date) {
        String ls_no = "";
        String ls_ta002 = "";
        String serial = "000";
        ls_ta002 = BaseLib.formatDate("yyyyMMdd", date);
        String sql = "SELECT * FROM REPTC WHERE TC001 = '" + tc001 + "' and TC002 LIKE '" + ls_ta002 + "%' ORDER BY TC002 DESC ";
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

    public List<REPTC> getReptcByTC001OrTc002(String maintainformtype, String maintainform) {
        Query query = null;
        if (maintainform != null & !"".equals(maintainform)) {
            StringBuffer sql = new StringBuffer("SELECT * FROM REPTC r WHERE r.TC001 = '");
            sql.append(maintainformtype).append("' AND r.TC002 like '%").append(maintainform).append("%'");
            sql.append(" order by CREATE_DATE desc");
            query = getEntityManager().createNativeQuery(sql.toString(), REPTC.class);
        } else {
            StringBuffer sql = new StringBuffer("SELECT * FROM REPTC  WHERE TC001 = '");
            sql.append(maintainformtype).append("'");
            sql.append(" order by CREATE_DATE desc");
            query = getEntityManager().createNativeQuery(sql.toString(), REPTC.class);
        }
        try {
            List<REPTC> list = query.getResultList();
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * @return @dscription获取CRM的品号类别编号
     */
    public List<Object> getItntypeList() {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT AA002 AS MA002 FROM SERAA ");
        sb.append(" UNION ");
        sb.append(" SELECT MA002 FROM WARMA ");
        sb.append(" WHERE ((MA001 in (SELECT AA001 FROM SERAA)) or ((SELECT AA001 FROM SERAA) ='')) and MA002 <> '' ");
        try {
            Query query = getEntityManager().createNativeQuery(sb.toString());
            return query.getResultList();
        } catch (NumberFormatException ex) {
            return null;
        }
    }

    /**
     * 获取可维护的工作记录，报销
     *
     * @param userId
     * @return
     * @throws ParseException
     */
    public List<Object> getCRMWorkRecordList(String userId) throws ParseException {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT TC002,TC001,TC003,TC007,GG003 FROM REPTC ");
        sb.append("LEFT JOIN CRMGG ON GG001 = TC007 ");
        sb.append("LEFT JOIN SERBQ ON BQ001=TC054 AND BQ059<>3 ");
        sb.append("WHERE TC091=0 AND TC034<>'V' ");
        sb.append("AND REPTC.CREATE_DATE>'20160101' AND TC016 ='").append(userId).append("'");
        sb.append(" UNION ALL SELECT FI001,'YXJL' as FI002,SALFI.CREATE_DATE,FI024,GG003 FROM SALFI ");
        sb.append("LEFT JOIN SALFT ON FT001 =FI001  AND FT002='' ");
        sb.append("LEFT JOIN CRMGG ON CRMGG.GG001 =FI024 ");
        sb.append("WHERE FI057=0 AND FI018='Y' ");
        sb.append("AND (FI084='N' OR FI084='') ");
        sb.append("AND GG003<>'' ");
        sb.append("AND SALFI.CREATE_DATE>'20200101' ");
        sb.append("AND SALFI.FI004 = '").append(userId).append("'");
        Query query = getEntityManager().createNativeQuery(sb.toString());
        List result = query.getResultList();
        return result;
    }

}
