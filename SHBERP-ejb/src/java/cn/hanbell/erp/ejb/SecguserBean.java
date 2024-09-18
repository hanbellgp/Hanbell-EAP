/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Secguser;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class SecguserBean extends SuperEJBForERP<Secguser> {

    public SecguserBean() {
        super(Secguser.class);
    }

    public List<Secguser> findByGroupno(String groupno) {
        Query query = getEntityManager().createNamedQuery("Secguser.findByGroupno");
        query.setParameter("groupno", groupno);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public Secguser findByPK(String groupno, String gtype, String userno) {
        Query query = getEntityManager().createNamedQuery("Secguser.findByPK");
        query.setParameter("groupno", groupno);
        query.setParameter("gtype", gtype);
        query.setParameter("userno", userno);
        try {
            Object o = query.getSingleResult();
            return (Secguser) o;
        } catch (Exception ex) {
            return null;
        }
    }

    //根据员工工号获取群组
    public List<Secguser> findByUserno(String userno) {
        Query query = getEntityManager().createNamedQuery("Secguser.findByUserno");
        query.setParameter("userno", userno);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * 获取员工剩余年休假天数
     *
     * @param employeeid 工号
     * @return
     * @throws java.lang.Exception
     */
    public BigDecimal getLeftYearDays(String employeeid) throws Exception {
        StringBuffer sql = new StringBuffer();
        sql.append("select leftyeardays from test.dbo.nianjia where employeeid='").append(employeeid).append("'");
        Query query = getEntityManager().createNativeQuery(sql.toString());
        return (BigDecimal) query.getSingleResult();
    }
}
