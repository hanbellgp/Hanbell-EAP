/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.mes.ejb;

import cn.hanbell.mes.comm.SuperEJBForMES;
import cn.hanbell.mes.entity.MUser;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class MUserBean extends SuperEJBForMES<MUser> {

    public MUserBean() {
        super(MUser.class);
    }

    public MUser findByUserid(String id) {
        Query query = getEntityManager().createNamedQuery("MUser.findByUserid");
        query.setParameter("userid", id);
        try {
            Object o = query.getSingleResult();
            return (MUser) o;
        } catch (Exception ex) {
            return null;
        }
    }

}
