/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.war.rpt;

import cn.hanbell.eap.ejb.ArmbillDetailForQueryBean;
import cn.hanbell.eap.entity.ArmbillDetailForQuery;
import com.lightshell.comm.SuperSingleReportBean;

/**
 *
 * @author C0160
 */
public class BillExportReport extends SuperSingleReportBean<ArmbillDetailForQueryBean, ArmbillDetailForQuery> {

    public BillExportReport() {
    }

    @Override
    public ArmbillDetailForQuery getEntity(int i) throws Exception {
        return this.superEJB.findById(i);
    }

}
