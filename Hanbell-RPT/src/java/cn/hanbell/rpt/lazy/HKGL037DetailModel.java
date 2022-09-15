/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.lazy;

import cn.hanbell.oa.entity.HKGL037Detail;
import cn.hanbell.rpt.web.SuperLazyModel;
import com.lightshell.comm.SuperEJB;
import java.util.Iterator;

/**
 *
 * @author C1491
 */
public class HKGL037DetailModel extends SuperLazyModel<HKGL037Detail> {

    public HKGL037DetailModel(SuperEJB superEJB) {
        this.superEJB = superEJB;
    }

    @Override
    public HKGL037Detail getRowData(String rowKey) {
        if (this.dataList != null) {
            Iterator var2 = this.dataList.iterator();

            while (var2.hasNext()) {
                HKGL037Detail entity = (HKGL037Detail) var2.next();
                if (entity.getOid().equals(rowKey)) {
                    return entity;
                }
            }
        }

        return null;
    }

    @Override
    public Object getRowKey(HKGL037Detail object) {
        return super.getRowKey(object);
    }
}
