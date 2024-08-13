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
@Table(name = "EhsHiddenDanger")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EhsHiddenDanger.findAll", query = "SELECT e FROM EhsHiddenDanger e"),
    @NamedQuery(name = "EhsHiddenDanger.findById", query = "SELECT e FROM EhsHiddenDanger e WHERE e.id = :id"),
    @NamedQuery(name = "EhsHiddenDanger.findByCompany", query = "SELECT e FROM EhsHiddenDanger e WHERE e.company = :company"),
    @NamedQuery(name = "EhsHiddenDanger.findByHiddenSource", query = "SELECT e FROM EhsHiddenDanger e WHERE e.hiddenSource = :hiddenSource"),
    @NamedQuery(name = "EhsHiddenDanger.findByHiddenLocation", query = "SELECT e FROM EhsHiddenDanger e WHERE e.hiddenLocation = :hiddenLocation"),
    @NamedQuery(name = "EhsHiddenDanger.findByHiddenDescribe", query = "SELECT e FROM EhsHiddenDanger e WHERE e.hiddenDescribe = :hiddenDescribe"),
    @NamedQuery(name = "EhsHiddenDanger.findByPresentingId", query = "SELECT e FROM EhsHiddenDanger e WHERE e.presentingId = :presentingId"),
    @NamedQuery(name = "EhsHiddenDanger.findByPresentingName", query = "SELECT e FROM EhsHiddenDanger e WHERE e.presentingName = :presentingName"),
    @NamedQuery(name = "EhsHiddenDanger.findByRectifierId", query = "SELECT e FROM EhsHiddenDanger e WHERE e.rectifierId = :rectifierId"),
    @NamedQuery(name = "EhsHiddenDanger.findByRectifierName", query = "SELECT e FROM EhsHiddenDanger e WHERE e.rectifierName = :rectifierName"),
    @NamedQuery(name = "EhsHiddenDanger.findByHiddenType", query = "SELECT e FROM EhsHiddenDanger e WHERE e.hiddenType = :hiddenType"),
    @NamedQuery(name = "EhsHiddenDanger.findByRectificationType", query = "SELECT e FROM EhsHiddenDanger e WHERE e.rectificationType = :rectificationType"),
    @NamedQuery(name = "EhsHiddenDanger.findByRectificationDeadline", query = "SELECT e FROM EhsHiddenDanger e WHERE e.rectificationDeadline = :rectificationDeadline"),
    @NamedQuery(name = "EhsHiddenDanger.findByRectificationMeasures", query = "SELECT e FROM EhsHiddenDanger e WHERE e.rectificationMeasures = :rectificationMeasures"),
    @NamedQuery(name = "EhsHiddenDanger.findByRectificationCompletionDate", query = "SELECT e FROM EhsHiddenDanger e WHERE e.rectificationCompletionDate = :rectificationCompletionDate"),
    @NamedQuery(name = "EhsHiddenDanger.findByAcceptedId", query = "SELECT e FROM EhsHiddenDanger e WHERE e.acceptedId = :acceptedId"),
    @NamedQuery(name = "EhsHiddenDanger.findByAcceptedName", query = "SELECT e FROM EhsHiddenDanger e WHERE e.acceptedName = :acceptedName"),
    @NamedQuery(name = "EhsHiddenDanger.findByAcceptanceOpinions", query = "SELECT e FROM EhsHiddenDanger e WHERE e.acceptanceOpinions = :acceptanceOpinions"),
    @NamedQuery(name = "EhsHiddenDanger.findByCheckName", query = "SELECT e FROM EhsHiddenDanger e WHERE e.checkName = :checkName"),
    @NamedQuery(name = "EhsHiddenDanger.findByCheckOpinions", query = "SELECT e FROM EhsHiddenDanger e WHERE e.checkOpinions = :checkOpinions"),
    @NamedQuery(name = "EhsHiddenDanger.findByUpdateTime", query = "SELECT e FROM EhsHiddenDanger e WHERE e.updateTime = :updateTime"),
    @NamedQuery(name = "EhsHiddenDanger.findByRstatus", query = "SELECT e FROM EhsHiddenDanger e WHERE e.rstatus = :rstatus"),
    @NamedQuery(name = "EhsHiddenDanger.findByStatus", query = "SELECT e FROM EhsHiddenDanger e WHERE e.status = :status"),
    @NamedQuery(name = "EhsHiddenDanger.findByCreateTime", query = "SELECT e FROM EhsHiddenDanger e WHERE e.createTime = :createTime"),
    @NamedQuery(name = "EhsHiddenDanger.findByCreateId", query = "SELECT e FROM EhsHiddenDanger e WHERE e.createId = :createId"),
    @NamedQuery(name = "EhsHiddenDanger.findByUpdateId", query = "SELECT e FROM EhsHiddenDanger e WHERE e.updateId = :updateId"),
    @NamedQuery(name = "EhsHiddenDanger.findByCheckId", query = "SELECT e FROM EhsHiddenDanger e WHERE e.checkId = :checkId")})
