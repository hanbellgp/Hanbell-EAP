/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.ItemCategory;
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
public class ItemCategoryBean extends SuperEJBForERP<ItemCategory> {

    public ItemCategoryBean() {
        super(ItemCategory.class);
    }

    @Override
    public List<ItemCategory> findAll() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT distinct mc_bigtype_itnbr,mc_bigtype_name FROM fw_mc_bigtype WHERE offer_code='RCSLJ' ");
        sb.append(" ORDER BY  mc_bigtype_itnbr ");
        Query query = getEntityManager().createNativeQuery(sb.toString());
        List result = query.getResultList();
        List<ItemCategory> dataList = new ArrayList<>();
        if (result != null && !result.isEmpty()) {
            ItemCategory newEntity;
            for (int i = 0; i < result.size(); i++) {
                Object[] row = (Object[]) result.get(i);
                newEntity = new ItemCategory(row[0].toString(), row[1].toString());
                dataList.add(newEntity);
            }
        }
        return dataList;
    }

    @Override
    public List<ItemCategory> findAll(int first, int pageSize) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT distinct mc_bigtype_itnbr,mc_bigtype_name FROM fw_mc_bigtype WHERE offer_code='RCSLJ' ");
        sb.append(" ORDER BY  mc_bigtype_itnbr ");
        Query query = getEntityManager().createNativeQuery(sb.toString()).setFirstResult(first).setMaxResults(pageSize);
        List result = query.getResultList();
        List<ItemCategory> dataList = new ArrayList<>();
        if (result != null && !result.isEmpty()) {
            ItemCategory newEntity;
            for (int i = 0; i < result.size(); i++) {
                Object[] row = (Object[]) result.get(i);
                newEntity = new ItemCategory(row[0].toString(), row[1].toString());
                dataList.add(newEntity);
            }
        }
        return dataList;
    }

}
