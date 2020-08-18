/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.efgp.rpt;

import cn.hanbell.oa.ejb.QTCCW005Bean;
import cn.hanbell.oa.entity.QTCCW005;
import cn.hanbell.oa.entity.QTCCW005Detail;
import cn.hanbell.util.SuperMultiReportBean;
import java.util.List;

/**
 *
 * @author C2082
 */
public class QTCCW005Report extends SuperMultiReportBean<QTCCW005Bean, QTCCW005, QTCCW005Detail>{

    @Override
    public List<QTCCW005Detail> getDetail(Object o) throws Exception {
       this.superEJB.setDetailList(o);
        return this.superEJB.getDetailList();
    }

    @Override
    public QTCCW005 getEntity(Object o) throws Exception {
        return this.superEJB.findByPSN(o);
    }
    
}
