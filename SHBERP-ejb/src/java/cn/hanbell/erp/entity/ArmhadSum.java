/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C0160
 */
@Entity
@XmlRootElement
public class ArmhadSum implements Serializable {
    
    @Id
    private String cusno;
    private String cusna;
    private String mancode;
    private String manname;
    private String coin;
    private BigDecimal warningamts;
    private BigDecimal thisrec;
    private BigDecimal totalrec;
    private BigDecimal nobill;

    /**
     * @return the cusno
     */
    public String getCusno() {
        return cusno;
    }

    /**
     * @param cusno the cusno to set
     */
    public void setCusno(String cusno) {
        this.cusno = cusno;
    }

    /**
     * @return the cusna
     */
    public String getCusna() {
        return cusna;
    }

    /**
     * @param cusna the cusna to set
     */
    public void setCusna(String cusna) {
        this.cusna = cusna;
    }

    /**
     * @return the mancode
     */
    public String getMancode() {
        return mancode;
    }

    /**
     * @param mancode the mancode to set
     */
    public void setMancode(String mancode) {
        this.mancode = mancode;
    }

    /**
     * @return the manname
     */
    public String getManname() {
        return manname;
    }

    /**
     * @param manname the manname to set
     */
    public void setManname(String manname) {
        this.manname = manname;
    }

    /**
     * @return the warningamts
     */
    public BigDecimal getWarningamts() {
        return warningamts;
    }

    /**
     * @param warningamts the warningamts to set
     */
    public void setWarningamts(BigDecimal warningamts) {
        this.warningamts = warningamts;
    }

    /**
     * @return the thisrec
     */
    public BigDecimal getThisrec() {
        return thisrec;
    }

    /**
     * @param thisrec the thisrec to set
     */
    public void setThisrec(BigDecimal thisrec) {
        this.thisrec = thisrec;
    }

    /**
     * @return the totalrec
     */
    public BigDecimal getTotalrec() {
        return totalrec;
    }

    /**
     * @param totalrec the totalrec to set
     */
    public void setTotalrec(BigDecimal totalrec) {
        this.totalrec = totalrec;
    }

    /**
     * @return the nobill
     */
    public BigDecimal getNobill() {
        return nobill;
    }

    /**
     * @param nobill the nobill to set
     */
    public void setNobill(BigDecimal nobill) {
        this.nobill = nobill;
    }

    /**
     * @return the coin
     */
    public String getCoin() {
        return coin;
    }

    /**
     * @param coin the coin to set
     */
    public void setCoin(String coin) {
        this.coin = coin;
    }
 
}
