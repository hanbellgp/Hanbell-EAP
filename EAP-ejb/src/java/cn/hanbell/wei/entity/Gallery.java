/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.wei.entity;

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
@Table(name = "gallery")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gallery.getRowCount", query = "SELECT COUNT(g) FROM Gallery g"),
    @NamedQuery(name = "Gallery.findAll", query = "SELECT g FROM Gallery g"),
    @NamedQuery(name = "Gallery.findById", query = "SELECT g FROM Gallery g WHERE g.id = :id"),
    @NamedQuery(name = "Gallery.findByCategoryId", query = "SELECT g FROM Gallery g WHERE g.status='V' AND g.category.id = :categoryid ORDER BY g.ontop DESC,g.id DESC"),
    @NamedQuery(name = "Gallery.findByStatus", query = "SELECT g FROM Gallery g WHERE g.status = :status")})
public class Gallery extends SuperEntity {

    @JoinColumn(name = "categoryid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GalleryCategory category;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "title")
    private String title;
    @Size(max = 100)
    @Column(name = "subtitle")
    private String subtitle;
    @Size(max = 400)
    @Column(name = "content")
    private String content;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ontop")
    private boolean ontop;
    @Column(name = "homeadv")
    private Boolean homeadv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hits")
    private int hits;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "imgfile")
    private String imgfile;

    public Gallery() {
        this.ontop = false;
        this.homeadv = false;
        this.hits = 0;
    }

    public GalleryCategory getCategory() {
        return category;
    }

    public void setCategory(GalleryCategory category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean getOntop() {
        return ontop;
    }

    public void setOntop(boolean ontop) {
        this.ontop = ontop;
    }

    public Boolean getHomeadv() {
        return homeadv;
    }

    public void setHomeadv(Boolean homeadv) {
        this.homeadv = homeadv;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
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
        if (!(object instanceof Gallery)) {
            return false;
        }
        Gallery other = (Gallery) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.Gallery[ id=" + id + " ]";
    }

}
