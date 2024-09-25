/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import com.lightshell.comm.SuperEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C2082
 */
@Entity
@Table(name = "attendance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attendance.findAll", query = "SELECT a FROM Attendance a"),
    @NamedQuery(name = "Attendance.findById", query = "SELECT a FROM Attendance a WHERE a.id = :id"),
    @NamedQuery(name = "Attendance.findByEmployeeId", query = "SELECT a FROM Attendance a WHERE a.employeeId = :employeeId"),
    @NamedQuery(name = "Attendance.findByAttendanceDate", query = "SELECT a FROM Attendance a WHERE a.attendanceDate = :attendanceDate"),
    @NamedQuery(name = "Attendance.findByFacnoAndEmployeeidAndAttendanceDate", query = "SELECT a FROM Attendance a WHERE  a.facno = :facno and a.employeeId = :employeeId and  a.attendanceDate = :attendanceDate"),
    @NamedQuery(name = "Attendance.findByEmployeeName", query = "SELECT a FROM Attendance a WHERE a.employeeName = :employeeName"),
    @NamedQuery(name = "Attendance.findByDept", query = "SELECT a FROM Attendance a WHERE a.dept = :dept"),
    @NamedQuery(name = "Attendance.findByPacificOvertime", query = "SELECT a FROM Attendance a WHERE a.pacificOvertime = :pacificOvertime"),
    @NamedQuery(name = "Attendance.findByRestOvertime", query = "SELECT a FROM Attendance a WHERE a.restOvertime = :restOvertime"),
    @NamedQuery(name = "Attendance.findByHolidayOvertime", query = "SELECT a FROM Attendance a WHERE a.holidayOvertime = :holidayOvertime"),
    @NamedQuery(name = "Attendance.findBySickLeave", query = "SELECT a FROM Attendance a WHERE a.sickLeave = :sickLeave"),
    @NamedQuery(name = "Attendance.findByAffairLeave", query = "SELECT a FROM Attendance a WHERE a.affairLeave = :affairLeave"),
    @NamedQuery(name = "Attendance.findBySpecialRest", query = "SELECT a FROM Attendance a WHERE a.specialRest = :specialRest"),
    @NamedQuery(name = "Attendance.findByMarriageLeave", query = "SELECT a FROM Attendance a WHERE a.marriageLeave = :marriageLeave"),
    @NamedQuery(name = "Attendance.findByDieLeave", query = "SELECT a FROM Attendance a WHERE a.dieLeave = :dieLeave"),
    @NamedQuery(name = "Attendance.findByHurtLeave", query = "SELECT a FROM Attendance a WHERE a.hurtLeave = :hurtLeave"),
    @NamedQuery(name = "Attendance.findByPaternityLeave", query = "SELECT a FROM Attendance a WHERE a.paternityLeave = :paternityLeave"),
    @NamedQuery(name = "Attendance.findByMaternityLeave", query = "SELECT a FROM Attendance a WHERE a.maternityLeave = :maternityLeave"),
    @NamedQuery(name = "Attendance.findByNoSalaryLeave", query = "SELECT a FROM Attendance a WHERE a.noSalaryLeave = :noSalaryLeave"),
    @NamedQuery(name = "Attendance.findByAntenatalLeave", query = "SELECT a FROM Attendance a WHERE a.antenatalLeave = :antenatalLeave"),
    @NamedQuery(name = "Attendance.findByPublicLeave", query = "SELECT a FROM Attendance a WHERE a.publicLeave = :publicLeave"),
    @NamedQuery(name = "Attendance.findByHomeLeave", query = "SELECT a FROM Attendance a WHERE a.homeLeave = :homeLeave"),
    @NamedQuery(name = "Attendance.findByForgetClock", query = "SELECT a FROM Attendance a WHERE a.forgetClock = :forgetClock"),
    @NamedQuery(name = "Attendance.findByLate", query = "SELECT a FROM Attendance a WHERE a.late = :late"),
    @NamedQuery(name = "Attendance.findByLeaveEarly", query = "SELECT a FROM Attendance a WHERE a.leaveEarly = :leaveEarly"),
    @NamedQuery(name = "Attendance.findByAbsent", query = "SELECT a FROM Attendance a WHERE a.absent = :absent"),
    @NamedQuery(name = "Attendance.findByMeal", query = "SELECT a FROM Attendance a WHERE a.meal = :meal"),
    @NamedQuery(name = "Attendance.findByBreakfast", query = "SELECT a FROM Attendance a WHERE a.breakfast = :breakfast"),
    @NamedQuery(name = "Attendance.findByLunch", query = "SELECT a FROM Attendance a WHERE a.lunch = :lunch"),
    @NamedQuery(name = "Attendance.findByDinner", query = "SELECT a FROM Attendance a WHERE a.dinner = :dinner"),
    @NamedQuery(name = "Attendance.findByOweClass", query = "SELECT a FROM Attendance a WHERE a.oweClass = :oweClass")})
