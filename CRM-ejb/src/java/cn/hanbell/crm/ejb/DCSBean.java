/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.DCS;
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
public class DCSBean extends SuperEJBForCRM<DCS> {

    public DCSBean() {
        super(DCS.class);
    }

    public List<Object[]> findIncidentCity(String city, String cityname) {
//        StringBuffer s = new StringBuffer("SELECT cityid,cityname from DCS where provinceid = ? and cityname LIKE ?");
//        s =s.append(city).append("' ");
//        if (cityname != null&&!"".equals(cityname)) {
//         s = s.append(" and cityname LIKE '").append(cityname).append("'");
//        }
        String s = "SELECT cityid,cityname from DCS where provinceid = ? and cityname LIKE ?";
        if (cityname == null) {
            cityname = "";
        }
        Query query = getEntityManager().createNativeQuery(s);
        query.setParameter(1, city);
        
        query.setParameter(2, "%"+cityname+"%");
        try {
            List<Object[]> list = query.getResultList();
            return list;
        } catch (Exception e) {
            return null;
        }
    }

}
