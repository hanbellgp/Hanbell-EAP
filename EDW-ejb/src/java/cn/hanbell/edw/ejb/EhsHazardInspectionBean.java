/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.edw.ejb;

import cn.hanbell.edw.comm.SuperEJBForEDW;
import cn.hanbell.edw.entity.EhsHazardInspection;
import com.lightshell.comm.BaseLib;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C2079
 */
@Stateless
@LocalBean
public class EhsHazardInspectionBean extends SuperEJBForEDW<EhsHazardInspection> {

    public EhsHazardInspectionBean() {
        super(EhsHazardInspection.class);
    }

    @Override
    public List<EhsHazardInspection> findByFilters(Map<String, Object> filters, Map<String, String> orderBy) {
         String exFilterStr = "";
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT e FROM ");
        sb.append(this.className);
        sb.append(" e WHERE 1=1 ");
        Map<String, Object> strMap = new LinkedHashMap<>();
        for (Map.Entry<String, Object> entry : filters.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if ("patrolType".equals(key)) {
                sb.append("  AND (e.patrolType = '");
                sb.append(filters.get("patrolType")).append("'");
            } else {
                strMap.put(key, value);
            }
        }
           sb.append(")").append(exFilterStr);
       filters = strMap;
        if (filters != null) {
            this.setQueryFilter(sb, filters);
        }
        if (orderBy != null && orderBy.size() > 0) {
            sb.append(" ORDER BY ");
            for (final Map.Entry<String, String> o : orderBy.entrySet()) {
                sb.append(" e.").append(o.getKey()).append(" ").append(o.getValue()).append(",");
            }
            sb.deleteCharAt(sb.lastIndexOf(","));
        }
        //生成SQL
        Query query = getEntityManager().createQuery(sb.toString());

        //参数赋值
        if (filters != null) {
            this.setQueryParam(query, filters);
        }
        List results = query.getResultList();
        return results;
    }

    public List<EhsHazardInspection> getEhsHazardInspectionList(Map<String, Object> filters, Map<String, String> orderBy) {
        StringBuilder sb = new StringBuilder();
        String exFilterStr = "";
        String companyFilter = "";
        sb.append("SELECT e FROM ");
        sb.append(this.className);
        sb.append(" e WHERE (1=1 ");
        Map<String, Object> strMap = new LinkedHashMap<>();

        for (Map.Entry<String, Object> entry : filters.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
//            if ("userid".equals(key)) {
//                 sb.append("  AND (e.presentingId = '");
//                sb.append(filters.get("userid")).append("'");
//                sb.append("  OR e.rectifierId = '");
//                sb.append(filters.get("userid")).append("')");
//            } else {
            strMap.put(key, value);
//            }
        }
        sb.append(")").append(exFilterStr);
        filters = strMap;
        if (filters != null) {
            this.setQueryFilter(sb, filters);
        }
        if (orderBy != null && orderBy.size() > 0) {
            sb.append(" ORDER BY ");
            for (final Map.Entry<String, String> o : orderBy.entrySet()) {
                sb.append(" e.").append(o.getKey()).append(" ").append(o.getValue()).append(",");
            }
            sb.deleteCharAt(sb.lastIndexOf(","));
        }
        //生成SQL
        Query query = getEntityManager().createQuery(sb.toString());

        //参数赋值
        if (filters != null) {
            this.setQueryParam(query, filters);
        }
        List results = query.getResultList();
        return results;

    }

    @Override
    public String getFormId(Date day, String code, String format, int len) {
        //流水码不按年份重新编号
        String maxid, newid;
        int id, m;
        if (day != null && code != null && len > 0) {
            String d = "";
            if (format != null && !format.equals("")) {
                d = BaseLib.formatDate(format, day);
            }
            d = d + "-";
            int c = code.length();
            Query query = getEntityManager().createNativeQuery("select * from EhsHazardInspection where substring(id,1," + c + ")='" + (code) + "'");
            List results = query.getResultList();
            int rsize = results.size() + 1;
            newid = code + d + rsize;
            return newid;
        } else {
            return "";
        }
    }

    public List<EhsHazardInspection> findById(String id) {
        Query query = getEntityManager().createNamedQuery("EhsHazardInspection.findById");
        query.setParameter("id", id);
        try {
            List results = query.getResultList();
            return results;
        } catch (Exception ex) {
            return null;
        }
    }

}
