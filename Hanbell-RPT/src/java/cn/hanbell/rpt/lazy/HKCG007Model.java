/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.lazy;

import cn.hanbell.oa.entity.D50Z0009D0;
import cn.hanbell.oa.entity.HKCG007;
import cn.hanbell.oa.entity.HKFW005;
import cn.hanbell.rpt.web.SuperLazyModel;
import com.lightshell.comm.SuperEJB;
import java.util.Iterator;

/**
 *
 * @author C2082
 */
public class HKCG007Model extends SuperLazyModel<HKCG007> {

    public HKCG007Model(SuperEJB superEJB) {
        this.superEJB = superEJB;
    }

    public HKCG007 getRowData(String rowKey) {
        if (this.dataList != null) {
            Iterator var2 = this.dataList.iterator();

            while (var2.hasNext()) {
                HKCG007 entity = (HKCG007) var2.next();
                if (entity.getOid().equals(rowKey)) {
                    return entity;
                }
            }
        }

        return null;
    }

    public Object getRowKey(HKCG007 object) {
        return super.getRowKey(object);
    }
}
