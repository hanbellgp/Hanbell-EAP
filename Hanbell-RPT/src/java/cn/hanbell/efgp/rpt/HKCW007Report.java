/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.efgp.rpt;

import cn.hanbell.oa.ejb.HKCW007Bean;
import cn.hanbell.oa.entity.HKCW007;
import cn.hanbell.util.SuperSingleReportBean;
import javax.naming.NamingException;

/**
 *
 * @author C2082
 */
public class HKCW007Report extends SuperSingleReportBean<HKCW007Bean, HKCW007> {

    public HKCW007Report() {}

    @Override
    public HKCW007 getEntity(Object o) throws Exception {
        return this.superEJB.findByPSN(o);
    }

    @Override
    public void setEJB(String JNDIName) throws NamingException {
        super.setEJB(JNDIName);
    }

}
