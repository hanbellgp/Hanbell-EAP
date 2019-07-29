/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrator
 */
@Embeddable
public class MisratePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "coin")
    private String coin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rateday")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rateday;

    public MisratePK() {
    }

    public MisratePK(String coin, Date rateday) {
        this.coin = coin;
        this.rateday = rateday;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public Date getRateday() {
        return rateday;
    }

    public void setRateday(Date rateday) {
        this.rateday = rateday;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coin != null ? coin.hashCode() : 0);
        hash += (rateday != null ? rateday.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MisratePK)) {
            return false;
        }
        MisratePK other = (MisratePK) object;
        if ((this.coin == null && other.coin != null) || (this.coin != null && !this.coin.equals(other.coin))) {
            return false;
        }
        if ((this.rateday == null && other.rateday != null) || (this.rateday != null && !this.rateday.equals(other.rateday))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.MisratePK[ coin=" + coin + ", rateday=" + rateday + " ]";
    }

}
