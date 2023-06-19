/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.ServiceContract;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author C2082
 */
@Stateless
@LocalBean
public class ServiceContractBean extends SuperEJBForEAP<ServiceContract> {

    public ServiceContractBean() {
        super(ServiceContract.class);
    }

    public ServiceContract findByEmployeeIdAndTaskId(String taskid, String employeeid) {
        Query query = getEntityManager().createNamedQuery("ServiceContract.findByFormidAndEmployeeid");
        query.setParameter("formid", taskid);
        query.setParameter("employeeid", employeeid);
        try {
            ServiceContract rp = (ServiceContract) query.getSingleResult();
            return rp;
        } catch (Exception ex) {
            return null;
        }
    }
}
