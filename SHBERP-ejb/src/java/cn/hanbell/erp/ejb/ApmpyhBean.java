/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Apmpyh;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class ApmpyhBean  extends  SuperEJBForERP<Apmpyh>{
    
    public ApmpyhBean() {
        super(Apmpyh.class);
    }

    public  Apmpyh findByPK(String facno ,String acpno){
       Query query = getEntityManager().createNamedQuery("Apmpyh.findByPK");
        query.setParameter("facno", facno);
        query.setParameter("acpno", acpno);
        try {
            Apmpyh apmpyh = (Apmpyh) query.getSingleResult();
            return apmpyh ;
        } catch (Exception ex) {
            return null;
        }
    }
}
