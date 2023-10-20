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
@Table(name = "EhsHiddenDangerFile")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EhsHiddenDangerFile.findAll", query = "SELECT e FROM EhsHiddenDangerFile e"),
    @NamedQuery(name = "EhsHiddenDangerFile.findById", query = "SELECT e FROM EhsHiddenDangerFile e WHERE e.id = :id"),
    @NamedQuery(name = "EhsHiddenDangerFile.findByPid", query = "SELECT e FROM EhsHiddenDangerFile e WHERE e.pid = :pid"),
    @NamedQuery(name = "EhsHiddenDangerFile.findByCompany", query = "SELECT e FROM EhsHiddenDangerFile e WHERE e.company = :company"),
    @NamedQuery(name = "EhsHiddenDangerFile.findBySeq", query = "SELECT e FROM EhsHiddenDangerFile e WHERE e.seq = :seq"),
    @NamedQuery(name = "EhsHiddenDangerFile.findByFileType", query = "SELECT e FROM EhsHiddenDangerFile e WHERE e.fileType = :fileType"),
    @NamedQuery(name = "EhsHiddenDangerFile.findByFileName", query = "SELECT e FROM EhsHiddenDangerFile e WHERE e.fileName = :fileName"),
    @NamedQuery(name = "EhsHiddenDangerFile.findByFilePath", query = "SELECT e FROM EhsHiddenDangerFile e WHERE e.filePath = :filePath"),
    @NamedQuery(name = "EhsHiddenDangerFile.findByCreateTime", query = "SELECT e FROM EhsHiddenDangerFile e WHERE e.createTime = :createTime"),
    @NamedQuery(name = "EhsHiddenDangerFile.findByCreateId", query = "SELECT e FROM EhsHiddenDangerFile e WHERE e.createId = :createId"),
    @NamedQuery(name = "EhsHiddenDangerFile.findByUpdateId", query = "SELECT e FROM EhsHiddenDangerFile e WHERE e.updateId = :updateId"),
    @NamedQuery(name = "EhsHiddenDangerFile.findByUpdateTime", query = "SELECT e FROM EhsHiddenDangerFile e WHERE e.updateTime = :updateTime")})
public class EhsHiddenDangerFile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Id")
    private String id;
    @Size(max = 30)
    @Column(name = "Pid")
    private String pid;
    @Size(max = 4)
    @Column(name = "Company")
    private String company;
    @Column(name = "Seq")
    private int seq;
    @Size(max = 30)
    @Column(name = "FileType")
    private String fileType;
    @Size(max = 30)
    @Column(name = "FileName")
    private String fileName;
    @Size(max = 200)
    @Column(name = "FilePath")
    private String filePath;
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

    public EhsHiddenDangerFile() {
    }

    public EhsHiddenDangerFile(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
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
        if (!(object instanceof EhsHiddenDangerFile)) {
            return false;
        }
        EhsHiddenDangerFile other = (EhsHiddenDangerFile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.edw.entity.EhsHiddenDangerFile[ id=" + id + " ]";
    }
    
}
