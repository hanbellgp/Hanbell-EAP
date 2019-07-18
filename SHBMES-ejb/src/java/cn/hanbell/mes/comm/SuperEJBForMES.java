/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.mes.comm;

import com.lightshell.comm.SuperEJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrator
 * @param <T>
 */
public abstract class SuperEJBForMES<T> extends SuperEJB<T> {

    @PersistenceContext(unitName = "SHBMES-ejbPU")
    private EntityManager em;

    public SuperEJBForMES(Class<T> entityClass) {
        super(entityClass);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

}
