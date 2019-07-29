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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "cdrdpopsfk")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdrdpopsfk.findAll", query = "SELECT c FROM Cdrdpopsfk c"),
    @NamedQuery(name = "Cdrdpopsfk.findByFacno", query = "SELECT c FROM Cdrdpopsfk c WHERE c.cdrdpopsfkPK.facno = :facno"),
    @NamedQuery(name = "Cdrdpopsfk.findBySfktrno", query = "SELECT c FROM Cdrdpopsfk c WHERE c.cdrdpopsfkPK.sfktrno = :sfktrno"),
    @NamedQuery(name = "Cdrdpopsfk.findByParts", query = "SELECT c FROM Cdrdpopsfk c WHERE c.cdrdpopsfkPK.parts = :parts"),
    @NamedQuery(name = "Cdrdpopsfk.findByPartdesc", query = "SELECT c FROM Cdrdpopsfk c WHERE c.partdesc = :partdesc"),
    @NamedQuery(name = "Cdrdpopsfk.findByPapx", query = "SELECT c FROM Cdrdpopsfk c WHERE c.papx = :papx"),
    @NamedQuery(name = "Cdrdpopsfk.findBySorts", query = "SELECT c FROM Cdrdpopsfk c WHERE c.cdrdpopsfkPK.sorts = :sorts"),
    @NamedQuery(name = "Cdrdpopsfk.findBySortsdesc", query = "SELECT c FROM Cdrdpopsfk c WHERE c.sortsdesc = :sortsdesc"),
    @NamedQuery(name = "Cdrdpopsfk.findBySpecifit", query = "SELECT c FROM Cdrdpopsfk c WHERE c.specifit = :specifit"),
    @NamedQuery(name = "Cdrdpopsfk.findBySpecifitesc", query = "SELECT c FROM Cdrdpopsfk c WHERE c.specifitesc = :specifitesc"),
    @NamedQuery(name = "Cdrdpopsfk.findByReguation1", query = "SELECT c FROM Cdrdpopsfk c WHERE c.reguation1 = :reguation1"),
    @NamedQuery(name = "Cdrdpopsfk.findByRegua1desc", query = "SELECT c FROM Cdrdpopsfk c WHERE c.regua1desc = :regua1desc"),
    @NamedQuery(name = "Cdrdpopsfk.findByReguation2", query = "SELECT c FROM Cdrdpopsfk c WHERE c.reguation2 = :reguation2"),
    @NamedQuery(name = "Cdrdpopsfk.findByRegua2desc", query = "SELECT c FROM Cdrdpopsfk c WHERE c.regua2desc = :regua2desc"),
    @NamedQuery(name = "Cdrdpopsfk.findByReguation3", query = "SELECT c FROM Cdrdpopsfk c WHERE c.reguation3 = :reguation3"),
    @NamedQuery(name = "Cdrdpopsfk.findByRegua3desc", query = "SELECT c FROM Cdrdpopsfk c WHERE c.regua3desc = :regua3desc")})
public class Cdrdpopsfk implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CdrdpopsfkPK cdrdpopsfkPK;
    @Size(max = 16)
    @Column(name = "partdesc")
    private String partdesc;
    @Size(max = 2)
    @Column(name = "papx")
    private String papx;
    @Size(max = 50)
    @Column(name = "sortsdesc")
    private String sortsdesc;
    @Size(max = 8)
    @Column(name = "specifit")
    private String specifit;
    @Size(max = 60)
    @Column(name = "specifitesc")
    private String specifitesc;
    @Size(max = 12)
    @Column(name = "reguation1")
    private String reguation1;
    @Size(max = 60)
    @Column(name = "regua1desc")
    private String regua1desc;
    @Size(max = 12)
    @Column(name = "reguation2")
    private String reguation2;
    @Size(max = 60)
    @Column(name = "regua2desc")
    private String regua2desc;
    @Size(max = 12)
    @Column(name = "reguation3")
    private String reguation3;
    @Size(max = 60)
    @Column(name = "regua3desc")
    private String regua3desc;

    public Cdrdpopsfk() {
    }

    public Cdrdpopsfk(CdrdpopsfkPK cdrdpopsfkPK) {
        this.cdrdpopsfkPK = cdrdpopsfkPK;
    }

    public Cdrdpopsfk(String facno, String sfktrno, String parts, String sorts) {
        this.cdrdpopsfkPK = new CdrdpopsfkPK(facno, sfktrno, parts, sorts);
    }

    public CdrdpopsfkPK getCdrdpopsfkPK() {
        return cdrdpopsfkPK;
    }

    public void setCdrdpopsfkPK(CdrdpopsfkPK cdrdpopsfkPK) {
        this.cdrdpopsfkPK = cdrdpopsfkPK;
    }

    public String getPartdesc() {
        return partdesc;
    }

    public void setPartdesc(String partdesc) {
        this.partdesc = partdesc;
    }

    public String getPapx() {
        return papx;
    }

    public void setPapx(String papx) {
        this.papx = papx;
    }

    public String getSortsdesc() {
        return sortsdesc;
    }

    public void setSortsdesc(String sortsdesc) {
        this.sortsdesc = sortsdesc;
    }

    public String getSpecifit() {
        return specifit;
    }

    public void setSpecifit(String specifit) {
        this.specifit = specifit;
    }

    public String getSpecifitesc() {
        return specifitesc;
    }

    public void setSpecifitesc(String specifitesc) {
        this.specifitesc = specifitesc;
    }

    public String getReguation1() {
        return reguation1;
    }

    public void setReguation1(String reguation1) {
        this.reguation1 = reguation1;
    }

    public String getRegua1desc() {
        return regua1desc;
    }

    public void setRegua1desc(String regua1desc) {
        this.regua1desc = regua1desc;
    }

    public String getReguation2() {
        return reguation2;
    }

    public void setReguation2(String reguation2) {
        this.reguation2 = reguation2;
    }

    public String getRegua2desc() {
        return regua2desc;
    }

    public void setRegua2desc(String regua2desc) {
        this.regua2desc = regua2desc;
    }

    public String getReguation3() {
        return reguation3;
    }

    public void setReguation3(String reguation3) {
        this.reguation3 = reguation3;
    }

    public String getRegua3desc() {
        return regua3desc;
    }

    public void setRegua3desc(String regua3desc) {
        this.regua3desc = regua3desc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdrdpopsfkPK != null ? cdrdpopsfkPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cdrdpopsfk)) {
            return false;
        }
        Cdrdpopsfk other = (Cdrdpopsfk) object;
        if ((this.cdrdpopsfkPK == null && other.cdrdpopsfkPK != null) || (this.cdrdpopsfkPK != null && !this.cdrdpopsfkPK.equals(other.cdrdpopsfkPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Cdrdpopsfk[ cdrdpopsfkPK=" + cdrdpopsfkPK + " ]";
    }

}
