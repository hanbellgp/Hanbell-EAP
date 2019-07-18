/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.comm;

import cn.hanbell.erp.ejb.MiscodeBean;
import cn.hanbell.util.SuperEJB;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
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

    protected String company = "C";

    @PersistenceContext(unitName = "PU_shberp")
    private EntityManager em_shberp;

    @PersistenceContext(unitName = "PU_cqerp")
    private EntityManager em_cqerp;

    @PersistenceContext(unitName = "PU_gzerp")
    private EntityManager em_gzerp;

    @PersistenceContext(unitName = "PU_jnerp")
    private EntityManager em_jnerp;

    @PersistenceContext(unitName = "PU_njerp")
    private EntityManager em_njerp;

    @PersistenceContext(unitName = "PU_hansonerp")
    private EntityManager em_hansonerp;

    @PersistenceContext(unitName = "PU_hanyangerp")
    private EntityManager em_hanyangerp;

    @PersistenceContext(unitName = "PU_comererp")
    private EntityManager em_comererp;

    @PersistenceContext(unitName = "PU_qtcerp")
    private EntityManager em_qtcerp;

    @PersistenceContext(unitName = "PU_sderp")
    private EntityManager em_sderp;

    @PersistenceContext(unitName = "PU_hkerp")
    private EntityManager em_hkerp;

    @PersistenceContext(unitName = "PU_thberp")
    private EntityManager em_thberp;

    public SuperEJBForERP(Class<T> entityClass) {
        super(entityClass);
    }

    @Override
    public EntityManager getEntityManager() {
        return getEntityManager(getCompany());
    }

    public Boolean initByOAPSN(String psn) {
        return true;
    }

    public Boolean updateByOAPSN(String psn) {
        return true;
    }

    public Boolean deleteByOAPSN(String psn) {
        return true;
    }

    //新增一笔资料,一个表头多个明细
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void persist(T entity, HashMap<SuperEJBForERP, List<?>> detailAdded) {
        try {
            getEntityManager().persist(entity);
            if (detailAdded != null && !detailAdded.isEmpty()) {
                for (Entry<SuperEJBForERP, List<?>> entry : detailAdded.entrySet()) {
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
                for (Entry<SuperEJBForERP, List<?>> entry : detailEdited.entrySet()) {
                    entry.getKey().setCompany(company);
                    for (Object o : entry.getValue()) {
                        entry.getKey().update(o);
                    }
                }
            }
            if (detailDeleted != null && !detailDeleted.isEmpty()) {
                for (Entry<SuperEJBForERP, List<?>> entry : detailDeleted.entrySet()) {
                    entry.getKey().setCompany(company);
                    for (Object o : entry.getValue()) {
                        entry.getKey().delete(o);
                    }
                }
            }
            if (detailAdded != null && !detailAdded.isEmpty()) {
                for (Entry<SuperEJBForERP, List<?>> entry : detailAdded.entrySet()) {
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

    protected EntityManager getEntityManager(String facno) {
        switch (facno) {
            case "A":
                return em_thberp;
            case "C":
                return em_shberp;
            case "G":
                return em_gzerp;
            case "J":
                return em_jnerp;
            case "N":
                return em_njerp;
            case "C4":
                return em_cqerp;
            case "H":
                return em_hansonerp;
            case "K":
                return em_comererp;
            case "Q":
                return em_qtcerp;
            case "W":
                return em_sderp;
            case "X":
                return em_hkerp;
            case "Y":
                return em_hanyangerp;
            default:
                return em_shberp;
        }
    }

    /**
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(String company) {
        this.company = company;
    }

}