public class EhsHiddenDanger implements Serializable {

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
    @Size(max = 40)
    @Column(name = "HiddenSource")
    private String hiddenSource;
    @Size(max = 100)
    @Column(name = "HiddenLocation")
    private String hiddenLocation;
    @Size(max = 200)
    @Column(name = "HiddenDescribe")
    private String hiddenDescribe;
    @Size(max = 30)
    @Column(name = "PresentingId")
    private String presentingId;
    @Size(max = 30)
    @Column(name = "PresentingName")
    private String presentingName;
    @Size(max = 30)
    @Column(name = "RectifierId")
    private String rectifierId;
    @Size(max = 30)
    @Column(name = "RectifierName")
    private String rectifierName;
    @Size(max = 20)
    @Column(name = "HiddenType")
    private String hiddenType;
    @Size(max = 20)
    @Column(name = "RectificationType")
    private String rectificationType;
    @Column(name = "RectificationDeadline")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rectificationDeadline;
    @Size(max = 200)
    @Column(name = "RectificationMeasures")
    private String rectificationMeasures;
    @Column(name = "RectificationCompletionDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rectificationCompletionDate;
    @Size(max = 30)
    @Column(name = "AcceptedId")
    private String acceptedId;
    @Size(max = 30)
    @Column(name = "AcceptedName")
    private String acceptedName;
    @Size(max = 200)
    @Column(name = "AcceptanceOpinions")
    private String acceptanceOpinions;
    @Size(max = 30)
    @Column(name = "CheckName")
    private String checkName;
    @Size(max = 200)
    @Column(name = "CheckOpinions")
    private String checkOpinions;
    @Column(name = "UpdateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @Size(max = 10)
    @Column(name = "Rstatus")
    private String rstatus;
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
    @Size(max = 30)
    @Column(name = "CheckId")
    private String checkId;
    @Size(max = 200)
    @Column(name = "RectificationReasons")
    private String rectificationReasons;

    public EhsHiddenDanger() {
    }

    public EhsHiddenDanger(String id) {
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

    public String getHiddenSource() {
        return hiddenSource;
    }

    public void setHiddenSource(String hiddenSource) {
        this.hiddenSource = hiddenSource;
    }

    public String getHiddenLocation() {
        return hiddenLocation;
    }

    public void setHiddenLocation(String hiddenLocation) {
        this.hiddenLocation = hiddenLocation;
    }

    public String getHiddenDescribe() {
        return hiddenDescribe;
    }

    public void setHiddenDescribe(String hiddenDescribe) {
        this.hiddenDescribe = hiddenDescribe;
    }

    public String getPresentingId() {
        return presentingId;
    }

    public void setPresentingId(String presentingId) {
        this.presentingId = presentingId;
    }

    public String getPresentingName() {
        return presentingName;
    }

    public void setPresentingName(String presentingName) {
        this.presentingName = presentingName;
    }

    public String getRectifierId() {
        return rectifierId;
    }

    public void setRectifierId(String rectifierId) {
        this.rectifierId = rectifierId;
    }

    public String getRectifierName() {
        return rectifierName;
    }

    public void setRectifierName(String rectifierName) {
        this.rectifierName = rectifierName;
    }

    public String getHiddenType() {
        return hiddenType;
    }

    public void setHiddenType(String hiddenType) {
        this.hiddenType = hiddenType;
    }

    public String getRectificationType() {
        return rectificationType;
    }

    public void setRectificationType(String rectificationType) {
        this.rectificationType = rectificationType;
    }

    public Date getRectificationDeadline() {
        return rectificationDeadline;
    }

    public void setRectificationDeadline(Date rectificationDeadline) {
        this.rectificationDeadline = rectificationDeadline;
    }

    public String getRectificationMeasures() {
        return rectificationMeasures;
    }

    public void setRectificationMeasures(String rectificationMeasures) {
        this.rectificationMeasures = rectificationMeasures;
    }

    public Date getRectificationCompletionDate() {
        return rectificationCompletionDate;
    }

    public void setRectificationCompletionDate(Date rectificationCompletionDate) {
        this.rectificationCompletionDate = rectificationCompletionDate;
    }

    public String getAcceptedId() {
        return acceptedId;
    }

    public void setAcceptedId(String acceptedId) {
        this.acceptedId = acceptedId;
    }

    public String getAcceptedName() {
        return acceptedName;
    }

    public void setAcceptedName(String acceptedName) {
        this.acceptedName = acceptedName;
    }

    public String getAcceptanceOpinions() {
        return acceptanceOpinions;
    }

    public void setAcceptanceOpinions(String acceptanceOpinions) {
        this.acceptanceOpinions = acceptanceOpinions;
    }

    public String getCheckName() {
        return checkName;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName;
    }

    public String getCheckOpinions() {
        return checkOpinions;
    }

    public void setCheckOpinions(String checkOpinions) {
        this.checkOpinions = checkOpinions;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRstatus() {
        return rstatus;
    }

    public void setRstatus(String rstatus) {
        this.rstatus = rstatus;
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

    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public String getRectificationReasons() {
        return rectificationReasons;
    }

    public void setRectificationReasons(String rectificationReasons) {
        this.rectificationReasons = rectificationReasons;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EhsHiddenDanger)) {
            return false;
        }
        EhsHiddenDanger other = (EhsHiddenDanger) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.edw.entity.EhsHiddenDanger[ id=" + id + " ]";
    }

}
