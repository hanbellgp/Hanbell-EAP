/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKJH001serial;
import cn.hanbell.oa.entity.HKYX011;
import cn.hanbell.oa.entity.HKYX013;
import cn.hanbell.oa.entity.HKYX014;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class HKYX014Bean extends SuperEJBForEFGP<HKYX014> {
    @EJB
    private HKJH001serialBean hkjh001serialBean;
    
    public HKYX014Bean() {
        super(HKYX014.class);
    }
    
    public boolean updateHKYX014(String psn) {
        HKYX014 h = findByPSN(psn);
        if (h == null) {
            throw new NullPointerException();
        }
        String quotationNo = h.getQuotationNo();
        if ("".equals(quotationNo)){
        String sealfacno = h.getSealfacno();
        Date applyDate = h.getApplyDate();
        String formatDate = cn.hanbell.util.BaseLib.formatDate("yyyy", applyDate);
        
        HKJH001serial hs = hkjh001serialBean.findByKind("QS");

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
        no = sealfacno + this.OD + "QS" + formatDate + no;
        h.setQuotationNo(no);
        this.update(h);
        serialno++;
        hs.setSerialno(serialno);
        hkjh001serialBean.update(hs);
        return true;
        }
        return false;
    }
}
