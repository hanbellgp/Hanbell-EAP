/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.efgp.rpt;

import cn.hanbell.oa.ejb.HKGL038Bean;
import cn.hanbell.oa.ejb.SHBERPAPM828Bean;
import cn.hanbell.oa.entity.HKGL038;
import cn.hanbell.oa.entity.HKGL038Detail;
import cn.hanbell.oa.entity.SHBERPAPM828;
import cn.hanbell.oa.entity.SHBERPAPM828Detail;
import cn.hanbell.util.SuperMultiReportBean;
import java.util.List;

/**
 *
 * @author C2082
 */
public class SHBERPAPM828Report extends SuperMultiReportBean<SHBERPAPM828Bean, SHBERPAPM828, SHBERPAPM828Detail>{

    @Override
    public List<SHBERPAPM828Detail> getDetail(Object o) throws Exception {
        return this.superEJB.getDetailList((String)o);
    }

    @Override
    public SHBERPAPM828 getEntity(Object o) throws Exception {
       return superEJB.findByPSN(o);
    }
    
}
