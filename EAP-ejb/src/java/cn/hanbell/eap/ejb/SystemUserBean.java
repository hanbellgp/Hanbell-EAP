/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.SystemUser;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
public class SystemUserBean extends SuperEJBForEAP<SystemUser> {

    public SystemUserBean() {
        super(SystemUser.class);
    }

    public List<SystemUser> findByDeptno(String deptno) {
        Query query = getEntityManager().createNamedQuery("SystemUser.findByDeptno");
        query.setParameter("deptno", deptno);
        try {
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public List<SystemUser> findByDeptnoAndOnJob(String deptno) {
        Query query = getEntityManager().createNamedQuery("SystemUser.findByDeptnoAndOnJob");
        query.setParameter("deptno", deptno);
        try {
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public SystemUser findByUserId(String userid) {
        Query query = getEntityManager().createNamedQuery("SystemUser.findByUserId");
        query.setParameter("userid", userid);
        try {
            return (SystemUser) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public SystemUser findByUserIdAndPwd(String userid, String pwd) {
        Query query = getEntityManager().createNamedQuery("SystemUser.findByUserIdAndPwd");
        query.setParameter("userid", userid);
        query.setParameter("pwd", pwd);
        query.setParameter("email", userid);
        try {
            return (SystemUser) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
