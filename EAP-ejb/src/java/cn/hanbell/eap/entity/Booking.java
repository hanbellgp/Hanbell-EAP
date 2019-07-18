/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import com.lightshell.comm.FormEntity;
import java.util.Date;
import java.util.Objects;
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
@Table(name = "booking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Booking.getRowCount", query = "SELECT COUNT(b) FROM Booking b"),
    @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b"),
    @NamedQuery(name = "Booking.findById", query = "SELECT b FROM Booking b WHERE b.id = :id"),
    @NamedQuery(name = "Booking.findByFormid", query = "SELECT b FROM Booking b WHERE b.formid = :formid"),
    @NamedQuery(name = "Booking.findByFormdate", query = "SELECT b FROM Booking b WHERE b.formdate = :formdate"),
    @NamedQuery(name = "Booking.findNeedMsgNotify", query = "SELECT b FROM Booking b WHERE b.msgNotify=true AND b.msgNotified>0 AND b.startDate = :startdate AND b.startTime = :starttime ")})
public class Booking extends FormEntity {

    @Column(name = "msgNotify")
    private Boolean msgNotify;
    @Column(name = "msgNotified")
    private Integer msgNotified;

    @Size(max = 45)
    @Column(name = "key1")
    private String key1;
    @Size(max = 45)
    @Column(name = "value1")
    private String value1;
    @Size(max = 45)
    @Column(name = "key2")
    private String key2;
    @Size(max = 45)
    @Column(name = "value2")
    private String value2;
    @Size(max = 45)
    @Column(name = "key3")
    private String key3;
    @Size(max = 45)
    @Column(name = "value3")
    private String value3;
    @Size(max = 45)
    @Column(name = "key4")
    private String key4;
    @Size(max = 45)
    @Column(name = "value4")
    private String value4;
    @Size(max = 45)
    @Column(name = "key5")
    private String key5;
    @Size(max = 45)
    @Column(name = "value5")
    private String value5;
    @Size(max = 45)
    @Column(name = "key6")
    private String key6;
    @Size(max = 45)
    @Column(name = "value6")
    private String value6;
    @Size(max = 45)
    @Column(name = "key7")
    private String key7;
    @Size(max = 45)
    @Column(name = "value7")
    private String value7;
    @Size(max = 45)
    @Column(name = "key8")
    private String key8;
    @Size(max = 45)
    @Column(name = "value8")
    private String value8;

    @Size(max = 10)
    @Column(name = "formtype")
    private String formtype;

    @JoinColumn(name = "formkind", referencedColumnName = "kind")
    @ManyToOne(optional = true)
    private BookingKind bookingKind;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 2)
    @Column(name = "gender")
    private String gender;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "mobile")
    private String mobile;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="电子邮件无效")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Size(max = 100)
    @Column(name = "company")
    private String company;
    @Size(max = 45)
    @Column(name = "title")
    private String title;
    @Column(name = "startDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "startTime")
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Column(name = "endDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Column(name = "endTime")
    @Temporal(TemporalType.TIME)
    private Date endTime;
    @Size(max = 45)
    @Column(name = "contacter")
    private String contacter;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num")
    private int num;
    @Size(max = 45)
    @Column(name = "room")
    private String room;
    @Size(max = 45)
    @Column(name = "seat")
    private String seat;
    @Size(max = 200)
    @Column(name = "remark")
    private String remark;

    public Booking() {
        this.num = 1;
        this.key1 = "";
        this.key2 = "";
        this.key3 = "";
        this.key4 = "";
        this.key5 = "";
        this.key6 = "";
        this.key7 = "";
        this.key8 = "";
        this.status = "N";
    }

    public String getFormtype() {
        return formtype;
    }

    public void setFormtype(String formtype) {
        this.formtype = formtype;
    }

    public BookingKind getBookingKind() {
        return bookingKind;
    }

    public void setBookingKind(BookingKind bookingKind) {
        this.bookingKind = bookingKind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
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

    public String getContacter() {
        return contacter;
    }

    public void setContacter(String contacter) {
        this.contacter = contacter;
    }

    /**
     * @return the num
     */
    public int getNum() {
        return num;
    }

    /**
     * @param num the num to set
     */
    public void setNum(int num) {
        this.num = num;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    /**
     * @return the msgNotify
     */
    public Boolean getMsgNotify() {
        return msgNotify;
    }

    /**
     * @param msgNotify the msgNotify to set
     */
    public void setMsgNotify(Boolean msgNotify) {
        this.msgNotify = msgNotify;
    }

    /**
     * @return the msgNotified
     */
    public Integer getMsgNotified() {
        return msgNotified;
    }

    /**
     * @param msgNotified the msgNotified to set
     */
    public void setMsgNotified(Integer msgNotified) {
        this.msgNotified = msgNotified;
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
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
        if (this.id != null && other.id != null && !this.id.equals(other.id)) {
            return false;
        }
        return Objects.equals(this.formid, other.formid);
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.Booking[ id=" + id + " ]";
    }

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getKey2() {
        return key2;
    }

    public void setKey2(String key2) {
        this.key2 = key2;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public String getKey3() {
        return key3;
    }

    public void setKey3(String key3) {
        this.key3 = key3;
    }

    public String getValue3() {
        return value3;
    }

    public void setValue3(String value3) {
        this.value3 = value3;
    }

    public String getKey4() {
        return key4;
    }

    public void setKey4(String key4) {
        this.key4 = key4;
    }

    public String getValue4() {
        return value4;
    }

    public void setValue4(String value4) {
        this.value4 = value4;
    }

    public String getKey5() {
        return key5;
    }

    public void setKey5(String key5) {
        this.key5 = key5;
    }

    public String getValue5() {
        return value5;
    }

    public void setValue5(String value5) {
        this.value5 = value5;
    }

    public String getKey6() {
        return key6;
    }

    public void setKey6(String key6) {
        this.key6 = key6;
    }

    public String getValue6() {
        return value6;
    }

    public void setValue6(String value6) {
        this.value6 = value6;
    }

    public String getKey7() {
        return key7;
    }

    public void setKey7(String key7) {
        this.key7 = key7;
    }

    public String getValue7() {
        return value7;
    }

    public void setValue7(String value7) {
        this.value7 = value7;
    }

    public String getKey8() {
        return key8;
    }

    public void setKey8(String key8) {
        this.key8 = key8;
    }

    public String getValue8() {
        return value8;
    }

    public void setValue8(String value8) {
        this.value8 = value8;
    }

}
