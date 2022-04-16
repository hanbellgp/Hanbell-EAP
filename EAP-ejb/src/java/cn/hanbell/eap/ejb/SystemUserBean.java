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
import java.util.stream.Collectors;
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
            job.add("userid", entity.getUserid()).add("name", entity.getUsername());
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
            if (entity.getJob() != null && !"".equals(entity.getJob()) && isUpdateAlias(entity.getJob())) {
                job.add("alias", entity.getJob());
            } else {
                //之前为行政级别，后期修改为专业级别。需把之前的行政级别修改掉
                job.add("alias", "");
            }
            // 职位暂时不更新sda
            // if (entity.getPosition() != null & !"".equals(entity.getPosition())) {
            // job.add("position", entity.getPosition());
            // }
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
                JsonObjectBuilder extattr = Json.createObjectBuilder();
                extattr.add("attrs", attrs);
                job.add("extattr", extattr);
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

    public List<SystemUser> findBySyncWeChatStatusAndDeptno(String deptno) {
        //此方法与findByDeptnoAndSyncWeChatStatus判断的状态不同。获取SyncWeChatStatus为V的数据
        StringBuffer sql = new StringBuffer("SELECT * FROM SystemUser s WHERE s.syncWeChatStatus='V' AND s.deptno ='");
        sql.append(deptno).append("' ORDER BY s.userid");
        try {
            Query query = getEntityManager().createNativeQuery(sql.toString(), SystemUser.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<SystemUser> findByLikeDeptno(String deptno) {
        Query query = getEntityManager().createNamedQuery("SystemUser.findByLikeDeptno");
        query.setParameter("deptno", deptno);
        try {
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public List<SystemUser> findByLikeWorkingAgeBeginDateAndDeptno(String workingAgeBeginDate) {
        //排除了台湾人员
        StringBuffer sql = new StringBuffer("SELECT * FROM SystemUser s WHERE  s.workingAgeBeginDate like '");
        sql.append(workingAgeBeginDate).append("' and deptno NOT LIKE 'A%' AND deptno NOT LIKE 'B%' AND  deptno NOT LIKE 'OU' ");
        Query query = getEntityManager().createNativeQuery(sql.toString(), SystemUser.class);
        try {
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public List<SystemUser> findByLikeBirthdayDateAndDeptno(String birthdayDate) {
        //排除了台湾人员
        StringBuffer sql = new StringBuffer("SELECT * FROM SystemUser s WHERE  s.birthdayDate like '");
        sql.append(birthdayDate).append("' and deptno NOT LIKE 'A%' AND deptno NOT LIKE 'B%' AND  deptno NOT LIKE 'OU'");
        Query query = getEntityManager().createNativeQuery(sql.toString(), SystemUser.class);
        try {
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 查看是否更新别名
     *
     * @param job
     * @return
     */
    public Boolean isUpdateAlias(String job) {
        switch (job) {
            case "執行董事":
                return true;
            case "组长":
                return true;
            case "副總經理":
                return true;
            case "協理":
                return true;
            case "廠長":
                return true;
            case "處長":
                return true;
            case "經理":
                return true;
            case "副理":
                return true;
            case "課長":
                return true;
            case "組長":
                return true;
            case "班長":
                return true;
            case "代組長":
                return true;
            case "代課長":
                return true;
            case "代副理":
                return true;
            case "課長代理":
                return true;
            case "副组长":
                return true;
            case "课长":
                return true;
            case "副课长":
                return true;
            case "代课长":
                return true;
            case "代副课长":
                return true;
            case "专案经理":
                return true;
            case "副经理":
                return true;
            case "经理":
                return true;
            case "副总经理":
                return true;
            case "执行副总经理":
                return true;
            case "总经理":
                return true;
            case "副董事长":
                return true;
            case "董事长":
                return true;
            case "董事長":
                return true;
            case "總經理":
                return true;
        }
        return false;
    }

    /**
     *
     * @param 发送的部门
     * @return 发生异常后需要通知的人员
     */
    public  List<String> tryFindExceptionInformUsers() {
        List<String> userids = new ArrayList();
        try {
            List<SystemUser> list = findByDeptnoAndSyncWeChatStatus("13120");
            SystemUser u = this.findByUserId("C2244");
            if (!list.contains(u)) {
                list.add(u);
            }
            userids = list.stream().map(SystemUser::getUserid).collect(Collectors.toList());
        } catch (Exception e) {
            userids.add("C2082");
            userids.add("C1491");
            userids.add("C1900");
            userids.add("C2244");
        }
        return userids;
    }
}
