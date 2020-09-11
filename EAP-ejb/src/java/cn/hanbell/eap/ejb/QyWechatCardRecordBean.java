/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.QyWechatCardRecord;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author C2082
 */
@Stateless
@LocalBean
public class QyWechatCardRecordBean extends SuperEJBForEAP<QyWechatCardRecord> {

    public QyWechatCardRecordBean() {
        super(QyWechatCardRecord.class);
    }

    public boolean hasExistPersist(QyWechatCardRecord qy) {
        StringBuffer sql = new StringBuffer("SELECT * FROM qywechatcardrecord where userid='");
        sql.append(qy.getUserid()).append("' and checkintime='").append(qy.getCheckintime()).append("'");
        sql.append(" and locationtitle='").append(qy.getLocationtitle()).append("' and locationdetail='").append(qy.getLocationdetail()).append("'");
        Query query = getEntityManager().createNativeQuery(sql.toString(), QyWechatCardRecord.class);
        try {
            List<QyWechatCardRecord> list = query.getResultList();
            if (list == null || list.isEmpty()) {
                return false;
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return true;
        }
    }

}
