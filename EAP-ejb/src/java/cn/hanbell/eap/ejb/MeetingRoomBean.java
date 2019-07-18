/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.MeetingRoom;
import cn.hanbell.eap.entity.MeetingSchedule;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
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
public class MeetingRoomBean extends SuperEJBForEAP<MeetingRoom> {

    @EJB
    private MeetingScheduleBean meetingScheduleBean;

    public MeetingRoomBean() {
        super(MeetingRoom.class);
    }

    public List<MeetingRoom> findByKind(String kind) {
        Query query = this.getEntityManager().createNamedQuery("MeetingRoom.findByKind");
        query.setParameter("kind", kind);
        return query.getResultList();
    }

    public List<MeetingSchedule> findIdleTime(String kind, Date startDate, int minutes) {
        MeetingSchedule ms;
        List<MeetingSchedule> idleList = new ArrayList<>();
        List<MeetingSchedule> scheduleList;
        List<MeetingRoom> roomList = this.findByKind(kind);
        if (roomList == null || roomList.isEmpty()) {
            return null;
        }
        for (MeetingRoom r : roomList) {
            scheduleList = meetingScheduleBean.findByPIdAndTime(r.getId(), startDate, r.getBookingKind().getStartTime(), startDate, r.getBookingKind().getEndTime());
            if (scheduleList != null && !scheduleList.isEmpty() && scheduleList.size() >= 2) {
                Long interval;
                Long times;
                MeetingSchedule se;
                MeetingSchedule sb;
                if (scheduleList.size() == 2) {
                    se = scheduleList.get(0);
                    sb = scheduleList.get(1);
                    interval = sb.getStartTime().getTime() - se.getEndTime().getTime();
                    times = interval / 1000 / 60;//分钟
                    if (times >= minutes) {
                        ms = new MeetingSchedule();
                        ms.setStartTime(se.getEndTime());
                        ms.setEndTime(sb.getStartTime());
                        ms.setMinutes(times.intValue());
                        idleList.add(ms);
                    }
                } else {
                    for (int i = 0; i < scheduleList.size() - 1; i++) {
                        se = scheduleList.get(i);
                        sb = scheduleList.get(i + 1);
                        interval = sb.getStartTime().getTime() - se.getEndTime().getTime();
                        times = interval / 1000 / 60;//分钟
                        if (times >= minutes) {
                            ms = new MeetingSchedule();
                            ms.setStartTime(se.getEndTime());
                            ms.setEndTime(sb.getStartTime());
                            ms.setMinutes(times.intValue());
                            idleList.add(ms);
                        }
                    }
                }
            }
        }
        return idleList;
    }

}
