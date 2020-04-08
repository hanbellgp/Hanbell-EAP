/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.entity;

import cn.hanbell.oa.ejb.WorkFlowBean;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.ejb.EJB;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C2082
 */
@Entity
@Table(
        name = "D50_Z0009_D0"
)
@XmlRootElement
@NamedQueries({
    @NamedQuery(
            name = "D50Z0009D0.findAll",
            query = "SELECT d FROM D50Z0009D0 d"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findByOID",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.oid = :oid"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findByEndyear",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.endyear = :endyear"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findByApplyreason",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.applyreason = :applyreason"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findByTotaldays",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.totaldays = :totaldays"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findByEndmonth",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.endmonth = :endmonth"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findByStartday",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.startday = :startday"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findBySerialNumber",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.serialNumber = :serialNumber"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findByStartyear",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.startyear = :startyear"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findByOtherpay1",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.otherpay1 = :otherpay1"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findByOtherpay2",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.otherpay2 = :otherpay2"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findBySupportfacno",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.supportfacno = :supportfacno"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findByPSN",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.processSerialNumber = :psn"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findByWend",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.wend = :wend"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findBySupporttype",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.supporttype = :supporttype"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findByTotalamount",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.totalamount = :totalamount"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findByOthertype",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.othertype = :othertype"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findByEndday",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.endday = :endday"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findByLodging2",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.lodging2 = :lodging2"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findByApplypay",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.applypay = :applypay"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findByLodging1",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.lodging1 = :lodging1"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findByCoin",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.coin = :coin"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findByKsno",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.ksno = :ksno"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findByApplyfacno",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.applyfacno = :applyfacno"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findByStartmonth",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.startmonth = :startmonth"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findByBack",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.back = :back"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findBySupportDept",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.supportDept = :supportDept"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findByApplyfactory",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.applyfactory = :applyfactory"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findByDay2",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.day2 = :day2"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findByDay1",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.day1 = :day1"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findByApplyUser",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.applyUser = :applyUser"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findByApplyDept",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.applyDept = :applyDept"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findByMonth1",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.month1 = :month1"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findByDays",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.days = :days"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findByJsjneed1",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.jsjneed1 = :jsjneed1"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findBySupportpay",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.supportpay = :supportpay"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findBySupportfactory",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.supportfactory = :supportfactory"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findByMonth2",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.month2 = :month2"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findByJsjneed2",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.jsjneed2 = :jsjneed2"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findBySupportUser",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.supportUser = :supportUser"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findByFSN",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.formSerialNumber = :fsn"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findByHdnAmanager",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.hdnAmanager = :hdnAmanager"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findByHdnSmanager",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.hdnSmanager = :hdnSmanager"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findByHdnSboss",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.hdnSboss = :hdnSboss"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findByHdnAboss",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.hdnAboss = :hdnAboss"
    ),
    @NamedQuery(
            name = "D50Z0009D0.findByHdnglb",
            query = "SELECT d FROM D50Z0009D0 d WHERE d.hdnglb = :hdnglb"
    )})
public class D50Z0009D0 implements Serializable {     
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(
            optional = false
    )
    @NotNull
    @Size(
            min = 1,
            max = 255
    )
    @Column(
            name = "OID"
    )
    private String oid;
    @Size(
            max = 255
    )
    @Column(
            name = "endyear"
    )
    private String endyear;
    @Size(
            max = 255
    )
    @Column(
            name = "applyreason"
    )
    private String applyreason;
    @Size(
            max = 255
    )
    @Column(
            name = "totaldays"
    )
    private String totaldays;
    @Size(
            max = 255
    )
    @Column(
            name = "endmonth"
    )
    private String endmonth;
    @Size(
            max = 255
    )
    @Column(
            name = "startday"
    )
    private String startday;

    @Size(
            max = 255
    )
    @Column(
            name = "SerialNumber"
    )
    private String serialNumber;

