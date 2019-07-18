/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Cdrivo;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class CdrivoBean extends SuperEJBForERP<Cdrivo> {

    public CdrivoBean() {
        super(Cdrivo.class);
    }

    public List<Cdrivo> findByCusno(String cusno) {
        Query query = getEntityManager().createNamedQuery("Cdrivo.findByCusno");
        query.setParameter("cusno", cusno);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

}
