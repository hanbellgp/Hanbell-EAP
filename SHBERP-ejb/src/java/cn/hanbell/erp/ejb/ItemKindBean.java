/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.ItemKind;
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
public class ItemKindBean extends SuperEJBForERP<ItemKind> {

    public ItemKindBean() {
        super(ItemKind.class);
    }

    @Override
    public List<ItemKind> findAll() {
        Query query = this.getEntityManager().createNativeQuery("SELECT distinct kind FROM cdrdmmodel ORDER BY kind ");
        List result = query.getResultList();
        List<ItemKind> dataList = new ArrayList<>();
        if (result != null && !result.isEmpty()) {
            ItemKind kind;
            for (Object o : result) {
                kind = new ItemKind(o.toString());
                dataList.add(kind);
            }
        }
        return dataList;
    }

    @Override
    public List<ItemKind> findAll(int first, int pageSize) {
        Query query = this.getEntityManager().createNativeQuery("SELECT distinct kind FROM cdrdmmodel ORDER BY kind ").setFirstResult(first).setMaxResults(pageSize);
        List result = query.getResultList();
        List<ItemKind> dataList = new ArrayList<>();
        if (result != null && !result.isEmpty()) {
            ItemKind kind;
            for (Object o : result) {
                kind = new ItemKind(o.toString());
                dataList.add(kind);
            }
        }
        return dataList;
    }

}
