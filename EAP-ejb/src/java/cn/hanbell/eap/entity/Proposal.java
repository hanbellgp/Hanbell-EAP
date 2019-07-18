/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import com.lightshell.comm.SuperEntity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "proposal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proposal.findAll", query = "SELECT p FROM Proposal p"),
    @NamedQuery(name = "Proposal.findById", query = "SELECT p FROM Proposal p WHERE p.id = :id"),
    @NamedQuery(name = "Proposal.findByProposalna", query = "SELECT p FROM Proposal p WHERE p.proposalna = :proposalna"),
    @NamedQuery(name = "Proposal.findByProposalid", query = "SELECT p FROM Proposal p WHERE p.proposalid = :proposalid"),
    @NamedQuery(name = "Proposal.findByProposaldept", query = "SELECT p FROM Proposal p WHERE p.proposaldept = :proposaldept"),
    @NamedQuery(name = "Proposal.findByProposaluserna", query = "SELECT p FROM Proposal p WHERE p.proposaluserna = :proposaluserna"),
    @NamedQuery(name = "Proposal.findByProposaluserno", query = "SELECT p FROM Proposal p WHERE p.proposaluserno = :proposaluserno"),
    @NamedQuery(name = "Proposal.findByProposaldate", query = "SELECT p FROM Proposal p WHERE p.proposaldate = :proposaldate"),
    @NamedQuery(name = "Proposal.findByReceiptdate", query = "SELECT p FROM Proposal p WHERE p.receiptdate = :receiptdate"),
    @NamedQuery(name = "Proposal.findByReviewdate", query = "SELECT p FROM Proposal p WHERE p.reviewdate = :reviewdate"),
    @NamedQuery(name = "Proposal.findByConclusion", query = "SELECT p FROM Proposal p WHERE p.conclusion = :conclusion"),
    @NamedQuery(name = "Proposal.findByProposalprop", query = "SELECT p FROM Proposal p WHERE p.proposalprop = :proposalprop"),
    @NamedQuery(name = "Proposal.findByCasetype", query = "SELECT p FROM Proposal p WHERE p.casetype = :casetype"),
    @NamedQuery(name = "Proposal.findByImproveuser", query = "SELECT p FROM Proposal p WHERE p.improveuser = :improveuser"),
    @NamedQuery(name = "Proposal.findByRewarded", query = "SELECT p FROM Proposal p WHERE p.rewarded = :rewarded"),
    @NamedQuery(name = "Proposal.findByReviewer", query = "SELECT p FROM Proposal p WHERE p.reviewer = :reviewer"),
    @NamedQuery(name = "Proposal.findByPrecompletedate", query = "SELECT p FROM Proposal p WHERE p.precompletedate = :precompletedate"),
    @NamedQuery(name = "Proposal.findByProgress", query = "SELECT p FROM Proposal p WHERE p.progress = :progress"),
    @NamedQuery(name = "Proposal.findByEnddate", query = "SELECT p FROM Proposal p WHERE p.enddate = :enddate")})
public class Proposal extends SuperEntity {

