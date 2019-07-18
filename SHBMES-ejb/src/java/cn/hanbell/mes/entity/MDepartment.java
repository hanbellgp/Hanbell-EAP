/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.mes.entity;

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
@Table(name = "MDEPARTMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MDepartment.findAll", query = "SELECT m FROM MDepartment m"),
    @NamedQuery(name = "MDepartment.findByDepartmentid", query = "SELECT m FROM MDepartment m WHERE m.departmentid = :departmentid"),
    @NamedQuery(name = "MDepartment.findByDepartmentname", query = "SELECT m FROM MDepartment m WHERE m.departmentname = :departmentname"),
    @NamedQuery(name = "MDepartment.findByPdepartmentid", query = "SELECT m FROM MDepartment m WHERE m.pdepartmentid = :pdepartmentid")})
public class MDepartment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "SYSID")
    private String sysid;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DEPARTMENTID")
    private String departmentid;
    @Size(max = 200)
    @Column(name = "DEPARTMENTNAME")
    private String departmentname;
    @Size(max = 200)
    @Column(name = "PDEPARTMENTID")
    private String pdepartmentid;
    @Size(max = 800)
    @Column(name = "PARAMETER")
    private String parameter;
    @Size(max = 80)
    @Column(name = "SEQUENCES")
    private String sequences;
    @Size(max = 800)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 80)
    @Column(name = "MODIFYUSERID")
    private String modifyuserid;
    @Size(max = 80)
    @Column(name = "MODIFYUSER")
    private String modifyuser;
    @Size(max = 80)
    @Column(name = "MODIFYTIME")
    private String modifytime;

    public MDepartment() {
    }

    public MDepartment(String departmentid) {
        this.departmentid = departmentid;
    }

    public MDepartment(String departmentid, String sysid) {
        this.departmentid = departmentid;
        this.sysid = sysid;
    }

    public String getSysid() {
        return sysid;
    }

    public void setSysid(String sysid) {
        this.sysid = sysid;
    }

    public String getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(String departmentid) {
        this.departmentid = departmentid;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    public String getPdepartmentid() {
        return pdepartmentid;
    }

    public void setPdepartmentid(String pdepartmentid) {
        this.pdepartmentid = pdepartmentid;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getSequences() {
        return sequences;
    }

    public void setSequences(String sequences) {
        this.sequences = sequences;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModifyuserid() {
        return modifyuserid;
    }

    public void setModifyuserid(String modifyuserid) {
        this.modifyuserid = modifyuserid;
    }

    public String getModifyuser() {
        return modifyuser;
    }

    public void setModifyuser(String modifyuser) {
        this.modifyuser = modifyuser;
    }

    public String getModifytime() {
        return modifytime;
    }

    public void setModifytime(String modifytime) {
        this.modifytime = modifytime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (departmentid != null ? departmentid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MDepartment)) {
            return false;
        }
        MDepartment other = (MDepartment) object;
        if ((this.departmentid == null && other.departmentid != null) || (this.departmentid != null && !this.departmentid.equals(other.departmentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.mes.entity.MDepartment[ departmentid=" + departmentid + " ]";
    }

}
