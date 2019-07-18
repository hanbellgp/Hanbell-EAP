/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author C1749
 */
@Entity
@Table(name = "HK_JS007")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKJS007.findAll", query = "SELECT h FROM HKJS007 h"),
    @NamedQuery(name = "HKJS007.findByVardsc", query = "SELECT h FROM HKJS007 h WHERE h.vardsc = :vardsc"),
    @NamedQuery(name = "HKJS007.findByGrdesc1", query = "SELECT h FROM HKJS007 h WHERE h.grdesc1 = :grdesc1"),
    @NamedQuery(name = "HKJS007.findByGrdesc3", query = "SELECT h FROM HKJS007 h WHERE h.grdesc3 = :grdesc3"),
    @NamedQuery(name = "HKJS007.findByCertyn", query = "SELECT h FROM HKJS007 h WHERE h.certyn = :certyn"),
    @NamedQuery(name = "HKJS007.findByGrdesc2", query = "SELECT h FROM HKJS007 h WHERE h.grdesc2 = :grdesc2"),
    @NamedQuery(name = "HKJS007.findByMakeyn", query = "SELECT h FROM HKJS007 h WHERE h.makeyn = :makeyn"),
    @NamedQuery(name = "HKJS007.findByMakecode", query = "SELECT h FROM HKJS007 h WHERE h.makecode = :makecode"),
    @NamedQuery(name = "HKJS007.findByGrdesc5", query = "SELECT h FROM HKJS007 h WHERE h.grdesc5 = :grdesc5"),
    @NamedQuery(name = "HKJS007.findByGrdesc4", query = "SELECT h FROM HKJS007 h WHERE h.grdesc4 = :grdesc4"),
    @NamedQuery(name = "HKJS007.findByGrdesc6", query = "SELECT h FROM HKJS007 h WHERE h.grdesc6 = :grdesc6"),
    @NamedQuery(name = "HKJS007.findByGrdescitem", query = "SELECT h FROM HKJS007 h WHERE h.grdescitem = :grdescitem"),
    @NamedQuery(name = "HKJS007.findByItcls", query = "SELECT h FROM HKJS007 h WHERE h.itcls = :itcls"),
    @NamedQuery(name = "HKJS007.findByItbnrtest", query = "SELECT h FROM HKJS007 h WHERE h.itbnrtest = :itbnrtest"),
    @NamedQuery(name = "HKJS007.findByComputeGitnbr6", query = "SELECT h FROM HKJS007 h WHERE h.computeGitnbr6 = :computeGitnbr6"),
    @NamedQuery(name = "HKJS007.findByComputeGitnbr5", query = "SELECT h FROM HKJS007 h WHERE h.computeGitnbr5 = :computeGitnbr5"),
    @NamedQuery(name = "HKJS007.findByComputeGitnbr4", query = "SELECT h FROM HKJS007 h WHERE h.computeGitnbr4 = :computeGitnbr4"),
    @NamedQuery(name = "HKJS007.findByIcbc", query = "SELECT h FROM HKJS007 h WHERE h.icbc = :icbc"),
    @NamedQuery(name = "HKJS007.findByGrdescyn", query = "SELECT h FROM HKJS007 h WHERE h.grdescyn = :grdescyn"),
    @NamedQuery(name = "HKJS007.findByApplydata", query = "SELECT h FROM HKJS007 h WHERE h.applydata = :applydata"),
    @NamedQuery(name = "HKJS007.findByFixdsc", query = "SELECT h FROM HKJS007 h WHERE h.fixdsc = :fixdsc"),
    @NamedQuery(name = "HKJS007.findByItclscode", query = "SELECT h FROM HKJS007 h WHERE h.itclscode = :itclscode"),
    @NamedQuery(name = "HKJS007.findByClsdsc", query = "SELECT h FROM HKJS007 h WHERE h.clsdsc = :clsdsc"),
    @NamedQuery(name = "HKJS007.findByComputeGcheck1", query = "SELECT h FROM HKJS007 h WHERE h.computeGcheck1 = :computeGcheck1"),
    @NamedQuery(name = "HKJS007.findByOid", query = "SELECT h FROM HKJS007 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKJS007.findByComputeGcheck2", query = "SELECT h FROM HKJS007 h WHERE h.computeGcheck2 = :computeGcheck2"),
    @NamedQuery(name = "HKJS007.findByComputeGcheck3", query = "SELECT h FROM HKJS007 h WHERE h.computeGcheck3 = :computeGcheck3"),
    @NamedQuery(name = "HKJS007.findByComputeGcheck4", query = "SELECT h FROM HKJS007 h WHERE h.computeGcheck4 = :computeGcheck4"),
    @NamedQuery(name = "HKJS007.findByComputeGcheck5", query = "SELECT h FROM HKJS007 h WHERE h.computeGcheck5 = :computeGcheck5"),
    @NamedQuery(name = "HKJS007.findByComputeGcheck6", query = "SELECT h FROM HKJS007 h WHERE h.computeGcheck6 = :computeGcheck6"),
    @NamedQuery(name = "HKJS007.findByJityn", query = "SELECT h FROM HKJS007 h WHERE h.jityn = :jityn"),
    @NamedQuery(name = "HKJS007.findByApplydept", query = "SELECT h FROM HKJS007 h WHERE h.applydept = :applydept"),
    @NamedQuery(name = "HKJS007.findByFacno", query = "SELECT h FROM HKJS007 h WHERE h.facno = :facno"),
    @NamedQuery(name = "HKJS007.findByModelyn", query = "SELECT h FROM HKJS007 h WHERE h.modelyn = :modelyn"),
    @NamedQuery(name = "HKJS007.findByCdrbomsubyn", query = "SELECT h FROM HKJS007 h WHERE h.cdrbomsubyn = :cdrbomsubyn"),
    @NamedQuery(name = "HKJS007.findByComGspdsc6", query = "SELECT h FROM HKJS007 h WHERE h.comGspdsc6 = :comGspdsc6"),
    @NamedQuery(name = "HKJS007.findByComGmodel6", query = "SELECT h FROM HKJS007 h WHERE h.comGmodel6 = :comGmodel6"),
    @NamedQuery(name = "HKJS007.findByComGmodel5", query = "SELECT h FROM HKJS007 h WHERE h.comGmodel5 = :comGmodel5"),
    @NamedQuery(name = "HKJS007.findByComGmodel4", query = "SELECT h FROM HKJS007 h WHERE h.comGmodel4 = :comGmodel4"),
    @NamedQuery(name = "HKJS007.findByComGmodel3", query = "SELECT h FROM HKJS007 h WHERE h.comGmodel3 = :comGmodel3"),
    @NamedQuery(name = "HKJS007.findByComGmodel2", query = "SELECT h FROM HKJS007 h WHERE h.comGmodel2 = :comGmodel2"),
    @NamedQuery(name = "HKJS007.findByComGmodel1", query = "SELECT h FROM HKJS007 h WHERE h.comGmodel1 = :comGmodel1"),
    @NamedQuery(name = "HKJS007.findByApplyuser", query = "SELECT h FROM HKJS007 h WHERE h.applyuser = :applyuser"),
    @NamedQuery(name = "HKJS007.findByMakelen", query = "SELECT h FROM HKJS007 h WHERE h.makelen = :makelen"),
    @NamedQuery(name = "HKJS007.findByComGspdsc1", query = "SELECT h FROM HKJS007 h WHERE h.comGspdsc1 = :comGspdsc1"),
    @NamedQuery(name = "HKJS007.findByPSN", query = "SELECT h FROM HKJS007 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKJS007.findByItnbrcode", query = "SELECT h FROM HKJS007 h WHERE h.itnbrcode = :itnbrcode"),
    @NamedQuery(name = "HKJS007.findByComGspdsc3", query = "SELECT h FROM HKJS007 h WHERE h.comGspdsc3 = :comGspdsc3"),
    @NamedQuery(name = "HKJS007.findByComGspdsc2", query = "SELECT h FROM HKJS007 h WHERE h.comGspdsc2 = :comGspdsc2"),
    @NamedQuery(name = "HKJS007.findByComGspdsc5", query = "SELECT h FROM HKJS007 h WHERE h.comGspdsc5 = :comGspdsc5"),
    @NamedQuery(name = "HKJS007.findByComGspdsc4", query = "SELECT h FROM HKJS007 h WHERE h.comGspdsc4 = :comGspdsc4"),
    @NamedQuery(name = "HKJS007.findByComputeGitnbr1", query = "SELECT h FROM HKJS007 h WHERE h.computeGitnbr1 = :computeGitnbr1"),
    @NamedQuery(name = "HKJS007.findByNrcode", query = "SELECT h FROM HKJS007 h WHERE h.nrcode = :nrcode"),
    @NamedQuery(name = "HKJS007.findByComputeGitnbr3", query = "SELECT h FROM HKJS007 h WHERE h.computeGitnbr3 = :computeGitnbr3"),
    @NamedQuery(name = "HKJS007.findByComputeGitnbr2", query = "SELECT h FROM HKJS007 h WHERE h.computeGitnbr2 = :computeGitnbr2"),
    @NamedQuery(name = "HKJS007.findByComGitdsc2", query = "SELECT h FROM HKJS007 h WHERE h.comGitdsc2 = :comGitdsc2"),
    @NamedQuery(name = "HKJS007.findByComGitdsc3", query = "SELECT h FROM HKJS007 h WHERE h.comGitdsc3 = :comGitdsc3"),
    @NamedQuery(name = "HKJS007.findByComGitdsc1", query = "SELECT h FROM HKJS007 h WHERE h.comGitdsc1 = :comGitdsc1"),
    @NamedQuery(name = "HKJS007.findByComGitdsc6", query = "SELECT h FROM HKJS007 h WHERE h.comGitdsc6 = :comGitdsc6"),
    @NamedQuery(name = "HKJS007.findByComGitdsc4", query = "SELECT h FROM HKJS007 h WHERE h.comGitdsc4 = :comGitdsc4"),
    @NamedQuery(name = "HKJS007.findByComGitdsc5", query = "SELECT h FROM HKJS007 h WHERE h.comGitdsc5 = :comGitdsc5"),
    @NamedQuery(name = "HKJS007.findByFSN", query = "SELECT h FROM HKJS007 h WHERE h.formSerialNumber = :fsn")})
