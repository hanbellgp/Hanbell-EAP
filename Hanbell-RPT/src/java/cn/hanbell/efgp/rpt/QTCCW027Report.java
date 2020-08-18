/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.efgp.rpt;

import cn.hanbell.oa.ejb.QTCCW027Bean;
import cn.hanbell.oa.entity.QTCCW027;
import cn.hanbell.oa.entity.QTCCW027Detail;
import cn.hanbell.util.SuperMultiReportBean;
import java.util.List;

/**
 *
 * @author C2082
 */
public class QTCCW027Report extends SuperMultiReportBean<QTCCW027Bean, QTCCW027, QTCCW027Detail>{

    @Override
    public List<QTCCW027Detail> getDetail(Object o) throws Exception {
         this.superEJB.setDetail(o);
        return this.superEJB.getDetailList();
    }

    @Override
    public QTCCW027 getEntity(Object o) throws Exception {
         return this.superEJB.findByPSN(o);
    }
    
}
