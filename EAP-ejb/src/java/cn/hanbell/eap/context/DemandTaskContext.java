/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.context;

import cn.hanbell.eap.ejb.DemandsBean;
import cn.hanbell.eap.ejb.TaskBean;
import cn.hanbell.eap.entity.Demands;
import cn.hanbell.eap.entity.Task;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author C0160
 */
public class DemandTaskContext implements TaskContext<Demands> {

    DemandsBean demandsBean = lookupDemandsBean();

    TaskBean taskBean = lookupTaskBean();

    @Override
    public Task updateTask(Demands context) throws Exception {
        Task task;
        try {
            task = taskBean.findByContextId(context.getId());
            if (task == null) {
                task = new Task();
                task.setName(context.getDemandResume());
                task.setDescription(context.getDemandResume());
                task.setExecutorId(context.getDirectorID());
                task.setExecutor(context.getDirectorName());
                task.setDeptId(context.getDirectorDeptID());
                task.setDept(context.getDirectorDeptName());
                task.setPriority(context.getEmergencyDegree());
                task.setPlannedStartDate(context.getPlanStartDate());
                task.setPlannedFinishDate(context.getPlanOverDate());
                task.setContextObject("D");
                task.setContextId(context.getId());
                task.setStatusToNew();
                taskBean.persist(task);
            } else {
                if (task.getStatus().equals("V")) {
                    // 结案直接返回
                    return task;
                }
                task.setName(context.getDemandResume());
                task.setDescription(context.getDemandResume());
                task.setExecutorId(context.getDirectorID());
                task.setExecutor(context.getDirectorName());
                task.setDeptId(context.getDirectorDeptID());
                task.setDept(context.getDirectorDeptName());
                task.setPriority(context.getEmergencyDegree());
                task.setPlannedStartDate(context.getPlanStartDate());
                task.setPlannedFinishDate(context.getPlanOverDate());
                task.setActualStartDate(context.getRealStartDate());
                task.setActualFinishDate(context.getRealOverDate());
                taskBean.update(task);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return task;

    }

    @Override
    public void updateContext(Task task) throws Exception {
        if (task != null) {
            Demands demand = demandsBean.findById(task.getContextId());
            if (demand != null) {
                demand.setPlanStartDate(task.getPlannedStartDate());
                demand.setPlanOverDate(task.getPlannedFinishDate());
                demand.setRealStartDate(task.getActualStartDate());
                demand.setRealOverDate(task.getActualFinishDate());
                try {
                    demandsBean.update(demand);
                } catch (Exception ex) {
                    throw ex;
                }
            }
        }
    }

    private DemandsBean lookupDemandsBean() {
        try {
            Context c = new InitialContext();
            return (DemandsBean) c.lookup("java:global/Hanbell-EAP/EAP-ejb/DemandsBean!cn.hanbell.eap.ejb.DemandsBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private TaskBean lookupTaskBean() {
        try {
            Context c = new InitialContext();
            return (TaskBean) c.lookup("java:global/Hanbell-EAP/EAP-ejb/TaskBean!cn.hanbell.eap.ejb.TaskBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
