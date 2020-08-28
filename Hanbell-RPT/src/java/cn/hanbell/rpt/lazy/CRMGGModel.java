/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.rpt.lazy;

import cn.hanbell.crm.entity.CRMGG;
import cn.hanbell.rpt.web.SuperLazyModel;
import com.lightshell.comm.SuperEJB;
import java.util.Iterator;

/**
 *
 * @author C2082
 */
public class CRMGGModel extends SuperLazyModel<CRMGG> {

    public CRMGGModel(SuperEJB superEJB) {
        this.superEJB = superEJB;
    }

    @Override
    public CRMGG getRowData(String rowKey) {
        if (this.dataList != null) {
            Iterator var2 = this.dataList.iterator();
            while (var2.hasNext()) {
                CRMGG entity = (CRMGG) var2.next();
                if (entity.getGg001().toString().equals(rowKey)) {
                    return entity;
                }
            }
        }
        return null;
    }
}
