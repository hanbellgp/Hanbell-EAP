/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.wei.entity;

import com.lightshell.comm.SuperDetailEntity;
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
 * @author C0160
 */
@Entity
@Table(name = "gallerydetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GalleryDetail.findAll", query = "SELECT g FROM GalleryDetail g"),
    @NamedQuery(name = "GalleryDetail.findById", query = "SELECT g FROM GalleryDetail g WHERE g.id = :id"),
    @NamedQuery(name = "GalleryDetail.findByPId", query = "SELECT g FROM GalleryDetail g WHERE g.pid = :pid")})
public class GalleryDetail extends SuperDetailEntity {

    @Basic(optional = false)
    @NotNull
    @Column(name = "resource")
    private boolean resource;
    @Size(max = 45)
    @Column(name = "subject")
    private String subject;
    @Size(max = 100)
    @Column(name = "content")
    private String content;
    @Size(max = 200)
    @Column(name = "imgfile")
    private String imgfile;

    public GalleryDetail() {
        resource = false;
    }

    /**
     * @return the resource
     */
    public boolean isResource() {
        return resource;
    }

    /**
     * @param resource the resource to set
     */
    public void setResource(boolean resource) {
        this.resource = resource;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
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
        if (!(object instanceof GalleryDetail)) {
            return false;
        }
        GalleryDetail other = (GalleryDetail) object;
        if (this.id != null && other.id != null) {
            return this.id.equals(other.id);
        }
        if (this.pid != 0 && other.pid != 0) {
            return this.pid == other.pid && this.seq == other.seq;
        }
        return this.seq == other.seq;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.GalleryDetail[ id=" + id + " ]";
    }

}
