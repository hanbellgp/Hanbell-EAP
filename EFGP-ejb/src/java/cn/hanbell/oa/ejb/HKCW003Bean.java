/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.crm.ejb.REPMFBean;
import cn.hanbell.crm.entity.REPMF;
import cn.hanbell.crm.entity.REPMFPK;
import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKCW003;
import cn.hanbell.oa.entity.HKCW003Detail;
import cn.hanbell.util.BaseLib;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class HKCW003Bean extends SuperEJBForEFGP<HKCW003> {

    @EJB
    private HKCW003DetailBean hkcw003DetailBean;
    @EJB
    private REPMFBean repmfBean;

    public HKCW003Bean() {
        super(HKCW003.class);
    }

    public List<HKCW003Detail> getDetailList(String fsn) {
        return hkcw003DetailBean.findByFSN(fsn);
    }

    public Boolean initByOAHKCW003(String psn) {
        HKCW003 h = this.findByPSN(psn);
        if (h == null) {
            throw new NullPointerException();
}
        repmfBean.setCompany(h.getFacno());
        List<HKCW003Detail> details = this.getDetailList(h.getFormSerialNumber());
        try {
            //表身循环
            for (int i = 0; i < details.size(); i++) {
                HKCW003Detail detail = details.get(i);
                REPMF repmf = repmfBean.findByItnbr(detail.getItnbr());
                if (repmf != null) {
                    if ("".equals(detail.getCost()) && "".equals(detail.getAsscost())) {
                    } else if (!"".equals(detail.getCost())) {
                        repmf.setMf003(BigDecimal.valueOf(Double.parseDouble(detail.getCost())));
                    } else if (!"".equals(detail.getAsscost()) && "".equals(detail.getCost())) {
                        repmf.setMf003(BigDecimal.valueOf(Double.parseDouble(detail.getAsscost())));
                    }
                    repmf.setMf004(BaseLib.formatDate("yyyyMMdd", h.getApplydate()));
                    repmfBean.update(repmf);
                } else if (repmf == null) {
                    REPMF m = new REPMF();
                    String mf001 = detail.getItnbr();
                    String mf002 = detail.getUnmsr1();
                    String mf005 = BaseLib.formatDate("yyyyMMdd", h.getApplydate());
                    String mf009 = "RMB";
                    REPMFPK pk = new REPMFPK();
                    pk.setMf001(mf001);
                    pk.setMf002(mf002);
                    pk.setMf005(mf005);
                    pk.setMf009(mf009);
                    m.setREPMFPK(pk);
                    if ("".equals(detail.getCost()) && "".equals(detail.getAsscost())) {
                        m.setMf003(BigDecimal.ZERO);
                    } else if (!"".equals(detail.getCost())) {
                        m.setMf003(BigDecimal.valueOf(Double.parseDouble(detail.getCost())));
                    } else if (!"".equals(detail.getAsscost()) && "".equals(detail.getCost())) {
                        m.setMf003(BigDecimal.valueOf(Double.parseDouble(detail.getAsscost())));
                    }
                    m.setMf004(BaseLib.formatDate("yyyyMMdd", h.getApplydate()));
                    m.setMf007("OA抛转" + h.getProcessSerialNumber());
                    m.setMf008("N");
                    repmfBean.persist(m);
                }
            }
            return true;
        } catch (Exception ex) {
            Logger.getLogger(HKCW003Bean.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
