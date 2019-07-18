/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.SystemRoleDetail;
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
public class SystemRoleDetailBean extends SuperEJBForEAP<SystemRoleDetail> {

    public SystemRoleDetailBean() {
        super(SystemRoleDetail.class);
    }

    public List<SystemRoleDetail> findByUserId(int id) {
        Query query = getEntityManager().createNamedQuery("SystemRoleDetail.findByUserId");
        query.setParameter("userid", id);
        return query.getResultList();
    }

}
