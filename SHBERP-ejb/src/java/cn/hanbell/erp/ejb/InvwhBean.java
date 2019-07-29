/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.erp.ejb;

import cn.hanbell.erp.comm.SuperEJBForERP;
import cn.hanbell.erp.entity.Invwh;
import cn.hanbell.erp.entity.Invwhclk;
import cn.hanbell.erp.entity.InvwhclkPK;
import cn.hanbell.oa.ejb.SHBERPINV150Bean;
import cn.hanbell.oa.entity.SHBERPINV150;
import cn.hanbell.oa.entity.SHBERPINV150Detail;
import java.util.Date;
import java.util.List;
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
public class InvwhBean extends SuperEJBForERP<Invwh> {

    @EJB
    private SHBERPINV150Bean shberpinv150Bean;
    @EJB
    private InvwhclkBean invwhclkBean;

    public InvwhBean() {
        super(Invwh.class);
    }

    public Invwh findByWareh(String wareh) {
        Query query = getEntityManager().createNamedQuery("Invwh.findByWareh");
        query.setParameter("wareh", wareh);
        try {
            Object o = query.getSingleResult();
            return (Invwh) o;
        } catch (Exception ex) {
            return null;
        }
    }

    public String getMinWareh(String facno, String prono) {
        StringBuilder sb = new StringBuilder();
        String wareh;
        sb.append("SELECT  Min(wareh)  from invwh where facno = '").append(facno).append("' AND prono = '").append(prono).append("' AND costyn= 'Y' ");
        Query query = getEntityManager().createNativeQuery(sb.toString());
        try {
            return (String) query.getSingleResult();
        } catch (Exception ex) {
            throw new RuntimeException("资料库查询库号发生错误！");
        }
    }

    public Boolean initByOASHBERPINV150(String psn) {
        String facno;
        String prono;
        String userno;
        Date indate;
        SHBERPINV150 h = shberpinv150Bean.findByPSN(psn);
        if (h == null) {
            throw new NullPointerException();
        }
        List<SHBERPINV150Detail> details = shberpinv150Bean.getDetailList(h.getFormSerialNumber());
        if (details.size() > 0) {
            facno = h.getFacno();
            prono = h.getProductplace();
            userno = h.getApplyUser();
            indate = h.getApplyDate();
            this.setCompany(facno);
            invwhclkBean.setCompany(facno);
            try {
                //表身循环
                for (int i = 0; i < details.size(); i++) {
                    SHBERPINV150Detail detail = details.get(i);
                    if (null == this.findByWareh(detail.getWareh())) {
                        Invwh w = new Invwh();
                        w.setFacno(facno);
                        if ("".equals(prono)) {
                            w.setProno("1");
                        } else {
                            w.setProno(prono);
                        }
                        w.setWareh(detail.getWareh());
                        w.setWhdsc(detail.getWhdsc());
                        w.setMrpco(detail.getHdnmrpco().charAt(0));
                        w.setCostyn(detail.getHdnCostyn().charAt(0));
                        w.setWclerk(detail.getWclerkTxt());
                        w.setUserno(userno);
                        w.setIndate(indate);
                        persist(w);
                        Invwhclk wc = new Invwhclk();
                        InvwhclkPK wcpk = new InvwhclkPK();
                        wcpk.setFacno(facno);
                        wcpk.setProno(prono);
                        wcpk.setWareh(detail.getWareh());
                        wcpk.setWclerk(detail.getWclerkTxt());
                        wc.setInvwhclkPK(wcpk);
                        wc.setIndate(indate);
                        wc.setMainyn('Y');
                        wc.setUserno(userno);
                        invwhclkBean.persist(wc);

                    }
                }
                return true;
            } catch (Exception ex) {
                Logger.getLogger(InvwhBean.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException(ex);
            }
        } else {
            throw new NullPointerException();
        }

    }

}
