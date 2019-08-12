/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.efgp.rpt;

import cn.hanbell.oa.ejb.HZCW028Bean;
import cn.hanbell.oa.entity.HZCW028;
import cn.hanbell.oa.entity.HZCW028reDetail;
import cn.hanbell.oa.entity.HZCW028tDetail;
import cn.hanbell.util.SuperMultiReportBean;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class HZCW028Report extends SuperMultiReportBean<HZCW028Bean, HZCW028, HZCW028reDetail> {

    public HZCW028Report() {

    }

    @Override
    public List<HZCW028reDetail> getDetail(Object o) throws Exception {
        this.superEJB.setDetail(o);
        return this.superEJB.getDetailList(o);
    }

    @Override
    public HZCW028 getEntity(Object o) throws Exception {
        return this.superEJB.findByPSN(o);
    }

    public List<HZCW028tDetail> getTrafficDetail(Object o) {
        return this.superEJB.getTrafficDetail(o);
    }

}
