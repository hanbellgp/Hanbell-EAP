/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "cdrsfkrno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdrsfkrno.findAll", query = "SELECT c FROM Cdrsfkrno c"),
    @NamedQuery(name = "Cdrsfkrno.findByFacno", query = "SELECT c FROM Cdrsfkrno c WHERE c.cdrsfkrnoPK.facno = :facno"),
    @NamedQuery(name = "Cdrsfkrno.findByTrtype", query = "SELECT c FROM Cdrsfkrno c WHERE c.cdrsfkrnoPK.trtype = :trtype"),
    @NamedQuery(name = "Cdrsfkrno.findByKeyformat", query = "SELECT c FROM Cdrsfkrno c WHERE c.cdrsfkrnoPK.keyformat = :keyformat"),
    @NamedQuery(name = "Cdrsfkrno.findByPK", query = "SELECT c FROM Cdrsfkrno c WHERE c.cdrsfkrnoPK.facno = :facno AND c.cdrsfkrnoPK.trtype = :trtype AND c.cdrsfkrnoPK.keyformat = :keyformat"),
    @NamedQuery(name = "Cdrsfkrno.findByMaxseq", query = "SELECT c FROM Cdrsfkrno c WHERE c.maxseq = :maxseq")})
public class Cdrsfkrno implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CdrsfkrnoPK cdrsfkrnoPK;
    @Column(name = "maxseq")
    private Short maxseq;

    public Cdrsfkrno() {
    }

    public Cdrsfkrno(CdrsfkrnoPK cdrsfkrnoPK) {
        this.cdrsfkrnoPK = cdrsfkrnoPK;
    }

    public Cdrsfkrno(String facno, String trtype, String keyformat) {
        this.cdrsfkrnoPK = new CdrsfkrnoPK(facno, trtype, keyformat);
    }

    public CdrsfkrnoPK getCdrsfkrnoPK() {
        return cdrsfkrnoPK;
    }

    public void setCdrsfkrnoPK(CdrsfkrnoPK cdrsfkrnoPK) {
        this.cdrsfkrnoPK = cdrsfkrnoPK;
    }

    public Short getMaxseq() {
        return maxseq;
    }

    public void setMaxseq(Short maxseq) {
        this.maxseq = maxseq;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdrsfkrnoPK != null ? cdrsfkrnoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cdrsfkrno)) {
            return false;
        }
        Cdrsfkrno other = (Cdrsfkrno) object;
        if ((this.cdrsfkrnoPK == null && other.cdrsfkrnoPK != null) || (this.cdrsfkrnoPK != null && !this.cdrsfkrnoPK.equals(other.cdrsfkrnoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Cdrsfkrno[ cdrsfkrnoPK=" + cdrsfkrnoPK + " ]";
    }

}
