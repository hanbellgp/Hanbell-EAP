/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.efgp.rpt;

import cn.hanbell.oa.ejb.HKFW006Bean;
import cn.hanbell.oa.entity.HKFW006;
import cn.hanbell.oa.entity.HKFW006Detail;
import cn.hanbell.util.SuperMultiReportBean;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class HKFW006Report extends SuperMultiReportBean<HKFW006Bean,HKFW006,HKFW006Detail>{

    
    public HKFW006Report(){}
    
    @Override
    public List<HKFW006Detail> getDetail(Object o) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.superEJB.setDetail(o);
        return this.superEJB.getDetailList();
    }

    @Override
    public HKFW006 getEntity(Object o) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return this.superEJB.findByPSN(o);
    }
    
    
    
}
