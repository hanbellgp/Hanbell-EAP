/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.jrs;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author C0160
 */
public class ResponseMessage {

    protected String code;
    protected String msg;
    protected Map<String, Object> extData;

    public ResponseMessage() {
        extData = new HashMap<>();
    }

    public ResponseMessage(String code, String msg) {
        this();
        this.code = code;
        this.msg = msg;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @return the extData
     */
    public Map<String, Object> getExtData() {
        return extData;
    }

}
