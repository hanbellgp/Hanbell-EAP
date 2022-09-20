/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.costctrl.app;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Date;
import java.util.Formatter;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.annotation.XmlRootElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Administrator
 */
@XmlRootElement
public class HmacSha1Signature {
    
    private final Logger log4j = LogManager.getLogger("cn.hanbell.eap");
    private String appid;
    private long time_stamp;
    private String sign;
    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
    private static final String KEY = "vXn925Fs87taW9zZwQc4enTwqsLxPrDiGUjDh6VBA4iAw0ZSgAzq7YJhjZJ30abc";
    private static final Integer MINUTE = 600;
    private static final String MATCHID = "53300001";
    
    public HmacSha1Signature() {
    }
    
    public HmacSha1Signature(String appid, long time_stamp, String sign) {
        this.appid = appid;
        this.sign = sign;
        this.time_stamp = time_stamp;
    }
    
    private static String toHexString(byte[] bytes) {
        Formatter formatter = new Formatter();
        for (byte b : bytes) {
            formatter.format("%02x", b);
        }
        return formatter.toString();
    }
    
    public static String calculateRFC2104HMAC(String data, String key) throws SignatureException, NoSuchAlgorithmException, InvalidKeyException {
        SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), HMAC_SHA1_ALGORITHM);
        Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
        mac.init(signingKey);
        return toHexString(mac.doFinal(data.getBytes()));
    }
    
    public boolean checkSign() {
        try {
            if (!appid.equals(MATCHID)) {
                return false;
            }
            long n = new Date().getTime();
            int minutes = (int) ((n - time_stamp) / (1000 * 60));
            if (minutes > MINUTE || minutes < -60) {
                return false;
            }
            String lsign = HmacSha1Signature.calculateRFC2104HMAC(appid + time_stamp, KEY);
            if (!sign.endsWith(lsign)) {
                return false;
            }
        } catch (InvalidKeyException | NoSuchAlgorithmException | SignatureException e) {
            log4j.error("授权验证失败！");
            return false;
        }
        return true;
    }
    
    public MCResponseData getBySign(String appid, long t, String sign) {
        int code = 200;
        String msg = "授权验证成功";
        if (!appid.equals(MATCHID)) {
            code = 102;
            msg = "授权码错误";
        }
        long n = new Date().getTime();
        int minutes = (int) ((n - t) / (1000 * 60));
        if (minutes > MINUTE || minutes < 0) {
            code = 103;
            msg = "授权码过期";
        }
        try {
            String lsign = HmacSha1Signature.calculateRFC2104HMAC(appid + t, KEY);
            if (!sign.endsWith(lsign)) {
                code = 113;
                msg = "识别失败";
            }
            
        } catch (InvalidKeyException | NoSuchAlgorithmException | SignatureException e) {
            code = 113;
            msg = "识别失败";
        }
        return new MCResponseData(code, msg);
    }
    
    public String getAppid() {
        return appid;
    }
    
    public void setAppid(String appid) {
        this.appid = appid;
    }
    
    public long getTime_stamp() {
        return time_stamp;
    }
    
    public void setTime_stamp(long time_stamp) {
        this.time_stamp = time_stamp;
    }
    
    public String getSign() {
        return sign;
    }
    
    public void setSign(String sign) {
        this.sign = sign;
    }
    
}
