/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKGL031;
import cn.hanbell.oa.entity.HKJH001serial;
import cn.hanbell.oa.entity.HKJH005;
import cn.hanbell.oa.entity.HKJH005Detail;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Administrator
 */
@Stateless
@LocalBean
public class HKJH005Bean extends SuperEJBForEFGP<HKJH005> {
    
    @EJB
    private HKJH001serialBean hkjh001serialBean;
    
    @EJB
    private HKJH005DetailBean hkjh005DetailBean;

    public HKJH005Bean() {
        super(HKJH005.class);
    }

    public List<HKJH005Detail> getDetailList(String fsn) {
        return hkjh005DetailBean.findByFSN(fsn);
    }

    public boolean updateHKJH005(String psn) {
        HKJH005 h = findByPSN(psn);
        if (h == null) {
            throw new NullPointerException();
        }
        String contractno = h.getContractno();
        if ("".equals(contractno)){
        String sealfacno = h.getSealfacno();
        Date applydate = h.getApplydate();
        String formatDate = cn.hanbell.util.BaseLib.formatDate("yyyy", applydate);
        
        HKJH001serial hs = hkjh001serialBean.findByKind("XJ");

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
        no = sealfacno + this.SS + "XJ" + formatDate + no;
        h.setContractno(no);
        this.update(h);
        serialno++;
        hs.setSerialno(serialno);
        hkjh001serialBean.update(hs);
        return true;
        }
        return false;
    }
}
