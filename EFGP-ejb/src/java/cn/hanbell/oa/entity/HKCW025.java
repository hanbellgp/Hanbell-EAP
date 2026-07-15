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
@Table(name = "HK_CW025")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKCW025.findAll", query = "SELECT h FROM HKCW025 h"),
    @NamedQuery(name = "HKCW025.findByFormid", query = "SELECT h FROM HKCW025 h WHERE h.formid = :formid"),
    @NamedQuery(name = "HKCW025.findByDeptno1", query = "SELECT h FROM HKCW025 h WHERE h.deptno1 = :deptno1"),
    @NamedQuery(name = "HKCW025.findByFacno", query = "SELECT h FROM HKCW025 h WHERE h.facno = :facno"),
    @NamedQuery(name = "HKCW025.findByPSN", query = "SELECT h FROM HKCW025 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HKCW025.findByWarehouseno2", query = "SELECT h FROM HKCW025 h WHERE h.warehouseno2 = :warehouseno2"),
    @NamedQuery(name = "HKCW025.findByAssetname", query = "SELECT h FROM HKCW025 h WHERE h.assetname = :assetname"),
    @NamedQuery(name = "HKCW025.findByPid", query = "SELECT h FROM HKCW025 h WHERE h.pid = :pid"),
    @NamedQuery(name = "HKCW025.findByRemark", query = "SELECT h FROM HKCW025 h WHERE h.remark = :remark"),
    @NamedQuery(name = "HKCW025.findByPosition4Name", query = "SELECT h FROM HKCW025 h WHERE h.position4Name = :position4Name"),
    @NamedQuery(name = "HKCW025.findByAssetno", query = "SELECT h FROM HKCW025 h WHERE h.assetno = :assetno"),
    @NamedQuery(name = "HKCW025.findByWarehouseno", query = "SELECT h FROM HKCW025 h WHERE h.warehouseno = :warehouseno"),
    @NamedQuery(name = "HKCW025.findByItdsc", query = "SELECT h FROM HKCW025 h WHERE h.itdsc = :itdsc"),
    @NamedQuery(name = "HKCW025.findByWarehousena2", query = "SELECT h FROM HKCW025 h WHERE h.warehousena2 = :warehousena2"),
    @NamedQuery(name = "HKCW025.findByPosition2Name", query = "SELECT h FROM HKCW025 h WHERE h.position2Name = :position2Name"),
    @NamedQuery(name = "HKCW025.findByDeptname1", query = "SELECT h FROM HKCW025 h WHERE h.deptname1 = :deptname1"),
    @NamedQuery(name = "HKCW025.findByUseman", query = "SELECT h FROM HKCW025 h WHERE h.useman = :useman"),
    @NamedQuery(name = "HKCW025.findByFSN", query = "SELECT h FROM HKCW025 h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKCW025.findByPosition3Name", query = "SELECT h FROM HKCW025 h WHERE h.position3Name = :position3Name"),
    @NamedQuery(name = "HKCW025.findByCfmdate", query = "SELECT h FROM HKCW025 h WHERE h.cfmdate = :cfmdate"),
    @NamedQuery(name = "HKCW025.findBySeq", query = "SELECT h FROM HKCW025 h WHERE h.seq = :seq"),
    @NamedQuery(name = "HKCW025.findByPosition1Name", query = "SELECT h FROM HKCW025 h WHERE h.position1Name = :position1Name"),
    @NamedQuery(name = "HKCW025.findByPosition6Name", query = "SELECT h FROM HKCW025 h WHERE h.position6Name = :position6Name"),
    @NamedQuery(name = "HKCW025.findByCreator", query = "SELECT h FROM HKCW025 h WHERE h.creator = :creator"),
    @NamedQuery(name = "HKCW025.findByIsERP", query = "SELECT h FROM HKCW025 h WHERE h.isERP = :isERP"),
    @NamedQuery(name = "HKCW025.findByUserno", query = "SELECT h FROM HKCW025 h WHERE h.userno = :userno"),
    @NamedQuery(name = "HKCW025.findByPosition1", query = "SELECT h FROM HKCW025 h WHERE h.position1 = :position1"),
    @NamedQuery(name = "HKCW025.findByPosition2", query = "SELECT h FROM HKCW025 h WHERE h.position2 = :position2"),
    @NamedQuery(name = "HKCW025.findByRelformid", query = "SELECT h FROM HKCW025 h WHERE h.relformid = :relformid"),
    @NamedQuery(name = "HKCW025.findByPosition3", query = "SELECT h FROM HKCW025 h WHERE h.position3 = :position3"),
    @NamedQuery(name = "HKCW025.findByItemno", query = "SELECT h FROM HKCW025 h WHERE h.itemno = :itemno"),
    @NamedQuery(name = "HKCW025.findByPosition4", query = "SELECT h FROM HKCW025 h WHERE h.position4 = :position4"),
    @NamedQuery(name = "HKCW025.findByOid", query = "SELECT h FROM HKCW025 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKCW025.findByPosition5", query = "SELECT h FROM HKCW025 h WHERE h.position5 = :position5"),
    @NamedQuery(name = "HKCW025.findByPosition6", query = "SELECT h FROM HKCW025 h WHERE h.position6 = :position6"),
    @NamedQuery(name = "HKCW025.findByDeptno", query = "SELECT h FROM HKCW025 h WHERE h.deptno = :deptno"),
    @NamedQuery(name = "HKCW025.findByDeptname", query = "SELECT h FROM HKCW025 h WHERE h.deptname = :deptname"),
    @NamedQuery(name = "HKCW025.findByFormdate", query = "SELECT h FROM HKCW025 h WHERE h.formdate = :formdate"),
    @NamedQuery(name = "HKCW025.findByUnit", query = "SELECT h FROM HKCW025 h WHERE h.unit = :unit"),
    @NamedQuery(name = "HKCW025.findBySerialNumber", query = "SELECT h FROM HKCW025 h WHERE h.serialNumber = :serialNumber"),
    @NamedQuery(name = "HKCW025.findByAssetid", query = "SELECT h FROM HKCW025 h WHERE h.assetid = :assetid"),
    @NamedQuery(name = "HKCW025.findByQty", query = "SELECT h FROM HKCW025 h WHERE h.qty = :qty"),
    @NamedQuery(name = "HKCW025.findByCfmuser", query = "SELECT h FROM HKCW025 h WHERE h.cfmuser = :cfmuser"),
    @NamedQuery(name = "HKCW025.findByPosition5Name", query = "SELECT h FROM HKCW025 h WHERE h.position5Name = :position5Name"),
    @NamedQuery(name = "HKCW025.findByWarehousena", query = "SELECT h FROM HKCW025 h WHERE h.warehousena = :warehousena"),
    @NamedQuery(name = "HKCW025.findByStatus", query = "SELECT h FROM HKCW025 h WHERE h.status = :status")})
