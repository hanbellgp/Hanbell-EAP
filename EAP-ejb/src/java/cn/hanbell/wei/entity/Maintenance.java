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
@Table(name = "maintenance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maintenance.getRowCount", query = "SELECT COUNT(m) FROM Maintenance m"),
    @NamedQuery(name = "Maintenance.findAll", query = "SELECT m FROM Maintenance m"),
    @NamedQuery(name = "Maintenance.findById", query = "SELECT m FROM Maintenance m WHERE m.id = :id"),
    @NamedQuery(name = "Maintenance.findByCategoryId", query = "SELECT m FROM Maintenance m WHERE m.status='V' AND m.category.id = :categoryid ORDER BY m.ontop DESC,m.id DESC"),
    @NamedQuery(name = "Maintenance.findByTitle", query = "SELECT m FROM Maintenance m WHERE m.title = :title"),
    @NamedQuery(name = "Maintenance.findBySubtitle", query = "SELECT m FROM Maintenance m WHERE m.subtitle = :subtitle"),
    @NamedQuery(name = "Maintenance.findByContent", query = "SELECT m FROM Maintenance m WHERE m.content = :content"),
    @NamedQuery(name = "Maintenance.findByOntop", query = "SELECT m FROM Maintenance m WHERE m.ontop = :ontop"),
    @NamedQuery(name = "Maintenance.findByImgfile", query = "SELECT m FROM Maintenance m WHERE m.imgfile = :imgfile"),
    @NamedQuery(name = "Maintenance.findByStatus", query = "SELECT m FROM Maintenance m WHERE m.status = :status")})
public class Maintenance extends SuperEntity {

    @JoinColumn(name = "categoryid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MaintenanceCategory category;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "hits")
    private int hits;
    @Size(max = 200)
    @Column(name = "imgfile")
    private String imgfile;

    public Maintenance() {
    }

    /**
     * @return the category
     */
    public MaintenanceCategory getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(MaintenanceCategory category) {
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
        if (!(object instanceof Maintenance)) {
            return false;
        }
        Maintenance other = (Maintenance) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.wei.entity.Maintenance[ id=" + id + " ]";
    }

}
