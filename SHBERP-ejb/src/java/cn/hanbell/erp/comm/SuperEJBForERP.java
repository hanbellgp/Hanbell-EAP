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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

    @PersistenceContext(unitName = "PU_gzerp")
    private EntityManager em_gzerp;

    @PersistenceContext(unitName = "PU_jnerp")
    private EntityManager em_jnerp;

    @PersistenceContext(unitName = "PU_njerp")
    private EntityManager em_njerp;

    @PersistenceContext(unitName = "PU_cqerp")
    private EntityManager em_cqerp;

    @PersistenceContext(unitName = "PU_comererp")
    private EntityManager em_comererp;

    @PersistenceContext(unitName = "PU_zjcomererp")
    private EntityManager em_zjcomererp;

    @PersistenceContext(unitName = "PU_plpserp")
    private EntityManager em_plpserp;

    @PersistenceContext(unitName = "PU_huosaierp")
    private EntityManager em_huosaierp;

    @PersistenceContext(unitName = "PU_hansonerp")
    private EntityManager em_hansonerp;

    @PersistenceContext(unitName = "PU_hanyoungerp")
    private EntityManager em_hanyoungerp;

    @PersistenceContext(unitName = "PU_qtcerp")
    private EntityManager em_qtcerp;

    //@PersistenceContext(unitName = "PU_sderp")
    private EntityManager em_sderp;

    @PersistenceContext(unitName = "PU_hkerp")
    private EntityManager em_hkerp;

    @PersistenceContext(unitName = "PU_zkerp")
    private EntityManager em_zkerp;

    @PersistenceContext(unitName = "PU_chuxiongerp")
    private EntityManager em_chuxiongerp;

    @PersistenceContext(unitName = "PU_yinchuanerp")
    private EntityManager em_yinchuanerp;

    //@PersistenceContext(unitName = "PU_thberp")
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
            // return em_thberp;
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
            case "K":
                return em_comererp;
            case "E":
                return em_zjcomererp;
            case "H":
                return em_hansonerp;
            case "Y":
                return em_hanyoungerp;
            case "L":
                return em_zkerp;
            case "Q":
                return em_qtcerp;
            case "W":
                //  return em_sderp;
                return null;
            case "X":
                return em_hkerp;
            case "F":
                return em_chuxiongerp;
            case "C5":
                return em_yinchuanerp;
            case "XB":
                return em_plpserp;
            case "CH":
                return em_huosaierp;
            default:
                return em_shberp;
        }
    }

    // 优化抛转时件号相关字符问题
    public String filterString(String s) {
        if (s != null && !s.trim().equals("")) {
            String returnStr = s;
            try {
                //String regEx = "[\\s`!！@#￥$%^……&（()）\\+【\\[\\]】｛{}｝\\|、\\\\；;：:‘'“”\"，,《<。.》>、/？?]";
                String regEx = "[\\s`&²³\\t\\r\\n ]";
                Pattern p = Pattern.compile(regEx);
                Matcher m = p.matcher(returnStr);
                returnStr = m.replaceAll(" ");
                //returnStr = removeNonAscii(returnStr);
            } catch (Exception ex) {
                log4j.error(ex);
            }
            return returnStr;
        }
        return s;
    }

    //去除非ascii码字符
    public String removeNonAscii(String str) {
        return str.replaceAll("[^\\x00-\\x7F]", "");
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
