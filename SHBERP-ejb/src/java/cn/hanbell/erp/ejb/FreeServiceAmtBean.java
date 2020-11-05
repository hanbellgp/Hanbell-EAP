/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.crm.comm.SuperEJBForCRM;
import cn.hanbell.crm.ejb.REPTCBean;
import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.FreeServiceAmt;
import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.ejb.HKFW005Bean;
import cn.hanbell.oa.ejb.HKFW006Bean;
import com.lightshell.comm.BaseLib;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.Query;

/**
 *
 * @author C1749
 */
@Stateless
@LocalBean
public class FreeServiceAmtBean extends SuperEJBForERP<FreeServiceAmt> {

    @EJB
    InvhadBean invhadBean;
    @EJB
    InvtrnhBean invtrnhBean;
    @EJB
    REPTCBean reptcBean;
    @EJB
    HKFW005Bean hKFW005Bean;
    @EJB
    HKFW006Bean hKFW006Bean;
    @EJB
    CdrlnhadBean cdrlnhadBean;

    public FreeServiceAmtBean() {
        super(FreeServiceAmt.class);
    }

    private List<FreeServiceAmt> getFreeServiceAmtList(int y, int m) {
        List<FreeServiceAmt> data = new ArrayList();
        List temp = reptcBean.getCRMList(y, m);
        BigDecimal gcpamt, gcramt, drpamt, drramt, travelamt, trafficamt;
        try {
            if (temp != null) {
                for (Object o : temp) {
                    Object[] row = (Object[]) o;
                    FreeServiceAmt fa = new FreeServiceAmt();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = sdf.parse(row[0].toString().substring(0, 4) + "-" + row[0].toString().substring(4, 6) + "-" + row[0].toString().substring(6, 8));
                    fa.setCrdate(date);
                    fa.setCasenumber(row[1] != null ? row[1].toString() : "");
                    fa.setUserno(row[2] != null ? row[2].toString() : "");
                    fa.setUserna(row[3] != null ? row[3].toString() : "");
                    fa.setDeptno(row[4] != null ? row[4].toString() : "");
                    fa.setDeptna(row[5] != null ? row[5].toString() : "");
                    fa.setItntypeno(row[6] != null ? row[6].toString() : "");
                    fa.setItntypena(row[7] != null ? row[7].toString() : "");
                    fa.setVarnr(row[8] != null ? row[8].toString() : "");
                    fa.setItnbrcus(row[9] != null ? row[9].toString() : "");
                    fa.setCusno(row[10] != null ? row[10].toString() : "");
                    fa.setCusna(row[11] != null ? row[11].toString() : "");
                    fa.setJudge(row[12] != null ? row[12].toString() : "");
                    fa.setCharge(row[13] != null ? row[13].toString() : "");
                    fa.setIswarranty(row[14] != null ? row[14].toString() : "");
                    fa.setAscriptiondept(row[15] != null ? row[15].toString() : "");
                    fa.setReason(row[16] != null ? row[16].toString() : "");
                    fa.setRepairnumber(row[17] != null ? row[17].toString() : "");
                    fa.setRepairuserno(row[18] != null ? row[18].toString() : "");
                    fa.setRepairuserna(row[19] != null ? row[19].toString() : "");
                    fa.setRepairdeptno(row[20] != null ? row[20].toString() : "");
                    fa.setRepairdeptna(row[21] != null ? row[21].toString() : "");
                    if (row[17] != null) {
                        //ERP的客诉领料
                        gcpamt = invhadBean.getInvtrnhTramt(row[17].toString(), "('1001','1013')");
                        //ERP的客诉退料
                        gcramt = invhadBean.getInvtrnhTramt(row[17].toString(), "('1002','1014')");
                        //ERP的拆修领料
                        drpamt = invhadBean.getInvtrnhTramt(row[17].toString(), "('1003')");
                        //ERP的拆修退料
                        drramt = invhadBean.getInvtrnhTramt(row[17].toString(), "('1004')");
                        //CRM的差旅费
                        travelamt = reptcBean.getCRMTravelamt(row[17].toString());
                        //OA的HKFW005的运费
                        BigDecimal trafficamt1 = hKFW005Bean.getOAHKFW005TrafficAmt(row[17].toString());
                        BigDecimal trafficamt2 = hKFW006Bean.getOAHKFW006TrafficAmt(row[17].toString());
                        BigDecimal trafficamt3 = cdrlnhadBean.getERPTrafficamtAmt(row[17].toString());
                        trafficamt = trafficamt1.add(trafficamt2).add(trafficamt3);
                        fa.setGcpamt(gcpamt);
                        fa.setGcramt(gcpamt);
                        fa.setDrpamt(drpamt);
                        fa.setDrramt(drramt);
                        fa.setTravelamt(travelamt);
                        fa.setTrafficamt(trafficamt);
                        fa.setTotalamt(gcpamt.add(gcramt).add(drpamt).add(drramt).add(travelamt).add(trafficamt));
                    } else {
                        fa.setGcpamt(BigDecimal.ZERO);
                        fa.setGcramt(BigDecimal.ZERO);
                        fa.setDrpamt(BigDecimal.ZERO);
                        fa.setDrramt(BigDecimal.ZERO);
                        fa.setTravelamt(BigDecimal.ZERO);
                        fa.setTrafficamt(BigDecimal.ZERO);
                        fa.setTotalamt(BigDecimal.ZERO);
                    }
                    data.add(fa);
                }
            }
            return data;
        } catch (ParseException ex) {
            log4j.error("FreeServiceAmtBean类的getFreeServiceAmtList()方法 Exception", ex);
        }
        return null;
    }