    //private static final long serialVersionUID = 1L;
    @Size(max = 45)
    @Column(name = "proposalna")
    private String proposalna;
    @Size(max = 20)
    @Column(name = "proposalid")
    private String proposalid;
    @Size(max = 20)
    @Column(name = "proposaldepno")
    private String proposaldepno;
    @Size(max = 45)
    @Column(name = "proposaldept")
    private String proposaldept;
    @Size(max = 20)
    @Column(name = "proposaluserna")
    private String proposaluserna;
    @Size(max = 20)
    @Column(name = "proposaluserno")
    private String proposaluserno;
    @Column(name = "proposaldate")
    @Temporal(TemporalType.DATE)
    private Date proposaldate;
    @Column(name = "receiptdate")
    @Temporal(TemporalType.DATE)
    private Date receiptdate;
    @Column(name = "reviewdate")
    @Temporal(TemporalType.DATE)
    private Date reviewdate;
    @Size(max = 15)
    @Column(name = "conclusion")
    private String conclusion;
    @Size(max = 15)
    @Column(name = "proposalprop")
    private String proposalprop;
    @Size(max = 15)
    @Column(name = "casetype")
    private String casetype;
    @Size(max = 20)
    @Column(name = "improveuser")
    private String improveuser;
    @Size(max = 4)
    @Column(name = "rewarded")
    private String rewarded;
    @Size(max = 20)
    @Column(name = "reviewer")
    private String reviewer;
    @Column(name = "precompletedate")
    @Temporal(TemporalType.DATE)
    private Date precompletedate;
    @Size(max = 255)
    @Column(name = "progress")
    private String progress;
    @Column(name = "enddate")
    @Temporal(TemporalType.DATE)
    private Date enddate;
    @Size(max = 255)
    @Column(name = "attachment")
    private String attachment;
    @Size(max = 255)
    @Column(name = "proporeward")
    private String proporeward;
    @Size(max = 255)
    @Column(name = "improreward")
    private String improreward;
    
    public Proposal() {
    }

    public Proposal(Integer id) {
        this.id = id;
    }

    public Proposal(Integer id, String status) {
        this.id = id;
        this.status = status;
    }

    public String getProposalna() {
        return proposalna;
    }

    public void setProposalna(String proposalna) {
        this.proposalna = proposalna;
    }

    public String getProposalid() {
        return proposalid;
    }

    public void setProposalid(String proposalid) {
        this.proposalid = proposalid;
    }

    public String getProposaldept() {
        return proposaldept;
    }

    public void setProposaldept(String proposaldept) {
        this.proposaldept = proposaldept;
    }

    public String getProposaluserna() {
        return proposaluserna;
    }

    public void setProposaluserna(String proposaluserna) {
        this.proposaluserna = proposaluserna;
    }

    public String getProposaluserno() {
        return proposaluserno;
    }

    public void setProposaluserno(String proposaluserno) {
        this.proposaluserno = proposaluserno;
    }

    public Date getProposaldate() {
        return proposaldate;
    }

    public void setProposaldate(Date proposaldate) {
        this.proposaldate = proposaldate;
    }

    public Date getReceiptdate() {
        return receiptdate;
    }

    public void setReceiptdate(Date receiptdate) {
        this.receiptdate = receiptdate;
    }

    public Date getReviewdate() {
        return reviewdate;
    }

    public void setReviewdate(Date reviewdate) {
        this.reviewdate = reviewdate;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public String getProposalprop() {
        return proposalprop;
    }

    public void setProposalprop(String proposalprop) {
        this.proposalprop = proposalprop;
    }

    public String getCasetype() {
        return casetype;
    }

    public void setCasetype(String casetype) {
        this.casetype = casetype;
    }

    public String getImproveuser() {
        return improveuser;
    }

    public void setImproveuser(String improveuser) {
        this.improveuser = improveuser;
    }

    public String getRewarded() {
        return rewarded;
    }

    public void setRewarded(String rewarded) {
        this.rewarded = rewarded;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public Date getPrecompletedate() {
        return precompletedate;
    }

    public void setPrecompletedate(Date precompletedate) {
        this.precompletedate = precompletedate;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
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
        if (!(object instanceof Proposal)) {
            return false;
        }
        Proposal other = (Proposal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.comm.Proposal[ id=" + id + " ]";
    }

    public String getProposaldepno() {
        return proposaldepno;
    }

    public void setProposaldepno(String proposaldepno) {
        this.proposaldepno = proposaldepno;
    }

    public String getProporeward() {
        return proporeward;
    }

    public void setProporeward(String proporeward) {
        this.proporeward = proporeward;
    }

    public String getImproreward() {
        return improreward;
    }

    public void setImproreward(String improreward) {
        this.improreward = improreward;
    }

}
