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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C1879
 */
@Entity
@Table(name = "wechattaguser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WechatTagUser.findAll", query = "SELECT w FROM WechatTagUser w")
    , @NamedQuery(name = "WechatTagUser.findById", query = "SELECT w FROM WechatTagUser w WHERE w.id = :id")
    , @NamedQuery(name = "WechatTagUser.findByTagid", query = "SELECT w FROM WechatTagUser w WHERE w.tagid = :tagid")
    , @NamedQuery(name = "WechatTagUser.findByUserid", query = "SELECT w FROM WechatTagUser w WHERE w.userid = :userid")
    , @NamedQuery(name = "WechatTagUser.findByTagidAndUserid", query = "SELECT w FROM WechatTagUser w WHERE w.userid = :userid AND w.tagid = :tagid ")
    , @NamedQuery(name = "WechatTagUser.findByWeChatStatus", query = "SELECT w FROM WechatTagUser w WHERE w.weChatStatus = :weChatStatus")})
public class WechatTagUser extends SuperEntity {

    @JoinColumn(name = "userid", referencedColumnName = "userid", insertable = false, updatable = false)
    @OneToOne(optional = true)
    private SystemUser user;
    
    @JoinColumn(name = "tagid", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = true)
    private WechatTag tag;

    @Basic(optional = false)
    @NotNull
    @Column(name = "tagid")
    private int tagid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "userid")
    private String userid;
    @Size(max = 2)
    @Column(name = "WeChatStatus")
    private String weChatStatus;

    public WechatTagUser() {
        this.status = "N";
        this.weChatStatus = "N";
    }

    public WechatTagUser(Integer id, int tagid, String userid, String status) {
        this.id = id;
        this.tagid = tagid;
        this.userid = userid;
        this.status = status;
    }

    public int getTagid() {
        return tagid;
    }

    public void setTagid(int tagid) {
        this.tagid = tagid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getWeChatStatus() {
        return weChatStatus;
    }

    public void setWeChatStatus(String weChatStatus) {
        this.weChatStatus = weChatStatus;
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
        if (!(object instanceof WechatTagUser)) {
            return false;
        }
        WechatTagUser other = (WechatTagUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.WechatTagUser[ id=" + id + " ]";
    }

    /**
     * @return the user
     */
    public SystemUser getUser() {
        return user;
    }

    /**
     * @return the tag
     */
    public WechatTag getTag() {
        return tag;
    }

}
