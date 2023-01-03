/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.Users;
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
public class UsersBean extends SuperEJBForEFGP<Users> {

    public UsersBean() {
        super(Users.class);
    }

    public Users findByOID(String oid) {
        Query query = getEntityManager().createNamedQuery("Users.findByOID");
        query.setParameter("oid", oid);
        try {
            return (Users) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     *
     * @param flag：人员是否在职
     * @param page_index 第几页
     * @param page_size 每页的数量
     * @return 所有行数和页面list 数组
     */
    public Object[] getPageListAndAllCount(String flag, int page_index, int page_size) {
        Object[] arr = new Object[2];
        int first = (page_index - 1) * page_size;
        StringBuilder sb = new StringBuilder();
        sb.append("select distinct Occupant.id as userId,Occupant.userName as userName ,OrganizationUnit.id as unitId, ");
        sb.append(" OrganizationUnit.organizationUnitName  as unitName ,Occupant.mailAddress, ");
        sb.append(" Manager.id as managerId,");
        sb.append("(case when Occupant.leaveDate is  null then 1 else 0 end ) as status ,Functions.isMain ");
        sb.append("from  Users Occupant ");
        sb.append("inner join Functions  on Functions.occupantOID = Occupant.OID ");
        sb.append("inner join OrganizationUnit inner join Organization on OrganizationUnit.organizationOID=Organization.OID  "
                + "on Functions.organizationUnitOID=OrganizationUnit.OID  and OrganizationUnit.validType = '1' ");
        sb.append(" left join Users Manager on Functions.specifiedManagerOID=Manager.OID ");
        if (flag != null && !"".equals(flag)) {
            if ("1".equals(flag)) {
                sb.append(" where Occupant.leaveDate is null");
                sb.append(" and Occupant.id not like '0%' and Occupant.id not like '1%' ");
            } else if ("0".equals(flag)) {
                sb.append(" where Occupant.leaveDate is not null");
            }
        }
        sb.append(" order by Occupant.id ");
        Query query = getEntityManager().createNativeQuery(sb.toString());
        int totalCount = query.getResultList().size();
        List result = query.setFirstResult(first).setMaxResults(page_size).getResultList();
        arr[0] = totalCount;
        arr[1] = result;
        return arr;
    }

    /**
     *
     * @param userId
     * @return 用户单元组织及主管的数组
     */
    public List getOrganizationUnitAndManager(String userId) {
        StringBuilder sb = new StringBuilder();
        sb.append("select distinct Occupant.id as userId,Occupant.userName as userName , OrganizationUnit.id as unitId,");
        sb.append(" OrganizationUnit.organizationUnitName  as unitName ,Manager.id as managerId, isMain ");
        sb.append(" from  Functions");
        sb.append(" inner join Users Occupant  on Functions.occupantOID = Occupant.OID ");
        sb.append(" inner join OrganizationUnit inner join Organization on OrganizationUnit.organizationOID=Organization.OID  on Functions.organizationUnitOID=OrganizationUnit.OID");
        sb.append(" inner join FunctionDefinition on Functions.definitionOID=FunctionDefinition.OID ");
        sb.append(" left join FunctionLevel on Functions.approvalLevelOID=FunctionLevel.OID ");
        sb.append(" left join Users Manager on Functions.specifiedManagerOID=Manager.OID ");
        sb.append(" where Occupant.id = '").append(userId).append("' AND Occupant.leaveDate is null ");
        sb.append(" order by  isMain DESC ");
        Query query = getEntityManager().createNativeQuery(sb.toString());
        return query.getResultList();
    }

    /**
     * 根据userid 和deptno 判断部门是否正确，
     *
     * @param userId
     * @param deptno
     * @return 正确返回当前部门，不正确返回用户主部门 或者空字符
     */
    public String checkDeptno(String userId, String deptno) {
        List objList = getOrganizationUnitAndManager(userId);
        if (null == objList || objList.isEmpty()) {
            throw new NullPointerException(userId + "账号无法正确找到OA中组织");
        } else {
            for (int i = 0; i < objList.size(); i++) {
                Object[] row = (Object[]) objList.get(i);
                if (null != row[2] && row[2].toString().equals(deptno)) {
                    return deptno;
                }
            }
            Object[] row = (Object[]) objList.get(0);
            return row[2] != null ? row[2].toString() : "";
        }
    }
}
