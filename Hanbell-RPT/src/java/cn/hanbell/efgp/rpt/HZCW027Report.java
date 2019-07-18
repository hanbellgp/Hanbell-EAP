/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.efgp.rpt;

import cn.hanbell.oa.ejb.HZCW027Bean;
import cn.hanbell.oa.entity.HZCW027;
import cn.hanbell.oa.entity.HZCW027Detail;
import cn.hanbell.util.SuperMultiReportBean;
import java.util.List;

/**
 *
 * @author C0160
 */
public class HZCW027Report extends SuperMultiReportBean<HZCW027Bean, HZCW027, HZCW027Detail> {

    public HZCW027Report() {

    }

    @Override
    public List<HZCW027Detail> getDetail(Object o) throws Exception {
        this.superEJB.setDetail(o);
        return this.superEJB.getDetailList();
    }

    @Override
    public HZCW027 getEntity(Object o) throws Exception {
        return this.superEJB.findByPSN(o);
    }

}
