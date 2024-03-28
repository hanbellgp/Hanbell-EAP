/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.Qrcode;
import cn.hanbell.eap.entity.Qrcode;
import cn.hanbell.eap.entity.QrcodeDetail;
import cn.hanbell.eap.entity.QrcodeDetail;
import cn.hanbell.eap.entity.SystemProgram;
import cn.hanbell.eap.entity.SystemProgram;
import com.lightshell.comm.SuperEJB;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author C2082
 */
@Stateless
@LocalBean
public class QrcodeBean extends SuperEJBForEAP<Qrcode> {

    @EJB
    private SystemProgramBean systemProgramBean;

    @EJB
    QrcodeDetailBean qrcodeDetailBean;

    public QrcodeBean() {
        super(Qrcode.class);
    }

    public String getFormId(Date day) {
        SystemProgram sp = systemProgramBean.findBySystemAndAPI("HBEAP", "qrcodeprint");
        if (sp == null) {
            throw new NullPointerException("找不到应用接口_shipmentprint");
        }
        return super.getFormId(day, sp.getNolead(), sp.getNoformat(), sp.getNoseqlen());
    }

    public String initData(Qrcode e, List<QrcodeDetail> detailList) {
        if (e == null || detailList == null) {
            return null;
        }
        LinkedHashMap<SuperEJB, List<?>> detailAdded = new LinkedHashMap<>();
        detailAdded.put(qrcodeDetailBean, detailList);
        try {
            String formid = getFormId(e.getFormdate());
            e.setFormid(formid);
            for (QrcodeDetail d : detailList) {
                d.setPid(formid);
            }
            persist(e, detailAdded, null, null);
            return formid;
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<QrcodeDetail> getDetailList(String value) {
        return qrcodeDetailBean.findByPId(value);

    }
}
