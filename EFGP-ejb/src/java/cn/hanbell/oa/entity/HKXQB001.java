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
 * @author Administrator
 */
@Entity
@Table(name = "HK_XQB001")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKXQB001.findAll", query = "SELECT h FROM HKXQB001 h"),
    @NamedQuery(name = "HKXQB001.findByOID", query = "SELECT h FROM HKXQB001 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKXQB001.findByCreatedate", query = "SELECT h FROM HKXQB001 h WHERE h.createdate = :createdate"),
    @NamedQuery(name = "HKXQB001.findByXypg", query = "SELECT h FROM HKXQB001 h WHERE h.xypg = :xypg"),
    @NamedQuery(name = "HKXQB001.findByNyd", query = "SELECT h FROM HKXQB001 h WHERE h.nyd = :nyd"),
    @NamedQuery(name = "HKXQB001.findBySerialNumber", query = "SELECT h FROM HKXQB001 h WHERE h.serialNumber = :serialNumber"),
    @NamedQuery(name = "HKXQB001.findBySsxt", query = "SELECT h FROM HKXQB001 h WHERE h.ssxt = :ssxt"),
    @NamedQuery(name = "HKXQB001.findByTime4", query = "SELECT h FROM HKXQB001 h WHERE h.time4 = :time4"),
    @NamedQuery(name = "HKXQB001.findByTime3", query = "SELECT h FROM HKXQB001 h WHERE h.time3 = :time3"),
    @NamedQuery(name = "HKXQB001.findByTime2", query = "SELECT h FROM HKXQB001 h WHERE h.time2 = :time2"),
    @NamedQuery(name = "HKXQB001.findByTgfj", query = "SELECT h FROM HKXQB001 h WHERE h.tgfj = :tgfj"),
    @NamedQuery(name = "HKXQB001.findByTime1", query = "SELECT h FROM HKXQB001 h WHERE h.time1 = :time1"),
    @NamedQuery(name = "HKXQB001.findBySsmk", query = "SELECT h FROM HKXQB001 h WHERE h.ssmk = :ssmk"),
    @NamedQuery(name = "HKXQB001.findByApplyuser", query = "SELECT h FROM HKXQB001 h WHERE h.applyuser = :applyuser"),
    @NamedQuery(name = "HKXQB001.findByZxhf", query = "SELECT h FROM HKXQB001 h WHERE h.zxhf = :zxhf"),
    @NamedQuery(name = "HKXQB001.findByPSN", query = "SELECT h FROM HKXQB001 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKXQB001.findByXqjs", query = "SELECT h FROM HKXQB001 h WHERE h.xqjs = :xqjs"),
    @NamedQuery(name = "HKXQB001.findByTime5", query = "SELECT h FROM HKXQB001 h WHERE h.time5 = :time5"),
    @NamedQuery(name = "HKXQB001.findByCxmc", query = "SELECT h FROM HKXQB001 h WHERE h.cxmc = :cxmc"),
    @NamedQuery(name = "HKXQB001.findByZsd", query = "SELECT h FROM HKXQB001 h WHERE h.zsd = :zsd"),
    @NamedQuery(name = "HKXQB001.findByDept1", query = "SELECT h FROM HKXQB001 h WHERE h.dept1 = :dept1"),
    @NamedQuery(name = "HKXQB001.findByXqnr", query = "SELECT h FROM HKXQB001 h WHERE h.xqnr = :xqnr"),
    @NamedQuery(name = "HKXQB001.findBySypl", query = "SELECT h FROM HKXQB001 h WHERE h.sypl = :sypl"),
    @NamedQuery(name = "HKXQB001.findByUser2", query = "SELECT h FROM HKXQB001 h WHERE h.user2 = :user2"),
    @NamedQuery(name = "HKXQB001.findByUser1", query = "SELECT h FROM HKXQB001 h WHERE h.user1 = :user1"),
    @NamedQuery(name = "HKXQB001.findByJjd", query = "SELECT h FROM HKXQB001 h WHERE h.jjd = :jjd"),
    @NamedQuery(name = "HKXQB001.findByFSN", query = "SELECT h FROM HKXQB001 h WHERE h.formSerialNumber = :fsn")})
