/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.efgp.rpt;

import cn.hanbell.oa.ejb.HZCW034Bean;
import cn.hanbell.oa.entity.HZCW034;
import cn.hanbell.oa.entity.HZCW034Detail;
import cn.hanbell.util.SuperMultiReportBean;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class HZCW034Report extends SuperMultiReportBean<HZCW034Bean, HZCW034, HZCW034Detail> {

    public HZCW034Report() {

    }

    @Override
    public List<HZCW034Detail> getDetail(Object o) throws Exception {
        return this.superEJB.getDetailList(o);
    }

    @Override
    public HZCW034 getEntity(Object o) throws Exception {
        return superEJB.findByPSN(o);
    }

}
