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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C1879
 */
@Entity
@Table(name = "wechattag")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WeChatTag.findAll", query = "SELECT w FROM WeChatTag w"),
    @NamedQuery(name = "WeChatTag.findById", query = "SELECT w FROM WeChatTag w WHERE w.id = :id"),
    @NamedQuery(name = "WeChatTag.findByTagcode", query = "SELECT w FROM WeChatTag w WHERE w.tagcode = :tagcode"),
    @NamedQuery(name = "WeChatTag.findByTagname", query = "SELECT w FROM WeChatTag w WHERE w.tagname = :tagname"),
    @NamedQuery(name = "WeChatTag.findByWeChatStatus", query = "SELECT w FROM WeChatTag w WHERE w.weChatStatus = :weChatStatus")
})
public class WeChatTag extends SuperEntity {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tagcode")
    private String tagcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tagname")
    private String tagname;
    @Size(max = 2)
    @Column(name = "WeChatStatus")
    private String weChatStatus;

    public WeChatTag() {
    }

    public WeChatTag(Integer id, String tagid, String tagname, String status) {
        this.id = id;
        this.tagcode = tagid;
        this.tagname = tagname;
        this.status = status;
    }

    /**
     * @return the tagcode
     */
    public String getTagcode() {
        return tagcode;
    }

    /**
     * @param tagcode the tagcode to set
     */
    public void setTagcode(String tagcode) {
        this.tagcode = tagcode;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
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
        if (!(object instanceof WeChatTag)) {
            return false;
        }
        WeChatTag other = (WeChatTag) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.WeChatTag[ id=" + id + " ]";
    }

}
