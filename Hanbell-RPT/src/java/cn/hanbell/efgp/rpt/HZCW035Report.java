/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.efgp.rpt;

import cn.hanbell.oa.ejb.HZCW035Bean;
import cn.hanbell.oa.entity.HZCW035;
import cn.hanbell.oa.entity.HZCW035Detail;
import cn.hanbell.util.SuperMultiReportBean;
import java.util.List;

/**
 *
 * @author C2082
 */
public class HZCW035Report extends SuperMultiReportBean<HZCW035Bean, HZCW035, HZCW035Detail>{
    
     public HZCW035Report() {

    }

    @Override
    public List<HZCW035Detail> getDetail(Object o) throws Exception {
       return this.superEJB.getDetailList(o);
    }

    @Override
    public HZCW035 getEntity(Object o) throws Exception {
       return superEJB.findByPSN(o);
    }
}
