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
@Table(name = "Hk_JS001")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKJS001.findAll", query = "SELECT h FROM HKJS001 h"),
    @NamedQuery(name = "HKJS001.findByOID", query = "SELECT h FROM HKJS001 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKJS001.findByDept", query = "SELECT h FROM HKJS001 h WHERE h.dept = :dept"),
    @NamedQuery(name = "HKJS001.findByPSN", query = "SELECT h FROM HKJS001 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKJS001.findByFSN", query = "SELECT h FROM HKJS001 h WHERE h.formSerialNumber = :fsn")})
public class HKJS001 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "ydept")
    private String ydept;
    @Size(max = 255)
    @Column(name = "pbb")
    private String pbb;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "bgbh")
    private String bgbh;
    @Column(name = "createdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;
    @Size(max = 255)
    @Column(name = "leib")
    private String leib;
    @Size(max = 255)
    @Column(name = "wjsqdh")
    private String wjsqdh;
    @Size(max = 255)
    @Column(name = "jgk")
    private String jgk;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "jhsqdh")
    private String jhsqdh;
    @Size(max = 255)
    @Column(name = "smhy")
    private String smhy;
    @Column(name = "time1")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time1;
    @Size(max = 255)
    @Column(name = "jszx")
    private String jszx;
    @Size(max = 255)
    @Column(name = "cwb")
    private String cwb;
    @Size(max = 255)
    @Column(name = "cpb")
    private String cpb;
    @Size(max = 255)
    @Column(name = "applyuser")
    private String applyuser;
    @Size(max = 255)
    @Column(name = "czfs")
    private String czfs;
    @Size(max = 255)
    @Column(name = "sjk")
    private String sjk;
    @Size(max = 255)
    @Column(name = "bth")
    private String bth;
    @Size(max = 255)
    @Column(name = "dept")
    private String dept;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "ecrdh")
    private String ecrdh;
    @Size(max = 255)
    @Column(name = "apm")
    private String apm;
    @Size(max = 255)
    @Column(name = "bjh")
    private String bjh;
    @Size(max = 255)
    @Column(name = "ath")
    private String ath;
    @Size(max = 255)
    @Column(name = "cgb")
    private String cgb;
    @Size(max = 255)
    @Column(name = "wgb")
    private String wgb;
    @Size(max = 255)
    @Column(name = "zdbg")
    private String zdbg;
    @Size(max = 255)
    @Column(name = "kycpb")
    private String kycpb;
    @Size(max = 255)
    @Column(name = "fwb")
    private String fwb;
    @Size(max = 255)
    @Column(name = "zlcpb")
    private String zlcpb;
    @Size(max = 255)
    @Column(name = "twhz")
    private String twhz;
    @Size(max = 255)
    @Column(name = "els")
    private String els;
    @Size(max = 255)
    @Column(name = "ajh")
    private String ajh;
    @Size(max = 255)
    @Column(name = "bpm")
    private String bpm;
    @Size(max = 255)
    @Column(name = "aim")
    private String aim;
    @Size(max = 255)
    @Column(name = "zdept")
    private String zdept;
    @Size(max = 255)
    @Column(name = "cjg")
    private String cjg;
    @Size(max = 255)
    @Column(name = "sgk")
    private String sgk;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "kmpbk")
    private String kmpbk;
    @Size(max = 255)
    @Column(name = "kmsck")
    private String kmsck;

    public HKJS001() {
    }

    public HKJS001(String oid) {
        this.oid = oid;
    }

    public String getYdept() {
        return ydept;
    }

    public void setYdept(String ydept) {
        this.ydept = ydept;
    }

    public String getPbb() {
        return pbb;
    }

    public void setPbb(String pbb) {
        this.pbb = pbb;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getBgbh() {
        return bgbh;
    }

    public void setBgbh(String bgbh) {
        this.bgbh = bgbh;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getLeib() {
        return leib;
    }

    public void setLeib(String leib) {
        this.leib = leib;
    }

    public String getWjsqdh() {
        return wjsqdh;
    }

    public void setWjsqdh(String wjsqdh) {
        this.wjsqdh = wjsqdh;
    }

    public String getJgk() {
        return jgk;
    }

    public void setJgk(String jgk) {
        this.jgk = jgk;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getJhsqdh() {
        return jhsqdh;
    }

    public void setJhsqdh(String jhsqdh) {
        this.jhsqdh = jhsqdh;
    }

    public String getSmhy() {
        return smhy;
    }

    public void setSmhy(String smhy) {
        this.smhy = smhy;
    }

    public Date getTime1() {
        return time1;
    }

    public void setTime1(Date time1) {
        this.time1 = time1;
    }

    public String getJszx() {
        return jszx;
    }

    public void setJszx(String jszx) {
        this.jszx = jszx;
    }

    public String getCwb() {
        return cwb;
    }

    public void setCwb(String cwb) {
        this.cwb = cwb;
    }

    public String getCpb() {
        return cpb;
    }

    public void setCpb(String cpb) {
        this.cpb = cpb;
    }

    public String getApplyuser() {
        return applyuser;
    }

    public void setApplyuser(String applyuser) {
        this.applyuser = applyuser;
    }

    public String getCzfs() {
        return czfs;
    }

    public void setCzfs(String czfs) {
        this.czfs = czfs;
    }

    public String getSjk() {
        return sjk;
    }

    public void setSjk(String sjk) {
        this.sjk = sjk;
    }

    public String getBth() {
        return bth;
    }

    public void setBth(String bth) {
        this.bth = bth;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getEcrdh() {
        return ecrdh;
    }

    public void setEcrdh(String ecrdh) {
        this.ecrdh = ecrdh;
    }

    public String getApm() {
        return apm;
    }

    public void setApm(String apm) {
        this.apm = apm;
    }

    public String getBjh() {
        return bjh;
    }

    public void setBjh(String bjh) {
        this.bjh = bjh;
    }

    public String getAth() {
        return ath;
    }

    public void setAth(String ath) {
        this.ath = ath;
    }

    public String getCgb() {
        return cgb;
    }

    public void setCgb(String cgb) {
        this.cgb = cgb;
    }

    public String getWgb() {
        return wgb;
    }

    public void setWgb(String wgb) {
        this.wgb = wgb;
    }

    public String getZdbg() {
        return zdbg;
    }

    public void setZdbg(String zdbg) {
        this.zdbg = zdbg;
    }

    public String getKycpb() {
        return kycpb;
    }

    public void setKycpb(String kycpb) {
        this.kycpb = kycpb;
    }

    public String getFwb() {
        return fwb;
    }

    public void setFwb(String fwb) {
        this.fwb = fwb;
    }

    public String getZlcpb() {
        return zlcpb;
    }

    public void setZlcpb(String zlcpb) {
        this.zlcpb = zlcpb;
    }

    public String getTwhz() {
        return twhz;
    }

    public void setTwhz(String twhz) {
        this.twhz = twhz;
    }

    public String getEls() {
        return els;
    }

    public void setEls(String els) {
        this.els = els;
    }

    public String getAjh() {
        return ajh;
    }

    public void setAjh(String ajh) {
        this.ajh = ajh;
    }

    public String getBpm() {
        return bpm;
    }

    public void setBpm(String bpm) {
        this.bpm = bpm;
    }

    public String getAim() {
        return aim;
    }

    public void setAim(String aim) {
        this.aim = aim;
    }

    public String getZdept() {
        return zdept;
    }

    public void setZdept(String zdept) {
        this.zdept = zdept;
    }

    public String getCjg() {
        return cjg;
    }

    public void setCjg(String cjg) {
        this.cjg = cjg;
    }

    public String getSgk() {
        return sgk;
    }

    public void setSgk(String sgk) {
        this.sgk = sgk;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getKmpbk() {
        return kmpbk;
    }

    public void setKmpbk(String kmpbk) {
        this.kmpbk = kmpbk;
    }

    public String getKmsck() {
        return kmsck;
    }

    public void setKmsck(String kmsck) {
        this.kmsck = kmsck;
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
        if (!(object instanceof HKJS001)) {
            return false;
        }
        HKJS001 other = (HKJS001) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKJS001[ oid=" + oid + " ]";
    }

}
