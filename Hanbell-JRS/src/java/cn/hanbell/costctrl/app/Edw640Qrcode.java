/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.costctrl.app;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C2082
 */
@XmlRootElement
public class Edw640Qrcode {

    private List<Edw640QrcodeDetail> qrcodes;

    public List<Edw640QrcodeDetail> getQrcodes() {
        return qrcodes;
    }

    public void setQrcodes(List<Edw640QrcodeDetail> qrcodes) {
        this.qrcodes = qrcodes;
    }
   

}
