/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import com.lightshell.comm.SuperDetailEntity;
import java.util.Objects;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "taskparticipant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TaskParticipant.findAll", query = "SELECT t FROM TaskParticipant t"),
    @NamedQuery(name = "TaskParticipant.findById", query = "SELECT t FROM TaskParticipant t WHERE t.id = :id"),
    @NamedQuery(name = "TaskParticipant.findByPId", query = "SELECT t FROM TaskParticipant t WHERE t.pid = :pid"),
    @NamedQuery(name = "TaskParticipant.findByParticipantId", query = "SELECT t FROM TaskParticipant t WHERE t.participantId = :participantId"),
    @NamedQuery(name = "TaskParticipant.findByParticipant", query = "SELECT t FROM TaskParticipant t WHERE t.participant = :participant"),
    @NamedQuery(name = "TaskParticipant.findByDeptId", query = "SELECT t FROM TaskParticipant t WHERE t.deptId = :deptId"),
    @NamedQuery(name = "TaskParticipant.findByDept", query = "SELECT t FROM TaskParticipant t WHERE t.dept = :dept")})
public class TaskParticipant extends SuperDetailEntity {

    @JsonbTransient
    @ManyToOne(optional = false)
    @JoinColumn(name = "pid", referencedColumnName = "id", insertable = false, updatable = false)
    private Task task;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "participantId")
    private String participantId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "participant")
    private String participant;
    @Size(max = 20)
    @Column(name = "deptId")
    private String deptId;
    @Size(max = 45)
    @Column(name = "dept")
    private String dept;

    public TaskParticipant() {
    }

    /**
     * @return the task
     */
    public Task getTask() {
        return task;
    }

    public String getParticipantId() {
        return participantId;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }

    public String getParticipant() {
        return participant;
    }

    public void setParticipant(String participant) {
        this.participant = participant;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
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
        if (!(object instanceof TaskParticipant)) {
            return false;
        }
        TaskParticipant other = (TaskParticipant) object;
        if (this.id != null && other.id != null) {
            return Objects.equals(this.id, other.id);
        }
        return Objects.equals(this.pid, other.pid) && Objects.equals(this.seq, other.seq);
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.TaskParticipant[ id=" + id + " ]";
    }

}
