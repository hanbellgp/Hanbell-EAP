/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import com.lightshell.comm.SuperDetailEntity;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C0160
 */
@Entity
@Table(name = "productbom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductBom.findAll", query = "SELECT p FROM ProductBom p"),
    @NamedQuery(name = "ProductBom.findById", query = "SELECT p FROM ProductBom p WHERE p.id = :id"),
    @NamedQuery(name = "ProductBom.findByPId", query = "SELECT p FROM ProductBom p WHERE p.pid = :pid"),
    @NamedQuery(name = "ProductBom.findByCategory", query = "SELECT p FROM ProductBom p WHERE p.category = :category"),
    @NamedQuery(name = "ProductBom.findBySeries", query = "SELECT p FROM ProductBom p WHERE p.series = :series"),
    @NamedQuery(name = "ProductBom.findByItemno", query = "SELECT p FROM ProductBom p WHERE p.itemno = :itemno"),
    @NamedQuery(name = "ProductBom.findByItemDesc", query = "SELECT p FROM ProductBom p WHERE p.itemDesc = :itemDesc"),
    @NamedQuery(name = "ProductBom.findByItemSpec", query = "SELECT p FROM ProductBom p WHERE p.itemSpec = :itemSpec"),
    @NamedQuery(name = "ProductBom.findByItemModel", query = "SELECT p FROM ProductBom p WHERE p.itemModel = :itemModel")})
public class ProductBom extends SuperDetailEntity {

    @JsonbTransient
    @ManyToOne(optional = false)
    @JoinColumn(name = "pid", referencedColumnName = "id", insertable = false, updatable = false)
    private Product parent;

    @ManyToOne(optional = true)
    @JoinColumn(name = "itemno", referencedColumnName = "itemno", insertable = false, updatable = false)
    private Product product;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "parent")
    @JoinTable(name = "itemsubstitute")
    private List<ItemSubstitute> substituteList = new ArrayList<ItemSubstitute>();

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

    public ProductBom() {
    }

    /**
     * @return the parent
     */
    public Product getParent() {
        return parent;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @return the substituteList
     */
    public List<ItemSubstitute> getSubstituteList() {
        return substituteList;
    }

    /**
     * @param substituteList the substituteList to set
     */
    public void setSubstituteList(List<ItemSubstitute> substituteList) {
        this.substituteList = substituteList;
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
        if (!(object instanceof ProductBom)) {
            return false;
        }
        ProductBom other = (ProductBom) object;
        if (this.id != null && other.id != null) {
            return Objects.equals(this.id, other.id);
        }
        boolean ret = Objects.equals(this.pid, other.pid) && Objects.equals(this.itemno, other.itemno);
        return ret;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.ProductBom[ id=" + id + " ]";
    }

}
