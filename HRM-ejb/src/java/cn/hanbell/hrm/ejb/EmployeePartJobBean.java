/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.hrm.ejb;

import cn.hanbell.hrm.comm.SuperEJBForHRM;
import cn.hanbell.hrm.entity.EmployeePartJob;
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
public class EmployeePartJobBean extends SuperEJBForHRM<EmployeePartJob> {

    public EmployeePartJobBean() {
        super(EmployeePartJob.class);
    }

    public List<EmployeePartJob> findByEmployeeId(String employeeId) {
        Query query = getEntityManager().createNamedQuery("EmployeePartJob.findByEmployeeId");
        query.setParameter("employeeId", employeeId);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

}
