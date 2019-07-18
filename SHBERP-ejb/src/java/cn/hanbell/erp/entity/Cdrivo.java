/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
 * @author C0160
 */
@Entity
@Table(name = "cdrivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdrivo.findAll", query = "SELECT c FROM Cdrivo c"),
    @NamedQuery(name = "Cdrivo.findByCusno", query = "SELECT c FROM Cdrivo c WHERE c.cdrivoPK.cusno = :cusno"),
    @NamedQuery(name = "Cdrivo.findByTrseq", query = "SELECT c FROM Cdrivo c WHERE c.cdrivoPK.trseq = :trseq"),
    @NamedQuery(name = "Cdrivo.findByIvocusno", query = "SELECT c FROM Cdrivo c WHERE c.cdrivoPK.ivocusno = :ivocusno"),
    @NamedQuery(name = "Cdrivo.findByCusna", query = "SELECT c FROM Cdrivo c WHERE c.cusna = :cusna"),
    @NamedQuery(name = "Cdrivo.findByUniform", query = "SELECT c FROM Cdrivo c WHERE c.uniform = :uniform"),
    @NamedQuery(name = "Cdrivo.findByIdno", query = "SELECT c FROM Cdrivo c WHERE c.idno = :idno"),
    @NamedQuery(name = "Cdrivo.findByDifcode", query = "SELECT c FROM Cdrivo c WHERE c.difcode = :difcode"),
    @NamedQuery(name = "Cdrivo.findByIvoyn", query = "SELECT c FROM Cdrivo c WHERE c.ivoyn = :ivoyn")})
public class Cdrivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CdrivoPK cdrivoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "cusna")
    private String cusna;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "address1")
    private String address1;
    @Size(max = 40)
    @Column(name = "address2")
    private String address2;
    @Size(max = 40)
    @Column(name = "address3")
    private String address3;
    @Size(max = 40)
    @Column(name = "address4")
    private String address4;
    @Size(max = 40)
    @Column(name = "address5")
    private String address5;
    @Size(max = 18)
    @Column(name = "uniform")
    private String uniform;
    @Size(max = 18)
    @Column(name = "idno")
    private String idno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "difcode")
    private Character difcode;
    @Column(name = "ivoyn")
    private Character ivoyn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "userno")
    private String userno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "indate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date indate;

    public Cdrivo() {
    }

    public Cdrivo(CdrivoPK cdrivoPK) {
        this.cdrivoPK = cdrivoPK;
    }

    public Cdrivo(CdrivoPK cdrivoPK, String cusna, String address1, Character difcode, String userno, Date indate) {
        this.cdrivoPK = cdrivoPK;
        this.cusna = cusna;
        this.address1 = address1;
        this.difcode = difcode;
        this.userno = userno;
        this.indate = indate;
    }

    public Cdrivo(String cusno, short trseq, String ivocusno) {
        this.cdrivoPK = new CdrivoPK(cusno, trseq, ivocusno);
    }

    public CdrivoPK getCdrivoPK() {
        return cdrivoPK;
    }

    public void setCdrivoPK(CdrivoPK cdrivoPK) {
        this.cdrivoPK = cdrivoPK;
    }

    public String getCusna() {
        return cusna;
    }

    public void setCusna(String cusna) {
        this.cusna = cusna;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getAddress4() {
        return address4;
    }

    public void setAddress4(String address4) {
        this.address4 = address4;
    }

    public String getAddress5() {
        return address5;
    }

    public void setAddress5(String address5) {
        this.address5 = address5;
    }

    public String getUniform() {
        return uniform;
    }

    public void setUniform(String uniform) {
        this.uniform = uniform;
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno;
    }

    public Character getDifcode() {
        return difcode;
    }

    public void setDifcode(Character difcode) {
        this.difcode = difcode;
    }

    public Character getIvoyn() {
        return ivoyn;
    }

    public void setIvoyn(Character ivoyn) {
        this.ivoyn = ivoyn;
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
    }

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdrivoPK != null ? cdrivoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cdrivo)) {
            return false;
        }
        Cdrivo other = (Cdrivo) object;
        if ((this.cdrivoPK == null && other.cdrivoPK != null) || (this.cdrivoPK != null && !this.cdrivoPK.equals(other.cdrivoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Cdrivo[ cdrivoPK=" + cdrivoPK + " ]";
    }
    
}
