/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.plm.ejb;

import cn.hanbell.plm.comm.SuperEJBForPLM;
import cn.hanbell.plm.entity.Part;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ZFF
 */
@Stateless
@LocalBean
public class PartBean extends SuperEJBForPLM<Part> {

    @PersistenceContext(unitName = "PLM-hbofficialPU")
    private EntityManager em;

    public PartBean() {
        super(Part.class);
    }

    public Part findByKeyedName(String itnbr) {
        Query query = getEntityManager().createNamedQuery("Part.findByKeyedName");
        query.setParameter("keyedName", itnbr);
        try {
            Object o = query.getSingleResult();
            return (Part) o;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

}
