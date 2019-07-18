/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.oa.app;

/**
 *
 * @author C0160
 */
public class KV {

    private String k;
    private String v;

    public KV() {

    }

    public KV(String k, String v) {
        this.k = k;
        this.v = v;
    }

    /**
     * @return the k
     */
    public String getK() {
        return k;
    }

    /**
     * @return the v
     */
    public String getV() {
        return v;
    }

    /**
     * @param k the k to set
     */
    public void setK(String k) {
        this.k = k;
    }

    /**
     * @param v the v to set
     */
    public void setV(String v) {
        this.v = v;
    }

}
