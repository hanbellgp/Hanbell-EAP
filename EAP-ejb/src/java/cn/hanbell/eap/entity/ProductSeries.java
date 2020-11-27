/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import com.lightshell.comm.SuperEntity;
import java.util.Objects;
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
@Table(name = "productseries")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductSeries.findAll", query = "SELECT p FROM ProductSeries p"),
    @NamedQuery(name = "ProductSeries.findById", query = "SELECT p FROM ProductSeries p WHERE p.id = :id"),
    @NamedQuery(name = "ProductSeries.findByCategory", query = "SELECT p FROM ProductSeries p WHERE p.category = :category"),
    @NamedQuery(name = "ProductSeries.findBySeries", query = "SELECT p FROM ProductSeries p WHERE p.series = :series"),
    @NamedQuery(name = "ProductSeries.findByUID", query = "SELECT p FROM ProductSeries p WHERE p.uid = :uid"),
    @NamedQuery(name = "ProductSeries.findByStatus", query = "SELECT p FROM ProductSeries p WHERE p.status = :status")})
public class ProductSeries extends SuperEntity {

    @Basic(optional = false)
    @Size(min = 1, max = 45)
    @Column(name = "category")
    private String category;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "series")
    private String series;
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @Size(max = 200)
    @Column(name = "remark")
    private String remark;
    @Size(max = 45)
    @Column(name = "uid")
    private String uid;

    public ProductSeries() {
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUID() {
        return uid;
    }

    public void setUID(String uid) {
        this.uid = uid;
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
        if (!(object instanceof ProductSeries)) {
            return false;
        }
        ProductSeries other = (ProductSeries) object;
        if (this.series != null && other.series != null) {
            return this.series.equals(other.series);
        }
        if (this.id != null && other.id != null) {
            return Objects.equals(this.id, other.id);
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.ProductSeries[ id=" + id + " ]";
    }

}
