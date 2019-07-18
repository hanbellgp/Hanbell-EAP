/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.app;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C0160
 */
@Entity
@XmlRootElement
public class MCHZCW017 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String company;
    private String loanDate;
    private String loanUser;
    private String loanDept;
    private String loanproperty;
    private String loanpropertyDesc;
    private double trafficfee;
    private double accommodation;
    private double allowance;
    private double other;
    private double entertain;
    private String coin;
    private double loanTotal;
    private String preAccno;
    private String prePayDate;
    private String centerid;
    private String reason;

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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(String loanDate) {
        this.loanDate = loanDate;
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

    public String getLoanproperty() {
        return loanproperty;
    }

    public void setLoanproperty(String loanproperty) {
        this.loanproperty = loanproperty;
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

    public String getLoanpropertyDesc() {
        return loanpropertyDesc;
    }

    public void setLoanpropertyDesc(String loanpropertyDesc) {
        this.loanpropertyDesc = loanpropertyDesc;
    }

}
