/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hanbell.erp.comm;

import vn.hanbell.erp.ejb.MiscodeBean;
import cn.hanbell.util.SuperEJB;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author C0160
 * @param <T>
 */
public abstract class SuperEJBForERP<T extends Object> extends SuperEJB<T> {

    protected final Logger log4j = LogManager.getLogger("cn.hanbell.eap");

    @EJB
    public MiscodeBean miscodeBean;

    protected String company = "V";

    @PersistenceContext(unitName = "VHBERP-ejbPU")
    private EntityManager em_VHBERP;

    public SuperEJBForERP(Class<T> entityClass) {
        super(entityClass);
    }

    @Override
    public EntityManager getEntityManager() {
        return em_VHBERP;
    }

}
