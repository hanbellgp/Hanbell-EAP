/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.CustomerComplaintCost;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C1879
 */
@Stateless
@LocalBean
public class CustomerComplaintCostBean extends SuperEJBForEAP<CustomerComplaintCost> {

    public CustomerComplaintCostBean() {
        super(CustomerComplaintCost.class);
    }

    public List<CustomerComplaintCost> findKfno(String kfno) {
        Query query = getEntityManager().createNamedQuery("CustomerComplaintCost.findKfno");
        query.setParameter("kfno", kfno);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public List<CustomerComplaintCost> getSumList(List<CustomerComplaintCost> list1, List<CustomerComplaintCost> list2) {
        List<CustomerComplaintCost> list = new ArrayList<>();
        if (list1 != null && !list1.isEmpty()) {
            for (CustomerComplaintCost cuscomPlaintCost : list1) {
                list.add(cuscomPlaintCost);
            }
        }
        if (list2 != null && !list2.isEmpty()) {
            for (CustomerComplaintCost cuscomPlaintCost : list2) {
                list.add(cuscomPlaintCost);
            }
        }
        return list;
    }
    public Date getTime(String date) throws ParseException{
        return  new SimpleDateFormat("yyyy-MM-dd").parse(date);
    }
            
}
