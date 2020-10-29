/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.Attendance;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author C2082
 */
@Stateless
@LocalBean
public class AttendanceBean extends SuperEJBForEAP<Attendance> {

    public AttendanceBean() {
        super(Attendance.class);
    }
    

    public List<Attendance> findByAttendanceDate(String date) {
        Query query = getEntityManager().createNamedQuery("Attendance.findByAttendanceDate");
        query.setParameter("attendanceDate", date);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Attendance> findByAttendanceAndEmployeeId(String employeeid, String date) {
        StringBuffer sql=new StringBuffer("SELECT * FROM attendance where 1=1 ");
        if(employeeid!=null&&!"".equals(employeeid)){
            sql.append("and  employeeName like '%").append(employeeid).append("%'");
        }
          if(date!=null&&!"".equals(date)){
            sql.append("and  attendanceDate like '%").append(date).append("%'");
        }
        Query query = getEntityManager().createNativeQuery(sql.toString(),Attendance.class);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
