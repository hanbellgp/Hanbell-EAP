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
@Table(name = "HK_PB054")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKPB054.findAll", query = "SELECT h FROM HKPB054 h"),
    @NamedQuery(name = "HKPB054.findByOID", query = "SELECT h FROM HKPB054 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKPB054.findByPSN", query = "SELECT h FROM HKPB054 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKPB054.findByFSN", query = "SELECT h FROM HKPB054 h WHERE h.formSerialNumber = :fsn")})
public class HKPB054 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "ZR003C")
    private String zr003c;
    @Size(max = 255)
    @Column(name = "btnMethod")
    private String btnMethod;
    @Size(max = 255)
    @Column(name = "remark")
    private String remark;
    @Size(max = 255)
    @Column(name = "BL002C")
    private String bl002c;
    @Size(max = 255)
    @Column(name = "ZR001")
    private String zr001;
    @Size(max = 255)
    @Column(name = "JE002C")
    private String je002c;
    @Size(max = 255)
    @Column(name = "ZR003")
    private String zr003;
    @Size(max = 255)
    @Column(name = "ZR002")
    private String zr002;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "ZR001C")
    private String zr001c;
    @Size(max = 255)
    @Column(name = "JEtotal")
    private String jEtotal;
    @Size(max = 255)
    @Column(name = "HiddenTextField17")
    private String hiddenTextField17;
    @Size(max = 255)
    @Column(name = "cusno")
    private String cusno;
    @Size(max = 255)
    @Column(name = "quantity")
    private String quantity;
    @Size(max = 255)
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "cusds")
    private String cusds;
    @Size(max = 255)
    @Column(name = "unmsr")
    private String unmsr;
    @Size(max = 255)
    @Column(name = "ZR002C")
    private String zr002c;
    @Size(max = 255)
    @Column(name = "mftNo")
    private String mftNo;
    @Size(max = 255)
    @Column(name = "BL003C")
    private String bl003c;
    @Size(max = 255)
    @Column(name = "JE001C")
    private String je001c;
    @Size(max = 255)
    @Column(name = "cusna")
    private String cusna;
    @Size(max = 255)
    @Column(name = "prona")
    private String prona;
    @Size(max = 255)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "kfno")
    private String kfno;
    @Size(max = 255)
    @Column(name = "cost")
    private String cost;
    @Size(max = 255)
    @Column(name = "JE003C")
    private String je003c;
    @Size(max = 255)
    @Column(name = "BL001C")
    private String bl001c;
    @Size(max = 255)
    @Column(name = "JEtotalB")
    private String jEtotalB;
    @Size(max = 255)
    @Column(name = "applyUser")
    private String applyUser;
    @Size(max = 255)
    @Column(name = "JE003")
    private String je003;
    @Size(max = 255)
    @Column(name = "applyDept")
    private String applyDept;
    @Size(max = 255)
    @Column(name = "JEtotalC")
    private String jEtotalC;
    @Size(max = 255)
    @Column(name = "abcclass")
    private String abcclass;
    @Size(max = 255)
    @Column(name = "JE001")
    private String je001;
    @Size(max = 255)
    @Column(name = "JE002")
    private String je002;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "CK004")
    private String ck004;
    @Size(max = 255)
    @Column(name = "CK001")
    private String ck001;
    @Size(max = 255)
    @Column(name = "CK002")
    private String ck002;
    @Size(max = 255)
    @Column(name = "CK003")
    private String ck003;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "XJtotal")
    private Double xJtotal;
    @Size(max = 255)
    @Column(name = "wareh")
    private String wareh;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "whdsc")
    private String whdsc;
    @Size(max = 255)
    @Column(name = "hdnmanage")
    private String hdnmanage;
    @Size(max = 20)
    @Column(name = "relformid")
    private String relformid;

    public HKPB054() {
    }

    public HKPB054(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getZr003c() {
        return zr003c;
    }

    public void setZr003c(String zr003c) {
        this.zr003c = zr003c;
    }

    public String getBtnMethod() {
        return btnMethod;
    }

    public void setBtnMethod(String btnMethod) {
        this.btnMethod = btnMethod;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBl002c() {
        return bl002c;
    }

    public void setBl002c(String bl002c) {
        this.bl002c = bl002c;
    }

    public String getZr001() {
        return zr001;
    }

    public void setZr001(String zr001) {
        this.zr001 = zr001;
    }

    public String getJe002c() {
        return je002c;
    }

    public void setJe002c(String je002c) {
        this.je002c = je002c;
    }

    public String getZr003() {
        return zr003;
    }

    public void setZr003(String zr003) {
        this.zr003 = zr003;
    }

    public String getZr002() {
        return zr002;
    }

    public void setZr002(String zr002) {
        this.zr002 = zr002;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getZr001c() {
        return zr001c;
    }

    public void setZr001c(String zr001c) {
        this.zr001c = zr001c;
    }

    public String getJEtotal() {
        return jEtotal;
    }

    public void setJEtotal(String jEtotal) {
        this.jEtotal = jEtotal;
    }

    public String getHiddenTextField17() {
        return hiddenTextField17;
    }

    public void setHiddenTextField17(String hiddenTextField17) {
        this.hiddenTextField17 = hiddenTextField17;
    }

    public String getCusno() {
        return cusno;
    }

    public void setCusno(String cusno) {
        this.cusno = cusno;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getCusds() {
        return cusds;
    }

    public void setCusds(String cusds) {
        this.cusds = cusds;
    }

    public String getUnmsr() {
        return unmsr;
    }

    public void setUnmsr(String unmsr) {
        this.unmsr = unmsr;
    }

    public String getZr002c() {
        return zr002c;
    }

    public void setZr002c(String zr002c) {
        this.zr002c = zr002c;
    }

    public String getMftNo() {
        return mftNo;
    }

    public void setMftNo(String mftNo) {
        this.mftNo = mftNo;
    }

    public String getBl003c() {
        return bl003c;
    }

    public void setBl003c(String bl003c) {
        this.bl003c = bl003c;
    }

    public String getJe001c() {
        return je001c;
    }

    public void setJe001c(String je001c) {
        this.je001c = je001c;
    }

    public String getCusna() {
        return cusna;
    }

    public void setCusna(String cusna) {
        this.cusna = cusna;
    }

    public String getProna() {
        return prona;
    }

    public void setProna(String prona) {
        this.prona = prona;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getKfno() {
        return kfno;
    }

    public void setKfno(String kfno) {
        this.kfno = kfno;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getJe003c() {
        return je003c;
    }

    public void setJe003c(String je003c) {
        this.je003c = je003c;
    }

    public String getBl001c() {
        return bl001c;
    }

    public void setBl001c(String bl001c) {
        this.bl001c = bl001c;
    }

    public String getJEtotalB() {
        return jEtotalB;
    }

    public void setJEtotalB(String jEtotalB) {
        this.jEtotalB = jEtotalB;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getJe003() {
        return je003;
    }

    public void setJe003(String je003) {
        this.je003 = je003;
    }

    public String getApplyDept() {
        return applyDept;
    }

    public void setApplyDept(String applyDept) {
        this.applyDept = applyDept;
    }

    public String getJEtotalC() {
        return jEtotalC;
    }

    public void setJEtotalC(String jEtotalC) {
        this.jEtotalC = jEtotalC;
    }

    public String getAbcclass() {
        return abcclass;
    }

    public void setAbcclass(String abcclass) {
        this.abcclass = abcclass;
    }

    public String getJe001() {
        return je001;
    }

    public void setJe001(String je001) {
        this.je001 = je001;
    }

    public String getJe002() {
        return je002;
    }

    public void setJe002(String je002) {
        this.je002 = je002;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getCk004() {
        return ck004;
    }

    public void setCk004(String ck004) {
        this.ck004 = ck004;
    }

    public String getCk001() {
        return ck001;
    }

    public void setCk001(String ck001) {
        this.ck001 = ck001;
    }

    public String getCk002() {
        return ck002;
    }

    public void setCk002(String ck002) {
        this.ck002 = ck002;
    }

    public String getCk003() {
        return ck003;
    }

    public void setCk003(String ck003) {
        this.ck003 = ck003;
    }

    public Double getXJtotal() {
        return xJtotal;
    }

    public void setXJtotal(Double xJtotal) {
        this.xJtotal = xJtotal;
    }

    public String getWareh() {
        return wareh;
    }

    public void setWareh(String wareh) {
        this.wareh = wareh;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getWhdsc() {
        return whdsc;
    }

    public void setWhdsc(String whdsc) {
        this.whdsc = whdsc;
    }

    public String getHdnmanage() {
        return hdnmanage;
    }

    public void setHdnmanage(String hdnmanage) {
        this.hdnmanage = hdnmanage;
    }

    public String getRelformid() {
        return relformid;
    }

    public void setRelformid(String relformid) {
        this.relformid = relformid;
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
        if (!(object instanceof HKPB054)) {
            return false;
        }
        HKPB054 other = (HKPB054) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKPB054[ oid=" + oid + " ]";
    }
    
}
