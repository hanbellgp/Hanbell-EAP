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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C2082
 */
@Entity
@Table(name = "HK_CW026")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKCW026.findAll", query = "SELECT h FROM HKCW026 h"),
    @NamedQuery(name = "HKCW026.findByFormid", query = "SELECT h FROM HKCW026 h WHERE h.formid = :formid"),
    @NamedQuery(name = "HKCW026.findByFacno", query = "SELECT h FROM HKCW026 h WHERE h.facno = :facno"),
    @NamedQuery(name = "HKCW026.findByDeptno2", query = "SELECT h FROM HKCW026 h WHERE h.deptno2 = :deptno2"),
    @NamedQuery(name = "HKCW026.findByPSN", query = "SELECT h FROM HKCW026 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKCW026.findByWarehouseno2", query = "SELECT h FROM HKCW026 h WHERE h.warehouseno2 = :warehouseno2"),
    @NamedQuery(name = "HKCW026.findByAssetname", query = "SELECT h FROM HKCW026 h WHERE h.assetname = :assetname"),
    @NamedQuery(name = "HKCW026.findByPosition4Name", query = "SELECT h FROM HKCW026 h WHERE h.position4Name = :position4Name"),
    @NamedQuery(name = "HKCW026.findByAssetno", query = "SELECT h FROM HKCW026 h WHERE h.assetno = :assetno"),
    @NamedQuery(name = "HKCW026.findByWarehouseno", query = "SELECT h FROM HKCW026 h WHERE h.warehouseno = :warehouseno"),
    @NamedQuery(name = "HKCW026.findByItdsc", query = "SELECT h FROM HKCW026 h WHERE h.itdsc = :itdsc"),
    @NamedQuery(name = "HKCW026.findByWarehousena2", query = "SELECT h FROM HKCW026 h WHERE h.warehousena2 = :warehousena2"),
    @NamedQuery(name = "HKCW026.findByPosition2Name", query = "SELECT h FROM HKCW026 h WHERE h.position2Name = :position2Name"),
    @NamedQuery(name = "HKCW026.findByFSN", query = "SELECT h FROM HKCW026 h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKCW026.findByPosition3Name", query = "SELECT h FROM HKCW026 h WHERE h.position3Name = :position3Name"),
    @NamedQuery(name = "HKCW026.findByDeptname2", query = "SELECT h FROM HKCW026 h WHERE h.deptname2 = :deptname2"),
    @NamedQuery(name = "HKCW026.findByUsername2", query = "SELECT h FROM HKCW026 h WHERE h.username2 = :username2"),
    @NamedQuery(name = "HKCW026.findByUserno2", query = "SELECT h FROM HKCW026 h WHERE h.userno2 = :userno2"),
    @NamedQuery(name = "HKCW026.findByPosition1Name", query = "SELECT h FROM HKCW026 h WHERE h.position1Name = :position1Name"),
    @NamedQuery(name = "HKCW026.findByPosition6Name", query = "SELECT h FROM HKCW026 h WHERE h.position6Name = :position6Name"),
    @NamedQuery(name = "HKCW026.findByCreator", query = "SELECT h FROM HKCW026 h WHERE h.creator = :creator"),
    @NamedQuery(name = "HKCW026.findByPosition1", query = "SELECT h FROM HKCW026 h WHERE h.position1 = :position1"),
    @NamedQuery(name = "HKCW026.findByPosition2", query = "SELECT h FROM HKCW026 h WHERE h.position2 = :position2"),
    @NamedQuery(name = "HKCW026.findByPosition3", query = "SELECT h FROM HKCW026 h WHERE h.position3 = :position3"),
    @NamedQuery(name = "HKCW026.findByItemno", query = "SELECT h FROM HKCW026 h WHERE h.itemno = :itemno"),
    @NamedQuery(name = "HKCW026.findByPosition4", query = "SELECT h FROM HKCW026 h WHERE h.position4 = :position4"),
    @NamedQuery(name = "HKCW026.findByOid", query = "SELECT h FROM HKCW026 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKCW026.findByPosition5", query = "SELECT h FROM HKCW026 h WHERE h.position5 = :position5"),
    @NamedQuery(name = "HKCW026.findByPosition6", query = "SELECT h FROM HKCW026 h WHERE h.position6 = :position6"),
    @NamedQuery(name = "HKCW026.findByDeptno", query = "SELECT h FROM HKCW026 h WHERE h.deptno = :deptno"),
    @NamedQuery(name = "HKCW026.findByDeptname", query = "SELECT h FROM HKCW026 h WHERE h.deptname = :deptname"),
    @NamedQuery(name = "HKCW026.findByUnit", query = "SELECT h FROM HKCW026 h WHERE h.unit = :unit"),
    @NamedQuery(name = "HKCW026.findBySerialNumber", query = "SELECT h FROM HKCW026 h WHERE h.serialNumber = :serialNumber"),
    @NamedQuery(name = "HKCW026.findByQty", query = "SELECT h FROM HKCW026 h WHERE h.qty = :qty"),
    @NamedQuery(name = "HKCW026.findByCfmuser", query = "SELECT h FROM HKCW026 h WHERE h.cfmuser = :cfmuser"),
    @NamedQuery(name = "HKCW026.findByPosition5Name", query = "SELECT h FROM HKCW026 h WHERE h.position5Name = :position5Name"),
    @NamedQuery(name = "HKCW026.findByWarehousena", query = "SELECT h FROM HKCW026 h WHERE h.warehousena = :warehousena"),
    @NamedQuery(name = "HKCW026.findByRemark", query = "SELECT h FROM HKCW026 h WHERE h.remark = :remark"),
    @NamedQuery(name = "HKCW026.findBySerialVersionUID", query = "SELECT h FROM HKCW026 h WHERE h.serialVersionUID = :serialVersionUID"),
    @NamedQuery(name = "HKCW026.findByFormdate", query = "SELECT h FROM HKCW026 h WHERE h.formdate = :formdate"),
    @NamedQuery(name = "HKCW026.findByStatus", query = "SELECT h FROM HKCW026 h WHERE h.status = :status"),
    @NamedQuery(name = "HKCW026.findByTitleDeptno", query = "SELECT h FROM HKCW026 h WHERE h.titleDeptno = :titleDeptno"),
    @NamedQuery(name = "HKCW026.findByUserno", query = "SELECT h FROM HKCW026 h WHERE h.userno = :userno"),
    @NamedQuery(name = "HKCW026.findByTitleDeptname", query = "SELECT h FROM HKCW026 h WHERE h.titleDeptname = :titleDeptname"),
    @NamedQuery(name = "HKCW026.findByUsername", query = "SELECT h FROM HKCW026 h WHERE h.username = :username"),
    @NamedQuery(name = "HKCW026.findByTransferUser", query = "SELECT h FROM HKCW026 h WHERE h.transferUser = :transferUser")})
