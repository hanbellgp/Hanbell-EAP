/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

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
 * @author Administrator
 */
@Entity
@Table(name = "crmusergroup")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CrmUserGroup.findAll", query = "SELECT c FROM CrmUserGroup c"),
    @NamedQuery(name = "CrmUserGroup.findByUserid", query = "SELECT c FROM CrmUserGroup c WHERE c.userid = :userid"),
    @NamedQuery(name = "CrmUserGroup.findByUsername", query = "SELECT c FROM CrmUserGroup c WHERE c.username = :username"),
    @NamedQuery(name = "CrmUserGroup.findByJob", query = "SELECT c FROM CrmUserGroup c WHERE c.job = :job"),
    @NamedQuery(name = "CrmUserGroup.findByLevelId", query = "SELECT c FROM CrmUserGroup c WHERE c.levelId = :levelId"),
    @NamedQuery(name = "CrmUserGroup.findByDecisionLevel", query = "SELECT c FROM CrmUserGroup c WHERE c.decisionLevel = :decisionLevel"),
    @NamedQuery(name = "CrmUserGroup.findByDeptno", query = "SELECT c FROM CrmUserGroup c WHERE c.deptno = :deptno"),
    @NamedQuery(name = "CrmUserGroup.findByDeptName", query = "SELECT c FROM CrmUserGroup c WHERE c.deptName = :deptName"),
    @NamedQuery(name = "CrmUserGroup.findByStatus", query = "SELECT c FROM CrmUserGroup c WHERE c.status = :status")})
public class CrmUserGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "userid")
    private String userid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "username")
    private String username;
    @Size(max = 45)
    @Column(name = "job")
    private String job;
    @Size(max = 20)
    @Column(name = "levelId")
    private String levelId;
    @Size(max = 45)
    @Column(name = "decisionLevel")
    private String decisionLevel;
    @Size(max = 20)
    @Column(name = "deptno")
    private String deptno;
    @Size(max = 45)
    @Column(name = "deptName")
    private String deptName;
    @Size(max = 2)
    @Column(name = "company")
    private String company;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "status")
    private String status;

    public CrmUserGroup() {
    }

    public CrmUserGroup(String userid) {
        this.userid = userid;
    }

    public CrmUserGroup(String userid, String username, String status) {
        this.userid = userid;
        this.username = username;
        this.status = status;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId;
    }

    public String getDecisionLevel() {
        return decisionLevel;
    }

    public void setDecisionLevel(String decisionLevel) {
        this.decisionLevel = decisionLevel;
    }

    public String getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CrmUserGroup)) {
            return false;
        }
        CrmUserGroup other = (CrmUserGroup) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.CrmUserGroup[ userid=" + userid + " ]";
    }
    
}
