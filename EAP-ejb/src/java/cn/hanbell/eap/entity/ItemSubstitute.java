/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import com.lightshell.comm.SuperDetailEntity;
import java.math.BigDecimal;
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
@Table(name = "itemsubstitute")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemSubstitute.findAll", query = "SELECT i FROM ItemSubstitute i"),
    @NamedQuery(name = "ItemSubstitute.findById", query = "SELECT i FROM ItemSubstitute i WHERE i.id = :id"),
    @NamedQuery(name = "ItemSubstitute.findByPId", query = "SELECT i FROM ItemSubstitute i WHERE i.pid = :pid"),
    @NamedQuery(name = "ItemSubstitute.findByCategory", query = "SELECT i FROM ItemSubstitute i WHERE i.category = :category"),
    @NamedQuery(name = "ItemSubstitute.findBySeries", query = "SELECT i FROM ItemSubstitute i WHERE i.series = :series"),
    @NamedQuery(name = "ItemSubstitute.findByItemno", query = "SELECT i FROM ItemSubstitute i WHERE i.itemno = :itemno"),
    @NamedQuery(name = "ItemSubstitute.findByItemDesc", query = "SELECT i FROM ItemSubstitute i WHERE i.itemDesc = :itemDesc"),
    @NamedQuery(name = "ItemSubstitute.findByItemSpec", query = "SELECT i FROM ItemSubstitute i WHERE i.itemSpec = :itemSpec"),
    @NamedQuery(name = "ItemSubstitute.findByItemModel", query = "SELECT i FROM ItemSubstitute i WHERE i.itemModel = :itemModel")})
public class ItemSubstitute extends SuperDetailEntity {

    @JsonbTransient
    @ManyToOne(optional = false)
    @JoinColumn(name = "pid", referencedColumnName = "id", insertable = false, updatable = false)
    private ProductBom parent;

    @Size(max = 45)
    @Column(name = "category")
    private String category;
    @Size(max = 45)
    @Column(name = "series")
    private String series;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "itemno")
    private String itemno;
    @Size(max = 100)
    @Column(name = "itemDesc")
    private String itemDesc;
    @Size(max = 100)
    @Column(name = "itemSpec")
    private String itemSpec;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "itemModel")
    private String itemModel;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "qty")
    private BigDecimal qty;
    @Size(max = 200)
    @Column(name = "remark")
    private String remark;

    public ItemSubstitute() {
    }

    /**
     * @return the parent
     */
    public ProductBom getParent() {
        return parent;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getItemno() {
        return itemno;
    }

    public void setItemno(String itemno) {
        this.itemno = itemno;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public String getItemSpec() {
        return itemSpec;
    }

    public void setItemSpec(String itemSpec) {
        this.itemSpec = itemSpec;
    }

    public String getItemModel() {
        return itemModel;
    }

    public void setItemModel(String itemModel) {
        this.itemModel = itemModel;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
        if (!(object instanceof ItemSubstitute)) {
            return false;
        }
        ItemSubstitute other = (ItemSubstitute) object;
        if (this.id != null && other.id != null) {
            return Objects.equals(this.id, other.id);
        }
        boolean ret = Objects.equals(this.pid, other.pid) && Objects.equals(this.itemno, other.itemno);
        return ret;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.ItemSubstitute[ id=" + id + " ]";
    }

}
