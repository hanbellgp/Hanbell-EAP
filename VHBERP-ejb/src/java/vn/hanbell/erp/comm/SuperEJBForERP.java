/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hanbell.erp.comm;

import vn.hanbell.erp.ejb.MiscodeBean;
import cn.hanbell.util.SuperEJB;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
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
    @PersistenceContext(unitName = "VBHBERP-ejbPU")
    private EntityManager em_VBHBERP;

    public SuperEJBForERP(Class<T> entityClass) {
        super(entityClass);
    }

    @Override
    public EntityManager getEntityManager() {
        return getEntityManager(getCompany());
    }

    protected EntityManager getEntityManager(String facno) {
        switch (facno) {
            case "V":
                return em_VHBERP;
            case "VB":
                return em_VBHBERP;
            default:
                return em_VHBERP;
        }
    }

    //新增一笔资料,一个表头多个明细
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void persist(T entity, HashMap<SuperEJBForERP, List<?>> detailAdded) {
        try {
            getEntityManager().persist(entity);
            if (detailAdded != null && !detailAdded.isEmpty()) {
                for (Map.Entry<SuperEJBForERP, List<?>> entry : detailAdded.entrySet()) {
                    entry.getKey().setCompany(company);
                    for (Object o : entry.getValue()) {
                        entry.getKey().persist(o);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //更新一笔资料,一个表头多个明细
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void updateForERP(T entity, HashMap<SuperEJBForERP, List<?>> detailAdded, HashMap<SuperEJBForERP, List<?>> detailEdited, HashMap<SuperEJBForERP, List<?>> detailDeleted) {
        try {
            getEntityManager().persist(entity);
            if (detailEdited != null && !detailEdited.isEmpty()) {
                for (Map.Entry<SuperEJBForERP, List<?>> entry : detailEdited.entrySet()) {
                    entry.getKey().setCompany(company);
                    for (Object o : entry.getValue()) {
                        entry.getKey().update(o);
                    }
                }
            }
            if (detailDeleted != null && !detailDeleted.isEmpty()) {
                for (Map.Entry<SuperEJBForERP, List<?>> entry : detailDeleted.entrySet()) {
                    entry.getKey().setCompany(company);
                    for (Object o : entry.getValue()) {
                        entry.getKey().delete(o);
                    }
                }
            }
            if (detailAdded != null && !detailAdded.isEmpty()) {
                for (Map.Entry<SuperEJBForERP, List<?>> entry : detailAdded.entrySet()) {
                    entry.getKey().setCompany(company);
                    for (Object o : entry.getValue()) {
                        entry.getKey().persist(o);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

}
