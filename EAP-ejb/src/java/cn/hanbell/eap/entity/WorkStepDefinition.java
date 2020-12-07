/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import com.lightshell.comm.SuperDetailEntity;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
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
@Table(name = "workstepdefinition")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WorkStepDefinition.findAll", query = "SELECT w FROM WorkStepDefinition w"),
    @NamedQuery(name = "WorkStepDefinition.findById", query = "SELECT w FROM WorkStepDefinition w WHERE w.id = :id"),
    @NamedQuery(name = "WorkStepDefinition.findByPId", query = "SELECT w FROM WorkStepDefinition w WHERE w.pid = :pid ORDER BY w.seq")})
public class WorkStepDefinition extends SuperDetailEntity {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @Size(max = 45)
    @Column(name = "prevStep")
    private String prevStep;
    @Size(max = 45)
    @Column(name = "nextStep")
    private String nextStep;
    @Size(max = 200)
    @Column(name = "remark")
    private String remark;

    public WorkStepDefinition() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrevStep() {
        return prevStep;
    }

    public void setPrevStep(String prevStep) {
        this.prevStep = prevStep;
    }

    public String getNextStep() {
        return nextStep;
    }

    public void setNextStep(String nextStep) {
        this.nextStep = nextStep;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
        if (!(object instanceof WorkStepDefinition)) {
            return false;
        }
        WorkStepDefinition other = (WorkStepDefinition) object;
        if (this.id != null && other.id != null) {
            return Objects.equals(this.id, other.id);
        }
        return Objects.equals(this.pid, other.pid) && Objects.equals(this.seq, other.seq);
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.WorkStepDefinition[ id=" + id + " ]";
    }

}
