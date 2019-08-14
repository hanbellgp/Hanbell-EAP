/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.REPTC;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C1491
 */
@Stateless
@LocalBean
public class REPTCBean extends SuperEJBForCRM<REPTC> {

    public REPTCBean() {
        super(REPTC.class);
    }

    public REPTC findByPK(String tc001, String tc002) {
        Query query = getEntityManager().createNamedQuery("REPTC.findByPK");
        query.setParameter("tc001", tc001);
        query.setParameter("tc002", tc002);
        try {
            Object o = query.getSingleResult();
            return (REPTC) o;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     *
     * @param kfno
     * @return CRM 差旅费
     */
    public List getCustomerComplaintExpense(String kfno) {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT 'travelexpense' as type ,'CRM' as sources,TC054 as kfno,(MZ005+MZ006) as fwno,rtrim(MY005) as userno,(MV002) as userna,  ");
        sb.append(" MY004 as deptno,ME002 as deptna,MZ007 as serialno,MZ008 as occurdate,GA003 as expensetype,MZ031 as custom1 ,MZ032 as custom2, ");
        sb.append(" MZ017 as 'expense',MZ020 as remark1,MY025 as oano,MY024 as oadate FROM PORMZ z LEFT OUTER JOIN PORMY y ON z.MZ001=y.MY001  ");
        sb.append(" AND  z.MZ002=y.MY002 LEFT OUTER JOIN CMSME e on e.ME001=y.MY004 LEFT OUTER JOIN CMSMV v on v.MV001=y.MY005 ");
        sb.append(" LEFT OUTER JOIN  CRMGA a ON a.GA002=z.MZ009 LEFT OUTER JOIN  REPTC t ON t.TC001= z.MZ005 AND t.TC002=z.MZ006 ");
        sb.append("  WHERE (GA001='3C') AND TC054='${kfno}' ");
        try {
            String sql = sb.toString().replace("${kfno}", kfno);
            Query query = getEntityManager().createNativeQuery(sql);
            List list = query.getResultList();
            return list;
        } catch (Exception e) {
            return null;
        }
    }

}
