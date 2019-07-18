/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "invdou")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invdou.findAll", query = "SELECT i FROM Invdou i"),
    @NamedQuery(name = "Invdou.findByTrtype", query = "SELECT i FROM Invdou i WHERE i.trtype = :trtype"),
    @NamedQuery(name = "Invdou.findByTypedsc", query = "SELECT i FROM Invdou i WHERE i.typedsc = :typedsc"),
    @NamedQuery(name = "Invdou.findBySyscode", query = "SELECT i FROM Invdou i WHERE i.syscode = :syscode"),
    @NamedQuery(name = "Invdou.findByIocode", query = "SELECT i FROM Invdou i WHERE i.iocode = :iocode"),
    @NamedQuery(name = "Invdou.findBySmcode", query = "SELECT i FROM Invdou i WHERE i.smcode = :smcode"),
    @NamedQuery(name = "Invdou.findByUpincode", query = "SELECT i FROM Invdou i WHERE i.upincode = :upincode"),
    @NamedQuery(name = "Invdou.findByUpoucode", query = "SELECT i FROM Invdou i WHERE i.upoucode = :upoucode"),
    @NamedQuery(name = "Invdou.findByFixdsc", query = "SELECT i FROM Invdou i WHERE i.fixdsc = :fixdsc"),
    @NamedQuery(name = "Invdou.findByVardsc", query = "SELECT i FROM Invdou i WHERE i.vardsc = :vardsc"),
    @NamedQuery(name = "Invdou.findByUnnum", query = "SELECT i FROM Invdou i WHERE i.unnum = :unnum"),
    @NamedQuery(name = "Invdou.findByDepdsc", query = "SELECT i FROM Invdou i WHERE i.depdsc = :depdsc"),
    @NamedQuery(name = "Invdou.findByDepdsckind", query = "SELECT i FROM Invdou i WHERE i.depdsckind = :depdsckind"),
    @NamedQuery(name = "Invdou.findByHmark1", query = "SELECT i FROM Invdou i WHERE i.hmark1 = :hmark1"),
    @NamedQuery(name = "Invdou.findByHmark1kind", query = "SELECT i FROM Invdou i WHERE i.hmark1kind = :hmark1kind"),
    @NamedQuery(name = "Invdou.findByHmark2", query = "SELECT i FROM Invdou i WHERE i.hmark2 = :hmark2"),
    @NamedQuery(name = "Invdou.findByHmark2kind", query = "SELECT i FROM Invdou i WHERE i.hmark2kind = :hmark2kind"),
    @NamedQuery(name = "Invdou.findByDmark1", query = "SELECT i FROM Invdou i WHERE i.dmark1 = :dmark1"),
    @NamedQuery(name = "Invdou.findByDmark1kind", query = "SELECT i FROM Invdou i WHERE i.dmark1kind = :dmark1kind"),
    @NamedQuery(name = "Invdou.findByDmark2", query = "SELECT i FROM Invdou i WHERE i.dmark2 = :dmark2"),
    @NamedQuery(name = "Invdou.findByDmark2kind", query = "SELECT i FROM Invdou i WHERE i.dmark2kind = :dmark2kind"),
    @NamedQuery(name = "Invdou.findByCntype", query = "SELECT i FROM Invdou i WHERE i.cntype = :cntype"),
    @NamedQuery(name = "Invdou.findByDirchk", query = "SELECT i FROM Invdou i WHERE i.dirchk = :dirchk"),
    @NamedQuery(name = "Invdou.findByReskind", query = "SELECT i FROM Invdou i WHERE i.reskind = :reskind"),
    @NamedQuery(name = "Invdou.findByGecode", query = "SELECT i FROM Invdou i WHERE i.gecode = :gecode"),
    @NamedQuery(name = "Invdou.findByRtcode", query = "SELECT i FROM Invdou i WHERE i.rtcode = :rtcode"),
    @NamedQuery(name = "Invdou.findByNrcode", query = "SELECT i FROM Invdou i WHERE i.nrcode = :nrcode"),
    @NamedQuery(name = "Invdou.findByAutoyn", query = "SELECT i FROM Invdou i WHERE i.autoyn = :autoyn"),
    @NamedQuery(name = "Invdou.findByAutochar", query = "SELECT i FROM Invdou i WHERE i.autochar = :autochar"),
    @NamedQuery(name = "Invdou.findByNofmt", query = "SELECT i FROM Invdou i WHERE i.nofmt = :nofmt"),
    @NamedQuery(name = "Invdou.findByUserno", query = "SELECT i FROM Invdou i WHERE i.userno = :userno"),
    @NamedQuery(name = "Invdou.findByIndate", query = "SELECT i FROM Invdou i WHERE i.indate = :indate"),
    @NamedQuery(name = "Invdou.findByCnmgn", query = "SELECT i FROM Invdou i WHERE i.cnmgn = :cnmgn")})
