/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.lazy;

import cn.hanbell.crm.entity.CMSMV;
import cn.hanbell.rpt.web.SuperLazyModel;
import com.lightshell.comm.SuperEJB;
import java.util.Iterator;

/**
 *
 * @author C0160
 */
public class CMSMVModel extends SuperLazyModel<CMSMV> {

    public CMSMVModel(SuperEJB sessionBean) {
        this.superEJB = sessionBean;
    }

    @Override
    public CMSMV getRowData(String rowKey) {
        if (this.dataList != null) {
            Iterator var2 = this.dataList.iterator();
            while (var2.hasNext()) {
                CMSMV entity = (CMSMV) var2.next();
                if (entity.getMv001().toString().equals(rowKey)) {
                    return entity;
                }
            }
        }
        return null;
    }
}
