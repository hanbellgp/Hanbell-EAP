/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "HK_CG020")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKCG020.findAll", query = "SELECT h FROM HKCG020 h"),
    @NamedQuery(name = "HKCG020.findByPcno", query = "SELECT h FROM HKCG020 h WHERE h.pcno = :pcno"),
    @NamedQuery(name = "HKCG020.findByPSN", query = "SELECT h FROM HKCG020 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKCG020.findByItnbr", query = "SELECT h FROM HKCG020 h WHERE h.itnbr = :itnbr"),
    @NamedQuery(name = "HKCG020.findByFSN", query = "SELECT h FROM HKCG020 h WHERE h.formSerialNumber = :fsn")})
public class HKCG020 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "pcno")
    private String pcno;
    @Size(max = 255)
    @Column(name = "paycode")
    private String paycode;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "apmunmsr")
    private String apmunmsr;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "sndcode")
    private String sndcode;
    @Size(max = 255)
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "termcode")
    private String termcode;
    @Size(max = 255)
    @Column(name = "tickdays")
    private String tickdays;
    @Size(max = 255)
    @Column(name = "fromdate")
    private String fromdate;
    @Size(max = 255)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "addcode")
    private String addcode;
    @Size(max = 255)
    @Column(name = "priceChange")
    private String priceChange;
    @Size(max = 255)
    @Column(name = "ext05")
    private String ext05;
    @Size(max = 255)
    @Column(name = "pcdate")
    private String pcdate;
    @Size(max = 255)
    @Column(name = "ext04")
    private String ext04;
    @Size(max = 255)
    @Column(name = "taxrate")
    private String taxrate;
    @Size(max = 255)
    @Column(name = "ext03")
    private String ext03;
    @Size(max = 255)
    @Column(name = "ext02")
    private String ext02;
    @Size(max = 255)
    @Column(name = "ext01")
    private String ext01;
    @Size(max = 255)
    @Column(name = "oldpri")
    private String oldpri;
    @Size(max = 255)
    @Column(name = "tax")
    private String tax;
    @Size(max = 255)
    @Column(name = "vdrno")
    private String vdrno;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "unpris")
    private String unpris;
    @Size(max = 255)
    @Column(name = "deptNO")
    private String deptNO;
    @Size(max = 255)
    @Column(name = "buyer")
    private String buyer;
    @Size(max = 255)
    @Column(name = "ecode")
    private String ecode;
    @Size(max = 255)
    @Column(name = "hdnpriceChange")
    private String hdnpriceChange;
    @Size(max = 255)
    @Column(name = "prono")
    private String prono;
    @Size(max = 255)
    @Column(name = "enddate")
    private String enddate;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "coin")
    private String coin;
    @Size(max = 255)
    @Column(name = "ratio")
    private String ratio;
    @Size(max = 255)
    @Column(name = "spdsc")
    private String spdsc;

    public HKCG020() {
    }

    public HKCG020(String oid) {
        this.oid = oid;
    }

    public String getPcno() {
        return pcno;
    }

    public void setPcno(String pcno) {
        this.pcno = pcno;
    }

    public String getPaycode() {
        return paycode;
    }

    public void setPaycode(String paycode) {
        this.paycode = paycode;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getApmunmsr() {
        return apmunmsr;
    }

    public void setApmunmsr(String apmunmsr) {
        this.apmunmsr = apmunmsr;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getSndcode() {
        return sndcode;
    }

    public void setSndcode(String sndcode) {
        this.sndcode = sndcode;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getTermcode() {
        return termcode;
    }

    public void setTermcode(String termcode) {
        this.termcode = termcode;
    }

    public String getTickdays() {
        return tickdays;
    }

    public void setTickdays(String tickdays) {
        this.tickdays = tickdays;
    }

    public String getFromdate() {
        return fromdate;
    }

    public void setFromdate(String fromdate) {
        this.fromdate = fromdate;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getAddcode() {
        return addcode;
    }

    public void setAddcode(String addcode) {
        this.addcode = addcode;
    }

    public String getPriceChange() {
        return priceChange;
    }

    public void setPriceChange(String priceChange) {
        this.priceChange = priceChange;
    }

    public String getExt05() {
        return ext05;
    }

    public void setExt05(String ext05) {
        this.ext05 = ext05;
    }

    public String getPcdate() {
        return pcdate;
    }

    public void setPcdate(String pcdate) {
        this.pcdate = pcdate;
    }

    public String getExt04() {
        return ext04;
    }

    public void setExt04(String ext04) {
        this.ext04 = ext04;
    }

    public String getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(String taxrate) {
        this.taxrate = taxrate;
    }

    public String getExt03() {
        return ext03;
    }

    public void setExt03(String ext03) {
        this.ext03 = ext03;
    }

    public String getExt02() {
        return ext02;
    }

    public void setExt02(String ext02) {
        this.ext02 = ext02;
    }

    public String getExt01() {
        return ext01;
    }

    public void setExt01(String ext01) {
        this.ext01 = ext01;
    }

    public String getOldpri() {
        return oldpri;
    }

    public void setOldpri(String oldpri) {
        this.oldpri = oldpri;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getVdrno() {
        return vdrno;
    }

    public void setVdrno(String vdrno) {
        this.vdrno = vdrno;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getUnpris() {
        return unpris;
    }

    public void setUnpris(String unpris) {
        this.unpris = unpris;
    }

    public String getDeptNO() {
        return deptNO;
    }

    public void setDeptNO(String deptNO) {
        this.deptNO = deptNO;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getEcode() {
        return ecode;
    }

    public void setEcode(String ecode) {
        this.ecode = ecode;
    }

    public String getHdnpriceChange() {
        return hdnpriceChange;
    }

    public void setHdnpriceChange(String hdnpriceChange) {
        this.hdnpriceChange = hdnpriceChange;
    }

    public String getProno() {
        return prono;
    }

    public void setProno(String prono) {
        this.prono = prono;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    public String getSpdsc() {
        return spdsc;
    }

    public void setSpdsc(String spdsc) {
        this.spdsc = spdsc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oid != null ? oid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HKCG020)) {
            return false;
        }
        HKCG020 other = (HKCG020) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKCG020[ oid=" + oid + " ]";
    }
    
}
