/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.entity;

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
 * @author C1587
 */
@Entity
@Table(name = "SERI12_grid1_SERI12")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SERI12grid1SERI12.findAll", query = "SELECT s FROM SERI12grid1SERI12 s"),
    @NamedQuery(name = "SERI12grid1SERI12.findByOID", query = "SELECT s FROM SERI12grid1SERI12 s WHERE s.oid = :oid"),
    @NamedQuery(name = "SERI12grid1SERI12.findByBr013c", query = "SELECT s FROM SERI12grid1SERI12 s WHERE s.br013c = :br013c"),
    @NamedQuery(name = "SERI12grid1SERI12.findByBr014c", query = "SELECT s FROM SERI12grid1SERI12 s WHERE s.br014c = :br014c"),
    @NamedQuery(name = "SERI12grid1SERI12.findByAd007c", query = "SELECT s FROM SERI12grid1SERI12 s WHERE s.ad007c = :ad007c"),
    @NamedQuery(name = "SERI12grid1SERI12.findByBr009", query = "SELECT s FROM SERI12grid1SERI12 s WHERE s.br009 = :br009"),
    @NamedQuery(name = "SERI12grid1SERI12.findByBr008", query = "SELECT s FROM SERI12grid1SERI12 s WHERE s.br008 = :br008"),
    @NamedQuery(name = "SERI12grid1SERI12.findByBr007", query = "SELECT s FROM SERI12grid1SERI12 s WHERE s.br007 = :br007"),
    @NamedQuery(name = "SERI12grid1SERI12.findByBr006", query = "SELECT s FROM SERI12grid1SERI12 s WHERE s.br006 = :br006"),
    @NamedQuery(name = "SERI12grid1SERI12.findByBr005", query = "SELECT s FROM SERI12grid1SERI12 s WHERE s.br005 = :br005"),
    @NamedQuery(name = "SERI12grid1SERI12.findByBr004", query = "SELECT s FROM SERI12grid1SERI12 s WHERE s.br004 = :br004"),
    @NamedQuery(name = "SERI12grid1SERI12.findByBr014", query = "SELECT s FROM SERI12grid1SERI12 s WHERE s.br014 = :br014"),
    @NamedQuery(name = "SERI12grid1SERI12.findByBr003", query = "SELECT s FROM SERI12grid1SERI12 s WHERE s.br003 = :br003"),
    @NamedQuery(name = "SERI12grid1SERI12.findByBr013", query = "SELECT s FROM SERI12grid1SERI12 s WHERE s.br013 = :br013"),
    @NamedQuery(name = "SERI12grid1SERI12.findByBr012c", query = "SELECT s FROM SERI12grid1SERI12 s WHERE s.br012c = :br012c"),
    @NamedQuery(name = "SERI12grid1SERI12.findByBr002", query = "SELECT s FROM SERI12grid1SERI12 s WHERE s.br002 = :br002"),
    @NamedQuery(name = "SERI12grid1SERI12.findByBr012", query = "SELECT s FROM SERI12grid1SERI12 s WHERE s.br012 = :br012"),
    @NamedQuery(name = "SERI12grid1SERI12.findByBr011c", query = "SELECT s FROM SERI12grid1SERI12 s WHERE s.br011c = :br011c"),
    @NamedQuery(name = "SERI12grid1SERI12.findByBr011", query = "SELECT s FROM SERI12grid1SERI12 s WHERE s.br011 = :br011"),
    @NamedQuery(name = "SERI12grid1SERI12.findByBr010c", query = "SELECT s FROM SERI12grid1SERI12 s WHERE s.br010c = :br010c"),
    @NamedQuery(name = "SERI12grid1SERI12.findByBr010", query = "SELECT s FROM SERI12grid1SERI12 s WHERE s.br010 = :br010"),
    @NamedQuery(name = "SERI12grid1SERI12.findByBr008c", query = "SELECT s FROM SERI12grid1SERI12 s WHERE s.br008c = :br008c"),
    @NamedQuery(name = "SERI12grid1SERI12.findByFSN", query = "SELECT s FROM SERI12grid1SERI12 s WHERE s.formSerialNumber = :fsn")})
