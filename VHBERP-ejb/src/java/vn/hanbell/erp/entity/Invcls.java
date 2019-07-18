/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hanbell.erp.entity;

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
@Table(name = "invcls")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invcls.findAll", query = "SELECT i FROM Invcls i"),
    @NamedQuery(name = "Invcls.findByItcls", query = "SELECT i FROM Invcls i WHERE i.itcls = :itcls"),
    @NamedQuery(name = "Invcls.findByClsdsc", query = "SELECT i FROM Invcls i WHERE i.clsdsc = :clsdsc"),
    @NamedQuery(name = "Invcls.findByItnbrcode", query = "SELECT i FROM Invcls i WHERE i.itnbrcode = :itnbrcode"),
    @NamedQuery(name = "Invcls.findByNrcode", query = "SELECT i FROM Invcls i WHERE i.nrcode = :nrcode")})
public class Invcls implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "itcls")
    private String itcls;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "clsdsc")
    private String clsdsc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "itnbrcode")
    private Character itnbrcode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nrcode")
    private Character nrcode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gpitdscyn")
    private Character gpitdscyn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gpspdscyn")
    private Character gpspdscyn;
    @Size(max = 24)
    @Column(name = "fixdsc")
    private String fixdsc;
    @Size(max = 2)
    @Column(name = "fixdscf")
    private String fixdscf;
    @Size(max = 24)
    @Column(name = "vardsc")
    private String vardsc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "itclscode")
    private Character itclscode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "gcheck")
    private String gcheck;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "gitnbr")
    private String gitnbr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "grdescyn")
    private Character grdescyn;
    @Column(name = "grdescitem")
    private Short grdescitem;
    @Size(max = 24)
    @Column(name = "gitdsc")
    private String gitdsc;
    @Size(max = 24)
    @Column(name = "gspdsc")
    private String gspdsc;
    @Size(max = 48)
    @Column(name = "grdesc1")
    private String grdesc1;
    @Size(max = 48)
    @Column(name = "grdesc2")
    private String grdesc2;
    @Size(max = 48)
    @Column(name = "grdesc3")
    private String grdesc3;
    @Size(max = 48)
    @Column(name = "grdesc4")
    private String grdesc4;
    @Size(max = 48)
    @Column(name = "grdesc5")
    private String grdesc5;
    @Size(max = 48)
    @Column(name = "grdesc6")
    private String grdesc6;
    @Size(max = 48)
    @Column(name = "grdesc7")
    private String grdesc7;
    @Size(max = 48)
    @Column(name = "grdesc8")
    private String grdesc8;
    @Size(max = 48)
    @Column(name = "grdesc9")
    private String grdesc9;
    @Size(max = 48)
    @Column(name = "grdesc10")
    private String grdesc10;
    @Size(max = 48)
    @Column(name = "grdesc11")
    private String grdesc11;
    @Size(max = 48)
    @Column(name = "grdesc12")
    private String grdesc12;
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
    @Column(name = "certyn")
    private Character certyn;
    @Size(max = 1)
    @Column(name = "codemap")
    private String codemap;
    @Basic(optional = false)
    @NotNull
    @Column(name = "jityn")
    private Character jityn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mainteyn")
    private Character mainteyn;
    @Column(name = "pyn")
    private Character pyn;
    @Column(name = "ryn")
    private Character ryn;
    @Column(name = "ayn")
    private Character ayn;
    @Column(name = "analysisyn")
    private Character analysisyn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "modelyn")
    private Character modelyn;
    @Column(name = "modelno")
    private Character modelno;
    @Column(name = "modeldsc")
    private Character modeldsc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "gmodel")
    private String gmodel;
    @Column(name = "makeyn")
    private Character makeyn;
    @Size(max = 4)
    @Column(name = "makeCode")
    private String makeCode;
    @Column(name = "makelen")
    private Integer makelen;
    @Column(name = "cdrbomsubyn")
    private Character cdrbomsubyn;
    @Size(max = 8)
    @Column(name = "cmckind")
    private String cmckind;
    // @OneToMany(mappedBy = "itcls")
    // private List<Invmas> invmasList;

    public Invcls() {
    }

    public Invcls(String itcls) {
        this.itcls = itcls;
    }

    public Invcls(String itcls, String clsdsc, Character itnbrcode, Character nrcode, Character gpitdscyn, Character gpspdscyn, Character itclscode, String gcheck, String gitnbr, Character grdescyn, String userno, Date indate, Character jityn, Character mainteyn, Character modelyn, String gmodel) {
        this.itcls = itcls;
        this.clsdsc = clsdsc;
        this.itnbrcode = itnbrcode;
        this.nrcode = nrcode;
        this.gpitdscyn = gpitdscyn;
        this.gpspdscyn = gpspdscyn;
        this.itclscode = itclscode;
        this.gcheck = gcheck;
        this.gitnbr = gitnbr;
        this.grdescyn = grdescyn;
        this.userno = userno;
        this.indate = indate;
        this.jityn = jityn;
        this.mainteyn = mainteyn;
        this.modelyn = modelyn;
        this.gmodel = gmodel;
    }

    public String getItcls() {
        return itcls;
    }

    public void setItcls(String itcls) {
        this.itcls = itcls;
    }

    public String getClsdsc() {
        return clsdsc;
    }

    public void setClsdsc(String clsdsc) {
        this.clsdsc = clsdsc;
    }

    public Character getItnbrcode() {
        return itnbrcode;
    }

    public void setItnbrcode(Character itnbrcode) {
        this.itnbrcode = itnbrcode;
    }

    public Character getNrcode() {
        return nrcode;
    }

    public void setNrcode(Character nrcode) {
        this.nrcode = nrcode;
    }

    public Character getGpitdscyn() {
        return gpitdscyn;
    }

    public void setGpitdscyn(Character gpitdscyn) {
        this.gpitdscyn = gpitdscyn;
    }

    public Character getGpspdscyn() {
        return gpspdscyn;
    }

    public void setGpspdscyn(Character gpspdscyn) {
        this.gpspdscyn = gpspdscyn;
    }

    public String getFixdsc() {
        return fixdsc;
    }

    public void setFixdsc(String fixdsc) {
        this.fixdsc = fixdsc;
    }

    public String getFixdscf() {
        return fixdscf;
    }

    public void setFixdscf(String fixdscf) {
        this.fixdscf = fixdscf;
    }

    public String getVardsc() {
        return vardsc;
    }

    public void setVardsc(String vardsc) {
        this.vardsc = vardsc;
    }

    public Character getItclscode() {
        return itclscode;
    }

    public void setItclscode(Character itclscode) {
        this.itclscode = itclscode;
    }

    public String getGcheck() {
        return gcheck;
    }

    public void setGcheck(String gcheck) {
        this.gcheck = gcheck;
    }

    public String getGitnbr() {
        return gitnbr;
    }

    public void setGitnbr(String gitnbr) {
        this.gitnbr = gitnbr;
    }

    public Character getGrdescyn() {
        return grdescyn;
    }

    public void setGrdescyn(Character grdescyn) {
        this.grdescyn = grdescyn;
    }

    public Short getGrdescitem() {
        return grdescitem;
    }

    public void setGrdescitem(Short grdescitem) {
        this.grdescitem = grdescitem;
    }

    public String getGitdsc() {
        return gitdsc;
    }

    public void setGitdsc(String gitdsc) {
        this.gitdsc = gitdsc;
    }

    public String getGspdsc() {
        return gspdsc;
    }

    public void setGspdsc(String gspdsc) {
        this.gspdsc = gspdsc;
    }

    public String getGrdesc1() {
        return grdesc1;
    }

    public void setGrdesc1(String grdesc1) {
        this.grdesc1 = grdesc1;
    }

    public String getGrdesc2() {
        return grdesc2;
    }

    public void setGrdesc2(String grdesc2) {
        this.grdesc2 = grdesc2;
    }

    public String getGrdesc3() {
        return grdesc3;
    }

    public void setGrdesc3(String grdesc3) {
        this.grdesc3 = grdesc3;
    }

    public String getGrdesc4() {
        return grdesc4;
    }

    public void setGrdesc4(String grdesc4) {
        this.grdesc4 = grdesc4;
    }

    public String getGrdesc5() {
        return grdesc5;
    }

    public void setGrdesc5(String grdesc5) {
        this.grdesc5 = grdesc5;
    }

    public String getGrdesc6() {
        return grdesc6;
    }

    public void setGrdesc6(String grdesc6) {
        this.grdesc6 = grdesc6;
    }

    public String getGrdesc7() {
        return grdesc7;
    }

    public void setGrdesc7(String grdesc7) {
        this.grdesc7 = grdesc7;
    }

    public String getGrdesc8() {
        return grdesc8;
    }

    public void setGrdesc8(String grdesc8) {
        this.grdesc8 = grdesc8;
    }

    public String getGrdesc9() {
        return grdesc9;
    }

    public void setGrdesc9(String grdesc9) {
        this.grdesc9 = grdesc9;
    }

    public String getGrdesc10() {
        return grdesc10;
    }

    public void setGrdesc10(String grdesc10) {
        this.grdesc10 = grdesc10;
    }

    public String getGrdesc11() {
        return grdesc11;
    }

    public void setGrdesc11(String grdesc11) {
        this.grdesc11 = grdesc11;
    }

    public String getGrdesc12() {
        return grdesc12;
    }

    public void setGrdesc12(String grdesc12) {
        this.grdesc12 = grdesc12;
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

    public Character getCertyn() {
        return certyn;
    }

    public void setCertyn(Character certyn) {
        this.certyn = certyn;
    }

    public String getCodemap() {
        return codemap;
    }

    public void setCodemap(String codemap) {
        this.codemap = codemap;
    }

    public Character getJityn() {
        return jityn;
    }

    public void setJityn(Character jityn) {
        this.jityn = jityn;
    }

    public Character getMainteyn() {
        return mainteyn;
    }

    public void setMainteyn(Character mainteyn) {
        this.mainteyn = mainteyn;
    }

    public Character getPyn() {
        return pyn;
    }

    public void setPyn(Character pyn) {
        this.pyn = pyn;
    }

    public Character getRyn() {
        return ryn;
    }

    public void setRyn(Character ryn) {
        this.ryn = ryn;
    }

    public Character getAyn() {
        return ayn;
    }

    public void setAyn(Character ayn) {
        this.ayn = ayn;
    }

    public Character getAnalysisyn() {
        return analysisyn;
    }

    public void setAnalysisyn(Character analysisyn) {
        this.analysisyn = analysisyn;
    }

    public Character getModelyn() {
        return modelyn;
    }

    public void setModelyn(Character modelyn) {
        this.modelyn = modelyn;
    }

    public Character getModelno() {
        return modelno;
    }

    public void setModelno(Character modelno) {
        this.modelno = modelno;
    }

    public Character getModeldsc() {
        return modeldsc;
    }

    public void setModeldsc(Character modeldsc) {
        this.modeldsc = modeldsc;
    }

    public String getGmodel() {
        return gmodel;
    }

    public void setGmodel(String gmodel) {
        this.gmodel = gmodel;
    }

    public Character getMakeyn() {
        return makeyn;
    }

    public void setMakeyn(Character makeyn) {
        this.makeyn = makeyn;
    }

    public String getMakeCode() {
        return makeCode;
    }

    public void setMakeCode(String makeCode) {
        this.makeCode = makeCode;
    }

    public Integer getMakelen() {
        return makelen;
    }

    public void setMakelen(Integer makelen) {
        this.makelen = makelen;
    }

    public Character getCdrbomsubyn() {
        return cdrbomsubyn;
    }

    public void setCdrbomsubyn(Character cdrbomsubyn) {
        this.cdrbomsubyn = cdrbomsubyn;
    }

    public String getCmckind() {
        return cmckind;
    }

    public void setCmckind(String cmckind) {
        this.cmckind = cmckind;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itcls != null ? itcls.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invcls)) {
            return false;
        }
        Invcls other = (Invcls) object;
        if ((this.itcls == null && other.itcls != null) || (this.itcls != null && !this.itcls.equals(other.itcls))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vn.hanbell.erp.comm.Invcls[ itcls=" + itcls + " ]";
    }
    
}
