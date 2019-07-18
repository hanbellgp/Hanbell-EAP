/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crmsys.comm;

import cn.hanbell.util.SuperEJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author C0160
 * @param <T>
 */
public abstract class SuperEJBForCRMSYS<T> extends SuperEJB<T> {

    @PersistenceContext(unitName = "CRMSYS-ejbPU")
    private EntityManager em;

    public SuperEJBForCRMSYS(Class<T> entityClass) {
        super(entityClass);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

}
