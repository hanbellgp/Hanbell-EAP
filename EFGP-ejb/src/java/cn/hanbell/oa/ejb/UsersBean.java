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
        sb.append("left join Functions  on Functions.occupantOID = Occupant.OID ");
        sb.append("left join OrganizationUnit inner join Organization on OrganizationUnit.organizationOID=Organization.OID  "
                + "on Functions.organizationUnitOID=OrganizationUnit.OID ");
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

}
