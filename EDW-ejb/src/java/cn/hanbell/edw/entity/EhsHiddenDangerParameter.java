/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.edw.entity;

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
 * @author Administrator
 */
@Entity
@Table(name = "EhsHiddenDangerParameter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EhsHiddenDangerParameter.findAll", query = "SELECT e FROM EhsHiddenDangerParameter e"),
    @NamedQuery(name = "EhsHiddenDangerParameter.findById", query = "SELECT e FROM EhsHiddenDangerParameter e WHERE e.id = :id"),
    @NamedQuery(name = "EhsHiddenDangerParameter.findByCompany", query = "SELECT e FROM EhsHiddenDangerParameter e WHERE e.company = :company"),
    @NamedQuery(name = "EhsHiddenDangerParameter.findBySyskind", query = "SELECT e FROM EhsHiddenDangerParameter e WHERE e.syskind = :syskind"),
    @NamedQuery(name = "EhsHiddenDangerParameter.findByParameterCode", query = "SELECT e FROM EhsHiddenDangerParameter e WHERE e.parameterCode = :parameterCode"),
    @NamedQuery(name = "EhsHiddenDangerParameter.findByParameterValue", query = "SELECT e FROM EhsHiddenDangerParameter e WHERE e.parameterValue = :parameterValue"),
    @NamedQuery(name = "EhsHiddenDangerParameter.findByParameterName", query = "SELECT e FROM EhsHiddenDangerParameter e WHERE e.parameterName = :parameterName"),
    @NamedQuery(name = "EhsHiddenDangerParameter.findByStatus", query = "SELECT e FROM EhsHiddenDangerParameter e WHERE e.status = :status"),
    @NamedQuery(name = "EhsHiddenDangerParameter.findByCreateTime", query = "SELECT e FROM EhsHiddenDangerParameter e WHERE e.createTime = :createTime"),
    @NamedQuery(name = "EhsHiddenDangerParameter.findByCreateId", query = "SELECT e FROM EhsHiddenDangerParameter e WHERE e.createId = :createId"),
    @NamedQuery(name = "EhsHiddenDangerParameter.findByUpdateId", query = "SELECT e FROM EhsHiddenDangerParameter e WHERE e.updateId = :updateId"),
    @NamedQuery(name = "EhsHiddenDangerParameter.findBySyskindAndCodeAndCompany", query = "SELECT e FROM EhsHiddenDangerParameter e WHERE e.syskind = :syskind And e.parameterCode = :parameterCode AND e.company = :company "),
    @NamedQuery(name = "EhsHiddenDangerParameter.findByUpdateTime", query = "SELECT e FROM EhsHiddenDangerParameter e WHERE e.updateTime = :updateTime")})
public class EhsHiddenDangerParameter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Id")
    private String id;
    @Size(max = 4)
    @Column(name = "Company")
    private String company;
    @Size(max = 30)
    @Column(name = "Syskind")
    private String syskind;
    @Size(max = 30)
    @Column(name = "ParameterCode")
    private String parameterCode;
    @Size(max = 30)
    @Column(name = "ParameterValue")
    private String parameterValue;
    @Size(max = 100)
    @Column(name = "ParameterName")
    private String parameterName;
    @Size(max = 10)
    @Column(name = "Status")
    private String status;
    @Column(name = "CreateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Size(max = 30)
    @Column(name = "CreateId")
    private String createId;
    @Size(max = 30)
    @Column(name = "UpdateId")
    private String updateId;
    @Column(name = "UpdateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    public EhsHiddenDangerParameter() {
    }

    public EhsHiddenDangerParameter(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSyskind() {
        return syskind;
    }

    public void setSyskind(String syskind) {
        this.syskind = syskind;
    }

    public String getParameterCode() {
        return parameterCode;
    }

    public void setParameterCode(String parameterCode) {
        this.parameterCode = parameterCode;
    }

    public String getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EhsHiddenDangerParameter)) {
            return false;
        }
        EhsHiddenDangerParameter other = (EhsHiddenDangerParameter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.edw.entity.EhsHiddenDangerParameter[ id=" + id + " ]";
    }

}
