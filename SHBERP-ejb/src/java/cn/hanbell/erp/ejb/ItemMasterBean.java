/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.ItemMaster;
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
public class ItemMasterBean extends SuperEJBForERP<ItemMaster> {

    public ItemMasterBean() {
        super(ItemMaster.class);
    }

    public List<ItemMaster> findByCategory(String category, int first, int pageSize) {
        Query query = getEntityManager().createNativeQuery("SELECT mc_smalltype_itnbr,itdsc FROM fw_mc_smalltype,invmas WHERE mc_smalltype_itnbr=itnbr AND mc_bigtype_itnbr = '" + category + "'").setFirstResult(first).setMaxResults(pageSize);
        List result = query.getResultList();
        List<ItemMaster> dataList = new ArrayList<>();
        if (result != null && !result.isEmpty()) {
            ItemMaster newEntity;
            for (int i = 0; i < result.size(); i++) {
                Object[] row = (Object[]) result.get(i);
                newEntity = new ItemMaster(row[0].toString(), row[1].toString());
                dataList.add(newEntity);
            }
        }
        return dataList;
    }

    public List<ItemMaster> findByModelAndCategory(String model, String category, int first, int pageSize) {
        Query query = getEntityManager().createNativeQuery("SELECT mc_smalltype_itnbr,itdsc FROM fw_mc_smalltype,invmas WHERE mc_smalltype_itnbr=itnbr AND mc_type_code = '" + model + "' AND mc_bigtype_itnbr = '" + category + "'").setFirstResult(first).setMaxResults(pageSize);
        List result = query.getResultList();
        List<ItemMaster> dataList = new ArrayList<>();
        if (result != null && !result.isEmpty()) {
            ItemMaster newEntity;
            for (int i = 0; i < result.size(); i++) {
                Object[] row = (Object[]) result.get(i);
                newEntity = new ItemMaster(row[0].toString(), row[1].toString());
                dataList.add(newEntity);
            }
        }
        return dataList;
    }

}
