/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import com.lightshell.comm.SuperEntity;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C0160
 */
@Entity
@Table(name = "meetingroom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MeetingRoom.getRowCount", query = "SELECT COUNT(m) FROM MeetingRoom m"),
    @NamedQuery(name = "MeetingRoom.findAll", query = "SELECT m FROM MeetingRoom m"),
    @NamedQuery(name = "MeetingRoom.findById", query = "SELECT m FROM MeetingRoom m WHERE m.id = :id"),
    @NamedQuery(name = "MeetingRoom.findByName", query = "SELECT m FROM MeetingRoom m WHERE m.name = :name"),
    @NamedQuery(name = "MeetingRoom.findByStatus", query = "SELECT m FROM MeetingRoom m WHERE m.status = :status"),
    @NamedQuery(name = "MeetingRoom.findByKind", query = "SELECT m FROM MeetingRoom m WHERE m.kind = :kind")})
public class MeetingRoom extends SuperEntity {

    @JoinColumn(name = "bookingkind", referencedColumnName = "kind", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private BookingKind bookingKind;

    @Size(max = 20)
    @Column(name = "bookingkind")
    private String kind;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sortid")
    private int sortid;
    @Size(max = 50)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "seats")
    private int seats;
    @Size(max = 45)
    @Column(name = "style")
    private String style;
    @Size(max = 200)
    @Column(name = "remark")
    private String remark;

    public MeetingRoom() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the kind
     */
    public String getKind() {
        return kind;
    }

    /**
     * @param kind the kind to set
     */
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * @return the bookingKind
     */
    public BookingKind getBookingKind() {
        return bookingKind;
    }

    /**
     * @param bookingKind the bookingKind to set
     */
    public void setBookingKind(BookingKind bookingKind) {
        this.bookingKind = bookingKind;
    }

    public int getSortid() {
        return sortid;
    }

    public void setSortid(int sortid) {
        this.sortid = sortid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
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
        if (!(object instanceof MeetingRoom)) {
            return false;
        }
        MeetingRoom other = (MeetingRoom) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.MeetingRoom[ id=" + id + " ]";
    }

}
