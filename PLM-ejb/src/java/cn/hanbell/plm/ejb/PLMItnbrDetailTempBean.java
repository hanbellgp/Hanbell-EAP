/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.plm.ejb;

import cn.hanbell.plm.comm.SuperEJBForPLM;
import cn.hanbell.plm.entity.PLMItnbrDetailTemp;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class PLMItnbrDetailTempBean extends SuperEJBForPLM<PLMItnbrDetailTemp> {

    public PLMItnbrDetailTempBean() {
        super(PLMItnbrDetailTemp.class);
    }

    public List<PLMItnbrDetailTemp> findByItemNumber(String itemNumber) {
        Query query = this.getEntityManager().createNamedQuery("PLMItnbrDetailTemp.findByItemNumber");
        query.setParameter("itemnumber", itemNumber);
        return query.getResultList();
    }

}
