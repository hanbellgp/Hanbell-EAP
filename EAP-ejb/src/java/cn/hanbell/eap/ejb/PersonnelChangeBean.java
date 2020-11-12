/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.PersonnelChange;
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
public class PersonnelChangeBean extends SuperEJBForEAP<PersonnelChange> {

    public PersonnelChangeBean() {
        super(PersonnelChange.class);
    }

    public boolean hanExistPersist(PersonnelChange p) {
        StringBuffer sql = new StringBuffer("SELECT * FROM PersonnelChange s WHERE s.taskname ='");
        sql.append(p.getTaskname()).append("'");
        sql.append(" and s.employeeid='").append(p.getEmployeeid()).append("'");
        Query query = getEntityManager().createNativeQuery(sql.toString(), PersonnelChange.class);
        try {
            List<PersonnelChange> pcs = query.getResultList();
            if (pcs == null || pcs.isEmpty()) {
                p.setContent("123");
                persist(p);
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return true;
    }

    public PersonnelChange findByEmployeeIdAndTaskId(String employeeid, String taskid) {
        Query query = getEntityManager().createNamedQuery("PersonnelChange.findByTaskidAndEmployeeid");
        query.setParameter("employeeid", employeeid);
        query.setParameter("taskid", taskid);
        try {
            PersonnelChange p = (PersonnelChange)query.getSingleResult();
            return p;
        } catch (Exception e) {
            return null;
        }
    }

    public String getTaskId(String taskid) {
        String ls_no = "";
        String ls_ta002 = "";
        String serial = "00";
        ls_ta002 = BaseLib.formatDate("yyyyMMdd", new Date());
        String sql = "SELECT * FROM PersonnelChange WHERE taskid like '" + taskid + "%' GROUP BY taskid";
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
