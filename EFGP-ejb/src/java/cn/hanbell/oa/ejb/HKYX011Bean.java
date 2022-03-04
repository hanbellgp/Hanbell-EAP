/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKJH001;
import cn.hanbell.oa.entity.HKJH001serial;
import cn.hanbell.oa.entity.HKYX011;
import com.lightshell.comm.BaseLib;
import java.util.Date;
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
public class HKYX011Bean extends SuperEJBForEFGP<HKYX011> {
    @EJB
    private HKJH001serialBean hkjh001serialBean;
    public HKYX011Bean() {
        super(HKYX011.class);
    }

    /**
     *
     * @param queryDateBeginn 查找开始时间（根据申请时间）
     * @param queryDateEnd 查找开始时间（根据申请时间）
     * @param customerNo 客户编号
     * @param customerName 客户名称
     * @param deptNo 部门编号
     * @param deptName 部门名称
     * @return
     */
    public List<HKYX011> getAll(Date queryDateBegin, Date queryDateEnd, String customerNo, String customerName, String deptNo, String deptName) {
        try {
            StringBuffer sql = new StringBuffer("SELECT * FROM HK_YX011");
            sql.append(" where applyDate>= '").append(BaseLib.formatDate("yyyy-MM-dd HH:mm:ss.000", queryDateBegin)).append("' and ");
            sql.append(" applyDate<= '").append(BaseLib.formatDate("yyyy-MM-dd HH:mm:ss.000", queryDateEnd)).append("'");

            if (customerNo != null && !"".equals(customerNo)) {
                sql.append(" and customerno like '%").append(customerNo).append("%'");
            }
            if (customerName != null && !"".equals(customerName)) {
                sql.append(" and customerName like '%").append(customerName).append("%'");
            }
            if (deptNo != null && !"".equals(deptNo)) {
                sql.append(" and deptNo like '%").append(deptNo).append("%'");
            }
             if (deptName != null && !"".equals(deptName)) {
                sql.append(" and deptNo in ").append(deptNo).append("");
            }
            Query query = getEntityManager().createNativeQuery(sql.toString(),HKYX011.class);
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    public boolean updateHKYX011(String psn) {
        HKYX011 h = findByPSN(psn);
        if (h == null) {
            throw new NullPointerException();
        }
        String actualDiscountNo = h.getActualDiscountNo();
        if ("".equals(actualDiscountNo)){
        String sealfacno = h.getSealfacno();
        String stampCategory = h.getStampCategory();
        Date applyDate = h.getApplyDate();
        String formatDate = cn.hanbell.util.BaseLib.formatDate("yyyy", applyDate);
        
        HKJH001serial hs = hkjh001serialBean.findByKind("SZ");

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
        no = sealfacno + stampCategory + "SZ" + formatDate + no;
        h.setActualDiscountNo(no);
        this.update(h);
        serialno++;
        hs.setSerialno(serialno);
        hkjh001serialBean.update(hs);
        return true;
        }
        return false;
    }
}
