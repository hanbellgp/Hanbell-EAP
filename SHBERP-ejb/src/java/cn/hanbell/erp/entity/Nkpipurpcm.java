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
 * @author C2082
 */
@Entity
@Table(name = "N_KpiPurPcm")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nkpipurpcm.findAll", query = "SELECT n FROM Nkpipurpcm n"),
    @NamedQuery(name = "Nkpipurpcm.findByVdrno", query = "SELECT n FROM Nkpipurpcm n WHERE n.vdrno = :vdrno"),
    @NamedQuery(name = "Nkpipurpcm.findByVdrna", query = "SELECT n FROM Nkpipurpcm n WHERE n.vdrna = :vdrna"),
    @NamedQuery(name = "Nkpipurpcm.findByFacno", query = "SELECT n FROM Nkpipurpcm n WHERE n.facno = :facno"),
    @NamedQuery(name = "Nkpipurpcm.findByMaterialTypeName", query = "SELECT n FROM Nkpipurpcm n WHERE n.materialTypeName = :materialTypeName"),
    @NamedQuery(name = "Nkpipurpcm.findByUserno", query = "SELECT n FROM Nkpipurpcm n WHERE n.userno = :userno"),
    @NamedQuery(name = "Nkpipurpcm.findByUserna", query = "SELECT n FROM Nkpipurpcm n WHERE n.userna = :userna"),
    @NamedQuery(name = "Nkpipurpcm.findByInDate", query = "SELECT n FROM Nkpipurpcm n WHERE n.inDate = :inDate")})
public class Nkpipurpcm implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "Vdrno")
    private String vdrno;
    @Size(max = 30)
    @Column(name = "Vdrna")
    private String vdrna;
    @Size(max = 8)
    @Column(name = "Facno")
    private String facno;
    @Size(max = 30)
    @Column(name = "MaterialTypeName")
    private String materialTypeName;
    @Size(max = 5)
    @Column(name = "Userno")
    private String userno;
    @Size(max = 30)
    @Column(name = "Userna")
    private String userna;
    @Column(name = "InDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inDate;

    public Nkpipurpcm() {
    }

    public Nkpipurpcm(String vdrno) {
        this.vdrno = vdrno;
    }

    public String getVdrno() {
        return vdrno;
    }

    public void setVdrno(String vdrno) {
        this.vdrno = vdrno;
    }

    public String getVdrna() {
        return vdrna;
    }

    public void setVdrna(String vdrna) {
        this.vdrna = vdrna;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getMaterialTypeName() {
        return materialTypeName;
    }

    public void setMaterialTypeName(String materialTypeName) {
        this.materialTypeName = materialTypeName;
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
    }

    public String getUserna() {
        return userna;
    }

    public void setUserna(String userna) {
        this.userna = userna;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vdrno != null ? vdrno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nkpipurpcm)) {
            return false;
        }
        Nkpipurpcm other = (Nkpipurpcm) object;
        if ((this.vdrno == null && other.vdrno != null) || (this.vdrno != null && !this.vdrno.equals(other.vdrno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Nkpipurpcm[ vdrno=" + vdrno + " ]";
    }
    
}
