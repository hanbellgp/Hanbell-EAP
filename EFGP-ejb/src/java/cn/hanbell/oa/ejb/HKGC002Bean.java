/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKGC001;
import cn.hanbell.oa.entity.HKGC001Detail;
import cn.hanbell.oa.entity.HKGC002;
import cn.hanbell.oa.model.HKGC002Model;
import cn.hanbell.util.BaseLib;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class HKGC002Bean extends SuperEJBForEFGP<HKGC002> {

    @EJB
    private HKGC001Bean hkgc001Bean;
    @EJB
    private HKGC001DetailBean hkgc001DetailBean;
    @EJB
    private WorkFlowBean workFlowBean;

    public HKGC002Bean() {
        super(HKGC002.class);
    }

    public HKGC002 findBySrcno(String srcno) {
        Query query = getEntityManager().createNamedQuery("HKGC002.findBySrcno");
        query.setParameter("srcno", srcno);
        try {
            Object o = query.getSingleResult();
            return (HKGC002) o;
        } catch (Exception ex) {
            return null;
        }
    }

    public String initByHKGC001(String psn) {
        HKGC001 e = hkgc001Bean.findByPSN(psn);
        if (e == null) {
            throw new NullPointerException();
        }
        hkgc001Bean.setDetail(e.getFormSerialNumber(), "Y");
        if (hkgc001Bean.getDetailList() == null || hkgc001Bean.getDetailList().isEmpty()) {
            return "204";
        }
        try {
            for (HKGC001Detail d : hkgc001Bean.getDetailList()) {
                if (d.getTransno() != null && !"".equals(d.getTransno())) {
                    continue;
                }
                HKGC002 t = this.findBySrcno(d.getOid());
                if (t != null) {
                    continue;
                }
                HKGC002Model m = new HKGC002Model();
                m.setFacno(e.getFacno());
                m.setApplyUser(e.getApplyUser());
                m.setApplyDept(e.getApplyDept());
                m.setApplyDate(e.getApplyDate());
                m.setApplyneed(e.getApplyneed());
                m.setItnbrf(d.getItnbrf());
                m.setItnbrfname(d.getItnbrfname());
                m.setQty(d.getQty());
                if (d.getNeeddate() != null) {
                    m.setNeeddate(BaseLib.getDate("yyyy/MM/dd", d.getNeeddate()));
                }
                m.setItnbr(d.getItnbr());
                m.setItnbrname(d.getItnbrname());
                if (d.getMancode() != null && !"".equals(d.getMancode())) {
                    m.setSupportUser(d.getMancode());
                }
                m.setSrcno(d.getOid());
                //重新初始化流程发起人员
                workFlowBean.initUserInfo(e.getApplyUser());
                String formInstance = workFlowBean.buildXmlForEFGP("HK_GC002", m, null);
                String subject = "研发工作支援单_" + e.getProcessSerialNumber();
                String msg = workFlowBean.invokeProcess(workFlowBean.hostAdd, workFlowBean.hostPort, "PKG_HK_GC002", formInstance, subject);
                String[] rm = msg.split("\\$");
                if (rm != null && rm.length == 2 && rm[0].equals("200")) {
                    //更新状态
                    d.setTransno(rm[1]);
                    hkgc001DetailBean.update(d);
                }
            }
            return "200";
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

}
