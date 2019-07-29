/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "cdrqsys")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdrqsys.findAll", query = "SELECT c FROM Cdrqsys c"),
    @NamedQuery(name = "Cdrqsys.findByFacno", query = "SELECT c FROM Cdrqsys c WHERE c.facno = :facno"),
    @NamedQuery(name = "Cdrqsys.findByHmark1", query = "SELECT c FROM Cdrqsys c WHERE c.hmark1 = :hmark1"),
    @NamedQuery(name = "Cdrqsys.findByHmark1kind", query = "SELECT c FROM Cdrqsys c WHERE c.hmark1kind = :hmark1kind"),
    @NamedQuery(name = "Cdrqsys.findByHmark2", query = "SELECT c FROM Cdrqsys c WHERE c.hmark2 = :hmark2"),
    @NamedQuery(name = "Cdrqsys.findByAutono", query = "SELECT c FROM Cdrqsys c WHERE c.autono = :autono"),
    @NamedQuery(name = "Cdrqsys.findByAutochar", query = "SELECT c FROM Cdrqsys c WHERE c.autochar = :autochar"),
    @NamedQuery(name = "Cdrqsys.findByNofmt", query = "SELECT c FROM Cdrqsys c WHERE c.nofmt = :nofmt"),
    @NamedQuery(name = "Cdrqsys.findByCntype", query = "SELECT c FROM Cdrqsys c WHERE c.cntype = :cntype"),
    @NamedQuery(name = "Cdrqsys.findByRepeattrn", query = "SELECT c FROM Cdrqsys c WHERE c.repeattrn = :repeattrn"),
    @NamedQuery(name = "Cdrqsys.findByCnmgn", query = "SELECT c FROM Cdrqsys c WHERE c.cnmgn = :cnmgn"),
    @NamedQuery(name = "Cdrqsys.findByKvalue", query = "SELECT c FROM Cdrqsys c WHERE c.kvalue = :kvalue")})
