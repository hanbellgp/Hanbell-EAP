/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "cdrscus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdrscus.findAll", query = "SELECT c FROM Cdrscus c"),
    @NamedQuery(name = "Cdrscus.findByCusno", query = "SELECT c FROM Cdrscus c WHERE c.cdrscusPK.cusno = :cusno"),
    @NamedQuery(name = "Cdrscus.findByTrseq", query = "SELECT c FROM Cdrscus c WHERE c.cdrscusPK.trseq = :trseq"),
    @NamedQuery(name = "Cdrscus.findByShpcusno", query = "SELECT c FROM Cdrscus c WHERE c.shpcusno = :shpcusno"),
    @NamedQuery(name = "Cdrscus.findByCusna", query = "SELECT c FROM Cdrscus c WHERE c.cusna = :cusna"),
    @NamedQuery(name = "Cdrscus.findByAreacode", query = "SELECT c FROM Cdrscus c WHERE c.areacode = :areacode"),
    @NamedQuery(name = "Cdrscus.findByCuycode", query = "SELECT c FROM Cdrscus c WHERE c.cuycode = :cuycode"),
    @NamedQuery(name = "Cdrscus.findByZonecode", query = "SELECT c FROM Cdrscus c WHERE c.zonecode = :zonecode"),
    @NamedQuery(name = "Cdrscus.findByTel", query = "SELECT c FROM Cdrscus c WHERE c.tel = :tel"),
    @NamedQuery(name = "Cdrscus.findByFax", query = "SELECT c FROM Cdrscus c WHERE c.fax = :fax"),
    @NamedQuery(name = "Cdrscus.findByShpyn", query = "SELECT c FROM Cdrscus c WHERE c.shpyn = :shpyn"),
    @NamedQuery(name = "Cdrscus.findByContactman", query = "SELECT c FROM Cdrscus c WHERE c.contactman = :contactman")})
public class Cdrscus implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CdrscusPK cdrscusPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "shpcusno")
    private String shpcusno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "cusna")
    private String cusna;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "address1")
    private String address1;
    @Size(max = 40)
    @Column(name = "address2")
    private String address2;
    @Size(max = 40)
    @Column(name = "address3")
    private String address3;
    @Size(max = 40)
    @Column(name = "address4")
    private String address4;
    @Size(max = 40)
    @Column(name = "address5")
    private String address5;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "areacode")
    private String areacode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "cuycode")
    private String cuycode;
    @Size(max = 8)
    @Column(name = "zonecode")
    private String zonecode;
    @Size(max = 20)
    @Column(name = "tel")
    private String tel;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="电话/传真格式无效, 应为 xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "fax")
    private String fax;
    @Column(name = "shpyn")
    private Character shpyn;
    @Size(max = 30)
    @Column(name = "contactman")
    private String contactman;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "userno")
    private String userno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "indate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date indate;

    public Cdrscus() {
    }

    public Cdrscus(CdrscusPK cdrscusPK) {
        this.cdrscusPK = cdrscusPK;
    }

    public Cdrscus(String cusno, short trseq) {
        this.cdrscusPK = new CdrscusPK(cusno, trseq);
    }

    public CdrscusPK getCdrscusPK() {
        return cdrscusPK;
    }

    public void setCdrscusPK(CdrscusPK cdrscusPK) {
        this.cdrscusPK = cdrscusPK;
    }

    public String getShpcusno() {
        return shpcusno;
    }

    public void setShpcusno(String shpcusno) {
        this.shpcusno = shpcusno;
    }

    public String getCusna() {
        return cusna;
    }

    public void setCusna(String cusna) {
        this.cusna = cusna;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getAddress4() {
        return address4;
    }

    public void setAddress4(String address4) {
        this.address4 = address4;
    }

    public String getAddress5() {
        return address5;
    }

    public void setAddress5(String address5) {
        this.address5 = address5;
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    public String getCuycode() {
        return cuycode;
    }

    public void setCuycode(String cuycode) {
        this.cuycode = cuycode;
    }

    public String getZonecode() {
        return zonecode;
    }

    public void setZonecode(String zonecode) {
        this.zonecode = zonecode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Character getShpyn() {
        return shpyn;
    }

    public void setShpyn(Character shpyn) {
        this.shpyn = shpyn;
    }

    public String getContactman() {
        return contactman;
    }

    public void setContactman(String contactman) {
        this.contactman = contactman;
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
    }

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdrscusPK != null ? cdrscusPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cdrscus)) {
            return false;
        }
        Cdrscus other = (Cdrscus) object;
        if ((this.cdrscusPK == null && other.cdrscusPK != null) || (this.cdrscusPK != null && !this.cdrscusPK.equals(other.cdrscusPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Cdrscus[ cdrscusPK=" + cdrscusPK + " ]";
    }
    
}
