/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.edw.rpt;

import cn.hanbell.costctrl.app.Edw640QrcodeDetail;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author C2082
 */
public class Edw640QrcodePrint{


    public void initQrcode(List<Edw640QrcodeDetail> qrcodes,int height,int width, String filePath,String filename) throws Exception {
        for (Edw640QrcodeDetail qrcode : qrcodes) {
            this.generateQRCode(qrcode.getQrcodeContent(), height, width, filePath,String.format("%scode%s.png",filename,String.valueOf(qrcodes.indexOf(qrcode)+1)));
        }
    }
    
     public void initQrcode(String codecontent,int height,int width, String filePath,String filename) throws Exception {
          this.generateQRCode(codecontent, height, width,filePath, filename + "Qrcode.png");
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
            ex.printStackTrace();
        }
    }
}
