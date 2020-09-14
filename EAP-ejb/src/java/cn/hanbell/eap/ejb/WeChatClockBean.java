/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.ejb;

import cn.hanbell.eap.comm.SuperEJBForEAP;
import cn.hanbell.eap.entity.WeChatClock;
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
public class WeChatClockBean extends SuperEJBForEAP<WeChatClock> {

    public WeChatClockBean() {
        super(WeChatClock.class);
    }

    public boolean hasExistPersist(WeChatClock qy) {
        StringBuffer sql = new StringBuffer("SELECT * FROM wechatclock where userid='");
        sql.append(qy.getUserid()).append("' and checkintime='").append(qy.getCheckintime()).append("'");
        sql.append(" and locationtitle='").append(qy.getLocationtitle()).append("' and locationdetail='").append(qy.getLocationdetail()).append("'");
        Query query = getEntityManager().createNativeQuery(sql.toString(), WeChatClock.class);
        try {
            List<WeChatClock> list = query.getResultList();
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
