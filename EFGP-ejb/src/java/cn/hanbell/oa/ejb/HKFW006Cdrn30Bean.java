/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.ejb;

import cn.hanbell.oa.comm.SuperEJBForEFGP;
import cn.hanbell.oa.entity.HKFW006Cdrn30;
import cn.hanbell.oa.entity.HKFW006Cdrn30Detail;
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
public class HKFW006Cdrn30Bean extends SuperEJBForEFGP<HKFW006Cdrn30> {

    @EJB
    private HKFW006Cdrn30DetailBean hkfw006CDRN30DetailBean;
    private List<HKFW006Cdrn30Detail> detailList;

    public HKFW006Cdrn30Bean() {
        super(HKFW006Cdrn30.class);
    }

    public List<HKFW006Cdrn30Detail> getDetailList(String fsn) {
        this.detailList = hkfw006CDRN30DetailBean.findByFSN(fsn);
        return detailList;
    }

}
