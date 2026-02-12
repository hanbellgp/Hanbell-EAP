/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cn.hanbell.oa.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.validation.constraints.Size;

/**
 *
 * @author S31106868hb
 */
public class HKCW026 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "formid")
    private String formid;

    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "deptno2")
    private String deptno2;
    @Size(max = 255)
    @Column(name = "warehouseno2")
    private String warehouseno2;
    @Size(max = 255)
    @Column(name = "assetname")
    private String assetname;
    @Size(max = 255)
    @Column(name = "formdate")
    private String formdate;
    @Size(max = 255)
    @Column(name = "position4Name")
    private String position4Name;

    @Size(max = 255)
    @Column(name = "assetno")
    private String assetno;
    @Size(max = 255)
    @Column(name = "warehouseno")
    private String warehouseno;
    @Size(max = 255)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "warehousena2")
    private String warehousena2;
    @Size(max = 255)
    @Column(name = "position2Name")
    private String position2Name;
    @Size(max = 255)
    @Column(name = "titleDeptno")
    private String titleDeptno;
    @Size(max = 255)
    @Column(name = "titleDeptname")
    private String titleDeptname;
    @Size(max = 255)
    @Column(name = "remark")
    private String remark;

    @Size(max = 255)
    @Column(name = "username")
    private String username;
    @Size(max = 255)
    @Column(name = "userno")
    private String userno;
    @Size(max = 255)
    @Column(name = "creator")
    private String creator;
    @Size(max = 255)
    @Column(name = "cfmuser")
    private String cfmuser;
    @Size(max = 255)
    @Column(name = "status")
    private String status;

    @Size(max = 255)
    @Column(name = "TransferUser")
    private String TransferUser;

    public HKCW026() {
    }

    public String getTransferUser() {
        return TransferUser;
    }

    public String getCfmuser() {
        return cfmuser;
    }

    public void setCfmuser(String cfmuser) {
        this.cfmuser = cfmuser;
    }

    public void setTransferUser(String TransferUser) {
        this.TransferUser = TransferUser;
    }

    public String getFormdate() {
        return formdate;
    }

    public void setFormdate(String formdate) {
        this.formdate = formdate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFormid() {
        return formid;
    }

    public void setFormid(String formid) {
        this.formid = formid;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getDeptno2() {
        return deptno2;
    }

    public void setDeptno2(String deptno2) {
        this.deptno2 = deptno2;
    }

    public String getWarehouseno2() {
        return warehouseno2;
    }

    public void setWarehouseno2(String warehouseno2) {
        this.warehouseno2 = warehouseno2;
    }

    public String getAssetname() {
        return assetname;
    }

    public void setAssetname(String assetname) {
        this.assetname = assetname;
    }

    public String getPosition4Name() {
        return position4Name;
    }

    public void setPosition4Name(String position4Name) {
        this.position4Name = position4Name;
    }

    public String getAssetno() {
        return assetno;
    }

    public void setAssetno(String assetno) {
        this.assetno = assetno;
    }

    public String getWarehouseno() {
        return warehouseno;
    }

    public void setWarehouseno(String warehouseno) {
        this.warehouseno = warehouseno;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getWarehousena2() {
        return warehousena2;
    }

    public void setWarehousena2(String warehousena2) {
        this.warehousena2 = warehousena2;
    }

    public String getPosition2Name() {
        return position2Name;
    }

    public void setPosition2Name(String position2Name) {
        this.position2Name = position2Name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getTitleDeptno() {
        return titleDeptno;
    }

    public void setTitleDeptno(String titleDeptno) {
        this.titleDeptno = titleDeptno;
    }

    public String getTitleDeptname() {
        return titleDeptname;
    }

    public void setTitleDeptname(String titleDeptname) {
        this.titleDeptname = titleDeptname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HKCW026)) {
            return false;
        }
        HKCW026 other = (HKCW026) object;
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKCW026";
    }

}
