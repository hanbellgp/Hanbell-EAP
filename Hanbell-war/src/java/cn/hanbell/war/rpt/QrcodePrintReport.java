/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.war.rpt;

import cn.hanbell.eap.ejb.QrcodeBean;
import cn.hanbell.eap.ejb.QrcodeDetailBean;
import cn.hanbell.eap.entity.Qrcode;
import cn.hanbell.eap.entity.QrcodeDetail;
import cn.hanbell.erp.ejb.CdrhadBean;
import cn.hanbell.war.control.ShipmentPrintManagedBean;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.lightshell.comm.SuperEJB;
import com.lightshell.comm.SuperMultiReportBean;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author C2082
 */
public abstract class QrcodePrintReport extends SuperMultiReportBean<QrcodeBean, Qrcode, QrcodeDetail> {

    @EJB
    private QrcodeDetailBean qrcodeDetailBean;
    
     @EJB
    public QrcodeBean qrcodeBean;

    @Override
    public List<QrcodeDetail> getDetail(Object o) throws Exception {
        return this.superEJB.getDetailList((String)o);
    }

    @Override
    public Qrcode getEntity(int i) throws Exception {
        Qrcode q=this.superEJB.findById(i);
        return q;
    }

    public void setEJB(QrcodeBean ejb){
        this.superEJB=ejb;
    }
        
    public void generateQRCode(String content, int width, int height, String filePath, String fileName) {
        try {
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            Map hints = new HashMap();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, width, height, hints);
            Path path = FileSystems.getDefault().getPath(filePath, fileName);
            MatrixToImageWriter.writeToPath(bitMatrix, "png", path);
        } catch (WriterException | IOException ex) {
            Logger.getLogger(ShipmentPrintManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public abstract void initQrcode(Object o,Object appResPath) throws Exception;
}
