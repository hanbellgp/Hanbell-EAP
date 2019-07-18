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
public class PLMTeamPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "projno")
    private String projno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "projrole")
    private String projrole;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "userid")
    private String userid;

    public PLMTeamPK() {
    }

    public PLMTeamPK(String projno, String projrole, String userid) {
        this.projno = projno;
        this.projrole = projrole;
        this.userid = userid;
    }

    public String getProjno() {
        return projno;
    }

    public void setProjno(String projno) {
        this.projno = projno;
    }

    public String getProjrole() {
        return projrole;
    }

    public void setProjrole(String projrole) {
        this.projrole = projrole;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projno != null ? projno.hashCode() : 0);
        hash += (projrole != null ? projrole.hashCode() : 0);
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PLMTeamPK)) {
            return false;
        }
        PLMTeamPK other = (PLMTeamPK) object;
        if ((this.projno == null && other.projno != null) || (this.projno != null && !this.projno.equals(other.projno))) {
            return false;
        }
        if ((this.projrole == null && other.projrole != null) || (this.projrole != null && !this.projrole.equals(other.projrole))) {
            return false;
        }
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.plm.entity.PLMTeamPK[ projno=" + projno + ", projrole=" + projrole + ", userid=" + userid + " ]";
    }
    
}
