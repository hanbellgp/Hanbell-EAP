/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Secuser;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
@Named
public class SecuserBean extends SuperEJBForERP<Secuser> {

    public SecuserBean() {
        super(Secuser.class);
    }

    @Override
    public Secuser findById(Object value) {
        return findByUserno(value.toString());
    }

    public Secuser findByUserno(String userno) {
        Query query = getEntityManager().createNamedQuery("Secuser.findByUserno");
        query.setParameter("userno", userno);
        try {
            Object o = query.getSingleResult();
            return (Secuser) o;
        } catch (Exception ex) {
            return null;
        }
    }

    public Secuser findByUsernoAndPwd(String userno, String pwd) {
        Query query = getEntityManager().createNamedQuery("Secuser.findByUsernoAndPwd");
        query.setParameter("userno", userno);
        query.setParameter("pwd", pwd);
        try {
            Object o = query.getSingleResult();
            if (o != null) {
                return (Secuser) o;
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }

}
