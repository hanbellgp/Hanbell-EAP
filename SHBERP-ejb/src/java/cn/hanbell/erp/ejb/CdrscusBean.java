/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Cdrscus;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class CdrscusBean extends SuperEJBForERP<Cdrscus> {

    public CdrscusBean() {
        super(Cdrscus.class);
    }

    public List<Cdrscus> findByCusno(String cusno) {
        Query query = getEntityManager().createNamedQuery("Cdrscus.findByCusno");
        query.setParameter("cusno", cusno);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public Cdrscus findByPK(String cusno, short trseq) {
        Query query = getEntityManager().createNamedQuery("Cdrscus.findByPK");
        query.setParameter("cusno", cusno);
        query.setParameter("trseq", trseq);
        try {
            Object o = query.getSingleResult();
            return (Cdrscus) o;
        } catch (Exception ex) {
            return null;
        }
    }

    public String getAddress(String cusno, short trseq) {
        String add = "";
        Cdrscus c = this.findByPK(cusno, trseq);
        if (c != null) {
            if (c.getAddress1() != null && !"".equals(c.getAddress1())) {
                add += c.getAddress1();
            }
            if (c.getAddress2() != null && !"".equals(c.getAddress2())) {
                add += c.getAddress2();
            }
            if (c.getAddress3() != null && !"".equals(c.getAddress3())) {
                add += c.getAddress3();
            }
            if (c.getAddress4() != null && !"".equals(c.getAddress4())) {
                add += c.getAddress4();
            }
        }
        return add;
    }

}
