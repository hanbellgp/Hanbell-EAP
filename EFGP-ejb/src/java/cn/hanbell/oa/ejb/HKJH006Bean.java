/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKJH001serial;
import cn.hanbell.oa.entity.HKJH006;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author C2082
 */
@Stateless
@LocalBean
public class HKJH006Bean extends SuperEJBForEFGP<HKJH006> {

    @EJB
    private HKJH001serialBean hkjh001serialBean;
    
    public HKJH006Bean() {
        super(HKJH006.class);
    }

    public List<Object[]> findByCustomerAndApplyDate(String queryDateBegin, String queryDateEnd, String customerid, String customername) {
        try {
            StringBuffer sql = new StringBuffer("SELECT a.applyDate,a.customerno,a.customername,d.id,d.organizationUnitName,a.discountrate,a.period,a.number,a.amount,explanation");
            sql.append(" FROM HK_JH006 a");
            sql.append(" left join Users b on a.principal = b.id");
            sql.append(" left join Functions c on b.OID=c.occupantOID");
            sql.append(" left join  OrganizationUnit d on d.OID=c.organizationUnitOID");
            sql.append(" where c.isMain=1 ");
            sql.append(" and a.applyDate>='").append(queryDateBegin).append("'");
            sql.append(" and a.applyDate<='").append(queryDateEnd).append("'");
            if (customerid != null && !"".equals(customerid)) {
                sql.append(" and customerno like '%").append(customerid).append("%'");
            }
            if (customername != null && !"".equals(customername)) {
                sql.append(" and customername like N'%").append(customername).append("%'");
            }
            Query q = getEntityManager().createNativeQuery(sql.toString());
            List<Object[]> list = q.getResultList();
            return list;
        } catch (Exception e) {
            return null;
        }

    }
    public synchronized boolean updateHKJH006(String psn){
    HKJH006 hkjh006psn = findByPSN(psn);
        if (hkjh006psn == null) {
            throw new NullPointerException();//抛异常，程式终止
        }
        HKJH001serial hs = hkjh001serialBean.findByKind("ZR");
        String fanco = hkjh006psn.getFacno();
        String no = "";
        int serialno = hs.getSerialno();
        if (serialno < 10) {
            no = "000" + serialno;
        } else if (serialno < 100) {
            no = "00" + serialno;
        } else if (serialno < 1000) {
            no = "0" + serialno;
        } else {
            no = "" + serialno;
        }

        no = fanco + "ZR" + no;
        hkjh006psn.setContractno(no);
        
        this.update(hkjh006psn);
        serialno=serialno+1;
        hs.setSerialno(serialno);
        hkjh001serialBean.update(hs);
        return true;
    }
    
}
