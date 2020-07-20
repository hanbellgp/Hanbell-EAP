/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.lazy;

import cn.hanbell.oa.entity.D50Z0009D0;
import cn.hanbell.oa.entity.HKGC001;
import cn.hanbell.oa.entity.HKGC001Detail;
import cn.hanbell.rpt.web.SuperLazyModel;
import com.lightshell.comm.SuperEJB;
import java.util.Iterator;

/**
 *
 * @author C2082
 */
public class HKGC001DetailModel extends SuperLazyModel<HKGC001Detail> {

    public HKGC001DetailModel(SuperEJB superEJB) {
        this.superEJB = superEJB;
    }

    @Override
    public HKGC001Detail getRowData(String rowKey) {
        if (this.dataList != null) {
            Iterator var2 = this.dataList.iterator();

            while (var2.hasNext()) {
                HKGC001Detail entity = (HKGC001Detail) var2.next();
                if (entity.getOid().equals(rowKey)) {
                    return entity;
                }
            }
        }

        return null;
    }

    @Override
    public Object getRowKey(HKGC001Detail object) {
        return super.getRowKey(object);
    }
}
