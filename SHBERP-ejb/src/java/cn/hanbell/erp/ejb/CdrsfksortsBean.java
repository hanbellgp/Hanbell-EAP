/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Cdrsfksorts;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class CdrsfksortsBean extends SuperEJBForERP<Cdrsfksorts>{

    public CdrsfksortsBean() {
        super(Cdrsfksorts.class);
    }

    public Cdrsfksorts findByPK(String facno, String parts, String sorts) {
        Query query = this.getEntityManager().createNamedQuery("Cdrsfksorts.findByPK");
        query.setParameter("facno", facno);
        query.setParameter("parts", parts);
        query.setParameter("sorts", sorts);
        try {
            return (Cdrsfksorts) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