public class HKJS007 implements Serializable {

    @Size(max = 255)
    @Column(name = "fixdscf")
    private String fixdscf;

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "vardsc")
    private String vardsc;
    @Size(max = 255)
    @Column(name = "grdesc1")
    private String grdesc1;
    @Size(max = 255)
    @Column(name = "grdesc3")
    private String grdesc3;
    @Size(max = 255)
    @Column(name = "certyn")
    private String certyn;
    @Size(max = 255)
    @Column(name = "grdesc2")
    private String grdesc2;
    @Size(max = 255)
    @Column(name = "makeyn")
    private String makeyn;
    @Size(max = 255)
    @Column(name = "makecode")
    private String makecode;
    @Size(max = 255)
    @Column(name = "grdesc5")
    private String grdesc5;
    @Size(max = 255)
    @Column(name = "grdesc4")
    private String grdesc4;
    @Size(max = 255)
    @Column(name = "grdesc6")
    private String grdesc6;
    @Size(max = 255)
    @Column(name = "grdescitem")
    private String grdescitem;
    @Size(max = 255)
    @Column(name = "itcls")
    private String itcls;
    @Size(max = 255)
    @Column(name = "itbnrtest")
    private String itbnrtest;
    @Size(max = 255)
    @Column(name = "compute_gitnbr6")
    private String computeGitnbr6;
    @Size(max = 255)
    @Column(name = "compute_gitnbr5")
    private String computeGitnbr5;
    @Size(max = 255)
    @Column(name = "compute_gitnbr4")
    private String computeGitnbr4;
    @Size(max = 255)
    @Column(name = "icbc")
    private String icbc;
    @Size(max = 255)
    @Column(name = "grdescyn")
    private String grdescyn;
    @Column(name = "applydata")
    @Temporal(TemporalType.TIMESTAMP)
    private Date applydata;
    @Size(max = 255)
    @Column(name = "fixdsc")
    private String fixdsc;
    @Size(max = 255)
    @Column(name = "itclscode")
    private String itclscode;
    @Size(max = 255)
    @Column(name = "clsdsc")
    private String clsdsc;
    @Size(max = 255)
    @Column(name = "compute_gcheck1")
    private String computeGcheck1;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "compute_gcheck2")
    private String computeGcheck2;
    @Size(max = 255)
    @Column(name = "compute_gcheck3")
    private String computeGcheck3;
    @Size(max = 255)
    @Column(name = "compute_gcheck4")
    private String computeGcheck4;
    @Size(max = 255)
    @Column(name = "compute_gcheck5")
    private String computeGcheck5;
    @Size(max = 255)
    @Column(name = "compute_gcheck6")
    private String computeGcheck6;
    @Size(max = 255)
    @Column(name = "jityn")
    private String jityn;
    @Size(max = 255)
    @Column(name = "applydept")
    private String applydept;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "modelyn")
    private String modelyn;
    @Size(max = 255)
    @Column(name = "cdrbomsubyn")
    private String cdrbomsubyn;
    @Size(max = 255)
    @Column(name = "com_gspdsc6")
    private String comGspdsc6;
    @Size(max = 255)
    @Column(name = "com_gmodel6")
    private String comGmodel6;
    @Size(max = 255)
    @Column(name = "com_gmodel5")
    private String comGmodel5;
    @Size(max = 255)
    @Column(name = "com_gmodel4")
    private String comGmodel4;
    @Size(max = 255)
    @Column(name = "com_gmodel3")
    private String comGmodel3;
    @Size(max = 255)
    @Column(name = "com_gmodel2")
    private String comGmodel2;
    @Size(max = 255)
    @Column(name = "com_gmodel1")
    private String comGmodel1;
    @Size(max = 255)
    @Column(name = "applyuser")
    private String applyuser;
    @Size(max = 255)
    @Column(name = "makelen")
    private String makelen;
    @Size(max = 255)
    @Column(name = "com_gspdsc1")
    private String comGspdsc1;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "itnbrcode")
    private String itnbrcode;
    @Size(max = 255)
    @Column(name = "com_gspdsc3")
    private String comGspdsc3;
    @Size(max = 255)
    @Column(name = "com_gspdsc2")
    private String comGspdsc2;
    @Size(max = 255)
    @Column(name = "com_gspdsc5")
    private String comGspdsc5;
    @Size(max = 255)
    @Column(name = "com_gspdsc4")
    private String comGspdsc4;
    @Size(max = 255)
    @Column(name = "compute_gitnbr1")
    private String computeGitnbr1;
    @Size(max = 255)
    @Column(name = "nrcode")
    private String nrcode;
    @Size(max = 255)
    @Column(name = "compute_gitnbr3")
    private String computeGitnbr3;
    @Size(max = 255)
    @Column(name = "compute_gitnbr2")
    private String computeGitnbr2;
    @Size(max = 255)
    @Column(name = "com_gitdsc2")
    private String comGitdsc2;
    @Size(max = 255)
    @Column(name = "com_gitdsc3")
    private String comGitdsc3;
    @Size(max = 255)
    @Column(name = "com_gitdsc1")
    private String comGitdsc1;
    @Size(max = 255)
    @Column(name = "com_gitdsc6")
    private String comGitdsc6;
    @Size(max = 255)
    @Column(name = "com_gitdsc4")
    private String comGitdsc4;
    @Size(max = 255)
    @Column(name = "com_gitdsc5")
    private String comGitdsc5;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;

    public HKJS007() {
    }

    public HKJS007(String oid) {
        this.oid = oid;
    }

    public String getVardsc() {
        return vardsc;
    }

    public void setVardsc(String vardsc) {
        this.vardsc = vardsc;
    }

    public String getGrdesc1() {
        return grdesc1;
    }

    public void setGrdesc1(String grdesc1) {
        this.grdesc1 = grdesc1;
    }

    public String getGrdesc3() {
        return grdesc3;
    }

    public void setGrdesc3(String grdesc3) {
        this.grdesc3 = grdesc3;
    }

    public String getCertyn() {
        return certyn;
    }

    public void setCertyn(String certyn) {
        this.certyn = certyn;
    }

    public String getGrdesc2() {
        return grdesc2;
    }

    public void setGrdesc2(String grdesc2) {
        this.grdesc2 = grdesc2;
    }

    public String getMakeyn() {
        return makeyn;
    }

    public void setMakeyn(String makeyn) {
        this.makeyn = makeyn;
    }

    public String getMakecode() {
        return makecode;
    }

    public void setMakecode(String makecode) {
        this.makecode = makecode;
    }

    public String getGrdesc5() {
        return grdesc5;
    }

    public void setGrdesc5(String grdesc5) {
        this.grdesc5 = grdesc5;
    }

    public String getGrdesc4() {
        return grdesc4;
    }

    public void setGrdesc4(String grdesc4) {
        this.grdesc4 = grdesc4;
    }

    public String getGrdesc6() {
        return grdesc6;
    }

    public void setGrdesc6(String grdesc6) {
        this.grdesc6 = grdesc6;
    }

    public String getGrdescitem() {
        return grdescitem;
    }

    public void setGrdescitem(String grdescitem) {
        this.grdescitem = grdescitem;
    }

    public String getItcls() {
        return itcls;
    }

    public void setItcls(String itcls) {
        this.itcls = itcls;
    }

    public String getItbnrtest() {
        return itbnrtest;
    }

    public void setItbnrtest(String itbnrtest) {
        this.itbnrtest = itbnrtest;
    }

    public String getComputeGitnbr6() {
        return computeGitnbr6;
    }

    public void setComputeGitnbr6(String computeGitnbr6) {
        this.computeGitnbr6 = computeGitnbr6;
    }

    public String getComputeGitnbr5() {
        return computeGitnbr5;
    }

    public void setComputeGitnbr5(String computeGitnbr5) {
        this.computeGitnbr5 = computeGitnbr5;
    }

    public String getComputeGitnbr4() {
        return computeGitnbr4;
    }

    public void setComputeGitnbr4(String computeGitnbr4) {
        this.computeGitnbr4 = computeGitnbr4;
    }

    public String getIcbc() {
        return icbc;
    }

    public void setIcbc(String icbc) {
        this.icbc = icbc;
    }

    public String getGrdescyn() {
        return grdescyn;
    }

    public void setGrdescyn(String grdescyn) {
        this.grdescyn = grdescyn;
    }

    public Date getApplydata() {
        return applydata;
    }

    public void setApplydata(Date applydata) {
        this.applydata = applydata;
    }

    public String getFixdsc() {
        return fixdsc;
    }

    public void setFixdsc(String fixdsc) {
        this.fixdsc = fixdsc;
    }

    public String getItclscode() {
        return itclscode;
    }

    public void setItclscode(String itclscode) {
        this.itclscode = itclscode;
    }

    public String getClsdsc() {
        return clsdsc;
    }

    public void setClsdsc(String clsdsc) {
        this.clsdsc = clsdsc;
    }

    public String getComputeGcheck1() {
        return computeGcheck1;
    }

    public void setComputeGcheck1(String computeGcheck1) {
        this.computeGcheck1 = computeGcheck1;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getComputeGcheck2() {
        return computeGcheck2;
    }

    public void setComputeGcheck2(String computeGcheck2) {
        this.computeGcheck2 = computeGcheck2;
    }

    public String getComputeGcheck3() {
        return computeGcheck3;
    }

    public void setComputeGcheck3(String computeGcheck3) {
        this.computeGcheck3 = computeGcheck3;
    }

    public String getComputeGcheck4() {
        return computeGcheck4;
    }

    public void setComputeGcheck4(String computeGcheck4) {
        this.computeGcheck4 = computeGcheck4;
    }

    public String getComputeGcheck5() {
        return computeGcheck5;
    }

    public void setComputeGcheck5(String computeGcheck5) {
        this.computeGcheck5 = computeGcheck5;
    }

    public String getComputeGcheck6() {
        return computeGcheck6;
    }

    public void setComputeGcheck6(String computeGcheck6) {
        this.computeGcheck6 = computeGcheck6;
    }

    public String getJityn() {
        return jityn;
    }

    public void setJityn(String jityn) {
        this.jityn = jityn;
    }

    public String getApplydept() {
        return applydept;
    }

    public void setApplydept(String applydept) {
        this.applydept = applydept;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getModelyn() {
        return modelyn;
    }

    public void setModelyn(String modelyn) {
        this.modelyn = modelyn;
    }

    public String getCdrbomsubyn() {
        return cdrbomsubyn;
    }

    public void setCdrbomsubyn(String cdrbomsubyn) {
        this.cdrbomsubyn = cdrbomsubyn;
    }

    public String getComGspdsc6() {
        return comGspdsc6;
    }

    public void setComGspdsc6(String comGspdsc6) {
        this.comGspdsc6 = comGspdsc6;
    }

    public String getComGmodel6() {
        return comGmodel6;
    }

    public void setComGmodel6(String comGmodel6) {
        this.comGmodel6 = comGmodel6;
    }

    public String getComGmodel5() {
        return comGmodel5;
    }

    public void setComGmodel5(String comGmodel5) {
        this.comGmodel5 = comGmodel5;
    }

    public String getComGmodel4() {
        return comGmodel4;
    }

    public void setComGmodel4(String comGmodel4) {
        this.comGmodel4 = comGmodel4;
    }

    public String getComGmodel3() {
        return comGmodel3;
    }

    public void setComGmodel3(String comGmodel3) {
        this.comGmodel3 = comGmodel3;
    }

    public String getComGmodel2() {
        return comGmodel2;
    }

    public void setComGmodel2(String comGmodel2) {
        this.comGmodel2 = comGmodel2;
    }

    public String getComGmodel1() {
        return comGmodel1;
    }

    public void setComGmodel1(String comGmodel1) {
        this.comGmodel1 = comGmodel1;
    }

    public String getApplyuser() {
        return applyuser;
    }

    public void setApplyuser(String applyuser) {
        this.applyuser = applyuser;
    }

    public String getMakelen() {
        return makelen;
    }

    public void setMakelen(String makelen) {
        this.makelen = makelen;
    }

    public String getComGspdsc1() {
        return comGspdsc1;
    }

    public void setComGspdsc1(String comGspdsc1) {
        this.comGspdsc1 = comGspdsc1;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getItnbrcode() {
        return itnbrcode;
    }

    public void setItnbrcode(String itnbrcode) {
        this.itnbrcode = itnbrcode;
    }

    public String getComGspdsc3() {
        return comGspdsc3;
    }

    public void setComGspdsc3(String comGspdsc3) {
        this.comGspdsc3 = comGspdsc3;
    }

    public String getComGspdsc2() {
        return comGspdsc2;
    }

    public void setComGspdsc2(String comGspdsc2) {
        this.comGspdsc2 = comGspdsc2;
    }

    public String getComGspdsc5() {
        return comGspdsc5;
    }

    public void setComGspdsc5(String comGspdsc5) {
        this.comGspdsc5 = comGspdsc5;
    }

    public String getComGspdsc4() {
        return comGspdsc4;
    }

    public void setComGspdsc4(String comGspdsc4) {
        this.comGspdsc4 = comGspdsc4;
    }

    public String getComputeGitnbr1() {
        return computeGitnbr1;
    }

    public void setComputeGitnbr1(String computeGitnbr1) {
        this.computeGitnbr1 = computeGitnbr1;
    }

    public String getNrcode() {
        return nrcode;
    }

    public void setNrcode(String nrcode) {
        this.nrcode = nrcode;
    }

    public String getComputeGitnbr3() {
        return computeGitnbr3;
    }

    public void setComputeGitnbr3(String computeGitnbr3) {
        this.computeGitnbr3 = computeGitnbr3;
    }

    public String getComputeGitnbr2() {
        return computeGitnbr2;
    }

    public void setComputeGitnbr2(String computeGitnbr2) {
        this.computeGitnbr2 = computeGitnbr2;
    }

    public String getComGitdsc2() {
        return comGitdsc2;
    }

    public void setComGitdsc2(String comGitdsc2) {
        this.comGitdsc2 = comGitdsc2;
    }

    public String getComGitdsc3() {
        return comGitdsc3;
    }

    public void setComGitdsc3(String comGitdsc3) {
        this.comGitdsc3 = comGitdsc3;
    }

    public String getComGitdsc1() {
        return comGitdsc1;
    }

    public void setComGitdsc1(String comGitdsc1) {
        this.comGitdsc1 = comGitdsc1;
    }

    public String getComGitdsc6() {
        return comGitdsc6;
    }

    public void setComGitdsc6(String comGitdsc6) {
        this.comGitdsc6 = comGitdsc6;
    }

    public String getComGitdsc4() {
        return comGitdsc4;
    }

    public void setComGitdsc4(String comGitdsc4) {
        this.comGitdsc4 = comGitdsc4;
    }

    public String getComGitdsc5() {
        return comGitdsc5;
    }

    public void setComGitdsc5(String comGitdsc5) {
        this.comGitdsc5 = comGitdsc5;
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
        if (!(object instanceof HKJS007)) {
            return false;
        }
        HKJS007 other = (HKJS007) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKJS007[ oid=" + oid + " ]";
    }

    public String getFixdscf() {
        return fixdscf;
    }

    public void setFixdscf(String fixdscf) {
        this.fixdscf = fixdscf;
    }
    
}
