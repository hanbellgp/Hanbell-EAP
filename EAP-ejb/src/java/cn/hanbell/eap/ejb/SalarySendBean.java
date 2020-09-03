/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.*;
import com.lightshell.comm.BaseLib;
import java.util.Date;
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
public class SalarySendBean extends SuperEJBForEAP<SalarySend> {

    public SalarySendBean() {
        super(SalarySend.class);
    }

    public List<SalarySend> findByTaskidAndDeptno(String taskid, String deptno) {
        Query query = getEntityManager().createNamedQuery("SalarySend.findByTaskidAndDeptno");
        query.setParameter("taskid", taskid + "%");
        query.setParameter("deptno", deptno);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public SalarySend findByTaskidAndEmployeeid(String taskid, String employeeid) {
        Query query = getEntityManager().createNamedQuery("SalarySend.findByTaskidAndEmployeeid");
        query.setParameter("taskid", taskid);
        query.setParameter("employeeid", employeeid);
        try {
            return (SalarySend) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

    public SalarySend findByTaskNameAndEmployeeid(String taskname, String employeeid) {
        StringBuffer sql=new StringBuffer("SELECT * FROM SalarySend s WHERE s.taskname ='");
        sql.append(taskname).append("'");
        sql.append( " and s.employeeid='").append(employeeid).append("'");
        Query query = getEntityManager().createNativeQuery(sql.toString(),SalarySend.class);
        try {
            return (SalarySend) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }
    public String getTaskId(String taskid) {
        String ls_no = "";
        String ls_ta002 = "";
        String serial = "00";
        ls_ta002 = BaseLib.formatDate("yyyyMMdd", new Date());
        String sql = "SELECT * FROM salarysend WHERE taskid like '" + taskid + "%' GROUP BY taskid";
        Query query = getEntityManager().createNativeQuery(sql);
        List result = query.getResultList();
        int m = 0;
        if (null != result && !result.isEmpty()) {
            m = result.size();
            m = m + 1;
        } else {
            m = 1;
        }
        serial = serial + m;
        serial = serial.substring(String.valueOf(m).length());
        ls_no += taskid;
        ls_no += serial;
        return ls_no;
    }
}
