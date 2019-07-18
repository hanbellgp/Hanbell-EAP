/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.efgp.rpt;

import cn.hanbell.oa.ejb.WARMI05Bean;
import cn.hanbell.oa.entity.WARMI05;
import cn.hanbell.oa.entity.WARMI05Detail;
import cn.hanbell.util.SuperMultiReportBean;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class WARMI05Report extends SuperMultiReportBean<WARMI05Bean, WARMI05, WARMI05Detail> {

    public WARMI05Report() {

    }

    @Override
    public List<WARMI05Detail> getDetail(Object o) throws Exception {
        this.superEJB.setDetail(o);
        return this.superEJB.getDetailList();
    }

    @Override
    public WARMI05 getEntity(Object o) throws Exception {
        return this.superEJB.findByPSN(o);
    }

}
