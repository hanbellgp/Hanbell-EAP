/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.SERAC;
import cn.hanbell.crm.entity.SERCA;
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
public class SERCABean extends SuperEJBForCRM<SERCA> {

    public SERCABean() {
        super(SERCA.class);
    }

    public String findCa009ByCa001(String kfno) {
        String varnr = null;
        Query query = getEntityManager().createNamedQuery("SERCA.findCa009ByCa001");
        query.setParameter("ca001", kfno);
        try {
            List<SERCA> list = query.getResultList();
            if (list != null && !list.isEmpty()) {
                int i = 1;
                StringBuilder sb = new StringBuilder();
                for (SERCA serca : list) {
                    if (i == 1) {
                        sb.append(serca.getCa009());
                    } else {
                        sb.append(",").append(serca.getCa009());
                    }
                    i++;
                }
                varnr = sb.toString();
            }
        } catch (Exception ex) {
        }
        return varnr;

    }

    public String findByAC010AndAC011(String ca010, String ca011) {
        StringBuffer sql = new StringBuffer("Select CA001 from SERCA where CA010='").append(ca010).append("' and CA011='").append(ca011).append("'");
        Query query = getEntityManager().createNativeQuery(sql.toString());
        try {
            List<String> list=query.getResultList();
            return list.get(0);
        } catch (Exception ex) {
            System.out.println("ex="+ex);
            return null;
        }
    }
}
