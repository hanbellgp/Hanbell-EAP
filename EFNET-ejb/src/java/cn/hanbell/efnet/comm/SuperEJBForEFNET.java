/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.efnet.comm;

import cn.hanbell.util.SuperEJB;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author C0160
 * @param <T>
 */
public abstract class SuperEJBForEFNET<T> extends SuperEJB<T> {

    @PersistenceContext(unitName = "EFNET-ejbPU")
    private EntityManager em;

    public SuperEJBForEFNET(Class<T> entityClass) {
        super(entityClass);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

}
