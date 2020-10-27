/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.jrs;

import cn.hanbell.eap.ejb.AttendanceBean;
import cn.hanbell.eap.entity.Attendance;
import cn.hanbell.jrs.SuperRESTForEAP;
import com.lightshell.comm.SuperEJB;
import javax.ejb.EJB;
import javax.ws.rs.Path;

/**
 *
 * @author C2082
 */
@Path("eap/attendance")
@javax.enterprise.context.RequestScoped
public class AttendanceFacadeREST extends SuperRESTForEAP<Attendance> {

    @EJB
    private AttendanceBean attendanceBean;
    public AttendanceFacadeREST() {
        super(Attendance.class);
    }

    @Override
    protected SuperEJB getSuperEJB() {
        return attendanceBean;
    }
    
}
