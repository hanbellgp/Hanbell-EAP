/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.efgp.rpt;

import cn.hanbell.oa.ejb.HKGL038Bean;
import cn.hanbell.oa.entity.HKGL038;
import cn.hanbell.oa.entity.HKGL038Detail;
import cn.hanbell.util.SuperMultiReportBean;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class HKGL038Report extends SuperMultiReportBean<HKGL038Bean, HKGL038, HKGL038Detail> {

    public HKGL038Report() {

    }

    @Override
    public List<HKGL038Detail> getDetail(Object o) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.superEJB.setDetail(o);
        return this.superEJB.getDetailList(o);
    }

    @Override
    public HKGL038 getEntity(Object o) throws Exception {
        return superEJB.findByPSN(o);
    }

}
