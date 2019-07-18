/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.entity;

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
 * @author C0160
 */
@Entity
@Table(name = "PLM_PROJECT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PLMProject.findAll", query = "SELECT p FROM PLMProject p"),
    @NamedQuery(name = "PLMProject.findByOID", query = "SELECT p FROM PLMProject p WHERE p.oid = :oid"),
    @NamedQuery(name = "PLMProject.findByPSN", query = "SELECT p FROM PLMProject p WHERE p.processSerialNumber = :psn"),
    @NamedQuery(name = "PLMProject.findByFSN", query = "SELECT p FROM PLMProject p WHERE p.formSerialNumber = :fsn")})
public class PLMProject implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Column(name = "startDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Size(max = 255)
    @Column(name = "useman")
    private String useman;
    @Size(max = 255)
    @Column(name = "remark")
    private String remark;
    @Size(max = 255)
    @Column(name = "projrole")
    private String projrole;
    @Size(max = 255)
    @Column(name = "hdnDept")
    private String hdnDept;
    @Size(max = 255)
    @Column(name = "projman")
    private String projman;
    @Size(max = 255)
    @Column(name = "production")
    private String production;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "hdnProjexample")
    private String hdnProjexample;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "teamrole")
    private String teamrole;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 255)
    @Column(name = "targetCost")
    private String targetCost;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "PLMNO")
    private String plmno;
    @Size(max = 255)
    @Column(name = "projno")
    private String projno;
    @Size(max = 255)
    @Column(name = "coin")
    private String coin;
    @Size(max = 255)
    @Column(name = "projtype")
    private String projtype;
    @Size(max = 255)
    @Column(name = "hdnProjrole")
    private String hdnProjrole;
    @Column(name = "finishDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finishDate;
    @Size(max = 255)
    @Column(name = "useDept")
    private String useDept;
    @Size(max = 255)
    @Column(name = "projname")
    private String projname;
    @Size(max = 255)
    @Column(name = "hdnProduction")
    private String hdnProduction;
    @Column(name = "applyDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date applyDate;
    @Size(max = 255)
    @Column(name = "applyUser")
    private String applyUser;
    @Size(max = 255)
    @Column(name = "applyDept")
    private String applyDept;
    @Size(max = 255)
    @Column(name = "projexample")
    private String projexample;
    @Size(max = 255)
    @Column(name = "factory")
    private String factory;
    @Size(max = 255)
    @Column(name = "useNature")
    private String useNature;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;

    public PLMProject() {
    }

    public PLMProject(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getUseman() {
        return useman;
    }

    public void setUseman(String useman) {
        this.useman = useman;
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

    public String getHdnDept() {
        return hdnDept;
    }

    public void setHdnDept(String hdnDept) {
        this.hdnDept = hdnDept;
    }

    public String getProjman() {
        return projman;
    }

    public void setProjman(String projman) {
        this.projman = projman;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getHdnProjexample() {
        return hdnProjexample;
    }

    public void setHdnProjexample(String hdnProjexample) {
        this.hdnProjexample = hdnProjexample;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getTeamrole() {
        return teamrole;
    }

    public void setTeamrole(String teamrole) {
        this.teamrole = teamrole;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTargetCost() {
        return targetCost;
    }

    public void setTargetCost(String targetCost) {
        this.targetCost = targetCost;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getPlmno() {
        return plmno;
    }

    public void setPlmno(String plmno) {
        this.plmno = plmno;
    }

    public String getProjno() {
        return projno;
    }

    public void setProjno(String projno) {
        this.projno = projno;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getProjtype() {
        return projtype;
    }

    public void setProjtype(String projtype) {
        this.projtype = projtype;
    }

    public String getHdnProjrole() {
        return hdnProjrole;
    }

    public void setHdnProjrole(String hdnProjrole) {
        this.hdnProjrole = hdnProjrole;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public String getUseDept() {
        return useDept;
    }

    public void setUseDept(String useDept) {
        this.useDept = useDept;
    }

    public String getProjname() {
        return projname;
    }

    public void setProjname(String projname) {
        this.projname = projname;
    }

    public String getHdnProduction() {
        return hdnProduction;
    }

    public void setHdnProduction(String hdnProduction) {
        this.hdnProduction = hdnProduction;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getApplyDept() {
        return applyDept;
    }

    public void setApplyDept(String applyDept) {
        this.applyDept = applyDept;
    }

    public String getProjexample() {
        return projexample;
    }

    public void setProjexample(String projexample) {
        this.projexample = projexample;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getUseNature() {
        return useNature;
    }

    public void setUseNature(String useNature) {
        this.useNature = useNature;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
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
        if (!(object instanceof PLMProject)) {
            return false;
        }
        PLMProject other = (PLMProject) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.PLMProject[ oid=" + oid + " ]";
    }

}
