/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.plm.entity;

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
@Table(name = "plm_team")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PLMTeam.findAll", query = "SELECT p FROM PLMTeam p"),
    @NamedQuery(name = "PLMTeam.findByProjno", query = "SELECT p FROM PLMTeam p WHERE p.teamPK.projno = :projno"),
    @NamedQuery(name = "PLMTeam.findByProjrole", query = "SELECT p FROM PLMTeam p WHERE p.teamPK.projrole = :projrole"),
    @NamedQuery(name = "PLMTeam.findByTeamrole", query = "SELECT p FROM PLMTeam p WHERE p.teamPK = :teamrole"),
    @NamedQuery(name = "PLMTeam.findByUserid", query = "SELECT p FROM PLMTeam p WHERE p.teamPK.userid = :userid")})
public class PLMTeam implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PLMTeamPK teamPK;
    @Size(max = 50)
    @Column(name = "teamrole")
    private String teamrole;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "exestatus")
    private String exestatus;
    @Size(max = 256)
    @Column(name = "exedsc")
    private String exedsc;
    @Column(name = "indate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date indate;
    @Column(name = "cfmdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cfmdate;

    public PLMTeam() {
    }

    public PLMTeam(String projno, String projrole, String userid) {
        this.teamPK = new PLMTeamPK(projno, projrole, userid);
    }

    public PLMTeamPK getTeamPK() {
        return teamPK;
    }

    public void setTeamPK(PLMTeamPK teamPK) {
        this.teamPK = teamPK;
    }

    public String getTeamrole() {
        return teamrole;
    }

    public void setTeamrole(String teamrole) {
        this.teamrole = teamrole;
    }

    public String getExestatus() {
        return exestatus;
    }

    public void setExestatus(String exestatus) {
        this.exestatus = exestatus;
    }

    public String getExedsc() {
        return exedsc;
    }

    public void setExedsc(String exedsc) {
        this.exedsc = exedsc;
    }

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    public Date getCfmdate() {
        return cfmdate;
    }

    public void setCfmdate(Date cfmdate) {
        this.cfmdate = cfmdate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teamPK != null ? teamPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PLMTeam)) {
            return false;
        }
        PLMTeam other = (PLMTeam) object;
        if ((this.teamPK == null && other.teamPK != null) || (this.teamPK != null && !this.teamPK.equals(other.teamPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.plm.entity.PLMTeam[ pLMTeamPK=" + teamPK + " ]";
    }

}
