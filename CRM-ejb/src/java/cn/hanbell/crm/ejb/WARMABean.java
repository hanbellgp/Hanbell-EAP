/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.Pormy;
import cn.hanbell.crm.entity.WARMA;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author C2082
 */

@Stateless
@LocalBean
public class WARMABean extends SuperEJBForCRM<WARMA>  {

    public WARMABean() {
        super(WARMA.class);
    }
    
    public List<WARMA> findByMA001(Integer ma001 ){
         Query query = getEntityManager().createNamedQuery("Warma.findByMa001");
         query.setParameter("ma001", ma001);
         try {
            Object o = query.getSingleResult();
            return (List<WARMA>) o;
        } catch (Exception ex) {
            return null;
        }
    }
}
