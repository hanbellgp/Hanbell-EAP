/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.crm.ejb.REPTCBean;
import cn.hanbell.crm.entity.REPTC;
import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKFW005;
import cn.hanbell.oa.entity.HKFW005Detail;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class HKFW005Bean extends SuperEJBForEFGP<HKFW005> {

    @EJB
    private HKFW005DetailBean hkfw005DetailBean;
    @EJB
    private REPTCBean reptcBean;

    private List<HKFW005Detail> detailList;

    public HKFW005Bean() {
        super(HKFW005.class);
    }

    //更新CRM-REPTC货运单号
    public Boolean updateReptdByOAHKFW005(String psn) {
        try {
            HKFW005 h = this.findByPSN(psn);
            if (h == null) {
                throw new NullPointerException("获取OA流程异常！");
            }
            String fwno = h.getFwno();
            if (fwno.length() > 4) {
                String tc001 = fwno.substring(0, 4);
                String tc002 = fwno.substring(4);
                REPTC reptc = reptcBean.findByPK(tc001, tc002);
                if (reptc != null) {
                    String hyno = h.getHyno();
                    if (!"".equals(hyno)) {
                        //优先将货运单号写入TC503，如此栏位有值，往后栏位写
                        if (reptc.getTc503() == null || "".equals(reptc.getTc503())) {
                            reptc.setTc503(hyno);
                        } else if (reptc.getTc504() == null || "".equals(reptc.getTc504())) {
                            reptc.setTc504(hyno);
                        } else if (reptc.getTc505() == null || "".equals(reptc.getTc505())) {
                            reptc.setTc505(hyno);
                        } else if (reptc.getTc506() == null || "".equals(reptc.getTc506())) {
                            reptc.setTc506(hyno);
                        } else if (reptc.getTc507() == null || "".equals(reptc.getTc507())) {
                            reptc.setTc504(hyno);
                        } else if (reptc.getTc508() == null || "".equals(reptc.getTc508())) {
                            reptc.setTc508(hyno);
                        }
                        reptcBean.update(reptc);
                    }
                }
            } else {
                throw new NullPointerException("服务单号异常！");
            }
            return true;

        } catch (Exception ex) {
            Logger.getLogger(HKFW005Bean.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    //运输方式
    public String getYsStyleName(String ysstyle) {
        switch (ysstyle) {
            case "1":
                return "快递";
            case "2":
                return "服务部货运";
            case "3":
                return "资材部货运";
            case "4":
                return "自提";
            case "5":
                return "专车";
            default:
                return "";
        }
    }

    /**
     *
     * @param kfno
     * @return 工作支援单运费和快递费
     */
    public List getTansportExpense(String kfno) {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT 'tansportexpense' as type ,N'OA服务支援单' as  sources,kfno,fwno,applyuser as userno,userName as userna  ");
        sb.append("  ,applydept as deptno,organizationUnitName as deptna, CONVERT(varchar(100), shpdate, 112) as occurdate, ");
        sb.append(" (CASE type WHEN '1' THEN '零件支援' WHEN '2' THEN '整机支援'WHEN '1' THEN '维修支援'WHEN '1' THEN '提货' ELSE '' END ) as expensetype, ");
        sb.append(" ysstyle as custom1,cusno as custom2,cusna as custom3, shpno as custom4,isnull(total,0) as 'expense' , ");
        sb.append("  mark as remark1,SerialNumber as sourcesno FROM HK_FW005 fw LEFT OUTER JOIN Users s on s.id=applyuser ");
        sb.append("  LEFT OUTER JOIN OrganizationUnit o on o.id=applydept WHERE kfno = '${kfno}' ");
        try {
            String sql = sb.toString().replace("${kfno}", kfno);
            Query query = getEntityManager().createNativeQuery(sql);
            List list = query.getResultList();
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     *
     * @param fwno
     * @return 工作支援单运费和快递费
     */
    public BigDecimal getOAHKFW005TrafficAmt(String fwno) {
        StringBuilder sb = new StringBuilder();
        BigDecimal amt;
        sb.append(" select isnull(sum(total),0) as total from HK_FW005 WHERE fwno = '${fwno}' ");
        try {
            String sql = sb.toString().replace("${fwno}", fwno);
            Query query = getEntityManager().createNativeQuery(sql);
            Object o = query.getSingleResult();
            amt = BigDecimal.valueOf(Double.valueOf(o.toString()));
            return amt;
        } catch (NumberFormatException e) {
            return BigDecimal.ZERO;
        }
    }

    @Override
    public void setDetail(Object value) {
        this.detailList = hkfw005DetailBean.findByFSN(value); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the detailList
     */
    public List<HKFW005Detail> getDetailList() {
        return detailList;
    }

    /**
     * @param detailList the detailList to set
     */
    public void setDetailList(List<HKFW005Detail> detailList) {
        this.detailList = detailList;
    }

    public List<HKFW005Detail> getDetailList(String fsn) {
        return hkfw005DetailBean.findByFSN(fsn);
    }

}
