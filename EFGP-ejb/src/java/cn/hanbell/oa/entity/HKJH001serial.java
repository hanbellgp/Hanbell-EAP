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
 * @author C1587
 */
@Entity
@Table(name = "HK_JH_001_serial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKJH001serial.findAll", query = "SELECT h FROM HKJH001serial h"),
    @NamedQuery(name = "HKJH001serial.findByKind", query = "SELECT h FROM HKJH001serial h WHERE h.kind = :kind"),
    @NamedQuery(name = "HKJH001serial.findBySerialno", query = "SELECT h FROM HKJH001serial h WHERE h.serialno = :serialno")})
public class HKJH001serial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "kind")
    private String kind;
    @Basic(optional = false)
    @NotNull
    @Column(name = "serialno")
    private int serialno;

    public HKJH001serial() {
    }

    public HKJH001serial(String kind) {
        this.kind = kind;
    }

    public HKJH001serial(String kind, int serialno) {
        this.kind = kind;
        this.serialno = serialno;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getSerialno() {
        return serialno;
    }

    public void setSerialno(int serialno) {
        this.serialno = serialno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kind != null ? kind.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HKJH001serial)) {
            return false;
        }
        HKJH001serial other = (HKJH001serial) object;
        if ((this.kind == null && other.kind != null) || (this.kind != null && !this.kind.equals(other.kind))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.hkjh001serial[ kind=" + kind + " ]";
    }
    
}
