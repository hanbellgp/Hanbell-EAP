/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.app;

import cn.hanbell.eap.entity.QyWechatCardRecord;
import java.util.List;

/**
 *
 * @author C2082
 */
public class CardRecordListApplication {

    private List<QyWechatCardRecord> records;

    public List<QyWechatCardRecord> getRecords() {
        return records;
    }

    public void setRecords(List<QyWechatCardRecord> records) {
        this.records = records;
    }

 

    @Override
    public String toString() {
        return "CardRecordListApplication{" + "records=" + records + '}';
    }

}
