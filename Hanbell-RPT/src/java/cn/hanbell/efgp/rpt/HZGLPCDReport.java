/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.efgp.rpt;

import cn.hanbell.oa.ejb.HZGLPCDBean;
import cn.hanbell.oa.entity.HZGLPCD;
import cn.hanbell.oa.entity.HZGLPCDDetail;
import cn.hanbell.util.SuperMultiReportBean;
import java.util.List;

/**
 *
 * @author C0160
 */
public class HZGLPCDReport extends SuperMultiReportBean<HZGLPCDBean, HZGLPCD, HZGLPCDDetail> {

    public HZGLPCDReport() {

    }

    @Override
    public List<HZGLPCDDetail> getDetail(Object o) throws Exception {
        this.superEJB.setDetail(o);
        return this.superEJB.getDetailList();
    }

    @Override
    public HZGLPCD getEntity(Object o) throws Exception {
        return this.superEJB.findByPSN(o);
    }

}
