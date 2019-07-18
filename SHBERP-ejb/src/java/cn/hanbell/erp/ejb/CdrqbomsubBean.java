/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Cdrqbomsub;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class CdrqbomsubBean extends SuperEJBForERP<Cdrqbomsub>{

    public CdrqbomsubBean() {
        super(Cdrqbomsub.class);
    }
   
    public Cdrqbomsub findByItnbrfAndCdrno(String facno ,String itnbrf ,String cdrno){
         Query query = this.getEntityManager().createNamedQuery("Cdrqbomsub.findByItnbrfAndCdrno");
        query.setParameter("facno", facno);
        query.setParameter("itnbrf", itnbrf);
        query.setParameter("cdrno", cdrno);
        try {
            return (Cdrqbomsub) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
}
