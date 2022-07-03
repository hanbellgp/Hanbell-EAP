/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.costctrl.app;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@XmlRootElement
public class MCArrear {

    private String oapsn;
    private String srcno;
    private String loanDate;
    private double loanTotal;
    private double arrear;

    public MCArrear(String oapsn, String srcno, String loanDate, double loanTotal, double arrear) {
        this.oapsn = oapsn;
        this.srcno = srcno;
        this.loanDate = loanDate;
        this.loanTotal = loanTotal;
        this.arrear = arrear;

    }

    public String getOapsn() {
        return oapsn;
    }

    public void setOapsn(String oapsn) {
        this.oapsn = oapsn;
    }

    public String getSrcno() {
        return srcno;
    }

    public void setSrcno(String srcno) {
        this.srcno = srcno;
    }

    public double getLoanTotal() {
        return loanTotal;
    }

    public void setLoanTotal(double loanTotal) {
        this.loanTotal = loanTotal;
    }

    public double getArrear() {
        return arrear;
    }

    public void setArrear(double arrear) {
        this.arrear = arrear;
    }

    public String getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(String loanDate) {
        this.loanDate = loanDate;
    }

}
