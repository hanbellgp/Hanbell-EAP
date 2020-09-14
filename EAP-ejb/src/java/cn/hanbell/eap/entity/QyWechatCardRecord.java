/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import com.lightshell.comm.BaseEntity;
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
@Table(name = "qywechatcardrecord")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QyWechatCardRecord.findAll", query = "SELECT q FROM QyWechatCardRecord q"),
    @NamedQuery(name = "QyWechatCardRecord.findById", query = "SELECT q FROM QyWechatCardRecord q WHERE q.id = :id"),
    @NamedQuery(name = "QyWechatCardRecord.findByUserid", query = "SELECT q FROM QyWechatCardRecord q WHERE q.userid = :userid"),
    @NamedQuery(name = "QyWechatCardRecord.findByGroupname", query = "SELECT q FROM QyWechatCardRecord q WHERE q.groupname = :groupname"),
    @NamedQuery(name = "QyWechatCardRecord.findByCheckintype", query = "SELECT q FROM QyWechatCardRecord q WHERE q.checkintype = :checkintype"),
    @NamedQuery(name = "QyWechatCardRecord.findByExceptiontype", query = "SELECT q FROM QyWechatCardRecord q WHERE q.exceptiontype = :exceptiontype"),
    @NamedQuery(name = "QyWechatCardRecord.findByCheckintime", query = "SELECT q FROM QyWechatCardRecord q WHERE q.checkintime = :checkintime"),
    @NamedQuery(name = "QyWechatCardRecord.findByLocationtitle", query = "SELECT q FROM QyWechatCardRecord q WHERE q.locationtitle = :locationtitle"),
    @NamedQuery(name = "QyWechatCardRecord.findByLocationdetail", query = "SELECT q FROM QyWechatCardRecord q WHERE q.locationdetail = :locationdetail"),
    @NamedQuery(name = "QyWechatCardRecord.findByWifiname", query = "SELECT q FROM QyWechatCardRecord q WHERE q.wifiname = :wifiname"),
    @NamedQuery(name = "QyWechatCardRecord.findByNotes", query = "SELECT q FROM QyWechatCardRecord q WHERE q.notes = :notes"),
    @NamedQuery(name = "QyWechatCardRecord.findByWifimac", query = "SELECT q FROM QyWechatCardRecord q WHERE q.wifimac = :wifimac"),
    @NamedQuery(name = "QyWechatCardRecord.findByMediaids", query = "SELECT q FROM QyWechatCardRecord q WHERE q.mediaids = :mediaids"),
    @NamedQuery(name = "QyWechatCardRecord.findByLat", query = "SELECT q FROM QyWechatCardRecord q WHERE q.lat = :lat"),
    @NamedQuery(name = "QyWechatCardRecord.findByLng", query = "SELECT q FROM QyWechatCardRecord q WHERE q.lng = :lng")})
public class QyWechatCardRecord extends BaseEntity{

    private static final long serialVersionUID = 1L;
  
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

    public QyWechatCardRecord() {
    }

    public QyWechatCardRecord(Integer id) {
        this.id = id;
    }

    public QyWechatCardRecord(Integer id, String userid) {
        this.id = id;
        this.userid = userid;
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
        if (!(object instanceof QyWechatCardRecord)) {
            return false;
        }
        QyWechatCardRecord other = (QyWechatCardRecord) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "QyWechatCardRecord{" + "id=" + id + ", userid=" + userid + ", groupname=" + groupname + ", checkintype=" + checkintype + ", exceptiontype=" + exceptiontype + ", checkintime=" + checkintime + ", locationtitle=" + locationtitle + ", locationDetail=" + locationdetail + ", wifiname=" + wifiname + ", notes=" + notes + ", wifimac=" + wifimac + ", mediaids=" + mediaids + ", lat=" + lat + ", lng=" + lng + '}';
    }

    
}
