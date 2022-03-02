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
public enum MessageEnum {

    SUCCESS(200, "处理成功"),
    Failue_101(101, "内部错误"),
    Failue_102(102, "授权码错误"),
    Failue_103(103, "授权码过期"),
    Failue_104(104, "没有数据"),
    Failue_105(105, "缺少关键参数"),
    Failue_106(106, "非法数据"),
    Failue_107(107, "无效数据"),
    Failue_108(108, "缺少权限"),
    Failue_109(109, "处理失败"),
    Failue_110(110, "无效请求"),
    Failue_111(111, "无效参数"),
    Failue_112(112, "缺少授权码"),
    Failue_113(113, "识别失败"),
    Failue_114(114, "账号不存在");

    private int code;
    private String msg;

    private MessageEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
