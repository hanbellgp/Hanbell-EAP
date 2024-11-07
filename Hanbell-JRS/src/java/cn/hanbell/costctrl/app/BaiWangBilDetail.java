/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.costctrl.app;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C2082
 */
@XmlRootElement
public class BaiWangBilDetail {

    private String spmc;
    private String ggxh;
    private String spdw;
    private double spsl;
    private double spdj;
    private double spje;
    private double sl;
    private double spse;

    public String getSpmc() {
        return spmc;
    }

    public void setSpmc(String spmc) {
        this.spmc = spmc;
    }

    public String getGgxh() {
        return ggxh;
    }

    public void setGgxh(String ggxh) {
        this.ggxh = ggxh;
    }

    public String getSpdw() {
        return spdw;
    }

    public void setSpdw(String spdw) {
        this.spdw = spdw;
    }

    public double getSpsl() {
        return spsl;
    }

    public void setSpsl(double spsl) {
        this.spsl = spsl;
    }

    public double getSpdj() {
        return spdj;
    }

    public void setSpdj(double spdj) {
        this.spdj = spdj;
    }

    public double getSpje() {
        return spje;
    }

    public void setSpje(double spje) {
        this.spje = spje;
    }

    public double getSl() {
        return sl;
    }

    public void setSl(double sl) {
        this.sl = sl;
    }

    public double getSpse() {
        return spse;
    }

    public void setSpse(double spse) {
        this.spse = spse;
    }

    @Override
    public String toString() {
        return "BaiWangBilDetail{" + "spmc=" + spmc + ", ggxh=" + ggxh + ", spdw=" + spdw + ", spsl=" + spsl + ", spdj=" + spdj + ", spje=" + spje + ", sl=" + sl + ", spse=" + spse + '}';
    }
    
}
