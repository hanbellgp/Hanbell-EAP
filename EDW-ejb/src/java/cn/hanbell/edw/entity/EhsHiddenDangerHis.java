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
@Table(name = "EhsHiddenDangerHis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EhsHiddenDangerHis.findAll", query = "SELECT e FROM EhsHiddenDangerHis e"),
    @NamedQuery(name = "EhsHiddenDangerHis.findById", query = "SELECT e FROM EhsHiddenDangerHis e WHERE e.id = :id"),
    @NamedQuery(name = "EhsHiddenDangerHis.findByCompany", query = "SELECT e FROM EhsHiddenDangerHis e WHERE e.company = :company"),
    @NamedQuery(name = "EhsHiddenDangerHis.findByPid", query = "SELECT e FROM EhsHiddenDangerHis e WHERE e.pid = :pid"),
    @NamedQuery(name = "EhsHiddenDangerHis.findByCurNode", query = "SELECT e FROM EhsHiddenDangerHis e WHERE e.curNode = :curNode"),
    @NamedQuery(name = "EhsHiddenDangerHis.findByCreateTime", query = "SELECT e FROM EhsHiddenDangerHis e WHERE e.createTime = :createTime"),
    @NamedQuery(name = "EhsHiddenDangerHis.findByCreateId", query = "SELECT e FROM EhsHiddenDangerHis e WHERE e.createId = :createId"),
    @NamedQuery(name = "EhsHiddenDangerHis.findByUpdateId", query = "SELECT e FROM EhsHiddenDangerHis e WHERE e.updateId = :updateId") })
public class EhsHiddenDangerHis implements Serializable {

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
    @Column(name = "Pid")
    private String pid;
    @Size(max = 4)
    @Column(name = "Seq")
    private String seq;
    @Size(max = 200)
    @Column(name = "CurNode")
    private String curNode;
    @Size(max = 30)
    @Column(name = "UserNo")
    private String userNo;
    @Size(max = 30)
    @Column(name = "UserName")
    private String userName;
    @Size(max = 30)
    @Column(name = "Contenct")
    private String contenct;
    @Size(max = 30)
    @Column(name = "Note")
    private String note;
    @Column(name = "CreateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Size(max = 30)
    @Column(name = "CreateId")
    private String createId;
    @Size(max = 30)
    @Column(name = "UpdateId")
    private String updateId;

    public EhsHiddenDangerHis() {
    }

    public EhsHiddenDangerHis(String id) {
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

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getCurNode() {
        return curNode;
    }

    public void setCurNode(String curNode) {
        this.curNode = curNode;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContenct() {
        return contenct;
    }

    public void setContenct(String contenct) {
        this.contenct = contenct;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EhsHiddenDangerHis)) {
            return false;
        }
        EhsHiddenDangerHis other = (EhsHiddenDangerHis) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.edw.entity.EhsHiddenDangerHis[ id=" + id + " ]";
    }

}
