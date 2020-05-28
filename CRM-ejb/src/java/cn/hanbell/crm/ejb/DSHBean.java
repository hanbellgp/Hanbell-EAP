/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.DSH;
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
public class DSHBean extends SuperEJBForCRM<DSH> {

    public DSHBean() {
        super(DSH.class);
    }

    public List<Object[]> findIncidentArea(String provincename) {
        StringBuffer s = new StringBuffer("SELECT provinceid,provincename from DSH ");
        if (provincename != null&&!"".equals(provincename)) {
            s = s.append("where provincename like ").append("'%" + provincename + "%'");
        }
        Query query = getEntityManager().createNativeQuery(s.toString());
        try {
            List<Object[]> list = query.getResultList();
            return list;
        } catch (Exception e) {
            return null;
        }
    }
}
