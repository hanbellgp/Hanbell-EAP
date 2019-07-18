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
 * @author C1587
 */
@Entity
@Table(name = "HK_GL039")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKGL039.findAll", query = "SELECT h FROM HKGL039 h"),
    @NamedQuery(name = "HKGL039.findByOID", query = "SELECT h FROM HKGL039 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKGL039.findBySalekind", query = "SELECT h FROM HKGL039 h WHERE h.salekind = :salekind"),
    @NamedQuery(name = "HKGL039.findByTakeuser", query = "SELECT h FROM HKGL039 h WHERE h.takeuser = :takeuser"),
    @NamedQuery(name = "HKGL039.findByBox01", query = "SELECT h FROM HKGL039 h WHERE h.box01 = :box01"),
    @NamedQuery(name = "HKGL039.findByBottle02", query = "SELECT h FROM HKGL039 h WHERE h.bottle02 = :bottle02"),
    @NamedQuery(name = "HKGL039.findByUnit01", query = "SELECT h FROM HKGL039 h WHERE h.unit01 = :unit01"),
    @NamedQuery(name = "HKGL039.findByCarno", query = "SELECT h FROM HKGL039 h WHERE h.carno = :carno"),
    @NamedQuery(name = "HKGL039.findByLookuser", query = "SELECT h FROM HKGL039 h WHERE h.lookuser = :lookuser"),
    @NamedQuery(name = "HKGL039.findByBottle01", query = "SELECT h FROM HKGL039 h WHERE h.bottle01 = :bottle01"),
    @NamedQuery(name = "HKGL039.findBySum02h", query = "SELECT h FROM HKGL039 h WHERE h.sum02h = :sum02h"),
    @NamedQuery(name = "HKGL039.findByTicket", query = "SELECT h FROM HKGL039 h WHERE h.ticket = :ticket"),
    @NamedQuery(name = "HKGL039.findByPSN", query = "SELECT h FROM HKGL039 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKGL039.findByS01", query = "SELECT h FROM HKGL039 h WHERE h.s01 = :s01"),
    @NamedQuery(name = "HKGL039.findByWhois", query = "SELECT h FROM HKGL039 h WHERE h.whois = :whois"),
    @NamedQuery(name = "HKGL039.findByOther1", query = "SELECT h FROM HKGL039 h WHERE h.other1 = :other1"),
    @NamedQuery(name = "HKGL039.findByJ01", query = "SELECT h FROM HKGL039 h WHERE h.j01 = :j01"),
    @NamedQuery(name = "HKGL039.findByUserno", query = "SELECT h FROM HKGL039 h WHERE h.userno = :userno"),
    @NamedQuery(name = "HKGL039.findBySum01", query = "SELECT h FROM HKGL039 h WHERE h.sum01 = :sum01"),
    @NamedQuery(name = "HKGL039.findBySum02", query = "SELECT h FROM HKGL039 h WHERE h.sum02 = :sum02"),
    @NamedQuery(name = "HKGL039.findByDepno", query = "SELECT h FROM HKGL039 h WHERE h.depno = :depno"),
    @NamedQuery(name = "HKGL039.findByA01", query = "SELECT h FROM HKGL039 h WHERE h.a01 = :a01"),
    @NamedQuery(name = "HKGL039.findBySum01h", query = "SELECT h FROM HKGL039 h WHERE h.sum01h = :sum01h"),
    @NamedQuery(name = "HKGL039.findByCreatdate", query = "SELECT h FROM HKGL039 h WHERE h.creatdate = :creatdate"),
    @NamedQuery(name = "HKGL039.findByNo01", query = "SELECT h FROM HKGL039 h WHERE h.no01 = :no01"),
    @NamedQuery(name = "HKGL039.findBySalevdr", query = "SELECT h FROM HKGL039 h WHERE h.salevdr = :salevdr"),
    @NamedQuery(name = "HKGL039.findByPrice01", query = "SELECT h FROM HKGL039 h WHERE h.price01 = :price01"),
    @NamedQuery(name = "HKGL039.findByTakedept", query = "SELECT h FROM HKGL039 h WHERE h.takedept = :takedept"),
    @NamedQuery(name = "HKGL039.findByFSN", query = "SELECT h FROM HKGL039 h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKGL039.findByPrice01h", query = "SELECT h FROM HKGL039 h WHERE h.price01h = :price01h")})
public class HKGL039 implements Serializable {

