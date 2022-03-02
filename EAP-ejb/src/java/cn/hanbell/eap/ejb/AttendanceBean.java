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

    public List<Attendance> findByAttendanceAndEmployeeIdAndStatus(String employeeId, String date, String status,String facno) {
        StringBuffer sql = new StringBuffer("SELECT * FROM attendance where 1=1 ");
        if (employeeId != null && !"".equals(employeeId)) {
            sql.append("and  employeeId like '%").append(employeeId).append("%'");
        }
        if (date != null && !"".equals(date)) {
            sql.append("and  attendanceDate like '%").append(date).append("%'");
        }
        if (status != null && !"All".equals(status)) {
            sql.append("and  status like '%").append(status).append("%'");
        }
           if (facno != null && !"".equals(facno)) {
            sql.append("and  facno ='").append(facno).append("'");
        }
        Query query = getEntityManager().createNativeQuery(sql.toString(), Attendance.class);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
