/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.war.rpt;

import cn.hanbell.eap.entity.Qrcode;
import cn.hanbell.eap.entity.QrcodeDetail;
import java.util.List;

/**
 *
 * @author C2082
 */
public class SGD00933QrcodePrint extends QrcodePrintReport {

    public SGD00933QrcodePrint() {
    }
    
    @Override
    public void initQrcode(Object o,Object appResPath) throws Exception {
        for (QrcodeDetail entity :  getDetail(o)) {
            this.initQrcode(entity.getQrcode(), entity,(String)appResPath);
        }
    }

    public void initQrcode(Qrcode qrcode, QrcodeDetail detail,String appResPath) throws Exception {
        this.generateQRCode(detail.getContent9(), 200, 200, appResPath, qrcode.getFormid() + detail.getSeq() + "Qrcode1.png");
        this.generateQRCode(detail.getContent6(), 200,  200, appResPath, qrcode.getFormid() + detail.getSeq() + "Qrcode2.png");
    }

}
