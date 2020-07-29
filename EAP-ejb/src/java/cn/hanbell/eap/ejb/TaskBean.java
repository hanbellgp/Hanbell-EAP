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
import cn.hanbell.eap.entity.SystemUser;
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
public class TaskBean extends SuperEJBForEAP<Task> {

    @EJB
    private SystemUserBean systemUserBean;

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

    public List<Task> findByExecutorIdAndStatus(String executorid, String status, Integer offset, Integer size) {
        Query query = getEntityManager().createNamedQuery("Task.findByExecutorIdAndStatus").setFirstResult(offset).setMaxResults(size);;
        query.setParameter("executorId", executorid);
        query.setParameter("status", status);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Task> findByManagerIdAndActualFinishDate(String managerid, Date date, Integer offset, Integer size) {
        List<SystemUser> subordinates = systemUserBean.findByManagerIdAndOnJob(managerid);
        if (subordinates != null && !subordinates.isEmpty()) {
            List<String> executors = new ArrayList<>();
            //下属列表
            subordinates.stream().forEach((e) -> {
                executors.add(e.getUserid());
            });
            Query query = getEntityManager().createNamedQuery("Task.findByExecutorsAndActualFinishDate").setFirstResult(offset).setMaxResults(size);
            query.setParameter("executors", executors);
            query.setParameter("actualFinishDate", date);
            try {
                return query.getResultList();
            } catch (Exception ex) {
                return null;
            }
        } else {
            return new ArrayList<>();
        }
    }

    public List<Task> findByManagerIdAndPlannedStartDate(String managerid, Date date, Integer offset, Integer size) {
        List<SystemUser> subordinates = systemUserBean.findByManagerIdAndOnJob(managerid);
        if (subordinates != null && !subordinates.isEmpty()) {
            List<String> executors = new ArrayList<>();
            //下属列表
            subordinates.stream().forEach((e) -> {
                executors.add(e.getUserid());
            });
            Query query = getEntityManager().createNamedQuery("Task.findByExecutorsAndPlannedStartDate").setFirstResult(offset).setMaxResults(size);
            query.setParameter("executors", executors);
            query.setParameter("plannedStartDate", date);
            try {
                return query.getResultList();
            } catch (Exception ex) {
                return null;
            }
        } else {
            return new ArrayList<>();
        }
    }

    public List<Task> findByManagerIdAndStatus(String managerid, String status, Integer offset, Integer size) {
        List<SystemUser> subordinates = systemUserBean.findByManagerIdAndOnJob(managerid);
        if (subordinates != null && !subordinates.isEmpty()) {
            List<String> executors = new ArrayList<>();
            //筛选条件
            subordinates.stream().forEach((e) -> {
                executors.add(e.getUserid());
            });
            Query query = getEntityManager().createNamedQuery("Task.findByExecutorsAndStatus").setFirstResult(offset).setMaxResults(size);
            query.setParameter("executors", executors);
            query.setParameter("status", status);
            try {
                return query.getResultList();
            } catch (Exception ex) {
                return null;
            }
        } else {
            return new ArrayList<>();
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

    public Integer getRowCountByExecutorIdAndStatus(String executorid, String status) {
        Query query = getEntityManager().createNamedQuery("Task.getRowCountByExecutorIdAndStatus");
        query.setParameter("executorId", executorid);
        query.setParameter("status", status);
        try {
            return Integer.valueOf(query.getSingleResult().toString());
        } catch (Exception ex) {
            log4j.error(ex);
            return 0;
        }
    }

    public Integer getRowCountByExecutorIdAndYear(String executorid, Integer y) {
        Query query = getEntityManager().createNamedQuery("Task.getRowCountByExecutorIdAndYear");
        query.setParameter("executorId", executorid);
        query.setParameter("y", y);
        try {
            return Integer.valueOf(query.getSingleResult().toString());
        } catch (Exception ex) {
            log4j.error(ex);
            return 0;
        }
    }

    public Integer getRowCountByExecutorIdYearAndMonth(String executorid, Integer y, Integer m) {
        Query query = getEntityManager().createNamedQuery("Task.getRowCountByExecutorIdYearAndMonth");
        query.setParameter("executorId", executorid);
        query.setParameter("y", y);
        query.setParameter("m", m);
        try {
            return Integer.valueOf(query.getSingleResult().toString());
        } catch (Exception ex) {
            log4j.error(ex);
            return 0;
        }
    }

    public Integer getRowCountByManagerIdAndActualFinishDate(String managerid, Date date) {
        List<SystemUser> subordinates = systemUserBean.findByManagerIdAndOnJob(managerid);
        if (subordinates != null && !subordinates.isEmpty()) {
            List<String> executors = new ArrayList<>();
            //下属列表
            subordinates.stream().forEach((e) -> {
                executors.add(e.getUserid());
            });
            Query query = getEntityManager().createNamedQuery("Task.getRowCountByExecutorsAndActualFinishDate");
            query.setParameter("executors", executors);
            query.setParameter("actualFinishDate", date);
            try {
                return Integer.valueOf(query.getSingleResult().toString());
            } catch (Exception ex) {
                return 0;
            }
        } else {
            return 0;
        }
    }

    public Integer getRowCountByManagerIdAndPlannedStartDate(String managerid, Date date) {
        List<SystemUser> subordinates = systemUserBean.findByManagerIdAndOnJob(managerid);
        if (subordinates != null && !subordinates.isEmpty()) {
            List<String> executors = new ArrayList<>();
            //下属列表
            subordinates.stream().forEach((e) -> {
                executors.add(e.getUserid());
            });
            Query query = getEntityManager().createNamedQuery("Task.getRowCountByExecutorsAndPlannedStartDate");
            query.setParameter("executors", executors);
            query.setParameter("plannedStartDate", date);
            try {
                return Integer.valueOf(query.getSingleResult().toString());
            } catch (Exception ex) {
                return 0;
            }
        } else {
            return 0;
        }
    }

    public Integer getRowCountByManagerIdAndStatus(String managerid, String status) {
        List<SystemUser> subordinates = systemUserBean.findByManagerIdAndOnJob(managerid);
        if (subordinates != null && !subordinates.isEmpty()) {
            List<String> executors = new ArrayList<>();
            //下属列表
            subordinates.stream().forEach((e) -> {
                executors.add(e.getUserid());
            });
            Query query = getEntityManager().createNamedQuery("Task.getRowCountByExecutorsAndStatus");
            query.setParameter("executors", executors);
            query.setParameter("status", status);
            try {
                return Integer.valueOf(query.getSingleResult().toString());
            } catch (Exception ex) {
                log4j.error(ex);
                return 0;
            }
        } else {
            return 0;
        }
    }

    public Integer getRowCountByManagerIdAndYear(String managerid, Integer y) {
        List<SystemUser> subordinates = systemUserBean.findByManagerIdAndOnJob(managerid);
        if (subordinates != null && !subordinates.isEmpty()) {
            List<String> executors = new ArrayList<>();
            //下属列表
            subordinates.stream().forEach((e) -> {
                executors.add(e.getUserid());
            });
            Query query = getEntityManager().createNamedQuery("Task.getRowCountByExecutorsAndYear");
            query.setParameter("executors", executors);
            query.setParameter("y", y);
            try {
                return Integer.valueOf(query.getSingleResult().toString());
            } catch (Exception ex) {
                log4j.error(ex);
                return 0;
            }
        } else {
            return 0;
        }
    }

    public Integer getRowCountByManagerIdYearAndMonth(String managerid, Integer y, Integer m) {
        List<SystemUser> subordinates = systemUserBean.findByManagerIdAndOnJob(managerid);
        if (subordinates != null && !subordinates.isEmpty()) {
            List<String> executors = new ArrayList<>();
            //下属列表
            subordinates.stream().forEach((e) -> {
                executors.add(e.getUserid());
            });
            Query query = getEntityManager().createNamedQuery("Task.getRowCountByExecutorsYearAndMonth");
            query.setParameter("executors", executors);
            query.setParameter("y", y);
            query.setParameter("m", m);
            try {
                return Integer.valueOf(query.getSingleResult().toString());
            } catch (Exception ex) {
                log4j.error(ex);
                return 0;
            }
        } else {
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
