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
@Table(name = "HK_CG006")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKCG006.findAll", query = "SELECT h FROM HKCG006 h"),
    @NamedQuery(name = "HKCG006.findByOid", query = "SELECT h FROM HKCG006 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKCG006.findByCreatedate", query = "SELECT h FROM HKCG006 h WHERE h.createdate = :createdate"),
    @NamedQuery(name = "HKCG006.findByParts", query = "SELECT h FROM HKCG006 h WHERE h.parts = :parts"),
    @NamedQuery(name = "HKCG006.findByFacno", query = "SELECT h FROM HKCG006 h WHERE h.facno = :facno"),
    @NamedQuery(name = "HKCG006.findByFacAddress", query = "SELECT h FROM HKCG006 h WHERE h.facAddress = :facAddress"),
    @NamedQuery(name = "HKCG006.findByRbtn1", query = "SELECT h FROM HKCG006 h WHERE h.rbtn1 = :rbtn1"),
    @NamedQuery(name = "HKCG006.findBySupman", query = "SELECT h FROM HKCG006 h WHERE h.supman = :supman"),
    @NamedQuery(name = "HKCG006.findByRbtn2", query = "SELECT h FROM HKCG006 h WHERE h.rbtn2 = :rbtn2"),
    @NamedQuery(name = "HKCG006.findByPSN", query = "SELECT h FROM HKCG006 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKCG006.findByFactel", query = "SELECT h FROM HKCG006 h WHERE h.factel = :factel"),
    @NamedQuery(name = "HKCG006.findByComfex", query = "SELECT h FROM HKCG006 h WHERE h.comfex = :comfex"),
    @NamedQuery(name = "HKCG006.findBySupno", query = "SELECT h FROM HKCG006 h WHERE h.supno = :supno"),
    @NamedQuery(name = "HKCG006.findBySupna", query = "SELECT h FROM HKCG006 h WHERE h.supna = :supna"),
    @NamedQuery(name = "HKCG006.findByFacfex", query = "SELECT h FROM HKCG006 h WHERE h.facfex = :facfex"),
    @NamedQuery(name = "HKCG006.findByTrl6", query = "SELECT h FROM HKCG006 h WHERE h.trl6 = :trl6"),
    @NamedQuery(name = "HKCG006.findByProduct", query = "SELECT h FROM HKCG006 h WHERE h.product = :product"),
    @NamedQuery(name = "HKCG006.findByTrl7", query = "SELECT h FROM HKCG006 h WHERE h.trl7 = :trl7"),
    @NamedQuery(name = "HKCG006.findByApplyUser", query = "SELECT h FROM HKCG006 h WHERE h.applyUser = :applyUser"),
    @NamedQuery(name = "HKCG006.findByComAddress", query = "SELECT h FROM HKCG006 h WHERE h.comAddress = :comAddress"),
    @NamedQuery(name = "HKCG006.findByApplyDept", query = "SELECT h FROM HKCG006 h WHERE h.applyDept = :applyDept"),
    @NamedQuery(name = "HKCG006.findByComtel", query = "SELECT h FROM HKCG006 h WHERE h.comtel = :comtel"),
    @NamedQuery(name = "HKCG006.findByTrl1", query = "SELECT h FROM HKCG006 h WHERE h.trl1 = :trl1"),
    @NamedQuery(name = "HKCG006.findByTrl2", query = "SELECT h FROM HKCG006 h WHERE h.trl2 = :trl2"),
    @NamedQuery(name = "HKCG006.findByTrl3", query = "SELECT h FROM HKCG006 h WHERE h.trl3 = :trl3"),
    @NamedQuery(name = "HKCG006.findByTrl4", query = "SELECT h FROM HKCG006 h WHERE h.trl4 = :trl4"),
    @NamedQuery(name = "HKCG006.findByFSN", query = "SELECT h FROM HKCG006 h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKCG006.findByTrl5", query = "SELECT h FROM HKCG006 h WHERE h.trl5 = :trl5")})
