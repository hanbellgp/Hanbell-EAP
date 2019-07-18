/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.Shipment;
import cn.hanbell.eap.entity.ShipmentDetail;
import cn.hanbell.eap.entity.SystemProgram;
import com.lightshell.comm.SuperEJB;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author C0160
 */
@Stateless
@LocalBean
public class ShipmentBean extends SuperEJBForEAP<Shipment> {

    @EJB
    private SystemProgramBean systemProgramBean;

    @EJB
    private ShipmentDetailBean shipmentDetailBean;

    private List<ShipmentDetail> detailList;

    public ShipmentBean() {
        super(Shipment.class);
    }

    public String getFormId(Date day) {
        SystemProgram sp = systemProgramBean.findBySystemAndAPI("HBEAP", "shipmentprint");
        if (sp == null) {
            throw new NullPointerException("找不到应用接口_shipmentprint");
        }
        return super.getFormId(day, sp.getNolead(), sp.getNoformat(), sp.getNoseqlen());
    }

    public String initData(Shipment e, List<ShipmentDetail> detailList) {
        if (e == null || detailList == null) {
            return null;
        }
        LinkedHashMap<SuperEJB, List<?>> detailAdded = new LinkedHashMap<>();
        detailAdded.put(shipmentDetailBean, detailList);
        try {
            String formid = getFormId(e.getFormdate());
            e.setFormid(formid);
            for (ShipmentDetail d : detailList) {
                d.setPid(formid);
            }
            persist(e, detailAdded, null, null);
            return formid;
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void setDetail(Object value) {
        this.detailList = shipmentDetailBean.findByPId(value);
    }

    /**
     * @return the detailList
     */
    public List<ShipmentDetail> getDetailList() {
        return detailList;
    }

}
