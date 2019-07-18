/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Cdrsfkpart;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class CdrsfkpartBean extends SuperEJBForERP<Cdrsfkpart>{

    public CdrsfkpartBean() {
        super(Cdrsfkpart.class);
    }
    
    public Cdrsfkpart findByPK(String facno, String parts){
        Query query = this.getEntityManager().createNamedQuery("Cdrsfkpart.findByPK");
        query.setParameter("facno", facno);
        query.setParameter("parts", parts);
        try {
            return (Cdrsfkpart) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
 
}
