/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.entity.Invhdsc;
import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Misdept;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class InvhdscBean extends SuperEJBForERP<Invhdsc> {

    public InvhdscBean() {
        super(Invhdsc.class);
    }

    public Invhdsc findByFacnoAndPronoAndTrno(String facno, String prono, String trno) {
        Query query = this.getEntityManager().createNamedQuery("Invhdsc.findByFacnoAndPronoAndTrno",Invhdsc.class);
        query.setParameter("facno", facno);
        query.setParameter("prono", prono);
        query.setParameter("trno", trno);
        try {
           List<Invhdsc> list = query.getResultList();
           if(list.isEmpty()){
                  return null;
           }
            return list.get(0);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
