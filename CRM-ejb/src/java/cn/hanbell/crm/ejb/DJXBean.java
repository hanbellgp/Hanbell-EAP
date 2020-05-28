/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.DFWEL;
import cn.hanbell.crm.entity.DJX;
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
public class DJXBean extends SuperEJBForCRM<DJX> {

    public DJXBean() {
        super(DJX.class);
    }

    public List<Object[]> findByJX003(String JX003,String JX002) {
        StringBuffer sql=new StringBuffer("SELECT JX001,JX002 FROM DJX WHERE JX003 = ? ");
        if(JX002!=null&&!"".equals(JX002)){
            sql=sql.append("AND JX002 like").append("'%"+JX002+"%'");
        }
        Query query = getEntityManager().createNativeQuery(sql.toString());
        query.setParameter(1, JX003);
        try {
            return (List<Object[]>) query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }
}
