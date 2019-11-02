/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

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
 * @author C0160
 */
@Entity
@Table(name = "secsys")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Secsys.findAll", query = "SELECT s FROM Secsys s"),
    @NamedQuery(name = "Secsys.findBySysno", query = "SELECT s FROM Secsys s WHERE s.sysno = :sysno"),
    @NamedQuery(name = "Secsys.findBySysname", query = "SELECT s FROM Secsys s WHERE s.sysname = :sysname"),
    @NamedQuery(name = "Secsys.findBySysorder", query = "SELECT s FROM Secsys s WHERE s.sysorder = :sysorder"),
    @NamedQuery(name = "Secsys.findByFlwyn", query = "SELECT s FROM Secsys s WHERE s.flwyn = :flwyn"),
    @NamedQuery(name = "Secsys.findBySysyn", query = "SELECT s FROM Secsys s WHERE s.sysyn = :sysyn")})
public class Secsys implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "sysno")
    private String sysno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 48)
    @Column(name = "sysname")
    private String sysname;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sysorder")
    private Double sysorder;
    @Size(max = 1)
    @Column(name = "flwyn")
    private String flwyn;
    @Size(max = 1)
    @Column(name = "sysyn")
    private String sysyn;

    public Secsys() {
    }

    public Secsys(String sysno) {
        this.sysno = sysno;
    }

    public Secsys(String sysno, String sysname) {
        this.sysno = sysno;
        this.sysname = sysname;
    }

    public String getSysno() {
        return sysno;
    }

    public void setSysno(String sysno) {
        this.sysno = sysno;
    }

    public String getSysname() {
        return sysname;
    }

    public void setSysname(String sysname) {
        this.sysname = sysname;
    }

    public Double getSysorder() {
        return sysorder;
    }

    public void setSysorder(Double sysorder) {
        this.sysorder = sysorder;
    }

    public String getFlwyn() {
        return flwyn;
    }

    public void setFlwyn(String flwyn) {
        this.flwyn = flwyn;
    }

    public String getSysyn() {
        return sysyn;
    }

    public void setSysyn(String sysyn) {
        this.sysyn = sysyn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sysno != null ? sysno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Secsys)) {
            return false;
        }
        Secsys other = (Secsys) object;
        if ((this.sysno == null && other.sysno != null) || (this.sysno != null && !this.sysno.equals(other.sysno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Secsys[ sysno=" + sysno + " ]";
    }

}
