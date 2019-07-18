/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.wei.entity;

import com.lightshell.comm.SuperDetailEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C0160
 */
@Entity
@Table(name = "maintenancedetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaintenanceDetail.findAll", query = "SELECT m FROM MaintenanceDetail m"),
    @NamedQuery(name = "MaintenanceDetail.findById", query = "SELECT m FROM MaintenanceDetail m WHERE m.id = :id"),
    @NamedQuery(name = "MaintenanceDetail.findByPId", query = "SELECT m FROM MaintenanceDetail m WHERE m.pid = :pid")})
public class MaintenanceDetail extends SuperDetailEntity {

    @Column(name = "resource")
    private Boolean resource;
    @Size(max = 45)
    @Column(name = "subject")
    private String subject;
    @Size(max = 2147483647)
    @Column(name = "content")
    private String content;
    @Size(max = 200)
    @Column(name = "imgfile")
    private String imgfile;

    public MaintenanceDetail() {
    }

    public Boolean getResource() {
        return resource;
    }

    public void setResource(Boolean resource) {
        this.resource = resource;
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

    public String getImgfile() {
        return imgfile;
    }

    public void setImgfile(String imgfile) {
        this.imgfile = imgfile;
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
        if (!(object instanceof MaintenanceDetail)) {
            return false;
        }
        MaintenanceDetail other = (MaintenanceDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.wei.entity.MaintenanceDetail[ id=" + id + " ]";
    }

}
