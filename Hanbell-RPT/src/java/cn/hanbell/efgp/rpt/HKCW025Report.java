/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.efgp.rpt;

import cn.hanbell.oa.ejb.HKCW025Bean;
import cn.hanbell.oa.entity.HKCW025;
import cn.hanbell.oa.entity.HKCW025Detail;
import cn.hanbell.util.SuperMultiReportBean;
import java.util.List;

/**
 *
 * @author C0160
 */
public class HKCW025Report extends SuperMultiReportBean<HKCW025Bean, HKCW025, HKCW025Detail> {

    public HKCW025Report() {

    }

    @Override
    public List<HKCW025Detail> getDetail(Object o) throws Exception {
        this.superEJB.setDetail(o);
        return this.superEJB.getDetailList(o);
    }

    @Override
    public HKCW025 getEntity(Object o) throws Exception {
        return this.superEJB.findByPSN(o);
    }

}
