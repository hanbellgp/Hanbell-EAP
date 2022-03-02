/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.costctrl.app;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@XmlRootElement
public class MCHZCW017 extends HmacSha1Signature implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String facno;
    //private String loanDate;
    private String loanUser;
    private String loanDept;
    private String loanProperty;
    private String traffic;
    private double trafficfee;
    private double accommodation;
    private double allowance;
    private double other;
    private double entertain;
    private String coin;
    private double loanTotal;
    private String preAccno;
    private String preAccname;
    private String prePayDate;
    private String centerid;
    private String reason;
    private String srcno;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MCHZCW017)) {
            return false;
        }
        MCHZCW017 mchzcw017 = (MCHZCW017) object;
        if ((this.id == null && mchzcw017.id != null) || (this.id != null && !this.id.equals(mchzcw017.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.app.MCHZCW017[ id=" + id + " ]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoanUser() {
        return loanUser;
    }

    public void setLoanUser(String loanUser) {
        this.loanUser = loanUser;
    }

    public String getLoanDept() {
        return loanDept;
    }

    public void setLoanDept(String loanDept) {
        this.loanDept = loanDept;
    }

    public double getTrafficfee() {
        return trafficfee;
    }

    public void setTrafficfee(double trafficfee) {
        this.trafficfee = trafficfee;
    }

    public double getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(double accommodation) {
        this.accommodation = accommodation;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    public double getOther() {
        return other;
    }

    public void setOther(double other) {
        this.other = other;
    }

    public double getEntertain() {
        return entertain;
    }

    public void setEntertain(double entertain) {
        this.entertain = entertain;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public double getLoanTotal() {
        return loanTotal;
    }

    public void setLoanTotal(double loanTotal) {
        this.loanTotal = loanTotal;
    }

    public String getPreAccno() {
        return preAccno;
    }

    public void setPreAccno(String preAccno) {
        this.preAccno = preAccno;
    }

    public String getPrePayDate() {
        return prePayDate;
    }

    public void setPrePayDate(String prePayDate) {
        this.prePayDate = prePayDate;
    }

    public String getCenterid() {
        return centerid;
    }

    public void setCenterid(String centerid) {
        this.centerid = centerid;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getLoanProperty() {
        return loanProperty;
    }

    public void setLoanProperty(String loanProperty) {
        this.loanProperty = loanProperty;
    }

    public String getTraffic() {
        return traffic;
    }

    public void setTraffic(String traffic) {
        this.traffic = traffic;
    }

    public String getPreAccname() {
        return preAccname;
    }

    public void setPreAccname(String preAccname) {
        this.preAccname = preAccname;
    }

    public String getSrcno() {
        return srcno;
    }

    public void setSrcno(String srcno) {
        this.srcno = srcno;
    }

}
