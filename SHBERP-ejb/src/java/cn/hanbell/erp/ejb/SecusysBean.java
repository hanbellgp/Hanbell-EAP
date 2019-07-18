/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Secusys;
import cn.hanbell.oa.entity.ProcessCheck;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C1587
 */
@Stateless
@LocalBean
public class SecusysBean extends SuperEJBForERP<Secusys> {

    public SecusysBean() {
        super(Secusys.class);
    }



    public Secusys findByPK(String sysno, String userno) {
        Query query = getEntityManager().createNamedQuery("Secusys.findByPK");
        query.setParameter("sysno", sysno);
        query.setParameter("userno", userno);
        try {
            Object o = query.getSingleResult();
            return (Secusys) o;
        } catch (Exception ex) {
            return null;
        }
    }
}
