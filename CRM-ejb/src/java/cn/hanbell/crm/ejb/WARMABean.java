/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.Pormy;
import cn.hanbell.crm.entity.WARMA;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author C2082
 */
@Stateless
@LocalBean
public class WARMABean extends SuperEJBForCRM<WARMA> {

    public WARMABean() {
        super(WARMA.class);
    }

    public List<Object[]> findProductType(String MA003) {
        String s2 = "SELECT RTRIM(MA002) AS MA002,MA003 FROM WARMA WHERE MA001 = 2 AND  MA003 like ?";
        try {
            Query query = getEntityManager().createNativeQuery(s2);
            if(MA003==null){
                MA003="";
            }
            query.setParameter(1, new StringBuffer("%").append(MA003).append("%").toString());
            List<Object[]> list = query.getResultList();
            return list;
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Object[]> findProductQuality(String MB002) {
        StringBuffer s2 = new StringBuffer("SELECT top 100 MB001,MB002,MB003 FROM  WARMB INNER JOIN  WARMA ON (MA001 = '1' AND MA002 = MB008 AND MA006 <> 'Y') OR (MA001 = '2' AND MA002 =MB009 AND MA006 <> 'Y') WHERE MB010 <> 'Y' AND MA001 = (SELECT AA001 FROM SERAA) ");;
        if (MB002 != null && !"".equals(MB002) && !"undefined".equals(MB002)) {
            s2 = s2.append("AND  MB002 like ").append("'%" + MB002 + "%'");
        }
        Query query = getEntityManager().createNativeQuery(s2.toString());
        try {
            List<Object[]> list = query.getResultList();
            return list;
        } catch (Exception ex) {
            return null;
        }

    }
}
