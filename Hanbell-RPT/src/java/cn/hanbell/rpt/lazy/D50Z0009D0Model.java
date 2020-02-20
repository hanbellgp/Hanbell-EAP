/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.lazy;

import cn.hanbell.oa.entity.D50Z0009D0;
import cn.hanbell.rpt.web.SuperLazyModel;
import com.lightshell.comm.SuperEJB;
import java.util.Iterator;

/**
 *
 * @author C2082
 */
public class D50Z0009D0Model extends SuperLazyModel<D50Z0009D0> {
    public D50Z0009D0Model(SuperEJB superEJB) {
        this.superEJB = superEJB;
    }

    public D50Z0009D0 getRowData(String rowKey) {
        if (this.dataList != null) {
            Iterator var2 = this.dataList.iterator();

            while(var2.hasNext()) {
                D50Z0009D0 entity = (D50Z0009D0)var2.next();
                if (entity.getOid().equals(rowKey)) {
                    return entity;
                }
            }
        }

        return null;
    }

    public Object getRowKey(D50Z0009D0 object) {
        return super.getRowKey(object);
    }
}

