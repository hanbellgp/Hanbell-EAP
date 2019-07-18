/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.wei.entity;

import com.lightshell.comm.SuperEntity;
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
@Table(name = "question")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Question.getRowCount", query = "SELECT COUNT(q) FROM Question q"),
    @NamedQuery(name = "Question.findAll", query = "SELECT q FROM Question q"),
    @NamedQuery(name = "Question.findById", query = "SELECT q FROM Question q WHERE q.id = :id"),
    @NamedQuery(name = "Question.findByCategoryId", query = "SELECT q FROM Question q WHERE q.status='V' AND q.category.id = :categoryid ORDER BY q.ontop DESC,q.id DESC"),
    @NamedQuery(name = "Question.findByTitle", query = "SELECT q FROM Question q WHERE q.title = :title"),
    @NamedQuery(name = "Question.findBySubtitle", query = "SELECT q FROM Question q WHERE q.subtitle = :subtitle"),
    @NamedQuery(name = "Question.findByContent", query = "SELECT q FROM Question q WHERE q.content = :content"),
    @NamedQuery(name = "Question.findByOntop", query = "SELECT q FROM Question q WHERE q.ontop = :ontop"),
    @NamedQuery(name = "Question.findByStatus", query = "SELECT q FROM Question q WHERE q.status = :status")})
public class Question extends SuperEntity {

    @JoinColumn(name = "categoryid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private QuestionCategory category;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "title")
    private String title;
    @Size(max = 100)
    @Column(name = "subtitle")
    private String subtitle;
    @Size(max = 400)
    @Column(name = "content")
    private String content;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ontop")
    private boolean ontop;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hits")
    private int hits;
    @Size(max = 200)
    @Column(name = "imgfile")
    private String imgfile;

    public Question() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean getOntop() {
        return ontop;
    }

    public void setOntop(boolean ontop) {
        this.ontop = ontop;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
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
        if (!(object instanceof Question)) {
            return false;
        }
        Question other = (Question) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.wei.entity.Question[ id=" + id + " ]";
    }

    /**
     * @return the category
     */
    public QuestionCategory getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(QuestionCategory category) {
        this.category = category;
    }

}
