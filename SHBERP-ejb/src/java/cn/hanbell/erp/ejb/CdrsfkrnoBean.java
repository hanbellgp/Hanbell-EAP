/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Cdrsfkrno;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class CdrsfkrnoBean extends SuperEJBForERP<Cdrsfkrno> {

    public CdrsfkrnoBean() {
        super(Cdrsfkrno.class);
    }

    public Cdrsfkrno findByPK(String facno, String trtype, String keyformat) {
        Query query = this.getEntityManager().createNamedQuery("Cdrsfkrno.findByPK");
        query.setParameter("facno", facno);
        query.setParameter("trtype", trtype);
        query.setParameter("keyformat", keyformat);
        try {
            return (Cdrsfkrno) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public int getMaxno(String facno, String trtype, String keyformat) {
        int li_maxno = 0;
        this.setCompany(facno);
        Cdrsfkrno cdrsfkrno = findByPK(facno, trtype, keyformat);
        try {
            li_maxno = cdrsfkrno.getMaxseq();
        } catch (Exception ex) {
            li_maxno = 0;
        }
        return li_maxno;
    }

}
