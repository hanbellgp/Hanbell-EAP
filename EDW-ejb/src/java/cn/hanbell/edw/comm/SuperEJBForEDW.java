/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.edw.comm;

import com.lightshell.comm.SuperEJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author C1491
 */
public abstract class SuperEJBForEDW<T> extends SuperEJB<T> {

    @PersistenceContext(unitName = "EDW-ejbPU")
    private EntityManager em;

    public SuperEJBForEDW(Class<T> entityClass) {
        super(entityClass);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}
