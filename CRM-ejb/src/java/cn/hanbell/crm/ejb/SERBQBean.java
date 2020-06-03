/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.crm.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.entity.SERBQ;
import cn.hanbell.util.BaseLib;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C1587
 */
@Stateless
@LocalBean
public class SERBQBean extends SuperEJBForCRM<SERBQ> {

    public SERBQBean() {
        super(SERBQ.class);
    }

    public SERBQ findByBq001(String bq001) {
        Query query = this.getEntityManager().createNamedQuery("SERBQ.findByBq001");
        query.setParameter("bq001", bq001);
        try {
            Object o = query.getSingleResult();
            return (SERBQ) o;
        } catch (Exception ex) {
            return null;
        }
    }

    public String getBQ001ByDeptAndDate(String deptno, Date date) {
        String ls_no = "";
        String serial = "0000";
        if ("".equals(deptno)) {
            return ls_no;
        }
        if (deptno.startsWith("5")) {
            ls_no += "KMKF";
        } else {
            switch (deptno.substring(0, 2)) {
                case "1C":
                    ls_no += "HBKF";
                    break;
                case "1D":
                    ls_no += "HNKF";
                    break;
                case "1V":
                    ls_no += "CQKF";
                    break;
                case "1E":
                    ls_no += "NJKF";
                    break;
                default:
                    ls_no += "HDKF";
                    break;
            }
        }
        ls_no += BaseLib.formatDate("yyyy", date);
        ls_no += BaseLib.formatDate("MM", date);
        String sql = "SELECT * FROM SERBQ WHERE BQ001 LIKE '" + ls_no + "%' ORDER BY BQ001 DESC ";
        Query query = getEntityManager().createNativeQuery(sql);
        List result = query.getResultList();
        int m = 0;
        if (null != result && !result.isEmpty()) {
            m = result.size();
            m = m + 1;
        } else {
            m = 1;
        }
        serial = serial + m;
        serial = serial.substring(String.valueOf(m).length());
        ls_no += serial;
        return ls_no;
    }

    /**
     * @Author C2082 客诉单号生成，从数据表中获得数据格式
     * @param deptno
     * @param date
     * @return
     */
//    public StringBuffer getBQ001ByDeptAndDate2(String deptno, Date date) {
//
//        StringBuffer ls_no = new StringBuffer("");
//        String serial = "0000";
//        //部门前缀
//        if ("".equals(deptno)) {
//            return ls_no;
//        }
//        if (deptno.startsWith("5")) {
//            ls_no.append("KMKF");
//        } else {
//            switch (deptno.substring(0, 2)) {
//                case "1C":
//                    ls_no.append("HBKF");
//                    break;
//                case "1D":
//                    ls_no.append("HNKF");
//                    break;
//                case "1V":
//                    ls_no.append("CQKF");
//                    break;
//                case "1E":
//                    ls_no.append("NJKF");
//                    break;
//                default:
//                    ls_no.append("HDKF");
//                    break;
//            }
//        }
//        //年月日编码格式编码
//        // GB009    編碼方式        1:年編號、2:月編號、3:日編號
//        // GB010    流水號碼數      流水號碼數
//        // B011     年編方式        1.年編4碼、2.年編2碼
//        String sql1 = "SELECT GB009,GB010,GB011 FROM CRMGB  where GB001='k' AND GB008='Y' AND GB002 LIKE ?";
//        Query q = getEntityManager().createNativeQuery(sql1);
//        q.setParameter(1, ls_no.append("%").toString());
//        List<Object[]> result1 = q.getResultList();
//        //判断年编号的码数
//        if (result1.size() == 1) {
//            //序列数
//            StringBuffer serl = new StringBuffer("");
//            for (int i = 0; i < (int) result1.get(0)[1]; i++) {
//                serl = serl.append("0");
//            }
//
//            switch ((String) result1.get(0)[2]) {
//                case "1":
//                    ls_no.append(BaseLib.formatDate("yyyy", date));
//                    break;
//                case "2":
//                    ls_no.append(BaseLib.formatDate("yy", date));
//                    break;
//            }
//            switch ((String) result1.get(0)[0]) {
//                case "1":
//                    format.
//                    break;
//                case "2":
//                    ls_no.append(ls_no.append(BaseLib.formatDate("MM", date)));
//                    break;
//                case "3":
//                    ls_no.append(ls_no.append(BaseLib.formatDate("dd", date)));
//                    break;
//            }
//
//            //编码格式
//            ls_no = ls_no.append(serl);
//        }
//        return ls_no;
//    }
//
//    public String getSerl(int i, String s, String sim) {
//        SimpleDateFormat format = null;
//        //年编2码
//        if (i == 2) {
//            //判断是否当年或当月或当日
//            format = new SimpleDateFormat(sim);
//            
//        }
//    }
}
