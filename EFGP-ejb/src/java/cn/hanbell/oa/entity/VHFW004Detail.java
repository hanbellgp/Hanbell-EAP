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
 * @author ZFF
 */
@Entity
@Table(name = "VH_FW004_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VHFW004Detail.findAll", query = "SELECT v FROM VHFW004Detail v"),
    @NamedQuery(name = "VHFW004Detail.findByTB010txt", query = "SELECT v FROM VHFW004Detail v WHERE v.tB010txt = :tB010txt"),
    @NamedQuery(name = "VHFW004Detail.findByOid", query = "SELECT v FROM VHFW004Detail v WHERE v.oid = :oid"),
    @NamedQuery(name = "VHFW004Detail.findByMb050", query = "SELECT v FROM VHFW004Detail v WHERE v.mb050 = :mb050"),
    @NamedQuery(name = "VHFW004Detail.findBySerialNo", query = "SELECT v FROM VHFW004Detail v WHERE v.serialNo = :serialNo"),
    @NamedQuery(name = "VHFW004Detail.findByTb008", query = "SELECT v FROM VHFW004Detail v WHERE v.tb008 = :tb008"),
    @NamedQuery(name = "VHFW004Detail.findByTb019", query = "SELECT v FROM VHFW004Detail v WHERE v.tb019 = :tb019"),
    @NamedQuery(name = "VHFW004Detail.findByTb009", query = "SELECT v FROM VHFW004Detail v WHERE v.tb009 = :tb009"),
    @NamedQuery(name = "VHFW004Detail.findByTb006", query = "SELECT v FROM VHFW004Detail v WHERE v.tb006 = :tb006"),
    @NamedQuery(name = "VHFW004Detail.findByTb017", query = "SELECT v FROM VHFW004Detail v WHERE v.tb017 = :tb017"),
    @NamedQuery(name = "VHFW004Detail.findByTb007", query = "SELECT v FROM VHFW004Detail v WHERE v.tb007 = :tb007"),
    @NamedQuery(name = "VHFW004Detail.findByTb018", query = "SELECT v FROM VHFW004Detail v WHERE v.tb018 = :tb018"),
    @NamedQuery(name = "VHFW004Detail.findByTb004", query = "SELECT v FROM VHFW004Detail v WHERE v.tb004 = :tb004"),
    @NamedQuery(name = "VHFW004Detail.findByTb015", query = "SELECT v FROM VHFW004Detail v WHERE v.tb015 = :tb015"),
    @NamedQuery(name = "VHFW004Detail.findByTb005", query = "SELECT v FROM VHFW004Detail v WHERE v.tb005 = :tb005"),
    @NamedQuery(name = "VHFW004Detail.findByTB011txt", query = "SELECT v FROM VHFW004Detail v WHERE v.tB011txt = :tB011txt"),
    @NamedQuery(name = "VHFW004Detail.findByTb016", query = "SELECT v FROM VHFW004Detail v WHERE v.tb016 = :tb016"),
    @NamedQuery(name = "VHFW004Detail.findByTb027", query = "SELECT v FROM VHFW004Detail v WHERE v.tb027 = :tb027"),
    @NamedQuery(name = "VHFW004Detail.findByFSN", query = "SELECT v FROM VHFW004Detail v WHERE v.formSerialNumber = :fsn"),
    @NamedQuery(name = "VHFW004Detail.findByTb022", query = "SELECT v FROM VHFW004Detail v WHERE v.tb022 = :tb022"),
    @NamedQuery(name = "VHFW004Detail.findByTb012", query = "SELECT v FROM VHFW004Detail v WHERE v.tb012 = :tb012"),
    @NamedQuery(name = "VHFW004Detail.findByTb020", query = "SELECT v FROM VHFW004Detail v WHERE v.tb020 = :tb020"),
    @NamedQuery(name = "VHFW004Detail.findByTb042", query = "SELECT v FROM VHFW004Detail v WHERE v.tb042 = :tb042"),
    @NamedQuery(name = "VHFW004Detail.findByTb021", query = "SELECT v FROM VHFW004Detail v WHERE v.tb021 = :tb021")})
