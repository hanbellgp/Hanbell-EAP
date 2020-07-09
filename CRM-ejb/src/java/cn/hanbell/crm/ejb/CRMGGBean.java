/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.CRMGD;
import cn.hanbell.crm.entity.CRMGG;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class CRMGGBean extends SuperEJBForCRM<CRMGG> {

    @EJB
    private CRMGDBean crmgdBean;

    public CRMGGBean() {
        super(CRMGG.class);
    }

    public CRMGG findByERPCusno(String cusno) {
        Query query = getEntityManager().createNamedQuery("CRMGG.findByERPCusno");
        query.setParameter("cusno", cusno);
        try {
            Object o = query.getSingleResult();
            return (CRMGG) o;
        } catch (Exception ex) {
            return null;
        }
    }

    public CRMGG findByGG001(String gg001) {
        Query query = getEntityManager().createNamedQuery("CRMGG.findById");
        query.setParameter("id", gg001);
        try {
            Object o = query.getSingleResult();
            return (CRMGG) o;
        } catch (Exception ex) {
            return null;
        }
    }

    public List<CRMGD> getDetaiList(String gg001) {
        return crmgdBean.findByCRMGG(gg001);
    }

    public List<Object[]> findCaller(String BQ002_value) {
         //公司简称，来电者,公司电话国码，公司电话区码，行动电话国码，行动电话区码,经销商
        Query query = getEntityManager().createNativeQuery("SELECT GG003,GD005,GD025,GD026,GD027,GD012,GD199,GG001 FROM CRMGG LEFT JOIN CRMGD ON GG001=GD002 where GG043= ?");
        query.setParameter(1, BQ002_value);
        try {
            List<Object[]> list = query.getResultList();
            return list;
        } catch (Exception ex) {
            return null;
        }
    }

    //微信小程序中寻找客户编号
    public List<Object[]> findCustomerCode(String GG003) {
        //公司简称，来电者,公司电话国码，公司电话区码，行动电话国码，行动电话区码,交易币别，公司全名,发票地址一，发票地址二，发票邮政区号，统一编号。经销商
        //GG003,GD005,GD025,GD026,GD027,GD012，GD199,GG084,GG004,GG096,GG097,GG101,GG030,GG132
        String sql = "SELECT top(100)GG001,GG003,GG043,GG003,GD005,GD025,GD026,GD027,GD012,GD199,GG084,GG004,GG096,GG097,GG101,GG030,GG132 FROM CRMGG "
                + "LEFT JOIN CRMGD AS D ON D.GD002=GG001 "
                + "WHERE  (GG025>=GETDATE() OR GG025 IS NULL OR GG025 = '') "
                + "AND (ISNULL(GG136,'N')='N' OR GG136='') AND GG043 IS NOT NULL AND GG043 != ''AND GG003 like ? ";
        try {
            Query query = getEntityManager().createNativeQuery(sql);
            query.setParameter(1, new StringBuffer("%").append(GG003).append("%").toString());
            List<Object[]> list = query.getResultList();
            return list;
        } catch (Exception e) {
            return null;
        }
    }
}
