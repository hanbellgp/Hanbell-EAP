/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.ItemFault;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.inject.Named;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
@Named
public class ItemFaultBean extends SuperEJBForERP<ItemFault> {

    public ItemFaultBean() {
        super(ItemFault.class);
    }

    @Override
    public List<ItemFault> findAll() {
        Query query = getEntityManager().createNativeQuery("SELECT distinct mc_bigtype_itnbr,mc_bigtype_name FROM fw_mc_bigtype WHERE offer_code='RCSWX' ");
        List result = query.getResultList();
        List<ItemFault> dataList = new ArrayList<>();
        if (result != null && !result.isEmpty()) {
            ItemFault newEntity;
            for (int i = 0; i < result.size(); i++) {
                Object[] row = (Object[]) result.get(i);
                newEntity = new ItemFault(row[0].toString(), row[1].toString());
                dataList.add(newEntity);
            }
        }
        return dataList;
    }
    
}
