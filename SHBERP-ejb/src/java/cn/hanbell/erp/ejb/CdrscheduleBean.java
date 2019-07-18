/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Cdrschedule;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
public class CdrscheduleBean extends SuperEJBForERP<Cdrschedule> {

    public CdrscheduleBean() {
        super(Cdrschedule.class);
    }

    public Cdrschedule findByPK(String facno, String cdrno) {
        Query query = this.getEntityManager().createNamedQuery("Cdrschedule.findByPK");
        query.setParameter("facno", facno);
        query.setParameter("cdrno", cdrno);
        try {
            Object o = query.getSingleResult();
            return (Cdrschedule) o;
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Cdrschedule> findByCustomerAndStatusAndFilters(String cusno, String status, Map<String, Object> filters) {
        int mon = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT c FROM Cdrschedule c WHERE c.cusno = :cusno ");
        switch (status) {
            case "N":
                sb.append(" AND c.status !='Y' ");
                break;
            case "Y":
                sb.append(" AND c.status = 'Y' ");
                break;
            case "A":
                break;
            default:
                sb.append(" AND c.status !='Y' ");
                break;
        }
        if (filters != null) {
            for (Map.Entry<String, Object> e : filters.entrySet()) {
                if (e.getKey().equals("prev")) {
                    mon = Integer.parseInt(e.getValue().toString());
                    sb.append(" AND c.shipday1 >= :datebegin ");
                } else if (e.getValue().getClass() == String.class) {
                    sb.append(" and c.").append(e.getKey()).append(" like :").append(e.getKey());
                } else {
                    sb.append(" and c.").append(e.getKey()).append(" = :").append(e.getKey());
                }
            }
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar c = Calendar.getInstance();
        Date baseday;
        if (mon != 0) {
            c.add(Calendar.MONTH, 0 - mon);
            baseday = c.getTime();
        } else {
            baseday = c.getTime();
        }
        try {
            baseday = sdf.parse(sdf.format(baseday));
        } catch (ParseException ex) {
            Logger.getLogger(CdrscheduleBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        Query query = getEntityManager().createQuery(sb.toString());
        query.setParameter("cusno", cusno);

        if (filters != null) {
            for (Map.Entry<String, Object> e : filters.entrySet()) {
                if (e.getKey().equals("prev")) {
                    query.setParameter("datebegin", baseday);
                } else if (e.getValue().getClass() == String.class) {
                    query.setParameter(e.getKey(), "%" + e.getValue() + "%");
                } else {
                    query.setParameter(e.getKey(), e.getValue());
                }
            }
        }
        return query.getResultList();
    }

}
