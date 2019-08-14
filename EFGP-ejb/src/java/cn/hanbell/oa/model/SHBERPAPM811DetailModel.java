/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@XmlRootElement
public class SHBERPAPM811DetailModel implements Serializable {

    private String seq;
    private String trapyh;
    private String acpno;
    private String sponr;
    private String itnbr;
    private String itdsc;
    private String pric;
    private String payqty;
    private String coin;
    private String ratio;
    private String ogdkid;
    private String bilno;
    private String acpamtfs;
    private String ivopsfs;
    private String ivomsfs;
    private String preamtfs;
    private String temamtfs;
    private String losamtfs;
    private String comApamtfs;
    private String dmark;
    private String apdsc;

    public SHBERPAPM811DetailModel() {

    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getAcpno() {
        return acpno;
    }

    public void setAcpno(String acpno) {
        this.acpno = acpno;
    }

    public String getLosamtfs() {
        return losamtfs;
    }

    public void setLosamtfs(String losamtfs) {
        this.losamtfs = losamtfs;
    }

    public String getTemamtfs() {
        return temamtfs;
    }

    public void setTemamtfs(String temamtfs) {
        this.temamtfs = temamtfs;
    }

    public String getIvomsfs() {
        return ivomsfs;
    }

    public void setIvomsfs(String ivomsfs) {
        this.ivomsfs = ivomsfs;
    }

    public String getPric() {
        return pric;
    }

    public void setPric(String pric) {
        this.pric = pric;
    }

    public String getComApamtfs() {
        return comApamtfs;
    }

    public void setComApamtfs(String comApamtfs) {
        this.comApamtfs = comApamtfs;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getOgdkid() {
        return ogdkid;
    }

    public void setOgdkid(String ogdkid) {
        this.ogdkid = ogdkid;
    }

    public String getSponr() {
        return sponr;
    }

    public void setSponr(String sponr) {
        this.sponr = sponr;
    }

    public String getPreamtfs() {
        return preamtfs;
    }

    public void setPreamtfs(String preamtfs) {
        this.preamtfs = preamtfs;
    }

    public String getIvopsfs() {
        return ivopsfs;
    }

    public void setIvopsfs(String ivopsfs) {
        this.ivopsfs = ivopsfs;
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

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getBilno() {
        return bilno;
    }

    public void setBilno(String bilno) {
        this.bilno = bilno;
    }

    public String getTrapyh() {
        return trapyh;
    }

    public void setTrapyh(String trapyh) {
        this.trapyh = trapyh;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getAcpamtfs() {
        return acpamtfs;
    }

    public void setAcpamtfs(String acpamtfs) {
        this.acpamtfs = acpamtfs;
    }

    public String getPayqty() {
        return payqty;
    }

    public void setPayqty(String payqty) {
        this.payqty = payqty;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SHBERPAPM811DetailModel)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.SHBERPAPM811DetailModel";
    }

    public String getApdsc() {
        return apdsc;
    }

    public void setApdsc(String apdsc) {
        this.apdsc = apdsc;
    }

}
