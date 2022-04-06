/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.lazy;

import cn.hanbell.eap.entity.SystemUser;
import cn.hanbell.rpt.web.SuperLazyModel;
import com.lightshell.comm.SuperEJB;
import java.util.Iterator;

/**
 *
 * @author C0160
 */
public class SystemUserModel extends SuperLazyModel<SystemUser> {

    public SystemUserModel(SuperEJB sessionBean) {
        this.superEJB = sessionBean;
    }
  @Override
    public SystemUser getRowData(String rowKey) {
        if (this.dataList != null) {
            Iterator var2 = this.dataList.iterator();
            while (var2.hasNext()) {
                SystemUser entity = (SystemUser) var2.next();
                if (entity.getId().toString().equals(rowKey)) {
                    return entity;
                }
            }
        }
        return null;
    }
}