/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.DUPLD;
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
public class DUPLDBean extends SuperEJBForCRM<DUPLD> {

    public DUPLDBean() {
        super(DUPLD.class);
    }

    public List<DUPLD> findByLD002AndLd003(String ld002, String ld003) {
        StringBuffer sql = new StringBuffer("select * from DUPLD where LD002 = ? and LD003 = ?");
        Query q = getEntityManager().createNativeQuery(sql.toString(),DUPLD.class);
        q.setParameter(1, ld002);
        q.setParameter(2, ld003);
        try {
            return q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
}