public class SERI12grid1SERI12 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "BR013C")
    private String br013c;
    @Size(max = 255)
    @Column(name = "BR014C")
    private String br014c;
    @Size(max = 255)
    @Column(name = "AD007C")
    private String ad007c;
    @Size(max = 255)
    @Column(name = "BR009")
    private String br009;
    @Size(max = 255)
    @Column(name = "BR008")
    private String br008;
    @Size(max = 255)
    @Column(name = "BR007")
    private String br007;
    @Size(max = 255)
    @Column(name = "BR006")
    private String br006;
    @Size(max = 255)
    @Column(name = "BR005")
    private String br005;
    @Size(max = 255)
    @Column(name = "BR004")
    private String br004;
    @Size(max = 255)
    @Column(name = "BR014")
    private String br014;
    @Size(max = 255)
    @Column(name = "BR003")
    private String br003;
    @Size(max = 255)
    @Column(name = "BR013")
    private String br013;
    @Size(max = 255)
    @Column(name = "BR012C")
    private String br012c;
    @Size(max = 255)
    @Column(name = "BR002")
    private String br002;
    @Size(max = 255)
    @Column(name = "BR012")
    private String br012;
    @Size(max = 255)
    @Column(name = "BR011C")
    private String br011c;
    @Size(max = 255)
    @Column(name = "BR011")
    private String br011;
    @Size(max = 255)
    @Column(name = "BR010C")
    private String br010c;
    @Size(max = 255)
    @Column(name = "BR010")
    private String br010;
    @Size(max = 255)
    @Column(name = "BR008C")
    private String br008c;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;

    public SERI12grid1SERI12() {
    }

    public SERI12grid1SERI12(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getBr013c() {
        return br013c;
    }

    public void setBr013c(String br013c) {
        this.br013c = br013c;
    }

    public String getBr014c() {
        return br014c;
    }

    public void setBr014c(String br014c) {
        this.br014c = br014c;
    }

    public String getAd007c() {
        return ad007c;
    }

    public void setAd007c(String ad007c) {
        this.ad007c = ad007c;
    }

    public String getBr009() {
        return br009;
    }

    public void setBr009(String br009) {
        this.br009 = br009;
    }

    public String getBr008() {
        return br008;
    }

    public void setBr008(String br008) {
        this.br008 = br008;
    }

    public String getBr007() {
        return br007;
    }

    public void setBr007(String br007) {
        this.br007 = br007;
    }

    public String getBr006() {
        return br006;
    }

    public void setBr006(String br006) {
        this.br006 = br006;
    }

    public String getBr005() {
        return br005;
    }

    public void setBr005(String br005) {
        this.br005 = br005;
    }

    public String getBr004() {
        return br004;
    }

    public void setBr004(String br004) {
        this.br004 = br004;
    }

    public String getBr014() {
        return br014;
    }

    public void setBr014(String br014) {
        this.br014 = br014;
    }

    public String getBr003() {
        return br003;
    }

    public void setBr003(String br003) {
        this.br003 = br003;
    }

    public String getBr013() {
        return br013;
    }

    public void setBr013(String br013) {
        this.br013 = br013;
    }

    public String getBr012c() {
        return br012c;
    }

    public void setBr012c(String br012c) {
        this.br012c = br012c;
    }

    public String getBr002() {
        return br002;
    }

    public void setBr002(String br002) {
        this.br002 = br002;
    }

    public String getBr012() {
        return br012;
    }

    public void setBr012(String br012) {
        this.br012 = br012;
    }

    public String getBr011c() {
        return br011c;
    }

    public void setBr011c(String br011c) {
        this.br011c = br011c;
    }

    public String getBr011() {
        return br011;
    }

    public void setBr011(String br011) {
        this.br011 = br011;
    }

    public String getBr010c() {
        return br010c;
    }

    public void setBr010c(String br010c) {
        this.br010c = br010c;
    }

    public String getBr010() {
        return br010;
    }

    public void setBr010(String br010) {
        this.br010 = br010;
    }

    public String getBr008c() {
        return br008c;
    }

    public void setBr008c(String br008c) {
        this.br008c = br008c;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oid != null ? oid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SERI12grid1SERI12)) {
            return false;
        }
        SERI12grid1SERI12 other = (SERI12grid1SERI12) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.SERI12grid1SERI12[ oid=" + oid + " ]";
    }
    
}
