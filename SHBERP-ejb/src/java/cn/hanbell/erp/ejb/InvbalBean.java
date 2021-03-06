/*
 * To change this license header, choose License Headers in Project Properties. To change this template file, choose
 * Tools | Templates and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Invbal;
import cn.hanbell.erp.entity.Invmas;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class InvbalBean extends SuperEJBForERP<Invbal> {

    @EJB
    private InvmasBean invmasBean;

    public InvbalBean() {
        super(Invbal.class);
    }

    public List<Invbal> findByItnbrAndFilters(String itnbr, Map<String, Object> filters, Boolean fuzzy) {

        StringBuilder sb = new StringBuilder();
        if (fuzzy) {
            sb.append(
                "SELECT i FROM Invbal i WHERE i.invbalPK.itnbr like :itnbr AND SUBSTRING(i.invbalPK.wareh,1,1)<>'J' AND ((i.onhand1 - i.preqy1) > 0 OR (i.onhand2 - i.preqy2) > 0) ");
        } else {
            sb.append(
                "SELECT i FROM Invbal i WHERE i.invbalPK.itnbr = :itnbr AND SUBSTRING(i.invbalPK.wareh,1,1)<>'J' AND ((i.onhand1 - i.preqy1) > 0 OR (i.onhand2 - i.preqy2) > 0) ");
        }
        boolean flag;
        if (filters != null) {
            for (Map.Entry<String, Object> e : filters.entrySet()) {
                flag = true;
                try {
                    Invbal.class.getDeclaredField(e.getKey());
                } catch (NoSuchFieldException | SecurityException ex) {
                    flag = false;
                }
                if (flag) {
                    sb.append(" AND i.").append(e.getKey()).append(" = :").append(e.getKey());
                } else {
                    sb.append(" AND i.invbalPK.").append(e.getKey()).append(" = :").append(e.getKey());
                }
            }
        }
        // 生成SQL
        Query query = getEntityManager().createQuery(sb.toString());
        // 参数赋值
        query.setParameter("itnbr", itnbr);
        if (filters != null) {
            for (Map.Entry<String, Object> e : filters.entrySet()) {
                query.setParameter(e.getKey(), e.getValue());
            }
        }
        return query.getResultList();

    }

    public Invbal findByItnbrAndWareh(String itnbr, String wareh) {
        Query query = getEntityManager().createNamedQuery("Invbal.findByItnbrAndWareh");
        query.setParameter("itnbr", itnbr);
        query.setParameter("wareh", wareh);
        try {
            Object o = query.getSingleResult();
            return (Invbal)o;
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Invbal> findByItnbr(String facno, String itnbr) {
        String jpql =
            "SELECT i FROM Invbal i WHERE i.invbalPK.itnbr = :itnbr AND SUBSTRING(i.invbalPK.wareh,1,1)<>'J' AND ((i.onhand1 - i.preqy1) > 0 OR (i.onhand2 - i.preqy2) > 0) ";
        Query query = getEntityManager().createQuery(jpql);
        query.setParameter("itnbr", itnbr);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Invbal> findByItnbr(String facno, List<String> itnbr) {
        String jpql =
            "SELECT i FROM Invbal i WHERE i.invbalPK.itnbr IN :itnbr AND SUBSTRING(i.invbalPK.wareh,1,1)<>'J' AND ((i.onhand1 - i.preqy1) > 0 OR (i.onhand2 - i.preqy2) > 0) ";
        Query query = getEntityManager().createQuery(jpql);
        query.setParameter("itnbr", itnbr);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Invbal> findByItnbrAndWareh(String facno, String itnbr, List<String> wareh) {
        String jpql =
            "SELECT i FROM Invbal i WHERE i.invbalPK.itnbr = :itnbr  AND i.invbalPK.wareh IN :wareh AND ((i.onhand1 - i.preqy1) > 0 OR (i.onhand2 - i.preqy2) > 0) ";
        Query query = getEntityManager().createQuery(jpql);
        query.setParameter("itnbr", itnbr);
        query.setParameter("wareh", wareh);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Invbal> findByItnbrAndWareh(String facno, List<String> itnbr, List<String> wareh) {
        String jpql =
            "SELECT i FROM Invbal i WHERE i.invbalPK.itnbr IN :itnbr  AND i.invbalPK.wareh IN :wareh AND ((i.onhand1 - i.preqy1) > 0 OR (i.onhand2 - i.preqy2) > 0) ";
        Query query = getEntityManager().createQuery(jpql);
        query.setParameter("itnbr", itnbr);
        query.setParameter("wareh", wareh);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public Invbal findByPK(String facno, String prono, String itnbr, String wareh) {
        Query query = getEntityManager().createNamedQuery("Invbal.findByPK");
        query.setParameter("facno", facno);
        query.setParameter("prono", prono);
        query.setParameter("itnbr", itnbr);
        query.setParameter("wareh", wareh);
        try {
            Object o = query.getSingleResult();
            return (Invbal)o;
        } catch (Exception ex) {
            return null;
        }
    }

    public Invbal findInvbal(Invbal entity) {
        return findByPK(entity.getInvbalPK().getFacno(), entity.getInvbalPK().getProno(),
            entity.getInvbalPK().getItnbr(), entity.getInvbalPK().getWareh());
    }

    public BigDecimal getInvbalQuantity(String facno, String itnbr) {
        BigDecimal qty = BigDecimal.ZERO;
        BigDecimal qty2 = BigDecimal.ZERO;
        List<Invbal> invbalList = findByItnbr(facno, itnbr);
        if (invbalList != null && !invbalList.isEmpty()) {
            for (Invbal e : invbalList) {
                qty = qty.add(e.getOnhand1().subtract(e.getPreqy1()));
                qty2 = qty2.add(e.getOnhand2().subtract(e.getPreqy2()));
            }
        }
        invmasBean.setCompany(facno);
        Invmas invmas = invmasBean.findByItnbr(itnbr);
        if (invmas != null && "4".equals(invmas.getJudco().substring(0, 1))) {
            if (qty.compareTo(BigDecimal.ZERO) == 0) {
                return qty2;
            }
        }
        return qty;
    }

    public BigDecimal getInvbalQuantity(String facno, List<String> itnbr) {
        BigDecimal qty = BigDecimal.ZERO;
        List<Invbal> invbalList = findByItnbr(facno, itnbr);
        if (invbalList != null && !invbalList.isEmpty()) {
            for (Invbal e : invbalList) {
                qty = qty.add(e.getOnhand1().subtract(e.getPreqy1()));
            }
        }
        return qty;
    }

    public BigDecimal getInvbalQuantity(String facno, String itnbr, List<String> wareh) {
        BigDecimal qty = BigDecimal.ZERO;
        BigDecimal qty2 = BigDecimal.ZERO;
        List<Invbal> invbalList;
        if (wareh == null || wareh.isEmpty()) {
            invbalList = findByItnbr(facno, itnbr);
        } else {
            invbalList = findByItnbrAndWareh(facno, itnbr, wareh);
        }
        if (invbalList != null && !invbalList.isEmpty()) {
            for (Invbal e : invbalList) {
                qty = qty.add(e.getOnhand1().subtract(e.getPreqy1()));
                qty2 = qty2.add(e.getOnhand2().subtract(e.getPreqy2()));
            }
        }
        invmasBean.setCompany(facno);
        Invmas invmas = invmasBean.findByItnbr(itnbr);
        if (invmas != null && "4".equals(invmas.getJudco().substring(0, 1))) {
            if (qty.compareTo(BigDecimal.ZERO) == 0) {
                return qty2;
            }
        }
        return qty;
    }

    public BigDecimal getInvbalQuantity(String facno, List<String> itnbr, List<String> wareh) {
        BigDecimal qty = BigDecimal.ZERO;
        List<Invbal> invbalList = findByItnbrAndWareh(facno, itnbr, wareh);
        if (invbalList != null && !invbalList.isEmpty()) {
            for (Invbal e : invbalList) {
                qty = qty.add(e.getOnhand1().subtract(e.getPreqy1()));
            }
        }
        return qty;
    }

    public Boolean isGreatThenInvbal(String facno, String prono, String itnbr, String wareh, BigDecimal qty) {
        Invbal e = findByPK(facno, prono, itnbr, wareh);
        if (e == null) {
            return true;
        }
        return (e.getOnhand1().subtract(e.getPreqy1()).compareTo(qty) < 0);
    }

    // 增加数量
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void add(Invbal entity) throws RuntimeException {
        try {
            Invbal e = findInvbal(entity);
            if (e == null) {
                persist(entity);
            } else {
                e.setPreqy1(e.getPreqy1().add(entity.getPreqy1()));
                e.setPreqy2(e.getPreqy2().add(entity.getPreqy2()));
                e.setPreqy3(e.getPreqy3().add(entity.getPreqy3()));
                e.setOnhand1(e.getOnhand1().add(entity.getOnhand1()));
                e.setOnhand2(e.getOnhand2().add(entity.getOnhand2()));
                e.setOnhand3(e.getOnhand3().add(entity.getOnhand3()));
                update(e);
            }
        } catch (RuntimeException ex) {
            throw new RuntimeException(ex);
        }
    }

    // 增加数量
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void add(List<Invbal> entities) {
        for (Invbal e : entities) {
            add(e);
        }
    }

    // 减少数量
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void subtract(Invbal entity) throws RuntimeException {
        try {
            Invbal e = findInvbal(entity);
            if (e == null) {
                throw new RuntimeException(
                    entity.getInvbalPK().getItnbr() + entity.getInvbalPK().getWareh() + "没有库存(invbal)");
            } else {
                e.setPreqy1(e.getPreqy1().subtract(entity.getPreqy1()));
                e.setPreqy2(e.getPreqy2().subtract(entity.getPreqy2()));
                e.setPreqy3(e.getPreqy3().subtract(entity.getPreqy3()));
                e.setOnhand1(e.getOnhand1().subtract(entity.getOnhand1()));
                e.setOnhand2(e.getOnhand2().subtract(entity.getOnhand2()));
                e.setOnhand3(e.getOnhand3().subtract(entity.getOnhand3()));
                update(e);
            }
        } catch (RuntimeException ex) {
            throw new RuntimeException(ex);
        }
    }

    // 减少数量
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void subtract(List<Invbal> entities) {
        for (Invbal e : entities) {
            subtract(e);
        }
    }

}
