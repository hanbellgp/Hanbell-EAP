/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.plm.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author C0160
 */
@Embeddable
public class PLMProjectPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "projno")
    private String projno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "projname")
    private String projname;

    public PLMProjectPK() {
    }

    public PLMProjectPK(String projno, String projname) {
        this.projno = projno;
        this.projname = projname;
    }

    public String getProjno() {
        return projno;
    }

    public void setProjno(String projno) {
        this.projno = projno;
    }

    public String getProjname() {
        return projname;
    }

    public void setProjname(String projname) {
        this.projname = projname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projno != null ? projno.hashCode() : 0);
        hash += (projname != null ? projname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PLMProjectPK)) {
            return false;
        }
        PLMProjectPK other = (PLMProjectPK) object;
        if ((this.projno == null && other.projno != null) || (this.projno != null && !this.projno.equals(other.projno))) {
            return false;
        }
        if ((this.projname == null && other.projname != null) || (this.projname != null && !this.projname.equals(other.projname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.plm.entity.PLMProjectPK[ projno=" + projno + ", projname=" + projname + " ]";
    }
    
}
