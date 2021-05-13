/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.WorkAssignment;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class WorkAssignmentBean extends SuperEJBForEFGP<WorkAssignment> {

    public WorkAssignmentBean() {
        super(WorkAssignment.class);
    }

    public WorkAssignment findByWorkItemOID(String workItemOID) {
        Query query = getEntityManager().createNamedQuery("WorkAssignment.findByWorkItemOID");
        query.setParameter("workItemOID", workItemOID);
        try {
            Object o = query.getSingleResult();
            return (WorkAssignment) o;
        } catch (Exception ex) {
            return null;
        }
    }

    public String getAssigneeOID(String workItemOID) {
        WorkAssignment assignment = findByWorkItemOID(workItemOID);
        if (assignment != null) {
            return assignment.getAssigneeOID();
        } else {
            return "";
        }
    }

}
