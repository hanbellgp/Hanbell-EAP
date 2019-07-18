/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.mes.ejb;

import cn.hanbell.mes.comm.SuperEJBForMES;
import cn.hanbell.mes.entity.MDepartment;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class MDepartmentBean extends SuperEJBForMES<MDepartment> {

    public MDepartmentBean() {
        super(MDepartment.class);
    }

    public MDepartment findByDepartmentid(String id) {
        Query query = getEntityManager().createNamedQuery("MDepartment.findByDepartmentid");
        query.setParameter("departmentid", id);
        try {
            Object o = query.getSingleResult();
            return (MDepartment) o;
        } catch (Exception ex) {
            return null;
        }
    }

}
