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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "HK_FW005")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKFW005.findAll", query = "SELECT h FROM HKFW005 h"),
    @NamedQuery(name = "HKFW005.findByApplyarea", query = "SELECT h FROM HKFW005 h WHERE h.applyarea = :applyarea"),
    @NamedQuery(name = "HKFW005.findByOID", query = "SELECT h FROM HKFW005 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKFW005.findByFacno", query = "SELECT h FROM HKFW005 h WHERE h.facno = :facno"),
    @NamedQuery(name = "HKFW005.findByPSN", query = "SELECT h FROM HKFW005 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKFW005.findByFSN", query = "SELECT h FROM HKFW005 h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKFW005.findByKfno", query = "SELECT h FROM HKFW005 h WHERE h.kfno = :kfno ")})
public class HKFW005 implements Serializable {

    @JoinColumn(name = "processSerialNumber", referencedColumnName = "serialNumber", insertable = false, updatable = false)
    @OneToOne
    private ProcessInstance processInstance;

    @JoinColumn(name = "applyuser", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private Users applyUser;

    @JoinColumn(name = "applydept", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private OrganizationUnit applyDept;

    @JoinColumn(name = "requireuser", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private Users requireUser;

    @JoinColumn(name = "requiredept", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private OrganizationUnit requireDept;

    @JoinColumn(name = "supportuser", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private Users supportUser;

    @JoinColumn(name = "supportdept", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private OrganizationUnit supportDept;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total")
    private Double total;
    @Column(name = "requiredate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date requiredate;
    @Size(max = 255)
    @Column(name = "sftype")
    private String sftype;
    @Column(name = "createdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;
    @Size(max = 255)
    @Column(name = "orderno")
    private String orderno;
    @Size(max = 255)
    @Column(name = "type")
    private String type;
    @Size(max = 255)
    @Column(name = "cdrno")
    private String cdrno;
    @Size(max = 255)
    @Column(name = "tel1")
    private String tel1;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "tel2")
    private String tel2;
    @Size(max = 255)
    @Column(name = "fwno")
    private String fwno;
    @Size(max = 255)
    @Column(name = "wlcompany")
    private String wlcompany;
    @Size(max = 255)
    @Column(name = "cusno")
    private String cusno;
    @Size(max = 255)
    @Column(name = "shpuser")
    private String shpuser;
    @Size(max = 255)
    @Column(name = "lendno")
    private String lendno;
    @Size(max = 255)
    @Column(name = "applyarea")
    private String applyarea;
    @Column(name = "qty")
    private Integer qty;
    @Size(max = 255)
    @Column(name = "mark")
    private String mark;
    @Size(max = 255)
    @Column(name = "shpno")
    private String shpno;
    @Size(max = 255)
    @Column(name = "ordertype")
    private String ordertype;
    @Size(max = 255)
    @Column(name = "hyno")
    private String hyno;
    @Size(max = 255)
    @Column(name = "supportarea")
    private String supportarea;
    @Size(max = 255)
    @Column(name = "kfno")
    private String kfno;
    @Size(max = 255)
    @Column(name = "shaddress")
    private String shaddress;
    @Size(max = 255)
    @Column(name = "requiretel")
    private String requiretel;
    @Size(max = 255)
    @Column(name = "shcontact")
    private String shcontact;
    @Size(max = 255)
    @Column(name = "mftype")
    private String mftype;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "model")
    private String model;
    @Size(max = 255)
    @Column(name = "ysstyle")
    private String ysstyle;
    @Size(max = 255)
    @Column(name = "requirearea")
    private String requirearea;
    @Size(max = 255)
    @Column(name = "hidetext")
    private String hidetext;
    @Size(max = 255)
    @Column(name = "applydept")
    private String applydept;
    @Size(max = 255)
    @Column(name = "mfreason")
    private String mfreason;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "createno")
    private String createno;
    @Size(max = 255)
    @Column(name = "hidetext2")
    private String hidetext2;
    @Size(max = 255)
    @Column(name = "applyuser")
    private String applyuser;
    @Size(max = 255)
    @Column(name = "packstyle")
    private String packstyle;
    @Size(max = 255)
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "requireuser")
    private String requireuser;
    @Size(max = 255)
    @Column(name = "requiredept")
    private String requiredept;
    @Size(max = 255)
    @Column(name = "cusna")
    private String cusna;
    @Size(max = 255)
    @Column(name = "yfjs")
    private String yfjs;
    @Size(max = 255)
    @Column(name = "applytel")
    private String applytel;
    @Column(name = "shpdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date shpdate;
    @Size(max = 255)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "supportdept")
    private String supportdept;
    @Size(max = 255)
    @Column(name = "supportuser")
    private String supportuser;
    @Size(max = 255)
    @Column(name = "returnno")
    private String returnno;
    @Size(max = 255)
    @Column(name = "supporttel")
    private String supporttel;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;

    public HKFW005() {
    }

    public HKFW005(String oid) {
        this.oid = oid;
    }

    /**
     * @return the processInstance
     */
    public ProcessInstance getProcessInstance() {
        return processInstance;
    }

    /**
     * @param processInstance the processInstance to set
     */
    public void setProcessInstance(ProcessInstance processInstance) {
        this.processInstance = processInstance;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getRequiredate() {
        return requiredate;
    }

    public void setRequiredate(Date requiredate) {
        this.requiredate = requiredate;
    }

    public String getSftype() {
        return sftype;
    }

    public void setSftype(String sftype) {
        this.sftype = sftype;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCdrno() {
        return cdrno;
    }

    public void setCdrno(String cdrno) {
        this.cdrno = cdrno;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public String getFwno() {
        return fwno;
    }

    public void setFwno(String fwno) {
        this.fwno = fwno;
    }

    public String getWlcompany() {
        return wlcompany;
    }

    public void setWlcompany(String wlcompany) {
        this.wlcompany = wlcompany;
    }

    public String getCusno() {
        return cusno;
    }

    public void setCusno(String cusno) {
        this.cusno = cusno;
    }

    public String getShpuser() {
        return shpuser;
    }

    public void setShpuser(String shpuser) {
        this.shpuser = shpuser;
    }

    public String getLendno() {
        return lendno;
    }

    public void setLendno(String lendno) {
        this.lendno = lendno;
    }

    public String getApplyarea() {
        return applyarea;
    }

    public void setApplyarea(String applyarea) {
        this.applyarea = applyarea;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getShpno() {
        return shpno;
    }

    public void setShpno(String shpno) {
        this.shpno = shpno;
    }

    public String getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(String ordertype) {
        this.ordertype = ordertype;
    }

    public String getHyno() {
        return hyno;
    }

    public void setHyno(String hyno) {
        this.hyno = hyno;
    }

    public String getSupportarea() {
        return supportarea;
    }

    public void setSupportarea(String supportarea) {
        this.supportarea = supportarea;
    }

    public String getKfno() {
        return kfno;
    }

    public void setKfno(String kfno) {
        this.kfno = kfno;
    }

    public String getShaddress() {
        return shaddress;
    }

    public void setShaddress(String shaddress) {
        this.shaddress = shaddress;
    }

    public String getRequiretel() {
        return requiretel;
    }

    public void setRequiretel(String requiretel) {
        this.requiretel = requiretel;
    }

    public String getShcontact() {
        return shcontact;
    }

    public void setShcontact(String shcontact) {
        this.shcontact = shcontact;
    }

    public String getMftype() {
        return mftype;
    }

    public void setMftype(String mftype) {
        this.mftype = mftype;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYsstyle() {
        return ysstyle;
    }

    public void setYsstyle(String ysstyle) {
        this.ysstyle = ysstyle;
    }

    public String getRequirearea() {
        return requirearea;
    }

    public void setRequirearea(String requirearea) {
        this.requirearea = requirearea;
    }

    public String getHidetext() {
        return hidetext;
    }

    public void setHidetext(String hidetext) {
        this.hidetext = hidetext;
    }

    public String getApplydept() {
        return applydept;
    }

    public void setApplydept(String applydept) {
        this.applydept = applydept;
    }

    public String getMfreason() {
        return mfreason;
    }

    public void setMfreason(String mfreason) {
        this.mfreason = mfreason;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getCreateno() {
        return createno;
    }

    public void setCreateno(String createno) {
        this.createno = createno;
    }

    public String getHidetext2() {
        return hidetext2;
    }

    public void setHidetext2(String hidetext2) {
        this.hidetext2 = hidetext2;
    }

    public String getApplyuser() {
        return applyuser;
    }

    public void setApplyuser(String applyuser) {
        this.applyuser = applyuser;
    }

    public String getPackstyle() {
        return packstyle;
    }

    public void setPackstyle(String packstyle) {
        this.packstyle = packstyle;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getRequireuser() {
        return requireuser;
    }

    public void setRequireuser(String requireuser) {
        this.requireuser = requireuser;
    }

    public String getRequiredept() {
        return requiredept;
    }

    public void setRequiredept(String requiredept) {
        this.requiredept = requiredept;
    }

    public String getCusna() {
        return cusna;
    }

    public void setCusna(String cusna) {
        this.cusna = cusna;
    }

    public String getYfjs() {
        return yfjs;
    }

    public void setYfjs(String yfjs) {
        this.yfjs = yfjs;
    }

    public String getApplytel() {
        return applytel;
    }

    public void setApplytel(String applytel) {
        this.applytel = applytel;
    }

    public Date getShpdate() {
        return shpdate;
    }

    public void setShpdate(Date shpdate) {
        this.shpdate = shpdate;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getSupportdept() {
        return supportdept;
    }

    public void setSupportdept(String supportdept) {
        this.supportdept = supportdept;
    }

    public String getSupportuser() {
        return supportuser;
    }

    public void setSupportuser(String supportuser) {
        this.supportuser = supportuser;
    }

    public String getReturnno() {
        return returnno;
    }

    public void setReturnno(String returnno) {
        this.returnno = returnno;
    }

    public String getSupporttel() {
        return supporttel;
    }

    public void setSupporttel(String supporttel) {
        this.supporttel = supporttel;
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
        if (!(object instanceof HKFW005)) {
            return false;
        }
        HKFW005 other = (HKFW005) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKFW005[ oid=" + oid + " ]";
    }

    /**
     * @return the applyUser
     */
    public Users getApplyUser() {
        return applyUser;
    }

    /**
     * @param applyUser the applyUser to set
     */
    public void setApplyUser(Users applyUser) {
        this.applyUser = applyUser;
    }

    /**
     * @return the applyDept
     */
    public OrganizationUnit getApplyDept() {
        return applyDept;
    }

    /**
     * @param applyDept the applyDept to set
     */
    public void setApplyDept(OrganizationUnit applyDept) {
        this.applyDept = applyDept;
    }

    /**
     * @return the requireUser
     */
    public Users getRequireUser() {
        return requireUser;
    }

    /**
     * @param requireUser the requireUser to set
     */
    public void setRequireUser(Users requireUser) {
        this.requireUser = requireUser;
    }

    /**
     * @return the supportUser
     */
    public Users getSupportUser() {
        return supportUser;
    }

    /**
     * @param supportUser the supportUser to set
     */
    public void setSupportUser(Users supportUser) {
        this.supportUser = supportUser;
    }

    /**
     * @return the requireDept
     */
    public OrganizationUnit getRequireDept() {
        return requireDept;
    }

    /**
     * @param requireDept the requireDept to set
     */
    public void setRequireDept(OrganizationUnit requireDept) {
        this.requireDept = requireDept;
    }

    /**
     * @return the supportDept
     */
    public OrganizationUnit getSupportDept() {
        return supportDept;
    }

    /**
     * @param supportDept the supportDept to set
     */
    public void setSupportDept(OrganizationUnit supportDept) {
        this.supportDept = supportDept;
    }

}
