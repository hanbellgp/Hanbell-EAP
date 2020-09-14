/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.app;


import cn.hanbell.eap.entity.WechatClock;
import java.util.List;

/**
 *
 * @author C2082
 */
public class CardRecordListApplication {

    private List<WechatClock> records;

    public List<WechatClock> getRecords() {
        return records;
    }

    public void setRecords(List<WechatClock> records) {
        this.records = records;
    }

 

    @Override
    public String toString() {
        return "CardRecordListApplication{" + "records=" + records + '}';
    }

}
