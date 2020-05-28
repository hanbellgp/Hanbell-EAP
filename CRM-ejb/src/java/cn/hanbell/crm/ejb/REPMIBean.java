/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.CRMGG;
import cn.hanbell.crm.entity.REPMI;
import com.sun.xml.xsom.impl.scd.Iterators.Map;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class REPMIBean extends SuperEJBForCRM<REPMI> {

    public REPMIBean() {
        super(REPMI.class);
    }

    public REPMI findByPK(String mi001, String mi002) {
        Query query = this.getEntityManager().createNamedQuery("REPMI.findByPK");
        query.setParameter("mi001", mi001);
        query.setParameter("mi002", mi002);
        try {
            Object o = query.getSingleResult();
            return (REPMI) o;
        } catch (Exception e) {
            return null;
        }
    }

    //根据制造号码查询
    public REPMI findByMI002(String mi002) {
        Query query = this.getEntityManager().createNamedQuery("REPMI.findByMi002");
        query.setParameter("mi002", mi002);
        try {
            Object o = query.getSingleResult();
            return (REPMI) o;
        } catch (Exception e) {
            return null;
        }
    }

    //导入资料,CRM资料存在即修改，反之新增
    public boolean addRepmi(List<REPMI> list, String userno) {
        try {
            REPMI repmi;
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
            String nowtime = df.format(new Date());
            for (REPMI newRepmi : list) {
                repmi = findByPK(newRepmi.getREPMIPK().getMi001(), newRepmi.getREPMIPK().getMi002());
                if (repmi != null) {
                    String bz = repmi.getMi003();
                    repmi.setCreateDate(nowtime);
                    repmi.setREPMIPK(newRepmi.getREPMIPK()); //(品号,序号)
                    repmi.setMi006(newRepmi.getMi006()); //保修期间起
                    repmi.setMi007(newRepmi.getMi007()); //保修期间止
                    repmi.setMi004("Y");//已出货
                    repmi.setMi011("N");//结案码
                    repmi.setMi506(newRepmi.getMi506()); //终端客户代号
                    repmi.setMi507(newRepmi.getMi507()); //终端客户简称
                    //在原有备注上开头增加替换记录
                    repmi.setMi003("EAP替换- " + nowtime + " -" + userno);
                    super.update(repmi);
                } else {
                    newRepmi.setMi004("Y");//已出货
                    newRepmi.setMi011("N");//结案码
                    newRepmi.setCreateDate(nowtime);
                    newRepmi.setMi003("EAP新增-" + nowtime + " -" + userno);
                    super.persist(newRepmi);
                }
            }
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public List<REPMI> queryRepmi(LinkedHashMap<String, String> map) {
        String dateBegin = map.get("dateBegin") != null ? map.get("dateBegin") : "";
        String dateEnd = map.get("dateEnd") != null ? map.get("dateEnd") : "";
        String MI001 = map.get("MI001") != null ? map.get("MI001") : "";
        String MI002 = map.get("MI002") != null ? map.get("MI002") : "";
        StringBuilder sb = new StringBuilder();

        sb.append("SELECT r FROM REPMI r WHERE r.mi003 LIKE 'EAP%' ");
        //品号
        if (!"".equals(MI001)) {
            sb.append(" and r.repmiPK.mi001 like '%").append(MI001).append("%' ");
        }
        //制造号码
        if (!"".equals(MI002)) {
            sb.append(" and r.repmiPK.mi002 like '%").append(MI002).append("%' ");
        }
        //导入时间
        if (!"".equals(dateBegin)) {
            sb.append(" and r.createDate >= '").append(dateBegin).append("'");
        }
        if (!"".equals(dateEnd)) {
            sb.append(" and r.createDate <= '").append(dateEnd).append("'");
        }
        sb.append(" ORDER BY r.createDate DESC,r.repmiPK.mi001 ASC");
        try {
            Query query = getEntityManager().createQuery(sb.toString());
            List<REPMI> list = query.getResultList();
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public List<Object[]> findProductNumber(String MI001) {

        StringBuffer sql = new StringBuffer("Select top 200 MI002,MI001,MB002,MB003 from REPMI "
                + "left join WARMB ON MB001 = MI001  Where  N'' IN (MI001,'')  AND N'' IN (MI002,'')  "
                + "AND MI005='N' AND MI011='N' AND ISNULL(MI010,'') = '' ");
        Query query = null;
        if (!"undefined".equals(MI001) && !"".equals(MI001) && MI001 != null) {
            sql = new StringBuffer("Select top 200 MI002,MI001,MB002,MB003 from REPMI "
                + "left join WARMB ON MB001 = MI001  Where  N'' IN (MI001,'')  AND N'' IN (MI002,'')  "
                + "AND MI005='N' AND MI011='N' AND ISNULL(MI010,'') = '' And MB002 Like ");
            query = getEntityManager().createNativeQuery(sql.append(new StringBuffer("'%").append(MI001).append("%'")).toString());
        } else {
            query = getEntityManager().createNativeQuery(sql.toString());
        }
        try {
            List<Object[]> list = query.getResultList();
            return list;
        } catch (Exception ex) {
            System.out.println("ex=" + ex);
            return null;
        }
    }
}
