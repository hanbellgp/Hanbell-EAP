/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.efgp.rpt;

import cn.hanbell.oa.ejb.HSYPB004Bean;
import cn.hanbell.oa.entity.HSYPB004;
import cn.hanbell.oa.entity.HSYPB004Detail;
import cn.hanbell.util.SuperMultiReportBean;
import java.util.List;

/**
 *
 * @author C0160
 */
public class HSYPB004Report extends SuperMultiReportBean<HSYPB004Bean, HSYPB004, HSYPB004Detail> {

    @Override
    public List<HSYPB004Detail> getDetail(Object o) throws Exception {
        return superEJB.getDetailList(o.toString());
    }

    @Override
    public HSYPB004 getEntity(Object o) throws Exception {
        return superEJB.findByPSN(o);
    }

}
