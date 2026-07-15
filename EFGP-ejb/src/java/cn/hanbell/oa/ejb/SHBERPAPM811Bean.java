/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.SHBERPAPM811;
import cn.hanbell.oa.entity.SHBERPAPM811Detail;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class SHBERPAPM811Bean extends SuperEJBForEFGP<SHBERPAPM811> {

    @EJB
    private SHBERPAPM811DetailBean shberpapm811DetailBean;
    private List<SHBERPAPM811Detail> detailList;

    public SHBERPAPM811Bean() {
        super(SHBERPAPM811.class);
    }

    public List<SHBERPAPM811Detail> getDetailList(String fsn) {
        detailList = shberpapm811DetailBean.findByFSN(fsn);
        return detailList;
    }

    public void setDetailList(List<SHBERPAPM811Detail> detailList) {
        this.detailList = detailList;
    }

    /**
     * C1491 根据请款单号，查询OA流程返回状态
     *
     * @param facno
     * @param apno
     * @param aptyp
     * @return 1进行中，3已结案，0未找到有效记录
     */
    public int findBySrcno(String facno, String apno, String aptyp) {
        String jpql = "SELECT e.currentState FROM SHBERPAPM811 h "
                + "JOIN ProcessInstance e ON e.serialNumber = h.processSerialNumber "
                + "WHERE h.facno = :facno AND h.apno = :apno  AND h.aptyp = :aptyp";
        Query query = this.getEntityManager().createQuery(jpql);
        query.setParameter("facno", facno);
        query.setParameter("apno", apno);
        query.setParameter("aptyp", aptyp);
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
