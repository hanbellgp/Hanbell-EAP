/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.exch.ejb;

import cn.hanbell.erp.comm.SuperSyncBean;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class ExchangeSHBBean extends SuperSyncBean {

    @PersistenceContext(unitName = "Exchange-SHB")
    private EntityManager em;

    public ExchangeSHBBean() {

    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    //新增资料,一个表头多个明细
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public <T> void persist(Object entity, List<T> detailAdded) {
        try {
            getEntityManager().persist(entity);
            if (detailAdded != null && !detailAdded.isEmpty()) {
                for (Object d : detailAdded) {
                    getEntityManager().persist(d);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