    /**
     * @description 保存到ERP的FreeServiceAmt表中
     * @param y
     * @param m
     */
    public void updateFreeServiceAmt(int y, int m) {
        List<FreeServiceAmt> data = getFreeServiceAmtList(y, m);
        try {
            if (!data.isEmpty()) {
                //先删除当月数据
                setCompany("C");
                String sql = "DELETE from freeserviceamt where year(crdate) = "+y+" and month(crdate) =" + m;
                this.getEntityManager().createNativeQuery(sql).executeUpdate();
                //再从新跟新一版数据
                for (FreeServiceAmt f : data) {
                    persist(f);
                }
            }
        } catch (Exception ex) {
            log4j.error("FreeServiceAmtBean类的updateFreeServiceAmt()方法 Exception", ex);
        }
    }

    public List<FreeServiceAmt> findQueryList(String casenumber, String repairnumber, String userna, String deptna, String itntypeno, String judge, String charge, String iswarranty, String begin, String end) {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT * FROM freeserviceamt f WHERE f.crdate BETWEEN '").append(begin).append("' AND '").append(end).append("'");
        if (!"".equals(casenumber) && casenumber != null) {
            sb.append(" and casenumber like '%").append(casenumber).append("%'");
        }
        if (!"".equals(repairnumber) && repairnumber != null) {
            sb.append(" and repairnumber like '%").append(repairnumber).append("%'");
        }
        if (!"".equals(userna) && userna != null) {
            sb.append(" and userna like '%").append(userna).append("%'");
        }
        if (!"".equals(deptna) && deptna != null) {
            sb.append(" and deptna like '%").append(deptna).append("%'");
        }
        if (!"".equals(itntypeno) && itntypeno != null) {
            sb.append(" and itntypeno = '").append(itntypeno).append("'");
        }
        if (!"".equals(judge) && judge != null) {
            sb.append(" and judge = '").append(judge).append("'");
        }
        if (!"".equals(charge) && charge != null) {
            sb.append(" and charge = '").append(charge).append("'");
        }
        if (!"".equals(iswarranty) && iswarranty != null) {
            sb.append(" and iswarranty = '").append(iswarranty).append("'");
        }
        try {
            Query query = getEntityManager().createNativeQuery(sb.toString(), FreeServiceAmt.class);
            List<FreeServiceAmt> data = query.getResultList();
            return data;
        } catch (Exception ex) {
            return null;
        }
    }

}
