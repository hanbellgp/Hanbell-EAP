/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.efnet.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
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
 * @author C0160
 */
@Entity
@Table(name = "hzfwd")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HZFWD.findAll", query = "SELECT h FROM HZFWD h"),
    @NamedQuery(name = "HZFWD.findById", query = "SELECT h FROM HZFWD h WHERE h.hzfwd006 = :id"),
    @NamedQuery(name = "HZFWD.findByServiceId", query = "SELECT h FROM HZFWD h WHERE h.hzfwd006 = :id")})
public class HZFWD implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HZFWDPK hZFWDPK;
    @Size(max = 50)
    @Column(name = "hzfwd005")
    private String hzfwd005;
    @Size(max = 50)
    @Column(name = "hzfwd008")
    private String hzfwd008;
    @Size(max = 250)
    @Column(name = "hzfwd005C")
    private String hzfwd005C;
    @Size(max = 250)
    @Column(name = "hzfwd008C")
    private String hzfwd008C;
    @Size(max = 20)
    @Column(name = "hzfwd003")
    private String hzfwd003;
    @Size(max = 20)
    @Column(name = "hzfwd004")
    private String hzfwd004;
    @Size(max = 20)
    @Column(name = "hzfwd006")
    private String hzfwd006;
    @Size(max = 10)
    @Column(name = "hzfwd007")
    private String hzfwd007;
    @Size(max = 20)
    @Column(name = "hzfwd009")
    private String hzfwd009;
    @Size(max = 20)
    @Column(name = "hzfwd010")
    private String hzfwd010;
    @Size(max = 20)
    @Column(name = "hzfwd011")
    private String hzfwd011;
    @Size(max = 50)
    @Column(name = "hzfwd012")
    private String hzfwd012;
    @Size(max = 20)
    @Column(name = "hzfwd013")
    private String hzfwd013;
    @Size(max = 20)
    @Column(name = "hzfwd014")
    private String hzfwd014;
    @Size(max = 20)
    @Column(name = "hzfwd015")
    private String hzfwd015;
    @Size(max = 20)
    @Column(name = "hzfwd016")
    private String hzfwd016;
    @Size(max = 20)
    @Column(name = "hzfwd017")
    private String hzfwd017;
    @Size(max = 20)
    @Column(name = "hzfwd018")
    private String hzfwd018;
    @Size(max = 20)
    @Column(name = "hzfwd019")
    private String hzfwd019;
    @Size(max = 20)
    @Column(name = "hzfwd020")
    private String hzfwd020;
    @Size(max = 20)
    @Column(name = "hzfwd021")
    private String hzfwd021;
    @Size(max = 500)
    @Column(name = "hzfwd022")
    private String hzfwd022;
    @Size(max = 200)
    @Column(name = "hzfwd023")
    private String hzfwd023;
    @Size(max = 20)
    @Column(name = "hzfwd024")
    private String hzfwd024;
    @Size(max = 500)
    @Column(name = "hzfwd025")
    private String hzfwd025;
    @Size(max = 20)
    @Column(name = "hzfwd026")
    private String hzfwd026;
    @Size(max = 500)
    @Column(name = "hzfwd027")
    private String hzfwd027;
    @Size(max = 20)
    @Column(name = "COMPANY")
    private String company;
    @Size(max = 10)
    @Column(name = "CREATOR")
    private String creator;
    @Size(max = 10)
    @Column(name = "USR_GROUP")
    private String usrGroup;
    @Size(max = 8)
    @Column(name = "CREATE_DATE")
    private String createDate;
    @Size(max = 10)
    @Column(name = "MODIFIER")
    private String modifier;
    @Size(max = 8)
    @Column(name = "MODI_DATE")
    private String modiDate;
    @Column(name = "FLAG")
    private Short flag;
    @Size(max = 20)
    @Column(name = "hzfwd029")
    private String hzfwd029;
    @Size(max = 2147483647)
    @Column(name = "hzfwd023C")
    private String hzfwd023C;
    @Size(max = 50)
    @Column(name = "select1")
    private String select1;
    @Size(max = 10)
    @Column(name = "facno")
    private String facno;
    @Size(max = 1000)
    @Column(name = "remarks")
    private String remarks;
    @Size(max = 10)
    @Column(name = "gzxxno")
    private String gzxxno;
    @Size(max = 2)
    @Column(name = "mystatus")
    private String mystatus;
    @Size(max = 2)
    @Column(name = "mygh")
    private String mygh;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "wlajtot")
    private BigDecimal wlajtot;
    @Column(name = "dzf")
    private BigDecimal dzf;

    @Column(name = "paydate")
    @Temporal(TemporalType.DATE)
    private Date paydate;

    public HZFWD() {
    }

    public HZFWD(HZFWDPK hZFWDPK) {
        this.hZFWDPK = hZFWDPK;
    }

    public HZFWD(String hzfwd001, String hzfwd002) {
        this.hZFWDPK = new HZFWDPK(hzfwd001, hzfwd002);
    }

    public HZFWDPK getHZFWDPK() {
        return hZFWDPK;
    }

    public void setHZFWDPK(HZFWDPK hZFWDPK) {
        this.hZFWDPK = hZFWDPK;
    }

    public String getHzfwd005() {
        return hzfwd005;
    }

    public void setHzfwd005(String hzfwd005) {
        this.hzfwd005 = hzfwd005;
    }

    public String getHzfwd008() {
        return hzfwd008;
    }

    public void setHzfwd008(String hzfwd008) {
        this.hzfwd008 = hzfwd008;
    }

    public String getHzfwd005C() {
        return hzfwd005C;
    }

    public void setHzfwd005C(String hzfwd005C) {
        this.hzfwd005C = hzfwd005C;
    }

    public String getHzfwd008C() {
        return hzfwd008C;
    }

    public void setHzfwd008C(String hzfwd008C) {
        this.hzfwd008C = hzfwd008C;
    }

    public String getHzfwd003() {
        return hzfwd003;
    }

    public void setHzfwd003(String hzfwd003) {
        this.hzfwd003 = hzfwd003;
    }

    public String getHzfwd004() {
        return hzfwd004;
    }

    public void setHzfwd004(String hzfwd004) {
        this.hzfwd004 = hzfwd004;
    }

    public String getHzfwd006() {
        return hzfwd006;
    }

    public void setHzfwd006(String hzfwd006) {
        this.hzfwd006 = hzfwd006;
    }

    public String getHzfwd007() {
        return hzfwd007;
    }

    public void setHzfwd007(String hzfwd007) {
        this.hzfwd007 = hzfwd007;
    }

    public String getHzfwd009() {
        return hzfwd009;
    }

    public void setHzfwd009(String hzfwd009) {
        this.hzfwd009 = hzfwd009;
    }

    public String getHzfwd010() {
        return hzfwd010;
    }

    public void setHzfwd010(String hzfwd010) {
        this.hzfwd010 = hzfwd010;
    }

    public String getHzfwd011() {
        return hzfwd011;
    }

    public void setHzfwd011(String hzfwd011) {
        this.hzfwd011 = hzfwd011;
    }

    public String getHzfwd012() {
        return hzfwd012;
    }

    public void setHzfwd012(String hzfwd012) {
        this.hzfwd012 = hzfwd012;
    }

    public String getHzfwd013() {
        return hzfwd013;
    }

    public void setHzfwd013(String hzfwd013) {
        this.hzfwd013 = hzfwd013;
    }

    public String getHzfwd014() {
        return hzfwd014;
    }

    public void setHzfwd014(String hzfwd014) {
        this.hzfwd014 = hzfwd014;
    }

    public String getHzfwd015() {
        return hzfwd015;
    }

    public void setHzfwd015(String hzfwd015) {
        this.hzfwd015 = hzfwd015;
    }

    public String getHzfwd016() {
        return hzfwd016;
    }

    public void setHzfwd016(String hzfwd016) {
        this.hzfwd016 = hzfwd016;
    }

    public String getHzfwd017() {
        return hzfwd017;
    }

    public void setHzfwd017(String hzfwd017) {
        this.hzfwd017 = hzfwd017;
    }

    public String getHzfwd018() {
        return hzfwd018;
    }

    public void setHzfwd018(String hzfwd018) {
        this.hzfwd018 = hzfwd018;
    }

    public String getHzfwd019() {
        return hzfwd019;
    }

    public void setHzfwd019(String hzfwd019) {
        this.hzfwd019 = hzfwd019;
    }

    public String getHzfwd020() {
        return hzfwd020;
    }

    public void setHzfwd020(String hzfwd020) {
        this.hzfwd020 = hzfwd020;
    }

    public String getHzfwd021() {
        return hzfwd021;
    }

    public void setHzfwd021(String hzfwd021) {
        this.hzfwd021 = hzfwd021;
    }

    public String getHzfwd022() {
        return hzfwd022;
    }

    public void setHzfwd022(String hzfwd022) {
        this.hzfwd022 = hzfwd022;
    }

    public String getHzfwd023() {
        return hzfwd023;
    }

    public void setHzfwd023(String hzfwd023) {
        this.hzfwd023 = hzfwd023;
    }

    public String getHzfwd024() {
        return hzfwd024;
    }

    public void setHzfwd024(String hzfwd024) {
        this.hzfwd024 = hzfwd024;
    }

    public String getHzfwd025() {
        return hzfwd025;
    }

    public void setHzfwd025(String hzfwd025) {
        this.hzfwd025 = hzfwd025;
    }

    public String getHzfwd026() {
        return hzfwd026;
    }

    public void setHzfwd026(String hzfwd026) {
        this.hzfwd026 = hzfwd026;
    }

    public String getHzfwd027() {
        return hzfwd027;
    }

    public void setHzfwd027(String hzfwd027) {
        this.hzfwd027 = hzfwd027;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getUsrGroup() {
        return usrGroup;
    }

    public void setUsrGroup(String usrGroup) {
        this.usrGroup = usrGroup;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getModiDate() {
        return modiDate;
    }

    public void setModiDate(String modiDate) {
        this.modiDate = modiDate;
    }

    public Short getFlag() {
        return flag;
    }

    public void setFlag(Short flag) {
        this.flag = flag;
    }

    public String getHzfwd029() {
        return hzfwd029;
    }

    public void setHzfwd029(String hzfwd029) {
        this.hzfwd029 = hzfwd029;
    }

    public String getHzfwd023C() {
        return hzfwd023C;
    }

    public void setHzfwd023C(String hzfwd023C) {
        this.hzfwd023C = hzfwd023C;
    }

    public String getSelect1() {
        return select1;
    }

    public void setSelect1(String select1) {
        this.select1 = select1;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getGzxxno() {
        return gzxxno;
    }

    public void setGzxxno(String gzxxno) {
        this.gzxxno = gzxxno;
    }

    public String getMystatus() {
        return mystatus;
    }

    public void setMystatus(String mystatus) {
        this.mystatus = mystatus;
    }

    public String getMygh() {
        return mygh;
    }

    public void setMygh(String mygh) {
        this.mygh = mygh;
    }

    public BigDecimal getWlajtot() {
        return wlajtot;
    }

    public void setWlajtot(BigDecimal wlajtot) {
        this.wlajtot = wlajtot;
    }

    public BigDecimal getDzf() {
        return dzf;
    }

    public void setDzf(BigDecimal dzf) {
        this.dzf = dzf;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hZFWDPK != null ? hZFWDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HZFWD)) {
            return false;
        }
        HZFWD other = (HZFWD) object;
        if ((this.hZFWDPK == null && other.hZFWDPK != null) || (this.hZFWDPK != null && !this.hZFWDPK.equals(other.hZFWDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.efnet.entity.HZFWD[ hZFWDPK=" + hZFWDPK + " ]";
    }

    /**
     * @return the paydate
     */
    public Date getPaydate() {
        return paydate;
    }

    /**
     * @param paydate the paydate to set
     */
    public void setPaydate(Date paydate) {
        this.paydate = paydate;
    }

}
