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
@Table(name = "HK_FW006_CDRN30")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKFW006Cdrn30.findAll", query = "SELECT h FROM HKFW006Cdrn30 h"),
    @NamedQuery(name = "HKFW006Cdrn30.findByOID", query = "SELECT h FROM HKFW006Cdrn30 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKFW006Cdrn30.findByFixnr", query = "SELECT h FROM HKFW006Cdrn30 h WHERE h.fixnr = :fixnr"),
    @NamedQuery(name = "HKFW006Cdrn30.findByWareh", query = "SELECT h FROM HKFW006Cdrn30 h WHERE h.wareh = :wareh"),
    @NamedQuery(name = "HKFW006Cdrn30.findByBrdate", query = "SELECT h FROM HKFW006Cdrn30 h WHERE h.brdate = :brdate"),
    @NamedQuery(name = "HKFW006Cdrn30.findByCdrobty", query = "SELECT h FROM HKFW006Cdrn30 h WHERE h.cdrobty = :cdrobty"),
    @NamedQuery(name = "HKFW006Cdrn30.findByVarnr", query = "SELECT h FROM HKFW006Cdrn30 h WHERE h.varnr = :varnr"),
    @NamedQuery(name = "HKFW006Cdrn30.findByRetqy1", query = "SELECT h FROM HKFW006Cdrn30 h WHERE h.retqy1 = :retqy1"),
    @NamedQuery(name = "HKFW006Cdrn30.findByFacno", query = "SELECT h FROM HKFW006Cdrn30 h WHERE h.facno = :facno"),
    @NamedQuery(name = "HKFW006Cdrn30.findBySpdsc", query = "SELECT h FROM HKFW006Cdrn30 h WHERE h.spdsc = :spdsc"),
    @NamedQuery(name = "HKFW006Cdrn30.findByIndate", query = "SELECT h FROM HKFW006Cdrn30 h WHERE h.indate = :indate"),
    @NamedQuery(name = "HKFW006Cdrn30.findByUsername", query = "SELECT h FROM HKFW006Cdrn30 h WHERE h.username = :username"),
    @NamedQuery(name = "HKFW006Cdrn30.findByHdDetail", query = "SELECT h FROM HKFW006Cdrn30 h WHERE h.hdDetail = :hdDetail"),
    @NamedQuery(name = "HKFW006Cdrn30.findByDmark2", query = "SELECT h FROM HKFW006Cdrn30 h WHERE h.dmark2 = :dmark2"),
    @NamedQuery(name = "HKFW006Cdrn30.findByBrowno", query = "SELECT h FROM HKFW006Cdrn30 h WHERE h.browno = :browno"),
    @NamedQuery(name = "HKFW006Cdrn30.findByCusno", query = "SELECT h FROM HKFW006Cdrn30 h WHERE h.cusno = :cusno"),
    @NamedQuery(name = "HKFW006Cdrn30.findByItnbr", query = "SELECT h FROM HKFW006Cdrn30 h WHERE h.itnbr = :itnbr"),
    @NamedQuery(name = "HKFW006Cdrn30.findByPSN", query = "SELECT h FROM HKFW006Cdrn30 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKFW006Cdrn30.findByDepname", query = "SELECT h FROM HKFW006Cdrn30 h WHERE h.depname = :depname"),
    @NamedQuery(name = "HKFW006Cdrn30.findByPzno", query = "SELECT h FROM HKFW006Cdrn30 h WHERE h.pzno = :pzno"),
    @NamedQuery(name = "HKFW006Cdrn30.findByHmark01", query = "SELECT h FROM HKFW006Cdrn30 h WHERE h.hmark01 = :hmark01"),
    @NamedQuery(name = "HKFW006Cdrn30.findByObjtype", query = "SELECT h FROM HKFW006Cdrn30 h WHERE h.objtype = :objtype"),
    @NamedQuery(name = "HKFW006Cdrn30.findByHmark02", query = "SELECT h FROM HKFW006Cdrn30 h WHERE h.hmark02 = :hmark02"),
    @NamedQuery(name = "HKFW006Cdrn30.findByProno", query = "SELECT h FROM HKFW006Cdrn30 h WHERE h.prono = :prono"),
    @NamedQuery(name = "HKFW006Cdrn30.findByPrebkdate", query = "SELECT h FROM HKFW006Cdrn30 h WHERE h.prebkdate = :prebkdate"),
    @NamedQuery(name = "HKFW006Cdrn30.findByUnmsr1", query = "SELECT h FROM HKFW006Cdrn30 h WHERE h.unmsr1 = :unmsr1"),
    @NamedQuery(name = "HKFW006Cdrn30.findByItdsc", query = "SELECT h FROM HKFW006Cdrn30 h WHERE h.itdsc = :itdsc"),
    @NamedQuery(name = "HKFW006Cdrn30.findByUserno", query = "SELECT h FROM HKFW006Cdrn30 h WHERE h.userno = :userno"),
    @NamedQuery(name = "HKFW006Cdrn30.findByBrpqy1", query = "SELECT h FROM HKFW006Cdrn30 h WHERE h.brpqy1 = :brpqy1"),
    @NamedQuery(name = "HKFW006Cdrn30.findByDepno", query = "SELECT h FROM HKFW006Cdrn30 h WHERE h.depno = :depno"),
    @NamedQuery(name = "HKFW006Cdrn30.findByCusname", query = "SELECT h FROM HKFW006Cdrn30 h WHERE h.cusname = :cusname"),
    @NamedQuery(name = "HKFW006Cdrn30.findByWhdsc", query = "SELECT h FROM HKFW006Cdrn30 h WHERE h.whdsc = :whdsc"),
    @NamedQuery(name = "HKFW006Cdrn30.findByTrseq", query = "SELECT h FROM HKFW006Cdrn30 h WHERE h.trseq = :trseq"),
    @NamedQuery(name = "HKFW006Cdrn30.findByBrqy1", query = "SELECT h FROM HKFW006Cdrn30 h WHERE h.brqy1 = :brqy1"),
    @NamedQuery(name = "HKFW006Cdrn30.findByFSN", query = "SELECT h FROM HKFW006Cdrn30 h WHERE h.formSerialNumber = :fsn")})
