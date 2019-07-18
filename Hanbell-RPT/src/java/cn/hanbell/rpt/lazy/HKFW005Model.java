/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.lazy;

import cn.hanbell.oa.entity.HKFW005;
import cn.hanbell.rpt.web.SuperLazyModel;
import com.lightshell.comm.SuperEJB;

/**
 *
 * @author C0160
 */
public class HKFW005Model extends SuperLazyModel<HKFW005> {

    public HKFW005Model(SuperEJB superEJB) {
        this.superEJB = superEJB;
    }

    @Override
    public HKFW005 getRowData(String rowKey) {
        if (dataList != null) {
            for (HKFW005 entity : dataList) {
                if (entity.getOid().equals(rowKey)) {
                    return entity;
                }
            }
        }
        return null;
    }

    @Override
    public Object getRowKey(HKFW005 t) {
        return t.getOid();
    }

}
