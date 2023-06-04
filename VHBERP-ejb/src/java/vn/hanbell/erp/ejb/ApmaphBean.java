/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hanbell.erp.ejb;

import cn.hanbell.oa.ejb.ProcessCheckBean;
import cn.hanbell.oa.ejb.VHTV005Bean;
import cn.hanbell.oa.entity.ProcessCheck;
import cn.hanbell.oa.entity.VHTV005;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;
import vn.hanbell.erp.comm.SuperEJBForERP;
import vn.hanbell.erp.entity.Apmapd;
import vn.hanbell.erp.entity.Apmaph;

/**
 *
 * @author C1491
 */
@Stateless
@LocalBean
public class ApmaphBean extends SuperEJBForERP<Apmaph> {

    @EJB
    private ApmapdBean apmapdBean;
    @EJB
    private VHTV005Bean vhtv005Bean;
    @EJB
    private ProcessCheckBean processCheckBean;

    public ApmaphBean() {
        super(Apmaph.class);
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

    public Apmaph findByPK(String facno, String apno, String aptyp) {
        Query query = this.getEntityManager().createNamedQuery("Apmaph.findByPK");
        query.setParameter("facno", facno);
        query.setParameter("apno", apno);
        query.setParameter("aptyp", aptyp);
        return (Apmaph) query.getSingleResult();
    }

    public List<Apmapd> findApmapd(String facno, String apno) {
        apmapdBean.setCompany(facno);
        return apmapdBean.findByFacnoAndApno(facno, apno);
    }

    /**
     * 只更新ERP 费用类立账申请APM820表头状态
     *
     * @param psn 流程序号
     */
    public Boolean updateERPAPM820ByOAHKCW013(String psn, String status) {
        VHTV005 oah = vhtv005Bean.findByPSN(psn);
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
        //"3"流程完成, "1"流程撤销
        if ("3".equals(status)) {
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
        } else if ("1".equals(status)) {
            aph.setOano("");
            aph.setApsta("20");
            aph.setPzsta(' ');
        }
        update(aph);
        return true;
    }

}
