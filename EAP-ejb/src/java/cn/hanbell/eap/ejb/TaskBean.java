/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.comm.TaskContextFactory;
import cn.hanbell.eap.entity.Task;
import cn.hanbell.eap.context.TaskContext;
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
public class TaskBean extends SuperEJBForEAP<Task> {

    private TaskContext taskContext;

    public TaskBean() {
        super(Task.class);
    }

    public Task findByContextId(Integer contextId) {
        Query query = getEntityManager().createNamedQuery("Task.findByContextId");
        query.setParameter("contextId", contextId);
        try {
            Object o = query.getSingleResult();
            return (Task) o;
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Task> findByExecutorIdAndActualFinishDate(String executorid, Date date, Integer offset, Integer size) {
        Query query = getEntityManager().createNamedQuery("Task.findByExecutorIdAndActualFinishDate").setFirstResult(offset).setMaxResults(size);
        query.setParameter("executorId", executorid);
        query.setParameter("actualFinishDate", date);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Task> findByExecutorIdAndPlannedStartDate(String executorid, Date date, Integer offset, Integer size) {
        Query query = getEntityManager().createNamedQuery("Task.findByExecutorIdAndPlannedStartDate").setFirstResult(offset).setMaxResults(size);
        query.setParameter("executorId", executorid);
        query.setParameter("plannedStartDate", date);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Task> findByExecutorIdAndStatus(String executorid, String status) {
        Query query = getEntityManager().createNamedQuery("Task.findByExecutorIdAndStatus");
        query.setParameter("executorId", executorid);
        query.setParameter("status", status);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public Integer getRowCountByExecutorIdAndActualFinishDate(String executorid, Date date) {
        Query query = getEntityManager().createNamedQuery("Task.getRowCountByExecutorIdAndActualFinishDate");
        query.setParameter("executorId", executorid);
        query.setParameter("actualFinishDate", date);
        try {
            return Integer.valueOf(query.getSingleResult().toString());
        } catch (Exception ex) {
            return 0;
        }
    }

    public Integer getRowCountByExecutorIdAndPlannedStartDate(String executorid, Date date) {
        Query query = getEntityManager().createNamedQuery("Task.getRowCountByExecutorIdAndPlannedStartDate");
        query.setParameter("executorId", executorid);
        query.setParameter("plannedStartDate", date);
        try {
            return Integer.valueOf(query.getSingleResult().toString());
        } catch (Exception ex) {
            return 0;
        }
    }

    public void updateTaskContext(Task task) {
        if (task.getContextObject() != null && !"".equals(task.getContextObject())) {
            taskContext = TaskContextFactory.createTaskContext(task.getContextObject());
            if (taskContext != null) {
                try {
                    taskContext.updateContext(task);
                } catch (Exception ex) {
                    log4j.error(ex);
                }
            }
        }
    }

    @Override
    public Task update(Task entity) {
        Task task = super.update(entity);
        updateTaskContext(task);
        return task;
    }

}
