/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.CustomerComplaintExpense;
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
public class CustomerComplaintExpenseBean extends SuperEJBForEAP<CustomerComplaintExpense> {

    public CustomerComplaintExpenseBean() {
        super(CustomerComplaintExpense.class);
    }

    public List<CustomerComplaintExpense> findKfno(String kfno) {
        Query query = getEntityManager().createNamedQuery("CustomerComplaintExpense.findKfno");
        query.setParameter("kfno", kfno);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public List<CustomerComplaintExpense> findKfnoAndType(String kfno, String type) {
        Query query = getEntityManager().createNamedQuery("CustomerComplaintExpense.findKfnoAndType");
        query.setParameter("kfno", kfno);
        query.setParameter("type", type);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public List<CustomerComplaintExpense> getSumList(List<CustomerComplaintExpense> list1, List<CustomerComplaintExpense> list2) {
        List<CustomerComplaintExpense> list = new ArrayList<>();
        if (list1 != null && !list1.isEmpty()) {
            for (CustomerComplaintExpense complaintExpense : list1) {
                list.add(complaintExpense);
            }
        }
        if (list2 != null && !list2.isEmpty()) {
            for (CustomerComplaintExpense complaintExpense : list2) {
                list.add(complaintExpense);
            }
        }
        return list;
    }

    public Date getTime(String date) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(date);
    }

}
