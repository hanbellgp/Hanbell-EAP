/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.ProductionPlan;
import cn.hanbell.util.BaseLib;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class ProductionPlanBean extends SuperEJBForEAP<ProductionPlan> {

    public ProductionPlanBean() {
        super(ProductionPlan.class);
    }

    public String getFormId() {
        return getFormId(BaseLib.getDate());
    }

    public String getFormId(Date day) {
        return super.getFormId(day, "VM", "yyMM", 4);
    }

    public List<Object[]> getSummary(Map<String, Object> filters,
            Map<String, String> orderBy) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT e.mon,e.productSeries,e.itemno,e.itemModel,e.formdate,SUM(e.qty) FROM ProductionPlan e WHERE 1=1 ");
        if (filters != null) {
            this.setQueryFilter(sb, filters);
        }
        sb.append(" GROUP BY e.mon,e.productSeries,e.itemno,e.itemModel,e.formdate ");
        sb.append(" ORDER BY e.mon,e.productSeries,e.itemno,e.itemModel,e.formdate ");
        // if ((orderBy != null) && (orderBy.size() > 0)) {
        // sb.append(" ORDER BY ");
        // for (Map.Entry<String, String> o : orderBy.entrySet()) {
        // sb.append(" e.").append(o.getKey()).append("
        // ").append(o.getValue()).append(",");
        // }
        // sb.deleteCharAt(sb.lastIndexOf(","));
        // }
        Query query = getEntityManager().createQuery(sb.toString());
        if (filters != null) {
            this.setQueryParam(query, filters);
        }
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Object[]> getSummary(String model, String mon) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT e.mon,e.productSeries,e.itemno,e.itemModel,e.formdate,SUM(e.qty) FROM ProductionPlan e WHERE 1=1 ");
        sb.append(" AND e.itemModel = '").append(model).append("' AND e.mon = '").append(mon).append("' ");
        sb.append(" GROUP BY e.mon,e.productSeries,e.itemno,e.itemModel,e.formdate ");
        sb.append(" ORDER BY e.mon,e.productSeries,e.itemno,e.itemModel,e.formdate ");
        Query query = getEntityManager().createQuery(sb.toString());
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

}
