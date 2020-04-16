/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.efgp.rpt;

import cn.hanbell.oa.ejb.HZCW033Bean;
import cn.hanbell.oa.entity.HZCW033;
import cn.hanbell.oa.entity.HZCW033reDetail;
import cn.hanbell.oa.entity.HZCW033tDetail;
import cn.hanbell.util.SuperMultiReportBean;
import java.util.List;

/**
 *
 * @author C2082
 */
public class HZCW033Report extends SuperMultiReportBean<HZCW033Bean, HZCW033, HZCW033reDetail> {

    public HZCW033Report() {

    }

    @Override
    public List<HZCW033reDetail> getDetail(Object o) throws Exception {
        return this.superEJB.getDetailList(o);
    }

    @Override
    public HZCW033 getEntity(Object o) throws Exception {
        return this.superEJB.findByPSN(o);
    }

    public List<HZCW033tDetail> getTrafficDetail(Object o) {
        return this.superEJB.getTrafficDetail(o);
    }

}
