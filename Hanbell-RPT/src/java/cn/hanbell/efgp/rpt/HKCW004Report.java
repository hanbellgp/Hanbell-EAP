/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.efgp.rpt;

import cn.hanbell.oa.ejb.HKCW004Bean;
import cn.hanbell.oa.entity.HKCW004;
import cn.hanbell.oa.entity.HKCW004Detail;
import cn.hanbell.util.SuperMultiReportBean;
import java.util.List;

/**
 *
 * @author C2082
 */
public class HKCW004Report extends SuperMultiReportBean<HKCW004Bean, HKCW004, HKCW004Detail>{

    @Override
    public List<HKCW004Detail> getDetail(Object o) throws Exception {
        this.superEJB.setDetail(o);
        return this.superEJB.getDetailList();
    }

    @Override
    public HKCW004 getEntity(Object o) throws Exception {
      return this.superEJB.findByPSN(o);
    }
    
}
