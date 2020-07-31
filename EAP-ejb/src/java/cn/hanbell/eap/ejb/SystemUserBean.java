/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.SystemUser;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
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

    @Override
    public JsonObjectBuilder createJsonObjectBuilder(SystemUser entity) {
        JsonObjectBuilder job = Json.createObjectBuilder();
        if (entity != null) {
            job.add("userid", entity.getUserid())
                    .add("name", entity.getUsername());
            if (entity.getPhone() != null) {
                job.add("mobile", entity.getPhone());
            }
            if (entity.getDept() != null) {
                List<Integer> depts = new ArrayList<>();
                depts.add(entity.getDept().getId());
                job.add("department", Json.createArrayBuilder(depts));
            }
            if (entity.getEmail() != null && !"".equals(entity.getEmail())) {
                job.add("email", entity.getEmail());
            }
            if (entity.getTel() != null && !"".equals(entity.getTel())) {
                job.add("telephone", entity.getTel());
            }
            //职位暂时不更新
//            if (entity.getPosition() != null & !"".equals(entity.getPosition())) {
//                job.add("position", entity.getPosition());
//            }
            if (entity.getJob() != null && !"".equals(entity.getJob())) {
            job.add("to_invite", true);
            JsonObjectBuilder textValue = Json.createObjectBuilder();
            textValue.add("value", entity.getJob());
            JsonObjectBuilder attr = Json.createObjectBuilder();
            attr.add("type", 0);
            attr.add("name", "岗位");
            attr.add("text", textValue);
            JsonArrayBuilder attrs = Json.createArrayBuilder();
            attrs.add(attr);
            JsonObjectBuilder attrsBean = Json.createObjectBuilder();
            attrsBean.add("attrs", attrs);
            job.add("extattr", attrsBean);
            }
        }
        return job;
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

    public List<SystemUser> findByManagerIdAndOnJob(String managerId) {
        Query query = getEntityManager().createNamedQuery("SystemUser.findByManagerIdAndOnJob");
        query.setParameter("managerId", managerId);
        try {
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public List<SystemUser> findByDeptnoAndSyncWeChatStatus(String deptno) {
        Query query = getEntityManager().createNamedQuery("SystemUser.findByDeptnoAndSyncWeChatStatus");
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

    public List<SystemUser> findByUserIdOrName(String str) {
        Query query = getEntityManager().createNamedQuery("SystemUser.findByUserIdOrName");
        query.setParameter("userid", "%" + str + "%");
        query.setParameter("username", "%" + str + "%");
        try {
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
}
