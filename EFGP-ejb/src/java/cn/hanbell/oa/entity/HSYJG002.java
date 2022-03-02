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
 * @author Administrator
 */
@Entity
@Table(name = "HSY_JG002")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HSYJG002.findAll", query = "SELECT h FROM HSYJG002 h"),
    @NamedQuery(name = "HSYJG002.findByJgc6", query = "SELECT h FROM HSYJG002 h WHERE h.jgc6 = :jgc6"),
    @NamedQuery(name = "HSYJG002.findByPSN", query = "SELECT h FROM HSYJG002 h WHERE h.processSerialNumber = :psn"),
    @NamedQuery(name = "HSYJG002.findByCreatedate", query = "SELECT h FROM HSYJG002 h WHERE h.createdate = :createdate"),
    @NamedQuery(name = "HSYJG002.findByType", query = "SELECT h FROM HSYJG002 h WHERE h.type = :type"),
    @NamedQuery(name = "HSYJG002.findByMjmc4", query = "SELECT h FROM HSYJG002 h WHERE h.mjmc4 = :mjmc4"),
    @NamedQuery(name = "HSYJG002.findByMjmc3", query = "SELECT h FROM HSYJG002 h WHERE h.mjmc3 = :mjmc3"),
    @NamedQuery(name = "HSYJG002.findByMjmc6", query = "SELECT h FROM HSYJG002 h WHERE h.mjmc6 = :mjmc6"),
    @NamedQuery(name = "HSYJG002.findByMjmc5", query = "SELECT h FROM HSYJG002 h WHERE h.mjmc5 = :mjmc5"),
    @NamedQuery(name = "HSYJG002.findByBeiz4", query = "SELECT h FROM HSYJG002 h WHERE h.beiz4 = :beiz4"),
    @NamedQuery(name = "HSYJG002.findByBeiz5", query = "SELECT h FROM HSYJG002 h WHERE h.beiz5 = :beiz5"),
    @NamedQuery(name = "HSYJG002.findByBeiz6", query = "SELECT h FROM HSYJG002 h WHERE h.beiz6 = :beiz6"),
    @NamedQuery(name = "HSYJG002.findByJgc1", query = "SELECT h FROM HSYJG002 h WHERE h.jgc1 = :jgc1"),
    @NamedQuery(name = "HSYJG002.findByJgc3", query = "SELECT h FROM HSYJG002 h WHERE h.jgc3 = :jgc3"),
    @NamedQuery(name = "HSYJG002.findByJgc2", query = "SELECT h FROM HSYJG002 h WHERE h.jgc2 = :jgc2"),
    @NamedQuery(name = "HSYJG002.findByJgc5", query = "SELECT h FROM HSYJG002 h WHERE h.jgc5 = :jgc5"),
    @NamedQuery(name = "HSYJG002.findByJgc4", query = "SELECT h FROM HSYJG002 h WHERE h.jgc4 = :jgc4"),
    @NamedQuery(name = "HSYJG002.findByMjc6", query = "SELECT h FROM HSYJG002 h WHERE h.mjc6 = :mjc6"),
    @NamedQuery(name = "HSYJG002.findByOID", query = "SELECT h FROM HSYJG002 h WHERE h.oid = :oid"),
    @NamedQuery(name = "HSYJG002.findByLendDate", query = "SELECT h FROM HSYJG002 h WHERE h.lendDate = :lendDate"),
    @NamedQuery(name = "HSYJG002.findByMjmc2", query = "SELECT h FROM HSYJG002 h WHERE h.mjmc2 = :mjmc2"),
    @NamedQuery(name = "HSYJG002.findByMjmc1", query = "SELECT h FROM HSYJG002 h WHERE h.mjmc1 = :mjmc1"),
    @NamedQuery(name = "HSYJG002.findByMjc1", query = "SELECT h FROM HSYJG002 h WHERE h.mjc1 = :mjc1"),
    @NamedQuery(name = "HSYJG002.findByMjc5", query = "SELECT h FROM HSYJG002 h WHERE h.mjc5 = :mjc5"),
    @NamedQuery(name = "HSYJG002.findByMjc4", query = "SELECT h FROM HSYJG002 h WHERE h.mjc4 = :mjc4"),
    @NamedQuery(name = "HSYJG002.findByMjc3", query = "SELECT h FROM HSYJG002 h WHERE h.mjc3 = :mjc3"),
    @NamedQuery(name = "HSYJG002.findByMjc2", query = "SELECT h FROM HSYJG002 h WHERE h.mjc2 = :mjc2"),
    @NamedQuery(name = "HSYJG002.findByMjjh2", query = "SELECT h FROM HSYJG002 h WHERE h.mjjh2 = :mjjh2"),
    @NamedQuery(name = "HSYJG002.findByMjjh1", query = "SELECT h FROM HSYJG002 h WHERE h.mjjh1 = :mjjh1"),
    @NamedQuery(name = "HSYJG002.findByMjjh4", query = "SELECT h FROM HSYJG002 h WHERE h.mjjh4 = :mjjh4"),
    @NamedQuery(name = "HSYJG002.findByMjjh3", query = "SELECT h FROM HSYJG002 h WHERE h.mjjh3 = :mjjh3"),
    @NamedQuery(name = "HSYJG002.findByMjjh6", query = "SELECT h FROM HSYJG002 h WHERE h.mjjh6 = :mjjh6"),
    @NamedQuery(name = "HSYJG002.findByMjjh5", query = "SELECT h FROM HSYJG002 h WHERE h.mjjh5 = :mjjh5"),
    @NamedQuery(name = "HSYJG002.findByZjc4", query = "SELECT h FROM HSYJG002 h WHERE h.zjc4 = :zjc4"),
    @NamedQuery(name = "HSYJG002.findByZjc3", query = "SELECT h FROM HSYJG002 h WHERE h.zjc3 = :zjc3"),
    @NamedQuery(name = "HSYJG002.findByFSN", query = "SELECT h FROM HSYJG002 h WHERE h.formSerialNumber = :fsn"),
    @NamedQuery(name = "HSYJG002.findByYdnr1", query = "SELECT h FROM HSYJG002 h WHERE h.ydnr1 = :ydnr1"),
    @NamedQuery(name = "HSYJG002.findByZjc6", query = "SELECT h FROM HSYJG002 h WHERE h.zjc6 = :zjc6"),
    @NamedQuery(name = "HSYJG002.findByYdnr2", query = "SELECT h FROM HSYJG002 h WHERE h.ydnr2 = :ydnr2"),
    @NamedQuery(name = "HSYJG002.findByZjc5", query = "SELECT h FROM HSYJG002 h WHERE h.zjc5 = :zjc5"),
    @NamedQuery(name = "HSYJG002.findByYdnr3", query = "SELECT h FROM HSYJG002 h WHERE h.ydnr3 = :ydnr3"),
    @NamedQuery(name = "HSYJG002.findByYdnr4", query = "SELECT h FROM HSYJG002 h WHERE h.ydnr4 = :ydnr4"),
    @NamedQuery(name = "HSYJG002.findByYdnr5", query = "SELECT h FROM HSYJG002 h WHERE h.ydnr5 = :ydnr5"),
    @NamedQuery(name = "HSYJG002.findByYdnr6", query = "SELECT h FROM HSYJG002 h WHERE h.ydnr6 = :ydnr6"),
    @NamedQuery(name = "HSYJG002.findByYdlx1", query = "SELECT h FROM HSYJG002 h WHERE h.ydlx1 = :ydlx1"),
    @NamedQuery(name = "HSYJG002.findByYdlx2", query = "SELECT h FROM HSYJG002 h WHERE h.ydlx2 = :ydlx2"),
    @NamedQuery(name = "HSYJG002.findByYdlx3", query = "SELECT h FROM HSYJG002 h WHERE h.ydlx3 = :ydlx3"),
    @NamedQuery(name = "HSYJG002.findByYdlx4", query = "SELECT h FROM HSYJG002 h WHERE h.ydlx4 = :ydlx4"),
    @NamedQuery(name = "HSYJG002.findByYdlx5", query = "SELECT h FROM HSYJG002 h WHERE h.ydlx5 = :ydlx5"),
    @NamedQuery(name = "HSYJG002.findByZjc2", query = "SELECT h FROM HSYJG002 h WHERE h.zjc2 = :zjc2"),
    @NamedQuery(name = "HSYJG002.findByYdlx6", query = "SELECT h FROM HSYJG002 h WHERE h.ydlx6 = :ydlx6"),
    @NamedQuery(name = "HSYJG002.findByZjc1", query = "SELECT h FROM HSYJG002 h WHERE h.zjc1 = :zjc1"),
    @NamedQuery(name = "HSYJG002.findByBeiz1", query = "SELECT h FROM HSYJG002 h WHERE h.beiz1 = :beiz1"),
    @NamedQuery(name = "HSYJG002.findByBeiz2", query = "SELECT h FROM HSYJG002 h WHERE h.beiz2 = :beiz2"),
    @NamedQuery(name = "HSYJG002.findByBeiz3", query = "SELECT h FROM HSYJG002 h WHERE h.beiz3 = :beiz3"),
    @NamedQuery(name = "HSYJG002.findByDept", query = "SELECT h FROM HSYJG002 h WHERE h.dept = :dept"),
    @NamedQuery(name = "HSYJG002.findByApplyUser", query = "SELECT h FROM HSYJG002 h WHERE h.applyUser = :applyUser"),
    @NamedQuery(name = "HSYJG002.findByReturnDate", query = "SELECT h FROM HSYJG002 h WHERE h.returnDate = :returnDate"),
    @NamedQuery(name = "HSYJG002.findByCompany", query = "SELECT h FROM HSYJG002 h WHERE h.company = :company"),
    @NamedQuery(name = "HSYJG002.findByFormid", query = "SELECT h FROM HSYJG002 h WHERE h.formid = :formid"),
    @NamedQuery(name = "HSYJG002.findByModingFactory", query = "SELECT h FROM HSYJG002 h WHERE h.modingFactory = :modingFactory"),
    @NamedQuery(name = "HSYJG002.findByFacno", query = "SELECT h FROM HSYJG002 h WHERE h.facno = :facno"),
    @NamedQuery(name = "HSYJG002.findByChangeType", query = "SELECT h FROM HSYJG002 h WHERE h.changeType = :changeType"),
    @NamedQuery(name = "HSYJG002.findByCastingPlant", query = "SELECT h FROM HSYJG002 h WHERE h.castingPlant = :castingPlant"),
    @NamedQuery(name = "HSYJG002.findByRemark", query = "SELECT h FROM HSYJG002 h WHERE h.remark = :remark"),
    @NamedQuery(name = "HSYJG002.findByItnbr", query = "SELECT h FROM HSYJG002 h WHERE h.itnbr = :itnbr"),
    @NamedQuery(name = "HSYJG002.findByApplyDept", query = "SELECT h FROM HSYJG002 h WHERE h.applyDept = :applyDept"),
    @NamedQuery(name = "HSYJG002.findBySerialNumber", query = "SELECT h FROM HSYJG002 h WHERE h.serialNumber = :serialNumber"),
    @NamedQuery(name = "HSYJG002.findByItdsc", query = "SELECT h FROM HSYJG002 h WHERE h.itdsc = :itdsc"),
    @NamedQuery(name = "HSYJG002.findByChangeContent", query = "SELECT h FROM HSYJG002 h WHERE h.changeContent = :changeContent"),
    @NamedQuery(name = "HSYJG002.findByProcessingPlant", query = "SELECT h FROM HSYJG002 h WHERE h.processingPlant = :processingPlant")})