public class HKCW025 implements Serializable {

    private static final long serialVersionUID1 = 1L;
    @Size(max = 255)
    @Column(name = "formid")
    private String formid;
    @Size(max = 255)
    @Column(name = "deptno1")
    private String deptno1;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
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
    @Column(name = "pid")
    private String pid;
    @Size(max = 255)
    @Column(name = "remark")
    private String remark;
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
    @Column(name = "deptname1")
    private String deptname1;
    @Size(max = 255)
    @Column(name = "useman")
    private String useman;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "position3Name")
    private String position3Name;
    @Size(max = 255)
    @Column(name = "cfmdate")
    private String cfmdate;
    @Size(max = 255)
    @Column(name = "seq")
    private String seq;
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
    @Column(name = "isERP")
    private String isERP;
    @Size(max = 255)
    @Column(name = "userno")
    private String userno;
    @Size(max = 255)
    @Column(name = "position1")
    private String position1;
    @Size(max = 255)
    @Column(name = "position2")
    private String position2;
    @Size(max = 255)
    @Column(name = "relformid")
    private String relformid;
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
    @Column(name = "formdate")
    private String formdate;
    @Size(max = 255)
    @Column(name = "unit")
    private String unit;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "assetid")
    private String assetid;
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
    @Column(name = "status")
    private String status;
    @Size(max = 255)
    @Column(name = "username")
    private String username;
    @Size(max = 255)
    @Column(name = "cfmuser_txt")
    private String cfmuserTxt;
    @Size(max = 255)
    @Column(name = "cfmuser_lbl")
    private String cfmuserLbl;

    //申请人
    @JoinColumn(name = "creator", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private Users applyUser;

    //申请部门
    @JoinColumn(name = "cfmuser", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = true)
    private Users cfmUser;
    
    public HKCW025() {
    }

    public HKCW025(String oid) {
        this.oid = oid;
    }

    public String getFormid() {
        return formid;
    }

    public void setFormid(String formid) {
        this.formid = formid;
    }

    public String getDeptno1() {
        return deptno1;
    }

    public void setDeptno1(String deptno1) {
        this.deptno1 = deptno1;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
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

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public String getDeptname1() {
        return deptname1;
    }

    public void setDeptname1(String deptname1) {
        this.deptname1 = deptname1;
    }

    public String getUseman() {
        return useman;
    }

    public void setUseman(String useman) {
        this.useman = useman;
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

    public String getCfmdate() {
        return cfmdate;
    }

    public void setCfmdate(String cfmdate) {
        this.cfmdate = cfmdate;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
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

    public String getIsERP() {
        return isERP;
    }

    public void setIsERP(String isERP) {
        this.isERP = isERP;
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
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

    public String getRelformid() {
        return relformid;
    }

    public void setRelformid(String relformid) {
        this.relformid = relformid;
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

    public String getFormdate() {
        return formdate;
    }

    public void setFormdate(String formdate) {
        this.formdate = formdate;
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

    public String getAssetid() {
        return assetid;
    }

    public void setAssetid(String assetid) {
        this.assetid = assetid;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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



    public String getCfmuserTxt() {
        return cfmuserTxt;
    }

    public void setCfmuserTxt(String cfmuserTxt) {
        this.cfmuserTxt = cfmuserTxt;
    }

    public String getCfmuserLbl() {
        return cfmuserLbl;
    }

    public void setCfmuserLbl(String cfmuserLbl) {
        this.cfmuserLbl = cfmuserLbl;
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
        if (!(object instanceof HKCW025)) {
            return false;
        }
        HKCW025 other = (HKCW025) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKCW025[ oid=" + oid + " ]";
    }
    
}
