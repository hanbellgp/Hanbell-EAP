/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.costctrl.app;

/**
 *
 * @author Administrator
 */
public class MCResponsePageData<T> extends MCResponseData {

    private int has_more;
    private int total_count;

    public MCResponsePageData() {
    }

    public MCResponsePageData(MCResponseData rs) {

    }

    public MCResponsePageData(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getHas_more() {
        return has_more;
    }

    public void setHas_more(int has_more) {
        this.has_more = has_more;
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }
}
