/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Invbat;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class InvbatBean extends SuperEJBForERP<Invbat> {

    public InvbatBean() {
        super(Invbat.class);
    }

    public Invbat findByPK(String facno, String prono, String itnbr, String wareh, String fixnr, String varnr) {
        Query query = getEntityManager().createNamedQuery("Invbat.findByPK");
        query.setParameter("facno", facno);
        query.setParameter("prono", prono);
        query.setParameter("itnbr", itnbr);
        query.setParameter("wareh", wareh);
        query.setParameter("fixnr", fixnr);
        query.setParameter("varnr", varnr);
        try {
            Object o = query.getSingleResult();
            return (Invbat) o;
        } catch (Exception ex) {
            return null;
        }
    }

    public Invbat findInvbat(Invbat entity) {
        return findByPK(entity.getInvbatPK().getFacno(), entity.getInvbatPK().getProno(), entity.getInvbatPK().getItnbr(), entity.getInvbatPK().getWareh(), entity.getInvbatPK().getFixnr(), entity.getInvbatPK().getVarnr());
    }

    public boolean isGreatThenInvbat(String facno, String prono, String itnbr, String wareh, String fixnr, String varnr, BigDecimal qty) {
        if (fixnr == null) {
            fixnr = "";
        }
        if (varnr == null) {
            varnr = "";
        }
        Invbat e = findByPK(facno, prono, itnbr, wareh, fixnr, varnr);
        if (e == null) {
            return true;
        }
        return (e.getOnhand1().subtract(e.getPreqy1()).compareTo(qty) < 0);
    }

    //增加数量
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void add(Invbat entity) throws RuntimeException {
        try {
            Invbat e = findInvbat(entity);
            if (e == null) {
                persist(entity);
            } else {
                e.setPreqy1(e.getPreqy1().add(entity.getPreqy1()));
                e.setPreqy2(e.getPreqy1().add(entity.getPreqy2()));
                e.setPreqy3(e.getPreqy1().add(entity.getPreqy3()));
                e.setOnhand1(e.getOnhand1().add(entity.getOnhand1()));
                e.setOnhand2(e.getOnhand2().add(entity.getOnhand2()));
                e.setOnhand3(e.getOnhand3().add(entity.getOnhand3()));
                update(e);
            }
        } catch (RuntimeException ex) {
            throw new RuntimeException(ex);
        }
    }

    //增加数量
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void add(List<Invbat> entities) {
        for (Invbat e : entities) {
            add(e);
        }
    }

    //减少数量
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void subtract(Invbat entity) throws RuntimeException {
        try {
            Invbat e = findInvbat(entity);
            if (e == null) {
                throw new RuntimeException(entity.getInvbatPK().getItnbr() + entity.getInvbatPK().getWareh() + "没有库存(invbat)");
            } else {
                e.setPreqy1(e.getPreqy1().subtract(entity.getPreqy1()));
                e.setPreqy2(e.getPreqy1().subtract(entity.getPreqy2()));
                e.setPreqy3(e.getPreqy1().subtract(entity.getPreqy3()));
                e.setOnhand1(e.getOnhand1().subtract(entity.getOnhand1()));
                e.setOnhand2(e.getOnhand2().subtract(entity.getOnhand2()));
                e.setOnhand3(e.getOnhand3().subtract(entity.getOnhand3()));
            }
        } catch (RuntimeException ex) {
            throw new RuntimeException(ex);
        }
    }

    //减少数量
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void subtract(List<Invbat> entities) {
        for (Invbat e : entities) {
            subtract(e);
        }
    }

}
