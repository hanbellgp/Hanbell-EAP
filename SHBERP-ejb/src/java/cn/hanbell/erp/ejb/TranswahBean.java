/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Transwah;
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
public class TranswahBean extends SuperEJBForERP<Transwah> {

    public TranswahBean() {
        super(Transwah.class);
    }

    public List<Transwah> findByCusno(String cusno) {
        Query query = getEntityManager().createNamedQuery("Transwah.findByCusno");
        query.setParameter("cusno", cusno);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

}
