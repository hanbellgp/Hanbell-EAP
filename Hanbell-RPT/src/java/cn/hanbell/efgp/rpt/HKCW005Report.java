/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.efgp.rpt;

import cn.hanbell.oa.ejb.HKCW005Bean;
import cn.hanbell.oa.entity.HKCW005;
import cn.hanbell.oa.entity.HKCW005Detail;
import cn.hanbell.util.SuperMultiReportBean;
import java.util.List;

/**
 *
 * @author C2082
 */
public class HKCW005Report extends SuperMultiReportBean<HKCW005Bean, HKCW005, HKCW005Detail>{

    @Override
    public List<HKCW005Detail> getDetail(Object o) throws Exception {
      this.superEJB.setDetail(o);
        return this.superEJB.getDetailList();
    }

    @Override
    public HKCW005 getEntity(Object o) throws Exception {
          return this.superEJB.findByPSN(o);
    }
    
}
