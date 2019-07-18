/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Invsys;
import com.lightshell.comm.SuperEJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class InvsysBean extends SuperEJBForERP<Invsys>{

    public InvsysBean() {
        super(Invsys.class);
    }

    public  Invsys findByFacno(String facno){
       Query query = getEntityManager().createNamedQuery("Invsys.findByFacno");
        query.setParameter("facno", facno);
        try {
            Invsys invsys = (Invsys) query.getSingleResult();
            return invsys;
        } catch (Exception ex) {
            return null;
        }
    }
}