public class Invdou implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "trtype")
    private String trtype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "typedsc")
    private String typedsc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "syscode")
    private String syscode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iocode")
    private Character iocode;
    @Column(name = "smcode")
    private Character smcode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "upincode")
    private Character upincode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "upoucode")
    private Character upoucode;
    @Size(max = 12)
    @Column(name = "fixdsc")
    private String fixdsc;
    @Size(max = 12)
    @Column(name = "vardsc")
    private String vardsc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unnum")
    private int unnum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "depdsc")
    private String depdsc;
    @Size(max = 2)
    @Column(name = "depdsckind")
    private String depdsckind;
    @Size(max = 8)
    @Column(name = "hmark1")
    private String hmark1;
    @Size(max = 2)
    @Column(name = "hmark1kind")
    private String hmark1kind;
    @Size(max = 8)
    @Column(name = "hmark2")
    private String hmark2;
    @Size(max = 2)
    @Column(name = "hmark2kind")
    private String hmark2kind;
    @Size(max = 8)
    @Column(name = "dmark1")
    private String dmark1;
    @Size(max = 2)
    @Column(name = "dmark1kind")
    private String dmark1kind;
    @Size(max = 8)
    @Column(name = "dmark2")
    private String dmark2;
    @Size(max = 2)
    @Column(name = "dmark2kind")
    private String dmark2kind;
    @Size(max = 4)
    @Column(name = "cntype")
    private String cntype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dirchk")
    private Character dirchk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "reskind")
    private String reskind;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gecode")
    private Character gecode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rtcode")
    private Character rtcode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nrcode")
    private Character nrcode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "autoyn")
    private Character autoyn;
    @Column(name = "autochar")
    private Character autochar;
    @Size(max = 6)
    @Column(name = "nofmt")
    private String nofmt;
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
    @Size(max = 4)
    @Column(name = "cnmgn")
    private String cnmgn;
    //@OneToMany(mappedBy = "trtype")
    private List<Invhad> invhadList;

    public Invdou() {
    }

    public Invdou(String trtype) {
        this.trtype = trtype;
    }

    public Invdou(String trtype, String typedsc, String syscode, Character iocode, Character upincode, Character upoucode, int unnum, String depdsc, Character dirchk, String reskind, Character gecode, Character rtcode, Character nrcode, Character autoyn, String userno, Date indate) {
        this.trtype = trtype;
        this.typedsc = typedsc;
        this.syscode = syscode;
        this.iocode = iocode;
        this.upincode = upincode;
        this.upoucode = upoucode;
        this.unnum = unnum;
        this.depdsc = depdsc;
        this.dirchk = dirchk;
        this.reskind = reskind;
        this.gecode = gecode;
        this.rtcode = rtcode;
        this.nrcode = nrcode;
        this.autoyn = autoyn;
        this.userno = userno;
        this.indate = indate;
    }

    public String getTrtype() {
        return trtype;
    }

    public void setTrtype(String trtype) {
        this.trtype = trtype;
    }

    public String getTypedsc() {
        return typedsc;
    }

    public void setTypedsc(String typedsc) {
        this.typedsc = typedsc;
    }

    public String getSyscode() {
        return syscode;
    }

    public void setSyscode(String syscode) {
        this.syscode = syscode;
    }

    public Character getIocode() {
        return iocode;
    }

    public void setIocode(Character iocode) {
        this.iocode = iocode;
    }

    public Character getSmcode() {
        return smcode;
    }

    public void setSmcode(Character smcode) {
        this.smcode = smcode;
    }

    public Character getUpincode() {
        return upincode;
    }

    public void setUpincode(Character upincode) {
        this.upincode = upincode;
    }

    public Character getUpoucode() {
        return upoucode;
    }

    public void setUpoucode(Character upoucode) {
        this.upoucode = upoucode;
    }

    public String getFixdsc() {
        return fixdsc;
    }

    public void setFixdsc(String fixdsc) {
        this.fixdsc = fixdsc;
    }

    public String getVardsc() {
        return vardsc;
    }

    public void setVardsc(String vardsc) {
        this.vardsc = vardsc;
    }

    public int getUnnum() {
        return unnum;
    }

    public void setUnnum(int unnum) {
        this.unnum = unnum;
    }

    public String getDepdsc() {
        return depdsc;
    }

    public void setDepdsc(String depdsc) {
        this.depdsc = depdsc;
    }

    public String getDepdsckind() {
        return depdsckind;
    }

    public void setDepdsckind(String depdsckind) {
        this.depdsckind = depdsckind;
    }

    public String getHmark1() {
        return hmark1;
    }

    public void setHmark1(String hmark1) {
        this.hmark1 = hmark1;
    }

    public String getHmark1kind() {
        return hmark1kind;
    }

    public void setHmark1kind(String hmark1kind) {
        this.hmark1kind = hmark1kind;
    }

    public String getHmark2() {
        return hmark2;
    }

    public void setHmark2(String hmark2) {
        this.hmark2 = hmark2;
    }

    public String getHmark2kind() {
        return hmark2kind;
    }

    public void setHmark2kind(String hmark2kind) {
        this.hmark2kind = hmark2kind;
    }

    public String getDmark1() {
        return dmark1;
    }

    public void setDmark1(String dmark1) {
        this.dmark1 = dmark1;
    }

    public String getDmark1kind() {
        return dmark1kind;
    }

    public void setDmark1kind(String dmark1kind) {
        this.dmark1kind = dmark1kind;
    }

    public String getDmark2() {
        return dmark2;
    }

    public void setDmark2(String dmark2) {
        this.dmark2 = dmark2;
    }

    public String getDmark2kind() {
        return dmark2kind;
    }

    public void setDmark2kind(String dmark2kind) {
        this.dmark2kind = dmark2kind;
    }

    public String getCntype() {
        return cntype;
    }

    public void setCntype(String cntype) {
        this.cntype = cntype;
    }

    public Character getDirchk() {
        return dirchk;
    }

    public void setDirchk(Character dirchk) {
        this.dirchk = dirchk;
    }

    public String getReskind() {
        return reskind;
    }

    public void setReskind(String reskind) {
        this.reskind = reskind;
    }

    public Character getGecode() {
        return gecode;
    }

    public void setGecode(Character gecode) {
        this.gecode = gecode;
    }

    public Character getRtcode() {
        return rtcode;
    }

    public void setRtcode(Character rtcode) {
        this.rtcode = rtcode;
    }

    public Character getNrcode() {
        return nrcode;
    }

    public void setNrcode(Character nrcode) {
        this.nrcode = nrcode;
    }

    public Character getAutoyn() {
        return autoyn;
    }

    public void setAutoyn(Character autoyn) {
        this.autoyn = autoyn;
    }

    public Character getAutochar() {
        return autochar;
    }

    public void setAutochar(Character autochar) {
        this.autochar = autochar;
    }

    public String getNofmt() {
        return nofmt;
    }

    public void setNofmt(String nofmt) {
        this.nofmt = nofmt;
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

    public String getCnmgn() {
        return cnmgn;
    }

    public void setCnmgn(String cnmgn) {
        this.cnmgn = cnmgn;
    }

    @XmlTransient
    public List<Invhad> getInvhadList() {
        return invhadList;
    }

    public void setInvhadList(List<Invhad> invhadList) {
        this.invhadList = invhadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trtype != null ? trtype.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invdou)) {
            return false;
        }
        Invdou other = (Invdou) object;
        if ((this.trtype == null && other.trtype != null) || (this.trtype != null && !this.trtype.equals(other.trtype))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Invdou[ trtype=" + trtype + " ]";
    }
    
}
