/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.jrs;

import cn.hanbell.eap.ejb.TaskAttachmentBean;
import cn.hanbell.eap.ejb.TaskBean;
import cn.hanbell.eap.ejb.TaskParticipantBean;
import cn.hanbell.eap.entity.Task;
import cn.hanbell.eap.entity.TaskAttachment;
import cn.hanbell.eap.entity.TaskParticipant;
import cn.hanbell.jrs.ResponseData;
import cn.hanbell.jrs.ResponseMessage;
import cn.hanbell.jrs.ResponseObject;
import cn.hanbell.jrs.SuperRESTForEAP;
import com.lightshell.comm.BaseLib;
import com.lightshell.comm.SuperEJB;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;

/**
 *
 * @author C0160
 */
@Path("eap/task")
public class TaskFacadeREST extends SuperRESTForEAP<Task> {

    @EJB
    private TaskBean taskBean;
    @EJB
    private TaskParticipantBean participantBean;
    @EJB
    private TaskAttachmentBean attachmentBean;

    public TaskFacadeREST() {
        super(Task.class);
    }

    @Override
    protected SuperEJB getSuperEJB() {
        return taskBean;
    }

    @Override
    public ResponseMessage edit(PathSegment id, Task entity, String appid, String token) {
        if (isAuthorized(appid, token)) {
            Task t;
            List<TaskParticipant> participantList = null;
            List<TaskAttachment> attachmentList = null;
            try {
                t = taskBean.findById(Integer.parseInt(id.getPath()));
                if (t == null) {
                    return new ResponseMessage("404", "找不到对象");
                }
                participantList = participantBean.findByPId(t.getId());
                if (participantList != null && !participantList.isEmpty()) {
                    participantBean.delete(participantList);
                }
                attachmentList = attachmentBean.findByPId(t.getId());
                if (attachmentList != null && !attachmentList.isEmpty()) {
                    attachmentBean.delete(attachmentList);
                }
                taskBean.update(entity);
                return new ResponseMessage("200", "更新成功");
            } catch (Exception ex) {
                return new ResponseMessage("500", "系统错误更新失败");
            } finally {
                t = null;
                if (participantList != null) {
                    participantList.clear();
                }
                participantList = null;
                if (attachmentList != null) {
                    attachmentList.clear();
                }
                attachmentList = null;
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("executor/{executorid}")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseData findByExecutorId(@PathParam("executorid") String executorid,
            @QueryParam("status") String status, @QueryParam("offset") Integer offset,
            @QueryParam("pageSize") Integer pageSize, @QueryParam("appid") String appid,
            @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            try {
                List<Task> list = taskBean.findByExecutorIdAndStatus(executorid, status, offset, pageSize);
                ResponseData res = new ResponseData<Task>("200", "获取成功");
                res.setData(list);
                res.setCount(list.size());
                return res;
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("executor/{executorid}/progress")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseObject findByExecutorIdAndProgress(@PathParam("executorid") String executorid,
            @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            Map<String, Integer> obj = new HashMap<>();
            Calendar c = Calendar.getInstance();
            Integer thisYearFinished, thisMonthFinished, unfinished;
            try {
                thisYearFinished = taskBean.getRowCountByExecutorIdAndYear(executorid, c.get(Calendar.YEAR));
                thisMonthFinished = taskBean.getRowCountByExecutorIdYearAndMonth(executorid, c.get(Calendar.YEAR),
                        c.get(Calendar.MONTH) + 1);
                unfinished = taskBean.getRowCountByExecutorIdAndStatus(executorid, "N");
                obj.put("thisYearFinished", thisYearFinished);
                obj.put("thisMonthFinished", thisMonthFinished);
                obj.put("unfinished", unfinished);
                ResponseObject res = new ResponseObject("200", "获取成功");
                res.setObject(obj);
                return res;
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("executor/{executorid}/past_weeks/{weeks}")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseData findByExecutorIdAndPastWeeks(@PathParam("executorid") String executorid,
            @PathParam("weeks") Integer weeks, @QueryParam("offset") Integer offset,
            @QueryParam("pageSize") Integer pageSize, @QueryParam("appid") String appid,
            @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            try {
                Calendar c = Calendar.getInstance();
                c.setTime(BaseLib.getDate());
                c.add(Calendar.DATE, weeks * -7);

                List<Task> list = taskBean.findByExecutorIdAndActualFinishDate(executorid, c.getTime(), offset,
                        pageSize);
                Integer count = taskBean.getRowCountByExecutorIdAndActualFinishDate(executorid, c.getTime());
                ResponseData res = new ResponseData<Task>("200", "success");
                res.setData(list);
                res.setCount(count);
                return res;
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("executor/{executorid}/next_weeks/{weeks}")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseData findByExecutorIdAndNextWeeks(@PathParam("executorid") String executorid,
            @PathParam("weeks") Integer weeks, @QueryParam("offset") Integer offset,
            @QueryParam("pageSize") Integer pageSize, @QueryParam("appid") String appid,
            @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            try {
                Calendar c = Calendar.getInstance();
                c.setTime(BaseLib.getDate());
                c.add(Calendar.DATE, weeks * 7);

                List<Task> list = taskBean.findByExecutorIdAndPlannedStartDate(executorid, c.getTime(), offset,
                        pageSize);
                Integer count = taskBean.getRowCountByExecutorIdAndPlannedStartDate(executorid, c.getTime());
                ResponseData res = new ResponseData<Task>("200", "success");
                res.setData(list);
                res.setCount(count);
                return res;
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("manager/{managerid}")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseData findByManagerId(@PathParam("managerid") String managerid, @QueryParam("status") String status,
            @QueryParam("offset") Integer offset, @QueryParam("pageSize") Integer pageSize,
            @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            try {
                List<Task> list = taskBean.findByManagerIdAndStatus(managerid, status, offset, pageSize);
                ResponseData res = new ResponseData<Task>("200", "获取成功");
                res.setData(list);
                res.setCount(list.size());
                return res;
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("manager/{managerid}/progress")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseObject findByManagerIdAndProgress(@PathParam("managerid") String managerid,
            @QueryParam("appid") String appid, @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            Map<String, Integer> obj = new HashMap<>();
            Calendar c = Calendar.getInstance();
            Integer thisYearFinished, thisMonthFinished, unfinished;
            try {
                thisYearFinished = taskBean.getRowCountByManagerIdAndYear(managerid, c.get(Calendar.YEAR));
                thisMonthFinished = taskBean.getRowCountByManagerIdYearAndMonth(managerid, c.get(Calendar.YEAR),
                        c.get(Calendar.MONTH) + 1);
                unfinished = taskBean.getRowCountByManagerIdAndStatus(managerid, "N");
                obj.put("thisYearFinished", thisYearFinished);
                obj.put("thisMonthFinished", thisMonthFinished);
                obj.put("unfinished", unfinished);
                ResponseObject res = new ResponseObject("200", "获取成功");
                res.setObject(obj);
                return res;
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("manager/{managerid}/past_weeks/{weeks}")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseData findByManagerIdAndPastWeeks(@PathParam("managerid") String managerid,
            @PathParam("weeks") Integer weeks, @QueryParam("offset") Integer offset,
            @QueryParam("pageSize") Integer pageSize, @QueryParam("appid") String appid,
            @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            try {
                Calendar c = Calendar.getInstance();
                c.setTime(BaseLib.getDate());
                c.add(Calendar.DATE, weeks * -7);

                List<Task> list = taskBean.findByManagerIdAndActualFinishDate(managerid, c.getTime(), offset, pageSize);
                Integer count = taskBean.getRowCountByManagerIdAndActualFinishDate(managerid, c.getTime());
                ResponseData res = new ResponseData<Task>("200", "success");
                res.setData(list);
                res.setCount(count);
                return res;
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("manager/{managerid}/next_weeks/{weeks}")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseData findByManagerIdAndNextWeeks(@PathParam("managerid") String managerid,
            @PathParam("weeks") Integer weeks, @QueryParam("offset") Integer offset,
            @QueryParam("pageSize") Integer pageSize, @QueryParam("appid") String appid,
            @QueryParam("token") String token) {
        if (isAuthorized(appid, token)) {
            try {
                Calendar c = Calendar.getInstance();
                c.setTime(BaseLib.getDate());
                c.add(Calendar.DATE, weeks * 7);

                List<Task> list = taskBean.findByManagerIdAndPlannedStartDate(managerid, c.getTime(), offset, pageSize);
                Integer count = taskBean.getRowCountByManagerIdAndPlannedStartDate(managerid, c.getTime());
                ResponseData res = new ResponseData<Task>("200", "success");
                res.setData(list);
                res.setCount(count);
                return res;
            } catch (Exception ex) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } else {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

}
