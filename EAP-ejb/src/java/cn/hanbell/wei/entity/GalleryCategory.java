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
@Table(name = "gallerycategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GalleryCategory.findAll", query = "SELECT c FROM GalleryCategory c"),
    @NamedQuery(name = "GalleryCategory.findById", query = "SELECT c FROM GalleryCategory c WHERE c.id = :id"),
    @NamedQuery(name = "GalleryCategory.findByName", query = "SELECT c FROM GalleryCategory c WHERE c.name = :name"),
    @NamedQuery(name = "GalleryCategory.findByClassname", query = "SELECT c FROM GalleryCategory c WHERE c.classname = :classname"),
    @NamedQuery(name = "GalleryCategory.findByItemcount", query = "SELECT c FROM GalleryCategory c WHERE c.itemcount = :itemcount"),
    @NamedQuery(name = "GalleryCategory.findByStatus", query = "SELECT c FROM GalleryCategory c WHERE c.status = :status")})
public class GalleryCategory extends SuperEntity {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "name")
    private String name;
    @Size(max = 20)
    @Column(name = "classname")
    private String classname;
    @Column(name = "itemcount")
    private Integer itemcount;

    public GalleryCategory() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public Integer getItemcount() {
        return itemcount;
    }

    public void setItemcount(Integer itemcount) {
        this.itemcount = itemcount;
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
        if (!(object instanceof GalleryCategory)) {
            return false;
        }
        GalleryCategory other = (GalleryCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.Category[ id=" + id + " ]";
    }

}
