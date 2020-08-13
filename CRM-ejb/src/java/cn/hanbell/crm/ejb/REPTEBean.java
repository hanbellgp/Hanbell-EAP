/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.REPTE;
import cn.hanbell.util.BaseLib;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author C2082
 */
@Stateless
@LocalBean
public class REPTEBean extends SuperEJBForCRM<REPTE> {

    public REPTEBean() {
        super(REPTE.class);
    }

    public REPTE findByPK(String te001, String te002, String te004) {
        Query query = getEntityManager().createNamedQuery("REPTE.findByPK");
        query.setParameter("te001", te001);
        query.setParameter("te002", te002);
        query.setParameter("te004", te004);
        try {
            Object o = query.getSingleResult();
            return (REPTE) o;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<REPTE> findByCreatorAndCreatedateOrModifierAndModiDate(String maintainer, String maintaindate) {
        String  s = new String("SELECT * FROM REPTE  WHERE (CREATOR='matainer' AND CREATE_DATE='maintaindate') OR ( MODIFIER='matainer' AND MODI_DATE='maintaindate')");
        String sql= s.replaceAll("matainer", maintainer).replaceAll("maintaindate", maintaindate);
        try {
            Query query = getEntityManager().createNativeQuery(sql, REPTE.class);
            List<REPTE> list = query.getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Set<REPTE> validateIntegrity(List<REPTE> list) throws ParseException {
        Set<REPTE> reptes = new HashSet<>();
        if (list.isEmpty() || list == null) {
            return reptes;
        }
        for (REPTE repte : list) {
            if (repte.getTe007() == null || "".equals(repte.getTe007())) {
                reptes.add(repte);
            }
            if (repte.getTe017() == null || "".equals(repte.getTe017())) {
                reptes.add(repte);
            }
            if (repte.getTe018() == null || "".equals(repte.getTe018())) {
                reptes.add(repte);
            }
            if (repte.getTe019() == null || "".equals(repte.getTe019())) {
                reptes.add(repte);
            }
            if (repte.getTe502() == null || "".equals(repte.getTe502())) {
                reptes.add(repte);
            }
            if (repte.getTe504() == null || "".equals(repte.getTe504())) {
                reptes.add(repte);
            }
            if (repte.getTe503() == null || "".equals(repte.getTe503())) {
                reptes.add(repte);
            }
            if (repte.getTe505() == null || "".equals(repte.getTe505())) {
                reptes.add(repte);
            }
            if (repte.getTe007() != null && !"".equals(repte.getTe007())
                    && repte.getTe017() != null && !"".equals(repte.getTe007())
                    && repte.getTe018() != null && !"".equals(repte.getTe018())
                    && repte.getTe019() != null && !"".equals(repte.getTe019())
                    && repte.getTe502() != null && !"".equals(repte.getTe502())
                    && repte.getTe504() != null && !"".equals(repte.getTe504())
                    && repte.getTe503() != null && !"".equals(repte.getTe503())
                    && repte.getTe505() != null && !"".equals(repte.getTe505())) {
                long d1 = BaseLib.getDate("yyyyMMddHHmm", repte.getTe502() + repte.getTe504()).getTime();
                long d2 = BaseLib.getDate("yyyyMMddHHmm", repte.getTe007() + repte.getTe017()).getTime();
                long d3 = BaseLib.getDate("yyyyMMddHHmm", repte.getTe018() + repte.getTe019()).getTime();
                long d4 = BaseLib.getDate("yyyyMMddHHmm", repte.getTe503() + repte.getTe505()).getTime();
                if (d1 <= d2 && d2 < d3 && d3 <= d4) {
                } else {
                    reptes.add(repte);
                }
            }

        }
        return reptes;
    }

    /**
     * 修改String类型的时间格式
     *
     * @param dateFormat 入参时间格式
     * @param date 时间
     * @param format 修改的时间格式
     * @return
     */
    public String proccessDate(String dateFormat, String date, String format) {
        if (dateFormat == null || "".equals(dateFormat)) {
            return "";
        }
        if (date == null || "".equals(date)) {
            return "";
        }
        if (format == null || "".equals(format)) {
            return "";
        }
        try {
            Date d = BaseLib.getDate(dateFormat, date);
            String xx = BaseLib.formatDate(format, d);
            return xx;
        } catch (ParseException p) {
            p.printStackTrace();
            return "";
        }
    }

    public String getTE004ByTE001AndTE002(String te001, String te002) {
        Query query = getEntityManager().createNativeQuery("Select TE004 from REPTE WHERE TE001=? and TE002=?");
        query.setParameter(1, te001);
        query.setParameter(2, te002);
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
