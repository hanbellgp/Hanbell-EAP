/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.MeetingSchedule;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.inject.Named;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
@Named
public class MeetingScheduleBean extends SuperEJBForEAP<MeetingSchedule> {

    public MeetingScheduleBean() {
        super(MeetingSchedule.class);
    }

    public MeetingSchedule findByBookingId(String value) {
        Query query = this.getEntityManager().createNamedQuery("MeetingSchedule.findByBookingId");
        query.setParameter("bookingid", value);
        try {
            Object o = query.getSingleResult();
            return (MeetingSchedule) o;
        } catch (Exception ex) {
            return null;
        }
    }

    public List<MeetingSchedule> findByKindAndTime(String kind, Date startDate, Date startTime, Date endDate, Date endTime) {
        Query query = this.getEntityManager().createNamedQuery("MeetingSchedule.findByKindAndTime");
        query.setParameter("bookingkind", kind);
        query.setParameter("startDate", startDate);
        query.setParameter("startTime", startTime);
        query.setParameter("endDate", endDate);
        query.setParameter("endTime", endTime);
        return query.getResultList();
    }

    public List<MeetingSchedule> findByPIdAndTime(Object pid, Date startDate, Date startTime, Date endDate, Date endTime) {
        Query query = this.getEntityManager().createNamedQuery("MeetingSchedule.findByPIdAndTime");
        query.setParameter("pid", pid);
        query.setParameter("startDate", startDate);
        query.setParameter("startTime", startTime);
        query.setParameter("endDate", endDate);
        query.setParameter("endTime", endTime);
        return query.getResultList();
    }

}
