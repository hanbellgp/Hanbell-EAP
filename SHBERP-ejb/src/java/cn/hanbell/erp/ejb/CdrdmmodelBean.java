/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Cdrdmmodel;
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
public class CdrdmmodelBean extends SuperEJBForERP<Cdrdmmodel> {

    public CdrdmmodelBean() {
        super(Cdrdmmodel.class);
    }

    public List<Cdrdmmodel> findByKind(String kind) {
        Query query = getEntityManager().createNamedQuery("Cdrdmmodel.findByKind");
        query.setParameter("kind", kind);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Cdrdmmodel> findByKind(String kind, int offset, int pageSize) {
        Query query = getEntityManager().createNamedQuery("Cdrdmmodel.findByKind").setFirstResult(offset).setMaxResults(pageSize);
        query.setParameter("kind", kind);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

}
