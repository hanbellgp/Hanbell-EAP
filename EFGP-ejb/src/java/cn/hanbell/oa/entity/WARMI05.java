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
 * @author C0160
 */
@Entity
@Table(name = "WARMI05")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WARMI05.findAll", query = "SELECT w FROM WARMI05 w"),
    @NamedQuery(name = "WARMI05.findByOID", query = "SELECT w FROM WARMI05 w WHERE w.oid = :oid"),
    @NamedQuery(name = "WARMI05.findByPSN", query = "SELECT w FROM WARMI05 w WHERE w.processSerialNumber = :psn"),
    @NamedQuery(name = "WARMI05.findByFSN", query = "SELECT w FROM WARMI05 w WHERE w.formSerialNumber = :fsn")})
public class WARMI05 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "TA040")
    private String ta040;
    @Size(max = 255)
    @Column(name = "TA030")
    private String ta030;
    @Size(max = 255)
    @Column(name = "TA031")
    private String ta031;
    @Size(max = 255)
    @Column(name = "TA032")
    private String ta032;
    @Size(max = 255)
    @Column(name = "TA033")
    private String ta033;
    @Size(max = 255)
    @Column(name = "TA034")
    private String ta034;
    @Size(max = 255)
    @Column(name = "TA035")
    private String ta035;
    @Size(max = 255)
    @Column(name = "TA036")
    private String ta036;
    @Size(max = 255)
    @Column(name = "TA037")
    private String ta037;
    @Size(max = 255)
    @Column(name = "TA038")
    private String ta038;
    @Size(max = 255)
    @Column(name = "TA039")
    private String ta039;
    @Size(max = 255)
    @Column(name = "TA005")
    private String ta005;
    @Size(max = 255)
    @Column(name = "TA008")
    private String ta008;
    @Size(max = 255)
    @Column(name = "TA009")
    private String ta009;
    @Size(max = 255)
    @Column(name = "TA002")
    private String ta002;
    @Size(max = 255)
    @Column(name = "TA001")
    private String ta001;
    @Size(max = 255)
    @Column(name = "TA004")
    private String ta004;
    @Size(max = 255)
    @Column(name = "TA003")
    private String ta003;
    @Size(max = 255)
    @Column(name = "TB027")
    private String tb027;
    @Size(max = 255)
    @Column(name = "hidwareh")
    private String hidwareh;
    @Size(max = 255)
    @Column(name = "TA041")
    private String ta041;
    @Size(max = 255)
    @Column(name = "TA042")
    private String ta042;
    @Size(max = 255)
    @Column(name = "TB022")
    private String tb022;
    @Size(max = 255)
    @Column(name = "TB021")
    private String tb021;
    @Size(max = 255)
    @Column(name = "TB020")
    private String tb020;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "TA019")
    private String ta019;
    @Size(max = 255)
    @Column(name = "TA018")
    private String ta018;
    @Size(max = 255)
    @Column(name = "TA014")
    private String ta014;
    @Size(max = 255)
    @Column(name = "TA013")
    private String ta013;
    @Size(max = 255)
    @Column(name = "TA012")
    private String ta012;
    @Size(max = 255)
    @Column(name = "TA010")
    private String ta010;
    @Size(max = 255)
    @Column(name = "TB010")
    private String tb010;
    @Size(max = 255)
    @Column(name = "TB012")
    private String tb012;
    @Size(max = 255)
    @Column(name = "TB011")
    private String tb011;
    @Size(max = 255)
    @Column(name = "TB016")
    private String tb016;
    @Size(max = 255)
    @Column(name = "TB015")
    private String tb015;
    @Size(max = 255)
    @Column(name = "TB018")
    private String tb018;
    @Size(max = 255)
    @Column(name = "TB017")
    private String tb017;
    @Size(max = 255)
    @Column(name = "TB019")
    private String tb019;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "TA028")
    private String ta028;
    @Size(max = 255)
    @Column(name = "TA029")
    private String ta029;
    @Size(max = 255)
    @Column(name = "TA200")
    private String ta200;
    @Size(max = 255)
    @Column(name = "TA026")
    private String ta026;
    @Size(max = 255)
    @Column(name = "TA025")
    private String ta025;
    @Size(max = 255)
    @Column(name = "MB050")
    private String mb050;
    @Size(max = 255)
    @Column(name = "TB005")
    private String tb005;
    @Size(max = 255)
    @Column(name = "TB004")
    private String tb004;
    @Size(max = 255)
    @Column(name = "TB009")
    private String tb009;
    @Size(max = 255)
    @Column(name = "TB008")
    private String tb008;
    @Size(max = 255)
    @Column(name = "TB042")
    private String tb042;
    @Size(max = 255)
    @Column(name = "TB007")
    private String tb007;
    @Size(max = 255)
    @Column(name = "TB006")
    private String tb006;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "TA043C")
    private String ta043c;
    @Size(max = 255)
    @Column(name = "TA043")
    private String ta043;
    @Size(max = 255)
    @Column(name = "TA042C")
    private String ta042c;
    @Size(max = 255)
    @Column(name = "TA032C")
    private String ta032c;
    @Size(max = 255)
    @Column(name = "TA012C")
    private String ta012c;

    public WARMI05() {
    }

    public WARMI05(String oid) {
        this.oid = oid;
    }

    public String getTa040() {
        return ta040;
    }

    public void setTa040(String ta040) {
        this.ta040 = ta040;
    }

    public String getTa030() {
        return ta030;
    }

    public void setTa030(String ta030) {
        this.ta030 = ta030;
    }

    public String getTa031() {
        return ta031;
    }

    public void setTa031(String ta031) {
        this.ta031 = ta031;
    }

    public String getTa032() {
        return ta032;
    }

    public void setTa032(String ta032) {
        this.ta032 = ta032;
    }

    public String getTa033() {
        return ta033;
    }

    public void setTa033(String ta033) {
        this.ta033 = ta033;
    }

    public String getTa034() {
        return ta034;
    }

    public void setTa034(String ta034) {
        this.ta034 = ta034;
    }

    public String getTa035() {
        return ta035;
    }

    public void setTa035(String ta035) {
        this.ta035 = ta035;
    }

    public String getTa036() {
        return ta036;
    }

    public void setTa036(String ta036) {
        this.ta036 = ta036;
    }

    public String getTa037() {
        return ta037;
    }

    public void setTa037(String ta037) {
        this.ta037 = ta037;
    }

    public String getTa038() {
        return ta038;
    }

    public void setTa038(String ta038) {
        this.ta038 = ta038;
    }

    public String getTa039() {
        return ta039;
    }

    public void setTa039(String ta039) {
        this.ta039 = ta039;
    }

    public String getTa005() {
        return ta005;
    }

    public void setTa005(String ta005) {
        this.ta005 = ta005;
    }

    public String getTa008() {
        return ta008;
    }

    public void setTa008(String ta008) {
        this.ta008 = ta008;
    }

    public String getTa009() {
        return ta009;
    }

    public void setTa009(String ta009) {
        this.ta009 = ta009;
    }

    public String getTa002() {
        return ta002;
    }

    public void setTa002(String ta002) {
        this.ta002 = ta002;
    }

    public String getTa001() {
        return ta001;
    }

    public void setTa001(String ta001) {
        this.ta001 = ta001;
    }

    public String getTa004() {
        return ta004;
    }

    public void setTa004(String ta004) {
        this.ta004 = ta004;
    }

    public String getTa003() {
        return ta003;
    }

    public void setTa003(String ta003) {
        this.ta003 = ta003;
    }

    public String getTb027() {
        return tb027;
    }

    public void setTb027(String tb027) {
        this.tb027 = tb027;
    }

    public String getHidwareh() {
        return hidwareh;
    }

    public void setHidwareh(String hidwareh) {
        this.hidwareh = hidwareh;
    }

    public String getTa041() {
        return ta041;
    }

    public void setTa041(String ta041) {
        this.ta041 = ta041;
    }

    public String getTa042() {
        return ta042;
    }

    public void setTa042(String ta042) {
        this.ta042 = ta042;
    }

    public String getTb022() {
        return tb022;
    }

    public void setTb022(String tb022) {
        this.tb022 = tb022;
    }

    public String getTb021() {
        return tb021;
    }

    public void setTb021(String tb021) {
        this.tb021 = tb021;
    }

    public String getTb020() {
        return tb020;
    }

    public void setTb020(String tb020) {
        this.tb020 = tb020;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getTa019() {
        return ta019;
    }

    public void setTa019(String ta019) {
        this.ta019 = ta019;
    }

    public String getTa018() {
        return ta018;
    }

    public void setTa018(String ta018) {
        this.ta018 = ta018;
    }

    public String getTa014() {
        return ta014;
    }

    public void setTa014(String ta014) {
        this.ta014 = ta014;
    }

    public String getTa013() {
        return ta013;
    }

    public void setTa013(String ta013) {
        this.ta013 = ta013;
    }

    public String getTa012() {
        return ta012;
    }

    public void setTa012(String ta012) {
        this.ta012 = ta012;
    }

    public String getTa010() {
        return ta010;
    }

    public void setTa010(String ta010) {
        this.ta010 = ta010;
    }

    public String getTb010() {
        return tb010;
    }

    public void setTb010(String tb010) {
        this.tb010 = tb010;
    }

    public String getTb012() {
        return tb012;
    }

    public void setTb012(String tb012) {
        this.tb012 = tb012;
    }

    public String getTb011() {
        return tb011;
    }

    public void setTb011(String tb011) {
        this.tb011 = tb011;
    }

    public String getTb016() {
        return tb016;
    }

    public void setTb016(String tb016) {
        this.tb016 = tb016;
    }

    public String getTb015() {
        return tb015;
    }

    public void setTb015(String tb015) {
        this.tb015 = tb015;
    }

    public String getTb018() {
        return tb018;
    }

    public void setTb018(String tb018) {
        this.tb018 = tb018;
    }

    public String getTb017() {
        return tb017;
    }

    public void setTb017(String tb017) {
        this.tb017 = tb017;
    }

    public String getTb019() {
        return tb019;
    }

    public void setTb019(String tb019) {
        this.tb019 = tb019;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getTa028() {
        return ta028;
    }

    public void setTa028(String ta028) {
        this.ta028 = ta028;
    }

    public String getTa029() {
        return ta029;
    }

    public void setTa029(String ta029) {
        this.ta029 = ta029;
    }

    public String getTa200() {
        return ta200;
    }

    public void setTa200(String ta200) {
        this.ta200 = ta200;
    }

    public String getTa026() {
        return ta026;
    }

    public void setTa026(String ta026) {
        this.ta026 = ta026;
    }

    public String getTa025() {
        return ta025;
    }

    public void setTa025(String ta025) {
        this.ta025 = ta025;
    }

    public String getMb050() {
        return mb050;
    }

    public void setMb050(String mb050) {
        this.mb050 = mb050;
    }

    public String getTb005() {
        return tb005;
    }

    public void setTb005(String tb005) {
        this.tb005 = tb005;
    }

    public String getTb004() {
        return tb004;
    }

    public void setTb004(String tb004) {
        this.tb004 = tb004;
    }

    public String getTb009() {
        return tb009;
    }

    public void setTb009(String tb009) {
        this.tb009 = tb009;
    }

    public String getTb008() {
        return tb008;
    }

    public void setTb008(String tb008) {
        this.tb008 = tb008;
    }

    public String getTb042() {
        return tb042;
    }

    public void setTb042(String tb042) {
        this.tb042 = tb042;
    }

    public String getTb007() {
        return tb007;
    }

    public void setTb007(String tb007) {
        this.tb007 = tb007;
    }

    public String getTb006() {
        return tb006;
    }

    public void setTb006(String tb006) {
        this.tb006 = tb006;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getTa043c() {
        return ta043c;
    }

    public void setTa043c(String ta043c) {
        this.ta043c = ta043c;
    }

    public String getTa043() {
        return ta043;
    }

    public void setTa043(String ta043) {
        this.ta043 = ta043;
    }

    public String getTa042c() {
        return ta042c;
    }

    public void setTa042c(String ta042c) {
        this.ta042c = ta042c;
    }

    public String getTa032c() {
        return ta032c;
    }

    public void setTa032c(String ta032c) {
        this.ta032c = ta032c;
    }

    public String getTa012c() {
        return ta012c;
    }

    public void setTa012c(String ta012c) {
        this.ta012c = ta012c;
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
        if (!(object instanceof WARMI05)) {
            return false;
        }
        WARMI05 other = (WARMI05) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.WARMI05[ oid=" + oid + " ]";
    }

}
