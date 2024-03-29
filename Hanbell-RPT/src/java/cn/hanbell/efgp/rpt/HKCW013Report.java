/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.efgp.rpt;

import cn.hanbell.oa.ejb.HKCW013Bean;
import cn.hanbell.oa.entity.HKCW013;
import cn.hanbell.oa.entity.HKCW013Detail;
import cn.hanbell.util.SuperMultiReportBean;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author C2082
 */
public class HKCW013Report extends SuperMultiReportBean<HKCW013Bean, HKCW013, HKCW013Detail> {

    @Override
    public HKCW013 getEntity(Object o) throws Exception {
        return this.superEJB.findByPSN(o);
    }

    @Override
    public void setEJB(String JNDIName) throws NamingException {
        super.setEJB(JNDIName);
    }

    @Override
    public List<HKCW013Detail> getDetail(Object o) throws Exception {
        return this.superEJB.getDetailList((String) o);
    }

}
