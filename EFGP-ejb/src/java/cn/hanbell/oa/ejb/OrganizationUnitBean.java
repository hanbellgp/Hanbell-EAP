/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.OrganizationUnit;
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
public class OrganizationUnitBean extends SuperEJBForEFGP<OrganizationUnit> {

    public OrganizationUnitBean() {
        super(OrganizationUnit.class);
    }

    /**
     *
     * @param flag：部门是否有效
     * @param page_index 第几页
     * @param page_size 每页的数量
     * @return 所有行数和页面list 数组
     */
    public Object[] getPageListAndAllCount(String flag, int page_index, int page_size) {
        Object[] arr = new Object[2];
        int first = (page_index - 1) * page_size;
        StringBuilder sb = new StringBuilder();
        sb.append("select d.id,d.organizationUnitName,u.id,d1.id,d.validType ");
        sb.append("from OrganizationUnit d ");
        sb.append("left join Users u on u.OID = d.managerOID ");
        sb.append("left join OrganizationUnit d1 on d1.OID = d.superUnitOID");
        if (flag != null && !"".equals(flag)) {
            sb.append(" where d.validType = ").append(flag);
        }
        sb.append(" order by d.id");
        Query query = getEntityManager().createNativeQuery(sb.toString());
        int totalCount = query.getResultList().size();
        List result = query.setFirstResult(first).setMaxResults(page_size).getResultList();
        arr[0] = totalCount;
        arr[1] = result;
        return arr;
    }

}