public class Attendance extends SuperEntity {

    private static final long serialVersionUID = 1L;
    @Size(max = 5)
    @Column(name = "employeeId")
    private String employeeId;
    @Size(max = 10)
    @Column(name = "attendanceDate")
    private String attendanceDate;
     @Size(max = 6)
    @Column(name = "checkcode")
    private String checkcode;
          @Size(max = 5)
    @Column(name = "facno")
    private String facno;
    @Size(max = 10)
    @Column(name = "employeeName")
    private String employeeName;
    @Size(max = 20)
    @Column(name = "dept")
    private String dept;
    @Size(max = 10)
    @Column(name = "pacificOvertime")
    private String pacificOvertime;
    @Size(max = 10)
    @Column(name = "restOvertime")
    private String restOvertime;
    @Size(max = 10)
    @Column(name = "holidayOvertime")
    private String holidayOvertime;
    @Size(max = 10)
    @Column(name = "sickLeave")
    private String sickLeave;
    @Size(max = 10)
    @Column(name = "affairLeave")
    private String affairLeave;
    @Size(max = 10)
    @Column(name = "specialRest")
    private String specialRest;
    @Size(max = 10)
    @Column(name = "marriageLeave")
    private String marriageLeave;
    @Size(max = 10)
    @Column(name = "dieLeave")
    private String dieLeave;
    @Size(max = 10)
    @Column(name = "hurtLeave")
    private String hurtLeave;
    @Size(max = 10)
    @Column(name = "paternityLeave")
    private String paternityLeave;
    @Size(max = 10)
    @Column(name = "maternityLeave")
    private String maternityLeave;
    @Size(max = 10)
    @Column(name = "noSalaryLeave")
    private String noSalaryLeave;
    @Size(max = 10)
    @Column(name = "antenatalLeave")
    private String antenatalLeave;
    @Size(max = 10)
    @Column(name = "publicLeave")
    private String publicLeave;
     @Size(max = 10)
    @Column(name = "breastfeedingLeave")
    private String breastfeedingLeave;
    @Size(max = 10)
    @Column(name = "homeLeave")
    private String homeLeave;
    @Size(max = 10)
    @Column(name = "forgetClock")
    private String forgetClock;
    @Size(max = 10)
    @Column(name = "late")
    private String late;
    @Size(max = 10)
    @Column(name = "leaveEarly")
    private String leaveEarly;
    @Size(max = 10)
    @Column(name = "absent")
    private String absent;
    @Size(max = 10)
    @Column(name = "meal")
    private String meal;
        @Size(max = 10)
    @Column(name = "child")
    private String child;
    @Size(max = 10)
    @Column(name = "breakfast")
    private String breakfast;
    @Size(max = 10)
    @Column(name = "lunch")
    private String lunch;
    @Size(max = 10)
    @Column(name = "dinner")
    private String dinner;
    @Size(max = 10)
    @Column(name = "oweClass")
    private String oweClass;

