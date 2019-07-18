/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Pricing;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
@Named
public class PricingBean extends SuperEJBForERP<Pricing> {

    public PricingBean() {
        super(Pricing.class);
    }

    public Pricing findByItnbrAndFilters(String itnbr, Map<String, Object> filters) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/dd");
        Date today = sdf.parse(sdf.format(Calendar.getInstance().getTime()));
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT p FROM Pricing p,PricingPolicy pp WHERE p.pricingPK.pricingid = pp.pricingid AND pp.pricingtype<>'00' ");
        sb.append(" AND pp.status='V' AND pp.daybegin <= :daybegin AND pp.dayend >= :dayend AND p.pricingPK.itnbr = :itnbr ");

        boolean flag;
        if (filters != null) {
            for (Map.Entry<String, Object> e : filters.entrySet()) {
                flag = true;
                try {
                    Pricing.class.getDeclaredField(e.getKey());
                } catch (SecurityException | NoSuchFieldException ex) {
                    flag = false;
                }
                if (flag) {
                    sb.append(" AND p.").append(e.getKey()).append(" = :").append(e.getKey());
                } else {
                    sb.append(" AND pp.").append(e.getKey()).append(" = :").append(e.getKey());
                }
            }
        }
        sb.append(
                " ORDER BY pp.pricingid DESC ");
        //生成SQL
        Query query = getEntityManager().createQuery(sb.toString());

        //参数赋值
        query.setParameter("daybegin", today);
        query.setParameter("dayend", today);
        query.setParameter("itnbr", itnbr);
        if (filters != null) {
            for (Map.Entry<String, Object> e : filters.entrySet()) {
                query.setParameter(e.getKey(), e.getValue());
            }
        }
        List<Pricing> entityList = query.getResultList();

        if (!entityList.isEmpty()) {
            return entityList.get(0);
        }

        return null;
    }

}
