/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.Pormy;
import cn.hanbell.crm.entity.PormyPK;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

@Stateless
@LocalBean
public class PormyBean extends SuperEJBForCRM<Pormy> {

    public PormyBean() {
        super(Pormy.class);
    }

    public Pormy findByMY002(String crmno) {
        PormyPK pk = new PormyPK();
        pk.setMy001("A1");
        pk.setMy002(crmno);
        Query query = getEntityManager().createNamedQuery("Pormy.findByPK");
        query.setParameter("pormyPK", pk);
        try {
            Object o = query.getSingleResult();
            return (Pormy) o;
        } catch (Exception ex) {
            return null;
        }
    }

}
