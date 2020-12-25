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

}
