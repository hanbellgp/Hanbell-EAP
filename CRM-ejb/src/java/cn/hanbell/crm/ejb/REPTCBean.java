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
    public List getCustomerComPlaintCost(String kfno) {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT t.TC054,(LC001+LC002),sum(l.LC007) FROM REPLC l LEFT JOIN REPTC t ON t.TC001=l.LC001  ");
        sb.append("  AND t.TC002=l.LC002 WHERE t.TC054='${kfno}' GROUP BY t.TC054,LC001,LC002 ");
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
