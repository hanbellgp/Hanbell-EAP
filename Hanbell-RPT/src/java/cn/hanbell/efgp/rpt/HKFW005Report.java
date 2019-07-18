/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.efgp.rpt;

import cn.hanbell.oa.ejb.HKFW005Bean;
import cn.hanbell.oa.entity.HKFW005;
import cn.hanbell.oa.entity.HKFW005Detail;
import cn.hanbell.util.SuperMultiReportBean;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class HKFW005Report extends SuperMultiReportBean<HKFW005Bean,HKFW005,HKFW005Detail>{

    
    public HKFW005Report(){}
    
    @Override
    public List<HKFW005Detail> getDetail(Object o) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.superEJB.setDetail(o);
        return this.superEJB.getDetailList();
    }

    @Override
    public HKFW005 getEntity(Object o) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return this.superEJB.findByPSN(o);
    }
    
    
    
}
