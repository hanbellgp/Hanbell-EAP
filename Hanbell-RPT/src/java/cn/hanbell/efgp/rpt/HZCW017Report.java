/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.efgp.rpt;

import cn.hanbell.oa.ejb.HZCW017Bean;
import cn.hanbell.oa.entity.HZCW017;
import cn.hanbell.util.SuperSingleReportBean;
import javax.naming.NamingException;

/**
 *
 * @author C1879
 */
public class HZCW017Report extends SuperSingleReportBean<HZCW017Bean, HZCW017> {

    public HZCW017Report() {

    }

    @Override
    public void setEJB(String JNDIName) throws NamingException {
        super.setEJB(JNDIName);
    }

    @Override
    public HZCW017 getEntity(Object o) throws Exception {
        return this.superEJB.findByPSN(o);
    }

}
