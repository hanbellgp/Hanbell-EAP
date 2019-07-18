/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.Department;
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
public class DepartmentBean extends SuperEJBForEAP<Department> {

    public DepartmentBean() {
        super(Department.class);
    }

    public Department findByDeptno(String value) {
        Query query = getEntityManager().createNamedQuery("Department.findByDeptno");
        query.setParameter("deptno", value);
        try {
            Object o = query.getSingleResult();
            return (Department) o;
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Department> findRoot() {
        Query query = getEntityManager().createNamedQuery("Department.findRoot");
        return query.getResultList();
    }

}
