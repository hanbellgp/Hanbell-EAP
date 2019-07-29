/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Cdrsfkspec;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class CdrsfkspecBean extends SuperEJBForERP<Cdrsfkspec> {

    public CdrsfkspecBean() {
        super(Cdrsfkspec.class);
    }

    public Cdrsfkspec findByPK(String facno, String parts, String sorts, String specifit) {
        Query query = this.getEntityManager().createNamedQuery("Cdrsfkspec.findByPK");
        query.setParameter("facno", facno);
        query.setParameter("parts", parts);
        query.setParameter("sorts", sorts);
        query.setParameter("specifit", specifit);
        try {
            return (Cdrsfkspec) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}
