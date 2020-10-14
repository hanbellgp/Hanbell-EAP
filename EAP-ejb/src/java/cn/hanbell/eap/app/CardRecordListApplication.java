/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.app;


import cn.hanbell.eap.entity.WeChatClock;
import java.util.List;

/**
 *
 * @author C2082
 */
public class CardRecordListApplication {

    private List<WeChatClock> records;

    public List<WeChatClock> getRecords() {
        return records;
    }

    public void setRecords(List<WeChatClock> records) {
        this.records = records;
    }

 

    @Override
    public String toString() {
        return "CardRecordListApplication{" + "records=" + records + '}';
    }

}