    @Size(
            max = 255
    )
    @Column(
            name = "startyear"
    )
    private String startyear;
    @Size(
            max = 255
    )
    @Column(
            name = "otherpay1"
    )
    private String otherpay1;
    @Size(
            max = 255
    )
    @Column(
            name = "otherpay2"
    )
    private String otherpay2;
    @Size(
            max = 255
    )
    @Column(
            name = "supportfacno"
    )
    private String supportfacno;

    @JoinColumn(
            name = "processSerialNumber",
            referencedColumnName = "serialNumber",
            insertable = false,
            updatable = false
    )
    @ManyToOne(
            optional = true
    )
    private ProcessInstance processSerialNumber;

    @Size(
            max = 255
    )
    @Column(
            name = "wend"
    )
    private String wend;
    @Size(
            max = 255
    )
    @Column(
            name = "supporttype"
    )
    private String supporttype;
    @Size(
            max = 255
    )
    @Column(
            name = "totalamount"
    )
    private String totalamount;
    @Size(
            max = 255
    )
    @Column(
            name = "othertype"
    )
    private String othertype;
    @Size(
            max = 255
    )
    @Column(
            name = "endday"
    )
    private String endday;
    @Size(
            max = 255
    )
    @Column(
            name = "lodging2"
    )
    private String lodging2;
    @Size(
            max = 255
    )
    @Column(
            name = "applypay"
    )
    private String applypay;
    @Size(
            max = 255
    )
    @Column(
            name = "lodging1"
    )
    private String lodging1;
    @Size(
            max = 255
    )
    @Column(
            name = "coin"
    )
    private String coin;
    @Size(
            max = 255
    )
    @Column(
            name = "ksno"
    )
    private String ksno;
    @Size(
            max = 255
    )
    @Column(
            name = "applyfacno"
    )
    private String applyfacno;
    @Size(
            max = 255
    )
    @Column(
            name = "startmonth"
    )
    private String startmonth;
    @Size(
            max = 255
    )
    @Column(
            name = "back"
    )
    private String back;
    @JoinColumn(
            name = "supportDept",
            referencedColumnName = "id",
            insertable = false,
            updatable = false
    )
    @ManyToOne(
            optional = true
    )
    private OrganizationUnit supportDept;
    @Size(
            max = 255
    )
    @Column(
            name = "applyfactory"
    )
    private String applyfactory;
    @Size(
            max = 255
    )
    @Column(
            name = "day2"
    )
    private String day2;
    @Size(
            max = 255
    )
    @Column(
            name = "day1"
    )
    private String day1;
    @JoinColumn(
            name = "applyUser",
            referencedColumnName = "id",
            insertable = false,
            updatable = false
    )
    @ManyToOne(
            optional = true
    )
    private Users applyUser;
    @JoinColumn(
            name = "applyDept",
            referencedColumnName = "id",
            insertable = false,
            updatable = false
    )
    @ManyToOne(
            optional = true
    )
    private OrganizationUnit applyDept;
    @Size(
            max = 255
    )
    @Column(
            name = "month1"
    )
    private String month1;
    @Size(
            max = 255
    )
    @Column(
            name = "days"
    )
    private String days;
    @Size(
            max = 255
    )
    @Column(
            name = "jsjneed1"
    )
    private String jsjneed1;
    @Size(
            max = 255
    )
    @Column(
            name = "supportpay"
    )
    private String supportpay;
    @Size(
            max = 255
    )
    @Column(
            name = "supportfactory"
    )
    private String supportfactory;
    @Size(
            max = 255
    )
    @Column(
            name = "month2"
    )
    private String month2;
    @Size(
            max = 255
    )
    @Column(
            name = "jsjneed2"
    )
    private String jsjneed2;
    @JoinColumn(
            name = "supportUser",
            referencedColumnName = "id",
            insertable = false,
            updatable = false
    )
    @ManyToOne(
            optional = true
    )
    private Users supportUser;
    @Size(
            max = 255
    )
    @Column(
            name = "formSerialNumber"
    )
    private String formSerialNumber;
    @Size(
            max = 255
    )
    @Column(
            name = "hdnAmanager"
    )
    private String hdnAmanager;
    @Size(
            max = 255
    )
    @Column(
            name = "hdnSmanager"
    )
    private String hdnSmanager;
    @Size(
            max = 255
    )
    @Column(
            name = "hdnSboss"
    )
    private String hdnSboss;
    @Size(
            max = 255
    )
    @Column(
            name = "hdnAboss"
    )
    private String hdnAboss;
    @Size(
            max = 255
    )
    @Column(
            name = "hdnglb"
    )
    private String hdnglb;

