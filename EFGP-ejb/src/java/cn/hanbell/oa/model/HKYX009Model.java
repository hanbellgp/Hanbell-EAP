/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.model;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@XmlRootElement
public class HKYX009Model implements Serializable {

    private String facno;
    private String quono;
    private Date quodate;
    private Date cfmdate;
    private String isspecial;
    private String quotype;
    private String pricingtype;
    private String pricingtypedsc;
    private String coin;
    private Double ratio;
    private String levelp;
    private String cusno;
    private String cusna;
    private String mancode;
    private String mancodesc;
    private String depno;
    private String cfmuser;
    private String apprresno;
    private String paycodedsc;
    private String pricgroup;
    private String oilspecial;
    private Double totamts;

    public HKYX009Model() {

    }

    @Override
    public int hashCode() {
        int hash = 0;
        return hash;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.SHBERPAPM811Model";
    }

    public Date getCfmdate() {
        return cfmdate;
    }

    public void setCfmdate(Date cfmdate) {
        this.cfmdate = cfmdate;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getIsspecial() {
        return isspecial;
    }

    public void setIsspecial(String isspecial) {
        this.isspecial = isspecial;
    }

    public String getLevelp() {
        return levelp;
    }

    public void setLevelp(String levelp) {
        this.levelp = levelp;
    }

    public String getCusno() {
        return cusno;
    }

    public void setCusno(String cusno) {
        this.cusno = cusno;
    }

    public String getQuono() {
        return quono;
    }

    public void setQuono(String quono) {
        this.quono = quono;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getQuotype() {
        return quotype;
    }

    public void setQuotype(String quotype) {
        this.quotype = quotype;
    }

    public String getCusna() {
        return cusna;
    }

    public void setCusna(String cusna) {
        this.cusna = cusna;
    }

    public String getApprresno() {
        return apprresno;
    }

    public void setApprresno(String apprresno) {
        this.apprresno = apprresno;
    }

    public String getDepno() {
        return depno;
    }

    public void setDepno(String depno) {
        this.depno = depno;
    }

    public Double getRatio() {
        return ratio;
    }

    public void setRatio(Double ratio) {
        this.ratio = ratio;
    }

    public String getCfmuser() {
        return cfmuser;
    }

    public void setCfmuser(String cfmuser) {
        this.cfmuser = cfmuser;
    }

    public String getMancode() {
        return mancode;
    }

    public void setMancode(String mancode) {
        this.mancode = mancode;
    }

    public Date getQuodate() {
        return quodate;
    }

    public void setQuodate(Date quodate) {
        this.quodate = quodate;
    }

    public String getPricingtype() {
        return pricingtype;
    }

    public void setPricingtype(String pricingtype) {
        this.pricingtype = pricingtype;
    }

    public String getPricingtypedsc() {
        return pricingtypedsc;
    }

    public void setPricingtypedsc(String pricingtypedsc) {
        this.pricingtypedsc = pricingtypedsc;
    }

    public String getMancodesc() {
        return mancodesc;
    }

    public void setMancodesc(String mancodesc) {
        this.mancodesc = mancodesc;
    }

    public String getPaycodedsc() {
        return paycodedsc;
    }

    public void setPaycodedsc(String paycodedsc) {
        this.paycodedsc = paycodedsc;
    }

    public String getOilspecial() {
        return oilspecial;
    }

    public void setOilspecial(String oilspecial) {
        this.oilspecial = oilspecial;
    }

    public String getPricgroup() {
        return pricgroup;
    }

    public void setPricgroup(String pricgroup) {
        this.pricgroup = pricgroup;
    }

    public Double getTotamts() {
        return totamts;
    }

    public void setTotamts(Double totamts) {
        this.totamts = totamts;
    }

}
