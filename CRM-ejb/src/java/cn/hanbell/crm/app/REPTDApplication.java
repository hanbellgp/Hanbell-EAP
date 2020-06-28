/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.app;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C2082
 */
@XmlRootElement
public class REPTDApplication implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String productNumberId;

    private String productQuality;

    private String product_name;

    private String productStandard;

    private String warrantyStart;

    private String warrantyEnd;

    private String planMaintainCount;

    private String maintainCategoryId;

    private String maintainCategoryName;

    private String warehouseId;

    private String warehouseName;

    private String productUnit;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    public String getProductNumberId() {
        return productNumberId;
    }

    public void setProductNumberId(String productNumberId) {
        this.productNumberId = productNumberId;
    }

    public String getProductQuality() {
        return productQuality;
    }

    public void setProductQuality(String productQuality) {
        this.productQuality = productQuality;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProductStandard() {
        return productStandard;
    }

    public void setProductStandard(String productStandard) {
        this.productStandard = productStandard;
    }

    public String getWarrantyStart() {
        return warrantyStart;
    }

    public void setWarrantyStart(String warrantyStart) {
        this.warrantyStart = warrantyStart;
    }

    public String getWarrantyEnd() {
        return warrantyEnd;
    }

    public void setWarrantyEnd(String warrantyEnd) {
        this.warrantyEnd = warrantyEnd;
    }

    public String getPlanMaintainCount() {
        return planMaintainCount;
    }

    public void setPlanMaintainCount(String planMaintainCount) {
        this.planMaintainCount = planMaintainCount;
    }

    public String getMaintainCategoryId() {
        return maintainCategoryId;
    }

    public void setMaintainCategoryId(String maintainCategoryId) {
        this.maintainCategoryId = maintainCategoryId;
    }

    public String getMaintainCategoryName() {
        return maintainCategoryName;
    }

    public void setMaintainCategoryName(String maintainCategoryName) {
        this.maintainCategoryName = maintainCategoryName;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

}