public class Cdrqsys implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "facno")
    private String facno;
    @Size(max = 8)
    @Column(name = "hmark1")
    private String hmark1;
    @Size(max = 2)
    @Column(name = "hmark1kind")
    private String hmark1kind;
    @Size(max = 8)
    @Column(name = "hmark2")
    private String hmark2;
    @Size(max = 2)
    @Column(name = "hmark2kind")
    private String hmark2kind;
    @Size(max = 8)
    @Column(name = "hmark3")
    private String hmark3;
    @Size(max = 2)
    @Column(name = "hmark3kind")
    private String hmark3kind;
    @Size(max = 8)
    @Column(name = "hmark4")
    private String hmark4;
    @Size(max = 2)
    @Column(name = "hmark4kind")
    private String hmark4kind;
    @Size(max = 8)
    @Column(name = "dmark1")
    private String dmark1;
    @Size(max = 2)
    @Column(name = "dmark1kind")
    private String dmark1kind;
    @Size(max = 8)
    @Column(name = "dmark2")
    private String dmark2;
    @Size(max = 2)
    @Column(name = "dmark2kind")
    private String dmark2kind;
    @Size(max = 8)
    @Column(name = "dmark3")
    private String dmark3;
    @Size(max = 2)
    @Column(name = "dmark3kind")
    private String dmark3kind;
    @Size(max = 8)
    @Column(name = "dmark4")
    private String dmark4;
    @Size(max = 2)
    @Column(name = "dmark4kind")
    private String dmark4kind;
    @Basic(optional = false)
    @NotNull
    @Column(name = "autono")
    private Character autono;
    @Column(name = "autochar")
    private Character autochar;
    @Size(max = 6)
    @Column(name = "nofmt")
    private String nofmt;
    @Size(max = 8)
    @Column(name = "cntype")
    private String cntype;
    @Column(name = "repeattrn")
    private Character repeattrn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "cnmgn")
    private String cnmgn;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "kvalue")
    private BigDecimal kvalue;

    public Cdrqsys() {
    }

    public Cdrqsys(String facno) {
        this.facno = facno;
    }

    public Cdrqsys(String facno, Character autono, String cnmgn) {
        this.facno = facno;
        this.autono = autono;
        this.cnmgn = cnmgn;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getHmark1() {
        return hmark1;
    }

    public void setHmark1(String hmark1) {
        this.hmark1 = hmark1;
    }

    public String getHmark1kind() {
        return hmark1kind;
    }

    public void setHmark1kind(String hmark1kind) {
        this.hmark1kind = hmark1kind;
    }

    public String getHmark2() {
        return hmark2;
    }

    public void setHmark2(String hmark2) {
        this.hmark2 = hmark2;
    }

    public String getHmark2kind() {
        return hmark2kind;
    }

    public void setHmark2kind(String hmark2kind) {
        this.hmark2kind = hmark2kind;
    }

    public String getHmark3() {
        return hmark3;
    }

    public void setHmark3(String hmark3) {
        this.hmark3 = hmark3;
    }

    public String getHmark3kind() {
        return hmark3kind;
    }

    public void setHmark3kind(String hmark3kind) {
        this.hmark3kind = hmark3kind;
    }

    public String getHmark4() {
        return hmark4;
    }

    public void setHmark4(String hmark4) {
        this.hmark4 = hmark4;
    }

    public String getHmark4kind() {
        return hmark4kind;
    }

    public void setHmark4kind(String hmark4kind) {
        this.hmark4kind = hmark4kind;
    }

    public String getDmark1() {
        return dmark1;
    }

    public void setDmark1(String dmark1) {
        this.dmark1 = dmark1;
    }

    public String getDmark1kind() {
        return dmark1kind;
    }

    public void setDmark1kind(String dmark1kind) {
        this.dmark1kind = dmark1kind;
    }

    public String getDmark2() {
        return dmark2;
    }

    public void setDmark2(String dmark2) {
        this.dmark2 = dmark2;
    }

    public String getDmark2kind() {
        return dmark2kind;
    }

    public void setDmark2kind(String dmark2kind) {
        this.dmark2kind = dmark2kind;
    }

    public String getDmark3() {
        return dmark3;
    }

    public void setDmark3(String dmark3) {
        this.dmark3 = dmark3;
    }

    public String getDmark3kind() {
        return dmark3kind;
    }

    public void setDmark3kind(String dmark3kind) {
        this.dmark3kind = dmark3kind;
    }

    public String getDmark4() {
        return dmark4;
    }

    public void setDmark4(String dmark4) {
        this.dmark4 = dmark4;
    }

    public String getDmark4kind() {
        return dmark4kind;
    }

    public void setDmark4kind(String dmark4kind) {
        this.dmark4kind = dmark4kind;
    }

    public Character getAutono() {
        return autono;
    }

    public void setAutono(Character autono) {
        this.autono = autono;
    }

    public Character getAutochar() {
        return autochar;
    }

    public void setAutochar(Character autochar) {
        this.autochar = autochar;
    }

    public String getNofmt() {
        return nofmt;
    }

    public void setNofmt(String nofmt) {
        this.nofmt = nofmt;
    }

    public String getCntype() {
        return cntype;
    }

    public void setCntype(String cntype) {
        this.cntype = cntype;
    }

    public Character getRepeattrn() {
        return repeattrn;
    }

    public void setRepeattrn(Character repeattrn) {
        this.repeattrn = repeattrn;
    }

    public String getCnmgn() {
        return cnmgn;
    }

    public void setCnmgn(String cnmgn) {
        this.cnmgn = cnmgn;
    }

    public BigDecimal getKvalue() {
        return kvalue;
    }

    public void setKvalue(BigDecimal kvalue) {
        this.kvalue = kvalue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facno != null ? facno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cdrqsys)) {
            return false;
        }
        Cdrqsys other = (Cdrqsys) object;
        if ((this.facno == null && other.facno != null) || (this.facno != null && !this.facno.equals(other.facno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Cdrqsys[ facno=" + facno + " ]";
    }

}