public class HSYJG002 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "jgc6")
    private String jgc6;
    @Size(max = 255)
    @Column(name = "processSerialNumber")
    private String processSerialNumber;
    @Column(name = "createdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;
    @Size(max = 255)
    @Column(name = "type")
    private String type;
    @Size(max = 255)
    @Column(name = "mjmc4")
    private String mjmc4;
    @Size(max = 255)
    @Column(name = "mjmc3")
    private String mjmc3;
    @Size(max = 255)
    @Column(name = "mjmc6")
    private String mjmc6;
    @Size(max = 255)
    @Column(name = "mjmc5")
    private String mjmc5;
    @Size(max = 255)
    @Column(name = "beiz4")
    private String beiz4;
    @Size(max = 255)
    @Column(name = "beiz5")
    private String beiz5;
    @Size(max = 255)
    @Column(name = "beiz6")
    private String beiz6;
    @Size(max = 255)
    @Column(name = "jgc1")
    private String jgc1;
    @Size(max = 255)
    @Column(name = "jgc3")
    private String jgc3;
    @Size(max = 255)
    @Column(name = "jgc2")
    private String jgc2;
    @Size(max = 255)
    @Column(name = "jgc5")
    private String jgc5;
    @Size(max = 255)
    @Column(name = "jgc4")
    private String jgc4;
    @Size(max = 255)
    @Column(name = "mjc6")
    private String mjc6;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "OID")
    private String oid;
    @Column(name = "lendDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lendDate;
    @Size(max = 255)
    @Column(name = "mjmc2")
    private String mjmc2;
    @Size(max = 255)
    @Column(name = "mjmc1")
    private String mjmc1;
    @Size(max = 255)
    @Column(name = "mjc1")
    private String mjc1;
    @Size(max = 255)
    @Column(name = "mjc5")
    private String mjc5;
    @Size(max = 255)
    @Column(name = "mjc4")
    private String mjc4;
    @Size(max = 255)
    @Column(name = "mjc3")
    private String mjc3;
    @Size(max = 255)
    @Column(name = "mjc2")
    private String mjc2;
    @Size(max = 255)
    @Column(name = "mjjh2")
    private String mjjh2;
    @Size(max = 255)
    @Column(name = "mjjh1")
    private String mjjh1;
    @Size(max = 255)
    @Column(name = "mjjh4")
    private String mjjh4;
    @Size(max = 255)
    @Column(name = "mjjh3")
    private String mjjh3;
    @Size(max = 255)
    @Column(name = "mjjh6")
    private String mjjh6;
    @Size(max = 255)
    @Column(name = "mjjh5")
    private String mjjh5;
    @Size(max = 255)
    @Column(name = "zjc4")
    private String zjc4;
    @Size(max = 255)
    @Column(name = "zjc3")
    private String zjc3;
    @Size(max = 255)
    @Column(name = "formSerialNumber")
    private String formSerialNumber;
    @Size(max = 255)
    @Column(name = "ydnr1")
    private String ydnr1;
    @Size(max = 255)
    @Column(name = "zjc6")
    private String zjc6;
    @Size(max = 255)
    @Column(name = "ydnr2")
    private String ydnr2;
    @Size(max = 255)
    @Column(name = "zjc5")
    private String zjc5;
    @Size(max = 255)
    @Column(name = "ydnr3")
    private String ydnr3;
    @Size(max = 255)
    @Column(name = "ydnr4")
    private String ydnr4;
    @Size(max = 255)
    @Column(name = "ydnr5")
    private String ydnr5;
    @Size(max = 255)
    @Column(name = "ydnr6")
    private String ydnr6;
    @Size(max = 255)
    @Column(name = "ydlx1")
    private String ydlx1;
    @Size(max = 255)
    @Column(name = "ydlx2")
    private String ydlx2;
    @Size(max = 255)
    @Column(name = "ydlx3")
    private String ydlx3;
    @Size(max = 255)
    @Column(name = "ydlx4")
    private String ydlx4;
    @Size(max = 255)
    @Column(name = "ydlx5")
    private String ydlx5;
    @Size(max = 255)
    @Column(name = "zjc2")
    private String zjc2;
    @Size(max = 255)
    @Column(name = "ydlx6")
    private String ydlx6;
    @Size(max = 255)
    @Column(name = "zjc1")
    private String zjc1;
    @Size(max = 255)
    @Column(name = "beiz1")
    private String beiz1;
    @Size(max = 255)
    @Column(name = "beiz2")
    private String beiz2;
    @Size(max = 255)
    @Column(name = "beiz3")
    private String beiz3;
    @Size(max = 255)
    @Column(name = "dept")
    private String dept;
    @Size(max = 255)
    @Column(name = "applyUser")
    private String applyUser;
    @Column(name = "returnDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date returnDate;
    @Size(max = 255)
    @Column(name = "Company")
    private String company;
    @Size(max = 255)
    @Column(name = "formid")
    private String formid;
    @Size(max = 255)
    @Column(name = "modingFactory")
    private String modingFactory;
    @Size(max = 255)
    @Column(name = "facno")
    private String facno;
    @Size(max = 255)
    @Column(name = "changeType")
    private String changeType;
    @Size(max = 255)
    @Column(name = "castingPlant")
    private String castingPlant;
    @Size(max = 4000)
    @Column(name = "remark")
    private String remark;
    @Size(max = 255)
    @Column(name = "itnbr")
    private String itnbr;
    @Size(max = 255)
    @Column(name = "applyDept")
    private String applyDept;
    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;
    @Size(max = 255)
    @Column(name = "itdsc")
    private String itdsc;
    @Size(max = 255)
    @Column(name = "changeContent")
    private String changeContent;
    @Size(max = 255)
    @Column(name = "processingPlant")
    private String processingPlant;
    @Size(max = 255)
    @Column(name = "positionOld")
    private String positionOld;
    @Size(max = 255)
    @Column(name = "positionNew")
    private String positionNew;
    
    public HSYJG002() {
    }

    public HSYJG002(String oid) {
        this.oid = oid;
    }

    public String getJgc6() {
        return jgc6;
    }

    public void setJgc6(String jgc6) {
        this.jgc6 = jgc6;
    }

    public String getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(String processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMjmc4() {
        return mjmc4;
    }

    public void setMjmc4(String mjmc4) {
        this.mjmc4 = mjmc4;
    }

    public String getMjmc3() {
        return mjmc3;
    }

    public void setMjmc3(String mjmc3) {
        this.mjmc3 = mjmc3;
    }

    public String getMjmc6() {
        return mjmc6;
    }

    public void setMjmc6(String mjmc6) {
        this.mjmc6 = mjmc6;
    }

    public String getMjmc5() {
        return mjmc5;
    }

    public void setMjmc5(String mjmc5) {
        this.mjmc5 = mjmc5;
    }

    public String getBeiz4() {
        return beiz4;
    }

    public void setBeiz4(String beiz4) {
        this.beiz4 = beiz4;
    }

    public String getBeiz5() {
        return beiz5;
    }

    public void setBeiz5(String beiz5) {
        this.beiz5 = beiz5;
    }

    public String getBeiz6() {
        return beiz6;
    }

    public void setBeiz6(String beiz6) {
        this.beiz6 = beiz6;
    }

    public String getJgc1() {
        return jgc1;
    }

    public void setJgc1(String jgc1) {
        this.jgc1 = jgc1;
    }

    public String getJgc3() {
        return jgc3;
    }

    public void setJgc3(String jgc3) {
        this.jgc3 = jgc3;
    }

    public String getJgc2() {
        return jgc2;
    }

    public void setJgc2(String jgc2) {
        this.jgc2 = jgc2;
    }

    public String getJgc5() {
        return jgc5;
    }

    public void setJgc5(String jgc5) {
        this.jgc5 = jgc5;
    }

    public String getJgc4() {
        return jgc4;
    }

    public void setJgc4(String jgc4) {
        this.jgc4 = jgc4;
    }

    public String getMjc6() {
        return mjc6;
    }

    public void setMjc6(String mjc6) {
        this.mjc6 = mjc6;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Date getLendDate() {
        return lendDate;
    }

    public void setLendDate(Date lendDate) {
        this.lendDate = lendDate;
    }

    public String getMjmc2() {
        return mjmc2;
    }

    public void setMjmc2(String mjmc2) {
        this.mjmc2 = mjmc2;
    }

    public String getMjmc1() {
        return mjmc1;
    }

    public void setMjmc1(String mjmc1) {
        this.mjmc1 = mjmc1;
    }

    public String getMjc1() {
        return mjc1;
    }

    public void setMjc1(String mjc1) {
        this.mjc1 = mjc1;
    }

    public String getMjc5() {
        return mjc5;
    }

    public void setMjc5(String mjc5) {
        this.mjc5 = mjc5;
    }

    public String getMjc4() {
        return mjc4;
    }

    public void setMjc4(String mjc4) {
        this.mjc4 = mjc4;
    }

    public String getMjc3() {
        return mjc3;
    }

    public void setMjc3(String mjc3) {
        this.mjc3 = mjc3;
    }

    public String getMjc2() {
        return mjc2;
    }

    public void setMjc2(String mjc2) {
        this.mjc2 = mjc2;
    }

    public String getMjjh2() {
        return mjjh2;
    }

    public void setMjjh2(String mjjh2) {
        this.mjjh2 = mjjh2;
    }

    public String getMjjh1() {
        return mjjh1;
    }

    public void setMjjh1(String mjjh1) {
        this.mjjh1 = mjjh1;
    }

    public String getMjjh4() {
        return mjjh4;
    }

    public void setMjjh4(String mjjh4) {
        this.mjjh4 = mjjh4;
    }

    public String getMjjh3() {
        return mjjh3;
    }

    public void setMjjh3(String mjjh3) {
        this.mjjh3 = mjjh3;
    }

    public String getMjjh6() {
        return mjjh6;
    }

    public void setMjjh6(String mjjh6) {
        this.mjjh6 = mjjh6;
    }

    public String getMjjh5() {
        return mjjh5;
    }

    public void setMjjh5(String mjjh5) {
        this.mjjh5 = mjjh5;
    }

    public String getZjc4() {
        return zjc4;
    }

    public void setZjc4(String zjc4) {
        this.zjc4 = zjc4;
    }

    public String getZjc3() {
        return zjc3;
    }

    public void setZjc3(String zjc3) {
        this.zjc3 = zjc3;
    }

    public String getFormSerialNumber() {
        return formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getYdnr1() {
        return ydnr1;
    }

    public void setYdnr1(String ydnr1) {
        this.ydnr1 = ydnr1;
    }

    public String getZjc6() {
        return zjc6;
    }

    public void setZjc6(String zjc6) {
        this.zjc6 = zjc6;
    }

    public String getYdnr2() {
        return ydnr2;
    }

    public void setYdnr2(String ydnr2) {
        this.ydnr2 = ydnr2;
    }

    public String getZjc5() {
        return zjc5;
    }

    public void setZjc5(String zjc5) {
        this.zjc5 = zjc5;
    }

    public String getYdnr3() {
        return ydnr3;
    }

    public void setYdnr3(String ydnr3) {
        this.ydnr3 = ydnr3;
    }

    public String getYdnr4() {
        return ydnr4;
    }

    public void setYdnr4(String ydnr4) {
        this.ydnr4 = ydnr4;
    }

    public String getYdnr5() {
        return ydnr5;
    }

    public void setYdnr5(String ydnr5) {
        this.ydnr5 = ydnr5;
    }

    public String getYdnr6() {
        return ydnr6;
    }

    public void setYdnr6(String ydnr6) {
        this.ydnr6 = ydnr6;
    }

    public String getYdlx1() {
        return ydlx1;
    }

    public void setYdlx1(String ydlx1) {
        this.ydlx1 = ydlx1;
    }

    public String getYdlx2() {
        return ydlx2;
    }

    public void setYdlx2(String ydlx2) {
        this.ydlx2 = ydlx2;
    }

    public String getYdlx3() {
        return ydlx3;
    }

    public void setYdlx3(String ydlx3) {
        this.ydlx3 = ydlx3;
    }

    public String getYdlx4() {
        return ydlx4;
    }

    public void setYdlx4(String ydlx4) {
        this.ydlx4 = ydlx4;
    }

    public String getYdlx5() {
        return ydlx5;
    }

    public void setYdlx5(String ydlx5) {
        this.ydlx5 = ydlx5;
    }

    public String getZjc2() {
        return zjc2;
    }

    public void setZjc2(String zjc2) {
        this.zjc2 = zjc2;
    }

    public String getYdlx6() {
        return ydlx6;
    }

    public void setYdlx6(String ydlx6) {
        this.ydlx6 = ydlx6;
    }

    public String getZjc1() {
        return zjc1;
    }

    public void setZjc1(String zjc1) {
        this.zjc1 = zjc1;
    }

    public String getBeiz1() {
        return beiz1;
    }

    public void setBeiz1(String beiz1) {
        this.beiz1 = beiz1;
    }

    public String getBeiz2() {
        return beiz2;
    }

    public void setBeiz2(String beiz2) {
        this.beiz2 = beiz2;
    }

    public String getBeiz3() {
        return beiz3;
    }

    public void setBeiz3(String beiz3) {
        this.beiz3 = beiz3;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getFormid() {
        return formid;
    }

    public void setFormid(String formid) {
        this.formid = formid;
    }

    public String getModingFactory() {
        return modingFactory;
    }

    public void setModingFactory(String modingFactory) {
        this.modingFactory = modingFactory;
    }

    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    public String getCastingPlant() {
        return castingPlant;
    }

    public void setCastingPlant(String castingPlant) {
        this.castingPlant = castingPlant;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getItnbr() {
        return itnbr;
    }

    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    public String getApplyDept() {
        return applyDept;
    }

    public void setApplyDept(String applyDept) {
        this.applyDept = applyDept;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getItdsc() {
        return itdsc;
    }

    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    public String getChangeContent() {
        return changeContent;
    }

    public void setChangeContent(String changeContent) {
        this.changeContent = changeContent;
    }

    public String getProcessingPlant() {
        return processingPlant;
    }

    public void setProcessingPlant(String processingPlant) {
        this.processingPlant = processingPlant;
    }

    public String getPositionOld() {
        return positionOld;
    }

    public void setPositionOld(String positionOld) {
        this.positionOld = positionOld;
    }

    public String getPositionNew() {
        return positionNew;
    }

    public void setPositionNew(String positionNew) {
        this.positionNew = positionNew;
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
        if (!(object instanceof HSYJG002)) {
            return false;
        }
        HSYJG002 other = (HSYJG002) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.oa.entity.HSYJG002[ oid=" + oid + " ]";
    }
    
}
