/*
 * To change this license header, choose License Headers in Project Properties. To change this template file, choose
 * Tools | Templates and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Accacr;
import cn.hanbell.erp.entity.Accsped;
import cn.hanbell.erp.entity.Apmapd;
import cn.hanbell.erp.entity.Apmaph;
import cn.hanbell.erp.entity.Invpri;
import cn.hanbell.oa.ejb.HKCW013Bean;
import cn.hanbell.oa.ejb.ProcessCheckBean;
import cn.hanbell.oa.ejb.SHBERPAPM811Bean;
import cn.hanbell.oa.ejb.SHBERPAPM828Bean;
import cn.hanbell.oa.entity.HKCW013;
import cn.hanbell.oa.entity.ProcessCheck;
import cn.hanbell.oa.entity.SHBERPAPM811;
import cn.hanbell.oa.entity.SHBERPAPM828;
import cn.hanbell.util.BaseLib;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
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
public class ApmaphBean extends SuperEJBForERP<Apmaph> {

    @EJB
    private ApmapdBean apmapdBean;
    @EJB
    private InvpriBean invpriBean;
    @EJB
    private AccacrBean accacrBean;
    @EJB
    private AccspedBean accspedBean;

    @EJB
    private SHBERPAPM811Bean shberpapm811Bean;
    @EJB
    private SHBERPAPM828Bean shberpapm828Bean;
    @EJB
    private HKCW013Bean hkcw013Bean;
    @EJB
    private ProcessCheckBean processCheckBean;

    private List<Apmapd> apmapdList;

    public ApmaphBean() {
        super(Apmaph.class);
    }

    public Apmaph findByPK(String facno, String apno, String aptyp) {
        Query query = this.getEntityManager().createNamedQuery("Apmaph.findByPK");
        query.setParameter("facno", facno);
        query.setParameter("apno", apno);
        query.setParameter("aptyp", aptyp);
        return (Apmaph) query.getSingleResult();
    }

    public List<Apmaph> findNeedThrow(String aptyp) {
        Query query
                = this.getEntityManager().createNamedQuery("Apmaph.findNeedThrow").setFirstResult(0).setMaxResults(1);
        query.setParameter("aptyp", aptyp);
        return query.getResultList();
    }

    public List<Apmapd> findNeedThrowDetail(String facno, String apno, String aptyp) {
        apmapdBean.setCompany(facno);
        return apmapdBean.findNeedThrowDetail(facno, apno, aptyp);
    }

    public List<Apmapd> findApmapd(String facno, String apno) {
        apmapdBean.setCompany(facno);
        return apmapdBean.findByFacnoAndApno(facno, apno);
    }

    public Boolean rollApmtbil(String psn) {
        SHBERPAPM811 oah = shberpapm811Bean.findByPSN(psn);
        if (oah == null) {
            throw new NullPointerException();
        }
        String facno = oah.getFacno();
        String apno = oah.getApno();
        String aptyp = oah.getAptyp();
        this.setCompany(facno);
        Apmaph erph;
        erph = this.findByPK(facno, apno, aptyp);
        if (erph.getApsta().equals("25")) {
            erph.setOano("");
            erph.setApsta("10");
            erph.setPzsta(' ');
            update(erph);
        }
        return true;

    }

    /**
     * 只更新ERP APM828表头状态
     *
     * @param psn 流程序号
     */
    public Boolean updateByOAAPM828(String psn) {
        SHBERPAPM828 oah = shberpapm828Bean.findByPSN(psn);
        if (oah == null) {
            throw new NullPointerException(psn);
        }
        String facno = oah.getFacno();
        String apno = oah.getApno();
        String aptyp = oah.getAptyp();
        this.setCompany(facno);
        Apmaph aph = findByPK(facno, apno, aptyp);
        if (aph == null || !aph.getApsta().equals("25")) {
            throw new NullPointerException(apno);
        }
        aph.setApsta("20");
        // 更新apusrno,cfmusrno为OA审核人
        aph.setOano(oah.getProcessSerialNumber().substring(4));
        List<ProcessCheck> processList;
        processList = processCheckBean.findByPSN(psn);
        for (ProcessCheck pc : processList) {
            if (pc.getWorkItemName().contains("直属主管") || pc.getWorkItemName().contains("课长")) {
                aph.setApusrno(pc.getUserID());
            }
            if (pc.getWorkItemName().contains("经理级") && !pc.getWorkItemName().contains("总经理级")) {
                aph.setCfmusrno(pc.getUserID());
            }
        }
        update(aph);
        return true;
    }

    /**
     * 只更新ERP 费用类立账申请APM820表头状态
     *
     * @param psn 流程序号
     */
    public Boolean updateERPAPM820ByOAHKCW013(String psn) {
        HKCW013 oah = hkcw013Bean.findByPSN(psn);
        if (oah == null) {
            throw new NullPointerException(psn);
        }
        String facno = oah.getFacno();
        String apno = oah.getApno();
        String aptyp = "0";     //费用类立账申请
        this.setCompany(facno);
        Apmaph aph = findByPK(facno, apno, aptyp);
        if (aph == null || !aph.getApsta().equals("25")) {
            throw new NullPointerException(apno);
        }
        aph.setApsta("20");
        // 更新apusrno,cfmusrno为OA审核人
        aph.setOano(oah.getProcessSerialNumber().substring(4));
        List<ProcessCheck> processList;
        processList = processCheckBean.findByPSN(psn);
        for (ProcessCheck pc : processList) {
            if (pc.getWorkItemName().contains("直属主管") || pc.getWorkItemName().contains("课长")) {
                aph.setApusrno(pc.getUserID());
            }
            if (pc.getWorkItemName().contains("经理级") && !pc.getWorkItemName().contains("总经理级")) {
                aph.setCfmusrno(pc.getUserID());
            }
        }
        update(aph);
        return true;
    }

    public boolean checkValueyn(String facno, String rkd) {
        accacrBean.setCompany(facno);
        accspedBean.setCompany(facno);
        int l_row, l_acrcount;
        List<Accacr> accacrList = accacrBean.findBySysnoAndKindAndRkd("APM", "71", rkd);
        List<Accsped> accspedList = accspedBean.findByConfig((short) 52);
        l_row = 1;
        if (null == accacrList || accacrList.isEmpty()) {
            l_acrcount = 0;
            l_row = 1;
        } else {
            l_acrcount = accacrList.size();
            for (l_row = 1; l_row < accacrList.size(); l_row++) {
                String accno = accacrList.get(l_row - 1).getAccno();
                for (Accsped sped : accspedList) {
                    if (accno.equals(sped.getAccspedPK().getAccno())) {
                        break;
                    }
                }
            }
        }
        if (l_row > l_acrcount) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkExistqty(String facno, String itnbr, String preyrmth, Date startdate, Date endDate) {
        BigDecimal ldc_unittotqy;
        int llcount;
        StringBuilder sb = new StringBuilder();
        invpriBean.setCompany(facno);
        Invpri invpri = invpriBean.findByPK(facno, preyrmth, itnbr);
        if (null == invpri || null == invpri.getUnittotqy() || "".equals(invpri.getUnittotqy())) {
            ldc_unittotqy = BigDecimal.ZERO;
        } else {
            ldc_unittotqy = invpri.getUnittotqy();
        }
        if (ldc_unittotqy.compareTo(BigDecimal.ZERO) > 0) {
            return true;
        }

        sb.append("select count(*)  from invtrn h,invwh w  where h.facno = w.facno and h.prono = w.prono ");
        sb.append(" and h.wareh = w.wareh and w.costyn = 'Y' and h.facno = '").append(facno)
                .append("' and h.trdate >= '").append(BaseLib.formatDate("yyyyMMdd", startdate))
                .append("' and h.trdate < '").append(BaseLib.formatDate("yyyyMMdd", endDate)).append("' and h.itnbr = '")
                .append(itnbr).append("' and h.trtype in (select trntp from cstrul where facno = '").append(facno)
                .append("' and kseq = 30 and iocode = '1' and avgco = 'Y')");
        Query query = getEntityManager().createNativeQuery(sb.toString());
        try {
            llcount = (int) query.getSingleResult();
            if (llcount > 0) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public List<Apmapd> getApmapdList() {
        return apmapdList;
    }

    public void setApmapdList(List<Apmapd> apmapdList) {
        this.apmapdList = apmapdList;
    }

}
