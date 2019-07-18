/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C0160
 */
@Entity
@Table(name = "HK_YX006")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKYX006.findAll", query = "SELECT c FROM HKYX006 c"),
    @NamedQuery(name = "HKYX006.findByOID", query = "SELECT c FROM HKYX006 c WHERE c.oid = :oid"),
    @NamedQuery(name = "HKYX006.findByPSN", query = "SELECT c FROM HKYX006 c WHERE c.processSerialNumber = :psn"),
    @NamedQuery(name = "HKYX006.findByFSN", query = "SELECT c FROM HKYX006 c WHERE c.formSerialNumber = :fsn")})
public class HKYX006 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "mapbilyn")
    private String mapbilyn;
    @Size(max = 255)
    @Column(name = "GG078")
    private String gg078;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "GG027")
    private String gg027;
    @Size(max = 255)
    @Column(name = "GG024")
    private String gg024;
    @Size(max = 255)
    @Column(name = "cusbakna")
    private String cusbakna;
    @Column(name = "handays1")
    private Integer handays1;
    @Column(name = "latdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date latdate;
    @Size(max = 255)
    @Column(name = "GG030")
    private String gg030;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "GG031")
    private Double gg031;
    @Size(max = 255)
    @Column(name = "sndcode")
    private String sndcode;
    @Size(max = 255)
    @Column(name = "mchdate")
    private String mchdate;
    @Size(max = 255)
    @Column(name = "salesman")
    private String salesman;
    @Size(max = 255)
    @Column(name = "decode")
    private String decode;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="电子邮件无效")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 255)
    @Column(name = "GG036")
    private String gg036;
    @Size(max = 255)
    @Column(name = "GG105")
    private String gg105;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "mark1")
    private String mark1;
    @Size(max = 255)
    @Column(name = "contactman")
    private String contactman;
    @Size(max = 255)
    @Column(name = "GG109")
    private String gg109;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "GG098")
    private String gg098;
    @Size(max = 255)
    @Column(name = "GG009")
    private String gg009;
    @Size(max = 255)
    @Column(name = "GG008")
    private String gg008;
    @Size(max = 255)
    @Column(name = "cusgroup")
    private String cusgroup;
    @Size(max = 255)
    @Column(name = "GG003")
    private String gg003;
    @Size(max = 255)
    @Column(name = "GG001")
    private String gg001;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "fj1")
    private String fj1;
    @Size(max = 255)
    @Column(name = "fj2")
    private String fj2;
    @Size(max = 255)
    @Column(name = "GG004")
    private String gg004;
    @Column(name = "yearamt")
    private Double yearamt;
    @Size(max = 255)
    @Column(name = "cussta")
    private String cussta;
    @Size(max = 255)
    @Column(name = "dmcode")
    private String dmcode;
    @Size(max = 255)
    @Column(name = "GG113")
    private String gg113;
    @Size(max = 255)
    @Column(name = "GG010")
    private String gg010;
    @Size(max = 255)
    @Column(name = "GG112")
    private String gg112;
    @Size(max = 255)
    @Column(name = "GG050")
    private String gg050;
    @Size(max = 255)
    @Column(name = "GG084")
    private String gg084;
    @Size(max = 255)
    @Column(name = "pz")
    private String pz;
    @Size(max = 255)
    @Column(name = "GG011")
    private String gg011;
    @Size(max = 255)
    @Column(name = "cusacctno")
    private String cusacctno;
    @Size(max = 255)
    @Column(name = "skfs1")
    private String skfs1;
    @Size(max = 255)
    @Column(name = "skfs2")
    private String skfs2;
    @Size(max = 255)
    @Column(name = "GG018")
    private String gg018;
    @Size(max = 255)
    @Column(name = "vdrno")
    private String vdrno;
    @Column(name = "GG017")
    @Temporal(TemporalType.TIMESTAMP)
    private Date gg017;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;

    public HKYX006() {
    }

    public HKYX006(String oid) {
        this.oid = oid;
    }

    public String getMapbilyn() {
        return mapbilyn;
    }

    public void setMapbilyn(String mapbilyn) {
        this.mapbilyn = mapbilyn;
    }

    public String getGg078() {
        return gg078;
    }

    public void setGg078(String gg078) {
        this.gg078 = gg078;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getGg027() {
        return gg027;
    }

    public void setGg027(String gg027) {
        this.gg027 = gg027;
    }

    public String getGg024() {
        return gg024;
    }

    public void setGg024(String gg024) {
        this.gg024 = gg024;
    }

    public String getCusbakna() {
        return cusbakna;
    }

    public void setCusbakna(String cusbakna) {
        this.cusbakna = cusbakna;
    }

    public Integer getHandays1() {
        return handays1;
    }

    public void setHandays1(Integer handays1) {
        this.handays1 = handays1;
    }

    public Date getLatdate() {
        return latdate;
    }

    public void setLatdate(Date latdate) {
        this.latdate = latdate;
    }

    public String getGg030() {
        return gg030;
    }

    public void setGg030(String gg030) {
        this.gg030 = gg030;
    }

    public Double getGg031() {
        return gg031;
    }

    public void setGg031(Double gg031) {
        this.gg031 = gg031;
    }

    public String getSndcode() {
        return sndcode;
    }

    public void setSndcode(String sndcode) {
        this.sndcode = sndcode;
    }

    public String getMchdate() {
        return mchdate;
    }

    public void setMchdate(String mchdate) {
        this.mchdate = mchdate;
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }

    public String getDecode() {
        return decode;
    }

    public void setDecode(String decode) {
        this.decode = decode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGg036() {
        return gg036;
    }

    public void setGg036(String gg036) {
        this.gg036 = gg036;
    }

    public String getGg105() {
        return gg105;
    }

    public void setGg105(String gg105) {
        this.gg105 = gg105;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getMark1() {
        return mark1;
    }

    public void setMark1(String mark1) {
        this.mark1 = mark1;
    }

    public String getContactman() {
        return contactman;
    }

    public void setContactman(String contactman) {
        this.contactman = contactman;
    }

    public String getGg109() {
        return gg109;
    }

    public void setGg109(String gg109) {
        this.gg109 = gg109;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getGg098() {
        return gg098;
    }

    public void setGg098(String gg098) {
        this.gg098 = gg098;
    }

    public String getGg009() {
        return gg009;
    }

    public void setGg009(String gg009) {
        this.gg009 = gg009;
    }

    public String getGg008() {
        return gg008;
    }

    public void setGg008(String gg008) {
        this.gg008 = gg008;
    }

    public String getCusgroup() {
        return cusgroup;
    }

    public void setCusgroup(String cusgroup) {
        this.cusgroup = cusgroup;
    }

    public String getGg003() {
        return gg003;
    }

    public void setGg003(String gg003) {
        this.gg003 = gg003;
    }

    public String getGg001() {
        return gg001;
    }

    public void setGg001(String gg001) {
        this.gg001 = gg001;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getFj1() {
        return fj1;
    }

    public void setFj1(String fj1) {
        this.fj1 = fj1;
    }

    public String getFj2() {
        return fj2;
    }

    public void setFj2(String fj2) {
        this.fj2 = fj2;
    }

    public String getGg004() {
        return gg004;
    }

    public void setGg004(String gg004) {
        this.gg004 = gg004;
    }

    public Double getYearamt() {
        return yearamt;
    }

    public void setYearamt(Double yearamt) {
        this.yearamt = yearamt;
    }

    public String getCussta() {
        return cussta;
    }

    public void setCussta(String cussta) {
        this.cussta = cussta;
    }

    public String getDmcode() {
        return dmcode;
    }

    public void setDmcode(String dmcode) {
        this.dmcode = dmcode;
    }

    public String getGg113() {
        return gg113;
    }

    public void setGg113(String gg113) {
        this.gg113 = gg113;
    }

    public String getGg010() {
        return gg010;
    }

    public void setGg010(String gg010) {
        this.gg010 = gg010;
    }

    public String getGg112() {
        return gg112;
    }

    public void setGg112(String gg112) {
        this.gg112 = gg112;
    }

    public String getGg050() {
        return gg050;
    }

    public void setGg050(String gg050) {
        this.gg050 = gg050;
    }

    public String getGg084() {
        return gg084;
    }

    public void setGg084(String gg084) {
        this.gg084 = gg084;
    }

    public String getPz() {
        return pz;
    }

    public void setPz(String pz) {
        this.pz = pz;
    }

    public String getGg011() {
        return gg011;
    }

    public void setGg011(String gg011) {
        this.gg011 = gg011;
    }

    public String getCusacctno() {
        return cusacctno;
    }

    public void setCusacctno(String cusacctno) {
        this.cusacctno = cusacctno;
    }

    public String getSkfs1() {
        return skfs1;
    }

    public void setSkfs1(String skfs1) {
        this.skfs1 = skfs1;
    }

    public String getSkfs2() {
        return skfs2;
    }

    public void setSkfs2(String skfs2) {
        this.skfs2 = skfs2;
    }

    public String getGg018() {
        return gg018;
    }

    public void setGg018(String gg018) {
        this.gg018 = gg018;
    }

    public String getVdrno() {
        return vdrno;
    }

    public void setVdrno(String vdrno) {
        this.vdrno = vdrno;
    }

    public Date getGg017() {
        return gg017;
    }

    public void setGg017(Date gg017) {
        this.gg017 = gg017;
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
        if (!(object instanceof HKYX006)) {
            return false;
        }
        HKYX006 other = (HKYX006) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKYX006[ oid=" + oid + " ]";
    }
    
}
