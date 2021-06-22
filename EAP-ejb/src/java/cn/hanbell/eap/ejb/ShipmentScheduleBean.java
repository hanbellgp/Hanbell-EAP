/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.ShipmentSchedule;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author kevindong
 */
@Stateless
@LocalBean
public class ShipmentScheduleBean extends SuperEJBForEAP<ShipmentSchedule> {

    public ShipmentScheduleBean() {
        super(ShipmentSchedule.class);
    }

    public List<ShipmentSchedule> findByCompanyAndFormdate(String company, Date formdateBegin, Date formdateEnd, boolean shortage) {
        String jpql = "SELECT e FROM ShipmentSchedule e WHERE e.company = :company AND e.formdate >= :formdateBegin AND e.formdate <= :formdateEnd ";
        if (shortage) {
            jpql += " AND e.invqty - e.appqty < 0 ORDER BY e.formdate,e.priority,e.itemno";
        } else {
            jpql += " ORDER BY e.formdate,e.priority,e.itemno";
        }
        Query query = getEntityManager().createQuery(jpql);
        query.setParameter("company", company);
        query.setParameter("formdateBegin", formdateBegin);
        query.setParameter("formdateEnd", formdateEnd);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            log4j.error(ex);
        }
        return null;
    }

    public List<ShipmentSchedule> findByCompanyAndFormdate(String company, Date formdateBegin, Date formdateEnd, boolean shortage, int first, int pageSize) {
        String jpql = "SELECT e FROM ShipmentSchedule e WHERE e.company = :company AND e.formdate >= :formdateBegin AND e.formdate <= :formdateEnd ";
        if (shortage) {
            jpql += " AND e.invqty - e.appqty < 0 ORDER BY e.formdate,e.priority,e.itemno";
        } else {
            jpql += " ORDER BY e.formdate,e.priority,e.itemno";
        }
        Query query = getEntityManager().createQuery(jpql).setFirstResult(first).setMaxResults(pageSize);
        query.setParameter("company", company);
        query.setParameter("formdateBegin", formdateBegin);
        query.setParameter("formdateEnd", formdateEnd);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            log4j.error(ex);
        }
        return null;
    }

    public ShipmentSchedule findByUID(String uid) {
        Query query = getEntityManager().createNamedQuery("ShipmentSchedule.findByUID");
        query.setParameter("uid", uid);
        try {
            Object o = query.getSingleResult();
            return (ShipmentSchedule) o;
        } catch (Exception ex) {
            return null;
        }
    }

    public int getRowCountByCompanyAndFormdate(String company, Date formdateBegin, Date formdateEnd, boolean shortage) {
        String jpql = "SELECT COUNT(e) FROM ShipmentSchedule e WHERE e.company = :company AND e.formdate >= :formdateBegin AND e.formdate <= :formdateEnd ";
        if (shortage) {
            jpql += " AND e.invqty - e.appqty < 0 ";
        }
        Query query = getEntityManager().createQuery(jpql);
        query.setParameter("company", company);
        query.setParameter("formdateBegin", formdateBegin);
        query.setParameter("formdateEnd", formdateEnd);
        try {
            return Integer.parseInt(query.getSingleResult().toString());
        } catch (Exception ex) {
            log4j.error(ex);
        }
        return 0;
    }

}
