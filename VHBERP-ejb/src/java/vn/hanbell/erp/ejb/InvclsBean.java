/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hanbell.erp.ejb;

import vn.hanbell.erp.comm.SuperEJBForERP;
import vn.hanbell.erp.entity.Invcls;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

@Stateless
@LocalBean
public class InvclsBean extends SuperEJBForERP<Invcls> {

    public InvclsBean() {
        super(Invcls.class);
    }

    public Invcls findByItcls(String itcls) {
        Query query = getEntityManager().createNamedQuery("Invcls.findByItcls");
        query.setParameter("itcls", itcls);
        try {
            return (Invcls) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

    public String findPurtrtypeByItclscode(String value) {
        Query query = getEntityManager().createNativeQuery("select purtrtype from purdou p ,invdou v where p.trtype = v.trtype and p.itclscode = ?1 and v.iocode='1'");
        query.setParameter(1, value);
        try {
            return query.getSingleResult().toString();
        } catch (Exception ex) {
            return "";
        }
    }

}
