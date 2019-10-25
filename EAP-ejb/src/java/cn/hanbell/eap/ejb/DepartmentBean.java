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
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
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

    @Override
    public JsonObjectBuilder createJsonObjectBuilder(Department entity) {
        JsonObjectBuilder job = Json.createObjectBuilder();
        if (entity != null) {
            job.add("id", entity.getId())
                    .add("name", entity.getDept());
            if (entity.getParentDept() != null) {
                job.add("parentid", entity.getParentDept().getId());
            }
        }
        return job;
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
