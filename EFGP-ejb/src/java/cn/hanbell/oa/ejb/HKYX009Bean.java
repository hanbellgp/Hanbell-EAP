/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKYX009;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class HKYX009Bean extends SuperEJBForEFGP<HKYX009> {

    public HKYX009Bean() {
        super(HKYX009.class);
    }

    //根据报价单号查询表单
    public HKYX009 findByQuono(String quono) {
        Query query = this.getEntityManager().createNamedQuery("HKYX009.findByQuono");
        query.setParameter("quono", quono);
        try {
            return (HKYX009) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * C1491
     * 根据报价单号，查询OA流程返回状态
     * @param facno
     * @param quono
     * @return 1进行中，3已结案，0未找到有效记录
     */
    public int findBySrcno(String facno, String quono) {
        String jpql = "SELECT e.currentState FROM HKYX009 h "
                + "JOIN ProcessInstance e ON e.serialNumber = h.processSerialNumber "
                + "WHERE h.facno = :facno AND h.quono = :quono";

        Query query = this.getEntityManager().createQuery(jpql);
        query.setParameter("facno", facno);
        query.setParameter("quono", quono);
        List<Integer> stateList = query.getResultList();
        if (stateList.contains(1)) {
            return 1;
        } else if (stateList.contains(3)) {
            return 3;
        } else {
            return 0;
        }
    }
}
