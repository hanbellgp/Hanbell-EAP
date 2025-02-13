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
import javax.persistence.Lob;
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
 * @author C2082
 */
@Entity
@Table(name = "EdwAMT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EdwAMT.findAll", query = "SELECT e FROM EdwAMT e"),
    @NamedQuery(name = "EdwAMT.findById", query = "SELECT e FROM EdwAMT e WHERE e.id = :id"),
    @NamedQuery(name = "EdwAMT.findBySysno", query = "SELECT e FROM EdwAMT e WHERE e.sysno = :sysno"),
    @NamedQuery(name = "EdwAMT.findByUrl", query = "SELECT e FROM EdwAMT e WHERE e.url = :url"),
    @NamedQuery(name = "EdwAMT.findByFTime", query = "SELECT e FROM EdwAMT e WHERE e.fTime = :fTime"),
    @NamedQuery(name = "EdwAMT.findByDsc", query = "SELECT e FROM EdwAMT e WHERE e.dsc = :dsc"),
    @NamedQuery(name = "EdwAMT.findByRTime", query = "SELECT e FROM EdwAMT e WHERE e.rTime = :rTime"),
    @NamedQuery(name = "EdwAMT.findByRNum", query = "SELECT e FROM EdwAMT e WHERE e.rNum = :rNum"),
    @NamedQuery(name = "EdwAMT.findByReqId", query = "SELECT e FROM EdwAMT e WHERE e.reqId = :reqId"),
    @NamedQuery(name = "EdwAMT.findByStatus", query = "SELECT e FROM EdwAMT e WHERE e.status = :status"),
    @NamedQuery(name = "EdwAMT.findByReqType", query = "SELECT e FROM EdwAMT e WHERE e.reqType = :reqType"),
    @NamedQuery(name = "EdwAMT.findByReqUserno", query = "SELECT e FROM EdwAMT e WHERE e.reqUserno = :reqUserno"),
    @NamedQuery(name = "EdwAMT.findByReqIP", query = "SELECT e FROM EdwAMT e WHERE e.reqIP = :reqIP"),
    @NamedQuery(name = "EdwAMT.findByIsAuth", query = "SELECT e FROM EdwAMT e WHERE e.isAuth = :isAuth"),
    @NamedQuery(name = "EdwAMT.findByCTime", query = "SELECT e FROM EdwAMT e WHERE e.cTime = :cTime"),
    @NamedQuery(name = "EdwAMT.findByRType", query = "SELECT e FROM EdwAMT e WHERE e.rType = :rType"),
    @NamedQuery(name = "EdwAMT.findByMsg", query = "SELECT e FROM EdwAMT e WHERE e.msg = :msg"),
    @NamedQuery(name = "EdwAMT.findByHttpCode", query = "SELECT e FROM EdwAMT e WHERE e.httpCode = :httpCode"),
    @NamedQuery(name = "EdwAMT.findByHttpDesc", query = "SELECT e FROM EdwAMT e WHERE e.httpDesc = :httpDesc")})
public class EdwAMT implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "Id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Sysno")
    private String sysno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Url")
    private String url;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fTime;
    @Size(max = 128)
    @Column(name = "Dsc")
    private String dsc;
    @Column(name = "RTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rTime;
    @Column(name = "RNum")
    private Integer rNum;
    @Size(max = 64)
    @Column(name = "ReqId")
    private String reqId;
    @Size(max = 2)
    @Column(name = "Status")
    private String status;
    @Lob
    @Column(name = "ReqContent")
    private String reqContent;
    @Size(max = 30)
    @Column(name = "ReqType")
    private String reqType;
    @Size(max = 16)
    @Column(name = "ReqUserno")
    private String reqUserno;
    @Size(max = 16)
    @Column(name = "ReqIP")
    private String reqIP;
    @Lob
    @Column(name = "ResContent")
    private String resContent;
    @Size(max = 2)
    @Column(name = "IsAuth")
    private String isAuth;
    @Column(name = "CTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cTime;
    @Size(max = 2)
    @Column(name = "RType")
    private String rType;
    @Size(max = 2048)
    @Column(name = "Msg")
    private String msg;
    @Lob
    @Column(name = "MsgContent")
    private String msgContent;
    @Lob
    @Column(name = "Error")
    private String error;
    @Column(name = "HttpCode")
    private Integer httpCode;
    @Size(max = 255)
    @Column(name = "HttpDesc")
    private String httpDesc;
    @Size(max = 255)
    @Column(name = "ComType")
    private String comType;
    public EdwAMT() {
    }

    public EdwAMT(String id) {
        this.id = id;
    }

    public EdwAMT(String id, String sysno, String url, Date fTime) {
        this.id = id;
        this.sysno = sysno;
        this.url = url;
        this.fTime = fTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSysno() {
        return sysno;
    }

    public void setSysno(String sysno) {
        this.sysno = sysno;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getFTime() {
        return fTime;
    }

    public void setFTime(Date fTime) {
        this.fTime = fTime;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    public Date getRTime() {
        return rTime;
    }

    public void setRTime(Date rTime) {
        this.rTime = rTime;
    }

    public Integer getRNum() {
        return rNum;
    }

    public void setRNum(Integer rNum) {
        this.rNum = rNum;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReqContent() {
        return reqContent;
    }

    public void setReqContent(String reqContent) {
        this.reqContent = reqContent;
    }

    public String getReqType() {
        return reqType;
    }

    public void setReqType(String reqType) {
        this.reqType = reqType;
    }

    public String getReqUserno() {
        return reqUserno;
    }

    public void setReqUserno(String reqUserno) {
        this.reqUserno = reqUserno;
    }

    public String getReqIP() {
        return reqIP;
    }

    public void setReqIP(String reqIP) {
        this.reqIP = reqIP;
    }

    public String getResContent() {
        return resContent;
    }

    public void setResContent(String resContent) {
        this.resContent = resContent;
    }

    public String getIsAuth() {
        return isAuth;
    }

    public void setIsAuth(String isAuth) {
        this.isAuth = isAuth;
    }

    public Date getCTime() {
        return cTime;
    }

    public void setCTime(Date cTime) {
        this.cTime = cTime;
    }

    public String getRType() {
        return rType;
    }

    public void setRType(String rType) {
        this.rType = rType;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Integer getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(Integer httpCode) {
        this.httpCode = httpCode;
    }

    public String getHttpDesc() {
        return httpDesc;
    }

    public void setHttpDesc(String httpDesc) {
        this.httpDesc = httpDesc;
    }

    public Date getfTime() {
        return fTime;
    }

    public void setfTime(Date fTime) {
        this.fTime = fTime;
    }

    public Date getrTime() {
        return rTime;
    }

    public void setrTime(Date rTime) {
        this.rTime = rTime;
    }

    public Integer getrNum() {
        return rNum;
    }

    public void setrNum(Integer rNum) {
        this.rNum = rNum;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public String getComType() {
        return comType;
    }

    public void setComType(String comType) {
        this.comType = comType;
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
        if (!(object instanceof EdwAMT)) {
            return false;
        }
        EdwAMT other = (EdwAMT) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.edw.entity.EdwAMT[ id=" + id + " ]";
    }
    
}
