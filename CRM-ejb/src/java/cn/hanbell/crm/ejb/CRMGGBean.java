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
        String sql="SELECT  TOP 50 * FROM ( SELECT * FROM (Select '公司電話資訊' AS AA,GG003,GG020,GG021,GG024,'' AS GD027,'' AS GD012,GG064,GG026,GG027,'' AS GD009,'' AS GD004, "
                + "CUSTOMER,GG103,GG078,PRODUCT,REGION,DEALER,CREATOR,USR_GROUP,GG001 "
                + "from CRMGG CRMGG "
                + "Where GG001 =? AND GG002='2' "
                + "AND  (GG025>=GETDATE() OR GG025 IS NULL OR GG025 = '') "
                + "AND (ISNULL(GG136,'N')='N' OR GG136='') "
                + "UNION ALL "
                + "SELECT '連絡人電話資訊' AS AA,GD005,GD025,GD026, "
                + "(CASE WHEN GD010 <> '' THEN RTRIM(GD007)+ '@'+GD010 ELSE GD007 END) AS  GD007, "
                + "GD027,GD012,GD028,GD013,GD014,GD009,GD004,CUSTOMER,'' AS GG103,'' AS GG078 "
                + ",PRODUCT,REGION,DEALER,CREATOR,USR_GROUP,GD002 "
                + "FROM CRMGD CRMGD "
                + "WHERE GD002 = ? ) AS CRMGG WHERE 1=1 ) AS tData";
        Query query = getEntityManager().createNativeQuery(sql);
        query.setParameter(1, BQ002_value);
        query.setParameter(2, BQ002_value);
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
        String sql = "SELECT top(100)GG001,GG003,GG001,GG003,GD005,GD025,GD026,GD027,GD012,GD199,GG084,GG004,GG096,GG097,GG101,GG030,GG132 FROM CRMGG "
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
