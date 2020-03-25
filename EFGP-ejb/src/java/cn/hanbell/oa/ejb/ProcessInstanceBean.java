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

}
