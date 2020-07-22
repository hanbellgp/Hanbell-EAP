/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.hrm.ejb;

import cn.hanbell.hrm.comm.SuperEJBForHRM;
import cn.hanbell.hrm.entity.Employee;
import cn.hanbell.hrm.entity.EmployeePartJob;
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
public class EmployeeBean extends SuperEJBForHRM<Employee> {

    @EJB
    private EmployeePartJobBean employeePartJobBean;

    public EmployeeBean() {
        super(Employee.class);
    }

    public List<Employee> findByCreateDate(Date value) {
        Query query = getEntityManager().createNamedQuery("Employee.findByCreateDate");
        query.setParameter("createDate", value);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Employee> findByDepartmentCode(String code) {
        Query query = getEntityManager().createNamedQuery("Employee.findByDepartmentCode");
        query.setParameter("code", code);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Employee> findByLastModifiedDate(Date value) {
        Query query = getEntityManager().createNamedQuery("Employee.findByLastModifiedDate");
        query.setParameter("lastModifiedDate", value);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public List<EmployeePartJob> findPartJobByEmployeeId(String employeeId) {
        return employeePartJobBean.findByEmployeeId(employeeId);
    }

}
