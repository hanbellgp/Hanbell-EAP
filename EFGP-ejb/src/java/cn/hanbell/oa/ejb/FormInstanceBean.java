/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.FormInstance;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class FormInstanceBean extends SuperEJBForEFGP<FormInstance> {

    public FormInstanceBean() {
        super(FormInstance.class);
    }

    public FormInstance findBySerialNumber(String serialNumber) {
        Query query = getEntityManager().createNamedQuery("FormInstance.findBySerialNumber");
        query.setParameter("serialNumber", serialNumber);
        try {
            Object o = query.getSingleResult();
            return (FormInstance) o;
        } catch (Exception ex) {
            return null;
        }
    }

}
