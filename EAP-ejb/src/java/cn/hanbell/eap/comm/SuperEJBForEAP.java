/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.comm;



import com.lightshell.comm.SuperEJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author C0160
 * @param <T>
 */
public abstract class SuperEJBForEAP<T> extends SuperEJB<T> {

    @PersistenceContext(unitName = "EAP-ejbPU")
    private EntityManager em;

    public SuperEJBForEAP(Class<T> entityClass) {
        super(entityClass);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

}
