/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.efgp.rpt;

import cn.hanbell.oa.ejb.HKGL039Bean;
import cn.hanbell.oa.entity.HKGL039;
import cn.hanbell.oa.entity.HKGL039Detail;
import cn.hanbell.util.SuperMultiReportBean;
import java.util.List;

/**
 *
 * @author C1587
 */
public class HKGL039Report extends SuperMultiReportBean<HKGL039Bean, HKGL039, HKGL039Detail> {

    public HKGL039Report() {

    }

    @Override
    public List<HKGL039Detail> getDetail(Object o) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.superEJB.setDetailList(o);
        return this.superEJB.getDetailList(o);
    }

    @Override
    public HKGL039 getEntity(Object o) throws Exception {
        return superEJB.findByPSN(o);
    }

}
