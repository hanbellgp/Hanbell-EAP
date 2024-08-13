/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.QrcodeDetail;
import cn.hanbell.eap.entity.QrcodeDetail;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author C2082
 */
@Stateless
@LocalBean
public class QrcodeDetailBean extends SuperEJBForEAP<QrcodeDetail>{
    
    public QrcodeDetailBean() {
        super(QrcodeDetail.class);
    }
    
}
