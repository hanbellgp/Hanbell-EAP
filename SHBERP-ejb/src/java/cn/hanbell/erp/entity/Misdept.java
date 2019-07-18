/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "misdept")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Misdept.findAll", query = "SELECT m FROM Misdept m"),
    @NamedQuery(name = "Misdept.findByFacno", query = "SELECT m FROM Misdept m WHERE m.misdeptPK.facno = :facno"),
    @NamedQuery(name = "Misdept.findByDepno", query = "SELECT m FROM Misdept m WHERE m.misdeptPK.depno = :depno"),
    @NamedQuery(name = "Misdept.findByDepname", query = "SELECT m FROM Misdept m WHERE m.depname = :depname"),
    @NamedQuery(name = "Misdept.findByManager", query = "SELECT m FROM Misdept m WHERE m.manager = :manager"),
    @NamedQuery(name = "Misdept.findByUplevel", query = "SELECT m FROM Misdept m WHERE m.uplevel = :uplevel"),
    @NamedQuery(name = "Misdept.findByChildren", query = "SELECT m FROM Misdept m WHERE m.children = :children")})
public class Misdept implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MisdeptPK misdeptPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 48)
    @Column(name = "depname")
    private String depname;
    @Size(max = 8)
    @Column(name = "manager")
    private String manager;
    @Size(max = 8)
    @Column(name = "uplevel")
    private String uplevel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "children")
    private int children;

    public Misdept() {
    }

    public Misdept(MisdeptPK misdeptPK) {
        this.misdeptPK = misdeptPK;
    }

    public Misdept(MisdeptPK misdeptPK, String depname, int children) {
        this.misdeptPK = misdeptPK;
        this.depname = depname;
        this.children = children;
    }

    public Misdept(String facno, String depno) {
        this.misdeptPK = new MisdeptPK(facno, depno);
    }

    public MisdeptPK getMisdeptPK() {
        return misdeptPK;
    }

    public void setMisdeptPK(MisdeptPK misdeptPK) {
        this.misdeptPK = misdeptPK;
    }

    public String getDepname() {
        return depname;
    }

    public void setDepname(String depname) {
        this.depname = depname;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getUplevel() {
        return uplevel;
    }

    public void setUplevel(String uplevel) {
        this.uplevel = uplevel;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (misdeptPK != null ? misdeptPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Misdept)) {
            return false;
        }
        Misdept other = (Misdept) object;
        if ((this.misdeptPK == null && other.misdeptPK != null) || (this.misdeptPK != null && !this.misdeptPK.equals(other.misdeptPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Misdept[ misdeptPK=" + misdeptPK + " ]";
    }
    
}
