/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.jrs;

import java.util.List;

/**
 *
 * @author C0160
 * @param <T>
 */
public class ResponseInfo<T> extends ResponseMessage {

    protected String data;

    public ResponseInfo() {

    }

    public ResponseInfo(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    
}
