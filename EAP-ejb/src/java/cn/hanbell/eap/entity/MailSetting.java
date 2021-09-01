/*
 * To change this license header, choose License Headers in Project Properties. To change this template file, choose
 * Tools | Templates and open the template in the editor.
 */

package cn.hanbell.eap.entity;

import com.lightshell.comm.SuperEntity;
import java.util.UUID;
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
@Table(name = "mailsetting")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "MailSetting.findAll", query = "SELECT m FROM MailSetting m"),
    @NamedQuery(name = "MailSetting.findById", query = "SELECT m FROM MailSetting m WHERE m.id = :id"),
    @NamedQuery(name = "MailSetting.findByCompany", query = "SELECT m FROM MailSetting m WHERE m.company = :company"),
    @NamedQuery(name = "MailSetting.findByName", query = "SELECT m FROM MailSetting m WHERE m.name = :name"),
    @NamedQuery(name = "MailSetting.findByMailClazz",
        query = "SELECT m FROM MailSetting m WHERE m.mailClazz = :mailClazz"),
    @NamedQuery(name = "MailSetting.findByRemark", query = "SELECT m FROM MailSetting m WHERE m.remark = :remark"),
    @NamedQuery(name = "MailSetting.findByUid", query = "SELECT m FROM MailSetting m WHERE m.uid = :uid"),
    @NamedQuery(name = "MailSetting.findByStatus", query = "SELECT m FROM MailSetting m WHERE m.status = :status")})
public class MailSetting extends SuperEntity {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "company")
    private String company;
    @Size(max = 200)
    @Column(name = "name")
    private String name;
    @Size(max = 400)
    @Column(name = "description")
    private String description;
    @Size(max = 100)
    @Column(name = "mail_clazz")
    private String mailClazz;
    @Size(max = 45)
    @Column(name = "job_type")
    private String jobType;
    @Size(max = 200)
    @Column(name = "job_schedule")
    private String jobSchedule;
    @Size(max = 200)
    @Column(name = "remark")
    private String remark;
    @Size(max = 32)
    @Column(name = "uid")
    private String uid;

    public MailSetting() {
        this.uid = UUID.randomUUID().toString().replace("-", "");
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    public String getMailClazz() {
        return mailClazz;
    }

    public void setMailClazz(String mailClazz) {
        this.mailClazz = mailClazz;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getJobSchedule() {
        return jobSchedule;
    }

    public void setJobSchedule(String jobSchedule) {
        this.jobSchedule = jobSchedule;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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
        if (!(object instanceof MailSetting)) {
            return false;
        }
        MailSetting other = (MailSetting)object;
        if (this.id != null && other.id != null) {
            return this.id.equals(other.id);
        }
        return this.getMailClazz().equals(other.getMailClazz());
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.MailSetting[ id=" + id + " ]";
    }

}
