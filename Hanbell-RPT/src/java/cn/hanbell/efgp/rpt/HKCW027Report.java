/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.efgp.rpt;

import cn.hanbell.oa.ejb.HKCW027Bean;
import cn.hanbell.oa.entity.HKCW027;
import cn.hanbell.oa.entity.HKCW027Detail;
import cn.hanbell.util.SuperMultiReportBean;
import java.util.List;

/**
 *
 * @author C0160
 */
public class HKCW027Report extends SuperMultiReportBean<HKCW027Bean, HKCW027, HKCW027Detail> {

    public HKCW027Report() {

    }

    @Override
    public List<HKCW027Detail> getDetail(Object o) throws Exception {
        return this.superEJB.getDetailList(o);
    }

    @Override
    public HKCW027 getEntity(Object o) throws Exception {
        return this.superEJB.findByPSN(o);
    }

}
