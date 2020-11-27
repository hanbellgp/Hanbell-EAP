/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import com.lightshell.comm.BaseLib;
import com.lightshell.comm.FormDetailEntity;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C0160
 */
@Entity
@Table(name = "shipmentdetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShipmentDetail.findAll", query = "SELECT s FROM ShipmentDetail s"),
    @NamedQuery(name = "ShipmentDetail.findById", query = "SELECT s FROM ShipmentDetail s WHERE s.id = :id"),
    @NamedQuery(name = "ShipmentDetail.findByPId", query = "SELECT s FROM ShipmentDetail s WHERE s.pid = :pid ORDER BY s.shpno,s.shpseq")})
public class ShipmentDetail extends FormDetailEntity {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "shpno")
    private String shpno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "shpdate")
    @Temporal(TemporalType.DATE)
    private Date shpdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "shpseq")
    private int shpseq;
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
    @Size(max = 45)
    @Column(name = "itemModel")
    private String itemModel;
    @Size(max = 60)
    @Column(name = "customerItem")
    private String customerItem;
    @Size(max = 45)
    @Column(name = "customerItemDesc")
    private String customerItemDesc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lotseq")
    private int lotseq;
    @Size(max = 45)
    @Column(name = "fixnr")
    private String fixnr;
    @Size(max = 45)
    @Column(name = "varnr")
    private String varnr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "wareh")
    private String wareh;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qty")
    private BigDecimal qty;
    @Size(max = 200)
    @Column(name = "remark")
    private String remark;
    @Size(max = 100)
    @Column(name = "relapi")
    private String relapi;
    @Size(max = 20)
    @Column(name = "relformid")
    private String relformid;
    @Column(name = "relseq")
    private Integer relseq;

    public ShipmentDetail() {
    }

    public String getShpno() {
        return shpno;
    }

    public void setShpno(String shpno) {
        this.shpno = shpno;
    }

    public Date getShpdate() {
        return shpdate;
    }

    public void setShpdate(Date shpdate) {
        this.shpdate = shpdate;
    }

    public int getShpseq() {
        return shpseq;
    }

    public void setShpseq(int shpseq) {
        this.shpseq = shpseq;
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

    public String getCustomerItem() {
        return customerItem;
    }

    public void setCustomerItem(String customerItem) {
        this.customerItem = customerItem;
    }

    public String getCustomerItemDesc() {
        return customerItemDesc;
    }

    public void setCustomerItemDesc(String customerItemDesc) {
        this.customerItemDesc = customerItemDesc;
    }

    public int getLotseq() {
        return lotseq;
    }

    public void setLotseq(int lotseq) {
        this.lotseq = lotseq;
    }

    public String getFixnr() {
        return fixnr;
    }

    public void setFixnr(String fixnr) {
        this.fixnr = fixnr;
    }

    public String getVarnr() {
        return varnr;
    }

    public void setVarnr(String varnr) {
        this.varnr = varnr;
    }

    public String getWareh() {
        return wareh;
    }

    public void setWareh(String wareh) {
        this.wareh = wareh;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    /**
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return the relapi
     */
    public String getRelapi() {
        return relapi;
    }

    /**
     * @param relapi the relapi to set
     */
    public void setRelapi(String relapi) {
        this.relapi = relapi;
    }

    /**
     * @return the relformid
     */
    public String getRelformid() {
        return relformid;
    }

    /**
     * @param relformid the relformid to set
     */
    public void setRelformid(String relformid) {
        this.relformid = relformid;
    }

    /**
     * @return the relseq
     */
    public Integer getRelseq() {
        return relseq;
    }

    /**
     * @param relseq the relseq to set
     */
    public void setRelseq(Integer relseq) {
        this.relseq = relseq;
    }

    //由于得到的shpdate是日期格式， 报表中无法追加字符串，报表fetch事件中引用该方法
    public String getShpdateAndLotseq() {
        String date = BaseLib.formatDate("yyyyMMdd", this.getShpdate());
        return new StringBuffer(date).append("-").append(this.getLotseq()).toString();
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
        if (!(object instanceof ShipmentDetail)) {
            return false;
        }
        ShipmentDetail other = (ShipmentDetail) object;
        if (this.id != null && other.id != null) {
            return Objects.equals(this.id, other.id);
        }
        return this.shpno == other.shpno && this.seq == other.seq;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.ShipmentDetail[ id=" + id + " ]";
    }

}
