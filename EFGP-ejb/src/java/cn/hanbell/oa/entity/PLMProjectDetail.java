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
 * @author C0160
 */
@Entity
@Table(name = "PLM_PROJECT_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PLMProjectDetail.findAll", query = "SELECT p FROM PLMProjectDetail p"),
    @NamedQuery(name = "PLMProjectDetail.findByOID", query = "SELECT p FROM PLMProjectDetail p WHERE p.oid = :oid"),
    @NamedQuery(name = "PLMProjectDetail.findByFSN", query = "SELECT p FROM PLMProjectDetail p WHERE p.formSerialNumber = :fsn")})
public class PLMProjectDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "userId")
    private String userId;
    @Size(max = 255)
    @Column(name = "remark")
    private String remark;
    @Size(max = 255)
    @Column(name = "projrole")
    private String projrole;
    @Size(max = 255)
    @Column(name = "teamrole")
    private String teamrole;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;
    @Size(max = 255)
    @Column(name = "factory")
    private String factory;
    @Size(max = 255)
    @Column(name = "useDeptName")
    private String useDeptName;
    @Size(max = 255)
    @Column(name = "userName")
    private String userName;
    @Size(max = 255)
    @Column(name = "useDeptId")
    private String useDeptId;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "PLMNO")
    private String plmno;

    public PLMProjectDetail() {
    }

    public PLMProjectDetail(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getProjrole() {
        return projrole;
    }

    public void setProjrole(String projrole) {
        this.projrole = projrole;
    }

    public String getTeamrole() {
        return teamrole;
    }

    public void setTeamrole(String teamrole) {
        this.teamrole = teamrole;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getUseDeptName() {
        return useDeptName;
    }

    public void setUseDeptName(String useDeptName) {
        this.useDeptName = useDeptName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUseDeptId() {
        return useDeptId;
    }

    public void setUseDeptId(String useDeptId) {
        this.useDeptId = useDeptId;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getPlmno() {
        return plmno;
    }

    public void setPlmno(String plmno) {
        this.plmno = plmno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oid != null ? oid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PLMProjectDetail)) {
            return false;
        }
        PLMProjectDetail other = (PLMProjectDetail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.PLMProjectDetail[ oid=" + oid + " ]";
    }

}
