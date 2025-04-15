/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.edw.ejb;

import cn.hanbell.edw.comm.SuperEJBForEDW;
import cn.hanbell.edw.entity.EhsHiddenDanger;
import com.lightshell.comm.BaseLib;
import java.text.SimpleDateFormat;
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
public class EhsHiddenDangerBean extends SuperEJBForEDW<EhsHiddenDanger> {

    public EhsHiddenDangerBean() {
        super(EhsHiddenDanger.class);
    }

    public List<EhsHiddenDanger> getEHSHiddenDangerList(Map<String, Object> filters, Map<String, String> orderBy) {
        StringBuilder sb = new StringBuilder();
        StringBuilder userb = new StringBuilder();
        String exFilterStr = "";
        String companyFilter = "";
        sb.append("SELECT e FROM ");
        sb.append(this.className);
        sb.append(" e WHERE (1=1 ");
        Map<String, Object> strMap = new LinkedHashMap<>();

        for (Map.Entry<String, Object> entry : filters.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if ("userid".equals(key)) {
                if (filters.containsKey("月安全课长")) {//当点进来的是月安全课长不筛选对应的人员
//                    sb.append("  AND (e.presentingId = '");
//                    sb.append(filters.get("userid")).append("'");
//                    sb.append("  OR e.acceptedId = '");
//                    
//                    sb.append(filters.get("userid")).append("'");
//                    sb.append("  OR e.rectifierId = '");
//                    sb.append(filters.get("userid")).append("')");
                }
            } else if ("rstatus".equals(key)) {
                if (Integer.parseInt(value.toString()) == 10) {
                    //获取整改人的待处理单据
                    sb.append("  AND (e.rstatus =10  ");
                    sb.append("  AND e.rectifierId = '");
                    sb.append(filters.get("userid")).append("')");
                    //获取整改人的待处理单据
                    sb.append("  OR (e.rstatus =30  ");
                    sb.append("  AND e.rectifierId = '");
                    sb.append(filters.get("userid")).append("')");
                    //获取会签人的待处理单据
                    sb.append("  OR (e.rstatus =45  ");
                    sb.append("  AND e.acceptedId = '");
                    sb.append(filters.get("userid")).append("')");
                    //获取排查人的待处理单据
                    sb.append("  OR (e.rstatus =60  ");
                    sb.append("  AND e.presentingId = '");
                    sb.append(filters.get("userid")).append("')");
                    //获取复核人的待处理单据
                    if (filters.containsKey("月安全课长")) {
                        sb.append("  OR (e.rstatus =75 ) ");
                    }
                }
                if (Integer.parseInt(value.toString()) == 30) {
                    sb.append("  AND (e.rstatus =10    ");
                    sb.append("  AND e.acceptedId = '");
                    sb.append(filters.get("userid")).append("')");

                    //获取排查人的待处理单据
                    sb.append("  OR (e.rstatus =10");
                    sb.append("  AND e.presentingId = '");
                    sb.append(filters.get("userid")).append("')");
                    //获取整改人的待处理单据
                    sb.append("  OR (e.rstatus =30 ");
                    sb.append("  AND e.acceptedId = '");
                    sb.append(filters.get("userid")).append("')");
                    //获取整改人的待处理单据
                    sb.append("  OR (e.rstatus =30 ");
                    sb.append("  AND e.presentingId = '");
                    sb.append(filters.get("userid")).append("')");
                    //获取整改人的待处理单据
                    sb.append("  OR (e.rstatus =45");
                    sb.append("  AND e.rectifierId = '");
                    sb.append(filters.get("userid")).append("')");
                    //获取整改人的待处理单据
                    sb.append("  OR (e.rstatus =45");
                    sb.append("  AND e.presentingId = '");
                    sb.append(filters.get("userid")).append("')");
                    //获取整改人的待处理单据
                    sb.append("  OR (e.rstatus =60");
                    sb.append("  AND e.acceptedId = '");
                    sb.append(filters.get("userid")).append("')");

                    sb.append("  OR (e.rstatus =60");
                    sb.append("  AND e.rectifierId = '");
                    sb.append(filters.get("userid")).append("')");
                    //获取排查人的待处理单据
                    sb.append("  OR (e.rstatus =75");
                    sb.append("  AND e.presentingId = '");
                    sb.append(filters.get("userid")).append("')");

                    //获取排查人的待处理单据
                    sb.append("  OR (e.rstatus =75");
                    sb.append("  AND e.acceptedId = '");
                    sb.append(filters.get("userid")).append("')");

                    //获取排查人的待处理单据
                    sb.append("  OR (e.rstatus =75");
                    sb.append("  AND e.rectifierId = '");
                    sb.append(filters.get("userid")).append("')");
                    //获取复核人的待处理单据
                    if (filters.containsKey("月安全课长")) {
                        sb.append("  OR (e.rstatus !=75 AND e.rstatus !=95 ) ");
                    }
                }
                if (Integer.parseInt(value.toString()) == 95) {
                    if (!filters.containsKey("月安全课长")) {//当点进来的是月安全课长不筛选对应的人员
                        sb.append("  AND (e.presentingId = '");
                        sb.append(filters.get("userid")).append("'");
                        sb.append("  OR e.acceptedId = '");
                        sb.append(filters.get("userid")).append("'");
                        sb.append("  OR e.rectifierId = '");
                        sb.append(filters.get("userid")).append("')");
                    }
                    strMap.put(key, value);
                }
            } else if ("formdateBegin".equals(key)) {
                SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
                String formdateEndStr = fmt.format(new Date(value.toString()));
                sb.append("  AND (e.createTime >='" + formdateEndStr + " ') ");
            } else if ("formdateEnd".equals(key)) {
                SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
                String formdateEndStr = fmt.format(new Date(value.toString()));
                sb.append("  AND (e.createTime <='" + formdateEndStr + " ') ");
            } else if ("月安全课长".equals(key)) {
                sb.append("  AND (e.hiddenSource ='安全专员巡查'  ");
                sb.append("  OR e.area = '");
                sb.append(filters.get("area")).append("')");
            } else if ("area".equals(key)) {//厂区只有月安全课长会赛选所以不在条件内

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
            Query query = getEntityManager().createNativeQuery("select max(id) from EhsHiddenDanger where substring(id,1," + c + ")='" + (code) + "'");
            if (query.getSingleResult() != null) {

                maxid = query.getSingleResult().toString();
                m = maxid.length();
                id = Integer.parseInt(maxid.substring(m - len, m)) + 1;
                newid = code + d + String.format("%0" + len + "d", id);
            } else {
                newid = code + d + String.format("%0" + len + "d", 1);
            }
            return newid;
        } else {
            return "";
        }
    }

    @Override
    public int getRowCount(Map<String, Object> filters) {

        StringBuilder sb = new StringBuilder();
        String exFilterStr = "";
        String companyFilter = "";
        sb.append("SELECT COUNT(e) FROM ");
        sb.append(this.className);
        sb.append(" e WHERE (1=1 ");
        Map<String, Object> strMap = new LinkedHashMap<>();

        for (Map.Entry<String, Object> entry : filters.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if ("userid".equals(key)) {
                sb.append("  AND (e.presentingId = '");
                sb.append(filters.get("userid")).append("'");
                sb.append("  OR e.rectifierId = '");
                sb.append(filters.get("userid")).append("')");
            } else {
                strMap.put(key, value);
            }
        }
        sb.append(")").append(exFilterStr);
        filters = strMap;
        if (filters != null) {
            this.setQueryFilter(sb, filters);
        }

        final Query query = this.getEntityManager().createQuery(sb.toString());
        if (filters != null) {
            this.setQueryParam(query, filters);
        }
        return Integer.parseInt(query.getSingleResult().toString());

    }

}
