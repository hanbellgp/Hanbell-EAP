/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.war.rpt;

import cn.hanbell.eap.ejb.ArmbillBean;
import cn.hanbell.eap.entity.Armbill;
import cn.hanbell.eap.entity.ArmbillDetail;
import com.lightshell.comm.SuperMultiReportBean;
import java.util.List;

/**
 *
 * @author C0160
 */
public class BillPrintReport extends SuperMultiReportBean<ArmbillBean, Armbill, ArmbillDetail> {

    public BillPrintReport() {

    }

    @Override
    public List<ArmbillDetail> getDetail(Object o) throws Exception {
        this.superEJB.setDetail(o);
        return this.superEJB.getDetailList();
    }

    @Override
    public Armbill getEntity(int i) throws Exception {
        return this.superEJB.findById(i);
    }

}
