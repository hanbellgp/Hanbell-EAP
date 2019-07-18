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
@Table(name = "MUSER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MUser.findAll", query = "SELECT m FROM MUser m"),
    @NamedQuery(name = "MUser.findByUserid", query = "SELECT m FROM MUser m WHERE m.userid = :userid"),
    @NamedQuery(name = "MUser.findByUsername", query = "SELECT m FROM MUser m WHERE m.username = :username"),
    @NamedQuery(name = "MUser.findByPassword", query = "SELECT m FROM MUser m WHERE m.password = :password"),
    @NamedQuery(name = "MUser.findByStatus", query = "SELECT m FROM MUser m WHERE m.status = :status"),
    @NamedQuery(name = "MUser.findByRoleid", query = "SELECT m FROM MUser m WHERE m.roleid = :roleid"),
    @NamedQuery(name = "MUser.findByWebroleid", query = "SELECT m FROM MUser m WHERE m.webroleid = :webroleid"),
    @NamedQuery(name = "MUser.findByTitle", query = "SELECT m FROM MUser m WHERE m.title = :title"),
    @NamedQuery(name = "MUser.findByDepartmentid", query = "SELECT m FROM MUser m WHERE m.departmentid = :departmentid"),
    @NamedQuery(name = "MUser.findByTelephone", query = "SELECT m FROM MUser m WHERE m.telephone = :telephone"),
    @NamedQuery(name = "MUser.findByMobilephone", query = "SELECT m FROM MUser m WHERE m.mobilephone = :mobilephone"),
    @NamedQuery(name = "MUser.findByEmail", query = "SELECT m FROM MUser m WHERE m.email = :email"),
    @NamedQuery(name = "MUser.findByLastlogintime", query = "SELECT m FROM MUser m WHERE m.lastlogintime = :lastlogintime"),
    @NamedQuery(name = "MUser.findByDeleteflag", query = "SELECT m FROM MUser m WHERE m.deleteflag = :deleteflag"),
    @NamedQuery(name = "MUser.findByModifytime", query = "SELECT m FROM MUser m WHERE m.modifytime = :modifytime"),
    @NamedQuery(name = "MUser.findByModifyuser", query = "SELECT m FROM MUser m WHERE m.modifyuser = :modifyuser")})
public class MUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "USERID")
    private String userid;
    @Size(max = 20)
    @Column(name = "USERNAME")
    private String username;
    @Size(max = 50)
    @Column(name = "PASSWORD")
    private String password;
    @Size(max = 1)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 20)
    @Column(name = "ROLEID")
    private String roleid;
    @Size(max = 20)
    @Column(name = "WEBROLEID")
    private String webroleid;
    @Size(max = 20)
    @Column(name = "TITLE")
    private String title;
    @Size(max = 20)
    @Column(name = "DEPARTMENTID")
    private String departmentid;
    @Size(max = 20)
    @Column(name = "TELEPHONE")
    private String telephone;
    @Size(max = 20)
    @Column(name = "MOBILEPHONE")
    private String mobilephone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 20)
    @Column(name = "LASTLOGINTIME")
    private String lastlogintime;
    @Size(max = 1)
    @Column(name = "DELETEFLAG")
    private String deleteflag;
    @Size(max = 20)
    @Column(name = "MODIFYTIME")
    private String modifytime;
    @Size(max = 20)
    @Column(name = "MODIFYUSER")
    private String modifyuser;

    public MUser() {
    }

    public MUser(String userid) {
        this.userid = userid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getWebroleid() {
        return webroleid;
    }

    public void setWebroleid(String webroleid) {
        this.webroleid = webroleid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(String departmentid) {
        this.departmentid = departmentid;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(String lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public String getDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(String deleteflag) {
        this.deleteflag = deleteflag;
    }

    public String getModifytime() {
        return modifytime;
    }

    public void setModifytime(String modifytime) {
        this.modifytime = modifytime;
    }

    public String getModifyuser() {
        return modifyuser;
    }

    public void setModifyuser(String modifyuser) {
        this.modifyuser = modifyuser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MUser)) {
            return false;
        }
        MUser other = (MUser) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.mes.entity.MUser[ userid=" + userid + " ]";
    }
    
}
