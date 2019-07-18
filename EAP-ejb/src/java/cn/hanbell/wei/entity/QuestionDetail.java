/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.wei.entity;

import com.lightshell.comm.SuperDetailEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C0160
 */
@Entity
@Table(name = "questiondetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QuestionDetail.findAll", query = "SELECT q FROM QuestionDetail q"),
    @NamedQuery(name = "QuestionDetail.findById", query = "SELECT q FROM QuestionDetail q WHERE q.id = :id"),
    @NamedQuery(name = "QuestionDetail.findByPId", query = "SELECT q FROM QuestionDetail q WHERE q.pid = :pid")})
public class QuestionDetail extends SuperDetailEntity {

    @Lob
    @Size(max = 2147483647)
    @Column(name = "content")
    private String content;
    @Size(max = 200)
    @Column(name = "imgfile")
    private String imgfile;

    public QuestionDetail() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgfile() {
        return imgfile;
    }

    public void setImgfile(String imgfile) {
        this.imgfile = imgfile;
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
        if (!(object instanceof QuestionDetail)) {
            return false;
        }
        QuestionDetail other = (QuestionDetail) object;
        if (this.id != null && other.id != null) {
            return this.id.equals(other.id);
        }
        if (this.pid != 0 && other.pid != 0) {
            return this.pid == other.pid && this.seq == other.seq;
        }
        return this.seq == other.seq;
    }

    @Override
    public String toString() {
        return "cn.hanbell.wei.entity.QuestionDetail[ id=" + id + " ]";
    }

}
