/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.hrm.comm;

import com.lightshell.comm.SuperEJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author C0160
 * @param <T>
 */
public abstract class SuperEJBForHRM<T> extends SuperEJB<T> {

    @PersistenceContext(unitName = "HRM-ejbPU")
    private EntityManager em;

    public SuperEJBForHRM(Class<T> entityClass) {
        super(entityClass);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

}
