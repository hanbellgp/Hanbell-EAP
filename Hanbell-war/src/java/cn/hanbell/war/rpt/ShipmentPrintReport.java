/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.war.rpt;

import cn.hanbell.eap.ejb.ShipmentBean;
import cn.hanbell.eap.entity.Shipment;
import cn.hanbell.eap.entity.ShipmentDetail;
import com.lightshell.comm.SuperMultiReportBean;
import java.util.List;

/**
 *
 * @author C0160
 */
public class ShipmentPrintReport extends SuperMultiReportBean<ShipmentBean, Shipment, ShipmentDetail> {

    public ShipmentPrintReport() {

    }

    @Override
    public List<ShipmentDetail> getDetail(Object o) throws Exception {
        this.superEJB.setDetail(o);
        return this.superEJB.getDetailList();
    }

    @Override
    public Shipment getEntity(int i) throws Exception {
        return this.superEJB.findById(i);
    }

}
