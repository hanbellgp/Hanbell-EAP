/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.efgp.rpt;

import cn.hanbell.oa.ejb.HKCW026Bean;
import cn.hanbell.oa.entity.HKCW026;
import cn.hanbell.oa.entity.HKCW026Detail;
import cn.hanbell.util.SuperMultiReportBean;
import java.util.List;

/**
 *
 * @author C0160
 */
public class HKCW026Report extends SuperMultiReportBean<HKCW026Bean, HKCW026, HKCW026Detail> {

    public HKCW026Report() {

    }

    @Override
    public List<HKCW026Detail> getDetail(Object o) throws Exception {
       
        return this.superEJB.getDetailList(o);
    }

    @Override
    public HKCW026 getEntity(Object o) throws Exception {
        return this.superEJB.findByPSN(o);
    }

}