public class HKCG006 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Column(name = "createdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;
    @Size(max = 255)
    @Column(name = "parts")
    private String parts;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "facAddress")
    private String facAddress;
    @Size(max = 255)
    @Column(name = "rbtn1")
    private String rbtn1;
    @Size(max = 255)
    @Column(name = "supman")
    private String supman;
    @Size(max = 255)
    @Column(name = "rbtn2")
    private String rbtn2;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "factel")
    private String factel;
    @Size(max = 255)
    @Column(name = "comfex")
    private String comfex;
    @Size(max = 255)
    @Column(name = "supno")
    private String supno;
    @Size(max = 255)
    @Column(name = "supna")
    private String supna;
    @Size(max = 255)
    @Column(name = "facfex")
    private String facfex;
    @Size(max = 255)
    @Column(name = "trl6")
    private String trl6;
    @Size(max = 255)
    @Column(name = "product")
    private String product;
    @Size(max = 255)
    @Column(name = "trl7")
    private String trl7;
    @Size(max = 255)
    @Column(name = "applyUser")
    private String applyUser;
    @Size(max = 255)
    @Column(name = "comAddress")
    private String comAddress;
    @Size(max = 255)
    @Column(name = "applyDept")
    private String applyDept;
    @Size(max = 255)
    @Column(name = "comtel")
    private String comtel;
    @Size(max = 255)
    @Column(name = "trl1")
    private String trl1;
    @Size(max = 255)
    @Column(name = "trl2")
    private String trl2;
    @Size(max = 255)
    @Column(name = "trl3")
    private String trl3;
    @Size(max = 255)
    @Column(name = "trl4")
    private String trl4;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "trl5")
    private String trl5;

    public HKCG006() {
    }

    public HKCG006(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getParts() {
        return parts;
    }

    public void setParts(String parts) {
        this.parts = parts;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getFacAddress() {
        return facAddress;
    }

    public void setFacAddress(String facAddress) {
        this.facAddress = facAddress;
    }

    public String getRbtn1() {
        return rbtn1;
    }

    public void setRbtn1(String rbtn1) {
        this.rbtn1 = rbtn1;
    }

    public String getSupman() {
        return supman;
    }

    public void setSupman(String supman) {
        this.supman = supman;
    }

    public String getRbtn2() {
        return rbtn2;
    }

    public void setRbtn2(String rbtn2) {
        this.rbtn2 = rbtn2;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public String getFactel() {
        return factel;
    }

    public void setFactel(String factel) {
        this.factel = factel;
    }

    public String getComfex() {
        return comfex;
    }

    public void setComfex(String comfex) {
        this.comfex = comfex;
    }

    public String getSupno() {
        return supno;
    }

    public void setSupno(String supno) {
        this.supno = supno;
    }

    public String getSupna() {
        return supna;
    }

    public void setSupna(String supna) {
        this.supna = supna;
    }

    public String getFacfex() {
        return facfex;
    }

    public void setFacfex(String facfex) {
        this.facfex = facfex;
    }

    public String getTrl6() {
        return trl6;
    }

    public void setTrl6(String trl6) {
        this.trl6 = trl6;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getTrl7() {
        return trl7;
    }

    public void setTrl7(String trl7) {
        this.trl7 = trl7;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getComAddress() {
        return comAddress;
    }

    public void setComAddress(String comAddress) {
        this.comAddress = comAddress;
    }

    public String getApplyDept() {
        return applyDept;
    }

    public void setApplyDept(String applyDept) {
        this.applyDept = applyDept;
    }

    public String getComtel() {
        return comtel;
    }

    public void setComtel(String comtel) {
        this.comtel = comtel;
    }

    public String getTrl1() {
        return trl1;
    }

    public void setTrl1(String trl1) {
        this.trl1 = trl1;
    }

    public String getTrl2() {
        return trl2;
    }

    public void setTrl2(String trl2) {
        this.trl2 = trl2;
    }

    public String getTrl3() {
        return trl3;
    }

    public void setTrl3(String trl3) {
        this.trl3 = trl3;
    }

    public String getTrl4() {
        return trl4;
    }

    public void setTrl4(String trl4) {
        this.trl4 = trl4;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getTrl5() {
        return trl5;
    }

    public void setTrl5(String trl5) {
        this.trl5 = trl5;
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
        if (!(object instanceof HKCG006)) {
            return false;
        }
        HKCG006 other = (HKCG006) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKCG006[ oid=" + oid + " ]";
    }

}
