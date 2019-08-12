/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import com.lightshell.comm.SuperDetailEntity;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C0160
 */
@Entity
@Table(name = "meetingschedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MeetingSchedule.findAll", query = "SELECT m FROM MeetingSchedule m"),
    @NamedQuery(name = "MeetingSchedule.findById", query = "SELECT m FROM MeetingSchedule m WHERE m.id = :id"),
    @NamedQuery(name = "MeetingSchedule.findByPId", query = "SELECT m FROM MeetingSchedule m WHERE m.pid = :pid ORDER BY m.startDate DESC,m.endDate DESC,m.endTime DESC"),
    @NamedQuery(name = "MeetingSchedule.findByPIdAndTime", query = "SELECT m FROM MeetingSchedule m WHERE m.pid = :pid AND m.endDate >=:startDate AND m.endTime >:startTime AND m.startDate <= :endDate AND m.startTime <:endTime ORDER BY m.startDate,m.endDate,m.endTime"),
    @NamedQuery(name = "MeetingSchedule.findByBookingId", query = "SELECT m FROM MeetingSchedule m WHERE m.bookingid = :bookingid"),
    @NamedQuery(name = "MeetingSchedule.findByKindAndTime", query = "SELECT m FROM MeetingSchedule m WHERE m.meetingRoom.kind = :bookingkind AND m.endDate >=:startDate AND m.endTime >:startTime AND m.startDate <= :endDate AND m.startTime <:endTime ")})
public class MeetingSchedule extends SuperDetailEntity {

    @JoinColumn(name = "pid", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private MeetingRoom meetingRoom;
    @JoinColumn(name = "bookingid", referencedColumnName = "formid", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private Booking booking;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "bookingid")
    private String bookingid;
    @Size(max = 45)
    @Column(name = "subject")
    private String subject;
    @Size(max = 800)
    @Column(name = "content")
    private String content;
    @Basic(optional = false)
    @NotNull
    @Column(name = "startDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "startTime")
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "endDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "endTime")
    @Temporal(TemporalType.TIME)
    private Date endTime;
    @Column(name = "minutes")
    private Integer minutes;
    @Size(max = 200)
    @Column(name = "remark")
    private String remark;

    public MeetingSchedule() {
        this.seq = 1;
    }

    /**
     * @return the meetingRoom
     */
    public MeetingRoom getMeetingRoom() {
        return meetingRoom;
    }

    /**
     * @param meetingRoom the meetingRoom to set
     */
    public void setMeetingRoom(MeetingRoom meetingRoom) {
        this.meetingRoom = meetingRoom;
    }

    /**
     * @return the booking
     */
    public Booking getBooking() {
        return booking;
    }

    /**
     * @param booking the booking to set
     */
    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getBookingid() {
        return bookingid;
    }

    public void setBookingid(String bookingid) {
        this.bookingid = bookingid;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MeetingSchedule)) {
            return false;
        }
        MeetingSchedule other = (MeetingSchedule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.MeetingSchedule[ id=" + id + " ]";
    }

}
