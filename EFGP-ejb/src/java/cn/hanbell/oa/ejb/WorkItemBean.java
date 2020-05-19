/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.WorkItem;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class WorkItemBean extends SuperEJBForEFGP<WorkItem> {

    public WorkItemBean() {
        super(WorkItem.class);
    }

    public List<WorkItem> findWorkItem(String processId, String workItemName, Date startTime, Date endTime) {
        Query query = getEntityManager().createNamedQuery("WorkItem.findByProcessIdWorkItemNameAndTime");
        query.setParameter("processId", processId);
        query.setParameter("workItemName", workItemName);
        query.setParameter("startTime", startTime);
        query.setParameter("endTime", endTime);
        return query.getResultList();
    }

    public List<String> findProcessSerialNumbersByWorkItem(String processId, String workItemName, Date startTime, Date endTime) {
        List<WorkItem> workItems = findWorkItem(processId, workItemName, startTime, endTime);
        if (workItems != null && !workItems.isEmpty()) {
            List<String> results = new ArrayList<>();
            for (WorkItem e : workItems) {
                if (!results.contains(e.getProcessInstance().getSerialNumber())) {
                    results.add(e.getProcessInstance().getSerialNumber());
                }
            }
            return results;
        } else {
            return null;
        }
    }

    public List<WorkItem> findByContextOID(String contextOID) {
        Query query = getEntityManager().createNamedQuery("WorkItem.findByContextOID");
        query.setParameter("contextOID", contextOID);
        return query.getResultList();
    }

}
