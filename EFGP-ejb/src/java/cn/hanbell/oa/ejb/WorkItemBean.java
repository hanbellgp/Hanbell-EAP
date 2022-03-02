/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.WorkAssignment;
import cn.hanbell.oa.entity.WorkItem;
import cn.hanbell.util.BaseLib;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
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

    @EJB
    private WorkAssignmentBean workAssignmentBean;

    public WorkItemBean() {
        super(WorkItem.class);
    }

    public WorkItem findByContainerOIDAndContextOID(String containerOID, String contextOID) {
        Query query = getEntityManager().createNamedQuery("WorkItem.findByContainerOIDAndContextOID");
        query.setParameter("containerOID", containerOID);
        query.setParameter("contextOID", contextOID);
        try {
            Object o = query.getSingleResult();
            return (WorkItem) o;
        } catch (Exception ex) {
            return null;
        }
    }

    public List<WorkItem> findByContextOID(String contextOID) {
        Query query = getEntityManager().createNamedQuery("WorkItem.findByContextOID");
        query.setParameter("contextOID", contextOID);
        return query.getResultList();
    }

    public List<WorkItem> findByProcessIdAndCompletedTime(String processId, Date startTime, Date endTime) {
        Query query = getEntityManager().createNamedQuery("WorkItem.findByProcessIdAndCompletedTime");
        query.setParameter("processId", processId);
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

    public List<String> findProcessSerialNumbersByProcessIdAndCompletedTime(String processId, Date startTime, Date endTime) {
        List<WorkItem> workItems = findByProcessIdAndCompletedTime(processId, startTime, endTime);
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

    public List<String> findProcessNumbersByWorkItemName(String processDefinition,String workItemName, Date beginDate,Date endDate) {
        StringBuffer sql = new StringBuffer("select p.serialNumber");
        sql.append(" from (select contextOID from WorkItem where workItemName in (").append(workItemName).append(")");
        if(beginDate!=null && !"".equals(beginDate)){
            sql.append(" and createdTime>='").append(BaseLib.formatDate("yyyy-MM-dd 00:00:00", beginDate)).append("'");
        }
        if(endDate!=null && !"".equals(endDate)){
             sql.append(" and createdTime<='").append(BaseLib.formatDate("yyyy-MM-dd 23:59:59", endDate)).append("'");
        }
        sql.append(" and completedTime is null) a");
        sql.append(" left join ProcessInstance p on p.contextOID=a.contextOID");
        sql.append("  where p.processDefinitionId='").append(processDefinition).append("'");
        Query query = getEntityManager().createNativeQuery(sql.toString());
        try {
            List<String> result = query.getResultList();
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    public List<WorkItem> findWorkItem(String processId, String workItemName, Date startTime, Date endTime) {
        Query query = getEntityManager().createNamedQuery("WorkItem.findByProcessIdWorkItemNameAndTime");
        query.setParameter("processId", processId);
        query.setParameter("workItemName", workItemName);
        query.setParameter("startTime", startTime);
        query.setParameter("endTime", endTime);
        return query.getResultList();
    }
    



    public String getAssigneeOID(String workItemOID) {
        return workAssignmentBean.getAssigneeOID(workItemOID);
    }

    public String getAssigneeOID(String containerOID, String contextOID) {
        return getAssigneeOID(getWorkItemOID(containerOID, contextOID));
    }

    public WorkAssignment getWorkAssignment(String workItemOID) {
        return workAssignmentBean.findByWorkItemOID(workItemOID);
    }

    public String getWorkItemOID(String containerOID, String contextOID) {
        WorkItem item = findByContainerOIDAndContextOID(containerOID, contextOID);
        if (item != null) {
            return item.getOID();
        } else {
            return "";
        }
    }

}