    @Basic(optional = false)
    @NotNull
    @Column(name = "endout")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endout;

    @Basic(optional = false)
    @NotNull
    @Column(name = "startout")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startout;

    @Basic(optional = false)
    @NotNull
    @Column(name = "staydate1")
    @Temporal(TemporalType.TIMESTAMP)
    private Date staydate1;

    @Basic(optional = false)
    @NotNull
    @Column(name = "staydate2")
    @Temporal(TemporalType.TIMESTAMP)
    private Date staydate2;

    public D50Z0009D0() {
    }

    public D50Z0009D0(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return this.oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getEndyear() {
        return this.endyear;
    }

    public void setEndyear(String endyear) {
        this.endyear = endyear;
    }

    public String getApplyreason() {
        return this.applyreason;
    }

    public void setApplyreason(String applyreason) {
        this.applyreason = applyreason;
    }

    public String getTotaldays() {
        return this.totaldays;
    }

    public void setTotaldays(String totaldays) {
        this.totaldays = totaldays;
    }

    public String getEndmonth() {
        return this.endmonth;
    }

    public void setEndmonth(String endmonth) {
        this.endmonth = endmonth;
    }

    public String getStartday() {
        return this.startday;
    }

    public void setStartday(String startday) {
        this.startday = startday;
    }

    public String getStartyear() {
        return this.startyear;
    }

    public void setStartyear(String startyear) {
        this.startyear = startyear;
    }

    public String getOtherpay1() {
        return this.otherpay1;
    }

    public void setOtherpay1(String otherpay1) {
        this.otherpay1 = otherpay1;
    }

    public String getOtherpay2() {
        return this.otherpay2;
    }

    public void setOtherpay2(String otherpay2) {
        this.otherpay2 = otherpay2;
    }

    public String getSupportfacno() {
        return getComapntName(this.supportfacno);
    }

    public void setSupportfacno(String supportfacno) {
        this.supportfacno = supportfacno;
    }

    public String getWend() {
        return this.wend;
    }

    public void setWend(String wend) {
        this.wend = wend;
    }

    public String getSupporttype() {
        return this.supporttype;
    }

    public void setSupporttype(String supporttype) {
        this.supporttype = supporttype;
    }

    public String getTotalamount() {
        return this.totalamount;
    }

    public void setTotalamount(String totalamount) {
        this.totalamount = totalamount;
    }

    public String getOthertype() {
        return this.othertype;
    }

    public void setOthertype(String othertype) {
        this.othertype = othertype;
    }

    public String getEndday() {
        return this.endday;
    }

    public void setEndday(String endday) {
        this.endday = endday;
    }

    public String getLodging2() {
        return this.lodging2;
    }

    public void setLodging2(String lodging2) {
        this.lodging2 = lodging2;
    }

    public String getApplypay() {
        return this.applypay;
    }

    public void setApplypay(String applypay) {
        this.applypay = applypay;
    }

    public String getLodging1() {
        return this.lodging1;
    }

    public void setLodging1(String lodging1) {
        this.lodging1 = lodging1;
    }

    public String getCoin() {
        return this.coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getKsno() {
        return this.ksno;
    }

    public void setKsno(String ksno) {
        this.ksno = ksno;
    }

    public String getApplyfacno() {
        return getComapntName(this.applyfacno);
    }

    public void setApplyfacno(String applyfacno) {
        this.applyfacno = applyfacno;
    }

    public String getStartmonth() {
        return this.startmonth;
    }

    public void setStartmonth(String startmonth) {
        this.startmonth = startmonth;
    }

    public String getBack() {
        return this.back;
    }

    public void setBack(String back) {
        this.back = back;
    }

    public OrganizationUnit getSupportDept() {
        return this.supportDept;
    }

    public void setSupportDept(OrganizationUnit supportDept) {
        this.supportDept = supportDept;
    }

    public String getApplyfactory() {
        return this.applyfactory;
    }

    public void setApplyfactory(String applyfactory) {
        this.applyfactory = applyfactory;
    }

    public String getDay2() {
        return this.day2;
    }

    public void setDay2(String day2) {
        this.day2 = day2;
    }

    public String getDay1() {
        return this.day1;
    }

    public void setDay1(String day1) {
        this.day1 = day1;
    }

    public Users getApplyUser() {
        return this.applyUser;
    }

    public void setApplyUser(Users applyUser) {
        this.applyUser = applyUser;
    }

    public OrganizationUnit getApplyDept() {
        return this.applyDept;
    }

    public void setApplyDept(OrganizationUnit applyDept) {
        this.applyDept = applyDept;
    }

    public String getMonth1() {
        return this.month1;
    }

    public void setMonth1(String month1) {
        this.month1 = month1;
    }

    public String getDays() {
        return this.days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getJsjneed1() {
        return this.jsjneed1;
    }

    public void setJsjneed1(String jsjneed1) {
        this.jsjneed1 = jsjneed1;
    }

    public String getSupportpay() {
        return this.supportpay;
    }

    public void setSupportpay(String supportpay) {
        this.supportpay = supportpay;
    }

    public String getSupportfactory() {
        return this.supportfactory;
    }

    public void setSupportfactory(String supportfactory) {
        this.supportfactory = supportfactory;
    }

    public String getMonth2() {
        return this.month2;
    }

    public void setMonth2(String month2) {
        this.month2 = month2;
    }

    public String getJsjneed2() {
        return this.jsjneed2;
    }

    public void setJsjneed2(String jsjneed2) {
        this.jsjneed2 = jsjneed2;
    }

    public Users getSupportUser() {
        return this.supportUser;
    }

    public void setSupportUser(Users supportUser) {
        this.supportUser = supportUser;
    }

    public String getFormSerialNumber() {
        return this.formSerialNumber;
    }

    public void setFormSerialNumber(String formSerialNumber) {
        this.formSerialNumber = formSerialNumber;
    }

    public String getHdnAmanager() {
        return this.hdnAmanager;
    }

    public void setHdnAmanager(String hdnAmanager) {
        this.hdnAmanager = hdnAmanager;
    }

    public String getHdnSmanager() {
        return this.hdnSmanager;
    }

    public void setHdnSmanager(String hdnSmanager) {
        this.hdnSmanager = hdnSmanager;
    }
    public String getHdnSboss() {
        return this.hdnSboss;
    }

    public void setHdnSboss(String hdnSboss) {
        this.hdnSboss = hdnSboss;
    }

    public String getHdnAboss() {
        return this.hdnAboss;
    }

    public void setHdnAboss(String hdnAboss) {
        this.hdnAboss = hdnAboss;
    }

    public String getHdnglb() {
        return this.hdnglb;
    }

    public void setHdnglb(String hdnglb) {
        this.hdnglb = hdnglb;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public ProcessInstance getProcessSerialNumber() {
        return processSerialNumber;
    }

    public void setProcessSerialNumber(ProcessInstance processSerialNumber) {
        this.processSerialNumber = processSerialNumber;
    }

    public Date getEndout() {
        return endout;
    }

    public void setEndout(Date endout) {
        this.endout = endout;
    }

    public Date getStartout() {
        return startout;
    }

    public void setStartout(Date startout) {
        this.startout = startout;
    }

 

    public Date getStaydate1() {
        return staydate1;
    }

    public void setStaydate1(Date staydate1) {
        this.staydate1 = staydate1;
    }

    public Date getStaydate2() {
        return staydate2;
    }

    public void setStaydate2(Date staydate2) {
        this.staydate2 = staydate2;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.oid);
        hash = 41 * hash + Objects.hashCode(this.endyear);
        hash = 41 * hash + Objects.hashCode(this.applyreason);
        hash = 41 * hash + Objects.hashCode(this.totaldays);
        hash = 41 * hash + Objects.hashCode(this.endmonth);
        hash = 41 * hash + Objects.hashCode(this.startday);
        hash = 41 * hash + Objects.hashCode(this.serialNumber);
        hash = 41 * hash + Objects.hashCode(this.startyear);
        hash = 41 * hash + Objects.hashCode(this.otherpay1);
        hash = 41 * hash + Objects.hashCode(this.otherpay2);
        hash = 41 * hash + Objects.hashCode(this.supportfacno);
        hash = 41 * hash + Objects.hashCode(this.processSerialNumber);
        hash = 41 * hash + Objects.hashCode(this.wend);
        hash = 41 * hash + Objects.hashCode(this.supporttype);
        hash = 41 * hash + Objects.hashCode(this.totalamount);
        hash = 41 * hash + Objects.hashCode(this.othertype);
        hash = 41 * hash + Objects.hashCode(this.endday);
        hash = 41 * hash + Objects.hashCode(this.lodging2);
        hash = 41 * hash + Objects.hashCode(this.applypay);
        hash = 41 * hash + Objects.hashCode(this.lodging1);
        hash = 41 * hash + Objects.hashCode(this.coin);
        hash = 41 * hash + Objects.hashCode(this.ksno);
        hash = 41 * hash + Objects.hashCode(this.applyfacno);
        hash = 41 * hash + Objects.hashCode(this.startmonth);
        hash = 41 * hash + Objects.hashCode(this.back);
        hash = 41 * hash + Objects.hashCode(this.supportDept);
        hash = 41 * hash + Objects.hashCode(this.applyfactory);
        hash = 41 * hash + Objects.hashCode(this.day2);
        hash = 41 * hash + Objects.hashCode(this.day1);
        hash = 41 * hash + Objects.hashCode(this.applyUser);
        hash = 41 * hash + Objects.hashCode(this.applyDept);
        hash = 41 * hash + Objects.hashCode(this.month1);
        hash = 41 * hash + Objects.hashCode(this.days);
        hash = 41 * hash + Objects.hashCode(this.jsjneed1);
        hash = 41 * hash + Objects.hashCode(this.supportpay);
        hash = 41 * hash + Objects.hashCode(this.supportfactory);
        hash = 41 * hash + Objects.hashCode(this.month2);
        hash = 41 * hash + Objects.hashCode(this.jsjneed2);
        hash = 41 * hash + Objects.hashCode(this.supportUser);
        hash = 41 * hash + Objects.hashCode(this.formSerialNumber);
        hash = 41 * hash + Objects.hashCode(this.hdnAmanager);
        hash = 41 * hash + Objects.hashCode(this.hdnSmanager);
        hash = 41 * hash + Objects.hashCode(this.hdnSboss);
        hash = 41 * hash + Objects.hashCode(this.hdnAboss);
        hash = 41 * hash + Objects.hashCode(this.hdnglb);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final D50Z0009D0 other = (D50Z0009D0) obj;
        if (!Objects.equals(this.oid, other.oid)) {
            return false;
        }
        if (!Objects.equals(this.endyear, other.endyear)) {
            return false;
        }
        if (!Objects.equals(this.applyreason, other.applyreason)) {
            return false;
        }
        if (!Objects.equals(this.totaldays, other.totaldays)) {
            return false;
        }
        if (!Objects.equals(this.endmonth, other.endmonth)) {
            return false;
        }
        if (!Objects.equals(this.startday, other.startday)) {
            return false;
        }
        if (!Objects.equals(this.serialNumber, other.serialNumber)) {
            return false;
        }
        if (!Objects.equals(this.startyear, other.startyear)) {
            return false;
        }
        if (!Objects.equals(this.otherpay1, other.otherpay1)) {
            return false;
        }
        if (!Objects.equals(this.otherpay2, other.otherpay2)) {
            return false;
        }
        if (!Objects.equals(this.supportfacno, other.supportfacno)) {
            return false;
        }
        if (!Objects.equals(this.processSerialNumber, other.processSerialNumber)) {
            return false;
        }
        if (!Objects.equals(this.wend, other.wend)) {
            return false;
        }
        if (!Objects.equals(this.supporttype, other.supporttype)) {
            return false;
        }
        if (!Objects.equals(this.totalamount, other.totalamount)) {
            return false;
        }
        if (!Objects.equals(this.othertype, other.othertype)) {
            return false;
        }
        if (!Objects.equals(this.endday, other.endday)) {
            return false;
        }
        if (!Objects.equals(this.lodging2, other.lodging2)) {
            return false;
        }
        if (!Objects.equals(this.applypay, other.applypay)) {
            return false;
        }
        if (!Objects.equals(this.lodging1, other.lodging1)) {
            return false;
        }
        if (!Objects.equals(this.coin, other.coin)) {
            return false;
        }
        if (!Objects.equals(this.ksno, other.ksno)) {
            return false;
        }
        if (!Objects.equals(this.applyfacno, other.applyfacno)) {
            return false;
        }
        if (!Objects.equals(this.startmonth, other.startmonth)) {
            return false;
        }
        if (!Objects.equals(this.back, other.back)) {
            return false;
        }
        if (!Objects.equals(this.applyfactory, other.applyfactory)) {
            return false;
        }
        if (!Objects.equals(this.day2, other.day2)) {
            return false;
        }
        if (!Objects.equals(this.day1, other.day1)) {
            return false;
        }
        if (!Objects.equals(this.month1, other.month1)) {
            return false;
        }
        if (!Objects.equals(this.days, other.days)) {
            return false;
        }
        if (!Objects.equals(this.jsjneed1, other.jsjneed1)) {
            return false;
        }
        if (!Objects.equals(this.supportpay, other.supportpay)) {
            return false;
        }
        if (!Objects.equals(this.supportfactory, other.supportfactory)) {
            return false;
        }
        if (!Objects.equals(this.month2, other.month2)) {
            return false;
        }
        if (!Objects.equals(this.jsjneed2, other.jsjneed2)) {
            return false;
        }
        if (!Objects.equals(this.formSerialNumber, other.formSerialNumber)) {
            return false;
        }
        if (!Objects.equals(this.hdnAmanager, other.hdnAmanager)) {
            return false;
        }
        if (!Objects.equals(this.hdnSmanager, other.hdnSmanager)) {
            return false;
        }
        if (!Objects.equals(this.hdnSboss, other.hdnSboss)) {
            return false;
        }
        if (!Objects.equals(this.hdnAboss, other.hdnAboss)) {
            return false;
        }
        if (!Objects.equals(this.hdnglb, other.hdnglb)) {
            return false;
        }
        if (!Objects.equals(this.supportDept, other.supportDept)) {
            return false;
        }
        if (!Objects.equals(this.applyUser, other.applyUser)) {
            return false;
        }
        if (!Objects.equals(this.applyDept, other.applyDept)) {
            return false;
        }
        if (!Objects.equals(this.supportUser, other.supportUser)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "cn.hanbell.oa.entity.D50Z0009D0[ oid=" + this.oid + " ]";
    }
    
    public String getComapntName(String name){
        WorkFlowBean WorkFlowBean=new WorkFlowBean();
    return WorkFlowBean.getCompanyName(name);
    }
}
