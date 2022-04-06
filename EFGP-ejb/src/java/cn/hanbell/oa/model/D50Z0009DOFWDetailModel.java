/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C2082
 */
@XmlRootElement
public class D50Z0009DOFWDetailModel implements Serializable {

    private static final long serialVersionUID = 1L;
    private String seq;
    private String ksno;
    private BigDecimal travelAmount;
    private BigDecimal materialAmount;
    private BigDecimal hours;

    
    public String getKsno() {
        return ksno;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public void setKsno(String ksno) {
        this.ksno = ksno;
    }

    public BigDecimal getTravelAmount() {
        return travelAmount;
    }

    public void setTravelAmount(BigDecimal travelAmount) {
        this.travelAmount = travelAmount;
    }

    public BigDecimal getMaterialAmount() {
        return materialAmount;
    }

    public void setMaterialAmount(BigDecimal materialAmount) {
        this.materialAmount = materialAmount;
    }

    public BigDecimal getHours() {
        return hours;
    }

    public void setHours(BigDecimal hours) {
        this.hours = hours;
    }

   
    
    
}

