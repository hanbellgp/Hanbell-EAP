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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "HK_FW006")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKFW006.findAll", query = "SELECT h FROM HKFW006 h"),
    @NamedQuery(name = "HKFW006.findByGzreason", query = "SELECT h FROM HKFW006 h WHERE h.gzreason = :gzreason"),
    @NamedQuery(name = "HKFW006.findByYyjb", query = "SELECT h FROM HKFW006 h WHERE h.yyjb = :yyjb"),
    @NamedQuery(name = "HKFW006.findByTitdsc", query = "SELECT h FROM HKFW006 h WHERE h.titdsc = :titdsc"),
    @NamedQuery(name = "HKFW006.findByTklx", query = "SELECT h FROM HKFW006 h WHERE h.tklx = :tklx"),
    @NamedQuery(name = "HKFW006.findByCreatedate", query = "SELECT h FROM HKFW006 h WHERE h.createdate = :createdate"),
    @NamedQuery(name = "HKFW006.findByCdrno", query = "SELECT h FROM HKFW006 h WHERE h.cdrno = :cdrno"),
    @NamedQuery(name = "HKFW006.findByLitdsc", query = "SELECT h FROM HKFW006 h WHERE h.litdsc = :litdsc"),
    @NamedQuery(name = "HKFW006.findByMachineoil", query = "SELECT h FROM HKFW006 h WHERE h.machineoil = :machineoil"),
    @NamedQuery(name = "HKFW006.findByFwno", query = "SELECT h FROM HKFW006 h WHERE h.fwno = :fwno"),
    @NamedQuery(name = "HKFW006.findByCusno", query = "SELECT h FROM HKFW006 h WHERE h.cusno = :cusno"),
    @NamedQuery(name = "HKFW006.findByZbpzno", query = "SELECT h FROM HKFW006 h WHERE h.zbpzno = :zbpzno"),
    @NamedQuery(name = "HKFW006.findByRecitdsc", query = "SELECT h FROM HKFW006 h WHERE h.recitdsc = :recitdsc"),
    @NamedQuery(name = "HKFW006.findByRettype", query = "SELECT h FROM HKFW006 h WHERE h.rettype = :rettype"),
    @NamedQuery(name = "HKFW006.findByQty", query = "SELECT h FROM HKFW006 h WHERE h.qty = :qty"),
    @NamedQuery(name = "HKFW006.findByMark", query = "SELECT h FROM HKFW006 h WHERE h.mark = :mark"),
    @NamedQuery(name = "HKFW006.findByShpno", query = "SELECT h FROM HKFW006 h WHERE h.shpno = :shpno"),
    @NamedQuery(name = "HKFW006.findByKfno", query = "SELECT h FROM HKFW006 h WHERE h.kfno = :kfno"),
    @NamedQuery(name = "HKFW006.findByMachineoilhalf", query = "SELECT h FROM HKFW006 h WHERE h.machineoilhalf = :machineoilhalf"),
    @NamedQuery(name = "HKFW006.findByCptype", query = "SELECT h FROM HKFW006 h WHERE h.cptype = :cptype"),
    @NamedQuery(name = "HKFW006.findByPstyle", query = "SELECT h FROM HKFW006 h WHERE h.pstyle = :pstyle"),
    @NamedQuery(name = "HKFW006.findByRecitnbr", query = "SELECT h FROM HKFW006 h WHERE h.recitnbr = :recitnbr"),
    @NamedQuery(name = "HKFW006.findByTitnbr", query = "SELECT h FROM HKFW006 h WHERE h.titnbr = :titnbr"),
    @NamedQuery(name = "HKFW006.findByLcreateno", query = "SELECT h FROM HKFW006 h WHERE h.lcreateno = :lcreateno"),
    @NamedQuery(name = "HKFW006.findByRetqty", query = "SELECT h FROM HKFW006 h WHERE h.retqty = :retqty"),
    @NamedQuery(name = "HKFW006.findByOid", query = "SELECT h FROM HKFW006 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKFW006.findByApplydept", query = "SELECT h FROM HKFW006 h WHERE h.applydept = :applydept"),
    @NamedQuery(name = "HKFW006.findByFacno", query = "SELECT h FROM HKFW006 h WHERE h.facno = :facno"),
    @NamedQuery(name = "HKFW006.findByRetitdsc", query = "SELECT h FROM HKFW006 h WHERE h.retitdsc = :retitdsc"),
    @NamedQuery(name = "HKFW006.findByFgspzno", query = "SELECT h FROM HKFW006 h WHERE h.fgspzno = :fgspzno"),
    @NamedQuery(name = "HKFW006.findByTcreateno", query = "SELECT h FROM HKFW006 h WHERE h.tcreateno = :tcreateno"),
    @NamedQuery(name = "HKFW006.findByApplyuser", query = "SELECT h FROM HKFW006 h WHERE h.applyuser = :applyuser"),
    @NamedQuery(name = "HKFW006.findByRstyle", query = "SELECT h FROM HKFW006 h WHERE h.rstyle = :rstyle"),
    @NamedQuery(name = "HKFW006.findByRetitnbr", query = "SELECT h FROM HKFW006 h WHERE h.retitnbr = :retitnbr"),
    @NamedQuery(name = "HKFW006.findByPSN", query = "SELECT h FROM HKFW006 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKFW006.findByYf", query = "SELECT h FROM HKFW006 h WHERE h.yf = :yf"),
    @NamedQuery(name = "HKFW006.findByCusna", query = "SELECT h FROM HKFW006 h WHERE h.cusna = :cusna"),
    @NamedQuery(name = "HKFW006.findByBhmk", query = "SELECT h FROM HKFW006 h WHERE h.bhmk = :bhmk"),
    @NamedQuery(name = "HKFW006.findBySupportdept", query = "SELECT h FROM HKFW006 h WHERE h.supportdept = :supportdept"),
    @NamedQuery(name = "HKFW006.findByDzf", query = "SELECT h FROM HKFW006 h WHERE h.dzf = :dzf"),
    @NamedQuery(name = "HKFW006.findByReturntype", query = "SELECT h FROM HKFW006 h WHERE h.returntype = :returntype"),
    @NamedQuery(name = "HKFW006.findByRecqty", query = "SELECT h FROM HKFW006 h WHERE h.recqty = :recqty"),
    @NamedQuery(name = "HKFW006.findByUnit", query = "SELECT h FROM HKFW006 h WHERE h.unit = :unit"),
    @NamedQuery(name = "HKFW006.findByKssjt", query = "SELECT h FROM HKFW006 h WHERE h.kssjt = :kssjt"),
    @NamedQuery(name = "HKFW006.findByAstyle", query = "SELECT h FROM HKFW006 h WHERE h.astyle = :astyle"),
    @NamedQuery(name = "HKFW006.findBySupportuser", query = "SELECT h FROM HKFW006 h WHERE h.supportuser = :supportuser"),
    @NamedQuery(name = "HKFW006.findByFrozenoil", query = "SELECT h FROM HKFW006 h WHERE h.frozenoil = :frozenoil"),
    @NamedQuery(name = "HKFW006.findByReturndate", query = "SELECT h FROM HKFW006 h WHERE h.returndate = :returndate"),
    @NamedQuery(name = "HKFW006.findByCctype", query = "SELECT h FROM HKFW006 h WHERE h.cctype = :cctype"),
    @NamedQuery(name = "HKFW006.findByLitnbr", query = "SELECT h FROM HKFW006 h WHERE h.litnbr = :litnbr"),
    @NamedQuery(name = "HKFW006.findByFormSerialNumber", query = "SELECT h FROM HKFW006 h WHERE h.formSerialNumber = :formSerialNumber"),
    @NamedQuery(name = "HKFW006.findBySfzb", query = "SELECT h FROM HKFW006 h WHERE h.sfzb = :sfzb"),
    @NamedQuery(name = "HKFW006.findByDhno", query = "SELECT h FROM HKFW006 h WHERE h.dhno = :dhno"),
    @NamedQuery(name = "HKFW006.findByYymark", query = "SELECT h FROM HKFW006 h WHERE h.yymark = :yymark"),
    @NamedQuery(name = "HKFW006.findByPzno", query = "SELECT h FROM HKFW006 h WHERE h.pzno = :pzno"),
    @NamedQuery(name = "HKFW006.findByHdyyjb", query = "SELECT h FROM HKFW006 h WHERE h.hdyyjb = :hdyyjb")})