public class HKFW006Cdrn30 implements Serializable {

    @Size(max = 255)
    @Column(name = "pzcdrn30")
    private String pzcdrn30;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "fixnr")
    private String fixnr;
    @Size(max = 255)
    @Column(name = "wareh")
    private String wareh;
    @Size(max = 255)
    @Column(name = "brdate")
    private String brdate;
    @Size(max = 255)
    @Column(name = "cdrobty")
    private String cdrobty;
    @Size(max = 255)
    @Column(name = "varnr")
    private String varnr;
    @Size(max = 255)
    @Column(name = "retqy1")
    private String retqy1;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "spdsc")
    private String spdsc;
    @Size(max = 255)
    @Column(name = "indate")
    private String indate;
    @Size(max = 255)
    @Column(name = "username")
    private String username;
    @Size(max = 255)
    @Column(name = "hdDetail")
    private String hdDetail;
    @Size(max = 255)
    @Column(name = "dmark1")
    private String dmark1;
    @Size(max = 255)
    @Column(name = "dmark2")
    private String dmark2;
    @Size(max = 255)
    @Column(name = "browno")
    private String browno;
    @Size(max = 255)
    @Column(name = "cusno")
    private String cusno;
    @Size(max = 255)
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "depname")
    private String depname;
    @Size(max = 255)
    @Column(name = "pzno")
    private String pzno;
    @Size(max = 255)
    @Column(name = "hmark01")
    private String hmark01;
    @Size(max = 255)
    @Column(name = "objtype")
    private String objtype;
    @Size(max = 255)
    @Column(name = "hmark02")
    private String hmark02;
    @Size(max = 255)
    @Column(name = "prono")
    private String prono;
    @Size(max = 255)
    @Column(name = "prebkdate")
    private String prebkdate;
    @Size(max = 255)
    @Column(name = "unmsr1")
    private String unmsr1;
    @Size(max = 255)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "userno")
    private String userno;
    @Size(max = 255)
    @Column(name = "brpqy1")
    private String brpqy1;
    @Size(max = 255)
    @Column(name = "depno")
    private String depno;
    @Size(max = 255)
    @Column(name = "cusname")
    private String cusname;
    @Size(max = 255)
    @Column(name = "whdsc")
    private String whdsc;
    @Size(max = 255)
    @Column(name = "trseq")
    private String trseq;
    @Size(max = 255)
    @Column(name = "brqy1")
    private String brqy1;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;

    public HKFW006Cdrn30() {
    }

    public HKFW006Cdrn30(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getFixnr() {
        return fixnr;
    }

    public void setFixnr(String fixnr) {
        this.fixnr = fixnr;
    }

    public String getWareh() {
        return wareh;
    }

    public void setWareh(String wareh) {
        this.wareh = wareh;
    }

    public String getBrdate() {
        return brdate;
    }

    public void setBrdate(String brdate) {
        this.brdate = brdate;
    }

    public String getCdrobty() {
        return cdrobty;
    }

    public void setCdrobty(String cdrobty) {
        this.cdrobty = cdrobty;
    }

    public String getVarnr() {
        return varnr;
    }

    public void setVarnr(String varnr) {
        this.varnr = varnr;
    }

    public String getRetqy1() {
        return retqy1;
    }

    public void setRetqy1(String retqy1) {
        this.retqy1 = retqy1;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getSpdsc() {
        return spdsc;
    }

    public void setSpdsc(String spdsc) {
        this.spdsc = spdsc;
    }

    public String getIndate() {
        return indate;
    }

    public void setIndate(String indate) {
        this.indate = indate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHdDetail() {
        return hdDetail;
    }

    public void setHdDetail(String hdDetail) {
        this.hdDetail = hdDetail;
    }

    public String getDmark2() {
        return dmark2;
    }

    public void setDmark2(String dmark2) {
        this.dmark2 = dmark2;
    }

    public String getBrowno() {
        return browno;
    }

    public void setBrowno(String browno) {
        this.browno = browno;
    }

    public String getCusno() {
        return cusno;
    }

    public void setCusno(String cusno) {
        this.cusno = cusno;
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

    public String getDepname() {
        return depname;
    }

    public void setDepname(String depname) {
        this.depname = depname;
    }

    public String getPzno() {
        return pzno;
    }

    public void setPzno(String pzno) {
        this.pzno = pzno;
    }

    public String getHmark01() {
        return hmark01;
    }

    public void setHmark01(String hmark01) {
        this.hmark01 = hmark01;
    }

    public String getObjtype() {
        return objtype;
    }

    public void setObjtype(String objtype) {
        this.objtype = objtype;
    }

    public String getHmark02() {
        return hmark02;
    }

    public void setHmark02(String hmark02) {
        this.hmark02 = hmark02;
    }

    public String getProno() {
        return prono;
    }

    public void setProno(String prono) {
        this.prono = prono;
    }

    public String getPrebkdate() {
        return prebkdate;
    }

    public void setPrebkdate(String prebkdate) {
        this.prebkdate = prebkdate;
    }

    public String getUnmsr1() {
        return unmsr1;
    }

    public void setUnmsr1(String unmsr1) {
        this.unmsr1 = unmsr1;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
    }

    public String getBrpqy1() {
        return brpqy1;
    }

    public void setBrpqy1(String brpqy1) {
        this.brpqy1 = brpqy1;
    }

    public String getDepno() {
        return depno;
    }

    public void setDepno(String depno) {
        this.depno = depno;
    }

    public String getCusname() {
        return cusname;
    }

    public void setCusname(String cusname) {
        this.cusname = cusname;
    }

    public String getWhdsc() {
        return whdsc;
    }

    public void setWhdsc(String whdsc) {
        this.whdsc = whdsc;
    }

    public String getTrseq() {
        return trseq;
    }

    public void setTrseq(String trseq) {
        this.trseq = trseq;
    }

    public String getBrqy1() {
        return brqy1;
    }

    public void setBrqy1(String brqy1) {
        this.brqy1 = brqy1;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
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
        if (!(object instanceof HKFW006Cdrn30)) {
            return false;
        }
        HKFW006Cdrn30 other = (HKFW006Cdrn30) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKFW006Cdrn30[ oid=" + oid + " ]";
    }

    public String getPzcdrn30() {
        return pzcdrn30;
    }

    public void setPzcdrn30(String pzcdrn30) {
        this.pzcdrn30 = pzcdrn30;
    }

    public String getDmark1() {
        return dmark1;
    }

    public void setDmark1(String dmark1) {
        this.dmark1 = dmark1;
    }
    
}
