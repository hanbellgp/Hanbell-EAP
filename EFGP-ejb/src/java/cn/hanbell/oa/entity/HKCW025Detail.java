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
@Table(name = "HK_CW025_Detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HKCW025Detail.findAll", query = "SELECT h FROM HKCW025Detail h"),
    @NamedQuery(name = "HKCW025Detail.findByDeptno1", query = "SELECT h FROM HKCW025Detail h WHERE h.deptno1 = :deptno1"),
    @NamedQuery(name = "HKCW025Detail.findByWarehouseno2", query = "SELECT h FROM HKCW025Detail h WHERE h.warehouseno2 = :warehouseno2"),
    @NamedQuery(name = "HKCW025Detail.findByAssetname", query = "SELECT h FROM HKCW025Detail h WHERE h.assetname = :assetname"),
    @NamedQuery(name = "HKCW025Detail.findByPid", query = "SELECT h FROM HKCW025Detail h WHERE h.pid = :pid"),
    @NamedQuery(name = "HKCW025Detail.findByPosition4Name", query = "SELECT h FROM HKCW025Detail h WHERE h.position4Name = :position4Name"),
    @NamedQuery(name = "HKCW025Detail.findByAssetno", query = "SELECT h FROM HKCW025Detail h WHERE h.assetno = :assetno"),
    @NamedQuery(name = "HKCW025Detail.findByWarehouseno", query = "SELECT h FROM HKCW025Detail h WHERE h.warehouseno = :warehouseno"),
    @NamedQuery(name = "HKCW025Detail.findByItdsc", query = "SELECT h FROM HKCW025Detail h WHERE h.itdsc = :itdsc"),
    @NamedQuery(name = "HKCW025Detail.findByWarehousena2", query = "SELECT h FROM HKCW025Detail h WHERE h.warehousena2 = :warehousena2"),
    @NamedQuery(name = "HKCW025Detail.findByPosition2Name", query = "SELECT h FROM HKCW025Detail h WHERE h.position2Name = :position2Name"),
    @NamedQuery(name = "HKCW025Detail.findByDeptname1", query = "SELECT h FROM HKCW025Detail h WHERE h.deptname1 = :deptname1"),
    @NamedQuery(name = "HKCW025Detail.findByFSN", query = "SELECT h FROM HKCW025Detail h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HKCW025Detail.findByPosition3Name", query = "SELECT h FROM HKCW025Detail h WHERE h.position3Name = :position3Name"),
    @NamedQuery(name = "HKCW025Detail.findBySeq", query = "SELECT h FROM HKCW025Detail h WHERE h.seq = :seq"),
    @NamedQuery(name = "HKCW025Detail.findByPosition1Name", query = "SELECT h FROM HKCW025Detail h WHERE h.position1Name = :position1Name"),
    @NamedQuery(name = "HKCW025Detail.findByPosition6Name", query = "SELECT h FROM HKCW025Detail h WHERE h.position6Name = :position6Name"),
    @NamedQuery(name = "HKCW025Detail.findByUserno", query = "SELECT h FROM HKCW025Detail h WHERE h.userno = :userno"),
    @NamedQuery(name = "HKCW025Detail.findByPosition1", query = "SELECT h FROM HKCW025Detail h WHERE h.position1 = :position1"),
    @NamedQuery(name = "HKCW025Detail.findByPosition2", query = "SELECT h FROM HKCW025Detail h WHERE h.position2 = :position2"),
    @NamedQuery(name = "HKCW025Detail.findByPosition3", query = "SELECT h FROM HKCW025Detail h WHERE h.position3 = :position3"),
    @NamedQuery(name = "HKCW025Detail.findByItemno", query = "SELECT h FROM HKCW025Detail h WHERE h.itemno = :itemno"),
    @NamedQuery(name = "HKCW025Detail.findByPosition4", query = "SELECT h FROM HKCW025Detail h WHERE h.position4 = :position4"),
    @NamedQuery(name = "HKCW025Detail.findByOid", query = "SELECT h FROM HKCW025Detail h WHERE h.oid = :oid"),
    @NamedQuery(name = "HKCW025Detail.findByPosition5", query = "SELECT h FROM HKCW025Detail h WHERE h.position5 = :position5"),
    @NamedQuery(name = "HKCW025Detail.findByPosition6", query = "SELECT h FROM HKCW025Detail h WHERE h.position6 = :position6"),
    @NamedQuery(name = "HKCW025Detail.findBySerialNo", query = "SELECT h FROM HKCW025Detail h WHERE h.serialNo = :serialNo"),
    @NamedQuery(name = "HKCW025Detail.findByUnit", query = "SELECT h FROM HKCW025Detail h WHERE h.unit = :unit"),
    @NamedQuery(name = "HKCW025Detail.findByAssetid", query = "SELECT h FROM HKCW025Detail h WHERE h.assetid = :assetid"),
    @NamedQuery(name = "HKCW025Detail.findByQty", query = "SELECT h FROM HKCW025Detail h WHERE h.qty = :qty"),
    @NamedQuery(name = "HKCW025Detail.findByPosition5Name", query = "SELECT h FROM HKCW025Detail h WHERE h.position5Name = :position5Name"),
    @NamedQuery(name = "HKCW025Detail.findByWarehousena", query = "SELECT h FROM HKCW025Detail h WHERE h.warehousena = :warehousena"),
    @NamedQuery(name = "HKCW025Detail.findByUsername", query = "SELECT h FROM HKCW025Detail h WHERE h.username = :username")})
public class HKCW025Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "deptno1")
    private String deptno1;
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
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "position3Name")
    private String position3Name;
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
    @Column(name = "userno")
    private String userno;
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
    @Column(name = "serialNo")
    private String serialNo;
    @Size(max = 255)
    @Column(name = "unit")
    private String unit;
    @Size(max = 255)
    @Column(name = "assetid")
    private String assetid;
    @Size(max = 255)
    @Column(name = "qty")
    private String qty;
    @Size(max = 255)
    @Column(name = "position5Name")
    private String position5Name;
    @Size(max = 255)
    @Column(name = "warehousena")
    private String warehousena;
    @Size(max = 255)
    @Column(name = "username")
    private String username;

    public HKCW025Detail() {
    }

    public HKCW025Detail(String oid) {
        this.oid = oid;
    }

    public String getDeptno1() {
        return deptno1;
    }

    public void setDeptno1(String deptno1) {
        this.deptno1 = deptno1;
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

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        if (!(object instanceof HKCW025Detail)) {
            return false;
        }
        HKCW025Detail other = (HKCW025Detail) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKCW025Detail[ oid=" + oid + " ]";
    }
    
}