public class HKFW006 implements Serializable {

    @JoinColumn(name = "applyuser", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private Users applyUser;
    @JoinColumn(name = "applydept", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private OrganizationUnit applyDept;
    @JoinColumn(name = "supportuser", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private Users supportUser;
    @JoinColumn(name = "supportdept", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private OrganizationUnit supportDept;
    @Size(max = 255)
    @Column(name = "hdreturntype")
    private String hdreturntype;
    @Size(max = 255)
    @Column(name = "hdcptype")
    private String hdcptype;
    @Size(max = 255)
    @Column(name = "hdfacno")
    private String hdfacno;
    @Size(max = 255)
    @Column(name = "hdTC001")
    private String hdTC001;
    @Size(max = 255)
    @Column(name = "hdTD003")
    private String hdTD003;
    @Size(max = 255)
    @Column(name = "hdTD003A")
    private String hdTD003A;
    @Size(max = 255)
    @Column(name = "hdljxx")
    private String hdljxx;
    @Size(max = 255)
    @Column(name = "hditcls")
    private String hditcls;
    @Size(max = 255)
    @Column(name = "zjshpno")
    private String zjshpno;

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "gzreason")
    private String gzreason;
    @Size(max = 255)
    @Column(name = "yyjb")
    private String yyjb;
    @Size(max = 255)
    @Column(name = "titdsc")
    private String titdsc;
    @Size(max = 255)
    @Column(name = "tklx")
    private String tklx;
    @Column(name = "createdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;
    @Size(max = 255)
    @Column(name = "cdrno")
    private String cdrno;
    @Size(max = 255)
    @Column(name = "litdsc")
    private String litdsc;
    @Size(max = 255)
    @Column(name = "machineoil")
    private String machineoil;
    @Size(max = 255)
    @Column(name = "fwno")
    private String fwno;
    @Size(max = 255)
    @Column(name = "cusno")
    private String cusno;
    @Size(max = 255)
    @Column(name = "zbpzno")
    private String zbpzno;
    @Size(max = 255)
    @Column(name = "recitdsc")
    private String recitdsc;
    @Size(max = 255)
    @Column(name = "rettype")
    private String rettype;
    @Column(name = "qty")
    private Integer qty;
    @Size(max = 255)
    @Column(name = "mark")
    private String mark;
    @Size(max = 255)
    @Column(name = "shpno")
    private String shpno;
    @Size(max = 255)
    @Column(name = "kfno")
    private String kfno;
    @Size(max = 255)
    @Column(name = "machineoilhalf")
    private String machineoilhalf;
    @Size(max = 255)
    @Column(name = "cptype")
    private String cptype;
    @Size(max = 255)
    @Column(name = "pstyle")
    private String pstyle;
    @Size(max = 255)
    @Column(name = "recitnbr")
    private String recitnbr;
    @Size(max = 255)
    @Column(name = "titnbr")
    private String titnbr;
    @Size(max = 255)
    @Column(name = "lcreateno")
    private String lcreateno;
    @Size(max = 255)
    @Column(name = "retqty")
    private String retqty;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "applydept")
    private String applydept;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "retitdsc")
    private String retitdsc;
    @Size(max = 255)
    @Column(name = "fgspzno")
    private String fgspzno;
    @Size(max = 255)
    @Column(name = "tcreateno")
    private String tcreateno;
    @Size(max = 255)
    @Column(name = "applyuser")
    private String applyuser;
    @Size(max = 255)
    @Column(name = "rstyle")
    private String rstyle;
    @Size(max = 255)
    @Column(name = "retitnbr")
    private String retitnbr;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "yf")
    private Double yf;
    @Size(max = 255)
    @Column(name = "cusna")
    private String cusna;
    @Size(max = 255)
    @Column(name = "bhmk")
    private String bhmk;
    @Size(max = 255)
    @Column(name = "supportdept")
    private String supportdept;
    @Column(name = "dzf")
    private Double dzf;
    @Size(max = 255)
    @Column(name = "returntype")
    private String returntype;
    @Size(max = 255)
    @Column(name = "recqty")
    private String recqty;
    @Size(max = 255)
    @Column(name = "unit")
    private String unit;
    @Size(max = 255)
    @Column(name = "kssjt")
    private String kssjt;
    @Size(max = 255)
    @Column(name = "astyle")
    private String astyle;
    @Size(max = 255)
    @Column(name = "supportuser")
    private String supportuser;
    @Size(max = 255)
    @Column(name = "frozenoil")
    private String frozenoil;
    @Column(name = "returndate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date returndate;
    @Size(max = 255)
    @Column(name = "cctype")
    private String cctype;
    @Size(max = 255)
    @Column(name = "litnbr")
    private String litnbr;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "sfzb")
    private String sfzb;
    @Size(max = 255)
    @Column(name = "dhno")
    private String dhno;
    @Size(max = 255)
    @Column(name = "yymark")
    private String yymark;
    @Size(max = 255)
    @Column(name = "pzno")
    private String pzno;
    @Size(max = 255)
    @Column(name = "hdyyjb")
    private String hdyyjb;

    public HKFW006() {
    }

    public HKFW006(String oid) {
        this.oid = oid;
    }

    public String getGzreason() {
        return gzreason;
    }

    public void setGzreason(String gzreason) {
        this.gzreason = gzreason;
    }

    public String getYyjb() {
        return yyjb;
    }

    public void setYyjb(String yyjb) {
        this.yyjb = yyjb;
    }

    public String getTitdsc() {
        return titdsc;
    }

    public void setTitdsc(String titdsc) {
        this.titdsc = titdsc;
    }

    public String getTklx() {
        return tklx;
    }

    public void setTklx(String tklx) {
        this.tklx = tklx;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getCdrno() {
        return cdrno;
    }

    public void setCdrno(String cdrno) {
        this.cdrno = cdrno;
    }

    public String getLitdsc() {
        return litdsc;
    }

    public void setLitdsc(String litdsc) {
        this.litdsc = litdsc;
    }

    public String getMachineoil() {
        return machineoil;
    }

    public void setMachineoil(String machineoil) {
        this.machineoil = machineoil;
    }

    public String getFwno() {
        return fwno;
    }

    public void setFwno(String fwno) {
        this.fwno = fwno;
    }

    public String getCusno() {
        return cusno;
    }

    public void setCusno(String cusno) {
        this.cusno = cusno;
    }

    public String getZbpzno() {
        return zbpzno;
    }

    public void setZbpzno(String zbpzno) {
        this.zbpzno = zbpzno;
    }

    public String getRecitdsc() {
        return recitdsc;
    }

    public void setRecitdsc(String recitdsc) {
        this.recitdsc = recitdsc;
    }

    public String getRettype() {
        return rettype;
    }

    public void setRettype(String rettype) {
        this.rettype = rettype;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getShpno() {
        return shpno;
    }

    public void setShpno(String shpno) {
        this.shpno = shpno;
    }

    public String getKfno() {
        return kfno;
    }

    public void setKfno(String kfno) {
        this.kfno = kfno;
    }

    public String getMachineoilhalf() {
        return machineoilhalf;
    }

    public void setMachineoilhalf(String machineoilhalf) {
        this.machineoilhalf = machineoilhalf;
    }

    public String getCptype() {
        return cptype;
    }

    public void setCptype(String cptype) {
        this.cptype = cptype;
    }

    public String getPstyle() {
        return pstyle;
    }

    public void setPstyle(String pstyle) {
        this.pstyle = pstyle;
    }

    public String getRecitnbr() {
        return recitnbr;
    }

    public void setRecitnbr(String recitnbr) {
        this.recitnbr = recitnbr;
    }

    public String getTitnbr() {
        return titnbr;
    }

    public void setTitnbr(String titnbr) {
        this.titnbr = titnbr;
    }

    public String getLcreateno() {
        return lcreateno;
    }

    public void setLcreateno(String lcreateno) {
        this.lcreateno = lcreateno;
    }

    public String getRetqty() {
        return retqty;
    }

    public void setRetqty(String retqty) {
        this.retqty = retqty;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getApplydept() {
        return applydept;
    }

    public void setApplydept(String applydept) {
        this.applydept = applydept;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getRetitdsc() {
        return retitdsc;
    }

    public void setRetitdsc(String retitdsc) {
        this.retitdsc = retitdsc;
    }

    public String getFgspzno() {
        return fgspzno;
    }

    public void setFgspzno(String fgspzno) {
        this.fgspzno = fgspzno;
    }

    public String getTcreateno() {
        return tcreateno;
    }

    public void setTcreateno(String tcreateno) {
        this.tcreateno = tcreateno;
    }

    public String getApplyuser() {
        return applyuser;
    }

    public void setApplyuser(String applyuser) {
        this.applyuser = applyuser;
    }

    public String getRstyle() {
        return rstyle;
    }

    public void setRstyle(String rstyle) {
        this.rstyle = rstyle;
    }

    public String getRetitnbr() {
        return retitnbr;
    }

    public void setRetitnbr(String retitnbr) {
        this.retitnbr = retitnbr;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public Double getYf() {
        return yf;
    }

    public void setYf(Double yf) {
        this.yf = yf;
    }

    public String getCusna() {
        return cusna;
    }

    public void setCusna(String cusna) {
        this.cusna = cusna;
    }

    public String getBhmk() {
        return bhmk;
    }

    public void setBhmk(String bhmk) {
        this.bhmk = bhmk;
    }

    public String getSupportdept() {
        return supportdept;
    }

    public void setSupportdept(String supportdept) {
        this.supportdept = supportdept;
    }

    public Double getDzf() {
        return dzf;
    }

    public void setDzf(Double dzf) {
        this.dzf = dzf;
    }

    public String getReturntype() {
        return returntype;
    }

    public void setReturntype(String returntype) {
        this.returntype = returntype;
    }

    public String getRecqty() {
        return recqty;
    }

    public void setRecqty(String recqty) {
        this.recqty = recqty;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getKssjt() {
        return kssjt;
    }

    public void setKssjt(String kssjt) {
        this.kssjt = kssjt;
    }

    public String getAstyle() {
        return astyle;
    }

    public void setAstyle(String astyle) {
        this.astyle = astyle;
    }

    public String getSupportuser() {
        return supportuser;
    }

    public void setSupportuser(String supportuser) {
        this.supportuser = supportuser;
    }

    public String getFrozenoil() {
        return frozenoil;
    }

    public void setFrozenoil(String frozenoil) {
        this.frozenoil = frozenoil;
    }

    public Date getReturndate() {
        return returndate;
    }

    public void setReturndate(Date returndate) {
        this.returndate = returndate;
    }

    public String getCctype() {
        return cctype;
    }

    public void setCctype(String cctype) {
        this.cctype = cctype;
    }

    public String getLitnbr() {
        return litnbr;
    }

    public void setLitnbr(String litnbr) {
        this.litnbr = litnbr;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getSfzb() {
        return sfzb;
    }

    public void setSfzb(String sfzb) {
        this.sfzb = sfzb;
    }

    public String getDhno() {
        return dhno;
    }

    public void setDhno(String dhno) {
        this.dhno = dhno;
    }

    public String getYymark() {
        return yymark;
    }

    public void setYymark(String yymark) {
        this.yymark = yymark;
    }

    public String getPzno() {
        return pzno;
    }

    public void setPzno(String pzno) {
        this.pzno = pzno;
    }

    public String getHdyyjb() {
        return hdyyjb;
    }

    public void setHdyyjb(String hdyyjb) {
        this.hdyyjb = hdyyjb;
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
        if (!(object instanceof HKFW006)) {
            return false;
        }
        HKFW006 other = (HKFW006) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKFW006[ oid=" + oid + " ]";
    }

    public String getHdljxx() {
        return hdljxx;
    }

    public void setHdljxx(String hdljxx) {
        this.hdljxx = hdljxx;
    }

    public String getHditcls() {
        return hditcls;
    }

    public void setHditcls(String hditcls) {
        this.hditcls = hditcls;
    }

    public String getZjshpno() {
        return zjshpno;
    }

    public void setZjshpno(String zjshpno) {
        this.zjshpno = zjshpno;
    }

    public String getHdTC001() {
        return hdTC001;
    }

    public void setHdTC001(String hdTC001) {
        this.hdTC001 = hdTC001;
    }

    public String getHdTD003() {
        return hdTD003;
    }

    public void setHdTD003(String hdTD003) {
        this.hdTD003 = hdTD003;
    }

    public String getHdcptype() {
        return hdcptype;
    }

    public void setHdcptype(String hdcptype) {
        this.hdcptype = hdcptype;
    }

    public String getHdfacno() {
        return hdfacno;
    }

    public void setHdfacno(String hdfacno) {
        this.hdfacno = hdfacno;
    }

    public Users getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(Users applyUser) {
        this.applyUser = applyUser;
    }

    public OrganizationUnit getApplyDept() {
        return applyDept;
    }

    public void setApplyDept(OrganizationUnit applyDept) {
        this.applyDept = applyDept;
    }

    public Users getSupportUser() {
        return supportUser;
    }

    public void setSupportUser(Users supportUser) {
        this.supportUser = supportUser;
    }

    public OrganizationUnit getSupportDept() {
        return supportDept;
    }

    public void setSupportDept(OrganizationUnit supportDept) {
        this.supportDept = supportDept;
    }

    public String getHdreturntype() {
        return hdreturntype;
    }

    public void setHdreturntype(String hdreturntype) {
        this.hdreturntype = hdreturntype;
    }

    public String getHdTD003A() {
        return hdTD003A;
    }

    public void setHdTD003A(String hdTD003A) {
        this.hdTD003A = hdTD003A;
    }

}
