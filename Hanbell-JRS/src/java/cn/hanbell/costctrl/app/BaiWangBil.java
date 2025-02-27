/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.costctrl.app;

import java.math.BigDecimal;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C2082
 */
@XmlRootElement
public class BaiWangBil {

    private String fplxdm;
    private String fpdm;
    private String fphm;
    private String kprq;
    private String yjm;
    private String kpddm;
    private String ghdwmc;
    private String ghdwdm;
    private String ghdwdzdh;
    private String ghdwyhzh;
    private String skm;
    private String xhdwmc;
    private String xhdwdm;
    private String xhdwdzdh;
    private String xhdwyhzh;
    private String bz;
    private double hjje;
    private double se;
    private double jshj;
    private String bigjshj;
    private String skr;
    private String fhr;
    private String kpr;
    private List<BaiWangBilDetail> details;

    public String getFplxdm() {
        return fplxdm;
    }

    public void setFplxdm(String fplxdm) {
        this.fplxdm = fplxdm;
    }
    public String getFpdm() {
        return fpdm;
    }

    public void setFpdm(String fpdm) {
        this.fpdm = fpdm;
    }

    public String getFphm() {
        return fphm;
    }

    public void setFphm(String fphm) {
        this.fphm = fphm;
    }

    public String getKprq() {
        return kprq;
    }

    public void setKprq(String kprq) {
        this.kprq = kprq;
    }

    public String getYjm() {
        return yjm;
    }

    public void setYjm(String yjm) {
        this.yjm = yjm;
    }

    public String getKpddm() {
        return kpddm;
    }

    public void setKpddm(String kpddm) {
        this.kpddm = kpddm;
    }

    public String getGhdwmc() {
        return ghdwmc;
    }

    public void setGhdwmc(String ghdwmc) {
        this.ghdwmc = ghdwmc;
    }

    public String getGhdwdm() {
        return ghdwdm;
    }

    public void setGhdwdm(String ghdwdm) {
        this.ghdwdm = ghdwdm;
    }

    public String getGhdwdzdh() {
        return ghdwdzdh;
    }

    public void setGhdwdzdh(String ghdwdzdh) {
        this.ghdwdzdh = ghdwdzdh;
    }

    public String getGhdwyhzh() {
        return ghdwyhzh;
    }

    public void setGhdwyhzh(String ghdwyhzh) {
        this.ghdwyhzh = ghdwyhzh;
    }

    public String getSkm() {
        return skm;
    }

    public void setSkm(String skm) {
        this.skm = skm;
    }

    public String getXhdwmc() {
        return xhdwmc;
    }

    public void setXhdwmc(String xhdwmc) {
        this.xhdwmc = xhdwmc;
    }

    public String getXhdwdm() {
        return xhdwdm;
    }

    public void setXhdwdm(String xhdwdm) {
        this.xhdwdm = xhdwdm;
    }

    public String getXhdwdzdh() {
        return xhdwdzdh;
    }

    public void setXhdwdzdh(String xhdwdzdh) {
        this.xhdwdzdh = xhdwdzdh;
    }

    public String getXhdwyhzh() {
        return xhdwyhzh;
    }

    public void setXhdwyhzh(String xhdwyhzh) {
        this.xhdwyhzh = xhdwyhzh;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public double getHjje() {
        return hjje;
    }

    public void setHjje(double hjje) {
        this.hjje = hjje;
    }

    public double getSe() {
        return se;
    }

    public void setSe(double se) {
        this.se = se;
    }

    public double getJshj() {
        return jshj;
    }

    public void setJshj(double jshj) {
        this.jshj = jshj;
    }

   
    public String getBigjshj() {
        return bigjshj;
    }

    public void setBigjshj(String bigjshj) {
        this.bigjshj = bigjshj;
    }

    public String getSkr() {
        return skr;
    }

    public void setSkr(String skr) {
        this.skr = skr;
    }

    public String getFhr() {
        return fhr;
    }

    public void setFhr(String fhr) {
        this.fhr = fhr;
    }

    public String getKpr() {
        return kpr;
    }

    public void setKpr(String kpr) {
        this.kpr = kpr;
    }

    public List<BaiWangBilDetail> getDetails() {
        return details;
    }

    public void setDetails(List<BaiWangBilDetail> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "BaiWangBil{" + "fpdm=" + fpdm + ", fphm=" + fphm + ", kprq=" + kprq + ", yjm=" + yjm + ", kpddm=" + kpddm + ", ghdwmc=" + ghdwmc + ", ghdwdm=" + ghdwdm + ", ghdwdzdh=" + ghdwdzdh + ", ghdwyhzh=" + ghdwyhzh + ", skm=" + skm + ", xhdwmc=" + xhdwmc + ", xhdwdm=" + xhdwdm + ", xhdwdzdh=" + xhdwdzdh + ", xhdwyhzh=" + xhdwyhzh + ", bz=" + bz + ", hjje=" + hjje + ", se=" + se + ", jshj=" + jshj + ", bigjshj=" + bigjshj + ", skr=" + skr + ", fhr=" + fhr + ", kpr=" + kpr + ", details=" + details + '}';
    }


    

}
