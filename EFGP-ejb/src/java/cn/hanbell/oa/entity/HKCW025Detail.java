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
    @Size(max = 255)
    @Column(name = "position5")
    private String position5;
    @Size(max = 255)
    @Column(name = "position6")
    private String position6;

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
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HKCW025Detail)) {
            return false;
        }
        HKCW025Detail other = (HKCW025Detail) object;
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HKCW025Detail";
    }
    
}
