/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.PricingGroup;
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
public class PricingGroupBean extends SuperEJBForERP<PricingGroup> {

    public PricingGroupBean() {
        super(PricingGroup.class);
    }

    public List<PricingGroup> findByUserno(String userno) {
        StringBuilder sb = new StringBuilder();
        //不包含集团内部交易价格
        sb.append("SELECT pricinggroup.groupid,pricinggroup.groupname,price09,price08,price07,price06,price05,price04,price03,price02,price01,pricinggroup.pricingtype FROM pricinggroup,pricinguser ");
        sb.append(" WHERE pricinggroup.groupid = pricinguser.groupid AND pricinggroup.pricingtype = pricinguser.pricingtype AND pricinggroup.pricingtype<>'00' ");
        sb.append(" AND pricinguser.userid = '");
        sb.append(userno);
        sb.append("'");
        Query query = getEntityManager().createNativeQuery(sb.toString());
        List result = query.getResultList();
        List<PricingGroup> dataList = new ArrayList<>();
        PricingGroup newEntity;
        if (result != null && !result.isEmpty()) {
            String groupid = "", groupname = "", pricingtype = "";
            boolean price09 = false, price08 = false, price07 = false, price06 = false, price05 = false, price04 = false, price03 = false, price02 = false, price01 = false;
            for (int i = 0; i < result.size(); i++) {
                Object[] row = (Object[]) result.get(i);
                groupid = row[0].toString();
                groupname = row[1].toString();
                price01 = Boolean.parseBoolean(row[10].toString());
                price02 = price01 || Boolean.parseBoolean(row[9].toString());
                price03 = price02 || Boolean.parseBoolean(row[8].toString());
                price04 = price03 || Boolean.parseBoolean(row[7].toString());
                price05 = price04 || Boolean.parseBoolean(row[6].toString());
                price06 = price05 || Boolean.parseBoolean(row[5].toString());
                price07 = price06 || Boolean.parseBoolean(row[4].toString());
                price08 = price07 || Boolean.parseBoolean(row[3].toString());
                price09 = price08 || Boolean.parseBoolean(row[2].toString());
                pricingtype = row[11].toString();
                newEntity = new PricingGroup(groupid, groupname, price09, price08, price07, price06, price05, price04, price03, price02, price01, pricingtype);
                dataList.add(newEntity);
            }
        }
        return dataList;
    }

    public PricingGroup findByUsernoAndGroupId(String userno, String id) {
        StringBuilder sb = new StringBuilder();
        //不包含集团内部交易价格
        sb.append("SELECT pricinggroup.groupid,pricinggroup.groupname,price09,price08,price07,price06,price05,price04,price03,price02,price01,pricinggroup.pricingtype FROM pricinggroup,pricinguser ");
        sb.append(" WHERE pricinggroup.groupid = pricinguser.groupid AND pricinggroup.pricingtype = pricinguser.pricingtype AND pricinggroup.pricingtype<>'00' ");
        sb.append(" AND pricinguser.userid = '");
        sb.append(userno);
        sb.append("' ");
        sb.append(" AND pricinggroup.groupid='");
        sb.append(id);
        sb.append("' ");
        Query query = getEntityManager().createNativeQuery(sb.toString());
        Object[] row = (Object[]) query.getSingleResult();
        PricingGroup newEntity;
        if (row != null) {
            String groupid = "", groupname = "", pricingtype = "";
            boolean price09 = false, price08 = false, price07 = false, price06 = false, price05 = false, price04 = false, price03 = false, price02 = false, price01 = false;

            groupid = row[0].toString();
            groupname = row[1].toString();
            price01 = Boolean.parseBoolean(row[10].toString());
            price02 = price01 || Boolean.parseBoolean(row[9].toString());
            price03 = price02 || Boolean.parseBoolean(row[8].toString());
            price04 = price03 || Boolean.parseBoolean(row[7].toString());
            price05 = price04 || Boolean.parseBoolean(row[6].toString());
            price06 = price05 || Boolean.parseBoolean(row[5].toString());
            price07 = price06 || Boolean.parseBoolean(row[4].toString());
            price08 = price07 || Boolean.parseBoolean(row[3].toString());
            price09 = price08 || Boolean.parseBoolean(row[2].toString());
            pricingtype = row[11].toString();
            newEntity = new PricingGroup(groupid, groupname, price09, price08, price07, price06, price05, price04, price03, price02, price01, pricingtype);
            return newEntity;
        }
        return null;
    }

}
