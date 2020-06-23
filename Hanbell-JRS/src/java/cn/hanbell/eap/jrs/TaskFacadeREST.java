/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.jrs;

import cn.hanbell.eap.ejb.TaskBean;
import cn.hanbell.eap.entity.Task;
import cn.hanbell.jrs.SuperRESTForEAP;
import com.lightshell.comm.SuperEJB;
import javax.ejb.EJB;
import javax.ws.rs.Path;

/**
 *
 * @author C0160
 */
@Path("eap/task")
public class TaskFacadeREST extends SuperRESTForEAP<Task> {

    @EJB
    private TaskBean taskBean;

    public TaskFacadeREST() {
        super(Task.class);
    }

    @Override
    protected SuperEJB getSuperEJB() {
        return taskBean;
    }

}
