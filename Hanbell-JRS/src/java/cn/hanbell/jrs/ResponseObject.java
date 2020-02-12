/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.jrs;

/**
 *
 * @author C0160
 * @param <T>
 */
public class ResponseObject<T> extends ResponseMessage {

    private T object;

    public ResponseObject() {

    }

    public ResponseObject(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseObject(String code, String msg, T t) {
        this.code = code;
        this.msg = msg;
        this.object = t;
    }

    /**
     * @return the object
     */
    public T getObject() {
        return object;
    }

    /**
     * @param object the object to set
     */
    public void setObject(T object) {
        this.object = object;
    }

}
