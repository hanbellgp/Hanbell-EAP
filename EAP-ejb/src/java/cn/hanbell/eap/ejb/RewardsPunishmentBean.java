/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.PersonnelChange;
import cn.hanbell.eap.entity.RewardsPunishment;
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
public class RewardsPunishmentBean extends SuperEJBForEAP<RewardsPunishment> {

    public RewardsPunishmentBean() {
        super(RewardsPunishment.class);
    }

    public boolean hasExistPersist(RewardsPunishment p) {
        RewardsPunishment rp = findByEmployeeIdAndTaskId(p.getTaskid(), p.getEmployeeid());
        if (rp == null) {
            persist(p);
            return true;
        }
        return false;
    }

    public RewardsPunishment findByEmployeeIdAndTaskId(String taskid, String employeeid) {
        Query query = getEntityManager().createNamedQuery("RewardsPunishment.findByTaskidAndEmployeeid");
        query.setParameter("taskid", taskid);
        query.setParameter("employeeid", employeeid);
        try {
            RewardsPunishment rp = (RewardsPunishment) query.getSingleResult();
            return rp;
        } catch (Exception ex) {
            return null;
        }
    }

    public String getTaskId(String taskid) {
        String ls_no = "";
        String ls_ta002 = "";
        String serial = "00";
        ls_ta002 = BaseLib.formatDate("yyyyMMdd", new Date());
        String sql = "SELECT * FROM rewardspunishment WHERE taskid like '" + taskid + "%' GROUP BY taskid";
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
