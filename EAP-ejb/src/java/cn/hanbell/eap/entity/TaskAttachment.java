/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import com.lightshell.comm.SuperDetailEntity;
import java.util.Objects;
import javax.json.bind.annotation.JsonbTransient;
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
@Table(name = "taskattachment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TaskAttachment.findAll", query = "SELECT t FROM TaskAttachment t"),
    @NamedQuery(name = "TaskAttachment.findById", query = "SELECT t FROM TaskAttachment t WHERE t.id = :id"),
    @NamedQuery(name = "TaskAttachment.findByPId", query = "SELECT t FROM TaskAttachment t WHERE t.pid = :pid"),
    @NamedQuery(name = "TaskAttachment.findByUID", query = "SELECT t FROM TaskAttachment t WHERE t.uid = :uid"),
    @NamedQuery(name = "TaskAttachment.findByName", query = "SELECT t FROM TaskAttachment t WHERE t.name = :name"),
    @NamedQuery(name = "TaskAttachment.findByUrl", query = "SELECT t FROM TaskAttachment t WHERE t.url = :url"),
    @NamedQuery(name = "TaskAttachment.findByThumbUrl", query = "SELECT t FROM TaskAttachment t WHERE t.thumbUrl = :thumbUrl")})
public class TaskAttachment extends SuperDetailEntity {

    @JsonbTransient
    @ManyToOne(optional = false)
    @JoinColumn(name = "pid", referencedColumnName = "id", insertable = false, updatable = false)
    private Task task;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "uid")
    private String uid;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    @Size(max = 500)
    @Column(name = "url")
    private String url;
    @Size(max = 500)
    @Column(name = "thumbUrl")
    private String thumbUrl;

    public TaskAttachment() {
    }

    public TaskAttachment(int pid, int seq, String uid) {
        this.pid = pid;
        this.seq = seq;
        this.uid = uid;
    }

    /**
     * @return the task
     */
    public Task getTask() {
        return task;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
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
        if (!(object instanceof TaskAttachment)) {
            return false;
        }
        TaskAttachment other = (TaskAttachment) object;
        if (this.id != null && other.id != null) {
            return Objects.equals(this.id, other.id);
        }
        return Objects.equals(this.pid, other.pid) && Objects.equals(this.seq, other.seq);
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.TaskAttachment[ id=" + id + " ]";
    }

}
