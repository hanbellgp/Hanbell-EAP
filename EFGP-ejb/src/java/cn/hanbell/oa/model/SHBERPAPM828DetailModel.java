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
 * @author C0160
 */
@XmlRootElement
public class SHBERPAPM828DetailModel implements Serializable {

    private String seq;
    private String apdsc;
    private String coin;
    private String ratio;
    private BigDecimal apamtfs;
    private BigDecimal apamt;
    private String dmark;
    private String budgetacc;

    public SHBERPAPM828DetailModel() {
        this.apamtfs = BigDecimal.ZERO;
        this.apamt = BigDecimal.ZERO;
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

    public BigDecimal getApamtfs() {
        return apamtfs;
    }

    public void setApamtfs(BigDecimal apamtfs) {
        this.apamtfs = apamtfs;
    }

    public BigDecimal getApamt() {
        return apamt;
    }

    public void setApamt(BigDecimal apamt) {
        this.apamt = apamt;
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
        if (!(object instanceof SHBERPAPM828DetailModel)) {
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

}
