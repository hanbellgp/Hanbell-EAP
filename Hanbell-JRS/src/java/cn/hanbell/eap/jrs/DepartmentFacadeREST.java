/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.jrs;

import cn.hanbell.eap.ejb.DepartmentBean;
import cn.hanbell.eap.entity.Department;
import cn.hanbell.jrs.SuperRESTForEAP;
import com.lightshell.comm.SuperEJB;
import javax.ejb.EJB;
import javax.ws.rs.Path;

/**
 *
 * @author C0160
 */
@Path("eap/department")
public class DepartmentFacadeREST extends SuperRESTForEAP<Department> {

    @EJB
    private DepartmentBean departmentBean;

    public DepartmentFacadeREST() {
        super(Department.class);
    }

    @Override
    protected SuperEJB getSuperEJB() {
        return departmentBean;
    }

}
