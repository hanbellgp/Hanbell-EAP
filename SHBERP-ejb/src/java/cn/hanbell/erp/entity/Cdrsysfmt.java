/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C0160
 */
@Entity
@Table(name = "cdrsysfmt")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdrsysfmt.findAll", query = "SELECT c FROM Cdrsysfmt c"),
    @NamedQuery(name = "Cdrsysfmt.findByFacno", query = "SELECT c FROM Cdrsysfmt c WHERE c.facno = :facno")})
public class Cdrsysfmt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "facno")
    private String facno;
    @Column(name = "cautoyn")
    private Character cautoyn;
    @Column(name = "cautochar")
    private Character cautochar;
    @Size(max = 6)
    @Column(name = "cnofmt")
    private String cnofmt;
    @Column(name = "sautoyn")
    private Character sautoyn;
    @Column(name = "sautochar")
    private Character sautochar;
    @Size(max = 6)
    @Column(name = "snofmt")
    private String snofmt;
    @Column(name = "osautoyn")
    private Character osautoyn;
    @Column(name = "osautochar")
    private Character osautochar;
    @Size(max = 6)
    @Column(name = "osnofmt")
    private String osnofmt;
    @Column(name = "bautoyn")
    private Character bautoyn;
    @Column(name = "bautochar")
    private Character bautochar;
    @Size(max = 6)
    @Column(name = "bnofmt")
    private String bnofmt;
    @Column(name = "pautoyn")
    private Character pautoyn;
    @Column(name = "pautochar")
    private Character pautochar;
    @Size(max = 6)
    @Column(name = "pnofmt")
    private String pnofmt;
    @Column(name = "iautoyn")
    private Character iautoyn;
    @Column(name = "iautochar")
    private Character iautochar;
    @Size(max = 6)
    @Column(name = "inofmt")
    private String inofmt;
    @Column(name = "zautoyn")
    private Character zautoyn;
    @Column(name = "zautochar")
    private Character zautochar;
    @Size(max = 6)
    @Column(name = "znofmt")
    private String znofmt;
    @Column(name = "nocdryn")
    private Character nocdryn;
    @Column(name = "nosame1yn")
    private Character nosame1yn;
    @Column(name = "nocdrnoyn")
    private Character nocdrnoyn;
    @Column(name = "nautochar")
    private Character nautochar;
    @Size(max = 6)
    @Column(name = "nnofmt")
    private String nnofmt;
    @Column(name = "nosame2yn")
    private Character nosame2yn;
    @Column(name = "nocdrnozyn")
    private Character nocdrnozyn;
    @Column(name = "nzautochar")
    private Character nzautochar;
    @Size(max = 6)
    @Column(name = "nznofmt")
    private String nznofmt;
    @Column(name = "sioautoyn")
    private Character sioautoyn;
    @Column(name = "sioautochar")
    private Character sioautochar;
    @Size(max = 6)
    @Column(name = "sionofmt")
    private String sionofmt;
    @Column(name = "oseaautoyn")
    private Character oseaautoyn;
    @Column(name = "oseaautochar")
    private Character oseaautochar;
    @Size(max = 6)
    @Column(name = "oseanofmt")
    private String oseanofmt;
    @Column(name = "seaautoyn")
    private Character seaautoyn;
    @Column(name = "seaautochar")
    private Character seaautochar;
    @Size(max = 6)
    @Column(name = "seanofmt")
    private String seanofmt;
    @Column(name = "shpautoyn")
    private Character shpautoyn;
    @Column(name = "shpautochar")
    private Character shpautochar;
    @Size(max = 6)
    @Column(name = "shpnofmt")
    private String shpnofmt;
    @Column(name = "oshpautoyn")
    private Character oshpautoyn;
    @Column(name = "oshpautochar")
    private Character oshpautochar;
    @Size(max = 6)
    @Column(name = "oshpnofmt")
    private String oshpnofmt;
    @Column(name = "preautoyn")
    private Character preautoyn;
    @Column(name = "preautochar")
    private Character preautochar;
    @Size(max = 6)
    @Column(name = "prenofmt")
    private String prenofmt;
    @Column(name = "packsamein")
    private Character packsamein;
    @Column(name = "invshpnoyn")
    private Character invshpnoyn;
    @Column(name = "specautoyn")
    private Character specautoyn;
    @Column(name = "specautochar")
    private Character specautochar;
    @Size(max = 6)
    @Column(name = "specnofmt")
    private String specnofmt;
    @JoinColumn(name = "facno", referencedColumnName = "facno", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Cdrsys cdrsys;

    public Cdrsysfmt() {
    }

    public Cdrsysfmt(String facno) {
        this.facno = facno;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public Character getCautoyn() {
        return cautoyn;
    }

    public void setCautoyn(Character cautoyn) {
        this.cautoyn = cautoyn;
    }

    public Character getCautochar() {
        return cautochar;
    }

    public void setCautochar(Character cautochar) {
        this.cautochar = cautochar;
    }

    public String getCnofmt() {
        return cnofmt;
    }

    public void setCnofmt(String cnofmt) {
        this.cnofmt = cnofmt;
    }

    public Character getSautoyn() {
        return sautoyn;
    }

    public void setSautoyn(Character sautoyn) {
        this.sautoyn = sautoyn;
    }

    public Character getSautochar() {
        return sautochar;
    }

    public void setSautochar(Character sautochar) {
        this.sautochar = sautochar;
    }

    public String getSnofmt() {
        return snofmt;
    }

    public void setSnofmt(String snofmt) {
        this.snofmt = snofmt;
    }

    public Character getOsautoyn() {
        return osautoyn;
    }

    public void setOsautoyn(Character osautoyn) {
        this.osautoyn = osautoyn;
    }

    public Character getOsautochar() {
        return osautochar;
    }

    public void setOsautochar(Character osautochar) {
        this.osautochar = osautochar;
    }

    public String getOsnofmt() {
        return osnofmt;
    }

    public void setOsnofmt(String osnofmt) {
        this.osnofmt = osnofmt;
    }

    public Character getBautoyn() {
        return bautoyn;
    }

    public void setBautoyn(Character bautoyn) {
        this.bautoyn = bautoyn;
    }

    public Character getBautochar() {
        return bautochar;
    }

    public void setBautochar(Character bautochar) {
        this.bautochar = bautochar;
    }

    public String getBnofmt() {
        return bnofmt;
    }

    public void setBnofmt(String bnofmt) {
        this.bnofmt = bnofmt;
    }

    public Character getPautoyn() {
        return pautoyn;
    }

    public void setPautoyn(Character pautoyn) {
        this.pautoyn = pautoyn;
    }

    public Character getPautochar() {
        return pautochar;
    }

    public void setPautochar(Character pautochar) {
        this.pautochar = pautochar;
    }

    public String getPnofmt() {
        return pnofmt;
    }

    public void setPnofmt(String pnofmt) {
        this.pnofmt = pnofmt;
    }

    public Character getIautoyn() {
        return iautoyn;
    }

    public void setIautoyn(Character iautoyn) {
        this.iautoyn = iautoyn;
    }

    public Character getIautochar() {
        return iautochar;
    }

    public void setIautochar(Character iautochar) {
        this.iautochar = iautochar;
    }

    public String getInofmt() {
        return inofmt;
    }

    public void setInofmt(String inofmt) {
        this.inofmt = inofmt;
    }

    public Character getZautoyn() {
        return zautoyn;
    }

    public void setZautoyn(Character zautoyn) {
        this.zautoyn = zautoyn;
    }

    public Character getZautochar() {
        return zautochar;
    }

    public void setZautochar(Character zautochar) {
        this.zautochar = zautochar;
    }

    public String getZnofmt() {
        return znofmt;
    }

    public void setZnofmt(String znofmt) {
        this.znofmt = znofmt;
    }

    public Character getNocdryn() {
        return nocdryn;
    }

    public void setNocdryn(Character nocdryn) {
        this.nocdryn = nocdryn;
    }

    public Character getNosame1yn() {
        return nosame1yn;
    }

    public void setNosame1yn(Character nosame1yn) {
        this.nosame1yn = nosame1yn;
    }

    public Character getNocdrnoyn() {
        return nocdrnoyn;
    }

    public void setNocdrnoyn(Character nocdrnoyn) {
        this.nocdrnoyn = nocdrnoyn;
    }

    public Character getNautochar() {
        return nautochar;
    }

    public void setNautochar(Character nautochar) {
        this.nautochar = nautochar;
    }

    public String getNnofmt() {
        return nnofmt;
    }

    public void setNnofmt(String nnofmt) {
        this.nnofmt = nnofmt;
    }

    public Character getNosame2yn() {
        return nosame2yn;
    }

    public void setNosame2yn(Character nosame2yn) {
        this.nosame2yn = nosame2yn;
    }

    public Character getNocdrnozyn() {
        return nocdrnozyn;
    }

    public void setNocdrnozyn(Character nocdrnozyn) {
        this.nocdrnozyn = nocdrnozyn;
    }

    public Character getNzautochar() {
        return nzautochar;
    }

    public void setNzautochar(Character nzautochar) {
        this.nzautochar = nzautochar;
    }

    public String getNznofmt() {
        return nznofmt;
    }

    public void setNznofmt(String nznofmt) {
        this.nznofmt = nznofmt;
    }

    public Character getSioautoyn() {
        return sioautoyn;
    }

    public void setSioautoyn(Character sioautoyn) {
        this.sioautoyn = sioautoyn;
    }

    public Character getSioautochar() {
        return sioautochar;
    }

    public void setSioautochar(Character sioautochar) {
        this.sioautochar = sioautochar;
    }

    public String getSionofmt() {
        return sionofmt;
    }

    public void setSionofmt(String sionofmt) {
        this.sionofmt = sionofmt;
    }

    public Character getOseaautoyn() {
        return oseaautoyn;
    }

    public void setOseaautoyn(Character oseaautoyn) {
        this.oseaautoyn = oseaautoyn;
    }

    public Character getOseaautochar() {
        return oseaautochar;
    }

    public void setOseaautochar(Character oseaautochar) {
        this.oseaautochar = oseaautochar;
    }

    public String getOseanofmt() {
        return oseanofmt;
    }

    public void setOseanofmt(String oseanofmt) {
        this.oseanofmt = oseanofmt;
    }

    public Character getSeaautoyn() {
        return seaautoyn;
    }

    public void setSeaautoyn(Character seaautoyn) {
        this.seaautoyn = seaautoyn;
    }

    public Character getSeaautochar() {
        return seaautochar;
    }

    public void setSeaautochar(Character seaautochar) {
        this.seaautochar = seaautochar;
    }

    public String getSeanofmt() {
        return seanofmt;
    }

    public void setSeanofmt(String seanofmt) {
        this.seanofmt = seanofmt;
    }

    public Character getShpautoyn() {
        return shpautoyn;
    }

    public void setShpautoyn(Character shpautoyn) {
        this.shpautoyn = shpautoyn;
    }

    public Character getShpautochar() {
        return shpautochar;
    }

    public void setShpautochar(Character shpautochar) {
        this.shpautochar = shpautochar;
    }

    public String getShpnofmt() {
        return shpnofmt;
    }

    public void setShpnofmt(String shpnofmt) {
        this.shpnofmt = shpnofmt;
    }

    public Character getOshpautoyn() {
        return oshpautoyn;
    }

    public void setOshpautoyn(Character oshpautoyn) {
        this.oshpautoyn = oshpautoyn;
    }

    public Character getOshpautochar() {
        return oshpautochar;
    }

    public void setOshpautochar(Character oshpautochar) {
        this.oshpautochar = oshpautochar;
    }

    public String getOshpnofmt() {
        return oshpnofmt;
    }

    public void setOshpnofmt(String oshpnofmt) {
        this.oshpnofmt = oshpnofmt;
    }

    public Character getPreautoyn() {
        return preautoyn;
    }

    public void setPreautoyn(Character preautoyn) {
        this.preautoyn = preautoyn;
    }

    public Character getPreautochar() {
        return preautochar;
    }

    public void setPreautochar(Character preautochar) {
        this.preautochar = preautochar;
    }

    public String getPrenofmt() {
        return prenofmt;
    }

    public void setPrenofmt(String prenofmt) {
        this.prenofmt = prenofmt;
    }

    public Character getPacksamein() {
        return packsamein;
    }

    public void setPacksamein(Character packsamein) {
        this.packsamein = packsamein;
    }

    public Character getInvshpnoyn() {
        return invshpnoyn;
    }

    public void setInvshpnoyn(Character invshpnoyn) {
        this.invshpnoyn = invshpnoyn;
    }

    public Character getSpecautoyn() {
        return specautoyn;
    }

    public void setSpecautoyn(Character specautoyn) {
        this.specautoyn = specautoyn;
    }

    public Character getSpecautochar() {
        return specautochar;
    }

    public void setSpecautochar(Character specautochar) {
        this.specautochar = specautochar;
    }

    public String getSpecnofmt() {
        return specnofmt;
    }

    public void setSpecnofmt(String specnofmt) {
        this.specnofmt = specnofmt;
    }

    public Cdrsys getCdrsys() {
        return cdrsys;
    }

    public void setCdrsys(Cdrsys cdrsys) {
        this.cdrsys = cdrsys;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facno != null ? facno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cdrsysfmt)) {
            return false;
        }
        Cdrsysfmt other = (Cdrsysfmt) object;
        if ((this.facno == null && other.facno != null) || (this.facno != null && !this.facno.equals(other.facno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.erp.entity.Cdrsysfmt[ facno=" + facno + " ]";
    }

}
