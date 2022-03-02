/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKGL031;
import cn.hanbell.oa.entity.HKJH001serial;
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
public class HKGL031Bean extends SuperEJBForEFGP<HKGL031>{
    
    @EJB
    private HKJH001serialBean hkjh001serialBean;
    
    public HKGL031Bean() {
        super(HKGL031.class);
    }
    public boolean updateHKGL031(String psn) {
        HKGL031 h = findByPSN(psn);
        if (h == null) {
            throw new NullPointerException();
        }
        String contractno = h.getContractno();
        if ("".equals(contractno)){
        
        String sealfacno = h.getSealfacno();
        String test1 = h.getTest1();
        Date createtime = h.getCreatetime();
        String formatDate = cn.hanbell.util.BaseLib.formatDate("yyyy", createtime);
        
        HKJH001serial hs = hkjh001serialBean.findByKind("SZ");

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
        no = sealfacno + this.CS + test1 + formatDate + no;
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
