/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.efgp.rpt;

import cn.hanbell.oa.ejb.ZQ001Bean;
import cn.hanbell.oa.entity.ZQ001;
import cn.hanbell.oa.entity.ZQ001Detail;
import cn.hanbell.util.SuperMultiReportBean;
import java.util.List;

/**
 *
 * @author C2082
 */
public class ZQ001Report extends SuperMultiReportBean<ZQ001Bean, ZQ001, ZQ001Detail>{

    @Override
    public List<ZQ001Detail> getDetail(Object o) throws Exception {
        this.superEJB.setDetail(o);
        return this.superEJB.getDetailList();
    }

    @Override
    public ZQ001 getEntity(Object o) throws Exception {
      return this.superEJB.findByPSN(o);
    }
    
}
