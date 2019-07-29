/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrator
 */
@Embeddable
public class CdrhpriPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "cusno")
    private String cusno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "facno")
    private String facno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "itnbr")
    private String itnbr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "coin")
    private String coin;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "unpris")
    private BigDecimal unpris;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "trno")
    private String trno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trseq")
    private short trseq;

    public CdrhpriPK() {
    }

    public CdrhpriPK(String cusno, String facno, String itnbr, String coin, BigDecimal unpris, String trno, short trseq) {
        this.cusno = cusno;
        this.facno = facno;
        this.itnbr = itnbr;
        this.coin = coin;
        this.unpris = unpris;
        this.trno = trno;
        this.trseq = trseq;
    }

    public String getCusno() {
        return cusno;
    }

    public void setCusno(String cusno) {
        this.cusno = cusno;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public BigDecimal getUnpris() {
        return unpris;
    }

    public void setUnpris(BigDecimal unpris) {
        this.unpris = unpris;
    }

    public String getTrno() {
        return trno;
    }

    public void setTrno(String trno) {
        this.trno = trno;
    }

    public short getTrseq() {
        return trseq;
    }

    public void setTrseq(short trseq) {
        this.trseq = trseq;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cusno != null ? cusno.hashCode() : 0);
        hash += (facno != null ? facno.hashCode() : 0);
        hash += (itnbr != null ? itnbr.hashCode() : 0);
        hash += (coin != null ? coin.hashCode() : 0);
        hash += (unpris != null ? unpris.hashCode() : 0);
        hash += (trno != null ? trno.hashCode() : 0);
        hash += (int) trseq;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CdrhpriPK)) {
            return false;
        }
        CdrhpriPK other = (CdrhpriPK) object;
        if ((this.cusno == null && other.cusno != null) || (this.cusno != null && !this.cusno.equals(other.cusno))) {
            return false;
        }
        if ((this.facno == null && other.facno != null) || (this.facno != null && !this.facno.equals(other.facno))) {
            return false;
        }
        if ((this.itnbr == null && other.itnbr != null) || (this.itnbr != null && !this.itnbr.equals(other.itnbr))) {
            return false;
        }
        if ((this.coin == null && other.coin != null) || (this.coin != null && !this.coin.equals(other.coin))) {
            return false;
        }
        if ((this.unpris == null && other.unpris != null) || (this.unpris != null && !this.unpris.equals(other.unpris))) {
            return false;
        }
        if ((this.trno == null && other.trno != null) || (this.trno != null && !this.trno.equals(other.trno))) {
            return false;
        }
        if (this.trseq != other.trseq) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.CdrhpriPK[ cusno=" + cusno + ", facno=" + facno + ", itnbr=" + itnbr + ", coin=" + coin + ", unpris=" + unpris + ", trno=" + trno + ", trseq=" + trseq + " ]";
    }

}
