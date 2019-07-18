/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.ItemModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
public class ItemModelBean extends SuperEJBForERP<ItemModel> {

    public ItemModelBean() {
        super(ItemModel.class);
    }

    @Override
    public List<ItemModel> findAll() {
        Query query = getEntityManager().createNativeQuery("SELECT cmcmodel,itnbr FROM cdrdmmodel ORDER BY cmcmodel ");
        List result = query.getResultList();
        List<ItemModel> dataList = new ArrayList<>();
        if (result != null && !result.isEmpty()) {
            ItemModel newEntity;
            for (int i = 0; i < result.size(); i++) {
                Object[] row = (Object[]) result.get(i);
                newEntity = new ItemModel(row[0].toString(), row[1].toString());
                dataList.add(newEntity);
            }
        }
        return dataList;
    }

    public List<ItemModel> findByKind(String kind, Map<String, Object> filters) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT cmcmodel,itnbr FROM cdrdmmodel WHERE kind = '").append(kind).append("' ");
        if (filters != null) {
            for (Map.Entry<String, Object> e : filters.entrySet()) {
                sb.append(" AND ").append(e.getKey()).append(" LIKE '%").append(e.getValue()).append("%' ");
            }
        }
        sb.append(" ORDER BY cmcmodel ");
        Query query = getEntityManager().createNativeQuery(sb.toString());
        List result = query.getResultList();
        List<ItemModel> dataList = new ArrayList<>();
        if (result != null && !result.isEmpty()) {
            ItemModel newEntity;
            for (int i = 0; i < result.size(); i++) {
                Object[] row = (Object[]) result.get(i);
                newEntity = new ItemModel(row[0].toString(), row[1].toString());
                dataList.add(newEntity);
            }
        }
        return dataList;
    }

    public List<ItemModel> findByKind(String kind, Map<String, Object> filters, int offset, int pageSize) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT cmcmodel,itnbr FROM cdrdmmodel WHERE kind = '").append(kind).append("' ");
        if (filters != null) {
            for (Map.Entry<String, Object> e : filters.entrySet()) {
                sb.append(" AND ").append(e.getKey()).append(" LIKE '%").append(e.getValue()).append("%' ");
            }
        }
        sb.append(" ORDER BY cmcmodel ");
        Query query = getEntityManager().createNativeQuery(sb.toString()).setFirstResult(offset).setMaxResults(pageSize);
        List result = query.getResultList();
        List<ItemModel> dataList = new ArrayList<>();
        if (result != null && !result.isEmpty()) {
            ItemModel newEntity;
            for (int i = 0; i < result.size(); i++) {
                Object[] row = (Object[]) result.get(i);
                newEntity = new ItemModel(row[0].toString(), row[1].toString());
                dataList.add(newEntity);
            }
        }
        return dataList;
    }

}
