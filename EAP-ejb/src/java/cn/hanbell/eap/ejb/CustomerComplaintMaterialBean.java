/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.CustomerComplaintMaterial;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C1879
 */
@Stateless
@LocalBean
public class CustomerComplaintMaterialBean extends SuperEJBForEAP<CustomerComplaintMaterial> {

    public CustomerComplaintMaterialBean() {
        super(CustomerComplaintMaterial.class);
    }

    public List<CustomerComplaintMaterial> findKfno(String kfno) {
        Query query = getEntityManager().createNamedQuery("CustomerComplaintMaterial.findKfno");
        query.setParameter("kfno", kfno);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

}
