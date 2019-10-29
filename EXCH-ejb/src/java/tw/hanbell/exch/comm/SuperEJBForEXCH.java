/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.hanbell.exch.comm;

import cn.hanbell.util.SuperEJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author C0160
 * @param <T>
 */
public abstract class SuperEJBForEXCH<T extends Object> extends SuperEJB<T> {

    protected final Logger log4j = LogManager.getLogger("cn.hanbell.eap");

    @PersistenceContext(unitName = "Exchange-THB")
    private EntityManager em;

    public SuperEJBForEXCH(Class<T> entityClass) {
        super(entityClass);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

}