    private static final long serialVersionUID = 1L;
    @JoinColumn(name = "userno", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private Users applyuser;
    @JoinColumn(name = "depno", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private OrganizationUnit applyDept;
    @JoinColumn(name = "takedept", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private OrganizationUnit takeDept1;
    @JoinColumn(name = "lookuser", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private Users lookuser1;
    @JoinColumn(name = "takeuser", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private Users takeuser1;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "salekind")
    private String salekind;
    @Size(max = 255)
    @Column(name = "takeuser")
    private String takeuser;
    @Size(max = 255)
    @Column(name = "box01")
    private String box01;
    @Size(max = 255)
    @Column(name = "bottle02")
    private String bottle02;
    @Size(max = 255)
    @Column(name = "unit01")
    private String unit01;
    @Size(max = 255)
    @Column(name = "carno")
    private String carno;
    @Size(max = 255)
    @Column(name = "lookuser")
    private String lookuser;
    @Size(max = 255)
    @Column(name = "bottle01")
    private String bottle01;
    @Size(max = 255)
    @Column(name = "sum02h")
    private String sum02h;
    @Size(max = 255)
    @Column(name = "ticket")
    private String ticket;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "s01")
    private String s01;
    @Size(max = 255)
    @Column(name = "whois")
    private String whois;
    @Size(max = 255)
    @Column(name = "other1")
    private String other1;
    @Size(max = 255)
    @Column(name = "j01")
    private String j01;
    @Size(max = 255)
    @Column(name = "userno")
    private String userno;
    @Size(max = 255)
    @Column(name = "sum01")
    private String sum01;
    @Size(max = 255)
    @Column(name = "sum02")
    private String sum02;
    @Size(max = 255)
    @Column(name = "depno")
    private String depno;
    @Size(max = 255)
    @Column(name = "a01")
    private String a01;
    @Size(max = 255)
    @Column(name = "sum01h")
    private String sum01h;
    @Column(name = "creatdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creatdate;
    @Size(max = 255)
    @Column(name = "no01")
    private String no01;
    @Size(max = 255)
    @Column(name = "salevdr")
    private String salevdr;
    @Size(max = 255)
    @Column(name = "price01")
    private String price01;
    @Size(max = 255)
    @Column(name = "takedept")
    private String takedept;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "price01h")
    private String price01h;

    public HKGL039() {
    }

    public HKGL039(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getSalekind() {
        return salekind;
    }

    public void setSalekind(String salekind) {
        this.salekind = salekind;
    }

    public String getTakeuser() {
        return takeuser;
    }

    public void setTakeuser(String takeuser) {
        this.takeuser = takeuser;
    }

    public String getBox01() {
        return box01;
    }

    public void setBox01(String box01) {
        this.box01 = box01;
    }

    public String getBottle02() {
        return bottle02;
    }

    public void setBottle02(String bottle02) {
        this.bottle02 = bottle02;
    }

    public String getUnit01() {
        return unit01;
    }

    public void setUnit01(String unit01) {
        this.unit01 = unit01;
    }

    public String getCarno() {
        return carno;
    }

    public void setCarno(String carno) {
        this.carno = carno;
    }

    public String getLookuser() {
        return lookuser;
    }

    public void setLookuser(String lookuser) {
        this.lookuser = lookuser;
    }

    public String getBottle01() {
        return bottle01;
    }

    public void setBottle01(String bottle01) {
        this.bottle01 = bottle01;
    }

    public String getSum02h() {
        return sum02h;
    }

    public void setSum02h(String sum02h) {
        this.sum02h = sum02h;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getS01() {
        return s01;
    }

    public void setS01(String s01) {
        this.s01 = s01;
    }

    public String getWhois() {
        return whois;
    }

    public void setWhois(String whois) {
        this.whois = whois;
    }

    public String getOther1() {
        return other1;
    }

    public void setOther1(String other1) {
        this.other1 = other1;
    }

    public String getJ01() {
        return j01;
    }

    public void setJ01(String j01) {
        this.j01 = j01;
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
    }

    public String getSum01() {
        return sum01;
    }

    public void setSum01(String sum01) {
        this.sum01 = sum01;
    }

    public String getSum02() {
        return sum02;
    }

    public void setSum02(String sum02) {
        this.sum02 = sum02;
    }

    public String getDepno() {
        return depno;
    }

    public void setDepno(String depno) {
        this.depno = depno;
    }

    public String getA01() {
        return a01;
    }

    public void setA01(String a01) {
        this.a01 = a01;
    }

    public String getSum01h() {
        return sum01h;
    }

    public void setSum01h(String sum01h) {
        this.sum01h = sum01h;
    }

    public Date getCreatdate() {
        return creatdate;
    }

    public void setCreatdate(Date creatdate) {
        this.creatdate = creatdate;
    }

    public String getNo01() {
        return no01;
    }

    public void setNo01(String no01) {
        this.no01 = no01;
    }

    public String getSalevdr() {
        return salevdr;
    }

    public void setSalevdr(String salevdr) {
        this.salevdr = salevdr;
    }

    public String getPrice01() {
        return price01;
    }

    public void setPrice01(String price01) {
        this.price01 = price01;
    }

    public String getTakedept() {
        return takedept;
    }

    public void setTakedept(String takedept) {
        this.takedept = takedept;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getPrice01h() {
        return price01h;
    }

    public void setPrice01h(String price01h) {
        this.price01h = price01h;
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
        if (!(object instanceof HKGL039)) {
            return false;
        }
        HKGL039 other = (HKGL039) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKGL039[ oid=" + oid + " ]";
    }

    /**
     * @return the applyuser
     */
    public Users getApplyuser() {
        return applyuser;
    }

    /**
     * @param applyuser the applyuser to set
     */
    public void setApplyuser(Users applyuser) {
        this.applyuser = applyuser;
    }

    /**
     * @return the applyDept
     */
    public OrganizationUnit getApplyDept() {
        return applyDept;
    }

    /**
     * @param applyDept the applyDept to set
     */
    public void setApplyDept(OrganizationUnit applyDept) {
        this.applyDept = applyDept;
    }

    /**
     * @return the takeDept1
     */
    public OrganizationUnit getTakeDept1() {
        return takeDept1;
    }

    /**
     * @param takeDept1 the takeDept1 to set
     */
    public void setTakeDept1(OrganizationUnit takeDept1) {
        this.takeDept1 = takeDept1;
    }

    /**
     * @return the lookuser1
     */
    public Users getLookuser1() {
        return lookuser1;
    }

    /**
     * @param lookuser1 the lookuser1 to set
     */
    public void setLookuser1(Users lookuser1) {
        this.lookuser1 = lookuser1;
    }

    /**
     * @return the takeuser1
     */
    public Users getTakeuser1() {
        return takeuser1;
    }

    /**
     * @param takeuser1 the takeuser1 to set
     */
    public void setTakeuser1(Users takeuser1) {
        this.takeuser1 = takeuser1;
    }
    
}