public class HKCW026 implements Serializable {

    private static final long serialVersionUID1 = 1L;
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
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Size(max = 255)
    @Column(name = "warehouseno2")
    private String warehouseno2;
    @Size(max = 255)
    @Column(name = "assetname")
    private String assetname;
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
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "position3Name")
    private String position3Name;
    @Size(max = 255)
    @Column(name = "deptname2")
    private String deptname2;
    @Size(max = 255)
    @Column(name = "username2")
    private String username2;
    @Size(max = 255)
    @Column(name = "userno2")
    private String userno2;
    @Size(max = 255)
    @Column(name = "position1Name")
    private String position1Name;
    @Size(max = 255)
    @Column(name = "position6Name")
    private String position6Name;
    @Size(max = 255)
    @Column(name = "creator")
    private String creator;
    @Size(max = 255)
    @Column(name = "position1")
    private String position1;
    @Size(max = 255)
    @Column(name = "position2")
    private String position2;
    @Size(max = 255)
    @Column(name = "position3")
    private String position3;
    @Size(max = 255)
    @Column(name = "itemno")
    private String itemno;
    @Size(max = 255)
    @Column(name = "position4")
    private String position4;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Size(max = 255)
    @Column(name = "position5")
    private String position5;
    @Size(max = 255)
    @Column(name = "position6")
    private String position6;
    @Size(max = 255)
    @Column(name = "deptno")
    private String deptno;
    @Size(max = 255)
    @Column(name = "deptname")
    private String deptname;
    @Size(max = 255)
    @Column(name = "unit")
    private String unit;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "qty")
    private String qty;
    @Size(max = 255)
    @Column(name = "cfmuser")
    private String cfmuser;
    @Size(max = 255)
    @Column(name = "position5Name")
    private String position5Name;
    @Size(max = 255)
    @Column(name = "warehousena")
    private String warehousena;
    @Size(max = 255)
    @Column(name = "remark")
    private String remark;
    @Size(max = 255)
    @Column(name = "serialVersionUID")
    private String serialVersionUID;
    @Size(max = 255)
    @Column(name = "formdate")
    private String formdate;
    @Size(max = 255)
    @Column(name = "status")
    private String status;
    @Size(max = 255)
    @Column(name = "titleDeptno")
    private String titleDeptno;
    @Size(max = 255)
    @Column(name = "userno")
    private String userno;
    @Size(max = 255)
    @Column(name = "titleDeptname")
    private String titleDeptname;
    @Size(max = 255)
    @Column(name = "username")
    private String username;
    @Size(max = 255)
    @Column(name = "TransferUser")
    private String transferUser;

    //申请人
    @JoinColumn(name = "creator", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private Users applyUser;

    //审核人
    @JoinColumn(name = "cfmuser", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private Users cfmUser;
    
    
    public HKCW026() {
    }

    public HKCW026(String oid) {
        this.oid = oid;
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

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
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

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getPosition3Name() {
        return position3Name;
    }

    public void setPosition3Name(String position3Name) {
        this.position3Name = position3Name;
    }

    public String getDeptname2() {
        return deptname2;
    }

    public void setDeptname2(String deptname2) {
        this.deptname2 = deptname2;
    }

    public String getUsername2() {
        return username2;
    }

    public void setUsername2(String username2) {
        this.username2 = username2;
    }


    public String getUserno2() {
        return userno2;
    }

    public void setUserno2(String userno2) {
        this.userno2 = userno2;
    }


    public String getPosition1Name() {
        return position1Name;
    }

    public void setPosition1Name(String position1Name) {
        this.position1Name = position1Name;
    }

    public String getPosition6Name() {
        return position6Name;
    }

    public void setPosition6Name(String position6Name) {
        this.position6Name = position6Name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getPosition1() {
        return position1;
    }

    public void setPosition1(String position1) {
        this.position1 = position1;
    }

    public String getPosition2() {
        return position2;
    }

    public void setPosition2(String position2) {
        this.position2 = position2;
    }

    public String getPosition3() {
        return position3;
    }

    public void setPosition3(String position3) {
        this.position3 = position3;
    }

    public String getItemno() {
        return itemno;
    }

    public void setItemno(String itemno) {
        this.itemno = itemno;
    }

    public String getPosition4() {
        return position4;
    }

    public void setPosition4(String position4) {
        this.position4 = position4;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getPosition5() {
        return position5;
    }

    public void setPosition5(String position5) {
        this.position5 = position5;
    }

    public String getPosition6() {
        return position6;
    }

    public void setPosition6(String position6) {
        this.position6 = position6;
    }

    public String getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getCfmuser() {
        return cfmuser;
    }

    public void setCfmuser(String cfmuser) {
        this.cfmuser = cfmuser;
    }

    public String getPosition5Name() {
        return position5Name;
    }

    public void setPosition5Name(String position5Name) {
        this.position5Name = position5Name;
    }

    public String getWarehousena() {
        return warehousena;
    }

    public void setWarehousena(String warehousena) {
        this.warehousena = warehousena;
    }


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setSerialVersionUID(String serialVersionUID) {
        this.serialVersionUID = serialVersionUID;
    }

    public String getFormdate() {
        return formdate;
    }

    public void setFormdate(String formdate) {
        this.formdate = formdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitleDeptno() {
        return titleDeptno;
    }

    public void setTitleDeptno(String titleDeptno) {
        this.titleDeptno = titleDeptno;
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
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

    public String getTransferUser() {
        return transferUser;
    }

    public void setTransferUser(String transferUser) {
        this.transferUser = transferUser;
    }

    public Users getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(Users applyUser) {
        this.applyUser = applyUser;
    }

    public Users getCfmUser() {
        return cfmUser;
    }

    public void setCfmUser(Users cfmUser) {
        this.cfmUser = cfmUser;
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
        if (!(object instanceof HKCW026)) {
            return false;
        }
        HKCW026 other = (HKCW026) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKCW026[ oid=" + oid + " ]";
    }
    
}