public class VHFW004Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "TB010_txt")
    private String tB010txt;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "MB050")
    private String mb050;
    @Size(max = 255)
    @Column(name = "serialNo")
    private String serialNo;
    @Column(name = "TB003")
    private String tb003;
    @Size(max = 255)
    @Size(max = 255)
    @Column(name = "TB008")
    private String tb008;

    @Size(max = 255)
    @Column(name = "TB019")
    private String tb019;
    @Size(max = 255)
    @Column(name = "TB009")
    private String tb009;
    @Size(max = 255)
    @Column(name = "TB006")
    private String tb006;
    @Size(max = 255)
    @Column(name = "TB017")
    private String tb017;
    @Size(max = 255)
    @Column(name = "TB007")
    private String tb007;
    @Size(max = 255)
    @Column(name = "TB018")
    private String tb018;
    @Size(max = 255)
    @Column(name = "TB004")
    private String tb004;
    @Size(max = 255)
    @Column(name = "TB015")
    private String tb015;
    @Size(max = 255)
    @Column(name = "TB005")
    private String tb005;
    @Size(max = 255)
    @Column(name = "TB011_txt")
    private String tB011txt;
    @Size(max = 255)
    @Column(name = "TB016")
    private String tb016;
    @Size(max = 255)
    @Column(name = "TB027")
    private String tb027;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "TB022")
    private String tb022;
    @Size(max = 255)
    @Column(name = "TB012")
    private String tb012;
    @Size(max = 255)
    @Column(name = "TB020")
    private String tb020;
    @Size(max = 255)
    @Column(name = "TB042")
    private String tb042;
    @Size(max = 255)
    @Column(name = "TB021")
    private String tb021;

    public VHFW004Detail() {
    }

    public VHFW004Detail(String oid) {
        this.oid = oid;
    }

    public String getTB010txt() {
        return tB010txt;
    }

    public void setTB010txt(String tB010txt) {
        this.tB010txt = tB010txt;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getMb050() {
        return mb050;
    }

    public void setMb050(String mb050) {
        this.mb050 = mb050;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getTb008() {
        return tb008;
    }

    public void setTb008(String tb008) {
        this.tb008 = tb008;
    }

    public String getTb019() {
        return tb019;
    }

    public void setTb019(String tb019) {
        this.tb019 = tb019;
    }

    public String getTb009() {
        return tb009;
    }

    public void setTb009(String tb009) {
        this.tb009 = tb009;
    }

    public String getTb003() {
        return tb003;
    }

    public void setTb003(String tb003) {
        this.tb003 = tb003;
    }

    public String getTb006() {
        return tb006;
    }

    public void setTb006(String tb006) {
        this.tb006 = tb006;
    }

    public String getTb017() {
        return tb017;
    }

    public void setTb017(String tb017) {
        this.tb017 = tb017;
    }

    public String getTb007() {
        return tb007;
    }

    public void setTb007(String tb007) {
        this.tb007 = tb007;
    }

    public String getTb018() {
        return tb018;
    }

    public void setTb018(String tb018) {
        this.tb018 = tb018;
    }

    public String getTb004() {
        return tb004;
    }

    public void setTb004(String tb004) {
        this.tb004 = tb004;
    }

    public String getTb015() {
        return tb015;
    }

    public void setTb015(String tb015) {
        this.tb015 = tb015;
    }

    public String getTb005() {
        return tb005;
    }

    public void setTb005(String tb005) {
        this.tb005 = tb005;
    }

    public String getTB011txt() {
        return tB011txt;
    }

    public void setTB011txt(String tB011txt) {
        this.tB011txt = tB011txt;
    }

    public String getTb016() {
        return tb016;
    }

    public void setTb016(String tb016) {
        this.tb016 = tb016;
    }

    public String getTb027() {
        return tb027;
    }

    public void setTb027(String tb027) {
        this.tb027 = tb027;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getTb022() {
        return tb022;
    }

    public void setTb022(String tb022) {
        this.tb022 = tb022;
    }

    public String getTb012() {
        return tb012;
    }

    public void setTb012(String tb012) {
        this.tb012 = tb012;
    }

    public String getTb020() {
        return tb020;
    }

    public void setTb020(String tb020) {
        this.tb020 = tb020;
    }

    public String getTb042() {
        return tb042;
    }

    public void setTb042(String tb042) {
        this.tb042 = tb042;
    }

    public String getTb021() {
        return tb021;
    }

    public void setTb021(String tb021) {
        this.tb021 = tb021;
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
        if (!(object instanceof VHFW004Detail)) {
            return false;
        }
        VHFW004Detail other = (VHFW004Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.VHFW004Detail[ oid=" + oid + " ]";
    }

}
