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
@Table(name = "HK_FW006_INV310")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKFW006Inv310.findAll", query = "SELECT h FROM HKFW006Inv310 h"),
    @NamedQuery(name = "HKFW006Inv310.findByTrdate", query = "SELECT h FROM HKFW006Inv310 h WHERE h.trdate = :trdate"),
    @NamedQuery(name = "HKFW006Inv310.findByPzno", query = "SELECT h FROM HKFW006Inv310 h WHERE h.pzno = :pzno"),
    @NamedQuery(name = "HKFW006Inv310.findByOid", query = "SELECT h FROM HKFW006Inv310 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKFW006Inv310.findByWareh", query = "SELECT h FROM HKFW006Inv310 h WHERE h.wareh = :wareh"),
    @NamedQuery(name = "HKFW006Inv310.findByResno", query = "SELECT h FROM HKFW006Inv310 h WHERE h.resno = :resno"),
    @NamedQuery(name = "HKFW006Inv310.findByVarnr", query = "SELECT h FROM HKFW006Inv310 h WHERE h.varnr = :varnr"),
    @NamedQuery(name = "HKFW006Inv310.findByItdsc", query = "SELECT h FROM HKFW006Inv310 h WHERE h.itdsc = :itdsc"),
    @NamedQuery(name = "HKFW006Inv310.findByTrtype", query = "SELECT h FROM HKFW006Inv310 h WHERE h.trtype = :trtype"),
    @NamedQuery(name = "HKFW006Inv310.findByKfno", query = "SELECT h FROM HKFW006Inv310 h WHERE h.kfno = :kfno"),
    @NamedQuery(name = "HKFW006Inv310.findByFacno", query = "SELECT h FROM HKFW006Inv310 h WHERE h.facno = :facno"),
    @NamedQuery(name = "HKFW006Inv310.findByUnit", query = "SELECT h FROM HKFW006Inv310 h WHERE h.unit = :unit"),
    @NamedQuery(name = "HKFW006Inv310.findByDepno", query = "SELECT h FROM HKFW006Inv310 h WHERE h.depno = :depno"),
    @NamedQuery(name = "HKFW006Inv310.findByNum", query = "SELECT h FROM HKFW006Inv310 h WHERE h.num = :num"),
    @NamedQuery(name = "HKFW006Inv310.findByHmark2", query = "SELECT h FROM HKFW006Inv310 h WHERE h.hmark2 = :hmark2"),
    @NamedQuery(name = "HKFW006Inv310.findByFwno", query = "SELECT h FROM HKFW006Inv310 h WHERE h.fwno = :fwno"),
    @NamedQuery(name = "HKFW006Inv310.findByHmark1", query = "SELECT h FROM HKFW006Inv310 h WHERE h.hmark1 = :hmark1"),
    @NamedQuery(name = "HKFW006Inv310.findByWhdsc", query = "SELECT h FROM HKFW006Inv310 h WHERE h.whdsc = :whdsc"),
    @NamedQuery(name = "HKFW006Inv310.findByItnbr", query = "SELECT h FROM HKFW006Inv310 h WHERE h.itnbr = :itnbr"),
    @NamedQuery(name = "HKFW006Inv310.findByPSN", query = "SELECT h FROM HKFW006Inv310 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKFW006Inv310.findByFSN", query = "SELECT h FROM HKFW006Inv310 h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKFW006Inv310.findByDepname", query = "SELECT h FROM HKFW006Inv310 h WHERE h.depname = :depname")})
public class HKFW006Inv310 implements Serializable {

    @Size(max = 255)
    @Column(name = "pzinv310")
    private String pzinv310;

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "trdate")
    private String trdate;
    @Size(max = 255)
    @Column(name = "pzno")
    private String pzno;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "wareh")
    private String wareh;
    @Size(max = 255)
    @Column(name = "resno")
    private String resno;
    @Size(max = 255)
    @Column(name = "varnr")
    private String varnr;
    @Size(max = 255)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "trtype")
    private String trtype;
    @Size(max = 255)
    @Column(name = "kfno")
    private String kfno;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "unit")
    private String unit;
    @Size(max = 255)
    @Column(name = "depno")
    private String depno;
    @Size(max = 255)
    @Column(name = "num")
    private String num;
    @Size(max = 255)
    @Column(name = "hmark2")
    private String hmark2;
    @Size(max = 255)
    @Column(name = "fwno")
    private String fwno;
    @Size(max = 255)
    @Column(name = "hmark1")
    private String hmark1;
    @Size(max = 255)
    @Column(name = "whdsc")
    private String whdsc;
    @Size(max = 255)
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "depname")
    private String depname;
    @Size(max = 255)
    @Column(name = "pzuser")
    private String pzuser;
    
    public HKFW006Inv310() {
    }

    public HKFW006Inv310(String oid) {
        this.oid = oid;
    }

    public String getTrdate() {
        return trdate;
    }

    public void setTrdate(String trdate) {
        this.trdate = trdate;
    }

    public String getPzno() {
        return pzno;
    }

    public void setPzno(String pzno) {
        this.pzno = pzno;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getWareh() {
        return wareh;
    }

    public void setWareh(String wareh) {
        this.wareh = wareh;
    }

    public String getResno() {
        return resno;
    }

    public void setResno(String resno) {
        this.resno = resno;
    }

    public String getVarnr() {
        return varnr;
    }

    public void setVarnr(String varnr) {
        this.varnr = varnr;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getTrtype() {
        return trtype;
    }

    public void setTrtype(String trtype) {
        this.trtype = trtype;
    }

    public String getKfno() {
        return kfno;
    }

    public void setKfno(String kfno) {
        this.kfno = kfno;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDepno() {
        return depno;
    }

    public void setDepno(String depno) {
        this.depno = depno;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getHmark2() {
        return hmark2;
    }

    public void setHmark2(String hmark2) {
        this.hmark2 = hmark2;
    }

    public String getFwno() {
        return fwno;
    }

    public void setFwno(String fwno) {
        this.fwno = fwno;
    }

    public String getHmark1() {
        return hmark1;
    }

    public void setHmark1(String hmark1) {
        this.hmark1 = hmark1;
    }

    public String getWhdsc() {
        return whdsc;
    }

    public void setWhdsc(String whdsc) {
        this.whdsc = whdsc;
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

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getDepname() {
        return depname;
    }

    public void setDepname(String depname) {
        this.depname = depname;
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
        if (!(object instanceof HKFW006Inv310)) {
            return false;
        }
        HKFW006Inv310 other = (HKFW006Inv310) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKFW006Inv310[ oid=" + oid + " ]";
    }

    public String getPzinv310() {
        return pzinv310;
    }

    public void setPzinv310(String pzinv310) {
        this.pzinv310 = pzinv310;
    }

    public String getPzuser() {
        return pzuser;
    }

    public void setPzuser(String pzuser) {
        this.pzuser = pzuser;
    }
    
}
