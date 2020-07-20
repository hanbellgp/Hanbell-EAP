/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.validation.constraints.Size;

/**
 *
 * @author C2082
 */
public class HKGC001DetailModel implements Serializable {

    private String itnbrf;
    private String itnbrfname;
    private String itnbr;
    private String itnbrname;
    private String wareh;
    private String whdsc;
    private String qty;
    private String wareh2;
    private String whdsc2;
    private String needdate;
    private String purchasehelp;
    private String finishdate;
    private String transno;
    private String finqty;
    private String endDatetxt;
    private String stockDatetxt;
    private String oid;
    private String mancode;
    private String seq;
    private String manname;
    private String formSerialNumber;
    private Date applydate;
    public String getPurchasehelp() {
        return purchasehelp;
    }

    public void setPurchasehelp(String purchasehelp) {
        this.purchasehelp = purchasehelp;
    }

    public String getItnbrf() {
        return itnbrf;
    }

    public void setItnbrf(String itnbrf) {
        this.itnbrf = itnbrf;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getFinqty() {
        return finqty;
    }

    public void setFinqty(String finqty) {
        this.finqty = finqty;
    }

    public String getWareh() {
        return wareh;
    }

    public void setWareh(String wareh) {
        this.wareh = wareh;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getWareh2() {
        return wareh2;
    }

    public void setWareh2(String wareh2) {
        this.wareh2 = wareh2;
    }

    public String getItnbrname() {
        return itnbrname;
    }

    public void setItnbrname(String itnbrname) {
        this.itnbrname = itnbrname;
    }

    public String getWhdsc2() {
        return whdsc2;
    }

    public void setWhdsc2(String whdsc2) {
        this.whdsc2 = whdsc2;
    }

    public String getNeeddate() {
        return needdate;
    }

    public void setNeeddate(String needdate) {
        this.needdate = needdate;
    }

    public String getMancode() {
        return mancode;
    }

    public void setMancode(String mancode) {
        this.mancode = mancode;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getWhdsc() {
        return whdsc;
    }

    public void setWhdsc(String whdsc) {
        this.whdsc = whdsc;
    }

    public String getItnbrfname() {
        return itnbrfname;
    }

    public void setItnbrfname(String itnbrfname) {
        this.itnbrfname = itnbrfname;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getManname() {
        return manname;
    }

    public void setManname(String manname) {
        this.manname = manname;
    }

    public String getFinishdate() {
        return finishdate;
    }

    public void setFinishdate(String finishdate) {
        this.finishdate = finishdate;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getTransno() {
        return transno;
    }

    public void setTransno(String transno) {
        this.transno = transno;
    }

    public Date getApplydate() {
        return applydate;
    }

    public void setApplydate(Date applydate) {
        this.applydate = applydate;
    }
    public String getEndDatetxt() {
        return endDatetxt;
    }

    public void setEndDatetxt(String endDatetxt) {
        this.endDatetxt = endDatetxt;
    }

    public String getStockDatetxt() {
        return stockDatetxt;
    }

    public void setStockDatetxt(String stockDatetxt) {
        this.stockDatetxt = stockDatetxt;
    }
    
}
