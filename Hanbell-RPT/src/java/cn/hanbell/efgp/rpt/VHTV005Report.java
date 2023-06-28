/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.efgp.rpt;

import cn.hanbell.oa.ejb.VHTV005Bean;
import cn.hanbell.oa.entity.VHTV005;
import cn.hanbell.oa.entity.VHTV005Detail;
import cn.hanbell.util.SuperMultiReportBean;
import java.util.List;

/**
 *
 * @author C2082
 */
public class VHTV005Report extends SuperMultiReportBean<VHTV005Bean, VHTV005, VHTV005Detail> {

    @Override
    public List<VHTV005Detail> getDetail(Object o) throws Exception {
        return this.superEJB.getDetailList((String)o);
    }

    @Override
    public VHTV005 getEntity(Object o) throws Exception {
        return this.superEJB.findByPSN(o);
    }
    
}
