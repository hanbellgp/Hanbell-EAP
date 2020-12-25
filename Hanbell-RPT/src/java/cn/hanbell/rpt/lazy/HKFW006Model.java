/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.lazy;

import cn.hanbell.oa.entity.HKFW006;
import cn.hanbell.rpt.web.SuperLazyModel;
import com.lightshell.comm.SuperEJB;

/**
 *
 * @author C2082
 */
public class HKFW006Model extends SuperLazyModel<HKFW006> {

    public HKFW006Model(SuperEJB superEJB) {
        this.superEJB = superEJB;
    }

    @Override
    public HKFW006 getRowData(String rowKey) {
        if (dataList != null) {
            for (HKFW006 entity : dataList) {
                if (entity.getOid().equals(rowKey)) {
                    return entity;
                }
            }
        }
        return null;
    }

    @Override
    public Object getRowKey(HKFW006 t) {
        return t.getOid();
    }
}
