/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import com.lightshell.comm.SuperDetailEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "proposalattach")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProposalAttach.findAll", query = "SELECT p FROM ProposalAttach p")
    , @NamedQuery(name = "ProposalAttach.findById", query = "SELECT p FROM ProposalAttach p WHERE p.id = :id")
    , @NamedQuery(name = "ProposalAttach.findByPId", query = "SELECT p FROM ProposalAttach p WHERE p.pid = :pid")
    , @NamedQuery(name = "ProposalAttach.findBySeq", query = "SELECT p FROM ProposalAttach p WHERE p.seq = :seq")
    , @NamedQuery(name = "ProposalAttach.findByProposalid", query = "SELECT p FROM ProposalAttach p WHERE p.proposalid = :proposalid")
    , @NamedQuery(name = "ProposalAttach.findByContent", query = "SELECT p FROM ProposalAttach p WHERE p.content = :content")
    , @NamedQuery(name = "ProposalAttach.findByResource", query = "SELECT p FROM ProposalAttach p WHERE p.resource = :resource")})
public class ProposalAttach extends SuperDetailEntity  {

    @Size(max = 20)
    @Column(name = "proposalid")
    private String proposalid;
    @Size(max = 100)
    @Column(name = "content")
    private String content;
    @Size(max = 100)
    @Column(name = "resource")
    private String resource;

    public ProposalAttach() {
    }

    public String getProposalid() {
        return proposalid;
    }

    public void setProposalid(String proposalid) {
        this.proposalid = proposalid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
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
        if (!(object instanceof ProposalAttach)) {
            return false;
        }
        ProposalAttach other = (ProposalAttach) object;
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
        return "cn.hanbell.eap.entity.ProposalAttach[ id=" + id + " ]";
    }
    
}
