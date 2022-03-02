/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.lazy;

import cn.hanbell.oa.entity.HKFW005Detail;
import cn.hanbell.rpt.web.SuperLazyModel;
import com.lightshell.comm.SuperEJB;
import java.util.Iterator;

/**
 *
 * @author C1491
 */
public class HKFW005DetailModel extends SuperLazyModel<HKFW005Detail> {

    public HKFW005DetailModel(SuperEJB superEJB) {
        this.superEJB = superEJB;
    }

    @Override
    public HKFW005Detail getRowData(String rowKey) {
        if (this.dataList != null) {
            Iterator var2 = this.dataList.iterator();

            while (var2.hasNext()) {
                HKFW005Detail entity = (HKFW005Detail) var2.next();
                if (entity.getOid().equals(rowKey)) {
                    return entity;
                }
            }
        }

        return null;
    }

    @Override
    public Object getRowKey(HKFW005Detail object) {
        return super.getRowKey(object);
    }
}
