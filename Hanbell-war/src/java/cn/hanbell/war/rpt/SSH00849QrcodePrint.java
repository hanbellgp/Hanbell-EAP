/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.war.rpt;

import cn.hanbell.eap.entity.QrcodeDetail;

/**
 *
 * @author C2082
 */
public class SSH00849QrcodePrint extends QrcodePrintReport{

    @Override
    public void initQrcode(Object o, Object appResPath) throws Exception {
         for (QrcodeDetail entity :  getDetail(o)) {
           this.generateQRCode(entity.getContent7(), 200, 200, (String)appResPath, entity.getPid() + entity.getSeq() + "Qrcode.png");
        }
    }
    
}