    public Attendance() {
    }

    public Attendance(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(String attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public String getCheckcode() {
        return checkcode;
    }

    public void setCheckcode(String checkcode) {
        this.checkcode = checkcode;
    }
    
    public String getFacno() {
        return facno;
    }

    public void setFacno(String facno) {
        this.facno = facno;
    }

    
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getPacificOvertime() {
        return pacificOvertime;
    }

    public void setPacificOvertime(String pacificOvertime) {
        this.pacificOvertime = pacificOvertime;
    }

    public String getRestOvertime() {
        return restOvertime;
    }

    public void setRestOvertime(String restOvertime) {
        this.restOvertime = restOvertime;
    }

    public String getHolidayOvertime() {
        return holidayOvertime;
    }

    public void setHolidayOvertime(String holidayOvertime) {
        this.holidayOvertime = holidayOvertime;
    }

    public String getSickLeave() {
        return sickLeave;
    }

    public void setSickLeave(String sickLeave) {
        this.sickLeave = sickLeave;
    }

    public String getAffairLeave() {
        return affairLeave;
    }

    public void setAffairLeave(String affairLeave) {
        this.affairLeave = affairLeave;
    }

    public String getSpecialRest() {
        return specialRest;
    }

    public void setSpecialRest(String specialRest) {
        this.specialRest = specialRest;
    }

    public String getMarriageLeave() {
        return marriageLeave;
    }

    public void setMarriageLeave(String marriageLeave) {
        this.marriageLeave = marriageLeave;
    }

    public String getDieLeave() {
        return dieLeave;
    }

    public void setDieLeave(String dieLeave) {
        this.dieLeave = dieLeave;
    }

    public String getHurtLeave() {
        return hurtLeave;
    }

    public void setHurtLeave(String hurtLeave) {
        this.hurtLeave = hurtLeave;
    }

    public String getPaternityLeave() {
        return paternityLeave;
    }

    public void setPaternityLeave(String paternityLeave) {
        this.paternityLeave = paternityLeave;
    }

    public String getMaternityLeave() {
        return maternityLeave;
    }

    public void setMaternityLeave(String maternityLeave) {
        this.maternityLeave = maternityLeave;
    }

    public String getNoSalaryLeave() {
        return noSalaryLeave;
    }

    public void setNoSalaryLeave(String noSalaryLeave) {
        this.noSalaryLeave = noSalaryLeave;
    }

    public String getAntenatalLeave() {
        return antenatalLeave;
    }

    public void setAntenatalLeave(String antenatalLeave) {
        this.antenatalLeave = antenatalLeave;
    }

    public String getPublicLeave() {
        return publicLeave;
    }

    public void setPublicLeave(String publicLeave) {
        this.publicLeave = publicLeave;
    }

    public String getBreastfeedingLeave() {
        return breastfeedingLeave;
    }

    public void setBreastfeedingLeave(String breastfeedingLeave) {
        this.breastfeedingLeave = breastfeedingLeave;
    }

    public String getHomeLeave() {
        return homeLeave;
    }

    public void setHomeLeave(String homeLeave) {
        this.homeLeave = homeLeave;
    }

    public String getForgetClock() {
        return forgetClock;
    }

    public void setForgetClock(String forgetClock) {
        this.forgetClock = forgetClock;
    }

    public String getLate() {
        return late;
    }

    public void setLate(String late) {
        this.late = late;
    }

    public String getLeaveEarly() {
        return leaveEarly;
    }

    public void setLeaveEarly(String leaveEarly) {
        this.leaveEarly = leaveEarly;
    }

    public String getAbsent() {
        return absent;
    }

    public void setAbsent(String absent) {
        this.absent = absent;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
    }

    public String getOweClass() {
        return oweClass;
    }

    public void setOweClass(String oweClass) {
        this.oweClass = oweClass;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Attendance)) {
            return false;
        }
        Attendance other = (Attendance) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.Attendance[ id=" + id + " ]";
    }

}
