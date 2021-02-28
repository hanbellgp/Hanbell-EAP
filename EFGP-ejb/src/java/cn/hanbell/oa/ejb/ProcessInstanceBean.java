/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.ProcessInstance;
import cn.hanbell.oa.entity.WorkItem;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C1491
 */
@Stateless
@LocalBean
public class ProcessInstanceBean extends SuperEJBForEFGP<ProcessInstance> {

    @EJB
    private WorkItemBean workItemBean;

    public ProcessInstanceBean() {
        super(ProcessInstance.class);
    }

    public ProcessInstance findByOID(String oid) {
        Query query = getEntityManager().createNamedQuery("ProcessInstance.findByOID");
        query.setParameter("oid", oid);
        try {
            return (ProcessInstance) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

    public ProcessInstance findBySerialNumber(String serialNumber) {
        Query query = getEntityManager().createNamedQuery("ProcessInstance.findBySerialNumber");
        query.setParameter("serialNumber", serialNumber);
        try {
            return (ProcessInstance) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

    public List<WorkItem> getWorkItemListBySerialNumber(String psn) {
        try {
            ProcessInstance pi = findBySerialNumber(psn);
            if (pi != null) {
                List<WorkItem> workItemList;
                workItemList = workItemBean.findByContextOID(pi.getContextOID());
                return workItemList;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public String getCurrentStateValue(int currentstate) {
        switch (currentstate) {
            case 0:
                return "未开始";
            case 1:
                return "进行中";
            case 2:
                return "已暂停";
            case 3:
                return "已完成";
            case 4:
                return "已撤销";
            case 5:
                return "已终止";
            case 6:
                return "进行中，但已开始执行";
        }
        return "";
    }

    /**
     * 根据工号分类获取当前工号下有多少流程未处理。
     *
     * @param dateBegin
     * @param dateEnd
     * @return
     */
    public List<Object[]> getWorkAssignmentGroupByUserid(String dateBegin, String dateEnd) {
        StringBuffer sql = new StringBuffer("SELECT fei.id,fei.username,count(*) as '数量'");
        sql.append(" FROM (");
        sql.append("SELECT DISTINCT ");
        sql.append(" ProcessInstance.serialNumber,");
        sql.append(" ProcessInstance.currentState AS processState,");
        sql.append(" ProcessInstance.OID AS processOID,");
        sql.append(" ParticipantActivityInstance.definitionId, Users.id,");
        sql.append(" Users.userName As username");
        sql.append(" FROM ProcessInstance, ParticipantActivityInstance, WorkItem,");
        sql.append(" WorkAssignment, Users");
        sql.append(" WHERE");
        sql.append(" ParticipantActivityInstance.contextOID = ProcessInstance.contextOID");
        sql.append(" AND (ParticipantActivityInstance.currentState = 0 OR");
        sql.append(" ParticipantActivityInstance.currentState = 1 OR");
        sql.append(" ParticipantActivityInstance.currentState = 6) AND");
        sql.append(" WorkItem.containerOID = ParticipantActivityInstance.OID AND");
        sql.append(" (WorkItem.currentState = 0 OR");
        sql.append(" WorkItem.currentState = 1) AND");
        sql.append(" WorkAssignment.workItemOID = WorkItem.OID AND");
        sql.append(" WorkAssignment.isNotice = 0 AND");
        sql.append(" WorkAssignment.assigneeOID = Users.OID AND");
        sql.append(" WorkItem.createdTime>='").append(dateBegin).append("' AND");
        //获取最后一个时间点的时候在那个时间过的关卡也要被记录下来
        if("18:00:00.000".equals(dateEnd.split(" ")[1])||"22:00:00.000".equals(dateEnd.split(" ")[1])){
            sql.append(" WorkItem.createdTime<='").append(dateEnd).append("' AND");
        }else{
            sql.append(" WorkItem.createdTime<'").append(dateEnd).append("'");
        }
        sql.append(") as fei group by fei.id,fei.username");
        try {
            Query query=getEntityManager().createNativeQuery(sql.toString());
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