public class HKXQB001 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Column(name = "createdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;
    @Size(max = 255)
    @Column(name = "xypg")
    private String xypg;
    @Size(max = 255)
    @Column(name = "nyd")
    private String nyd;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "ssxt")
    private String ssxt;
    @Column(name = "time4")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time4;
    @Column(name = "time3")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time3;
    @Column(name = "time2")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time2;
    @Size(max = 255)
    @Column(name = "tgfj")
    private String tgfj;
    @Column(name = "time1")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time1;
    @Size(max = 255)
    @Column(name = "ssmk")
    private String ssmk;
    @Size(max = 255)
    @Column(name = "applyuser")
    private String applyuser;
    @Size(max = 255)
    @Column(name = "zxhf")
    private String zxhf;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "xqjs")
    private String xqjs;
    @Column(name = "time5")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time5;
    @Size(max = 255)
    @Column(name = "cxmc")
    private String cxmc;
    @Size(max = 255)
    @Column(name = "zsd")
    private String zsd;
    @Size(max = 255)
    @Column(name = "dept1")
    private String dept1;
    @Size(max = 255)
    @Column(name = "xqnr")
    private String xqnr;
    @Size(max = 255)
    @Column(name = "sypl")
    private String sypl;
    @Size(max = 255)
    @Column(name = "user2")
    private String user2;
    @Size(max = 255)
    @Column(name = "user1")
    private String user1;
    @Size(max = 255)
    @Column(name = "jjd")
    private String jjd;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;

    public HKXQB001() {
    }

    public HKXQB001(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getXypg() {
        return xypg;
    }

    public void setXypg(String xypg) {
        this.xypg = xypg;
    }

    public String getNyd() {
        return nyd;
    }

    public void setNyd(String nyd) {
        this.nyd = nyd;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSsxt() {
        return ssxt;
    }

    public void setSsxt(String ssxt) {
        this.ssxt = ssxt;
    }

    public Date getTime4() {
        return time4;
    }

    public void setTime4(Date time4) {
        this.time4 = time4;
    }

    public Date getTime3() {
        return time3;
    }

    public void setTime3(Date time3) {
        this.time3 = time3;
    }

    public Date getTime2() {
        return time2;
    }

    public void setTime2(Date time2) {
        this.time2 = time2;
    }

    public String getTgfj() {
        return tgfj;
    }

    public void setTgfj(String tgfj) {
        this.tgfj = tgfj;
    }

    public Date getTime1() {
        return time1;
    }

    public void setTime1(Date time1) {
        this.time1 = time1;
    }

    public String getSsmk() {
        return ssmk;
    }

    public void setSsmk(String ssmk) {
        this.ssmk = ssmk;
    }

    public String getApplyuser() {
        return applyuser;
    }

    public void setApplyuser(String applyuser) {
        this.applyuser = applyuser;
    }

    public String getZxhf() {
        return zxhf;
    }

    public void setZxhf(String zxhf) {
        this.zxhf = zxhf;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getXqjs() {
        return xqjs;
    }

    public void setXqjs(String xqjs) {
        this.xqjs = xqjs;
    }

    public Date getTime5() {
        return time5;
    }

    public void setTime5(Date time5) {
        this.time5 = time5;
    }

    public String getCxmc() {
        return cxmc;
    }

    public void setCxmc(String cxmc) {
        this.cxmc = cxmc;
    }

    public String getZsd() {
        return zsd;
    }

    public void setZsd(String zsd) {
        this.zsd = zsd;
    }

    public String getDept1() {
        return dept1;
    }

    public void setDept1(String dept1) {
        this.dept1 = dept1;
    }

    public String getXqnr() {
        return xqnr;
    }

    public void setXqnr(String xqnr) {
        this.xqnr = xqnr;
    }

    public String getSypl() {
        return sypl;
    }

    public void setSypl(String sypl) {
        this.sypl = sypl;
    }

    public String getUser2() {
        return user2;
    }

    public void setUser2(String user2) {
        this.user2 = user2;
    }

    public String getUser1() {
        return user1;
    }

    public void setUser1(String user1) {
        this.user1 = user1;
    }

    public String getJjd() {
        return jjd;
    }

    public void setJjd(String jjd) {
        this.jjd = jjd;
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
        if (!(object instanceof HKXQB001)) {
            return false;
        }
        HKXQB001 other = (HKXQB001) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKXQB001[ oid=" + oid + " ]";
    }
    
}
