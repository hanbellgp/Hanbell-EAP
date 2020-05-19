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
    
    public List<Map<String,Object>> findCaller(String BQ002_value) {
        Query query = getEntityManager().createNativeQuery("Select GG003,GG020,GG021,GG024,'' AS GD027,'' AS GD012,'' AS GD004 from CRMGG Where GG001 = N'2016120702' AND GG002='2' " +
                        "AND  (GG025>=GETDATE() OR GG025 IS NULL OR GG025 = '') AND (ISNULL(GG136,'N')='N' OR GG136='') " +
                        "UNION ALL SELECT GD005,GD025,GD026,'' AS GD004, " +
                        "(CASE WHEN GD010 <> '' THEN RTRIM(GD007)+ '@'+GD010 ELSE GD007 END) AS  GD007,GD027,GD012 " +
                        "FROM  CRMGD WHERE GD002 ="+"N".concat(BQ002_value));
        try {
           List<Map<String,Object>> list= query.getResultList();
            return list;
        } catch (Exception ex) {
            System.out.print("ex="+ex);
            return null;
        }
    }
}
