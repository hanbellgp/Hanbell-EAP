/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.SalesOrder;
import cn.hanbell.eap.entity.WorkStep;
import cn.hanbell.util.BaseLib;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class SalesOrderBean extends SuperEJBForEAP<SalesOrder> {

    @EJB
    private WorkStepBean workStepBean;

    public SalesOrderBean() {
        super(SalesOrder.class);
    }

    public SalesOrder findByUID(String uid) {
        Query query = getEntityManager().createNamedQuery("SalesOrder.findByUID");
        query.setParameter("uid", uid);
        try {
            Object o = query.getSingleResult();
            return (SalesOrder) o;
        } catch (Exception ex) {
            return null;
        }
    }

    public String getFormId() {
        return getFormId(BaseLib.getDate());
    }

    public String getFormId(Date day) {
        return super.getFormId(day, "VO", "yyMM", 4);
    }

    public List<Object[]> getSummary(Map<String, Object> filters,
            Map<String, String> orderBy) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT e.mon,e.productSeries,e.itemno,e.itemModel,e.demandDate,SUM(e.qty) FROM SalesOrder e WHERE 1=1 ");
        if (filters != null) {
            this.setQueryFilter(sb, filters);
        }
        sb.append(" GROUP BY e.mon,e.productSeries,e.itemno,e.itemModel,e.demandDate ");
        sb.append(" ORDER BY e.mon,e.productSeries,e.itemno,e.itemModel,e.demandDate ");
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
        sb.append("SELECT e.mon,e.productSeries,e.itemno,e.itemModel,e.demandDate,SUM(e.qty) FROM SalesOrder e WHERE 1=1 ");
        sb.append(" AND e.itemModel = '").append(model).append("' AND e.mon = '").append(mon).append("' ");
        sb.append(" GROUP BY e.mon,e.productSeries,e.itemno,e.itemModel,e.demandDate ");
        sb.append(" ORDER BY e.mon,e.productSeries,e.itemno,e.itemModel,e.demandDate ");
        Query query = getEntityManager().createQuery(sb.toString());
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public void persist(SalesOrder entity) {
        try {
            super.persist(entity);
            // 后续使用Definition代替
            WorkStep step;
            step = new WorkStep();
            step.setSeq(1);
            step.setName("营业");
            step.setContextObject(SalesOrder.class.getName());
            step.setContextUID(entity.getUID());
            step.setUID(this.getUUID());
            step.setStatusToNew();
            workStepBean.persist(step);
            step = new WorkStep();
            step.setSeq(2);
            step.setName("技术");
            step.setContextObject(SalesOrder.class.getName());
            step.setContextUID(entity.getUID());
            step.setUID(this.getUUID());
            step.setStatusToNew();
            workStepBean.persist(step);
            step = new WorkStep();
            step.setSeq(3);
            step.setName("生管");
            step.setContextObject(SalesOrder.class.getName());
            step.setContextUID(entity.getUID());
            step.setUID(this.getUUID());
            step.setStatusToNew();
            workStepBean.persist(step);
            step = new WorkStep();
            step.setSeq(4);
            step.setName("结案");
            step.setContextObject(SalesOrder.class.getName());
            step.setContextUID(entity.getUID());
            step.setUID(this.getUUID());
            step.setStatusToNew();
            workStepBean.persist(step);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
