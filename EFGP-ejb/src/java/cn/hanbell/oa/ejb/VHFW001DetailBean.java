/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.crm.ejb.REPTDBean;
import cn.hanbell.crm.entity.REPTD;
import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.VHFW001;
import cn.hanbell.oa.entity.VHFW001Detail;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author ZFF
 */
@Stateless
@LocalBean
public class VHFW001DetailBean extends SuperEJBForEFGP<VHFW001Detail> {

    @EJB
    private VHFW001Bean vhfw001Bean;
    @EJB
    private REPTDBean reptdBean;

    public VHFW001DetailBean() {
        super(VHFW001Detail.class);
    }

    public Boolean updateReptdByOAVHFW001(String psn) throws RuntimeException {
        try {
            VHFW001 ja = vhfw001Bean.findByPSN(psn);
            if (ja == null) {
                throw new NullPointerException();
            }
            reptdBean.setCompany(ja.getFacno());
            List<VHFW001Detail> details = this.findByFSN(ja.getFormSerialNumber());
            for (int i = 0; i < details.size(); i++) {
                VHFW001Detail detail = details.get(i);
                String td001 = detail.getTd001();
                String td002 = detail.getTd002();
                String td003 = detail.getTd003();
                REPTD td = reptdBean.findByPK(td001, td002, td003);
                td.setTd500(BigDecimal.valueOf(Double.valueOf(detail.getQty())));     //退货数量
                td.setTd502(detail.getFormSerialNumber());                            //OA单号  
                td.setTd043("Y");
                reptdBean.update(td);
            }

            return true;

        } catch (Exception ex) {
            Logger.getLogger(HZCW028Bean.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public Boolean rollbackReptdByOAVHFW001(String psn) throws RuntimeException {
        try {
            VHFW001 ja = vhfw001Bean.findByPSN(psn);
            if (ja == null) {
                throw new NullPointerException();
            }
            reptdBean.setCompany(ja.getFacno());
            List<VHFW001Detail> details = this.findByFSN(ja.getFormSerialNumber());
            for (int i = 0; i < details.size(); i++) {
                VHFW001Detail detail = details.get(i);
                String td001 = detail.getTd001();
                String td002 = detail.getTd002();
                String td003 = detail.getTd003();
                REPTD td = reptdBean.findByPK(td001, td002, td003);
                td.setTd043("N");
                reptdBean.update(td);
            }

            return true;

        } catch (Exception ex) {

            Logger.getLogger(HZCW028Bean.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
}
