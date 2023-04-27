/*
 * To change this license header, choose License Headers in Project Properties. To change this template file, choose
 * Tools | Templates and open the template in the editor.
 */
package cn.hanbell.oa.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C1491
 */
@XmlRootElement
public class VHTV005DetailModel implements Serializable {

    private String seq;
    private String apdsc;
    private String bilno;
    private String coin;
    private String ratio;
    private BigDecimal acpamtfs;
    private BigDecimal acpamt;
    private BigDecimal com_apamtfs;
    private BigDecimal com_apamt;
    private BigDecimal temamtfs;
    private BigDecimal temamt;
    private String dmark;
    private String centerid;
    private String cmp_centerid;
    private String budgetacc;
    private String cmp_budgetacc;
    private BigDecimal payqty;

    public VHTV005DetailModel() {
        this.acpamtfs = BigDecimal.ZERO;
        this.acpamt = BigDecimal.ZERO;
        this.com_apamtfs = BigDecimal.ZERO;
        this.com_apamt = BigDecimal.ZERO;
        this.temamtfs = BigDecimal.ZERO;
        this.temamt = BigDecimal.ZERO;

    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getApdsc() {
        return apdsc;
    }

    public void setApdsc(String apdsc) {
        this.apdsc = apdsc;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    public String getDmark() {
        return dmark;
    }

    public void setDmark(String dmark) {
        this.dmark = dmark;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VHTV005DetailModel)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.SHBERPAPM828DetailModel";
    }

    public String getBudgetacc() {
        return budgetacc;
    }

    public void setBudgetacc(String budgetacc) {
        this.budgetacc = budgetacc;
    }

    public String getBilno() {
        return bilno;
    }

    public void setBilno(String bilno) {
        this.bilno = bilno;
    }

    public BigDecimal getTemamtfs() {
        return temamtfs;
    }

    public void setTemamtfs(BigDecimal temamtfs) {
        this.temamtfs = temamtfs;
    }

    public BigDecimal getTemamt() {
        return temamt;
    }

    public void setTemamt(BigDecimal temamt) {
        this.temamt = temamt;
    }

    public String getCenterid() {
        return centerid;
    }

    public void setCenterid(String centerid) {
        this.centerid = centerid;
    }

    public String getCmp_centerid() {
        return cmp_centerid;
    }

    public void setCmp_centerid(String cmp_centerid) {
        this.cmp_centerid = cmp_centerid;
    }

    public String getCmp_budgetacc() {
        return cmp_budgetacc;
    }

    public void setCmp_budgetacc(String cmp_budgetacc) {
        this.cmp_budgetacc = cmp_budgetacc;
    }

    public BigDecimal getAcpamtfs() {
        return acpamtfs;
    }

    public void setAcpamtfs(BigDecimal acpamtfs) {
        this.acpamtfs = acpamtfs;
    }

    public BigDecimal getAcpamt() {
        return acpamt;
    }

    public void setAcpamt(BigDecimal acpamt) {
        this.acpamt = acpamt;
    }

    public BigDecimal getCom_apamtfs() {
        return com_apamtfs;
    }

    public void setCom_apamtfs(BigDecimal com_apamtfs) {
        this.com_apamtfs = com_apamtfs;
    }

    public BigDecimal getCom_apamt() {
        return com_apamt;
    }

    public void setCom_apamt(BigDecimal com_apamt) {
        this.com_apamt = com_apamt;
    }

    public BigDecimal getPayqty() {
        return payqty;
    }

    public void setPayqty(BigDecimal payqty) {
        this.payqty = payqty;
    }

}
