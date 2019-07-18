/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.hrm.ejb;

import cn.hanbell.hrm.comm.SuperEJBForHRM;
import cn.hanbell.hrm.entity.Department;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class DepartmentBean extends SuperEJBForHRM<Department> {

    public DepartmentBean() {
        super(Department.class);
    }

    public Department findByDepartmentId(String id) {
        Query query = getEntityManager().createNamedQuery("Department.findByDepartmentId");
        query.setParameter("departmentId", id);
        try {
            Object o = query.getSingleResult();
            return (Department) o;
        } catch (Exception ex) {
            return null;
        }
    }

    public Department findByCode(String code) {
        Query query = getEntityManager().createNamedQuery("Department.findByCode");
        query.setParameter("code", code);
        try {
            Object o = query.getSingleResult();
            return (Department) o;
        } catch (Exception ex) {
            return null;
        }
    }

}
