/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C2082
 */
@Entity
@Table(name = "wechatclock")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WechatClock.findAll", query = "SELECT w FROM WechatClock w"),
    @NamedQuery(name = "WechatClock.findById", query = "SELECT w FROM WechatClock w WHERE w.id = :id"),
    @NamedQuery(name = "WechatClock.findByUserid", query = "SELECT w FROM WechatClock w WHERE w.userid = :userid"),
    @NamedQuery(name = "WechatClock.findByGroupname", query = "SELECT w FROM WechatClock w WHERE w.groupname = :groupname"),
    @NamedQuery(name = "WechatClock.findByCheckintype", query = "SELECT w FROM WechatClock w WHERE w.checkintype = :checkintype"),
    @NamedQuery(name = "WechatClock.findByExceptiontype", query = "SELECT w FROM WechatClock w WHERE w.exceptiontype = :exceptiontype"),
    @NamedQuery(name = "WechatClock.findByCheckintime", query = "SELECT w FROM WechatClock w WHERE w.checkintime = :checkintime"),
    @NamedQuery(name = "WechatClock.findByLocationtitle", query = "SELECT w FROM WechatClock w WHERE w.locationtitle = :locationtitle"),
    @NamedQuery(name = "WechatClock.findByLocationdetail", query = "SELECT w FROM WechatClock w WHERE w.locationdetail = :locationdetail"),
    @NamedQuery(name = "WechatClock.findByWifiname", query = "SELECT w FROM WechatClock w WHERE w.wifiname = :wifiname"),
    @NamedQuery(name = "WechatClock.findByNotes", query = "SELECT w FROM WechatClock w WHERE w.notes = :notes"),
    @NamedQuery(name = "WechatClock.findByWifimac", query = "SELECT w FROM WechatClock w WHERE w.wifimac = :wifimac"),
    @NamedQuery(name = "WechatClock.findByMediaids", query = "SELECT w FROM WechatClock w WHERE w.mediaids = :mediaids"),
    @NamedQuery(name = "WechatClock.findByLat", query = "SELECT w FROM WechatClock w WHERE w.lat = :lat"),
    @NamedQuery(name = "WechatClock.findByLng", query = "SELECT w FROM WechatClock w WHERE w.lng = :lng")})
public class WechatClock implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "userid")
    private String userid;
    @Size(max = 20)
    @Column(name = "groupname")
    private String groupname;
    @Size(max = 20)
    @Column(name = "checkintype")
    private String checkintype;
    @Size(max = 20)
    @Column(name = "exceptiontype")
    private String exceptiontype;
    @Size(max = 20)
    @Column(name = "checkintime")
    private String checkintime;
    @Size(max = 100)
    @Column(name = "locationtitle")
    private String locationtitle;
    @Size(max = 200)
    @Column(name = "locationdetail")
    private String locationdetail;
    @Size(max = 200)
    @Column(name = "wifiname")
    private String wifiname;
    @Size(max = 200)
    @Column(name = "notes")
    private String notes;
    @Size(max = 200)
    @Column(name = "wifimac")
    private String wifimac;
    @Size(max = 5000)
    @Column(name = "mediaids")
    private String mediaids;
    @Size(max = 20)
    @Column(name = "lat")
    private String lat;
    @Size(max = 20)
    @Column(name = "lng")
    private String lng;

    public WechatClock() {
    }

    public WechatClock(Integer id) {
        this.id = id;
    }

    public WechatClock(Integer id, String userid) {
        this.id = id;
        this.userid = userid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getCheckintype() {
        return checkintype;
    }

    public void setCheckintype(String checkintype) {
        this.checkintype = checkintype;
    }

    public String getExceptiontype() {
        return exceptiontype;
    }

    public void setExceptiontype(String exceptiontype) {
        this.exceptiontype = exceptiontype;
    }

    public String getCheckintime() {
        return checkintime;
    }

    public void setCheckintime(String checkintime) {
        this.checkintime = checkintime;
    }

    public String getLocationtitle() {
        return locationtitle;
    }

    public void setLocationtitle(String locationtitle) {
        this.locationtitle = locationtitle;
    }

    public String getLocationdetail() {
        return locationdetail;
    }

    public void setLocationdetail(String locationdetail) {
        this.locationdetail = locationdetail;
    }

    public String getWifiname() {
        return wifiname;
    }

    public void setWifiname(String wifiname) {
        this.wifiname = wifiname;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getWifimac() {
        return wifimac;
    }

    public void setWifimac(String wifimac) {
        this.wifimac = wifimac;
    }

    public String getMediaids() {
        return mediaids;
    }

    public void setMediaids(String mediaids) {
        this.mediaids = mediaids;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
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
        if (!(object instanceof WechatClock)) {
            return false;
        }
        WechatClock other = (WechatClock) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.WechatClock[ id=" + id + " ]";
    }
    
}
